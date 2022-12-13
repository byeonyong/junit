package thejavatest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RepeatTest {

//  "반복 횟수"와 "반복 테스트 이름"을 설정 할 수 있음
    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10 ,name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo){
        System.out.println("test "+ repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions());
    }

//  "매번 다른 결과값"으로 테스트를 해보고 싶을 때 이렇게 사용, "반복테스트 이름"도 물론 설정 가능
    @DisplayName("스터디 만들기2")
    @ParameterizedTest(name = "{index}_{displayName} message={0}")
    @ValueSource(strings={"날씨가","많이","추워지고","있어요"})
//    @EmptySource // 인자값으로 empty을 추가로 넣어주게 됨
//    @NullSource // 인자값으로 null 값을 추가로 넣어주게 됨
//    @NullAndEmptySource // 위의 @EmptySource @NullSource를 합친 어노테이션
    void parameterizedTest(String message){
        System.out.println(message);
    }

    //  "매번 다른 결과값"으로 테스트를 해보고 싶을 때 이렇게 사용, "반복테스트 이름"도 물론 설정 가능
    @DisplayName("스터디 만들기3")
    @ParameterizedTest(name = "{index}_{displayName} message={0}")
    @ValueSource(ints = {10,20,40})
    void parameterizedTest3(@ConvertWith(StudyConverter.class) Study study){
        System.out.println(study.getLimit());
    }

    //  "매번 다른 결과값"으로 테스트를 해보고 싶을 때 이렇게 사용, "반복테스트 이름"도 물론 설정 가능
//    @DisplayName("스터디 만들기4")
//    @ParameterizedTest(name = "{index}_{displayName} message={0}")
//    @CsvSource({"10,'자바스터디'","20,'스프링'"})
//    void parameterizedTest4(ArgumentsAccessor argumentsAccessor){
//        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
//        System.out.println(study.getLimit()+" "+study.getName());
//    }

    @DisplayName("스터디 만들기4")
    @ParameterizedTest(name = "{index}_{displayName} message={0}")
    @CsvSource({"10,'자바스터디'","20,'스프링'"})
    void parameterizedTest4(@AggregateWith(StudyAggregator.class) Study study){
        System.out.println(study.getLimit()+" "+study.getName());
    }

//    하나의 argument 에만 적용 가능 SimpleArgumentConverter
        static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            assertEquals(Study.class,aClass,"can only convert Study");
            return new Study(Integer.parseInt(o.toString()));
        }
    }

//    제약조건이 있는데 static 메소드여야 하고, 가져오는 인자의 클래스는 public클래스여야함 (Study는 public으로 생성해서 가져올수 잇음)
        static class StudyAggregator implements ArgumentsAggregator{
            @Override
            public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
                return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
            }
        }

}
