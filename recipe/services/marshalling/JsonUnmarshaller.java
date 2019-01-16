package recipe.services.marshalling;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import recipe.exception.MarshalUnmarshalException;

public class JsonUnmarshaller<T> implements Unmarshaller<T> {

	private Class<T> clazz;

	private ObjectMapper objectMapper;

	public JsonUnmarshaller(Class<T> clazz) {
		this.clazz = clazz;
		this.objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
		//Add custom de-serializers here:
		
	}

	private static Logger LOGGER = LoggerFactory.getLogger(JsonMarshaller.class);

	public T unmarshal(String json) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException exception) {
			LOGGER.error("Encountered exception {} while unmarshaling {}", exception, json);
			throw new MarshalUnmarshalException("Exception unmarshaling json: " + json + " to class: " + clazz, exception);
		}
	}

}
