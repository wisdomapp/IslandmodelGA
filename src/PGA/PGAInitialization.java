package PGA;
import GeneticAlgorithm.Data;
import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.InitializationBehavior;

public class PGAInitialization implements InitializationBehavior{

	public void initialization(GeneticAlgorithm ga){

		ga.setCurrentgeneration(0);
		int pop=ga.getPoplation();
		int geneSize=ga.getGeneSize();
		ga.PGAdata=new Data[ga.getGeneration()][ga.getISLAND()];

		for(int gen=0;gen<ga.getGeneration();gen++){
			for(int island=0;island<ga.getISLAND();island++){
				ga.PGAdata[gen][island]=new Data(pop);
			}
		}
		//String[] Pop=new String[pop];
		System.out.println("第1世代開始.\n初期集団生成.");
		for(int island=0;island<ga.getISLAND();island++){
			for(int i=0;i<pop;i++){
				ga.PGAdata[0][island].poplation[i]="";
				for(int i2=0;i2<geneSize;i2++){
					ga.PGAdata[0][island].poplation[i] +=(int)(Math.random()+0.5);
				}
			}
		}


		//デバッグ表示
		/*
		for(int island=0;island<ga.getISLAND();island++){
			for(int i=0;i<pop;i++){
			System.out.println("island["+island+"]="+ga.PGAdata[0][island].poplation[i]);
			}
		}
		*/
	}
}