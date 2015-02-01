package fr.uds.info907.control;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import fr.uds.info907.view.Home;

/**
 * Voir pour l'utilisation basique
 * http://cmusphinx.sourceforge.net/wiki/tutorialsphinx4
 * @author patrick-edouard
 *
 */
public class VoiceControler {
	
	private static final String configPath = "models/en-us";
	
	public VoiceControler(){
		
	}
	
	public String getComande() {
		String comande = " ";
		try{
			URL url;
            
            url = Thread.currentThread().getContextClassLoader().getResource("config.xml");
            

            System.out.println("Loading...");
            System.out.println(url.getPath());

            ConfigurationManager cm = new ConfigurationManager(url);

	    Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
	    Microphone microphone = (Microphone) cm.lookup("microphone");


            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();

            /* the microphone will keep recording until the program exits */
	    if (microphone.startRecording()) {

		Home home = new Home();
		while (true) {
		    System.out.println
			("Start speaking. Press Ctrl-C to quit.\n");

                    /*
                     * This method will return when the end of speech
                     * is reached. Note that the endpointer will determine
                     * the end of speech.
                     */ 
		    Result result = recognizer.recognize();
		    
		    if (result != null) {
			String resultText = result.getBestFinalResultNoFiller();
			System.out.println("You said: " + resultText + "\n");
			home.proceedComande(resultText);
		    } else {
			System.out.println("I can't hear what you said.\n");
		    }
		}
	    } else {
		System.out.println("Cannot start microphone.");
		recognizer.deallocate();
		System.exit(1);
	    }
        } catch (PropertyException e) {
            e.printStackTrace();
        }
		return comande;
	}
	
	public static void main (String[] args){
		
		VoiceControler voiceControler = new VoiceControler();
		String order = voiceControler.getComande();
		System.out.println(order);
	}
}
