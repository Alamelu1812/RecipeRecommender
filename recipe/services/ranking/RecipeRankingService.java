package recipe.services.ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import com.google.api.client.util.Maps;

import recipe.services.Service;

public class RecipeRankingService implements Service<Pair<String, List<Integer>>, Map<Integer, Integer>> {

	private static final Map<String, Map<Integer, Integer>> userRecipeRankingMap = Maps.newHashMap();

	@Override
	public Map<Integer, Integer> invoke(Pair<String, List<Integer>> userIdLikes) {
		if (userRecipeRankingMap.containsKey(userIdLikes.getKey())) {
			return userRecipeRankingMap.get(userIdLikes.getKey());
		}

		List<Integer> rankedRecipes = getRankedRecipesForUser(userIdLikes.getLeft());
		Map<Integer, Integer> recipeRankMap = new HashMap<>();
		int rank = 1;

		for (int recipeId : rankedRecipes) {
			recipeRankMap.put(recipeId, rank++);
		}
		userRecipeRankingMap.put(userIdLikes.getKey(), recipeRankMap);
		return recipeRankMap;
	}

	// Query ML Model and get list of ranked recipes
	private List<Integer> getRankedRecipesForUser(String userId) {
		
		return new ArrayList<>();
	}
}
