package thejavatest.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// PER_CLASS를 사용해주면 한 클래스 내에서 Instance를 공유(성능적인 부분 향상 효과도 있음), TestInstance를 사용하지 않았을때는 instance가 각 @Test가 실행될때마다 같이 실행됨.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Test를 순차적으로 실행시키고 싶을때 사용, 기본적으로 @Test는 규칙이 있지만 순서를 어떻게 정하는지는 모르기때문
public class InstancTestAndOrder {

    int value = 1;

    @Test
    @DisplayName("스터디 만들기 (반함)")
    @Order(2)
    void create_new_study(){
        System.out.println("TestInstance TEST 중입니다. order 2 "+value++);
    }

    @Test
    @Order(1) // 값이 낮을수록 높은 우선순위를 가짐
    void create_new_study_again(){
        System.out.println("TestInstance TEST 중입니다. order 1 "+value++);
    }

    //  TestInstance를 사용할때는 static 붙이지 않아도 됨
    @BeforeAll
    void beforeAll(){
        System.out.println("before all");
    }

    //  TestInstance를 사용할때는 static 붙이지 않아도 됨
    @AfterAll
    void afterAll(){
        System.out.println("after all");
    }

}
