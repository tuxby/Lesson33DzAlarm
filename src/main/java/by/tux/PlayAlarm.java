package by.tux;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayAlarm {
    public static void playAudio() {
        AudioInputStream audioIn;
        try {
//            audioIn = AudioSystem.getAudioInputStream(PlayAlarm.class.getResourceAsStream("/audio/alarm1.wav"));
            audioIn = AudioSystem.getAudioInputStream(PlayAlarm.class.getResourceAsStream("/audio/alarm2.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
            e.printStackTrace();
        }
    }

}