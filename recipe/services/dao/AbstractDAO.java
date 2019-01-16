package recipe.services.dao;

public interface AbstractDAO<T> {

	int executeUpdate(T object);

	T executeQuery(String id);
}
