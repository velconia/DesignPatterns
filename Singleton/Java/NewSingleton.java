import java.util.*;

/* 
 * 新式Singleton模式, 将Singleton模式的逻辑封装在SingletonHolder类中
 * 这样NewSingleton类就能保证只实现自己的内部逻辑，而不用关心Singleton模式相关的部分
 * 而这个版本使用了饱汉式的方法实现，在这里也可以很容易的实现饿汉，
 * 只要在SingletonHolder就可以了，因为相关的逻辑几乎都封装在SingletonHolder类里了
 * 
 * @author Velconia
 */
public class NewSingleton {

	// Constructor with empty arguments
	private NewSingleton() { }

	private static class SingletonHolder {
		private static NewSingleton instance = new NewSingleton();

		private SingletonHolder() { }

		private static void prepare() { 
			// 在返回instance之前做的准备，比如计算当前实例的数量等，这样可以控制实例化的数量
		}

		private static NewSingleton getInstance() {
			prepare();
			return SingletonHolder.instance;
		}
	}

	public static NewSingleton getInstance() {
		return SingletonHolder.getInstance();
	}

	public static void main(String[] args) {
		// Hope we get the answer "true"
		System.out.println((NewSingleton.getInstance() != null) + "");
	}
}