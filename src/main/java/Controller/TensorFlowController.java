//package Controller;
//import Service.TensorFlowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TensorFlowController {
//
//    @Autowired
//    private TensorFlowService tensorFlowService;
//
//    @PostMapping("/predict")
//    public float[][] predict(@RequestBody float[][] inputData) {
//        // Здесь должен быть загружен ваш файл модели (модель должна быть загружена заранее)
//        byte[] modelData = loadModel();
//        return tensorFlowService.runModel(modelData, inputData);
//    }
//
//    private byte[] loadModel() {
//        // Реализуйте метод загрузки модели в виде байтового массива
//        return new byte[]{};
//    }
//}
