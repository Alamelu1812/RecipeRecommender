package recipe.services.marshalling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import recipe.exception.MarshalUnmarshalException;

public class JsonMarshaller<T> implements Marshaller<T> {

	private ObjectMapper objectMapper;

	private static Logger LOGGER = LoggerFactory.getLogger(JsonMarshaller.class);

	public JsonMarshaller() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		//Add custom serializers here:
		
	}

	public String marshal(T input) {
		try {
			return objectMapper.writeValueAsString(input);
		} catch (JsonProcessingException exception) {
			LOGGER.error("Encountered exception {} while marshaling {}", exception, input);
			throw new MarshalUnmarshalException("Exception marshaling object: " + input, exception);
		}
	}
}
