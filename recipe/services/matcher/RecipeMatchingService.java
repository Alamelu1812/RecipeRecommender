package recipe.services.matcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Sets;

import recipe.services.Service;

public class RecipeMatchingService implements Service<Set<Integer>, List<Integer>> {

	private Map<Integer, Set<Integer>> ingredientToRecipeMap;

	public RecipeMatchingService(List<Pair<Integer, Integer>> ingredientRecipePairs) {
		ingredientToRecipeMap = new HashMap<>();
		for (Pair<Integer, Integer> ingredientRecipePair : ingredientRecipePairs) {
			if (!ingredientToRecipeMap.containsKey(ingredientRecipePair.getKey())) {
				Set<Integer> set = new HashSet<>();
				set.add(ingredientRecipePair.getValue());
				ingredientToRecipeMap.put(ingredientRecipePair.getKey(), set);
				
			}
			ingredientToRecipeMap.get(ingredientRecipePair.getKey()).add(ingredientRecipePair.getValue());
		}
	}

	// Max number of matched ingredients
	@Override
	public List<Integer> invoke(Set<Integer> selectedIngredients) {
		
		Map<Integer, Integer> recipeIngredientMatches = new HashMap<>();

		for (Integer selectedIngredient : selectedIngredients) {
			for (Integer recipe : ingredientToRecipeMap.get(selectedIngredient)) {
				if (!recipeIngredientMatches.containsKey(recipe)) {
					recipeIngredientMatches.put(recipe, 1);
				} else {
					recipeIngredientMatches.put(recipe, 1 + recipeIngredientMatches.get(recipe));
				}
			}
		}

		return recipeIngredientMatches.entrySet()
				.stream()
				.sorted((Entry<Integer, Integer> left, Entry<Integer, Integer> right) -> left.getValue().compareTo(right.getValue()))
				.map((Entry<Integer, Integer> entry) -> entry.getKey())
				.collect(Collectors.toList());
	}

}
