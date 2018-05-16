package storage;

import java.util.Date;

public class Person implements IPerson {

    private String FIO;
    private Date DateInfo;
    private Integer NumOfProjects;
    private Float Rate;
    private String Comments;

    //приватный конструктор
    private Person(){}

    public String getFIO() {
        return FIO;
    }

    public Date getDateInfo() {
        return DateInfo;
    }

    public Integer getNumOfProjects() {
        return NumOfProjects;
    }

    public Float getRate() {
        return Rate;
    }

    public String getComments() {
        return Comments;
    }

    //внутренний класс
   public class BuilderPerson{
        //приватный конструктор
        private BuilderPerson(){}

        public BuilderPerson setFIO(String FIO) {
        Person.this.FIO = FIO;
        return this;
        }
        public BuilderPerson setDateInfo(Date DateInfo) {
        Person.this.DateInfo = DateInfo;
        return this;
        }
        public BuilderPerson setNumOfProjects(Integer NumOfProjects) {
        Person.this.NumOfProjects = NumOfProjects;
        return this;
        }
        public BuilderPerson setRate(Float Rate) {
        Person.this.Rate = Rate;
        return this;
        }
        public BuilderPerson setComments(String Comments) {
        Person.this.Comments = Comments;
        return this;
        }
    }//BuilderPerson


    public Person build(){
        return Person.this;
    }

    //Создание экземпляра билдера
    public static BuilderPerson newBuilderPerson() {
        return new Person().new BuilderPerson();
    }



}
