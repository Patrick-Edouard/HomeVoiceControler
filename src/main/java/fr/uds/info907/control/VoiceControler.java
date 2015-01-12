package fr.uds.info907.control;

import java.net.URL;
import java.util.Scanner;

import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import fr.uds.info907.view.Home;

/**
 * Voir pour l'utilisation basique
 * http://cmusphinx.sourceforge.net/wiki/tutorialsphinx4
 * @author patrick-edouard
 *
 */
public class VoiceControler {
	
	public String getComande(){

		URL configURL = Thread.class.getResource("pathToConfig.xml");
		
		ConfigurationManager cm = new ConfigurationManager(configURL);
		Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
		Result result = recognizer.recognize();
		String resultText = result.getBestFinalResultNoFiller();
		System.out.println(resultText);
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		String comande = scanner.nextLine();
		scanner.close();
		return comande;
	}
	
	public static void main (String[] args){
		Home home = new Home();
		VoiceControler voiceControler = new VoiceControler();
		String order = voiceControler.getComande();
		while(!order.equals("exit")){
			home.proceedComande(order);
			order = voiceControler.getComande();
		}
		
	}
}
