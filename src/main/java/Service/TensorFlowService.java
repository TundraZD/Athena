//package Service;
//import org.springframework.stereotype.Service;
//import org.tensorflow.Graph;
//import org.tensorflow.Session;
//import org.tensorflow.Tensor;
//
//@Service
//public class TensorFlowService {
//
//    public float[][] runModel(byte[] modelData, float[][] inputData) {
//        try (Graph graph = new Graph()) {
//            graph.importGraphDef(modelData);
//            try (Session session = new Session(graph)) {
//                Tensor inputTensor = Tensor.create(inputData);
//                Tensor outputTensor = session.runner().feed("input", inputTensor).fetch("output").run().get(0);
//                float[][] output = new float[1][1];
//                outputTensor.copyTo(output);
//                return output;
//            }
//        }
//    }
//}
//
