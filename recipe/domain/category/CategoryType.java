package recipe.domain.category;

public enum CategoryType {
	
	Utensil, Nutrient, Flavour, Occasion, Cusine, Dish, Season, Location, Diet;

	private int categoryTypeId;

	private CategoryType(int categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	//TODO: remove later
	CategoryType() {
		this.categoryTypeId = 0;
	}

	public int getCategoryTypeId() {
		return categoryTypeId;
	}

}
