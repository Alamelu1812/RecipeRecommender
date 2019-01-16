package recipe.domain.recipe;

import java.util.Set;
import recipe.domain.category.Category;
import recipe.domain.ingredient.Ingredient;

public class Recipe {

	private String recipeName;

	private int recipeId;

	private float recipeRating;

	private int calories;

	private int protien;

	private int fat;

	private int sodium;

	private Set<Category> categories;

	private Set<Ingredient> ingredients;

	public Recipe() {
	}

	public Recipe(String recipeName, int recipeId, float recipeRating, int calories, int protien, int fat, int sodium,
			Set<Category> categories, Set<Ingredient> ingredients) {
		this.recipeName = recipeName;
		this.recipeId = recipeId;
		this.recipeRating = recipeRating;
		this.calories = calories;
		this.protien = protien;
		this.fat = fat;
		this.sodium = sodium;
		this.categories = categories;
		this.ingredients = ingredients;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public float getRecipeRating() {
		return recipeRating;
	}

	public void setRecipeRating(float recipeRating) {
		this.recipeRating = recipeRating;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getProtien() {
		return protien;
	}

	public void setProtien(int protien) {
		this.protien = protien;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + fat;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + protien;
		result = prime * result + recipeId;
		result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
		result = prime * result + Float.floatToIntBits(recipeRating);
		result = prime * result + sodium;
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
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (calories != other.calories) {
			return false;
		}
		if (categories == null) {
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		if (fat != other.fat) {
			return false;
		}
		if (ingredients == null) {
			if (other.ingredients != null) {
				return false;
			}
		} else if (!ingredients.equals(other.ingredients)) {
			return false;
		}
		if (protien != other.protien) {
			return false;
		}
		if (recipeId != other.recipeId) {
			return false;
		}
		if (recipeName == null) {
			if (other.recipeName != null) {
				return false;
			}
		} else if (!recipeName.equals(other.recipeName)) {
			return false;
		}
		if (Float.floatToIntBits(recipeRating) != Float.floatToIntBits(other.recipeRating)) {
			return false;
		}
		if (sodium != other.sodium) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe [recipeName=").append(recipeName).append(", recipeId=").append(recipeId)
				.append(", recipeRating=").append(recipeRating).append(", calories=").append(calories)
				.append(", protien=").append(protien).append(", fat=").append(fat).append(", sodium=").append(sodium)
				.append(", categories=").append(categories).append(", ingredients=").append(ingredients).append("]");
		return builder.toString();
	}
}
