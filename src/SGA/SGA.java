package SGA;

import GeneticAlgorithm.GeneticAlgorithm;

public class SGA extends GeneticAlgorithm {

    public SGA() {
	initializationBehavior = new SGAInitialization();
	fitnessBehavior = new SGAFitness();
	eliteBehavior = new SGASingleElite();
	selectionBehavior = new SGASelection();
	crossoverBehavior = new SGACrossover();
	mutationBehavior=new SGAMutation();
    }

}