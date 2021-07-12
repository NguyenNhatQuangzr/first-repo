import java.util.*;

public class finaloptimize {
	static Scanner sc = new Scanner(System.in);
	public static String[] choose(String[][] nvtrungtam, String[][] nvsinhvien, String[] thutusinhvien, String[] thututrungtam) {	
		
		int n = nvsinhvien.length; 
		
		boolean[] svFree = new boolean[n]; //true là chưa chọn trường
		String[] svchoose = new String[n]; 
										   
		Arrays.fill(svFree , true);
		Arrays.fill(svchoose ,"0");
		
		int k = 0; //thứ tự đang xét
		int free = n; 
		
		while(free > 0) {
			for(int i = 0; i < nvsinhvien.length; i++) {
				if(svFree[i] == true) {
					String m = nvsinhvien[i][k]; 
						if(check(m,svchoose) == false) { //th1
							svchoose[i] = m;
							svFree[i] = false;
							free--;
						} else { //th2
							int f = 0;
							int g = 0;
							int a = indextrungtam(svchoose , m); //thg nào đang chọn 
							int b = vitritrungtam(thututrungtam , m); // số thứ tự của bệnh viện
							for(int l = 0; l < n; l++) {
								if(nvtrungtam[b][l].equals(thutusinhvien[a])) {
									f = l;
								}
								if(nvtrungtam[b][l].equals(thutusinhvien[i])) {
									g = l;
								}
							}								
							if(g < f) {
								svchoose[i] = m;
								svFree[i] = false;
								svFree[a] = true;
							} else { //th3
								//ko làm gì cả
							}												
					}
				}
			}
			k++;
	}
	return svchoose;					
	}
	
	public static boolean check(String m, String[] svchoose) {
		for(int j = 0; j < svchoose.length; j++) {
			if(svchoose[j].equals(m)) {
				return true;
			} 
		}
		return false;
	}
	
	public static int vitritrungtam(String[] thututrungtam, String m) { 
		for(int i = 0; i < thututrungtam.length; i++) {
			if(thututrungtam[i].equals(m)) {
				return i;
			} 
		}
		return -1;
	}
	
	public static int indextrungtam(String[] svchoose, String m) { 
		for(int i = 0; i < svchoose.length; i++) {
			if(svchoose[i].equals(m)) {
				return i;
			} 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int n = sc.nextInt();
		String[][] nvsinhvien = new String[n][n];
		String[][] nvtrungtam = new String[n][n];
		
		System.out.println("Nhập nguyện vọng của các trung tâm là: ");	
		for(int i = 0; i < nvtrungtam.length ; i++) {
			for(int j = 0; j < nvtrungtam[i].length ; j++) {
				nvtrungtam[i][j] = sc.next();
			}
		}
		
		System.out.println("Nhập nguyện vọng của các sinh viên là: ");
		for(int i = 0; i < nvsinhvien.length ; i++) {
			for(int j = 0; j < nvsinhvien[i].length ; j++) {
				nvsinhvien[i][j] = sc.next();
			}
		}
		
		System.out.println("Nhập thứ tự của các sinh viên là: ");
		String[] thutusinhvien = new String[n];
		for(int i = 0; i < n; i++) {
			thutusinhvien[i] = sc.next();
		}
		
		System.out.println("Nhập thứ tự của các trung tâm là: ");
		String[] thututrungtam = new String[n];
		for(int i = 0; i < n; i++) {
			thututrungtam[i] = sc.next();
		}
		
		System.out.println("Nguyện vọng của các trung tâm là: ");
		for(int i = 0; i < nvtrungtam.length ; i++) {
			for(int j = 0; j < nvtrungtam[i].length ; j++) {
				System.out.print(nvtrungtam[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("Nguyện vọng của các sinh viên là: ");
		for(int i = 0; i < nvsinhvien.length ; i++) {
			for(int j = 0; j < nvsinhvien[i].length ; j++) {
				System.out.print(nvsinhvien[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("Thứ tự của các trung tâm là: ");
		for(int i = 0; i < n; i++) {
			System.out.print(thututrungtam[i] + " ");
		}
		
		System.out.println("");
		System.out.println("Thứ tự của các sinh viên là: ");
		for(int i = 0; i < n; i++) {
			System.out.print(thutusinhvien[i] + " ");
		}
		
		System.out.println("");
		System.out.println("Ghép cặp: ");
		String[] result = choose(nvtrungtam,nvsinhvien,thutusinhvien,thututrungtam);
	    for(int i = 0; i < n; i++) {
	    	 System.out.println(thutusinhvien[i] + " " + result[i]);
	    }
	}
}
