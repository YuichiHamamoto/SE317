package lab5;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Yuichi Hamamoto
 *
 */
public class Tharmo {
	public int curT;
	public int curH;
	public int preT;
	public int preH;
	public int maxT;
	public int maxH;
	public int minT;
	public int minH;
	
	//0 = increasing, 1 = decreasing, 2 = stable
	public int trendT;
	public int trendH;
	
	//0 = OK, 1 = High, 2 = Low
	public int check;
	
	public static void main(String[]args) throws NumberFormatException, Exception {
		Tharmo t = new Tharmo();
		
		//switch between part 1 and 2
		int flag = 1;
		switch(flag) {
		  case 1:
				while(true) {
					Scanner sc = new Scanner(System.in);
					
					String [] line = sc.nextLine().split(" ");
					if(line[0].equals("reset")) {
						t.reset();
						System.out.println(t.toString());
					}else if(line[0].equals("input")) {
						t.read(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
						System.out.println(t.toString());
					}
					else {
						System.out.println("Invalid input format");
						continue;
					}
					TimeUnit.SECONDS.sleep(30);
				}
		  case 2:
			  int []temp = {66, 68, 69, 67, 63, 59};
				int []humid= {53, 51, 48, 49, 54, 56, 53};
				int length = temp.length>humid.length ? temp.length:humid.length;
				for(int i = 0;i<length;i++) {
					try {
						t.read(temp[i], humid[i]);
					}
					catch(Exception e) {
						throw new Exception("Invalid input");
					}
				}
				System.out.println(t.toString());
		    break;
		}
		
		

	}
	
	//Construct default thermometer
	public Tharmo() {
		curT=-1;
		curH=-1;
		preT=-1;
		preH=-1;
		maxT=0;
		maxH=0;
		minT=125;
		minH=100;
		trendT=-1;
		trendH=-1;
		check=-1;
	}
	
	//Reset thermometer
	public void reset() {
		preT=-1;
		preH=-1;
		maxT=curT;
		maxH=curH;
		minT=curT;
		minH=curH;
		trendT=-1;
		trendH=-1;
		check = checkHum(curH);
	}
	
	
	//Check the humidity condition
	public int checkHum(int h) {
		if(h<0||100<h) {
			return -1;
		}else if(h<30) {
			return 2;
		}else if(30<=h&&h<=55) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//Set trend
	public int setTrend(int pre, int cur) {
		if(pre<0) {
			return -1;
		}
		if(pre<cur) {
			return 0;
		}else if(pre==cur) {
			return 2;
		}
		else{
			return 1;
		}
	}
	
	//Read temperature and humidity
	public void read(int t, int h) throws Exception {
		if((t<0||125<t)||(h<0||100<h)) {
			throw new Exception("Invalid input");
		}
		preT=curT;
		preH=curH;
		curT=t;
		curH=h;
		maxT=Math.max(maxT, curT);
		maxH=Math.max(maxH, curH);
		minT=Math.min(minT, curT);
		minH=Math.min(minH, curH);
		trendT=setTrend(preT,curT);
		trendH=setTrend(preH,curH);
		check = checkHum(curH);
	}
	
	//Get Trend
	public String getTrend(int n) {
		if(n==-1) {
			return "N/A";
		}else if(n==0) {
			return "up";
		}else if(n==1) {
			return "down";
		}else if(n==2) {
			return "stable";
		}else {
			return "N/A";
		}
	}
	
	//GetStatus
	public String getStatus(int n) {
		if(n==-1) {
			return "N/A";
		}else if(n==0) {
			return "OK";
		}else if(n==1) {
			return "Hi";
		}else if(n==2) {
			return "Low";
		}else {
			return "N/A";
		}
	}
	
	//To string function
	public String toString() {
		return "Current Humidity: "+curH+"%"+"\n"+
				"Maximum Humidity: "+maxH+"%"+"\n"+
				"Minimum Humidity: "+minH+"%"+"\n"+
				"Humidity Trend: "+getTrend(trendH)+"\n"+
				"Current Temperature: "+curT+"F"+"\n"+
				"Maximum Temperature: "+maxT+"F"+"\n"+
				"Minimum Temperature: "+minT+"F"+"\n"+
				"Temperature Trend: "+getTrend(trendT)+"\n"+
				"Humidity status: "+getStatus(check);
	}
}
