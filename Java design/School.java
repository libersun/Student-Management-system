package curriculum_Design;

import java.util.*;
import java.io.*;

public class School {
	List<Student> students = new ArrayList<Student>();// 创建一个Student类型的数组列表
	public School(List<Student> students) {
		this.students = students;
	}
	
	
	public int find(int id)//用学号为标准来验证学生是否已存在
	{
		int i;
		for(i=0;i<students.size();i++)
		{
			if(students.get(i).getId()==id)
			{
				break;
			}
		}
		
		if(i==students.size())
		{
			return -2;
		}else {
			return i;
		}
			
		
	}
	
	
	
	public void addStudent(Student stu) {// 实现学生信息的添加（把输入的参数stu放入student列表里面）
		
		students.add(stu);
		System.out.println("添加成功");
	}
	
	public void removeStudent(int id) {// 实现学生信息的删除
		Student stu = null;//创建一个学生的引用（临时的学生对象）
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).id==id) {//判断列表的第i个学生的名字是否和输入参数的名字相同
				stu = students.get(i);
			}
		}
		if (students.contains(stu) == false) {// 判断学生信息是否在数组列表里
			System.out.println("没有该学生信息");
		} else {
			students.remove(stu);//ArrayList里面的remove方法
			System.out.println("删除成功");
		}
	}
	
	
	public void changeStudent(Student stu) {// 实现学生信息的修改
		int i;
		for (i = 0; i < students.size(); i++) {// 用for循环找到要替换的对象的序号
			if (students.get(i).id==stu.id) {
				students.set(i, stu);// 用set方法（ArrayList了列表类自带的方法）修改信息
				System.out.println("修改成功");
				break;//修改完后跳出循环
			} 
		}
		if(i==students.size())
		{
			System.out.println("没有该学生信息");
		}
	}
	
	
	public void sorted() {// 实现按总成绩进行学生信息的排序
		Student stu = null;
		for (int i = 0; i < students.size() - 1; i++) {// 使用冒泡排序按总成绩排名
			for (int j = 0; j < students.size() - 1 - i; j++) {
				if (students.get(j).getScore() > students.get(j + 1).getScore()) {
					stu = students.get(j);//用临时变量stu存储位置为j的对应元素值
					students.set(j, students.get(j + 1));//把第j+1位置的元素值放到第j个的位置上		// 用set方法修改信息（ArrayList的set（int index,E element）,index为数组索引，E为数组的泛型，element为要替换进去的元素）
					students.set(j + 1, stu);//把第j个位置的元素放到j+1上
					stu = null;//一次j循环完后把临时变量stu清空，以便下一次j循环使用
				}
			}
		}
	}
	
	
	public void seeked(int id) {// 实现学生信息的查询
		int i;
		for (i = 0; i < students.size(); i++) {
			if (students.get(i).id==id) {
				System.out.println(students.get(i).toString());// 调用重写的toString方法
				break;
			}
		}
		if(i==students.size())
		{
			System.out.println("没有该学生信息");
		}
	}
	
	
	
	public void inputAllScore(int id) {//录入该学生的所有成绩的方法，参数为该学生学号
		Scanner sc=new Scanner(System.in);
		Student stu=null;
		for(int i=0;i<students.size();i++)//首先查询该学生是否在student列表中
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//如果找到了该学生
			System.out.println("请输入数学成绩：");
			stu.math=sc.nextDouble();
			System.out.println("请输入英语成绩：");
			stu.english=sc.nextDouble();
			System.out.println("请输入c语言成绩：");
			stu.c=sc.nextDouble();
			System.out.println("请输入Java成绩：");
			stu.java=sc.nextDouble();
			System.out.println("请输入数据库成绩：");
			stu.database=sc.nextDouble();
			stu.caScore();//录入科目成绩的同时计算总成绩
		}else {
			System.out.println("错误！无该学生存在");
		}
		
	}

	
	public void outputAllScore(int id) {//输出该学生的所有成绩的方法，参数为该学生姓名
		Student stu=null;
		for(int i=0;i<students.size();i++)//首先查询该学生是否在student列表中
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//如果找到了该学生
			System.out.println("该学生数学成绩为："+stu.getMath());
			System.out.println("该学生英语成绩为："+stu.getEnglish());
			System.out.println("该学生c语言成绩为："+stu.getC());
			System.out.println("该学生Java成绩为："+stu.getJava());
			System.out.println("该学生数据库成绩为："+stu.getDatabase());
		}else {
			System.out.println("错误！无该学生存在");
		}
	}
	
	
	public void changeScore(int id) {//修改某学生成绩的方法，参数为该学生学号
		Student stu=null;
		for(int i=0;i<students.size();i++)//首先查询该学生是否在student列表中
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//如果找到了该学生
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入该学生新的数学成绩：");stu.math=sc.nextDouble();
			System.out.println("请输入该学生新的英语成绩：");stu.english=sc.nextDouble();
			System.out.println("请输入该学生新的c语言成绩：");stu.c=sc.nextDouble();
			System.out.println("请输入该学生新的Java成绩：");stu.java=sc.nextDouble();
			System.out.println("请输入该学生新的数据库成绩：");stu.database=sc.nextDouble();
			stu.caScore();//修改科目成绩的同时计算总成绩
			System.out.println("修改信息成功！");		
		}else {
			System.out.println("错误！无该学生存在");
		}
	}
	
	
	
	ArrayList<Student> A=new ArrayList<Student>();//创建一个动态字符串型数组A，用来保存超过90分的学生信息
	ArrayList<Student> B=new ArrayList<Student>();//创建一个动态字符串型数组B，用来保存不及格的学生信息
	public void opGoodStuMessage() {//用于输出某科目成绩大于90分的学生信息的方法
		if(A.size()==0)
		{
			System.out.println("该科目无成绩大于90分的学生");
		}
		for(int i=0;i<A.size();i++)
		{
			System.out.println("姓名："+A.get(i).getName()+",学号："+A.get(i).getId()+",年龄："+A.get(i).getAge());
		}
		
	}

	public void opBadStuMessage() {//用于输出不及格学生信息的方法
		if(B.size()==0)
		{
			System.out.println("该科目无成绩不及格的学生");
		}
		for(int i=0;i<B.size();i++)
		{
			System.out.println("姓名："+B.get(i).getName()+",学号："+B.get(i).getId()+",年龄："+B.get(i).getAge());
		}
		
	}
	
	
	
	public void opSubject() {//成绩统计的方法
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1代表数学，2代表英语，3代表c语言，4代表Java,5代表数据库");
		System.out.println("请输入要查询的科目的编号：");int x=sc.nextInt();
		switch(x) {
		
		//数学math
		case 1:
			double max=0.0;//作为临时变量存储比较结果，最终用来输出最高分
			String name = null;//作为临时变量保存最高成绩的学生姓名
			int id = 0;//作为临时变量保存最高成绩的学生学号
			double sum=0.0;//保存该科目的成绩总分数
			int numGood=0;//该科目超过90分的学生人数
			int numBad=0;//该科目不及格的学生人数
			
			
			for(int i=0;i<students.size();i++)
			{
				if(students.get(i).getMath()>90)
				{
					A.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numGood=numGood+1;//人数
				}
				if(students.get(i).getMath()<60)
				{
					B.add(students.get(i));//把该科目不及格的学生信息放入动态数组B当中
					numBad=numBad+1;//人数
				}
				
				sum+=students.get(i).getMath();//进行该科目全部人成绩的求和
				//求该科目的最高分的学生（打擂法）
				if(i==0) {
					max=students.get(i).getMath();
					name=students.get(i).name;
					id=students.get(i).id;
				}
				
				else
				{
					if(students.get(i).getMath()>max)
					{
						max=students.get(i).getMath();
						name=students.get(i).name;
						id=students.get(i).id;
					}
				}
			}
			System.out.println("该科目成绩最高的学生姓名为："+name+"，学号为："+id);
			System.out.println("该科目课程的平均成绩是："+sum/students.size());
			System.out.println("该科目超过90分的学生信息为：");opGoodStuMessage();//输出信息的方法
			System.out.println("该科目超过90分的人数为："+numGood);
			System.out.println("该科目不及格的学生信息为：");opBadStuMessage();//输出信息的方法
			System.out.println("该科目不及格人数为："+numBad);
			A.clear();//清除数组A中元素
			B.clear();//清除数组B中元素
			break;
		
			
		//英语english
		case 2:
			double max1=0.0;//作为临时变量存储比较结果
			String name1 = null;//作为临时变量保存最高成绩的学生姓名
			int id1 = 0;//作为临时变量保存最高成绩的学生学号
			double sum2=0.0;
			int numGood1=0;//该科目超过90分的学生人数
			int numBad1=0;//该科目不及格的学生人数
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getEnglish()>90)
				{
					A.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numGood1=numGood1+1;
				}
				if(students.get(i).getEnglish()<60)
				{
					B.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numBad1=numBad1+1;
				}
				sum2+=students.get(i).getEnglish();
				if(i==0) {
					max1=students.get(i).getEnglish();
					name1=students.get(i).name;
					id1=students.get(i).id;
				}
				
				else
				{
					if(students.get(i).getEnglish()>max1)
					{
						max1=students.get(i).getEnglish();
						name1=students.get(i).name;
						id1=students.get(i).id;
					}
				}
			}
			
			System.out.println("该科目成绩最高的学生姓名为："+name1+"，学号为："+id1);
			System.out.println("该科目课程的平均成绩是："+sum2/students.size());
			System.out.println("该科目超过90分的学生信息为：");opGoodStuMessage();//输出信息的方法
			System.out.println("该科目超过90分的人数为："+numGood1);
			System.out.println("该科目不及格的学生信息为：");opBadStuMessage();//输出信息的方法
			System.out.println("该科目不及格人数为："+numBad1);
			A.clear();//清除数组A元素
			B.clear();//清除数组B元素
			break;
		
		//c语言 c
		case 3:
			double max2=0.0;//作为临时变量存储比较结果
			String name2 = null;//作为临时变量保存最高成绩的学生姓名
			int id2 = 0;//作为临时变量保存最高成绩的学生学号
			double sum3=0.0;
			int numGood11=0;//该科目超过90分的学生人数
			int numBad11=0;//该科目不及格的学生人数
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getC()>90)
				{
					A.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numGood11=numGood11+1;
				}
				if(students.get(i).getC()<60)
				{
					B.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numBad11=numBad11+1;
				}
				sum3+=students.get(i).getC();
				if(i==0) {
					max2=students.get(i).getC();
					name2=students.get(i).name;
					id2=students.get(i).id;
				}
				
				else
				{
					if(students.get(i).getC()>max2)
					{
						max2=students.get(i).getC();
						name2=students.get(i).name;
						id2=students.get(i).id;
					}
				}
			}
			System.out.println("该科目成绩最高的学生姓名为："+name2+"，学号为："+id2);
			System.out.println("该科目课程的平均成绩是："+sum3/students.size());
			System.out.println("该科目超过90分的学生信息为：");opGoodStuMessage();//输出信息的方法
			System.out.println("该科目超过90分的人数为："+numGood11);
			System.out.println("该科目不及格的学生信息为：");opBadStuMessage();//输出信息的方法
			System.out.println("该科目不及格人数为："+numBad11);
			A.clear();//清除数组A元素
			B.clear();//清除数组B元素
			break;
			
			
		//Java 
		case 4:
			double max3=0.0;//作为临时变量存储比较结果
			String name3 = null;//作为临时变量保存最高成绩的学生姓名
			int id3 = 0;//作为临时变量保存最高成绩的学生学号
			double sum4=0.0;
			int numGood111=0;//该科目超过90分的学生人数
			int numBad111=0;//该科目不及格的学生人数
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getJava()>90)
				{
					A.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numGood111=numGood111+1;
				}
				if(students.get(i).getJava()<60)
				{
					B.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numBad111=numBad111+1;
				}
				sum4+=students.get(i).getJava();
				if(i==0) {
					max3=students.get(i).getJava();
					name3=students.get(i).name;
					id3=students.get(i).id;
				}
				
				else
				{
					if(students.get(i).getJava()>max3)
					{
						max3=students.get(i).getJava();
						name3=students.get(i).name;
						id3=students.get(i).id;
					}
				}
			}
			System.out.println("该科目成绩最高的学生姓名为："+name3+"，学号为："+id3);
			System.out.println("该科目课程的平均成绩是："+sum4/students.size());
			System.out.println("该科目超过90分的学生信息为：");opGoodStuMessage();//输出信息的方法
			System.out.println("该科目超过90分的人数为："+numGood111);
			System.out.println("该科目不及格的学生信息为：");opBadStuMessage();//输出信息的方法
			System.out.println("该科目不及格人数为："+numBad111);
			A.clear();//清除数组A元素
			B.clear();//清除数组B元素
			break;
			
		//数据库database
		default :
			double max4=0.0;//作为临时变量存储比较结果
			String name4 = null;//作为临时变量保存最高成绩的学生姓名
			int id4 = 0;//作为临时变量保存最高成绩的学生学号
			double sum5=0.0;
			int numGood1111=0;//该科目超过90分的学生人数
			int numBad1111=0;//该科目不及格的学生人数
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getDatabase()>90)
				{
					A.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numGood1111=numGood1111+1;
				}
				if(students.get(i).getDatabase()<60)
				{
					B.add(students.get(i));//把该科目大于90分的学生信息放入动态数组A当中
					numBad1111=numBad1111+1;
				}
				sum5+=students.get(i).getDatabase();
				if(i==0) {
					max4=students.get(i).getDatabase();
					name4=students.get(i).name;
					id4=students.get(i).id;
				}
				
				else
				{
					if(students.get(i).getDatabase()>max4)
					{
						max4=students.get(i).getDatabase();
						name4=students.get(i).name;
						id4=students.get(i).id;
					}
				}
			}
			System.out.println("该科目成绩最高的学生姓名为："+name4+"，学号为："+id4);
			System.out.println("该科目课程的平均成绩是："+sum5/students.size());
			System.out.println("该科目超过90分的学生信息为：");opGoodStuMessage();//输出信息的方法
			System.out.println("该科目超过90分的人数为："+numGood1111);
			System.out.println("该科目不及格的学生信息为：");opBadStuMessage();//输出信息的方法
			System.out.println("该科目不及格人数为："+numBad1111);
			A.clear();//清除数组A元素
			B.clear();//清除数组B元素
			break;
		}
	}
	

	

	
	
	
}