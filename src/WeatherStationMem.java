public class WeatherStationMem {
    private int counter;
    public static final int DEFAULT_SIZE = 100;
    public static final int GROWTH = 2;
    private double[] samples;

    public WeatherStationMem() {
        counter = 0;
        samples = new double[DEFAULT_SIZE];
    }


    public void sampleTemperature(double temp) {
        if (this.atCapacity())
            this.resize();
        samples[counter++] = temp;
    }

    private boolean atCapacity() {
        return counter == samples.length;
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
        double max = 0;
        for (int i = 0; i < counter; i++)
            if (samples[i] > max)
                max = samples[i];
        return max;
    }

    public double minimum() {
        double min = samples[0];
        for (int i = 0; i < counter; i++)
            if (samples[i] < min)
                min = samples[i];
        return min;
    }

    private void resize() {
        double[] tmp = new double[GROWTH * samples.length];
        for (int i = 0; i < samples.length; i++)
            tmp[i] = samples[i];
        samples = tmp;
    }

    public int firstIndexOfSample(double temp) {
        int result = -1;
        for (int i = 0; i < counter && result == -1; i++)
            if (samples[i] == temp)
                result = i;
        return result;
    }

    public int lastIndexOfSample(double temp) {
        int result = -1;
        for (int i = counter; i >= 0 && result == -1; i--)
            if (samples[i] == temp)
                result = i;
        return result;

    }

    public int countSamplesGreaterThan(double temp) {
        int innerCounter = 0;
        for (int i = 0; i < counter; i++) {
            if (samples[i] > temp)
                innerCounter++;
        }
        return innerCounter;
    }

    public int countSamplesLowerThan(double temp) {
        int innerCounter = 0;
        for (int i = 0; i < counter; i++) {
            if (samples[i] < temp)
                innerCounter++;
        }
        return innerCounter;
    }

    public void insertAt(double temp, int pos) {
        if (this.atCapacity())
            this.resize();
        for (int i = counter; i > pos ; i--) {
            samples[i] = samples[i - 1];
        }
        samples[pos] = temp;
        counter++;
    }

    public void removeAt(int pos) {
        for (int i = pos; i < counter ; i++) {
            samples[i] = samples[i + 1];
        }
        counter--;
    }
}
