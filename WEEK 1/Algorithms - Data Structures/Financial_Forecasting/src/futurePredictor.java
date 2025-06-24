import java.util.ArrayList;
import java.util.List;

public class futurePredictor {

    public static void main(String[] args) {
        // Step 1: Historical quarterly data
        List<Double> pastValues = new ArrayList<>();
        pastValues.add(120.0);
        pastValues.add(125.0);
        pastValues.add(131.0);
        pastValues.add(138.0);

        int futureQuarters = 4;
        double weight = 0.3;

        List<Double> predictions = forecastFuture(pastValues, futureQuarters, weight);

        System.out.println("Quarter         | Value ($1000s)");

        for (int i = 0; i < pastValues.size() + futureQuarters; i++) {
            String label = (i < pastValues.size()) ? "Past Q" + (i + 1) : "Predicted Q" + (i + 1);
            double value = (i < pastValues.size()) ? pastValues.get(i) : predictions.get(i - pastValues.size());

            System.out.printf("%-16s| $%.2f\n", label, value);
        }
    }

    public static List<Double> forecastFuture(List<Double> past, int futureCount, double weight) {
        List<Double> forecast = new ArrayList<>();
        double initialGrowth = estimateGrowthRate(past, weight);
        forecastRecursively(past, forecast, futureCount, weight, initialGrowth);
        return forecast;
    }

    public static void forecastRecursively(List<Double> past, List<Double> forecast,
            int remaining, double weight, double growthRate) {
        if (remaining == 0)
            return;

        double lastValue = forecast.isEmpty() ? past.get(past.size() - 1) : forecast.get(forecast.size() - 1);
        double nextValue = lastValue * (1 + growthRate);
        forecast.add(nextValue);

        double newRate = weight * ((nextValue - lastValue) / lastValue) + (1 - weight) * growthRate;

        forecastRecursively(past, forecast, remaining - 1, weight, newRate);
    }

    public static double estimateGrowthRate(List<Double> past, double weight) {
        if (past.size() < 2)
            return 0;

        double sum = 0;
        double totalWeight = 0;

        for (int i = 1; i < past.size(); i++) {
            double growth = (past.get(i) - past.get(i - 1)) / past.get(i - 1);
            double currentWeight = Math.pow(weight, past.size() - i - 1);

            sum += growth * currentWeight;
            totalWeight += currentWeight;
        }

        return sum / totalWeight;
    }
}
