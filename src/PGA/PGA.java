package PGA;

import GeneticAlgorithm.GeneticAlgorithm;

public class PGA extends GeneticAlgorithm {

    public PGA() {
	initializationBehavior = new PGAInitialization();
	fitnessBehavior = new PGAFitness();
	eliteBehavior = new PGASingleElite();
	selectionBehavior = new PGASelection();
	crossoverBehavior = new PGAcrossover();
	mutationBehavior = new PGAMutation();
	nextBehavior = new PGANext();
	outputBehavior = new PGAOutput();

    }

}