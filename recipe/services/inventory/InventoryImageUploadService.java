package recipe.services.inventory;

import java.util.List;

import com.google.cloud.ByteArray;

import recipe.domain.ingredient.Ingredient;
import recipe.services.Service;

// End to end service to accept image data, perform OCR and update contents
public class InventoryImageUploadService implements Service<ByteArray, List<Ingredient>> {

	@Override
	public List<Ingredient> invoke(ByteArray input) {
		// TODO Auto-generated method stub
		return null;
	}

}
