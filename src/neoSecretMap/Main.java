package neoSecretMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr1[][] = new int[N][N];
		int arr2[][] = new int[N][N];
		int resultarr[][] = new int[N][N];
		
		for(int i = 0 ; i<N ; i++) {
			arr1[i][N-1] = Integer.parseInt(br.readLine()); //[i][N-1]에 암호 저장
		}
		
		for(int i = 0 ; i<N ; i++) {
			arr2[i][N-1] = Integer.parseInt(br.readLine());
		}
	
		br.close();
		

		arr1 = toBinary(arr1, N);
		arr2 = toBinary(arr2, N);
		resultarr = toMakearr(arr1, arr2, resultarr);
		
		for(int i = 0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++) {
				bw.write(printStr(resultarr[i][j]));
			}
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}

	private static String printStr(int resultarr) {
		if(resultarr == 0 )
			return " ";
		else
			return "#";
	}

	private static int[][] toMakearr(int[][] arr1, int[][] arr2, int [][] resultarr) {
		for(int i = 0 ; i < arr1.length ; i++) {
			for(int j = 0 ; j< arr1[i].length ; j++) {
				if(arr1[i][j] == 1 || arr2[i][j] == 1)
					resultarr[i][j] = 1;
				else
					resultarr[i][j] = 0 ;
			}
		}
				
		return resultarr;
	}

	private static int[][] toBinary(int arr[][], int N) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<arr.length ; i++) { 
			/*
			 * 쉬프트한 정수를 이진수로 변환하여 하나씩 배열에 넣음
			 */
			int input0 = N-Integer.toBinaryString(arr[i][N-1]).length(); //배열길이와 이진수 길이의 차 
			String binarystr = Integer.toBinaryString(arr[i][N-1]);
			if(input0 >0) {
				for(int k = 0 ; k<input0 ; k++) { // k=0수행, k<input0수행, 코드 수행, 조건검사
					arr[i][k] = 0;
				}
				for(int j = 0 ; j<binarystr.length(); j++) {
					arr[i][input0+j] = binarystr.charAt(j)-'0';
				}
				
			}
			
			else {
				for(int j = 0 ; j <arr[i].length ; j++) {
					arr[i][j] = binarystr.charAt(j) - '0';
				}
			}
				
			
	
		}
		

		return arr;
	}

}
