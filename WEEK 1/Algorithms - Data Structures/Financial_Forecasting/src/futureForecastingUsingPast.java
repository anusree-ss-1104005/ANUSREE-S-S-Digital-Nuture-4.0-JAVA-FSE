public class futureForecastingUsingPast {
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000;
        double rate = 0.07;
        int years = 10;

        double futureValue = calculateFutureValueRecursive(presentValue, rate, years);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);
    }

}
