class Animal5 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog4 extends Animal5 {
    Dog4(){ // 생성자의 입력 항목이 없고 생성자 내부에 아무 내용이 없는 생성자를 디폴트 생성자라고 부른다.
            // 디폴트 생성자를 구현하면 new Dog4()로 Dog4 클래스의 객체가 만들어 질 때 디폴트 생성자가 실행될 것이다.
            // 만약 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 디폴트 생성자를 추가한다.
            // 하지만 사용자가 작성한 생성자가 하나라도 구현되어 있다면 컴파일러는 디폴트 생성자를 추가하지 않는다.
            // 그렇기 때문에 HouseDog3 클래스에 name을 입력으로 받는 생성자를 만든 후에 new HouseDog3() 는 사용할 수 없다.
            // 왜냐하면 HouseDog3 클래스에 이미 생성자를 만들었기 때문에 컴파일러는 디폴트 생성자를 자동으로 추가하지 않기 때문이다.
    }

    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog3 extends Dog4 {
    HouseDog3(String name) { // 생성자는 클래스의 객체변수에 값을 무조건 설정해야만 객체가 생성될 수 있도록 강제시키는 방법이다.
                             // 생성자는 메소드명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메소드이다.
        this.setName(name);
    }

    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) {
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }
}

public class _06_1_Constructor {
    public static void main(String[] args) {
        HouseDog3 dog = new HouseDog3("happy"); // 생성자는 객체가 생성될 때, 즉, 생성자는 new 키워드가 사용될 때 호출된다.
                                                      // 생성자가 선언된 경우 생성자의 규칙대로만 객체를 생성할 수 있다.
                                                      // 따라서, 생성자 호출 시 문자열을 전달해야만 한다.
//      HouseDog3 dog = new HouseDog3(); // 이와 같이 코딩하면 컴파일 오류가 발생한다.
        System.out.println(dog.name);
    }
}
