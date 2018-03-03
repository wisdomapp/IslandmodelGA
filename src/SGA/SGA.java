package SGA;

import GeneticAlgorithm.GeneticAlgorithm;

public class SGA extends GeneticAlgorithm{
	
	public SGA(){
		initializationBehavior=new SGAInitialization();
	}

}