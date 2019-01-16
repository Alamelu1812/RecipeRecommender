package recipe.services.marshalling;

public interface Marshaller<T> {

	String marshal(T input);
}
