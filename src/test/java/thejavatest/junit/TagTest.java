package thejavatest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TagTest {

    @Test
    @DisplayName("스터디 만들기 (반함)") // 메소드에 이름 만들어 주는거
//    @Tag("fast") // 태그는 목적에 따라서 설명을 붙혀주는것. tag의 내용에 일치하는것만 테스트메소드 실행 할 수 있게 하기도 함
    void create_new_study(){
        System.out.println("tagTest 중입니다.");
    }

    @Test
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
