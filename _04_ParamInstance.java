class Counter {
    int count = 0;  // 객체변수
}

class Updater1 {
    void update1(int count) { // 객체 myCounter의 객체변수 count의 값 0을 받아서
        count++; // 1을 증가시켜 1로 만들었지만 update1 메소드 내에서만 일어난 일이기 때문에
                 // main 메소드에까지 영향을 끼치지 못함함
    }
}

class Updater2 {
    void update2(Counter counter) { // 따라서 메소드의 입력으로 Counter 클래스의 객체를 받고
        counter.count++; // 객체 counter의 객체변수 count에 1을 더하면
    }
}

public class _04_ParamInstance {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);

        Updater1 myUpdater1 = new Updater1();
        myUpdater1.update1(myCounter.count); // 객체 myCounter의 객체변수 count를 입력값으로 주었지만
        System.out.println("after update1:"+myCounter.count); // update1 메소드가 main 메소드에 영향을 못줘서 0이 출력된다.

        Updater2 myUpdater2 = new Updater2();
        myUpdater2.update2(myCounter); // update2 메소드에 객체를 전달하면 해당 메소드는 전달받은 객체를 그대로 수행하여
                                       // 메소드가 객체의 속성값을 변경하면 메소드 수행 후에도 객체의 변경된 속성값이 유지된다.
        System.out.println("after update2:"+myCounter.count); // 따라서 1을 출력한다.
    }
}
