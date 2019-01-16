package recipe.services.bill;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.protobuf.ByteString;

import recipe.services.Service;
import recipe.services.dao.mysql.RecipeMySqlDAO;
import recipe.services.lookup.InventoryLookup;
import recipe.services.ocr.OCRService;

@Component
public class BillUploadService implements Service<Pair<String, ByteString>, Boolean> {

	@Resource
	private OCRService ocrService;

	@Resource
	private InventoryLookup inventoryLookup;

	@Resource
	private RecipeMySqlDAO recipeDAO;

	@Override
	public Boolean invoke(Pair<String, ByteString> userImageBytes) {
		Set<String> identifiedTokens = ocrService.invoke(userImageBytes.getRight());
		Set<String> ingredients = inventoryLookup.getInventoryNames(identifiedTokens);

		if (CollectionUtils.isEmpty(ingredients)) {
			return false;
		}
		
		recipeDAO.storeInventory(ingredients, userImageBytes.getLeft());
		return true;
	}
}
