package SeriousGame.src;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class GameMusic {

    Clip clip;
    float previousVolume = -10;
    float currentVolume = -10;
    FloatControl fc;
    boolean mute = false;

    public void setFile(URL url){
        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e){

        }
    }
    public void play(URL url){
        clip.setFramePosition(0);
        clip.start();
    }
    public void loop(URL url){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(URL url){
        clip.stop();
    }
    public void volumeUp(URL url){
        currentVolume += 1.0f;
        if(currentVolume > 0.0f){
            currentVolume = 0.0f;
        }
        fc.setValue(currentVolume);
    }
    public void volumeDown(URL url){
        currentVolume -= 1.0f;
        if(currentVolume < -80.0f){
            currentVolume = -80.0f;
        }
        fc.setValue(currentVolume);
    }
    public void volumeMute()
    {
        if(mute == false)
        {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            mute = true;
        }
        else if(mute == true)
        {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            mute = false;
        }
    }
}
