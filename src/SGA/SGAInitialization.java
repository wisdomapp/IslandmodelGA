package SGA;
import GeneticAlgorithm.Data;
import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.InitializationBehavior;

public class SGAInitialization implements InitializationBehavior{

	public void initialization(GeneticAlgorithm ga){

		ga.setCurrentgeneration(0);
		int pop=ga.getPoplation();
		int geneSize=ga.getGeneSize();
		ga.SGAdata=new Data[pop];

		for(int i=0;i<ga.SGAdata.length;i++){
			ga.SGAdata[i]=new Data(pop);
		}
		//String[] Pop=new String[pop];
		System.out.println("第1世代開始\n初期集団");
		for(int i=0;i<pop;i++){
			ga.SGAdata[0].Pop[i]="";
			for(int i2=0;i2<geneSize;i2++){
				ga.SGAdata[0].Pop[i] +=(int)(Math.random()+0.5);
			}
		}

		//デバッグ表示
		for(int i=0;i<pop;i++){
			System.out.println("Pop["+i+"]="+ga.SGAdata[0].Pop[i]);
		}

	}
}