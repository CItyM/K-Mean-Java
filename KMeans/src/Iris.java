public class Iris {
    /**
     * Sepal's length
     */
    private double sepalLength;

    /**
     * Sepal's width
     */
    private double sepalWidth;

    /**
     * Petal's length
     */
    private double petalLength;

    /**
     * Petal's width
     */
    private double petalWidth;

    /**
     * Label's value
     */
    private String label;

    /**
     * A constructor, which sets its fields to the respective coresponding
     * parameters' values.
     *
     * @param sepalLength double The length of a sepal.
     * @param sepalWidth  double The width of a sepal.
     * @param petalLength double The langth of a petal.
     * @param petalWidth  double The width of a petal.
     * @param label       String The value of the label.
     */
    public Iris(final double sepalLength, final double sepalWidth, final double petalLength, final double petalWidth,
            final String label) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.label = label;
    }

    /**
     * A constructor, which takes an object parameter and asigns its fields values
     * to the new object.
     *
     * @param iris Iris
     */
    public Iris(final Iris iris) {
        this.sepalLength = iris.sepalLength;
        this.sepalWidth = iris.sepalWidth;
        this.petalLength = iris.petalLength;
        this.petalWidth = iris.petalWidth;
        this.label = iris.label;
    }

    /*
     * Overrides the toString method.
     */
    @Override
    public String toString() {
        return "Iris { " + "sepal_length = " + sepalLength + ", sepal_width = " + sepalWidth + ", petal_length = "
                + petalLength + ", petal_width = " + petalWidth + ", species = '" + label + '\'' + " }";
    }

    /*
     * Overrides the equals method.
     */
    @Override
    public boolean equals(final Object object) {
        // if the two objects are the same returns true
        if (this == object)
            return true;
        // if the obj parmaeter is not from class Iris retuns false
        if (object == null || getClass() != object.getClass())
            return false;
        // casts the parameter to a type of Iris
        final Iris iris = (Iris) object;
        // compares every pair of the parametet's fields
        return Double.compare(iris.sepalLength, sepalLength) == 0 && Double.compare(iris.sepalWidth, sepalWidth) == 0
                && Double.compare(iris.petalLength, petalLength) == 0
                && Double.compare(iris.petalWidth, petalWidth) == 0 && label.equals(((Iris) object).label);
    }

    /**
     * Gets the label's value.
     * 
     * @return String The label's value.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label's value.
     * 
     * @param label String The lable's value.
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Gets the petal's width.
     * 
     * @return double The petal's width.
     */
    public double getPetalWidth() {
        return petalWidth;
    }

    /**
     * Sets the petal's width.
     * 
     * @param petalWidth double The petal's width.
     */
    public void setPetalWidth(final double petalWidth) {
        this.petalWidth = petalWidth;
    }

    /**
     * Gets the petal's length.
     * 
     * @return double The petal's length.
     */
    public double getPetalLength() {
        return petalLength;
    }

    /**
     * Sets the petal's length.
     * 
     * @param petalLength double The petal's length.
     */
    public void setPetalLength(final double petalLength) {
        this.petalLength = petalLength;
    }

    /**
     * Gets the sepal's width
     * 
     * @return double The sepal's width.
     */
    public double getSepalWidth() {
        return sepalWidth;
    }

    /**
     * Sets the sepal's width.
     * 
     * @param sepalWidth double The sepal's width.
     */
    public void setSepalWidth(final double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    /**
     * Gets the sepal's length.
     * 
     * @return double The sepal's length.
     */
    public double getSepalLength() {
        return sepalLength;
    }

    /**
     * Sets the sepal's length.
     * 
     * @param sepalLength double The sepal's length.
     */
    public void setSepalLength(final double sepalLength) {
        this.sepalLength = sepalLength;
    }
}