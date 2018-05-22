package Scanner;

import service.ValidatonException;
import java.io.IOException;

public interface IReadCsvFile {

   void saveInfoFromBufferToBuilder () throws ValidatonException, IOException,StringIndexOutOfBoundsException;

}
