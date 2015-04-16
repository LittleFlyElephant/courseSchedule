package courseSchedule.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainSystem {
	//ArrayList<Course> courseList;
	String consoleInstruction;
	CourseManager manager;
	boolean isRunning = false;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MainSystem mainSystem = new MainSystem();
		//mainSystem.courseList = new ArrayList<Course>();
		
		System.out.println("请输入指令：");
		BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
		
		mainSystem.isRunning = true;
		while(mainSystem.isRunning){
			mainSystem.consoleInstruction = consoleReader.readLine();
			if(mainSystem.consoleInstruction.equals("Exit")) {
				mainSystem.isRunning = false;
				System.out.println("退出系统");
			}
			else
			//mainSystem.manager = new CourseManager(mainSystem.consoleInstruction,mainSystem.courseList);
			{
				mainSystem.manager = new CourseManager(mainSystem.consoleInstruction);
				System.out.println("--------------------------------------");
				System.out.println("请输入下一条指令，以Exit结束：");
			}
			
		}
	}

}
