package model.writer;

import java.io.*;


public class FileHandler implements Writable{

    public boolean save(Serializable serializable, String filePath) throws MyException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            throw new MyException("Ошибка в процессе записи в файл");
        }
    }

    public Object read(String filePath) throws MyException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new MyException("Ошибка в процессе чтения из файла");
        }
    }
}
