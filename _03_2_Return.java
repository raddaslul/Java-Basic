public class _03_2_Return {
    void sayNick(String nick) { // 입력값으로 문자열을 받고 리턴값은 없는 메소드
        if ("fool".equals(nick)) {
            return; // 리턴자료형이 void인 메소드의 경우,
                    // return 문을 이용하면 메소드 수행 시 특정 조건에 따라 메소드를 즉시 빠져나갈 수 있다.
        }
        System.out.println("나의 별명은 "+nick+" 입니다."); // 문자열을 출력하는 것과 리턴값이 있다는 것은 전혀 다른 말이다.
    }

    public static void main(String[] args) {
        _03_2_Return method = new _03_2_Return();
        method.sayNick("angel");
        method.sayNick("fool");  // 출력되지 않는다.
    }
}
