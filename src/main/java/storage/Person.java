package storage;

import java.util.Date;

public class Person implements IPerson {

    private String FIO;
    private Date birthDate;
    private Integer numOfProjects;
    private Float rate;
    private String comments;

    //приватный конструктор
    private Person() {
    }

    private Person(String FIO, Date birthDate, Integer numOfProjects, Float rate, String comments) {
        this.FIO = FIO;
        this.birthDate = birthDate;
        this.numOfProjects = numOfProjects;
        this.rate = rate;
        this.comments = comments;
    }

    //Создание экземпляра билдера
    public static BuilderPerson newBuilderPerson() {
        return new Person().new BuilderPerson();
    }

    public String getFIO() {
        return FIO;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Integer getNumOfProjects() {
        return numOfProjects;
    }

    public Float getRate() {
        return rate;
    }

    public String getComments() {
        return comments;
    }

    public Person build() {
        return Person.this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FIO='" + FIO + '\'' +
                ", birthDate=" + birthDate +
                ", numOfProjects=" + numOfProjects +
                ", rate=" + rate +
                ", comments='" + comments + '\'' +
                '}';
    }

    //внутренний класс
    public class BuilderPerson {
        //приватный конструктор
        private BuilderPerson() {
        }

        public BuilderPerson setFIO(String FIO) {
            Person.this.FIO = FIO;
            return this;
        }

        public BuilderPerson setBirthDate(Date birthDate) {
            Person.this.birthDate = birthDate;
            return this;
        }

        public BuilderPerson setNumOfProjects(Integer NumOfProjects) {
            Person.this.numOfProjects = NumOfProjects;
            return this;
        }

        public BuilderPerson setRate(Float Rate) {
            Person.this.rate = Rate;
            return this;
        }

        public BuilderPerson setComments(String Comments) {
            Person.this.comments = Comments;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }//BuilderPerson
}
