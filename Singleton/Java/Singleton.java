import java.util.*;

/* 
 * 饿汉式Singleton模式
 *
 * @author Velconia
 */
public class Singleton {
	// Instance
	private static Singleton instance = new Singleton();

	// Constructor with empty arguments
	private Singleton() { }

	public static Singleton getInstance() {
		return Singleton.instance;
	}

	public static void main(String[] args) {
		// Hope we get the answer "true"
		System.out.println((Singleton.getInstance() != null) + "");
	}
}