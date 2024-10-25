package com.example.Athena;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class SpeechRecognitionDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("src/main/resources/edu/cmu/sphinx/models/ru/zero_ru.cd_cont_4000");
        configuration.setDictionaryPath("src/main/resources/edu/cmu/sphinx/models/ru/cmudict-ru.dict");
        configuration.setLanguageModelPath("src/main/resources/edu/cmu/sphinx/models/ru/ru.lm.bin");

        try {
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);
            System.out.println("Speak something...");

            while (true) {
                String result = recognizer.getResult().getHypothesis();
                System.out.println("You said: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
