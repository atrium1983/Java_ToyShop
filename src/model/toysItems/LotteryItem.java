package model.toysItems;

public interface LotteryItem {
    int getToyId();
    String getToyName();
    int getFrequency();
    void setFrequency(int frequency);
    String getInfo();
}
