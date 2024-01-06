package model.toysItems;

import java.io.Serializable;

public class Toy implements Serializable, LotteryItem {
    public int toyId;
    public String toyName;
    public int frequency;

    public Toy (int toyId, String toyName, Integer frequency){
        this.toyId = toyId;
        this.toyName = toyName;
        this.frequency = frequency;
    }

    public int getToyId() {
        return toyId;
    }

    public String getToyName(){
        return toyName;
    }

    public int getFrequency(){
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(toyId);
        info.append("| ");
        info.append(toyName);
        info.append("| Частота: ");
        info.append(frequency);

        return info.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
