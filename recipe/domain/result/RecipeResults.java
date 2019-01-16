package recipe.domain.result;

import java.util.List;

import recipe.domain.recipe.FullRecipe;

/**
 * Contains all suggestion data that needs to be rendered to the front end
 */
public class RecipeResults {

	private String userId;

	private List<FullRecipe> recipes;

	public RecipeResults() {
	}

	public RecipeResults(String userId, List<FullRecipe> recipes) {
		this.userId = userId;
		this.recipes = recipes;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<FullRecipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<FullRecipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RecipeResults)) {
			return false;
		}
		RecipeResults other = (RecipeResults) obj;
		if (recipes == null) {
			if (other.recipes != null) {
				return false;
			}
		} else if (!recipes.equals(other.recipes)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeResults [userId=").append(userId).append(", recipes=").append(recipes).append("]");
		return builder.toString();
	}
}
