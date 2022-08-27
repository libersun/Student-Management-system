package curriculum_Design;

public class Student {
	int id; // 学号
	String name; // 姓名
	int age; // 年龄

	double math;//数学成绩
	double english;//英语成绩
	double c;//c语言成绩
	double java;//java成绩
	double database;//数据库成绩
	double score;//总成绩
	
	
	
	public Student() {
	}

	//有参构造方法，可以直接添加学生所有信息及成绩 添加学号 姓名 年龄
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
//		this.math=math;
//		this.english=english;
//		this.c=c;
//		this.java=java;
//		this.database=database;
	}

	
	
	
	public String toString() {// 重写toString方法，输出属性
		return "name:" + name + " " + "id:" + id + " " + "age:" + age ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getMath() {
		return math;
	}
	
	public void setMath(double math) {
		this.math = math;
	}
	public double getEnglish() {
		return english;
	}
	
	public void setEnglish(double english) {
		this.english = english;
	}
	
	public double getC() {
		return c;
	}
	
	public void setC(double c) {
		this.c = c;
	}
	public double getJava() {
		return java;
	}
	
	public void setJava(double java) {
		this.java = java;
	}
	
	
	public double getDatabase() {
		return database;
	}
	
	public void setDatabase(double database) {
		this.database = database;
	}
	
	public void caScore()//用来计算总成绩的方法
	{
		score=math+english+c+java+database;
		
	}
	
	

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
