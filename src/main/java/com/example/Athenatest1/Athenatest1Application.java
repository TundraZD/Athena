package com.example.Athenatest1;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Athenatest1Application {
	public static void main(String[] args) {
		SpringApplication.run(Athenatest1Application.class, args);
		try {
			Configuration configuration = new Configuration();
			configuration.setAcousticModelPath("file:/D:/ProjectAthena/Athenatest1/voxforge_ru_sphinx-master/model_parameters/voxforge_ru.cd_cont_200");
			configuration.setDictionaryPath("file:/D:/ProjectAthena/Athenatest1/voxforge_ru_sphinx-master/voxforge_ru.dic");
			configuration.setLanguageModelPath("file:/D:/ProjectAthena/Athenatest1/voxforge_ru_sphinx-master/voxforge_ru.lm.bin");

			System.out.println("Конфигурация установлена.");
			LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
			recognizer.startRecognition(true);

			System.out.println("Начало распознавания речи...");
			long endTime = System.currentTimeMillis() + 60000; // Устанавливаем таймаут 1 минуту
			SpeechResult result;
			while ((result = recognizer.getResult()) != null && System.currentTimeMillis() < endTime) {
				String hypothesis = result.getHypothesis();
				System.out.println("Вы сказали: " + hypothesis);
				if (hypothesis.equalsIgnoreCase("проводник") ||
						hypothesis.equalsIgnoreCase("путь") ||
						hypothesis.equalsIgnoreCase("трубка") ||
						hypothesis.equalsIgnoreCase("пропуск")) {
					Runtime.getRuntime().exec("explorer.exe");
				}
			}
			recognizer.stopRecognition();

			System.out.println("Распознавание завершено.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
