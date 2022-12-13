package thejavatest.junit;

import lombok.Data;

public class Study {

    private final int limit;
    private String name;

    private final StudyStatus status = StudyStatus.DRAFT;

    public Study(int limit){

        if(limit < 0 ){
            throw new IllegalArgumentException();
        }
        this.limit = limit;
    }

    public Study(int limit, String name){
        this.limit = limit;
        this.name = name;
    }

    public StudyStatus getStatus(){
        return this.status;
    }

    public int getLimit(){
        return limit;
    }

    public String getName(){return name;}


}
