package courseSchedule.transaction;

import java.io.IOException;
import java.util.ArrayList;

import courseSchedule.course.Course;
import courseSchedule.course.Time;
import courseSchedule.fileIO.MyFile;

public class CourseManager {
	MyFile myFile;
	ArrayList<Course> list;
	Course tempCourse;
	String [] temp1;
	String [] temp2;
	String ins;
	
	public CourseManager(String instruction) throws IOException{
		
		//读入课程表
		myFile = new MyFile("courseSchedule.txt");
		list = myFile.readFromFile();
		
		//分解命令
		temp1 = instruction.split(" ");
		
		//得到命令
		ins = temp1[0];
		
		//执行命令
		if(ins.equals("Add")) {
			temp2 = temp1[1].split("；");
			tempCourse = new Course(temp2[0],temp2[1],temp2[2],temp2[3]);
			addCourse(tempCourse,list);
			myFile.writeToFile(list);
		}
		else if(ins.equals("Remove")) {
			temp2 = temp1[1].split("；");
			tempCourse = new Course(temp2[0],temp2[1],temp2[2],temp2[3]);
			removeCourse(tempCourse,list);
			myFile.writeToFile(list);
		}
		else if(ins.equals("Show")) showCourses(list);
		else if(ins.equals("Find")) {
			temp2 = temp1[1].split("；");
			Time time = new Time(temp2[0],temp2[1]);
			findCourse(time,list);
		}
		else if(ins.equals("Update")) {
			temp2 = temp1[1].split("；");
			tempCourse = new Course(temp2[0],temp2[1],temp2[2],temp2[3]);
			updateCourse(tempCourse,list);
			myFile.writeToFile(list);
		}
	}
	
	//添加课程
	public void addCourse(Course course,ArrayList<Course> list){
		
		//遍历课程，查看是否已经存在
		boolean isExist = false;
		//查看是否有课程冲突，只针对每门课固定2节的一般情况
		boolean isTimeConflict = false;
		
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).isEqualTo(course)) isExist = true;
			if(list.get(i).isEqualTime(course.time)) isTimeConflict = true;
		}
		
		if(isExist) System.out.println("你要添加的课程已经存在！");
		else if(isTimeConflict) System.out.println("所在时间已有课程！");
			
		//不存在且时间不冲突就添加到课程表
		else{
			list.add(course);
			System.out.println("已添加到文件中！");
		}
	}
	
	//删除课程
	public void removeCourse(Course course,ArrayList<Course> list){
		
		//遍历课程表，寻找该课程位置
		int index = -1;
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).isEqualTo(course)) index = i;
		}
		
		//有就删除
		if(index >= 0){
			list.remove(index);
			System.out.println("已从文件中删除！");
		}else System.out.println("无此课程！");
	}
	
	//显示课程
	public void showCourses(ArrayList<Course> list){
		
		//排序
		sortCourse(list);
		
		//遍历课程表，输出所有课程
		for(int i = 0; i<list.size(); i++){
			Course temp = list.get(i);
			System.out.println(temp.time.weekDay+"；"
							+temp.time.dayTime+"；"
							+temp.name+"；"
							+temp.place);
			//System.out.println(temp.time.intDayTime+" "+temp.time.intWeekDay);
		}
	}
	
	//寻找课程
	public void findCourse(Time time,ArrayList<Course> list){
		
		//遍历课程表，看是否存在该课程
		int index = -1;
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).isEqualTime(time)) index = i;
		}
		
		//若存在，输出课程名和上课地点
		if(index >= 0) 
			System.out.println(list.get(index).name+" "
							+list.get(index).place);
		else System.out.println("无此课程！");
	}
	
	//更新课程
	public void updateCourse(Course course,ArrayList<Course> list){
		
		//遍历课程表，查看是否存在该课程
		int index = -1;
		boolean isUpdate = false;
		boolean isTimeConflict = false;
		
		for(int i = 0; i<list.size(); i++){
			if(list.get(i).isEqualName(course.name)) index = i;
			if(list.get(i).isEqualTo(course)) isUpdate = true;
			if(list.get(i).isEqualTime(course.time)) isTimeConflict = true;
		}
		
		//若存在但已经最新，则无需更新，反之更新
		if(index >= 0){
			if(isUpdate) System.out.println("无需重复更新！");
			else if(isTimeConflict) System.out.println("所在时间已有课程");
			else {
				list.set(index, course);
				System.out.println("已更新文件");
			}
		}else System.out.println("无此课程！");
	}
	
	//给课程排序
	public void sortCourse(ArrayList<Course> list){
		
		//System.out.println(1);
		//冒泡排序，按时间排序
		for(int i = 0; i<list.size(); i++){
			for(int j = i+1; j<list.size(); j++){
				if(list.get(i).isLaterTime(list.get(j).time)){
					//System.out.println(1);
					Course temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		
	}
}
