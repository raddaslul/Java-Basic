public class _03_1_Method {
    int sum1(int a, int b) { // a와 b는 매개변수(parameter)
        return a+b;
    }

    String say1() {
        return "Hi";
    }

    void sum2(int a, int b) {
        System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
    }

    void say2() {
        System.out.println("Hi");
    }


    public static void main(String[] args) {
        _03_1_Method method = new _03_1_Method();
        int c = method.sum1(3, 4); // 3, 4는 인수(argument)
                                        // 입력값과 리턴값이 있는 메소드 사용방법
                                        // : 리턴값받을변수 = 객체.메소드명(입력인수1, 입력인수2, ...)
        System.out.println(c);  // 7 출력


        String a = method.say1(); // 입력값이 없고 리턴값만 있는 메소드 사용방법
                                 // : 리턴값받을변수 = 객체.메소드명()
        System.out.println(a);  // "Hi" 출력


        method.sum2(3, 4); // 입력값이 있고 리턴값이 없는 메소드 사용방법
                                 // : 객체.메소드명(입력인수1, 입력인수2, ...)


        method.say2(); // 입력값도 리턴값도 없는 메소드 사용방법
                       // 객체.메소드명()
    }
}
