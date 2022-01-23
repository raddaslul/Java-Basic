class Animal { // 클래스는 일종의 빵 틀
    String name; // 클래스에 선언된 변수 : 객체변수(인스턴스 변수, 멤버 변수, 속성)

    public void setName(String name){ // 메소드는 클래스 내에 구현된 함수인데 함수라고 안하고 그냥 메소드라고 한다.
                                      // 입력값으로 name이라는 문자열, 리턴값은 없음
        this.name = name; //this는 Animal 클래스에 의해 생성된 객체를 지칭
    }
}

public class _02_Class {
    public static void main(String[] args){
        Animal cat = new Animal(); // cat 객체를 생성 (cat은 Animal의 인스턴스)
                                   // 객체는 빵틀에 의해 만들어진 빵
        cat.setName("boby"); // 객체가 메소드를 호출하는 방법 : 객체.메소드
                             // 해당 코드가 해석되는 순서
                             // : setName의 입력값 name에는 "boby"라는 문자열이 전달 -> this.name = "boby";
                             // -> this는 Animal 클래스의 객체를 지칭하기 때문에 -> cat.name = "boby";
        System.out.println(cat.name); // 객체가 객체변수를 호출하는 방법 : 객체.객체변수

        Animal dog = new Animal();
        dog.setName("happy"); // = dog.name = "happy";
        System.out.println(dog.name); // dog 객체를 추가해도 cat 객체와 독립적으로 유지되어 "happy"가 출력됨
    }
}
