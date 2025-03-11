package java_test002;

//1. 바뀌면 안되게 설정 final(하지마) 클래스(상속받지마) 멤버변수(수정못햐!: 상수) 멤버함수(오버라이딩하지마)
//2. 멤버변수 초기화 : 기본값 '\u0000' , null - 명시적 초기화 - 초기화 블록 - 생성자
class User004 {
    final char division; // 변경 불가능한 필드
    final String jumin;  // 변경 불가능한 필드

    // 생성자
    public User004(char division, String jumin) {
        this.division = division;
        this.jumin = jumin;
    }

    // 기본 생성자 (기본값 설정)
    public User004() {
        this.division = 'A';  // 기본값 A
        this.jumin = "123456-1234567";  // 기본값 설정
    }

    // division과 jumin 값을 가져올 수 있도록 getter 메서드 추가
    public char getDivision() {
        return division;
    }

    public String getJumin() {
        return jumin;
    }

    // 객체 정보 출력 포맷 지정
    @Override
    public String toString() {
        return "User004 [division=" + division + ", jumin=" + jumin + "]";
    }
}

public class Test004 {
    public static void main(String[] args) {
        // 객체 생성
        User004 c1 = new User004('B', "200101-1234567");
        User004 c2 = new User004(); // 기본 생성자 사용

        // 출력
        System.out.println(c1);
        System.out.println(c2);
    }
}