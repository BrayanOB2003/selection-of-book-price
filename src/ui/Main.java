package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public final static String SEPARATOR = " ";
	
	private static int[] parseAndSortArray(String[] arrayOrigin, int N) {
		int[] newArray = new int[N];
		
		for(int i = 0; i < N; i++) {
			newArray[i]=Integer.parseInt(arrayOrigin[i]);
		}
		
		Arrays.sort(newArray);
		
		return newArray;
	}
	
	public static String binarySearch(int[] array, int M) {
		String out = "";
			
		int miniDifference = M;
		int a = 0;
		int b = 0;
		
		int i = 0;
		int j = 0;
		for(int k = 0; k < array.length; k++ ) {
			
			i = k;
			j = array.length-1;
			
			int m = (k+j)/2;
			
			if(array[k] + array[m] != M) {
				
				while(i < j && array[k] + array[m] != M) {
					m = (i+j)/2;
					
					if(array[k] + array[m] == M) {
						if(array[m]-array[k] < miniDifference) {
							miniDifference = array[m]-array[k];
							a = array[k];
							b = array[m];							
						}						
					} else if(array[k] + array[m] > M) {
						j = m - 1;
					} else {
						i = m + 1;
					}			
				}
				
			}	else {
				miniDifference = array[m]-array[k];
				a = array[k];
				b = array[m];
			}
			
		}
		
		out += "Peter should buy books whose prices are " + a +" and " + b + ".\n";
			
		return out;
	}
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String line;
		 
		 do{
			 int N = Integer.parseInt(br.readLine());	 
			 int[] booksPrice = parseAndSortArray(br.readLine().split(" "), N);
			 int M = Integer.parseInt(br.readLine());
			 
			 bw.write(binarySearch(booksPrice, M));
			 
			 line = br.readLine(); 
			 
		 }while(line != null);
		 
		 br.close();
		 bw.close();
	}

}
