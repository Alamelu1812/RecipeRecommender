package recipe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RecipeSuggestor {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("app.env"));
		System.out.println("breakpoint");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context/recipe/recipe-suggestor.xml");
		System.out.println("Found" + context.getBean(HelloProperties.class));
		System.out.println("Done");
		
	}
}
