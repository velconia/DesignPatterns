import java.util.*;

/* 
 * 饱汉式Singleton模式
 *
 * @author Velconia
 */
public class Singleton2nd {
	// Instance
	private static Singleton2nd instance = null;

	// Constructor with empty arguments
	private Singleton2nd() { }

	public static synchronized Singleton2nd getInstance() {
		if (instance == null) instance = new Singleton2nd();
		return instance;
	}

	public static void main(String[] args) {
		// Hope we get the answer "true"
		System.out.println((Singleton2nd.getInstance() != null) + "");
	}
}