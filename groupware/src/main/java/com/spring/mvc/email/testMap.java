package com.spring.mvc.email;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testMap {
	public static void main(String[] args) {
//		
//		
//		
//		Map<String,ArrayList<List<String>>> map = new HashMap<String, ArrayList<List<String>>>();
//		
//		List<String> list1 = new ArrayList<String>();
//		list1.add("�쇱��1");
//		list1.add("蹂듭�ш린��由�");
//		list1.add("2018-08-09 11:04:49");
//		
//		List<String> list2 = new ArrayList<String>();
//		list2.add("�쇱��2");
//		list2.add("�닿�");
//		list2.add("2018-08-02 09:00:23");
//		
//		List<String> list3 = new ArrayList<String>();
//		list3.add("�쇱��3");
//		list3.add("�닿�");
//		list3.add("2018-08-02 09:22:23");
//		
//		List<String> list4 = new ArrayList<String>();
//		list4.add("�쇱��4");
//		list4.add("�닿�");
//		list4.add("2018-08-04 09:11:23");
//		
//		List<String> list5 = new ArrayList<String>();
//		list5.add("�쇱��5");
//		list5.add("�닿�");
//		list5.add("2018-08-04 09:15:23");
//		
////		System.out.println(list1);
////		System.out.println(list2);
////		System.out.println(list3);
////		System.out.println(list4);
////		System.out.println(list5);
//		
//		
//		ArrayList<List<String>> list11 = new ArrayList<List<String>>();
//		list11.add(list1);
//		list11.add(list2);
//		
//		ArrayList<List<String>> list22 = new ArrayList<List<String>>();
//		list22.add(list3);
//		
//		ArrayList<List<String>> list33 = new ArrayList<List<String>>();
//		list33.add(list4);
//		list33.add(list5);
//		
//		//System.out.println(list11);
//		
//		
//		map.put("1", list11);
//		map.put("2", list22);
//		map.put("3", list33);
//		
//		
//		System.out.println(map.toString());
//		
//		String reciever = "isy,pgy,jhg";
//		
//		String[] recieversp = reciever.split(",");
//		
//		for(int i =0;i<recieversp.length; i++) {
//			System.out.println(recieversp[i]);
//		}
//		
//		System.out.println(reciever);
		
		
		
		SimpleDateFormat date2 = new SimpleDateFormat("DDD,HH,mm,ss");
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss");
		
		
		Date day = new Date();
		String mite = date2.format(day);
		System.out.println(mite);
		
//		String day1 = date1.format(day);	
		String day1 = "2018,3,1,12,30,20";
		String day2 = "2017,2,28,11,35,19";
		
		
		int x1 = 20;
		int x2 = 30*60;
		int x3 = 12*3600;
		int x4 = 1*86400;
		
		int y1 = 19;
		int y2 = 35*60;
		int y3 = 11*3600;
		int y4 = 28*86400;
		
		
		int xr = x1+x2+x3+x4;
		int yr = y1+y2+y3+y4;
		System.out.println(xr);
		System.out.println(yr);
		System.out.println(yr-xr);
		
		int rr = yr-xr;
		int r4 = rr/86400;
		
		int r3 = (rr%86400)/3600;
		int r2 = (rr%3600)/60;
		int r1 = rr%60;
		
		System.out.println(r4+"일"+r3+"시간"+r2+"분"+r1+"초");
		
		
		
//		System.out.println(day1);
//		System.out.println(day2);
//		
//		String[] getday1 = day1.split(",");
//		String[] getday2 = day2.split(",");
//		
//		int[] getday11 = new int[getday1.length];
//		int[] getday22 = new int[getday2.length];
//		
//		for(int i=0;i<getday1.length;i++) {
//			getday11[i] = Integer.parseInt(getday1[i]);
//			getday22[i] = Integer.parseInt(getday2[i]);
//		}
//		
//			String lefted = "";
			
//		System.out.println(getday22[1]);
//			
//		if(getday11[0]!=getday22[0]) {
//			if (getday11[0]-getday22[0]==1&&
//				getday11[1]-getday22[1]<0&&
//				getday11[2]-getday22[2]<0&&
//				getday11[3]-getday22[3]<0&&
//				getday11[4]-getday22[4]<0&&
//				getday11[5]-getday22[5]<0) {
//				int seconds = getday11[5]+60-getday22[5];
//				lefted = seconds+"초 전";
//			}else if(getday11[0]-getday22[0]==1&&
//				getday11[1]-getday22[1]<0&&
//				getday11[2]-getday22[2]<0&&
//				getday11[3]-getday22[3]<0&&
//				getday11[4]-getday22[4]<0) {
//				int minutes = getday11[4]+60-getday22[4];
//				lefted = minutes+"분 전";
//			}else if(getday11[0]-getday22[0]==1&&
//				getday11[1]-getday22[1]<0&&
//				getday11[2]-getday22[2]<0&&
//				getday11[3]-getday22[3]<0) {
//				int hours = getday11[3]+24-getday22[3];
//				lefted = hours+"시간 전";
//			}else if(getday11[0]-getday22[0]==1&&
//				getday11[1]-getday22[1]<0&&
//				getday11[2]-getday22[2]<0){
//				if(getday22[1]==1||getday22[1]==3||getday22[1]==5||
//				   getday22[1]==7||getday22[1]==8||getday22[1]==10||
//				   getday22[1]==12) {
//					int days = getday11[2]+31-getday22[2];
//					lefted = days+"일 전";
//				}else if(getday22[1]==2&&getday22[0]%4==0) {
//					int days = getday11[2]+29-getday22[2];
//					lefted = days+"일 전";
//				}else if(getday22[1]==2) {
//					int days = getday11[2]+28-getday22[2];
//					lefted = days+"일 전";
//				}else {
//					int days = getday11[2]+30-getday22[2];
//					lefted = days+"일 전";
//				}
//			}else if(getday11[0]-getday22[0]==1&&
//				getday11[1]-getday22[1]<0) {
//				int months = getday11[1]+12-getday22[1];
//				lefted = months+"개월 전";
//			}
//			else {
//				int years = getday11[0]-getday22[0];
//				lefted = years+"년 전";
//			}
//		}else if(getday11[1]!=getday22[1]) {
//			
//			int months = getday11[1]-getday22[1];
//			System.out.println(months+"개월 전");
//		}else if(getday11[2]!=getday22[2]) {
//			int days = getday11[2]-getday22[2];
//			System.out.println(days+"일 전");
//		}else if(getday11[3]!=getday22[3]) {
//			int hours = getday11[3]-getday22[3];
//			System.out.println(hours+"시간 전");
//		}else if(getday11[4]!=getday22[4]) {
//			int minutes = getday11[4]-getday22[4];
//			System.out.println(minutes+"분 전");
//		}else {//if(getday11[5]!=getday22[5]) {
//			int seconds = getday11[5]-getday22[5];
//			System.out.println(seconds+"초 전");
//		}
//			System.out.println(lefted);
	}
}













