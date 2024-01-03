package model;

public class Toy {
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

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(toyId);
        info.append("| Название игрушки: ");
        info.append(toyName);
        info.append("| Частота выпадения: ");
        info.append(frequency);

        return info.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
