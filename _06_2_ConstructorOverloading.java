class Animal6 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog5 extends Animal6 {
    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog4 extends Dog5 {
    HouseDog4(String name) { // String 자료형을 입력으로 받는 생성자
        this.setName(name);
    }

    HouseDog4(int type) { // int 자료형을 입력으로 받는 생성자
        if (type == 1) {
            this.setName("yorkshire");
        } else if (type == 2) {
            this.setName("bulldog");
        }
    }

    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) {
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }
}


public class _06_2_ConstructorOverloading {
    public static void main(String[] args) {
        HouseDog4 happy = new HouseDog4("happy");
        HouseDog4 yorkshire = new HouseDog4(1);
        System.out.println(happy.name);  // happy 출력
        System.out.println(yorkshire.name);  // yorkshire 출력
                                             // 입력 항목이 다른 생성자를 여러 개 만들 수 있는데
                                             // 이를 생성자 오버로딩(Overloading) 이라고 한다.
    }
}
