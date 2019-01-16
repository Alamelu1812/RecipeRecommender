package recipe.domain.result;

import recipe.domain.recipe.FullRecipe;

/**
 * Contains all data that needs to be rendered back to the front end for any recipe
 */
public class RecipeResult {

	private FullRecipe fullRecipe;

	private RecipeMarker recipeMarker;

	public RecipeResult() {
	}

	public RecipeResult(FullRecipe fullRecipe, RecipeMarker recipeMarker) {
		this.fullRecipe = fullRecipe;
		this.recipeMarker = recipeMarker;
	}

	public FullRecipe getFullRecipe() {
		return fullRecipe;
	}

	public void setFullRecipe(FullRecipe fullRecipe) {
		this.fullRecipe = fullRecipe;
	}

	public RecipeMarker getRecipeMarker() {
		return recipeMarker;
	}

	public void setRecipeMarker(RecipeMarker recipeMarker) {
		this.recipeMarker = recipeMarker;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullRecipe == null) ? 0 : fullRecipe.hashCode());
		result = prime * result + ((recipeMarker == null) ? 0 : recipeMarker.hashCode());
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
		if (!(obj instanceof RecipeResult)) {
			return false;
		}
		RecipeResult other = (RecipeResult) obj;
		if (fullRecipe == null) {
			if (other.fullRecipe != null) {
				return false;
			}
		} else if (!fullRecipe.equals(other.fullRecipe)) {
			return false;
		}
		if (recipeMarker != other.recipeMarker) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecipeResult [fullRecipe=").append(fullRecipe).append(", recipeMarker=").append(recipeMarker)
				.append("]");
		return builder.toString();
	}
}
