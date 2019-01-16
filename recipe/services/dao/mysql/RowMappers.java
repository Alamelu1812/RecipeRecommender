package recipe.services.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import recipe.domain.ingredient.Ingredient;
import recipe.domain.recipe.input.Recipe;
import recipe.domain.user.UserDetails;
import recipe.exception.DataAccessException;

public class RowMappers {

	static interface RowMapper<T> {
		T mapRow(ResultSet resultSet, int rowNum) throws SQLException;
	}

	public static <T> List<T> mapAllRows(ResultSet resultSet, RowMapper<T> rowMapper) {
		List<T> result = new ArrayList<>();
		int rowNum = 1;
		try {
			while(resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet, rowNum++));
			}
			resultSet.close();
		} catch (SQLException e) {
			throw new DataAccessException("Failed to process result ", e);
		}
		return result;
	}

	public static RowMapper<UserDetails> USER_DETAILS_MAPPER = new RowMapper<UserDetails>() {

		@Override
		public UserDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			UserDetails userDetails = new UserDetails();
			userDetails.setUserName(resultSet.getString("user_name"));
			return userDetails;
		}
	};

	public static RowMapper<String> USER_PASSWORD_MAPPER = new RowMapper<String>() {

		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			 return resultSet.getString("password");
		}
	};

	public static RowMapper<Ingredient> INGREDIENT_MAPPER = new RowMapper<Ingredient>() {

		@Override
		public Ingredient mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Ingredient(resultSet.getInt("ingredient_id"), resultSet.getString("ingredient_name"));
		}
	};

	public static RowMapper<Integer> RECIPE_ID_MAPPER = new RowMapper<Integer>() {

		@Override
		public Integer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return resultSet.getInt("recipe_id");
		}
	};

	public static RowMapper<Pair<Integer,Integer>> INGREDIENT_RECIPE_MAPPER = new RowMapper<Pair<Integer,Integer>>() {

		@Override
		public Pair<Integer, Integer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new ImmutablePair<Integer, Integer>(resultSet.getInt("ingredient_id"), resultSet.getInt("recipe_id"));
		}
	};
//	public static RowMapper<Pair<Integer,Integer>> INGREDIENT_RECIPE_MAPPER = (ResultSet resultSet, int rowNum) -> {
//		return new ImmutablePair<Integer, Integer>(resultSet.getInt("ingredient_id"), resultSet.getInt("recipe_id"));
//	};

	public static RowMapper<Recipe> RECIPE_ROW_MAPPER = new RowMapper<Recipe>() {

		@Override
		public Recipe mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Recipe recipe = new Recipe();
			recipe.setTitle(resultSet.getString("recipe_name"));
			recipe.setRecipeId(resultSet.getInt("recipe_id"));
			return recipe;
		}
	};

}
