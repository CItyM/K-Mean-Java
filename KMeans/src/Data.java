import java.io.*;
import java.util.*;

public class Data {
    /**
     * Reads the data from the file.
     * 
     * @param fileName String The name of the file.
     * @return List<Iris> Returns a list of Iris, which comes from the data inside
     *         the file.
     */
    public static List<Iris> read(final String fileName) {
        String str;
        final List<Iris> irises = new ArrayList<>();
        try {
            final BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((str = br.readLine()) != null) {
                final String[] data = str.split(",");
                irises.add(new Iris(Double.parseDouble(data[0]), Double.parseDouble(data[1]),
                        Double.parseDouble(data[2]), Double.parseDouble(data[3]), data[4]));
            }

            br.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return irises;
    }

    /**
     * Writes the data inside the file.
     * 
     * @param data     List<List<Iris>> A list of clusters.
     * @param fileName String The name of the file.
     */
    public static void write(final List<List<Iris>> data, final String fileName) {
        try {
            final BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < data.size(); i++) {
                writer.write("\nCluster " + i + "\n\n");
                for (final Iris iris : data.get(i)) {
                    writer.write(iris.toString() + "\n");
                }
            }
            writer.close();
        } catch (final IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
