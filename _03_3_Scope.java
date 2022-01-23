public class _03_3_Scope {
    void varTest1(int a) { // 변수 a는 메소드 안에서만 쓰이는 변수이지 메소드 밖의 변수 a가 아니다.
                           // 따라서 메소드 내에서는 1이 증가되어 2가 되겠지만
                           // 그것이 main 메소드에 있는 변수 a를 2로 만드는 것이 아니다.
        a++;
    }

    int varTest2(int a) { // return문을 이용하면 1이 증가한 변수 a를 리턴하여 main 메소드의
                          // a = scope.varTest2(a);로 전달한다.
        a++;
        return a;
    }

    public static void main(String[] args) {
        int a = 1; // varTest 메소드 밖에서 선언된 변수 a (여기서 선언된 a는 지역변수(local variable)이다.)
        _03_3_Scope scope = new _03_3_Scope();
        scope.varTest1(a);
        System.out.println(a); // 2가 나와야 할 것 같지만 1이 출력된다.

        a = scope.varTest2(a); // varTest2에서 리턴한 변수 a(뒤에 있는 a)가 a(앞에 있는 a)에 대입된다.
        System.out.println(a);

        _03_3_Scope2 scope2 = new _03_3_Scope2(); // 아래 _03_3_Scope2의 객체 scope2 생성
        scope2.a = 1; // 객체 scope2의 객체변수 a는 1이라고 선언 (객체가 객체변수를 호출)
        scope2.varTest3(scope2); // varTest3 메소드에 변수 a의 값을 전달하던것을 _03_3_Scope2의 객체 scope2을 넘기도록 수정
                                 // varTest3 메소드의 입력값이 객체이기 때문에 변수가 아닌 객체를 입력해야 한다.
                                 // 메소드가 객체를 전달 받으면 메소드 내의 객체는 전달받은 객체 그 자체로 수행된다.
                                 // 따라서, 입력으로 전달받은 scope2 객체의 객체변수 a의 값이 증가하게 된다.
        System.out.println(scope2.a);

        _03_3_Scope3 scope3 = new _03_3_Scope3(); //하지만 위 경우는 _03_3_Scope3 클래스와 같이 간단히 표현 가능하다.
        scope3.a = 1; // 객체가 객체변수를 호출
        scope3.varTest4(); // 객체가 메소드를 호출
        System.out.println(scope3.a);  // 2 출력
    }
}

class _03_3_Scope2 {
    int a;  // 클래스의 객체변수 a

    void varTest3(_03_3_Scope2 scope2) { // 만약, 입력값이 기본형 데이터가 아닌 객체이고,
        scope2.a++; // 메소드가 객체의 객체변수 값을 변경한다면
        // 메소드 수행 이후에도 객체는 변경된 속성값을 유지한다.
    }
}

class _03_3_Scope3 { //하지만 scope3 객체를 이용하여 varTest4라는 메소드를 호출할 경우 굳이 scope3 객체를 전달할 필요가 없다.
    int a;  // 객체변수 a

    void varTest4() {
        this.a++; // 왜냐하면 전달하지 않더라도 varTest4 메소드는 this라는 키워드를 이용하여 객체에 접근할 수 있기 때문이다.
                  // this는 _03_3_Scope3에 의해 생성된 객체 scope3을 지칭
    }
}