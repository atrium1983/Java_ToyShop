package model.writer;

import java.io.FileNotFoundException;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath) throws MyException;
    Object read(String filePath) throws FileNotFoundException, MyException;
}
