import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class KMeans {

    /**
     * List of all the irises
     */
    private final List<Iris> irises;

    /**
     * List of the current centroids
     */
    private final List<Iris> currentCentroids = new ArrayList<>();

    /**
     * List of the previous centroids
     */
    private final List<Iris> previousCentroids = new ArrayList<>();

    /**
     * List of clusters
     */
    private final List<List<Iris>> clusters = new ArrayList<>();

    /**
     * Constructor
     * 
     * @param irises List<Iris> The data from which the clusters will be formed.
     * @param k      int Number of clusters.
     */
    public KMeans(final List<Iris> irises, final int k) {
        this.irises = irises;

        for (int i = 0; i < k; ++i) {
            // a random index from the availabe index pool,
            // using a multi-threded random variable to avoid any concurrent access
            final int index = ThreadLocalRandom.current().nextInt(irises.size() / k) * (i + 1);

            // populates the data into its collection
            currentCentroids.add(new Iris(irises.get(index)));
            previousCentroids.add(new Iris(currentCentroids.get(i)));
            clusters.add(new ArrayList<Iris>());
        }
    }

    /**
     * Clusters the data.
     */
    public void cluster() {
        int iterations = 0;
        do {
            clearClusters();
            addPointsToCluster();
            moveCentroids();
            ++iterations;
        } while (areCentroidsToBeMoved());

        System.out.printf("\nFinished clustering.\n\n", iterations);
        System.out.printf("It took %d iterations to cluster.\n", iterations);
    }

    /**
     * Method to check if there remaining centroids yet to be moved
     * 
     * @return boolean True if there is still clustering happend
     */
    private boolean areCentroidsToBeMoved() {
        //
        for (int i = 0; i < currentCentroids.size(); ++i) {
            // if the current centroid is not equals to the previous centroid,
            // at the same index position,
            // then further movement has to be done
            if (!currentCentroids.get(i).equals(previousCentroids.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the clusters.
     */
    private void clearClusters() {
        for (final List<Iris> cluster : clusters) {
            cluster.clear();
        }
    }

    /**
     * Adds a new iris to the nearest centroid cluster.
     */
    private void addPointsToCluster() {
        for (final Iris iris : irises) {

            clusters.get(nearestCentroid(iris)).add(iris);
        }
    }

    /**
     * Calculates the average stats of the irises inside a cluster to keep the
     * center point as accurate as possible, and avoid large amplitudes.
     */
    private void moveCentroids() {
        double averageSepalLength = 0;
        double averageSepalWidth = 0;
        double averagePetalLength = 0;
        double averagePetalWidth = 0;

        for (int i = 0; i < clusters.size(); ++i) {
            // summs all the values from a cluster i
            for (final Iris iris : clusters.get(i)) {
                averageSepalLength += iris.getSepalLength();
                averageSepalWidth += iris.getSepalWidth();
                averagePetalLength += iris.getPetalLength();
                averagePetalWidth += iris.getPetalWidth();
            }

            // calculates the averages of the i-th cluster
            averageSepalLength /= clusters.get(i).size();
            averageSepalWidth /= clusters.get(i).size();
            averagePetalLength /= clusters.get(i).size();
            averagePetalWidth /= clusters.get(i).size();

            // sets the current centroid as a previous
            previousCentroids.set(i, new Iris(currentCentroids.get(i)));

            // replaces the old with a new one
            currentCentroids.set(i,
                    new Iris(averageSepalLength, averageSepalWidth, averagePetalLength, averagePetalWidth, "Centroid"));
        }
    }

    /**
     * Calcutates the distance between two irises using the "Euclidean distance"
     * formula.
     * 
     * @param x Iris
     * @param y Iris
     * @return double The distance between the two irises.
     */
    private double distance(final Iris x, final Iris y) {
        return Math.sqrt(Math.pow((x.getSepalLength() - y.getSepalLength()), 2)
                + Math.pow((x.getSepalWidth() - y.getSepalWidth()), 2)
                + Math.pow((x.getPetalLength() - y.getPetalLength()), 2)
                + Math.pow((x.getPetalWidth() - y.getPetalWidth()), 2));
    }

    /**
     * Takes an iris and retunts the index of the nearest neighbor inside a cluster.
     * 
     * @param iris Iris
     * @return int The index of the nearest centroid from this iris.
     */
    private int nearestCentroid(final Iris iris) {
        // set a starting distance to which the next distances will be compared to
        double shortestDistance = distance(iris, currentCentroids.get(0));

        // the index of the closest
        int nearestCentroid = 0;

        for (int i = 1; i < currentCentroids.size(); ++i) {
            // calculates the distance betweent the parameter
            // and every element inside the centroids
            final double distance = distance(iris, currentCentroids.get(i));

            // if the current distance is shorter than the previously shortest one,
            // updates the shortestDistance and the nearestCentroid
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestCentroid = i;
            }
        }

        return nearestCentroid;
    }

    /**
     * Gets all the clusters.
     * 
     * @return List All of the clusters.
     */
    public List<List<Iris>> getClusters() {
        return clusters;
    }

}