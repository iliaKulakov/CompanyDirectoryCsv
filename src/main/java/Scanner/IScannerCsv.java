package Scanner;
import java.io.FileNotFoundException;

public interface IScannerCsv {

    void toReadFromFile() throws FileNotFoundException;

    //другая реализация с сохранением
    void toReadFromFile2()throws FileNotFoundException;

}
