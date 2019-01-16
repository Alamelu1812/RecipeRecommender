package recipe.services.recommender;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import recipe.services.Service;
import recipe.services.dao.mysql.RecipeMySqlDAO;
import recipe.services.matcher.RecipeMatchingService;
import recipe.services.ranking.RecipeRankingService;

@Component
public class RecipeRecommender implements Service<Pair<String, Set<Integer>>, List<Integer>> {

	private RecipeMatchingService matchingService;

	private RecipeRankingService rankingService;

	@Resource
	private RecipeMySqlDAO recipeDAO;

	private static final int THRESHOLD = 30;

	public RecipeRecommender() {
		rankingService = new RecipeRankingService();
//		this.recipeDAO = recipeDAO;
	}

	@Override
	public List<Integer> invoke(Pair<String, Set<Integer>> userIdIngredientNamesPair) {
		Set<Integer> selectedIngredients = userIdIngredientNamesPair.getRight();
		List<Integer> matchedRecipes = matchingService.invoke(selectedIngredients);
//		rankingService.invoke(ImmutablePair.<String, List<Integer>>of(userIdIngredientNamesPair.getLeft(), recipeDAO.getUserLikedRecipeIds(userIdIngredientNamesPair.getLeft())));
		
		List<Integer> result = new ArrayList<>();
		if (matchedRecipes.size() <= THRESHOLD) {
			return matchedRecipes;
		}
		
		for (int i = 0; i < THRESHOLD; i++) {
			result.add(matchedRecipes.get(i));
		}
		return result;
	}

	@PostConstruct
	public void afterPropertiesSet() {
		matchingService = new RecipeMatchingService(recipeDAO.fetchIngredientRecipe());
	}
}
