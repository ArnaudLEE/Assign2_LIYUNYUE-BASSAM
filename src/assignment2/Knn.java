package assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class Knn  {

	static double[] ValueMea = new double[18];
static List<Measurements> MeaList = new ArrayList<Measurements>();
static List<Point> dataset =null;
static double [][] values = new double [3600][2];
static String[][] info = new String[3600][3];
static ArrayList<Measurements> TESList = new ArrayList<Measurements>();	
    //static ArrayList<String> type = new ArrayList<String>();
	//static double [][] values = new double [3600][2];
	//static String[][] info = new String[3600][3];
	static double [][] values1 = new double [360][2];
	static String[][] info1 = new String[360][3];
	//static ArrayList<ValueList> centroids = new ArrayList<ValueList>() ;
	//static ArrayList<Measurements> Shuffleused = new ArrayList<Measurements>();
	//static ArrayList<double[]> clusters = new ArrayList<double[]>();
	static List<KnnValueBean> dataArray = new ArrayList<KnnValueBean>();
	//static ArrayList<KnnValueBean> TESdataArray = new ArrayList<KnnValueBean>();
	//static ArrayList<ValueList> Clustering0 = new ArrayList<ValueList>();
	//static ArrayList<ValueList> Clustering1 = new ArrayList<ValueList>();
//	static ArrayList<ValueList> Clustering2 = new ArrayList<ValueList>();
//	static ArrayList<ValueList> Clustering3 = new ArrayList<ValueList>();
	//static double[][] ValueMea = new double[200][18];
	static double[] ValueTES = new double[18];
	//static ArrayList<ValueList> VList= new ArrayList<ValueList>();
	static List<Point> TESdataset= new ArrayList<Point>();
	
	//static ArrayList<String> typeClustering0 = new ArrayList<String>();
	//static ArrayList<String> typeClustering1 = new ArrayList<String>();
	//static ArrayList<String> typeClustering2 = new ArrayList<String>();
	
	//Declare variable to store the centroids, clusters and flower type in each cluster
	
	   
	public static void main(String[] args) throws FileNotFoundException {
	   
		String dataFile = "src/dataset/measurements.csv";
		String dataFile1 = "src/dataset/analog_values.csv";
		read_data(dataFile);
	    read_data_testing(dataFile1);
	 //   System.out.println("131  " + flowerList.get(131).param[131][0]);
		// System.out.println("7 " + flowerList.get(7).param[7][0]);
	   // System.out.printf("see if the element 0 is of the same order: %.03f \t %s \n", flowerList.get(0).param[0][0], flowerList.get(0).type[0] );
	
	  MathKNN();
	  String result = getTypeId(TESdataset.get(15), dataArray);
		System.out.println("The final result is " + result);
	
	}//end main
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void read_data(String dataFile) throws FileNotFoundException {
		dataset = new ArrayList<Point>();
		FileReader README = new FileReader(dataFile);
		BufferedReader br = null;
		String line = "";
		String SplitBy = ",";
	    
		 MeaList.clear();
		try {
			br = new BufferedReader(README);
			int init = 0;
			
			while((line = br.readLine())!= null){
				
				String[] VALUE = line.split(SplitBy);
				
				    info[init][0] = VALUE[0];
			    	info[init][1] = VALUE[1];
				    info[init][2] = VALUE[4];
					values[init][0] = Double.parseDouble(VALUE[2]);
					values[init][1] = Double.parseDouble(VALUE[3]);
					
			     	
				
				//type.add(VALUE[4]);
					// LEE, I'm computing the new array to you , one array with 200 row and 18 column, consist the voltage;
				MeaList.add(new Measurements(info,values));
				init++; 
				           
				
				
				if(init==3600){
					System.out.println("LEE, The file reading procedure is completed.");
			}
				
			
		// use code from Java exercise IV to create internal database of iris flowers
			}
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//VList.clear();
		//Shuffleused.clear();
		dataset.clear();
                      int j=0;
				      for(int a=0; a<200;a++)    {
				    	  Point point = new Point();
						for(int b=0; b<18;b++){
							
							ValueMea[b] = MeaList.get(j+b).Mvol[j+b][1];
							if(b==0){
								point.setA(ValueMea[b]);
								continue;
							}
							if(b==1){
								point.setB(ValueMea[b]);
								continue;
							}
							if(b==2){
								point.setC(ValueMea[b]);
								continue;
								
							}
							if(b==3){
								point.setD(ValueMea[b]);
								continue;
							}
							if(b==4){
								point.setE(ValueMea[b]);
								continue;
								
							}
							
							if(b==5){
								point.setF(ValueMea[b]);
								continue;
							}
							if(b==6){
								point.setG(ValueMea[b]);
								continue;
							}
							if(b==7){
								point.setH(ValueMea[b]);
								continue;
							}
							if(b==8){
								point.setI(ValueMea[b]);
								continue;
							}
							if(b==9){
								point.setJ(ValueMea[b]);
								continue;
							}
							if(b==10){
								point.setK(ValueMea[b]);
								continue;
							}
							if(b==11){
								point.setL(ValueMea[b]);
								continue;
							}
							if(b==12){
								point.setM(ValueMea[b]);
								continue;
							}
							if(b==13){
								point.setN(ValueMea[b]);
								continue;
							}
							if(b==14){
								point.setO(ValueMea[b]);
								continue;
							}
							if(b==15){
								point.setP(ValueMea[b]);
								continue;
							}
							if(b==16){
								point.setQ(ValueMea[b]);
								continue;
							}
							if(b==17){
								point.setR(ValueMea[b]);
								dataset.add(point);
								break;
							}
					      
			//System.out.println("value " + ValueMea[b]);
			
						} 
						
					//	point.setX(ValueMea);
						//dataset.add(a, point);
						//dataset.add(a, new Point(ValueMea));
						if(a!=0){
							System.out.printf("ccc %.03f \n", dataset.get(a-1).getH());
						System.out.printf("ccc %.03f \n", dataset.get(a).getH());
						System.out.println();
						}
						
					//VList.add(new ValueList(ValueMea));
					//Shuffleused.add(new ValueList(ValueMea));
				j=j+18;}
				      for(int i=0; i< dataset.size();i++){
			
			System.out.printf("I'm checking if %.03f number %d \n", dataset.get(i).getD(), i);
		}
		System.out.println("RDF ID \t     NAME \t   Time \t  Value_measurments   \t   Sub_RDFID  \t  Type ");
		
		for(int a=0;a<20;a++){
		for(Measurements M: MeaList)
		{
			
				
				System.out.printf("%s  \t  %s \t   %.03f \t   %.06f  \t  %s \n", M.Minfo[a][0], M.Minfo[a][1], M.Mvol[a][0] , M.Mvol[a][1], M.Minfo[a][2] );
			    break;
			
		}
		}
		
		
		System.out.println("sieeeee " + dataset.size());
		//System.out.println("Type");
		//for(String T: type ){
			//System.out.printf("%s \n", T );
		//}
		// populate the values array and the type list from the above created database  
		
		
	}
	
	
	
	
	public Map<Point,List<Point>> kcluster(int k){
		Map<Point, List<Point>> nowClusterCenterMap = new HashMap<Point, List<Point>>();
		//Map<Point, ArrayList<Point>> lastClusterCenterMap = new HashMap<Point, ArrayList<Point>>();
		for(int i=0; i<k; i++){
			Random random = new Random();
			System.out.println("print size of the dataset " + dataset.size());
			int num = random.nextInt(dataset.size());
			System.out.println("The numero de centre point est: " + num);
			nowClusterCenterMap.put(dataset.get(num), new ArrayList<Point>());
			//lastClusterCenterMap.put(dataset.get(num+random.nextInt(20)), new ArrayList<Point>());
			
		}
		Map<Point,List<Point>> lastClusterCenterMap = null;
	System.out.println("Ck");
		while(true){
			for(Point point : dataset){
				double shortest = Double.MAX_VALUE;
				Point key = null;
				for(Entry<Point , List<Point>> entry : nowClusterCenterMap.entrySet()){
					double distance = distance(point, entry.getKey());
					if(distance < shortest){
						shortest = distance;
						key = entry.getKey();
					}
				}
				nowClusterCenterMap.get(key).add(point);
			}
			if(isEqualCenter(lastClusterCenterMap, nowClusterCenterMap)){
				break;
			}
			lastClusterCenterMap = nowClusterCenterMap;
			nowClusterCenterMap = new HashMap<Point, List<Point>>();
			for(Entry<Point, List<Point>> entry : lastClusterCenterMap.entrySet()){
				nowClusterCenterMap.put(getNewCenterPoint(entry.getValue()), new ArrayList<Point>());
			}
		
		
		
		}
		System.out.println("well");
		
		return nowClusterCenterMap;
		
		
	}
	
	
	private double distance(Point point1, Point point2){
		double distance = 0.0;
		double distance00 = 0.0;
		//double[] difference1 = new double[18]; 
		//double[] p1 = new double[18];
		//double[] p2 = new double[18];
		//p1 = point1.getX();
		//p2 = point2.getX();
		//for(int i=0; i<18; i++){
			
			//difference1[i] = p1[i] - p2[i];
			//distance = distance + Math.pow(difference1[i], 2);
		//}distance = Math.sqrt(distance);
		
		distance = distance + Math.pow((point1.getA()*Math.cos(Math.toRadians(point1.getB())) - point2.getA()* Math.cos(Math.toRadians(point2.getB()))), 2);
		distance = distance + Math.pow((point1.getA()*Math.sin(Math.toRadians(point1.getB())) - point2.getA()* Math.sin(Math.toRadians(point2.getB()))), 2);
		//distance = distance + Math.pow((point1.getB() - point2.getB()), 2);
		
		distance = distance + Math.pow((point1.getC()*Math.cos(Math.toRadians(point1.getD())) - point2.getC()* Math.cos(Math.toRadians(point2.getD()))), 2);
		distance = distance + Math.pow((point1.getC()*Math.sin(Math.toRadians(point1.getD())) - point2.getC()* Math.sin(Math.toRadians(point2.getD()))), 2);
		//distance = distance + Math.pow((point1.getD() - point2.getD()), 2);
		
		distance = distance + Math.pow((point1.getE()*Math.cos(Math.toRadians(point1.getF())) - point2.getE()* Math.cos(Math.toRadians(point2.getF()))), 2);
		distance = distance + Math.pow((point1.getE()*Math.sin(Math.toRadians(point1.getF())) - point2.getE()* Math.sin(Math.toRadians(point2.getF()))), 2);
		//distance = distance + Math.pow((point1.getF() - point2.getF()), 2);
		
		distance = distance + Math.pow((point1.getG()*Math.cos(Math.toRadians(point1.getH())) - point2.getG()* Math.cos(Math.toRadians(point2.getH()))), 2);
		distance = distance + Math.pow((point1.getG()*Math.sin(Math.toRadians(point1.getH())) - point2.getG()* Math.sin(Math.toRadians(point2.getH()))), 2);
		//distance = distance + Math.pow((point1.getH() - point2.getH()), 2);
		
		distance = distance + Math.pow((point1.getI()*Math.cos(Math.toRadians(point1.getJ())) - point2.getI()* Math.cos(Math.toRadians(point2.getJ()))), 2);
		distance = distance + Math.pow((point1.getI()*Math.sin(Math.toRadians(point1.getJ())) - point2.getI()* Math.sin(Math.toRadians(point2.getJ()))), 2);	
		//distance = distance + Math.pow((point1.getJ() - point2.getJ()), 2);
		
		distance = distance + Math.pow((point1.getK()*Math.cos(Math.toRadians(point1.getL())) - point2.getK()* Math.cos(Math.toRadians(point2.getL()))), 2);
		distance = distance + Math.pow((point1.getK()*Math.sin(Math.toRadians(point1.getL())) - point2.getK()* Math.sin(Math.toRadians(point2.getL()))), 2);	
		//distance = distance + Math.pow((point1.getL() - point2.getL()), 2);
		
		distance = distance + Math.pow((point1.getM()*Math.cos(Math.toRadians(point1.getN())) - point2.getM()* Math.cos(Math.toRadians(point2.getN()))), 2);
		distance = distance + Math.pow((point1.getM()*Math.sin(Math.toRadians(point1.getN())) - point2.getM()* Math.sin(Math.toRadians(point2.getN()))), 2);
		//distance = distance + Math.pow((point1.getN() - point2.getN()), 2);
		
		distance = distance + Math.pow((point1.getO()*Math.cos(Math.toRadians(point1.getP())) - point2.getO()* Math.cos(Math.toRadians(point2.getP()))), 2);
		distance = distance + Math.pow((point1.getO()*Math.sin(Math.toRadians(point1.getP())) - point2.getO()* Math.sin(Math.toRadians(point2.getP()))), 2);
	    //distance = distance + Math.pow((point1.getP() - point2.getP()), 2);
		
		distance = distance + Math.pow((point1.getQ()*Math.cos(Math.toRadians(point1.getR())) - point2.getQ()* Math.cos(Math.toRadians(point2.getR()))), 2);
		distance = distance + Math.pow((point1.getQ()*Math.sin(Math.toRadians(point1.getR())) - point2.getQ()* Math.sin(Math.toRadians(point2.getR()))), 2);
		//distance = distance + Math.pow((point1.getR() - point2.getR()), 2);
		
		distance00 = Math.sqrt(distance);
		
		return distance00;
	}
	
	
	
	private boolean isEqualCenter(Map<Point, List<Point>> lastClusterCenterMap, Map<Point, List<Point>> nowClusterCenterMap){

		if(lastClusterCenterMap == null){
			return false;
		}else {
			Point[] k1 = new Point[4];
			    int i =0;
				for (Entry<Point, List<Point>> entry : lastClusterCenterMap.entrySet()){
				k1[i] = entry.getKey();
				i++;
				
			}
			
			
			Point[] k2 = new Point[4];
			int j=0;
				for (Entry<Point, List<Point>> entry : nowClusterCenterMap.entrySet()){
				k2[j] = entry.getKey();
				j++;
			}
			
			
			if(distance(k1[0],k2[0]) >0.0000001 || distance(k1[1],k2[1])>0.0000001 || distance(k1[2],k2[2]) >0.0000001 ||  distance(k1[3],k2[3]) >0.0000001     ){
				return false;
			}
			//System.out.println();
			/*Point[] pp = (Point[]) lastClusterCenterMap.keySet().toArray();
			Point[] ppy = (Point[]) nowClusterCenterMap.keySet().toArray();
			double[] pp1 = new double[18];
			for(int i=0; i<4;i++){
				for(int j=0; j<18;j++){
					
				}
			}*/
			
			
			/*for (Entry<Point, List<Point>> entry : lastClusterCenterMap.entrySet()){
				if(! nowClusterCenterMap.containsKey(entry.getKey())){
					return false;
				}
			}*/
		}
		return true;
		
		
		
	}
	
	
	
	
	
	private Point getNewCenterPoint (List<Point> value){
		/*double[] sum = new double[18];
		for(int i=0; i<18;i++){
			sum[i]=0.0;
		}
		double[] p = new double[18];
		
		for(Point point : value){
			p = point.getX();
		for(int j=0; j<18;j++){
			sum[j] = sum[j] + p[j];
		}
			
		}
		//Point point = new Point();
		for(int i=0; i<18; i++){
			sum[i] = sum[i]/ value.size();
		}
		Point point = new Point();
		return point;*/
		
		double sumA=0.0;
		double sumB=0.0;
		double sumC=0.0;
		double sumD=0.0;
		double sumE=0.0;
		double sumF=0.0;
		double sumG=0.0;
		double sumH=0.0;
		double sumI=0.0;
		double sumJ=0.0;
		double sumK=0.0;
		double sumL=0.0;
		double sumM=0.0;
		double sumN=0.0;
		double sumO=0.0;
		double sumP=0.0;
		double sumQ=0.0;
		double sumR=0.0;
		for(Point point : value){
			sumA = sumA + point.getA();
			sumB = sumB + point.getB();
			sumC = sumC + point.getC();
			sumD = sumD + point.getD();
			sumE = sumE + point.getE();
			sumF = sumF + point.getF();
			sumG = sumG + point.getG();
			sumH = sumH + point.getH();
			sumI = sumI + point.getI();
			sumJ = sumJ + point.getJ();
			sumK = sumK + point.getK();
			sumL = sumL + point.getL();
			sumM = sumM + point.getM();
			sumN = sumN + point.getN();
			sumO = sumO + point.getO();
			sumP = sumP + point.getP();
			sumQ = sumQ + point.getQ();
			sumR = sumR + point.getR();
			
			
		}
		Point point = new Point();
		point.setA(sumA / (double)value.size());
		point.setB(sumB / (double)value.size());
		point.setC(sumC / (double)value.size());
		point.setD(sumD / (double)value.size());
		point.setE(sumE / (double)value.size());
		point.setF(sumF / (double)value.size());
		point.setG(sumG / (double)value.size());
		point.setH(sumH / (double)value.size());
		point.setI(sumI / (double)value.size());
		point.setJ(sumJ / (double)value.size());
		point.setK(sumK / (double)value.size());
		point.setL(sumL / (double)value.size());
		point.setM(sumM / (double)value.size());
		point.setN(sumN / (double)value.size());
		point.setO(sumO / (double)value.size());
		point.setP(sumP / (double)value.size());
		point.setQ(sumQ / (double)value.size());
		point.setR(sumR / (double)value.size());
		
		
		return point;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public static void read_data_testing(String dataFile1) throws FileNotFoundException {
			
			FileReader README1 = new FileReader(dataFile1);
			BufferedReader br1 = null;
			String line1 = "";
			String SplitBy1 = ",";
		    
			 MeaList.clear();
			try {
				br1 = new BufferedReader(README1);
				int init = 0;
				
				while((line1 = br1.readLine())!= null){
					
					String[] VALUE1 = line1.split(SplitBy1);
					
					    info1[init][0] = VALUE1[0];
				    	info1[init][1] = VALUE1[1];
					    info1[init][2] = VALUE1[4];
						values1[init][0] = Double.parseDouble(VALUE1[2]);
						values1[init][1] = Double.parseDouble(VALUE1[3]);
						
				     	
					
					//type.add(VALUE[4]);
						// LEE, I'm computing the new array to you , one array with 55 row and 18 column, consist the voltage;
					TESList.add(new Measurements(info1,values1));
					init++; 
					           
					
					
					if(init==360){
						System.out.println("LEE, The file reading procedure is completed.");
				}
					
				
			// use code from Java exercise IV to create internal database of iris flowers
				}
				} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			TESdataset.clear();
            int j=0;
		      for(int a=0; a<20;a++)    {
		    	  Point point = new Point();
				for(int b=0; b<18;b++){
					
					ValueTES[b] = TESList.get(j+b).Mvol[j+b][1];
					if(b==0){
						point.setA(ValueTES[b]);
						continue;
					}
					if(b==1){
						point.setB(ValueTES[b]);
						continue;
					}
					if(b==2){
						point.setC(ValueTES[b]);
						continue;
						
					}
					if(b==3){
						point.setD(ValueTES[b]);
						continue;
					}
					if(b==4){
						point.setE(ValueTES[b]);
						continue;
						
					}
					
					if(b==5){
						point.setF(ValueTES[b]);
						continue;
					}
					if(b==6){
						point.setG(ValueTES[b]);
						continue;
					}
					if(b==7){
						point.setH(ValueTES[b]);
						continue;
					}
					if(b==8){
						point.setI(ValueTES[b]);
						continue;
					}
					if(b==9){
						point.setJ(ValueTES[b]);
						continue;
					}
					if(b==10){
						point.setK(ValueTES[b]);
						continue;
					}
					if(b==11){
						point.setL(ValueTES[b]);
						continue;
					}
					if(b==12){
						point.setM(ValueTES[b]);
						continue;
					}
					if(b==13){
						point.setN(ValueTES[b]);
						continue;
					}
					if(b==14){
						point.setO(ValueTES[b]);
						continue;
					}
					if(b==15){
						point.setP(ValueTES[b]);
						continue;
					}
					if(b==16){
						point.setQ(ValueTES[b]);
						continue;
					}
					if(b==17){
						point.setR(ValueTES[b]);
						TESdataset.add(point);
						break;
					}
			      
	//System.out.println("value " + ValueMea[b]);
	
				} 
				
			//	point.setX(ValueMea);
				//dataset.add(a, point);
				//dataset.add(a, new Point(ValueMea));
				if(a!=0){
					System.out.printf("ccc %.03f \n", TESdataset.get(a-1).getH());
				System.out.printf("ccc %.03f \n", TESdataset.get(a).getH());
				System.out.println();
				}
				
			//VList.add(new ValueList(ValueMea));
			//Shuffleused.add(new ValueList(ValueMea));
		j=j+18;}
			
		}
		
		public static void MathKNN(){
			 Knn Kmeans2 = new Knn();
			    System.out.println("give a try");
			    
			    
			    Map<Point,List<Point>> result1 = Kmeans2.kcluster(4);
			    System.out.println("works");
			    
			dataArray.clear();
			int j=0;
			for(Entry<Point, List<Point>> entry : result1.entrySet()){
				if(j==0){
					for(int i=0; i< entry.getValue().size();i++){
					dataArray.add(new KnnValueBean(entry.getValue().get(i), "TYPEE0"  ));
				}
					j++;
					continue;
				}
				if(j==1){
					for(int i=0; i< entry.getValue().size();i++){
						dataArray.add(new KnnValueBean(entry.getValue().get(i), "TYPEE1"  ));
					}
					j++;
					continue;
				}
				if(j==2){
					for(int i=0; i< entry.getValue().size();i++){
					dataArray.add(new KnnValueBean(entry.getValue().get(i), "TYPEE2"  ));
				}
					j++;
					continue;
				}
				if(j==3){
					for(int i=0; i< entry.getValue().size();i++){
						dataArray.add(new KnnValueBean(entry.getValue().get(i), "TYPEE3"  ));
					}
					
					break;
				}
				
			}
			
		}
		
		
				
					
				

			
			
			
		
		
		public static double SimilarScore(Point point11, Point point22){
			double Score =0.0 ;
			double distance0 = 0.0;
			double distance000 = 0.0;
			//double[] difference1 = new double[18]; 
			//double[] p1 = new double[18];
			//double[] p2 = new double[18];
			//p1 = point1.getX();
			//p2 = point2.getX();
			//for(int i=0; i<18; i++){
				
				//difference1[i] = p1[i] - p2[i];
				//distance = distance + Math.pow(difference1[i], 2);
			//}distance = Math.sqrt(distance);
			
			distance0 = distance0 + Math.pow((point11.getA()*Math.cos(Math.toRadians(point11.getB())) - point22.getA()* Math.cos(Math.toRadians(point22.getB()))), 2);
			distance0 = distance0 + Math.pow((point11.getA()*Math.sin(Math.toRadians(point11.getB())) - point22.getA()* Math.sin(Math.toRadians(point22.getB()))), 2);
			//distance = distance + Math.pow((point1.getB() - point2.getB()), 2);
			
			distance0 = distance0 + Math.pow((point11.getC()*Math.cos(Math.toRadians(point11.getD())) - point22.getC()* Math.cos(Math.toRadians(point22.getD()))), 2);
			distance0 = distance0 + Math.pow((point11.getC()*Math.sin(Math.toRadians(point11.getD())) - point22.getC()* Math.sin(Math.toRadians(point22.getD()))), 2);
			//distance = distance + Math.pow((point1.getD() - point2.getD()), 2);
			
			distance0 = distance0 + Math.pow((point11.getE()*Math.cos(Math.toRadians(point11.getF())) - point22.getE()* Math.cos(Math.toRadians(point22.getF()))), 2);
			distance0 = distance0 + Math.pow((point11.getE()*Math.sin(Math.toRadians(point11.getF())) - point22.getE()* Math.sin(Math.toRadians(point22.getF()))), 2);
			//distance = distance + Math.pow((point1.getF() - point2.getF()), 2);
			
			distance0 = distance0 + Math.pow((point11.getG()*Math.cos(Math.toRadians(point11.getH())) - point22.getG()* Math.cos(Math.toRadians(point22.getH()))), 2);
			distance0 = distance0 + Math.pow((point11.getG()*Math.sin(Math.toRadians(point11.getH())) - point22.getG()* Math.sin(Math.toRadians(point22.getH()))), 2);
			//distance = distance + Math.pow((point1.getH() - point2.getH()), 2);
			
			distance0 = distance0 + Math.pow((point11.getI()*Math.cos(Math.toRadians(point11.getJ())) - point22.getI()* Math.cos(Math.toRadians(point22.getJ()))), 2);
			distance0 = distance0 + Math.pow((point11.getI()*Math.sin(Math.toRadians(point11.getJ())) - point22.getI()* Math.sin(Math.toRadians(point22.getJ()))), 2);	
			//distance = distance + Math.pow((point1.getJ() - point2.getJ()), 2);
			
			distance0 = distance0 + Math.pow((point11.getK()*Math.cos(Math.toRadians(point11.getL())) - point22.getK()* Math.cos(Math.toRadians(point22.getL()))), 2);
			distance0 = distance0 + Math.pow((point11.getK()*Math.sin(Math.toRadians(point11.getL())) - point22.getK()* Math.sin(Math.toRadians(point22.getL()))), 2);	
			//distance = distance + Math.pow((point1.getL() - point2.getL()), 2);
			
			distance0 = distance0 + Math.pow((point11.getM()*Math.cos(Math.toRadians(point11.getN())) - point22.getM()* Math.cos(Math.toRadians(point22.getN()))), 2);
			distance0 = distance0 + Math.pow((point11.getM()*Math.sin(Math.toRadians(point11.getN())) - point22.getM()* Math.sin(Math.toRadians(point22.getN()))), 2);
			//distance = distance + Math.pow((point1.getN() - point2.getN()), 2);
			
			distance0 = distance0 + Math.pow((point11.getO()*Math.cos(Math.toRadians(point11.getP())) - point22.getO()* Math.cos(Math.toRadians(point22.getP()))), 2);
			distance0 = distance0 + Math.pow((point11.getO()*Math.sin(Math.toRadians(point11.getP())) - point22.getO()* Math.sin(Math.toRadians(point22.getP()))), 2);
		    //distance = distance + Math.pow((point1.getP() - point2.getP()), 2);
			
			distance0 = distance0 + Math.pow((point11.getQ()*Math.cos(Math.toRadians(point11.getR())) - point22.getQ()* Math.cos(Math.toRadians(point22.getR()))), 2);
			distance0 = distance0 + Math.pow((point11.getQ()*Math.sin(Math.toRadians(point11.getR())) - point22.getQ()* Math.sin(Math.toRadians(point22.getR()))), 2);
			//distance = distance + Math.pow((point1.getR() - point2.getR()), 2);
			
			distance000 = Math.sqrt(distance0);
			Score = -1 * distance000; 
			return Score;
			
		}
		
		
		
		public static KnnValueSort[] getKType(Point p11, List<KnnValueBean> test){
			double SCORE = 0.0 ;
			int K = 4 ;
			int k=0;
			KnnValueSort[] topK = new KnnValueSort[K];
			for(int i=0; i<200; i++){
				SCORE = SimilarScore(p11, test.get(i).getPoint());
			if (k==0){
				topK[k] = new KnnValueSort(SCORE, dataArray.get(i).type);
				k++;
			} else{
				if(!(k==K && SCORE < topK[k-1].getScore())){
				int f=0;
				for(; f < k && SCORE < topK[f].getScore() ; f++);
				int j = k-1;
				if( k < K) {
					j = k;
					k++;
				}
				for(; j> f; j--){
					topK[j] = topK[j-1];
				}
				topK[f] = new KnnValueSort(SCORE, dataArray.get(i).type);
				
				}
			}
			
			
			
			
			
			}return topK; 
		}
		
		
		public static String getTypeId( Point point111, List<KnnValueBean> test1 ){
			KnnValueSort[] Arrayfinal = getKType(point111, test1);
			HashMap<String, Integer> map = new HashMap<String, Integer>(4);
			for (KnnValueSort bean : Arrayfinal){
				if(bean != null){
					if(map.containsKey(bean.getTypeId())){
						map.put(bean.getTypeId(), map.get(bean.getTypeId()) + 1 );
					}else {
						map.put(bean.getTypeId(), 1);
					}
				}
			}
			String maxTypeId = null;
			int maxCount = 0;
			Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
			while (iter.hasNext()){
				Entry<String, Integer> entry = iter.next();
				if(maxCount < entry.getValue()){
					maxCount = entry.getValue();
					maxTypeId = entry.getKey();
				}
			}
			return maxTypeId;
		}
		
		
		
		
		
		
		
}
