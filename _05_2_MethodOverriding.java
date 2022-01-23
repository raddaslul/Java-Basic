class Animal3 {
    String name;

    void setName(String name) {
        this.name = name; // this는 this가 속해있는 클래스 Animal3의 상속을 받은 클래스 Dog2의 상속을 받은
                          // 클래스 HouseDog의 객체인 houseDog를 지칭한다.
    }
}

class Dog2 extends Animal3 {
    void sleep() {
        System.out.println(this.name+" zzz"); // this는 this가 속해있는 클래스 Dog2의 상속을 받은
                                              // 클래스 HoeseDog의 객체 houseDog를 지칭한다.
    }
}

class HouseDog extends Dog2 {
    void sleep() {
        System.out.println(this.name + " zzz in house"); // this는 this가 속해있는 클래스 HouseDog의 객체 houseDog를 지칭한다.
    }
}

public class _05_2_MethodOverriding {
    public static void main(String[] args) {
        HouseDog houseDog = new HouseDog();
        houseDog.setName("happy");
        houseDog.sleep();  // HouseDog 클래스에 Dog 클래스와 동일한 형태(입출력이 동일)의 sleep 메소드를 구현하면
                           // HouseDog 클래스의 sleep 메소드가 Dog 클래스의 sleep 메소드보다 더 높은 우선순위를 갖게 되어
                           // HouseDog 클래스의 sleep 메소드가 호출되게 된다.
                           // 이렇게 부모클래스의 메소드를 자식클래스가 동일한 형태로 또다시 구현하는 행위를
                           // 메소드 오버라이딩(Method Overriding)이라고 한다. (※ 메소드 덮어쓰기)
    }
}
