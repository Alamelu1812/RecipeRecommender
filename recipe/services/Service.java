package recipe.services;

public interface Service<Input, Output> {

	Output invoke(Input input);
}
