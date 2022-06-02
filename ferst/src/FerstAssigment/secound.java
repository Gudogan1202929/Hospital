package FerstAssigment;
import java.util.*;

public class secound {
	
	public static void main(String[] args) {
		
		double[][] hospitall;
		int d=0,t=0;
		double c;
		//c is a reading the temperature celsius
		//t is tall of collom
		//number of day is d
		
		Scanner input = new Scanner(System.in);
		System.out.println("please enter num of day : ");
		d= input.nextInt();
		hospitall= new double[d][];
		
		double[] variables = new double[3];
		double[] cantBelow = new double[2];
		
		//to now how tall colloms
			for (int i = 0; i < hospitall.length; i++) {
				System.out.print("please enter num of time of reading the temperaturein celsius : ");
				t= input.nextInt();
				hospitall[i] = new double[t];
			}
			
			for (int i = 0; i < hospitall.length; i++) {
		
				for (int j = 0 ; j < hospitall[i].length;j++) {
					
					System.out.print("please enter reading day  "+i +" the temperaturein celsius");
					//to save reading
					c = input.nextDouble();
					if (c<30 || c>45) {
						System.out.println("there is erorre");
						//chiking
						break;
					}
					else 
						hospitall[i][j]=c;
				}
				
			}
			
			// print array befort sortting 
			for (int i = 0; i < hospitall.length; i++) {
				for (int j = 0; j < hospitall[i].length; j++) {
					System.out.print(" before sorrting : ");
					System.out.print("day : "+i +" is : "+hospitall[i][j]);
				}
				System.out.println("\n");
			}
			
			MaxMinAvg (variables , hospitall);
			cantBelowAboveAvg (cantBelow , hospitall,variables);
			sortArray (hospitall);
			printArray (hospitall);
			boolean b = leaveHospitall (hospitall,t,d);
			//t is number  of reading
			// d is num of day
			
			if (b==true) {
				System.out.println("yas he\she can leave");
			}
			else 
				System.out.println("no he\she cannot");
			
			//0 is index to max
			System.out.println("max is : "+variables[0]);
			//1 is index to min
			System.out.println("min is : "+variables[1]);
			//2 is index of avg
			System.out.println("avg is : "+variables[2]);

			
			
		
	}
	public static void MaxMinAvg (double[] variables , double[][] hospitall ) {
		
		double max =0;
			for (int i = 0; i < hospitall.length; i++) {
				for (int j = 0; j < hospitall[i].length; j++) {
					if (hospitall[i][j]>max) {
						max = hospitall[i][j];
						variables[0] = max ;
						//0 is index to max
						
					}
				}
			}
			
			double min = hospitall[0][0];
			
			for (int i = 0; i < hospitall.length; i++) {
				for (int j = 0; j < hospitall[i].length; j++) {
					if (hospitall[i][j]<min) {
						min = hospitall[i][j];
						variables[1] = min ;
						//1 is index to min
					}
				}
			}
			
			double avg=0,sum=0;
			int count=0;
			
			for (int i = 0; i < hospitall.length; i++) {
				for (int j = 0; j < hospitall[i].length; j++) {
					sum += hospitall[i][j];
					count++;
				}
			}
			avg = sum/count;
			variables[2] = avg;
			//2 is index of avg
			
	     }
	public static void cantBelowAboveAvg (double cantBelow[] ,double hospitall[][],double variables[]){
		
		double underAvg=0,upAvg=0;
		
		for (int i = 0; i < hospitall.length; i++) {
			for (int j = 0; j < hospitall[i].length; j++) {
				if (variables[2]>=hospitall[i][j]) {
					underAvg++;
				}
				else 
					upAvg++;
			}
		}
		cantBelow[0]=underAvg;
				//0 is index of under or equal avg
			System.out.println("number of temporat ");
		
		cantBelow[1]=upAvg;
				//1 is index of up avg
	}
	
	public static void sortArray (double[][] hospitall) {
		double temb=0;
		
		for (int i = 0; i < hospitall.length; i++) {
			for (int j = 0; j < (hospitall[i].length-1); j++) {
				
				for(int k=j+1;k<(hospitall[i].length);k++) {
					
					if (hospitall[i][k]<hospitall[i][j]) {
						
						temb = hospitall[i][k];
						hospitall[i][k]=hospitall[i][j];
						hospitall[i][j]=temb;
						
					}
					
				}
				
			}
			
		}
	}
	
	public static void printArray (double [][]hospitall){
		
		for (int i = 0; i < hospitall.length; i++) {
			for (int j = 0; j < hospitall[i].length; j++) {
				System.out.print(" after sorrting : ");
				System.out.print("day : "+i +" is : "+hospitall[i][j]);
				
			}
			System.out.println("\n");
		}
	}
	
	public static boolean leaveHospitall (double[][] hospitall , int t, int d) {
		double avg=0;
		
		avg = ((hospitall[d-1][t-1]+hospitall[d-1][t-2])/2);
		// t-1 and t-2 anf d-1 its because t is number of tall collom not index and d not num of day not index
		
		if (avg<35.5 || avg > 36.5) {
			return false;
		}
		else 
			return true;
	  }
	}


	
