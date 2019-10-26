package speechrecog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Sample2 {       

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        //configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration.setGrammarPath("resource:/grammars");
        
        configuration.setGrammarName("grammar");
        System.out.print(configuration.getGrammarPath());
        configuration.setUseGrammar(true);
       LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
  
     // Start recognition process pruning previously cached data.
     recognizer.startRecognition(true);
     SpeechResult result = recognizer.getResult();
    
     while ((result = recognizer.getResult()) != null) {
 	    System.out.format("Hypothesis: %s\n", result.getHypothesis());
 	}
     // Pause recognition process. It can be resumed then with startRecognition(false).
	//recognizer.stopRecognition();
    }
}