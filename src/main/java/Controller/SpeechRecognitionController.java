//package Controller;
//
//import com.google.cloud.speech.v1.RecognitionAudio;
//import com.google.cloud.speech.v1.RecognitionConfig;
//import com.google.cloud.speech.v1.SpeechClient;
//import com.google.cloud.speech.v1.SpeechRecognitionResult;
//import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
//import com.google.protobuf.ByteString;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SpeechRecognitionController {
//
//    @Autowired
//    private SpeechClient speechClient;
//
//    @PostMapping("/recognize")
//    public SpeechRecognitionResult recognize(@RequestBody byte[] audioData) {
//        RecognitionConfig config = RecognitionConfig.newBuilder()
//                .setEncoding(AudioEncoding.LINEAR16)
//                .setSampleRateHertz(16000)
//                .setLanguageCode("ru-RU")
//                .build();
//
//        ByteString audioBytes = ByteString.copyFrom(audioData);
//        RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder()
//                .setContent(audioBytes)
//                .build();
//
//        return speechClient.recognize(config, recognitionAudio).getResultsList().get(0);
//
//
//    }
//
//}