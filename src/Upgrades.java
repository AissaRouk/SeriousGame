package SeriousGame.src;

import javax.swing.*;

public class Upgrades {
    int upgradeIndex = 0;
    int clickValue;
    int upgradeCost = 10;
    String text1;
    String text2;
    ImageIcon image = new ImageIcon();

    Upgrades(){
        upgradeManger();
    };
    public void setUpgradeIndex(int upgradeIndex){
        this.upgradeIndex = upgradeIndex;
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
            ImageIcon image = new ImageIcon(Upgrades.class.getClassLoader().getResource("SeriousGame/resources/smile.png"));
            setImage(image);
            setText1("Eggman upgrade ara ara");
            setText2(upgradeCost + " social credits");
        }
        if(upgradeIndex == 1){
            setClickValue(5);
            ImageIcon image = new ImageIcon(Upgrades.class.getClassLoader().getResource("SeriousGame/resources/eggman.png"));
            setImage(image);
            setText1("The Wok upgrade uwu");
            setText2(upgradeCost * 5 + " social credits");
        }
        if(upgradeIndex == 2){
            setClickValue(10);
            ImageIcon image = new ImageIcon(Upgrades.class.getClassLoader().getResource("SeriousGame/resources/wok.png"));
            setImage(image);
            setText1("Zhong Xina upgrade owo");
            setText2(upgradeCost * 5 + " social credits");
        }
        if(upgradeIndex == 3){
            setClickValue(25);
            ImageIcon image = new ImageIcon(Upgrades.class.getClassLoader().getResource("SeriousGame/resources/xina.png"));
            setImage(image);
            setText1("Zhong Xina upgrade owo");
            setText2(upgradeCost * 5 + " social credits");
        }
        if(upgradeIndex == 4){
            setClickValue(50);
            ImageIcon image = new ImageIcon(Upgrades.class.getClassLoader().getResource("SeriousGame/resources/eggman.png"));
            setImage(image);
            setText1("Zhong Xina upgrade owo");
            setText2(upgradeCost * 5 + " social credits");
        }
        setUpgradeIndex(upgradeIndex + 1);
    }
}
