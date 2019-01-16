package recipe.services.dao.mysql;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.tuple.Pair;

import recipe.domain.ingredient.Ingredient;
import recipe.domain.recipe.FullRecipe;
import recipe.domain.recipe.input.Recipe;
import recipe.domain.user.UserDetails;

public class RecipeMySqlDAO extends MySqlDAO {
	
	public RecipeMySqlDAO(String host, String port, String database, String user, String password){
		super(host, port, database, user, password);
	}

	public boolean registerUser(UserDetails user) {
		return 0 < executeUpdate("INSERT INTO user (user_id, password, country, date_of_birth) VALUES (?,?,?,?)", user.getUserName(), getMD5Hash(user.getPassWord()), user.getCountry().name(), getDate(user.getDateOfBirth()));
	}

	public boolean checkUser(String userId, String password) {
		if (userId == null || password == null) {
			return false;
		}
		List<String> passwords = RowMappers.mapAllRows(executeQuery("SELECT password FROM user WHERE user_id=?", userId), RowMappers.USER_PASSWORD_MAPPER);
		return passwords != null && passwords.size() > 0 && getMD5Hash(password).equals(passwords.get(0));
	}

	public List<Ingredient> fetchUserInverntory(String userId) {
		return RowMappers.mapAllRows(executeQuery(
				"SELECT ingredient.ingredient_id, ingredient_name FROM user_ingredient_inventory INNER JOIN ingredient ON user_ingredient_inventory.ingredient_id = ingredient.ingredient_id WHERE user_id=? AND active_flag=1",
				userId), RowMappers.INGREDIENT_MAPPER);
	}

	public void removeUserInventory(String userId, List<Integer> ingredientIds) {
		for (Integer ingredientId : ingredientIds) {
			executeUpdate("UPDATE user_ingredient_inventory SET active_flag=0 WHERE user_id=? AND ingredient_id=? AND active_flag=1", userId, ingredientId);
		}
	}

	public void storeInventory(String userId, List<Integer> ingredientIds) {
		removeUserInventory(userId, ingredientIds);
		for (Integer ingredientId : ingredientIds) {
			executeUpdate("INSERT INTO user_ingredient_inventory(user_id,ingredient_id,active_flag) VALUES (?,?,1)", userId, ingredientId);
		}
	}

	public void storeInventory(Collection<String> ingredientNames, String userId) {
		List<Ingredient> ingredients = new ArrayList<>();
		for (String ingredientName : ingredientNames) {
			ingredients.add(RowMappers.mapAllRows(executeQuery("SELECT * FROM ingredient WHERE ingredient_name=?", ingredientName), RowMappers.INGREDIENT_MAPPER).get(0));
		}
		List<Integer> ingredientIds = new ArrayList<>();
		for (Ingredient ingredient : ingredients) {
			ingredientIds.add(ingredient.getIngredientId());
		}
		storeInventory(userId, ingredientIds);
	}

	public FullRecipe fetchRecipe(int recipeId) {
		return null;
	}

	public void updateUserRecipeLike(String userId, int recipeId, boolean like) {
		
	}

	public List<Pair<Integer, Integer>> fetchIngredientRecipe() {
		return RowMappers.mapAllRows(executeQuery("SELECT ingredient_id,recipe_id FROM recipe_ingredient"), RowMappers.INGREDIENT_RECIPE_MAPPER);
	}

	public Set<Ingredient> fetchIngredientsForNames(Set<String> ingredientNames) {
		Set<Ingredient> ingredients = new HashSet<>();
		for (String ingredientName : ingredientNames) {
			ingredients.add(RowMappers.mapAllRows(executeQuery("SELECT * FROM ingredient WHERE ingredient_name=?", ingredientName), RowMappers.INGREDIENT_MAPPER).get(0));
		}
		return ingredients;
	}

	public List<Recipe> fetchRecipesWithName(String recipeName) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM recipe WHERE recipe_name like '%" + recipeName + "%' AND recipe_id IS NOT NULL"), RowMappers.RECIPE_ROW_MAPPER);
	}

	public Recipe fetchRecipesWithId(int recipeId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM recipe WHERE recipe_id=?", recipeId), RowMappers.RECIPE_ROW_MAPPER).get(0);
	}

	public List<Integer> getUserLikedRecipeIds(String userId) {
		return RowMappers.mapAllRows(executeQuery("SELECT recipe_id FROM user_preference_history WHERE user_id=? AND liked=1", userId), RowMappers.RECIPE_ID_MAPPER);
	}

	private static String getMD5Hash(String password) {
		return DigestUtils.md5Hex(password).toUpperCase();
	}

	private static Date getDate(java.util.Date date) {
		return new Date(date.toInstant().toEpochMilli());
	}

}
