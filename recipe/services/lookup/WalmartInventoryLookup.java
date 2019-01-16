package recipe.services.lookup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

// Mock Walmart lookup service, since original lookup service is chargeable
@Component
public class WalmartInventoryLookup implements InventoryLookup {

	private Map<String, String> ingredientMap;

	public WalmartInventoryLookup() {
		ingredientMap = new HashMap<>();
		ingredientMap.put("eggs", "egg");
		ingredientMap.put("milk", "milk/cream");
		ingredientMap.put("bread", "flat bread");
		ingredientMap.put("potato", "potato");
		ingredientMap.put("potatoes", "potato");
		ingredientMap.put("onion", "onion");
		ingredientMap.put("onions", "onion");
		ingredientMap.put("tomato", "tomato");
		ingredientMap.put("tomatoes", "tomato");
		ingredientMap.put("yogurt", "yogurt");
		ingredientMap.put("caulif", "cauliflower");
	}

	@Override
	public Set<String> getInventoryNames(Set<String> inventoryTokens) {
		Set<String> ingredients = new HashSet<>();
		for (String inventoryToken : inventoryTokens) {
			if (ingredientMap.containsKey(inventoryToken.toLowerCase())) {
				ingredients.add(ingredientMap.get(inventoryToken.toLowerCase()));
			}
		}
		return ingredients;
	}
}
