package thejavatest.junit;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CustumTagTest {

    @DisplayName("스터디 만들기 (반함)") // 메소드에 이름 만들어 주는거
    @FastTest // @Interface로 생성한 Custum TAG를 사용할수 있음 , TypeSafe 한 형식, @Tag("fast") 처럼 써줄때는 오타가 날 수도 있으니
    void create_new_study(){
        System.out.println("fast Test 중입니다.");
    }

    @DisplayName("스터디 만들기 again")
    @SlowTest
    void create_new_study_again(){
        System.out.println("slow test");
    }

    //  모든 테스트 하기전에 실행 (static 이어야 함 )
    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    //  모든 테스트 하고난 후 실행 (static 이어야 함 )
    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    //  모든 테스트 메소드 전에 실행
    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
    }

    //  모든 테스트 메소드 후에 실행
    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}
