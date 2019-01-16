package recipe.services.recipe.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import recipe.domain.recipe.input.Recipe;
import recipe.exception.DataAccessException;
import recipe.services.Service;
import recipe.services.marshalling.JsonUnmarshaller;

public class RecipeDataService implements Service<String, Recipe> {

	private Map<String, Recipe> recipeMap;

	public RecipeDataService(String filePath) {
		String json;
		try {
			json = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataAccessException("Failed to load full recipe dataset", e);
		}
		JsonUnmarshaller<Recipe[]> unmarshaller = new JsonUnmarshaller<Recipe[]>(Recipe[].class);
		Recipe[] recipeList = unmarshaller.unmarshal(json);
		recipeMap = new HashMap<>();
		for (Recipe recipe : recipeList) {
			recipeMap.put(recipe.getTitle(), recipe);
		}
		System.out.println("Successfully loaded full-recipe dataset");
	}

	@Override
	public Recipe invoke(String recipeName) {
		return recipeMap.get(recipeName);
	}
}
