package recipe.domain.recipe.input;

import java.util.Date;
import java.util.List;

public class Recipe {

	private int recipeId;

	private List<String> directions;

	private int fat;

	private Date date;

	private List<String> categories;

	private int calories;

	private String desc;

	private int protien;

	private String title;

	private List<String> ingredients;

	private float rating;

	private int sodium;

	public List<String> getDirections() {
		return directions;
	}

	public void setDirections(List<String> directions) {
		this.directions = directions;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getProtien() {
		return protien;
	}

	public void setProtien(int protien) {
		this.protien = protien;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecipeName() {
		return title;
	}

	public void setRecipeName(String title) {
		this.title = title;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + fat;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + protien;
		result = prime * result + sodium;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (desc == null) {
			if (other.desc != null) {
				return false;
			}
		} else if (!desc.equals(other.desc)) {
			return false;
		}
		if (directions == null) {
			if (other.directions != null) {
				return false;
			}
		} else if (!directions.equals(other.directions)) {
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
		if (sodium != other.sodium) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe [directions=").append(directions).append(", fat=").append(fat).append(", date=")
				.append(date).append(", categories=").append(categories).append(", calories=").append(calories)
				.append(", desc=").append(desc).append(", protien=").append(protien).append(", title=").append(title)
				.append(", ingredients=").append(ingredients).append(", sodium=").append(sodium).append("]");
		return builder.toString();
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
}
