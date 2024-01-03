import model.writer.FileHandler;
import view.ConsoleUI;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.generateToyList();
        consoleUI.start();
    }
//        int quantity =10;
//        List<Integer> array = new ArrayList<>();
//        double frequency_1 = 0.2;
//        double frequency_2 = 0.2;
//        double frequency_3 = 0.6;
//        int [] arrayId = {1,2,3};
//        array.addAll(getSimpleList(arrayId[0], frequency_1, quantity));
//        array.addAll(getSimpleList(arrayId[1], frequency_2, quantity));
//        array.addAll(getSimpleList(arrayId[2], frequency_3, quantity));
//
//        System.out.printf(array.toString());
//        Collections.shuffle(array);
//        System.out.println(array);
//    }
//
//    public static List<Integer> getSimpleList(int elem, double frequency, int quantity){
//        int length = (int)(frequency*quantity);
//        List<Integer> numArray = new ArrayList<>();
//        for (int i = 0; i<length; i++){
//            numArray.add(elem);
//        }
//        return numArray;
//    }
}
