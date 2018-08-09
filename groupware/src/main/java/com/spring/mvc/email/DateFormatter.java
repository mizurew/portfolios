package com.spring.mvc.email;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	//두 날짜 입력받아 차이 연,월,일,시간,분,초 로 리턴
	public String dateformats(String today,String rcvday) throws ParseException {
		
		String getToday[] = today.split(",");
		String getRcvday[] = rcvday.split(",");
		int getTodayi[] = new int[getToday.length];
		int getRcvdayi[] = new int[getRcvday.length];
		for(int i=0;i<getToday.length;i++) {
			getTodayi[i] = Integer.parseInt(getToday[i]);
			getRcvdayi[i] = Integer.parseInt(getRcvday[i]);
		}
		if(getTodayi[0]!=getRcvdayi[0]) {
			if(getTodayi[0]-getRcvdayi[0]==1&&getTodayi[1]-getRcvdayi[1]<=0) {
				DateFormatter df = new DateFormatter();
				getTodayi[1] = getTodayi[1]+df.totalday(getRcvdayi[0]+"");
			}else {
			int yeardif = getTodayi[0]-getRcvdayi[0];
			return yeardif+"년 전";
			}
		}
		
		int x1 = getTodayi[0];
		int x2 = getTodayi[1]*86400;
		int x3 = getTodayi[2]*3600;
		int x4 = getTodayi[3]*60;
		int x5 = getTodayi[4];
		
		int xres = x2+x3+x4+x5;
		
		int y1 = getRcvdayi[0];
		int y2 = getRcvdayi[1]*86400;
		int y3 = getRcvdayi[2]*3600;
		int y4 = getRcvdayi[3]*60;
		int y5 = getRcvdayi[4];
 		
		int yres = y2+y3+y4+y5;
		
		int rres = xres - yres;
		
		int r1 = rres/86400;
		int r2 = (rres%86400)/3600;
		int r3 = (rres%3600)/60;
		int r4 = rres%60;
		
		if(r1!=0) {
			if(r1>30){
				r1 = r1/30;
			return r1+"개월 전";
			}
			return r1+"일 전";
		}else if(r2!=0) {
			return r2+"시간 전";
		}else if(r3!=0) {
			return r3+"분 전";
		}else
			return r4+"초 전";
	}
	//해당연도 총 일수
	public int totalday(String years) throws ParseException {
		String date1 = years+"-12-31 00:00:00";
	    SimpleDateFormat datefm1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date2 = datefm1.parse(date1);	
	    SimpleDateFormat datefm2 = new SimpleDateFormat("DDD");
		int date3 = Integer.parseInt(datefm2.format(date2));
		
		return date3;
	}
}
