// 饿汉式实现方法
// 巧妙的使用了智能指针保证指针在作用域结束后能够自动删除
// 也可以使用模板实单例模式的逻辑封装在Singleton模板中
// 使用外部线程类保证Singleton是线程安全的
// 但这里没做实现，可以参考ref.txt的第二个C++文档链接
#include <iostream>
#include <cstdlib>
#include <memory>

using namespace std;

class Singleton {
	friend class auto_ptr<Singleton>;

private:
	explicit Singleton() 
	{
		cout << "Construct Singleton" << endl;
	}

	~Singleton() 
	{
		cout << "Destroy Singleton" << endl;
	}

	static auto_ptr<Singleton> instance;

public:
	static auto_ptr<Singleton> get_instance();
};

auto_ptr<Singleton> Singleton::instance;

Singleton* Singleton::get_instance() 
{
	if (instance.get() == 0) instance.reset(new Singleton());
	return instance.get();
}

int main() 
{
	cout << "Singleton's address: " << Singleton::get_instance().get() << endl;
	return EXIT_SUCCESS;
}