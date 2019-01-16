package recipe.services.recipe.data;

import java.util.List;

import com.google.common.collect.Lists;

import recipe.domain.recipe.input.Recipe;
import recipe.services.Service;
import recipe.services.dao.mysql.RecipeMySqlDAO;

public class RecipeLookupService implements Service<String, List<Recipe>> {

	private RecipeMySqlDAO recipeDAO;

	private RecipeDataService recipeDataService;

	public RecipeLookupService(RecipeMySqlDAO recipeDAO, String recipeDataSetPath) {
		this.recipeDAO = recipeDAO;
		this.recipeDataService = new RecipeDataService(recipeDataSetPath);
	}

	@Override
	public List<Recipe> invoke(String recipeName) {
		List<Recipe> recipes = recipeDAO.fetchRecipesWithName(recipeName);
		List<Recipe> fullRecipes = Lists.newArrayList();
//		for (Recipe recipe : recipes) {
//			fullRecipes.add(recipeDataService.invoke(recipe.getTitle()));
//		}
		for (Recipe recipe : recipes) {
			Recipe fullRecipe = recipeDataService.invoke(recipe.getTitle());
			if (fullRecipe == null) {
				continue;
			}
			fullRecipe.setRecipeId(recipe.getRecipeId());
			fullRecipes.add(fullRecipe);
		}
		return fullRecipes;
	}

	public List<Recipe> fetchRecipesForIds(List<Integer> recipeIds) {
		List<Recipe> fullRecipes = Lists.newArrayList();
		for (int recipeId : recipeIds) {
			fullRecipes.add(recipeDataService.invoke(recipeDAO.fetchRecipesWithId(recipeId).getTitle()));
		}
		return fullRecipes;
	}

	public Recipe fetchRecipesForId(int recipeId) {
//		return recipeDataService.invoke(recipeName);
		return recipeDataService.invoke(recipeDAO.fetchRecipesWithId(recipeId).getTitle());
	}
}
