import javax.swing.*;
import java.util.Objects;

public class Upgrades {
    int upgradeIndex = 0;
    int clickValue;
    int upgradeCost = 10;
    int difficulty = 15;
    String text1;
    String text2;
    ImageIcon image = new ImageIcon();

    Upgrades(){
        upgradeManger();
    }
    public void setUpgradeIndex(int upgradeIndex){
        this.upgradeIndex = upgradeIndex;
    }
    public int getUpgradeIndex(){
        return upgradeIndex;
    }
    public void setClickValue(int clickValue){
        this.clickValue = clickValue;
    }
    public int getClickValue(){
        return clickValue;
    }
    public void setUpgradeCost(int upgradeCost){
        this.upgradeCost = upgradeCost;
    }
    public int getUpgradeCost(){
        return upgradeCost;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }
    public ImageIcon getImage(){
        return image;
    }
    public void setText1(String text1){
        this.text1 = text1;
    }
    public String getText1(){
        return text1;
    }
    public void setText2(String text2){
        this.text2 = text2;
    }
    public String getText2(){
        return text2;
    }

    public void upgradeManger(){
        if(upgradeIndex == 0){
            setClickValue(1);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("smile.png")));
            setImage(image);
            setText1("Eggman");
            setText2(upgradeCost + " social credits");
        }
        if(upgradeIndex == 1){
            setClickValue(5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("eggman.png")));
            setImage(image);
            setText1("Yin Di Zhel");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 2){
            setClickValue(10);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("diesel.png")));
            setImage(image);
            setText1("Yuan-i Dieph");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 3){
            setClickValue(25);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("depp.png")));
            setImage(image);
            setText1("Bhra Di Pitth");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 4){
            setClickValue(50);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("pitt.png")));
            setImage(image);
            setText1("The Wok");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 5){
            setClickValue(75);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("wok.png")));
            setImage(image);
            setText1("Zhong Xina");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 6){
            setClickValue(100);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("xina.png")));
            setImage(image);
            setText1("Zhig A Chad");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 7){
            setClickValue(150);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("gigachad.png")));
            setImage(image);
            setText1("All upgrades");
            setText2("unlocked");
        }
        setUpgradeIndex(upgradeIndex + 1);
    }
}
