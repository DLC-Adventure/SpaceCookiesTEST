/*
 * SPACE COOKIES by DLC © 2020
 */
package it.dlc.adventure.swing;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Riproduzione della musica in sottofondo.
 */
public class Music extends JDialog {

    public void playMusic() {

        try {
            File musicPath = new File("media/Soundtrack.wav");

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                Object[] message = {"Vuoi attivare la musica?"};

                Object[] options = {"Si", "No"};
                JFrame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                int selectedOption = JOptionPane.showOptionDialog(jf,
                        message, "Space Cookies",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        options, options[1]);

                if (selectedOption == JOptionPane.OK_OPTION) { // Risposta affermativa
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                if (selectedOption == JOptionPane.NO_OPTION) { // Risposta negativa
                    clip.stop();
                    clip.close();
                }
            } else {
                System.out.println("######################################################");
                System.err.println("Impossibile riprodurre la musica, file non trovato.");
                System.out.println("######################################################");
            }

        } catch (HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("################################################");
            System.err.println("Impossibile riprodurre la musica.\nEccezione verificata: " + ex);
            System.out.println("################################################");
        }

    }

}
