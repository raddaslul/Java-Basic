interface Predator2{

    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }

    int LEG_COUNT = 4;

    static int speed() {
        return LEG_COUNT * 30;
    }
}

interface Barkable {
    void bark();
}

interface BarkablePredator extends Predator, Barkable { // BarkablePredator는 Predator의 getFood 메소드,
                                                        // Barkable의 bark 메소드를 그대로 사용할 수 있다.
                                                        // 인터페이스는 일반 클래스와는 달리 다중 상속이 가능하다.
}

class Animal9 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger3 extends Animal9 implements Predator2, Barkable { // interface를 여러개 사용할 때는 콤마를 이용한다.
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion3 extends Animal9 implements BarkablePredator { // 다중 상속한 인터페이스를 실행해도 같은 값이 출력된다.
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}


class ZooKeeper3 {
    void feed(Predator2 predator2) {
        System.out.println("feed "+predator2.getFood());
    }
}

class Bouncer1 {
    void barkAnimal(Animal9 animal9) {
        if (animal9 instanceof Tiger3) { // instanceof는 어떤 객체가 특정 클래스의 객체인지를 조사할 때 사용되는 자바의 내장 명령어이다.
                                         // animal9 instanceof Tiger3은 "animal9 객체는 Tiger3 클래스로 만들어진 객체인가?"를 묻는 조건문이다.
            System.out.println("어흥");
        } else if (animal9 instanceof Lion3) {
            System.out.println("으르렁");
        }
    }
}

class Bouncer2 {
    void barkAnimal(Barkable animal9) {  // Animal 대신 Barkable을 사용
        animal9.bark(); // bark 메소드를 호출
    }
}



public class _07_2_Polymorphism {
    public static void main(String[] args) {
        Tiger3 tiger3 = new Tiger3(); // tiger3은 Tiger클래스의 객체이면서 Animal 클래스의 객체이기도 하고
                                      // Barkable, Predator 인터페이스의 객체이기도 하다.
                                      // 하나의 객체가 여러개의 자료형 타입을 가지는 것을 다형성이라고 한다.
        Lion3 lion3 = new Lion3();

        Bouncer1 bouncer1= new Bouncer1();
        bouncer1.barkAnimal(tiger3);
        bouncer1.barkAnimal(lion3);

        Bouncer2 bouncer2= new Bouncer2();
        bouncer2.barkAnimal(tiger3);
        bouncer2.barkAnimal(lion3);
    }
}

