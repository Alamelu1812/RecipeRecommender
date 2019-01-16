package recipe.domain.recipe.input;

import java.util.List;

public class RecipeList {

	private List<Recipe> recipeList;

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recipeList == null) ? 0 : recipeList.hashCode());
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
		if (!(obj instanceof RecipeList)) {
			return false;
		}
		RecipeList other = (RecipeList) obj;
		if (recipeList == null) {
			if (other.recipeList != null) {
				return false;
			}
		} else if (!recipeList.equals(other.recipeList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeList [recipeList=").append(recipeList).append("]");
		return builder.toString();
	}
}
