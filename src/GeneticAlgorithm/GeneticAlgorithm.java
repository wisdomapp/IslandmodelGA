package GeneticAlgorithm;

import java.util.Scanner;


public abstract class GeneticAlgorithm{


	private int GAtype; //GAtype選択
	private int ISLAND=4; //島の数
	private int IMMIGRATION=25; //移住イベント世代数
	private int grayF; //グレイコードフラグ
	private int poplation; //集団数
	private int geneSize; //個体長
	private int generation; //世代数
	private int crossingF; //交叉フラグ
	private boolean fileF; //ファイル保存フラグ
	private int currentisland; //現在の島
	private int currentgeneration; //現在の世代
	public Data SGAdata[]; //SGA用構造体
	private Data PGAdata[][]; //PGA用構造体

	public InitializationBehavior initializationBehavior;

	public GeneticAlgorithm(){

	}

	//初期化
	public void performInitialization(GeneticAlgorithm test){
		initializationBehavior.initialization(test);
	}
	//評価
	public void performFitness(){

	}
	//選択
	public void performSelection(){

	}
	//交叉
	public void performCrossover(){

	}
	//突然変異
	public void performMutation(){

	}
	//ファイル出力
	public void performOutput(){

	}

	public void FirstInput(){

		System.out.println("世代数を設定してください。");
		setGeneration(intReader());
		System.out.println("集団数を設定してください。");
		setPoplation(intReader());
		System.out.println("遺伝子長を設定してください。");
		setGeneSize(intReader());
		System.out.println("binaryなら0,graycodeなら1を入力してください。");
		setGrayF(intReader());
		System.out.println("一点交叉なら0,一様交叉なら1を入力してください。");
		setCrossingF(intReader());

	}

	//int型標準入力
	public static int intReader(){
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int line = in.nextInt();//文字列の入力受付
        return line;
	}

	//アクセサ
	public int getISLAND() {
		return ISLAND;
	}
	public void setISLAND(int iSLAND) {
		ISLAND = iSLAND;
	}

	public int getIMMIGRATION() {
		return IMMIGRATION;
	}
	public void setIMMIGRATION(int iMMIGRATION) {
		IMMIGRATION = iMMIGRATION;
	}

	public int getGrayF() {
		return grayF;
	}
	public void setGrayF(int grayF) {
		this.grayF = grayF;
	}

	public int getPoplation() {
		return poplation;
	}
	public void setPoplation(int poplation) {
		this.poplation = poplation;
	}

	public int getGeneSize() {
		return geneSize;
	}
	public void setGeneSize(int geneSize) {
		this.geneSize = geneSize;
	}

	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getCrossingF() {
		return crossingF;
	}
	public void setCrossingF(int crossingF) {
		this.crossingF = crossingF;
	}

	public boolean isFileF() {
		return fileF;
	}
	public void setFileF(boolean fileF) {
		this.fileF = fileF;
	}

	public int getGAtype() {
		return GAtype;
	}
	public void setGAtype(int gAtype) {
		GAtype = gAtype;
	}

	public Data[] getSGAdata() {
		return SGAdata;
	}
	public void setSGAdata(Data[] sGAdata) {
		SGAdata = sGAdata;
	}

	public Data[][] getPGAdata() {
		return PGAdata;
	}
	public void setPGAdata(Data[][] pGAdata) {
		PGAdata = pGAdata;
	}

	public int getCurrentisland() {
		return currentisland;
	}
	public void setCurrentisland(int currentisland) {
		this.currentisland = currentisland;
	}

	public int getCurrentgeneration() {
		return currentgeneration;
	}
	public void setCurrentgeneration(int currentgeneration) {
		this.currentgeneration = currentgeneration;
	}



}