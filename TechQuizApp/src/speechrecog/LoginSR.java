package speechrecog;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.InputStream;

import com.sun.swing.internal.plaf.synth.resources.synth;

import edu.cmu.sphinx.api.Configuration;
	import edu.cmu.sphinx.api.LiveSpeechRecognizer;
	import edu.cmu.sphinx.api.SpeechResult;
	import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class LoginSR {       
	private static Configuration configuration;
	private static LiveSpeechRecognizer recognizer;
	private static SpeechResult result;
/*	public LoginSR() {
		configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setGrammarPath("resource:/grammars");     
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);
        try {
        	recognizer = new LiveSpeechRecognizer(configuration);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}*/
	
	static {
		configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setGrammarPath("resource:/grammars");     
        configuration.setGrammarName("grammar");
        configuration.setUseGrammar(true);
        try {
        	recognizer = new LiveSpeechRecognizer(configuration);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        recognizer.startRecognition(true);
       	}
	
	public LiveSpeechRecognizer lsr() {
	/*	try {
        	recognizer = new LiveSpeechRecognizer(configuration);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }*/
		return recognizer;
	}
	
	public static String speech() {
		SpeechResult result = recognizer.getResult();
		return result.getHypothesis();
	}
	
	public Configuration newListening() {
		return configuration;
	}
}

