package curriculum_Design;

import java.util.*;
import java.io.*;

public class SystemOfStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//用来输入选择学生管理系统功能
		List<Student> students = new ArrayList<Student>();
		IOSystemOfStudent io=new IOSystemOfStudent();//自定义的类，用来读取或写入文件（为了使之前输入的学生信息保存起来（比如昨天输入的））
		try {
			students =io.getSystemOfStudent(); //从文件中读取学生信息
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		School school = new School(students);
		while(true) {
			System.out.println("欢迎使用学生管理系统");
			System.out.println("1 添加学生信息");
			System.out.println("2 删除学生信息");
			System.out.println("3 修改学生信息");
			System.out.println("4 成绩统计");
			System.out.println("5 学生信息查询");
			System.out.println("6 添加学生各科成绩");
			System.out.println("7 显示指定学生的所有成绩");
			System.out.println("8 修改指定学生成绩");
			System.out.println("输出其他退出");
			System.out.println("输入你的选择：");
			String x=sc.next();//输入数字，用来选择学生管理系统的操作
			switch(x) {
			case "1":
				// 学生信息的添加
				System.out.println("请输入学生的学号：");
				int id = sc.nextInt();
				if(school.find(id)!=-2)
				{
					System.out.println("该学生已存在！");
				}
				else {
				System.out.println("请输入学生的姓名：");
				String name = sc.next();
				System.out.println("请输入学生的年龄：");
				int age = sc.nextInt();
				
//				System.out.println("请输入学生的成绩：");
//				double score = sc.nextDouble();
				school.addStudent(new Student(id, name, age));
				try {
					io.saveSystemOfStudent(students);//保存好新添加的信息
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				break;
			case "2":
				// 学生信息的删除	
				System.out.println("请输入要删除的学生的学号："); int sno1=sc.nextInt();
				school.removeStudent(sno1);
				try {
					io.saveSystemOfStudent(students);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				// 学生信息的修改		//改成姓名改成学号来修改
				 System.out.println("请输入需要修改学生的学号："); int id1=sc.nextInt();
				 System.out.println("姓名修改为：");String name2=sc.next();
				 System.out.println("年龄修改为："); int age1=sc.nextInt();
				 //System.out.println("成绩修改为："); double score1=sc.nextDouble();
				 school.changeStudent(new Student(id1,name2,age1));
				 try {
					io.saveSystemOfStudent(students);//保存学生信息到文件里
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
				 
			case "4":
				school.opSubject();//成绩统计的方法
				//根据总成绩进行学生信息排序
				System.out.println("根据总成绩从小到大进行排名顺序如下：");
				school.sorted(); //按总成绩排名的方法
				try {
					io.saveSystemOfStudent(students);//将结果保存至学生列表
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
				
				
			case "5":
				// 学生信息查询
				System.out.println("请输入要查询的学生的学号：");
				int id9 = sc.nextInt();
				school.seeked(id9);
				break;
			case "6":
				// 添加学生各科成绩
				System.out.println("请输入要录入成绩的学生的学号：");
				int id4 = sc.nextInt();
				school.inputAllScore(id4);//录入所有科目成绩的方法
				 try {
						io.saveSystemOfStudent(students);//保存成绩信息保存到文件里
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			case "7":
				// 显示学生各科成绩
				System.out.println("请输入要显示成绩的学生的学号：");
				int id2 = sc.nextInt();
				school.outputAllScore(id2);//显示出该学生所有科目成绩的方法
				break;
			case "8":
				// 修改学生各科成绩
				System.out.println("请输入要修改成绩的学生的学号：");
				int id5 = sc.nextInt();
				school.changeScore(id5);//修改该学生各科目成绩的方法
				 try {
						io.saveSystemOfStudent(students);//保存修改后的信息到文件里
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
				
			default:
				System.out.println("谢谢使用");
				System.exit(0);
				break;
			}
		}
	}
}