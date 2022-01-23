class Animal7 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger1 extends Animal7 {
}

class Lion1 extends Animal7 {
}

class ZooKeeper1 {
    void feed(Tiger1 tiger1) {  // 호랑이가 오면 사과를 던져주는 메소드
        System.out.println("feed apple");
    }

    void feed(Lion1 lion1) {  // 사자가 오면 바나나를 던져주는 메소드
                            // 이 같은 경우도 입력값의 자료형 타입(클래스 Tiger와 클래스 Lion의 객체)이 다른 경우다.
                            // 따라서, 메소드 오버로딩(Method overloading)이 가능하다.
                            // 하지만 동물이 추가될 때마다 feed 메소드를 추가해야만 하는 번거로움이 생긴다.
                            // 이를 해결해 주는 것이 Interface다.
        System.out.println("feed banana");
    }
}


interface Predator{ // 중요 클래스를 작성한다면 클래스의 구현체와 상관없이 인터페이스를 기준으로 중요 클래스를 작성해야만 한다.
                    // 구현체는 늘어날수 있지만 인터페이스는 하나이기 때문이다.
                    // 중요 클래스 : ZooKeeper2, 구현체 : Tiger2, Lion2, ...., 인터페이스 : Predator
                    // 즉, ZooKeeper2 클래스가 동물들의 종류에 의존적인 클래스에서
                    // 동물들의 종류와 상관없는 독립적인 클래스가 되었다는 점이 인터페이스의 핵심이다.

    String getFood(); // 인터페이스의 메소드는 메소드의 이름과 입출력에 대한 정의만 있고 그 내용은 없다.
                      // getFood라는 메소드는 인터페이스를 implements한 클래스들이 구현해야만 하는 것이다.
                      // 즉, interface는 메소드 상속과는 다르게 인터페이스의 메소드를 반드시 구현해야 하는 "강제성"을 갖는다
                      // 메소드 상속의 경우 부모 클래스의 메소드를 오버라이딩 하지 않고, 자식 클래스에 있는 다른 메소드를 사용할 수 있다.

    default void printFood() { // 디폴트 메서드는 메소드명 가장 앞에 "default" 라고 표기해야 한다.
                               // 인터페이스의 메서드는 몸통(구현체)을 가질 수 없지만
                               // 디폴트 메서드를 사용하면 실제 구현된 형태의 메서드를 가질 수 있다.
                               // 이렇게 Predator 인터페이스에 printFood 디폴트 메서드를 구현하면
                               // Predator 인터페이스를 구현한 Tiger, Lion 등의 실제 클래스는
                               // printFood 메서드를 구현하지 않아도 사용할 수 있다.
                               // 그리고 디폴트 메스드는 오버라이딩이 가능하다.
                               // 즉, printFood 메서드를 실제 클래스에서 다르게 구현하여 사용할수 있다.
        System.out.printf("my food is %s\n", getFood());
    }

    int LEG_COUNT = 4;  // 인터페이스 상수
    // 인터페이스에 정의한 상수는 public static final을 생략해도 자동으로 public static final이 적용된다.
    // 다른 형태의 상수 정의는 불가능하다.

    static int speed() {
        return LEG_COUNT * 30;
    }
}

class Animal8 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger2 extends Animal8 implements Predator { // interface 구현은 implements라는 키워드를 사용한다.
    public String getFood() { // 인터페이스의 메소드는 항상 public으로 구현해야 한다.
        return "apple";
    }
}

class Lion2 extends Animal8 implements Predator {
    public String getFood() { // 인터페이스의 메소드는 항상 public으로 구현해야 한다.
        return "banana";
    }
}

class ZooKeeper2 {
    void feed(Predator predator) { // feed 메소드를 Predator라는 인터페이스로 대체할 수 있다.
                                   // tiger2, lion2은 각각 Tiger2, Lion2의 객체이기도 하지만
                                   // Predator 인터페이스의 객체이기도 하기 때문에 Predator를 자료형의 타입으로 사용할 수 있다.
                                   // IS-A 관계가 인터페이스에도 적용되어 "Tiger is a Predator", "Lion is a Predator"가 성립
                                   // 이제 어떤 육식동물이 추가되더라도 ZooKeeper2는 feed 메소드를 추가할 필요가 없다.
                                   // 다만 육식동물이 추가 될 때마다 Predator 인터페이스를 구현한 클래스를 작성하기만 하면 된다.
        System.out.println("feed "+predator.getFood());
        // predator.getFood()를 호출하면 Predator 인터페이스를 구현한 구현체(Tiger, Lion)의 getFood() 메소드가 호출된다.
    }
}


public class _07_Interface {
    public static void main(String[] args) {
        ZooKeeper1 zooKeeper1 = new ZooKeeper1();
        Tiger1 tiger1 = new Tiger1();
        Lion1 lion1 = new Lion1();
        zooKeeper1.feed(tiger1);  // feed apple 출력
        zooKeeper1.feed(lion1);  // feed banana 출력

        ZooKeeper2 zooKeeper2 = new ZooKeeper2();
        Tiger2 tiger2 = new Tiger2();
        Lion2 lion2 = new Lion2();
        zooKeeper2.feed(tiger2);  // feed apple 출력
        zooKeeper2.feed(lion2);  // feed banana 출력
        Predator.speed();
    }
}
