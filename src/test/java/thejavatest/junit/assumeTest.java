package thejavatest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class assumeTest {

    @Test
    @DisplayName("스터디 만들기 (반함)") // 메소드에 이름 만들어 주는거
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre({JRE.JAVA_11})
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV",matches = "BY") TEST_ENV 라는 환경변수의 값이 BY일 경우에 실행을 시켜라는 것
    void create_new_study(){
//        assumeTrue();
        String test = System.getenv("TEST_ENV");
        System.out.println(test);
    }

    @Test
    @DisabledOnJre(JRE.OTHER) // java 11버전 아니면 disable
    @DisabledOnOs({OS.WINDOWS,OS.MAC}) // 여러개 써줄때는 {} 사용해서 묶어줄 수 있음
    void create_new_study_again(){
        System.out.println("create1");
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
