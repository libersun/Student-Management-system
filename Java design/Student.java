package curriculum_Design;

public class Student {
	int id; // ѧ��
	String name; // ����
	int age; // ����

	double math;//��ѧ�ɼ�
	double english;//Ӣ��ɼ�
	double c;//c���Գɼ�
	double java;//java�ɼ�
	double database;//���ݿ�ɼ�
	double score;//�ܳɼ�
	
	
	
	public Student() {
	}

	//�вι��췽��������ֱ�����ѧ��������Ϣ���ɼ� ���ѧ�� ���� ����
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

	
	
	
	public String toString() {// ��дtoString�������������
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
	
	public void caScore()//���������ܳɼ��ķ���
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
