// 饿汉式实现方法
#include <iostream>
#include <cstdlib>

using namespace std;

class Singleton {
	// 让且仅让这个函数能触及到Singleton，而且这个函数
	// 一般也由Singleton的作者实现
	friend Singleton* GetInstance();
private:
	explicit Singleton() 
	{
		cout << "Construct Singleton" << endl;
	}

	~Singleton() 
	{
		cout << "Destroy Singleton" << endl;
	}
};

// 使用全局方法的static变量，既能解决用户无法主动析构Singleton指针的问题
// 又能保证Singleton的实例在被调用前初始化, 参见<<Effective C++>>
extern Singleton* GetInstance() 
{
	static Singleton instance;
	return &instance;
}

int main() 
{
	cout << "Singleton's address: " << GetInstance() << endl;
	return EXIT_SUCCESS;
}