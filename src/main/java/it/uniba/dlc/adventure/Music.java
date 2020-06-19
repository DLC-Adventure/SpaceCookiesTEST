/*
 * SPACE COOKIES by DLC © 2020
 */
package it.uniba.dlc.adventure;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ego
 */
// test 
public class Music {

    public void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                Object[] message = {"Vuoi Attivare l'audio"};

                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(new JFrame(),
                        message, "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options, options[1]);
                if (n == JOptionPane.OK_OPTION) { // Afirmative
                    clip.start();

                }
                if (n == JOptionPane.NO_OPTION) { // negative
                    clip.stop();
                }
                if (n == JOptionPane.CLOSED_OPTION) { // closed the dialog

                }

            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
