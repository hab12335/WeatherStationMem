public class WeatherStationMem {
    private int counter;
    public static final int DEFAULT_SIZE = 100;
    private double[] samples;

    public WeatherStationMem() {
        counter = 0;
        samples = new double[DEFAULT_SIZE];
    }

    public void sampleTemperature(double temp) {
        samples[counter++] = temp;
    }

    public int numberTemperatures() {
        return counter;
    }

    public double getSample(int i) {
        return samples[i - 1];
    }

    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < counter; i++) {
            sum += samples[i];
        }
        return sum / counter;
    }

    public double maximum() {
        int i= 0;
        double sum = 0;

    }

    public double minumum() {
        int i= 0;
        double sum = 0;

    }

}
