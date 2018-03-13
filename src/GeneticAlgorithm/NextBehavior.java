package GeneticAlgorithm;

public interface NextBehavior {
    public void eliteCheck(GeneticAlgorithm ga);

    public void next(GeneticAlgorithm ga);
}