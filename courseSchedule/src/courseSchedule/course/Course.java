package courseSchedule.course;

public class Course {
	public String name;
	public Time time;
	public String place;
	
	public Course(String t1,String t2,String name,String place){
		this.time = new Time(t1,t2);
		this.name = name;
		this.place = place;
	}
	
	public boolean isEqualTo(Course anotherCourse){
		if((name.equals(anotherCourse.name))
			&&(time.dayTime.equals(anotherCourse.time.dayTime))
			&&(time.weekDay.equals(anotherCourse.time.weekDay))
			&&(place.equals(anotherCourse.place))) return true;
		else return false;
	}
	
	public boolean isEqualTime(Time time){
		if((this.time.weekDay.equals(time.weekDay))
			&&(this.time.dayTime.equals(time.dayTime))) return true;
		else return false;
	}
	
	public boolean isEqualName(String name){
		if(this.name.equals(name)) return true;
		else return false;
	}
	
	public boolean isLaterTime(Time time){
		if(this.time.intWeekDay>time.intWeekDay) return true;
		else{
			if(this.time.intWeekDay == time.intWeekDay){
				if(this.time.intDayTime>time.intDayTime) return true;
				else return false;
			}
			else return false;
		}
	}
}
