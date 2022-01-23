class Animal4 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Dog3 extends Animal4 {
    void sleep() {
        System.out.println(this.name + " zzz");
    }
}

class HouseDog2 extends Dog3 {
    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    void sleep(int hour) { // 이미 sleep이라는 메소드가 있지만 동일한 이름의 sleep메소드를 또 생성할 수 있다.
                           // 단, 메소드의 입력항목이 다를 경우만 가능하다.
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }
}



public class _05_3_MethodOverloading {
    public static void main(String[] args) {
        HouseDog2 houseDog = new HouseDog2();
        houseDog.setName("happy");
        houseDog.sleep();  // happy zzz in house 출력
        houseDog.sleep(3);  // happy zzz in house for 3 hours 출력
                                 // 이렇듯 입력항목이 다른 경우 동일한 이름의 메소드를 만들 수 있는데
                                 // 이를 메소드 오버로딩(method overloading)이라고 부른다.
    }
}
