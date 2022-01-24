abstract class Predator3 extends Animal10{ // 추상 클래스는 인터페이스의 역할도 하면서 클래스의 기능도 가지고 있다.
                                           // 추상 클래스는 앞에 abstract를 표기해야한다.
                                           // Animal10 클래스의 기능을 유지하기 위해 Animal10 클래스를 상속한다.
    abstract String getFood(); // 인터페이스의 메소드와 같은 역할을 하는 메소드에도 abstract를 붙여야 한다.
                               // abstract 메소드는 인터페이스의 메소드와 마찬가지로 몸통이 없다.
                               // 즉 abstract 클래스를 상속하는 클래스에서 해당 abstract 메소드를 구현해야만 한다.

    void printFood() { // 인터페이스의 default 메소드는 더 이상 사용 불가는하므로 일반 메소드로 변경한다.
                       // 추상 클래스에서 abstract 메소드 외에 실제 메소드도 사용할 수 있다.
                       // 추상 클래스에 실제 메소드를 추가하면 Tiger4, Lion4에서 만들어진 객체에서 해당 메소드를 사용할 수 있다.
                       // 인터페이스의 default 메소드가 추상 클래스에서의 실제 메소드에 해당한다.
        System.out.printf("my food is %s\n", getFood());
    }

    static int LEG_COUNT = 4; // 인터페이스에서는 상수를 정의하면 자동으로 static을 인식하지만 추상 클래스는 static을 명시해줘야 한다.
    static int speed() {
        return LEG_COUNT * 30;
    }
}

interface Barkable2 {
    void bark();
}


class Animal10 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger4 extends Predator3 implements Barkable2 { // 추상 클래스는 단독으로 객체를 생성할 수 없다.
                                                      // 따라서 추상 클래스를 상속한 실제 클래스를 통해서만 객체를 생성해야 한다.
                                                      // Tiger4 클래스가 Predator3 추상 클래스를 상속하도록 변경한다.
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion4 extends Predator3 implements Barkable2 { // 추상 클래스는 단독으로 객체를 생성할 수 없다.
                                                     // 따라서 추상 클래스를 상속한 실제 클래스를 통해서만 객체를 생성해야 한다.
                                                     // Lion4 클래스가 Predator3 추상 클래스를 상속하도록 변경한다.
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}


class ZooKeeper4 {
    void feed(Predator3 predator3) {
        System.out.println("feed "+predator3.getFood());
    }
}


class Bouncer3 {
    void barkAnimal(Barkable2 animal10) {
        animal10.bark();
    }
}



public class _07_3_AbstractClass {
    public static void main(String[] args) {
        Tiger4 tiger4 = new Tiger4();
        Lion4 lion4 = new Lion4();

        Bouncer3 bouncer3= new Bouncer3();
        bouncer3.barkAnimal(tiger4);
        bouncer3.barkAnimal(lion4);
    }
}

