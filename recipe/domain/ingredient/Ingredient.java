package recipe.domain.ingredient;

public class Ingredient {
	
	private int ingredientId;
	
	private String ingredientName;

	public Ingredient() {
	}

	public Ingredient(int ingredientId, String ingredientName) {
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
		result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
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
		if (!(obj instanceof Ingredient)) {
			return false;
		}
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId) {
			return false;
		}
		if (ingredientName == null) {
			if (other.ingredientName != null) {
				return false;
			}
		} else if (!ingredientName.equals(other.ingredientName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [ingredientId=").append(ingredientId).append(", ingredientName=")
				.append(ingredientName).append("]");
		return builder.toString();
	}
}
