package assignment2;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.Random; 
import java.util.Set;
public class KMeeeeeeeens {

	 static List<Point> dataset =null;

	static ArrayList<Measurements> MeaList = new ArrayList<Measurements>();
	 
    //static ArrayList<String> type = new ArrayList<String>();
	static double [][] values = new double [3600][2];
	static String[][] info = new String[3600][3];
	static ArrayList<ValueList> centroids = new ArrayList<ValueList>() ;
	static ArrayList<ValueList> Shuffleused = new ArrayList<ValueList>();
	//static ArrayList<double[]> clusters = new ArrayList<double[]>();
	
	static ArrayList<ValueList> Clustering0 = new ArrayList<ValueList>();
	static ArrayList<ValueList> Clustering1 = new ArrayList<ValueList>();
	static ArrayList<ValueList> Clustering2 = new ArrayList<ValueList>();
	static ArrayList<ValueList> Clustering3 = new ArrayList<ValueList>();
	static double[] ValueMea = new double[18];
	static ArrayList<ValueList> VList= new ArrayList<ValueList>();
	
	//static ArrayList<String> typeClustering0 = new ArrayList<String>();
	//static ArrayList<String> typeCluster
	
	
	//This method is used for reading data from the excel file. 
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
		//Now I'm storing the data from the arraylist 'MeaList' to list dataset, at this point, I only store the measuring data, not other info,
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
					      
			
			
						} 
						
					
						////////////////////////////////////////////////check point 
					/*	if(a!=0){
							System.out.printf("ccc %.03f \n", dataset.get(a-1).getH());
						System.out.printf("ccc %.03f \n", dataset.get(a).getH());
						System.out.println();
						}*/
						
					
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
		
		/////////////////////Check point
		//System.out.println("Type");
		//for(String T: type ){
			//System.out.printf("%s \n", T );
		//}
		// populate the values array and the type list from the above created database  
		
		
	}
	
	
	
	//////This method is used for clustering the group of points in the learning set, with the help of other function defined below.
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
	
	// THis function used to calculate the distance between two points, we considered the difference of the physical quantity between magnitude  and the angle 
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
	
	
	//This one used for determine when the loop for clustering could be finished.
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
			
			
			if(distance(k1[0],k2[0]) >0.1 || distance(k1[1],k2[1])>0.1 || distance(k1[2],k2[2]) >0.1 ||  distance(k1[3],k2[3]) >0.1     ){
				return false;
			}
			
			//////////////Check point 
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
	
	
	
	
	// In the case that need to re-do clustering, we first calculate the new center point
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
	
	
	//The main function, here we print out the following four cluster with the correspoinding points inside.
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
	String dataFile = "src/dataset/measurements.csv";
		
	    read_data(dataFile);
	    
	    KMeeeeeeeens Kmeans1 = new KMeeeeeeeens();
	    System.out.println("give a try");
	    
	    
	    Map<Point,List<Point>> result = Kmeans1.kcluster(4);
	    System.out.println("works");
	    
	        int a=0;
	    	for(Entry<Point, List<Point>> entry : result.entrySet()){
	    		
	    		System.out.println("=====+++++++=Cluster center is: " + entry.getKey().getD() + "=========size is: " +   entry.getValue().size());
	    		
	    		System.out.println("Clar_VON \t Clar_ANG \t Amhe_VON \t Amhe_ANG \t Winl_VOLT \t Winl_ANG \t Bowm_VOLT \t Bowm_ANG \t Troy_VOLT \t Troy_ANG \t Mapl_VOLT  \t Mapl_ANG \t Gran_VOLT \t Gran_ANG \t WAUT_VOLT \t WAUT_ANG \t CROSS_VOLT \t Cross_ANG   ");
	    	if(a==0){
	    		System.out.println("===============CLASS 0====================");
	    		for(int i=0; i<entry.getValue().size();i++){
	    		
	    			System.out.printf("%.03f \t \t  %.03f \t %.03f \t \t %.03f \t    %.03f \t    %.03f \t %.03f \t \t  %.03f \t %.03f \t \t  %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t \n" , entry.getValue().get(i).getA(), entry.getValue().get(i).getB(), entry.getValue().get(i).getC(), entry.getValue().get(i).getD(), entry.getValue().get(i).getE(), entry.getValue().get(i).getF(), entry.getValue().get(i).getG(), entry.getValue().get(i).getH(),entry.getValue().get(i).getI(), entry.getValue().get(i).getJ(), entry.getValue().get(i).getK(), entry.getValue().get(i).getL(), entry.getValue().get(i).getM(), entry.getValue().get(i).getN(), entry.getValue().get(i).getO(), entry.getValue().get(i).getP(), entry.getValue().get(i).getQ(), entry.getValue().get(i).getR() );
	    		    
	    		}System.out.println("=======CLASS 0 Complete=======================");
	    		    System.out.println(" ");
	    	}
	    	if(a==1){
	    		System.out.println("===============CLASS 1====================");
	    		for(int i=0; i<entry.getValue().size();i++){
	    		
	    			System.out.printf("%.03f \t \t  %.03f \t %.03f \t \t %.03f \t    %.03f \t    %.03f \t %.03f \t \t  %.03f \t %.03f \t \t  %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t \n" , entry.getValue().get(i).getA(), entry.getValue().get(i).getB(), entry.getValue().get(i).getC(), entry.getValue().get(i).getD(), entry.getValue().get(i).getE(), entry.getValue().get(i).getF(), entry.getValue().get(i).getG(), entry.getValue().get(i).getH(),entry.getValue().get(i).getI(), entry.getValue().get(i).getJ(), entry.getValue().get(i).getK(), entry.getValue().get(i).getL(), entry.getValue().get(i).getM(), entry.getValue().get(i).getN(), entry.getValue().get(i).getO(), entry.getValue().get(i).getP(), entry.getValue().get(i).getQ(), entry.getValue().get(i).getR() );
	    		}  System.out.println("=======CLASS 1 Complete=============================");
    		    System.out.println(" ");
	    	}
	    	if(a==2){
	    		System.out.println("===============CLASS 2====================");
	    		for(int i=0; i<entry.getValue().size();i++){
	    		
	    			System.out.printf("%.03f \t \t  %.03f \t %.03f \t \t %.03f \t    %.03f \t    %.03f \t %.03f \t \t  %.03f \t %.03f \t \t  %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t \n" , entry.getValue().get(i).getA(), entry.getValue().get(i).getB(), entry.getValue().get(i).getC(), entry.getValue().get(i).getD(), entry.getValue().get(i).getE(), entry.getValue().get(i).getF(), entry.getValue().get(i).getG(), entry.getValue().get(i).getH(),entry.getValue().get(i).getI(), entry.getValue().get(i).getJ(), entry.getValue().get(i).getK(), entry.getValue().get(i).getL(), entry.getValue().get(i).getM(), entry.getValue().get(i).getN(), entry.getValue().get(i).getO(), entry.getValue().get(i).getP(), entry.getValue().get(i).getQ(), entry.getValue().get(i).getR() );
	    		}
	    		System.out.println("=======CLASS 2 Complete============================");
    		    System.out.println(" ");
	    	}
	    	if(a==3){
	    		System.out.println("===============CLASS 3====================");
	    		for(int i=0; i<entry.getValue().size();i++){
	    		
	    			System.out.printf("%.03f \t \t  %.03f \t %.03f \t \t %.03f \t    %.03f \t    %.03f \t %.03f \t \t  %.03f \t %.03f \t \t  %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t %.03f \t \t %.03f \t \n" , entry.getValue().get(i).getA(), entry.getValue().get(i).getB(), entry.getValue().get(i).getC(), entry.getValue().get(i).getD(), entry.getValue().get(i).getE(), entry.getValue().get(i).getF(), entry.getValue().get(i).getG(), entry.getValue().get(i).getH(),entry.getValue().get(i).getI(), entry.getValue().get(i).getJ(), entry.getValue().get(i).getK(), entry.getValue().get(i).getL(), entry.getValue().get(i).getM(), entry.getValue().get(i).getN(), entry.getValue().get(i).getO(), entry.getValue().get(i).getP(), entry.getValue().get(i).getQ(), entry.getValue().get(i).getR() );
	    		}
	    		System.out.println("=======CLASS 3 Complete==================================");
    		    System.out.println(" ");
	    	}
	    	a++;
	    		
	    		/*for(int j=0; j<entry.getValue().size();j++){
	    			System.out.println("======Cluster center is: " + entry.getKey() + "=========size is: " +   entry.getValue().size());
	    	    	
	    		}*/
	    	
	    		//System.out.println("======Cluster center is: " + entry.getKey().Va[i][12] + "=========size is: " +  entry.getValue().size());
	    //	System.out.println("==============================");
	    		
	    }
	    
	    
	    
	}

}
