
import java.io.*;
import java.util.*;

public class Main {	
	static int[] arr;
	static int[] temp;
	static long cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());//수 N개
		arr = new int[N];
		temp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		mergeSort(arr, 0, N-1);
		
		System.out.println(cnt);

	}	
	
	static void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			merge(arr, start, middle, end);
		}
	}
	
	static void merge(int[] arr, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int k = start;
		
		while(i <= middle && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				
				i++;
			} else {
				temp[k] = arr[j];
				cnt += j - k;
				j++;
			}
			k++;
		}
		
		if(i > middle) {
			for(int t = j; t<=end; t++) {
				temp[k] = arr[t];
				k++;
			}
		} else {
			for(int t = i; t<=middle; t++) {
				temp[k] = arr[t];
				k++;
			}
		}
		
		for(int t = start; t <= end; t++) {
			arr[t] = temp[t];
		}
	}
		
}

