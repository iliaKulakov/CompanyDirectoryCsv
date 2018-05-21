package Scanner;

import storage.Person;

import java.io.IOException;
import java.util.List;

public interface IOutputCsvFile {

    void saveInfoInCsvFileOutput(Person person)throws IOException;

}
