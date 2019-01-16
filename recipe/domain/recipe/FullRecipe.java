package recipe.domain.recipe;

public class FullRecipe {

	private Recipe recipe;

	private String recipeMethod;

	private String imageUrl;

	private String videoUrl;

	public FullRecipe() {
	}

	public FullRecipe(Recipe recipe, String recipeMethod, String imageUrl, String videoUrl) {
		this.recipe = recipe;
		this.recipeMethod = recipeMethod;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getRecipeMethod() {
		return recipeMethod;
	}

	public void setRecipeMethod(String recipeMethod) {
		this.recipeMethod = recipeMethod;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((recipeMethod == null) ? 0 : recipeMethod.hashCode());
		result = prime * result + ((videoUrl == null) ? 0 : videoUrl.hashCode());
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
		if (!(obj instanceof FullRecipe)) {
			return false;
		}
		FullRecipe other = (FullRecipe) obj;
		if (imageUrl == null) {
			if (other.imageUrl != null) {
				return false;
			}
		} else if (!imageUrl.equals(other.imageUrl)) {
			return false;
		}
		if (recipe == null) {
			if (other.recipe != null) {
				return false;
			}
		} else if (!recipe.equals(other.recipe)) {
			return false;
		}
		if (recipeMethod == null) {
			if (other.recipeMethod != null) {
				return false;
			}
		} else if (!recipeMethod.equals(other.recipeMethod)) {
			return false;
		}
		if (videoUrl == null) {
			if (other.videoUrl != null) {
				return false;
			}
		} else if (!videoUrl.equals(other.videoUrl)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FullRecipe [recipe=").append(recipe).append(", recipeMethod=").append(recipeMethod)
				.append(", imageUrl=").append(imageUrl).append(", videoUrl=").append(videoUrl).append("]");
		return builder.toString();
	}
}
