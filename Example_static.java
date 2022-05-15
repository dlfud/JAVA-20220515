package day09;

public class Example_static {
	static int a = 10; // 공유 목적이 아니어도 main 메서드가 static이기 때문에 억지로 static을 사용하게 됨. -> 객체지향에 어긋남
	
	
	// main 메서드는 무조건 static.
	// 핵심로직은 main에서 구현하지 않는다.
	// 보통 핵심 로직은 분리한다.
	public static void main(String[] args) {
		
		System.out.println(a);
		
		Test t1 = new Test();
		Test t2 = new Test();
		
		t1.num = 100;
		
		System.out.println(t1.num);
		System.out.println(t2.num);
		
		t2.num = 200;
		
		System.out.println(t2.num);
		
		
		System.out.println(t1.num2);
		System.out.println(t2.num2);
		
		t1.num2 = 50;
		
		System.out.println(t2.num2);
	
		
		// age, name이 static 변수이면 세사람이 나이와 이름을 공유하게 됨.
		Person p1 = new Person();
		p1.age = 20;
		p1.name ="홍길동";
		Person p2 = new Person();
		p2.age = 30;
		p2.name ="이순신";
		Person p3 = new Person();
		p3.age = 40;
		p3.name ="강감찬";
		
		System.out.println(p3.age);
		System.out.println(p1.age);
		
	}

}

// 일반적으로 class는 static을 사용하지 않는다.
// static은 non-static을 참조 할 수 없다. (메모리 로드 시점이 일치 하지 않음.)
class Test {
	
	int num = 10; // 인스턴스(객체)변수 -> 여러 복사본들이 들고있는 변수. 
	static int num2 = 20; // 정적변수 -> 자바 메모리상에 단 하나만 존재. 객체들의 공유 자원
	
}


class Person {
	static int age; // 인스턴스 변수
	static String name; // 인스턴스 변수
	
	public static void introduce() {
		System.out.println(age);
		System.out.println(name);
		System.out.println("=====================");
	}
	
	public void introduce2() {
		System.out.println(age);
		System.out.println(name);
		System.out.println("=====================");
	}
	
	
}