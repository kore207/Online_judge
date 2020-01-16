package helloworld;

import java.util.Scanner;

public class OJ2448 {

	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner sc = new Scanner(System.in);
	         
	        int n = sc.nextInt();
	         
	        String arr[]= new String[n];
	         
	        int i,j,m;
	        int height = 3; //기본 높이 3개를 기준으로 삼각형을 쌓아간다.
	        int k = (int) (Math.log(n/3) / Math.log(2));  //3개를 기준으로 하였기 때문에 3의 배수마다 그려야할 층을 나타낸다.
	        System.out.println(k);
	        arr[0] = "  *  ";
	        arr[1] = " * * ";
	        arr[2] = "*****";
	         
	        String space = "   ";
	         
	       for(i=0; i<k; i++) {
	           for(j=0; j<height; j++) {
	               arr[height + j] = arr[j] + " " + arr[j];
	               for(m=0; m<height/3; m++) {
	                   arr[j] = space + arr[j] + space;
	               }
	           }
	           height += height;
	       }
	        
	         
	        for(String star : arr) {
	            System.out.println(star);
	        }
	    }

}
