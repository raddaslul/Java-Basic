class Animal2 { // 자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다.
                // 따라서 해당 코드는 엄밀히 말해 class Animal extends Object 라고 해야한다.
                // 하지만 자바에서 만들어지는 모든 클래스는 Object 클래스를 자동으로 상속받게끔 되어 있다.
    String name;

    void setName(String name) {
        this.name = name; // this는 this가 속해있는 클래스인 Animal2의 상속을 받은 클래스 Dog의 객체 dog를 지칭한다.
    }
}

class Dog extends Animal2 { // Dog 클래스에 name 이라는 객체변수와 setName 이라는 메소드를 만들지 않았지만
                            // Animal 클래스를 상속했기 때문에 그대로 사용이 가능하다.
                            // Dog는 Animal2에 포함되기 때문에 "개는 동물이다"라고 표현할 수 있다.
                            // 자바는 이러한 관계를 IS-A 관계라고 표현한다. 즉 "Dog is a Animal" 과 같이 말할 수 있다.
    void sleep() {
        System.out.println(this.name+" zzz"); // this는 this가 속해있는 클래스인 Dog의 객체 dog를 지칭한다.
    }
}


public class _05_1_Inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog(); // 그리고 자식 클래스의 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있다.
                             // 따라서 Animal2 dog = new Dog(); 와 같은 코딩이 가능하다. (Dog is a Animal)
                             // "개로 만든 객체는 동물 자료형이다." (O)
                             // 하지만 Dog객체를 Animal2 자료형으로 사용할 경우, Dog 클래스에만 있는 sleep 메소드를 사용할 수 없다.
                             // 이런 경우에는 Animal 클래스에 구현된 setName 메소드만 사용이 가능하다.
                             // 그리고 그 반대의 경우인 부모 클래스로 만들어진 객체를 자식 클래스의 자료형으로는 사용할 수 없다.
                             // Dog dog = new Animal();는 컴파일 오류를 낸다. 이 코드는 Animal is a Dog라는 의미다.
                             // "동물로 만든 객체는 개 자료형이다." (X)
        dog.setName("poppy");
        System.out.println(dog.name);  // poppy 출력
        dog.sleep();  // poppy zzz 출력
    }
}
