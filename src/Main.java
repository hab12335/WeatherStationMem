public class Main {

    public static void main(String[] args) {
        WeatherStationMem temperaturas = new WeatherStationMem();
        temperaturas.sampleTemperature(66);
        temperaturas.sampleTemperature(30);
        for (double i = 0; i < 3; i++) {
            double random = -10 + Math.random() * (45 + 10);
            temperaturas.sampleTemperature(random);
        }
        temperaturas.countSamplesGreaterThan(10);
        temperaturas.countSamplesLowerThan(20);
        temperaturas.insertAt(66, 5);
        System.out.println(temperaturas.firstIndexOfSample(66));
        System.out.println(temperaturas.lastIndexOfSample(66));
    }
}
