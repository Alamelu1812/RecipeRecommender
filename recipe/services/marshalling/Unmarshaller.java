package recipe.services.marshalling;

public interface Unmarshaller<T> {

	T unmarshal(String input);
}
