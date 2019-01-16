package recipe.domain.result;

import java.util.List;

/**
 * This class models the results returned by the ML model
 */
public class UserRankedRecipes {

	private String userId;

	private List<Integer> rankedRecipes;

	public UserRankedRecipes() {
	}

	public UserRankedRecipes(String userId, List<Integer> rankedRecipes) {
		this.userId = userId;
		this.rankedRecipes = rankedRecipes;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Integer> getRankedRecipes() {
		return rankedRecipes;
	}

	public void setRankedRecipes(List<Integer> rankedRecipes) {
		this.rankedRecipes = rankedRecipes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRankedRecipes [userId=").append(userId).append(", rankedRecipes=").append(rankedRecipes)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rankedRecipes == null) ? 0 : rankedRecipes.hashCode());
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
		if (!(obj instanceof UserRankedRecipes)) {
			return false;
		}
		UserRankedRecipes other = (UserRankedRecipes) obj;
		if (rankedRecipes == null) {
			if (other.rankedRecipes != null) {
				return false;
			}
		} else if (!rankedRecipes.equals(other.rankedRecipes)) {
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
}
