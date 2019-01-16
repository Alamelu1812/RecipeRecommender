//package recipe.services.ocr;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.google.cloud.ByteArray;
//import com.google.cloud.vision.v1.AnnotateImageRequest;
//import com.google.cloud.vision.v1.AnnotateImageResponse;
//import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
//import com.google.cloud.vision.v1.Block;
//import com.google.cloud.vision.v1.Feature;
//import com.google.cloud.vision.v1.Feature.Type;
//import com.google.cloud.vision.v1.Image;
//import com.google.cloud.vision.v1.ImageAnnotatorClient;
//import com.google.cloud.vision.v1.ImageSource;
//import com.google.cloud.vision.v1.Page;
//import com.google.cloud.vision.v1.Paragraph;
//import com.google.cloud.vision.v1.Symbol;
//import com.google.cloud.vision.v1.TextAnnotation;
//import com.google.cloud.vision.v1.Word;
//
//public class OCRTrial {
//
//	public static void detectDocumentTextGcs(ByteArray byteArray) throws Exception,
//
//			IOException {
//
//		List<AnnotateImageRequest> requests = new ArrayList<>();
//		new com.google.api.services.vision.v1.model.Image().
//		Image image = Image.parser().parseFrom(byteArray.toByteArray());
//
////		ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
//
////		Image img = Image.newBuilder().setSource(imgSource).build();
//
//		ImageSource.parseDelimitedFrom(new FileInputStream(new File("C:\\Users\\burmi\\eclipse-workspace\\wallmart_bill.jpeg")));
//		ImageSource source = ImageSource.newBuilder().mergeFrom(byteArray.toByteArray()).build();
//		Image img = Image.newBuilder().setSource(source).build();
////		Image img = //Image.parseFrom(Files.readAllBytes(Paths.get(gcsPath)));
////		Image.parseFrom(new FileInputStream(new File(gcsPath)));
//
//		Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
//
//		AnnotateImageRequest request =
//
//				AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
//
//		requests.add(request);
//
//		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
//
//			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
//
//			List<AnnotateImageResponse> responses = response.getResponsesList();
//
//			client.close();
//
//			for (AnnotateImageResponse res : responses) {
//
//				if (res.hasError()) {
//
//					System.out.printf("Error: %s\n", res.getError().getMessage());
//
//					return;
//
//				}
//
//				// For full list of available annotations, see http://g.co/cloud/vision/docs
//
//				TextAnnotation annotation = res.getFullTextAnnotation();
//
//				for (Page page : annotation.getPagesList()) {
//
//					String pageText = "";
//
//					for (Block block : page.getBlocksList()) {
//
//						String blockText = "";
//
//						for (Paragraph para : block.getParagraphsList()) {
//
//							String paraText = "";
//
//							for (Word word : para.getWordsList()) {
//
//								String wordText = "";
//
//								for (Symbol symbol : word.getSymbolsList()) {
//
//									wordText = wordText + symbol.getText();
//
//								}
//
//								paraText = paraText + wordText;
//
//							}
//
//							// Output Example using Paragraph:
//
//							System.out.println("Paragraph: \n" + paraText);
//
//							System.out.println("Bounds: \n" + para.getBoundingBox() + "\n");
//
//							blockText = blockText + paraText;
//
//						}
//
//						pageText = pageText + blockText;
//
//					}
//
//				}
//
//				System.out.println(annotation.getText());
//
//			}
//
//		}
//
//	}
//
//	public static void main(String args[]) throws Exception {
//		Path fileLocation = Paths.get("C:\\Users\\burmi\\eclipse-workspace\\wallmart_bill.jpeg");
//		byte[] data = Files.readAllBytes(fileLocation);
//		
//		detectDocumentTextGcs(ByteArray.copyFrom(data));
////		detectDocumentTextGcs(Paths.get(OCRTrial.class.getResource("images\\wallmart_bill.jpeg").getPath()).toString());
//
//	}
//
//}