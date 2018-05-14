package storage;

public class PersonStorage {
    private String ID;
    private String FIO;
    private String Date;
    private String NumOfProjects;
    private String Rate;
    private String Comments;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getNumOfProjects() {
        return NumOfProjects;
    }

    public void setNumOfProjects(String numOfProjects) {
        NumOfProjects = numOfProjects;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    @Override
    public String toString() {
        return "PersonStorage{" +
                "ФИО='" + FIO + '\'' +
                ", Дата=" + Date +
                ", Количество проектов=" + NumOfProjects +
                ", Рейтинг=" + Rate +
                ", Комментарии='" + Comments + '\'' +
                '}';
    }
}
