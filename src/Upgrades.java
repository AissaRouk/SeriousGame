import javax.swing.*;
import java.util.Objects;

public class Upgrades {
    int upgradeIndex = 0;
    int autoClickUpgradeIndex = 0;
    int clickValue;
    int perSecondValue;
    int upgradeCost = 10;
    int autoUpgradeCost = 10;
    int difficulty = 15;
    String text1;
    String text2;
    String text3;
    String text4;
    ImageIcon image = new ImageIcon();

    Upgrades(){
        clickUpgradeManger();
        autoClickManager();
    }
    public void setUpgradeIndex(int upgradeIndex){
        this.upgradeIndex = upgradeIndex;
    }
    public int getUpgradeIndex(){
        return upgradeIndex;
    }
    public int getAutoClickUpgradeIndex(){
        return autoClickUpgradeIndex;
    }
    public void setAutoClickUpgradeIndex(int autoClickUpgradeIndex){
        this.autoClickUpgradeIndex = autoClickUpgradeIndex;
    }
    public void setClickValue(int clickValue){
        this.clickValue = clickValue;
    }
    public int getClickValue(){
        return clickValue;
    }
    public void setPerSecondValue(int perSecondValue){
        this.perSecondValue = perSecondValue;
    }
    public int getPerSecondValue(){
        return perSecondValue;
    }
    public void setUpgradeCost(int upgradeCost){
        this.upgradeCost = upgradeCost;
    }
    public int getUpgradeCost(){
        return upgradeCost;
    }
    public void setAutoUpgradeCost(int autoUpgradeCost){
        this.autoUpgradeCost = autoUpgradeCost;
    }
    public int getAutoUpgradeCost(){
        return autoUpgradeCost;
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
    public void setText3(String text3){
        this.text3 = text3;
    }
    public String getText3(){
        return text3;
    }
    public void setText4(String text4){
        this.text4 = text4;
    }
    public String getText4(){
        return text4;
    }

    public void clickUpgradeManger(){
        if(upgradeIndex == 0){
            setClickValue(1);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("smile.png")));
            setImage(image);
            setText1("Eggman");
            setText2(upgradeCost + " social credits");
        }
        if(upgradeIndex == 1){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("eggman.png")));
            setImage(image);
            setText1("Yin Di Zhel");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 2){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("diesel.png")));
            setImage(image);
            setText1("Yuan-i Dieph");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 3){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("depp.png")));
            setImage(image);
            setText1("Bhra Di Pitth");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 4){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("pitt.png")));
            setImage(image);
            setText1("The Wok");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 5){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("wok.png")));
            setImage(image);
            setText1("Zhong Xina");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 6){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("xina.png")));
            setImage(image);
            setText1("Zhig A Chad");
            setText2(upgradeCost * difficulty + " social credits");
        }
        if(upgradeIndex == 7){
            setClickValue(clickValue * 5);
            ImageIcon image = new ImageIcon(Objects.requireNonNull(Upgrades.class.getClassLoader().getResource("gigachad.png")));
            setImage(image);
            setText1("All upgrades");
            setText2("unlocked");
        }
        setUpgradeIndex(upgradeIndex + 1);
    }
    public void autoClickManager(){
        if(autoClickUpgradeIndex == 0){
            setPerSecondValue(0);
            setText3("5/second");
            setText4(autoUpgradeCost + " social credits");
        }
        if(autoClickUpgradeIndex == 1){
            setPerSecondValue(5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 2){
            setPerSecondValue(perSecondValue * 5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 3){
            setPerSecondValue(perSecondValue * 5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 4){
            setPerSecondValue(perSecondValue * 5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 5){
            setPerSecondValue(perSecondValue * 5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 6){
            setPerSecondValue(perSecondValue * 5);
            setText3(perSecondValue * 5 + "/second");
            setText4(autoUpgradeCost * difficulty + " social credits");
        }
        if(autoClickUpgradeIndex == 7){
            setPerSecondValue(perSecondValue * 5);
            setText3("All upgrades");
            setText4("unlocked");
        }
        setAutoClickUpgradeIndex(autoClickUpgradeIndex + 1);
    }
}
