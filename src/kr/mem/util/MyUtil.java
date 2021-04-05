package kr.mem.util;
public class MyUtil {
	 // 1~100까지의 총합=?  hap()
	 public int hap() {
		 int sum=0;
		    for(int i=1;i<=500;i++){
		    	sum+=i;
		    }
		    return sum;
	 }	 
	 public int hap(int su1, int su2) {
		 int sum=0;
		    for(int i=su1;i<=su2;i++){
		    	sum+=i;
		    }
		    return sum;
	 }	 
}
