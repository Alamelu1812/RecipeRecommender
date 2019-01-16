package recipe.services.lookup;

import java.util.Set;

public interface InventoryLookup {

	Set<String> getInventoryNames(Set<String> inventoryTokens);
}
