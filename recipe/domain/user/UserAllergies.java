package recipe.domain.user;

import java.util.Set;

import recipe.domain.ingredient.Ingredient;

public class UserAllergies {

	private String userId;

	private Set<Ingredient> allergicIngredients;

	public UserAllergies() {
	}

	public UserAllergies(String userId, Set<Ingredient> allergicIngredients) {
		this.userId = userId;
		this.allergicIngredients = allergicIngredients;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<Ingredient> getAllergicIngredients() {
		return allergicIngredients;
	}

	public void setAllergicIngredients(Set<Ingredient> allergicIngredients) {
		this.allergicIngredients = allergicIngredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergicIngredients == null) ? 0 : allergicIngredients.hashCode());
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
		if (!(obj instanceof UserAllergies)) {
			return false;
		}
		UserAllergies other = (UserAllergies) obj;
		if (allergicIngredients == null) {
			if (other.allergicIngredients != null) {
				return false;
			}
		} else if (!allergicIngredients.equals(other.allergicIngredients)) {
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
		builder.append("UserAllergies [userId=").append(userId).append(", allergicIngredients=")
				.append(allergicIngredients).append("]");
		return builder.toString();
	}

}
