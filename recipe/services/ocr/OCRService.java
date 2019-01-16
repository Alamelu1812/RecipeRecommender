package recipe.services.ocr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.protobuf.ByteString;

import recipe.services.Service;

@Component
public class OCRService implements Service<ByteString, Set<String>> {

	/**
	 * Takes in input in the form of ByteString and returns a JSON after performing
	 * OCR on the image
	 */
	public Set<String> invoke(ByteString imgBytes) {

		// Instantiates a client

		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

			// Builds the image annotation request
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
			requests.add(request);

			// Performs label detection on the image file
			BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			Set<String> result = new HashSet<>();

			for (AnnotateImageResponse res : responses) {
				TextAnnotation annotation = res.getFullTextAnnotation();

				for (String token : StringUtils.split(annotation.getText())) {
					result.add(token);
				}
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to parse uploaded image", e);
		}

	}

}
