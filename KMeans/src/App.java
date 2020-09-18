import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // the data
            List<Iris> irises = Data.read("./data/iris.data");

            // the model,
            // which takes the irises for data
            // and divides the data into 3 clusters
            KMeans kMeans = new KMeans(irises, 3);

            // runs the model
            kMeans.cluster();

            // wites the formed clusters inside the file
            Data.write(kMeans.getClusters(), "./output/cluster.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
