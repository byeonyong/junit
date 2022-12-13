package thejavatest.junit;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

// displayName 클래스에도 쓸수있는데 이 클래스에 있는 메소드들에대한 이름 전시가능
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // properties 파일에서 테스트 파일 전체 UndertoSpace로 적용했기때문에
class assertTest {

    @Test
    @DisplayName("스터디 만들기 (반함)") // 메소드에 이름 만들어 주는거
    void create_new_study(){
        Study study = new Study(-15);
        IllegalArgumentException illegal = assertThrows(IllegalArgumentException.class,()-> new Study(-15));
        String message = illegal.getMessage();
        System.out.println("message : " + message);

        assertTimeout(Duration.ofMillis(100),()->{
            new Study(10);
            Thread.sleep(300);
        });

//        assertAll이 좋은점은 따로 쓰면 에러 난 지점부터 test코드가 끊기는데 assertAll 은 중간에 에러가 나더라도 끝까지 코드가 진행
        assertAll(
                ()-> assertNotNull(study),
                ()-> assertEquals(StudyStatus.DRAFT, study.getStatus(),()->"스터디를 처음 만들면 상태값이 DRAFT여야 한다"),
                ()->assertTrue(study.getLimit() > 0,()-> "limit 값이 0이상이어야함")
        );
//        assertNotNull(study);
//      (기대하는 값, 실제값, description)
//        description이 String일경우 항상 문자열연산을 하지만 람다식일경우 실패할 경우에만(기대값,실제값 불일치) 실행되기때문에 성능을 신경쓰면 Supplyer로 실행
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),"스터디를 처음 만들면 상태값이 DRAFT여야 한다");
//        assertEquals(StudyStatus.DRAFT, study.getStatus(),()->"스터디를 처음 만들면 상태값이 DRAFT여야 한다");
//        assertTrue(study.getLimit() > 0,()-> "limit 값이 0이상이어야함");
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