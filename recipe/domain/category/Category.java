package recipe.domain.category;

public class Category {
	
	private int categoryId;
	
	private String categoryName;
	
	private CategoryType categoryType;

	public Category() {
	}

	public Category(int categoryId, String categoryName, CategoryType categoryType) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((categoryType == null) ? 0 : categoryType.hashCode());
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
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		if (categoryId != other.categoryId) {
			return false;
		}
		if (categoryName == null) {
			if (other.categoryName != null) {
				return false;
			}
		} else if (!categoryName.equals(other.categoryName)) {
			return false;
		}
		if (categoryType != other.categoryType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [categoryId=").append(categoryId).append(", categoryName=").append(categoryName)
				.append(", categoryType=").append(categoryType).append("]");
		return builder.toString();
	}
}
