package courseSchedule.fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import courseSchedule.course.Course;

public class MyFile {
	String fileName;
	
	public MyFile(String fileName){
		this.fileName = fileName;
	}
	
	//从文件中读数据
	public ArrayList<Course> readFromFile() throws IOException{
		
		File file = new File(this.fileName);
		BufferedReader bufr = new BufferedReader(new FileReader(file));
		
		String line;
		ArrayList<Course> list = new ArrayList<Course>();
		Course course;
		String [] temp;
		
		while((line = bufr.readLine())!=null){
			temp = line.split("；");
			course = new Course(temp[0],temp[1],temp[2],temp[3]);
			list.add(course);
		}
		
		bufr.close();
		return list;
	}
	
	//写入文件
	public void writeToFile(ArrayList<Course> list) throws IOException{
		
		FileWriter fw = new FileWriter(fileName,false);
		
		String line;
		
		for(int i = 0; i<list.size(); i++){
			line = list.get(i).time.weekDay+"；"+
					list.get(i).time.dayTime+"；"+
					list.get(i).name+"；"+
					list.get(i).place+"\r";
			fw.write(line);
			//System.out.println(line);
		}
		
		fw.close();
	}
}
