package PGA;

import GeneticAlgorithm.GeneticAlgorithm;

public class PGA extends GeneticAlgorithm{

	public PGA(){
		initializationBehavior=new PGAInitialization();
		fitnessBehavior=new PGAFitness();
	}

}