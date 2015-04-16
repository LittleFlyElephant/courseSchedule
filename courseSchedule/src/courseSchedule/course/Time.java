package courseSchedule.course;

public class Time {
	public String weekDay;
	public String dayTime;
	public int intWeekDay;
	public int intDayTime;
	
	public Time(String t1,String t2){
		this.weekDay = t1;
		this.dayTime = t2;
		convertToInt();
	}
	
	public void convertToInt(){
		switch(weekDay){
			case "星期一": {intWeekDay = 1;break;}
			case "星期二": {intWeekDay = 2;break;}
			case "星期三": {intWeekDay = 3;break;}
			case "星期四": {intWeekDay = 4;break;}
			case "星期五": {intWeekDay = 5;break;}
			case "星期六": {intWeekDay = 6;break;}
			case "星期天": {intWeekDay = 7;break;}
		}
		
		String [] temp = dayTime.split("、");
		
		switch(temp[0]){
			case "一": {intDayTime = 1;break;}
			case "二": {intDayTime = 2;break;}
			case "三": {intDayTime = 3;break;}
			case "四": {intDayTime = 4;break;}
			case "五": {intDayTime = 5;break;}
			case "六": {intDayTime = 6;break;}
			case "七": {intDayTime = 7;break;}
			case "八": {intDayTime = 8;break;}
			case "九": {intDayTime = 9;break;}
			case "十": {intDayTime = 10;break;}
		}
	}
}
