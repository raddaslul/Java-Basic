class Calculator {
    int result = 0;

    int add(int num){
        result += num;
        return result;
    }
}

//class Calculator2 { // 추가적인 계산기를 만들기 위해 클래스를 또 만들 필요가 없음
//    int result = 0;
//
//    int add(int num){
//        result += num;
//        return result;
//    }
//}


public class _01_ObjectOrientedProgram {
    public static void main(String[] args){
        Calculator cal1 = new Calculator(); // 계산기1 객체를 생성
        Calculator cal2 = new Calculator(); // 계산기2 객체를 생성
                                            // 각각의 객체는 다른 객체의 결과값과 상관없이 독립적인 값을 유지한다.
                                            // 이렇게 추가적인 클래스를 생성할 필요가 없이 다른 독립적인 객체를 생성만 해도 되는 것이
                                            // 객체지향 프로그램의 가장 큰 장점이다.

        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));

        System.out.println(cal2.add(3));
        System.out.println(cal2.add(7));

    }
}
