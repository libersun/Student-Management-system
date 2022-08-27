package curriculum_Design;

import java.util.*;
import java.io.*;

public class School {
	List<Student> students = new ArrayList<Student>();// ����һ��Student���͵������б�
	public School(List<Student> students) {
		this.students = students;
	}
	
	
	public int find(int id)//��ѧ��Ϊ��׼����֤ѧ���Ƿ��Ѵ���
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
	
	
	
	public void addStudent(Student stu) {// ʵ��ѧ����Ϣ����ӣ�������Ĳ���stu����student�б����棩
		
		students.add(stu);
		System.out.println("��ӳɹ�");
	}
	
	public void removeStudent(int id) {// ʵ��ѧ����Ϣ��ɾ��
		Student stu = null;//����һ��ѧ�������ã���ʱ��ѧ������
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).id==id) {//�ж��б�ĵ�i��ѧ���������Ƿ�����������������ͬ
				stu = students.get(i);
			}
		}
		if (students.contains(stu) == false) {// �ж�ѧ����Ϣ�Ƿ��������б���
			System.out.println("û�и�ѧ����Ϣ");
		} else {
			students.remove(stu);//ArrayList�����remove����
			System.out.println("ɾ���ɹ�");
		}
	}
	
	
	public void changeStudent(Student stu) {// ʵ��ѧ����Ϣ���޸�
		int i;
		for (i = 0; i < students.size(); i++) {// ��forѭ���ҵ�Ҫ�滻�Ķ�������
			if (students.get(i).id==stu.id) {
				students.set(i, stu);// ��set������ArrayList���б����Դ��ķ������޸���Ϣ
				System.out.println("�޸ĳɹ�");
				break;//�޸��������ѭ��
			} 
		}
		if(i==students.size())
		{
			System.out.println("û�и�ѧ����Ϣ");
		}
	}
	
	
	public void sorted() {// ʵ�ְ��ܳɼ�����ѧ����Ϣ������
		Student stu = null;
		for (int i = 0; i < students.size() - 1; i++) {// ʹ��ð�������ܳɼ�����
			for (int j = 0; j < students.size() - 1 - i; j++) {
				if (students.get(j).getScore() > students.get(j + 1).getScore()) {
					stu = students.get(j);//����ʱ����stu�洢λ��Ϊj�Ķ�ӦԪ��ֵ
					students.set(j, students.get(j + 1));//�ѵ�j+1λ�õ�Ԫ��ֵ�ŵ���j����λ����		// ��set�����޸���Ϣ��ArrayList��set��int index,E element��,indexΪ����������EΪ����ķ��ͣ�elementΪҪ�滻��ȥ��Ԫ�أ�
					students.set(j + 1, stu);//�ѵ�j��λ�õ�Ԫ�طŵ�j+1��
					stu = null;//һ��jѭ��������ʱ����stu��գ��Ա���һ��jѭ��ʹ��
				}
			}
		}
	}
	
	
	public void seeked(int id) {// ʵ��ѧ����Ϣ�Ĳ�ѯ
		int i;
		for (i = 0; i < students.size(); i++) {
			if (students.get(i).id==id) {
				System.out.println(students.get(i).toString());// ������д��toString����
				break;
			}
		}
		if(i==students.size())
		{
			System.out.println("û�и�ѧ����Ϣ");
		}
	}
	
	
	
	public void inputAllScore(int id) {//¼���ѧ�������гɼ��ķ���������Ϊ��ѧ��ѧ��
		Scanner sc=new Scanner(System.in);
		Student stu=null;
		for(int i=0;i<students.size();i++)//���Ȳ�ѯ��ѧ���Ƿ���student�б���
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//����ҵ��˸�ѧ��
			System.out.println("��������ѧ�ɼ���");
			stu.math=sc.nextDouble();
			System.out.println("������Ӣ��ɼ���");
			stu.english=sc.nextDouble();
			System.out.println("������c���Գɼ���");
			stu.c=sc.nextDouble();
			System.out.println("������Java�ɼ���");
			stu.java=sc.nextDouble();
			System.out.println("���������ݿ�ɼ���");
			stu.database=sc.nextDouble();
			stu.caScore();//¼���Ŀ�ɼ���ͬʱ�����ܳɼ�
		}else {
			System.out.println("�����޸�ѧ������");
		}
		
	}

	
	public void outputAllScore(int id) {//�����ѧ�������гɼ��ķ���������Ϊ��ѧ������
		Student stu=null;
		for(int i=0;i<students.size();i++)//���Ȳ�ѯ��ѧ���Ƿ���student�б���
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//����ҵ��˸�ѧ��
			System.out.println("��ѧ����ѧ�ɼ�Ϊ��"+stu.getMath());
			System.out.println("��ѧ��Ӣ��ɼ�Ϊ��"+stu.getEnglish());
			System.out.println("��ѧ��c���Գɼ�Ϊ��"+stu.getC());
			System.out.println("��ѧ��Java�ɼ�Ϊ��"+stu.getJava());
			System.out.println("��ѧ�����ݿ�ɼ�Ϊ��"+stu.getDatabase());
		}else {
			System.out.println("�����޸�ѧ������");
		}
	}
	
	
	public void changeScore(int id) {//�޸�ĳѧ���ɼ��ķ���������Ϊ��ѧ��ѧ��
		Student stu=null;
		for(int i=0;i<students.size();i++)//���Ȳ�ѯ��ѧ���Ƿ���student�б���
		{
			if(students.get(i).id==id)
			{
				stu=students.get(i);
			}
		}
		
		if(students.contains(stu)) {//����ҵ��˸�ѧ��
			Scanner sc=new Scanner(System.in);
			System.out.println("�������ѧ���µ���ѧ�ɼ���");stu.math=sc.nextDouble();
			System.out.println("�������ѧ���µ�Ӣ��ɼ���");stu.english=sc.nextDouble();
			System.out.println("�������ѧ���µ�c���Գɼ���");stu.c=sc.nextDouble();
			System.out.println("�������ѧ���µ�Java�ɼ���");stu.java=sc.nextDouble();
			System.out.println("�������ѧ���µ����ݿ�ɼ���");stu.database=sc.nextDouble();
			stu.caScore();//�޸Ŀ�Ŀ�ɼ���ͬʱ�����ܳɼ�
			System.out.println("�޸���Ϣ�ɹ���");		
		}else {
			System.out.println("�����޸�ѧ������");
		}
	}
	
	
	
	ArrayList<Student> A=new ArrayList<Student>();//����һ����̬�ַ���������A���������泬��90�ֵ�ѧ����Ϣ
	ArrayList<Student> B=new ArrayList<Student>();//����һ����̬�ַ���������B���������治�����ѧ����Ϣ
	public void opGoodStuMessage() {//�������ĳ��Ŀ�ɼ�����90�ֵ�ѧ����Ϣ�ķ���
		if(A.size()==0)
		{
			System.out.println("�ÿ�Ŀ�޳ɼ�����90�ֵ�ѧ��");
		}
		for(int i=0;i<A.size();i++)
		{
			System.out.println("������"+A.get(i).getName()+",ѧ�ţ�"+A.get(i).getId()+",���䣺"+A.get(i).getAge());
		}
		
	}

	public void opBadStuMessage() {//�������������ѧ����Ϣ�ķ���
		if(B.size()==0)
		{
			System.out.println("�ÿ�Ŀ�޳ɼ��������ѧ��");
		}
		for(int i=0;i<B.size();i++)
		{
			System.out.println("������"+B.get(i).getName()+",ѧ�ţ�"+B.get(i).getId()+",���䣺"+B.get(i).getAge());
		}
		
	}
	
	
	
	public void opSubject() {//�ɼ�ͳ�Ƶķ���
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1������ѧ��2����Ӣ�3����c���ԣ�4����Java,5�������ݿ�");
		System.out.println("������Ҫ��ѯ�Ŀ�Ŀ�ı�ţ�");int x=sc.nextInt();
		switch(x) {
		
		//��ѧmath
		case 1:
			double max=0.0;//��Ϊ��ʱ�����洢�ȽϽ�����������������߷�
			String name = null;//��Ϊ��ʱ����������߳ɼ���ѧ������
			int id = 0;//��Ϊ��ʱ����������߳ɼ���ѧ��ѧ��
			double sum=0.0;//����ÿ�Ŀ�ĳɼ��ܷ���
			int numGood=0;//�ÿ�Ŀ����90�ֵ�ѧ������
			int numBad=0;//�ÿ�Ŀ�������ѧ������
			
			
			for(int i=0;i<students.size();i++)
			{
				if(students.get(i).getMath()>90)
				{
					A.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
					numGood=numGood+1;//����
				}
				if(students.get(i).getMath()<60)
				{
					B.add(students.get(i));//�Ѹÿ�Ŀ�������ѧ����Ϣ���붯̬����B����
					numBad=numBad+1;//����
				}
				
				sum+=students.get(i).getMath();//���иÿ�Ŀȫ���˳ɼ������
				//��ÿ�Ŀ����߷ֵ�ѧ�������޷���
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
			System.out.println("�ÿ�Ŀ�ɼ���ߵ�ѧ������Ϊ��"+name+"��ѧ��Ϊ��"+id);
			System.out.println("�ÿ�Ŀ�γ̵�ƽ���ɼ��ǣ�"+sum/students.size());
			System.out.println("�ÿ�Ŀ����90�ֵ�ѧ����ϢΪ��");opGoodStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����90�ֵ�����Ϊ��"+numGood);
			System.out.println("�ÿ�Ŀ�������ѧ����ϢΪ��");opBadStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����������Ϊ��"+numBad);
			A.clear();//�������A��Ԫ��
			B.clear();//�������B��Ԫ��
			break;
		
			
		//Ӣ��english
		case 2:
			double max1=0.0;//��Ϊ��ʱ�����洢�ȽϽ��
			String name1 = null;//��Ϊ��ʱ����������߳ɼ���ѧ������
			int id1 = 0;//��Ϊ��ʱ����������߳ɼ���ѧ��ѧ��
			double sum2=0.0;
			int numGood1=0;//�ÿ�Ŀ����90�ֵ�ѧ������
			int numBad1=0;//�ÿ�Ŀ�������ѧ������
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getEnglish()>90)
				{
					A.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
					numGood1=numGood1+1;
				}
				if(students.get(i).getEnglish()<60)
				{
					B.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
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
			
			System.out.println("�ÿ�Ŀ�ɼ���ߵ�ѧ������Ϊ��"+name1+"��ѧ��Ϊ��"+id1);
			System.out.println("�ÿ�Ŀ�γ̵�ƽ���ɼ��ǣ�"+sum2/students.size());
			System.out.println("�ÿ�Ŀ����90�ֵ�ѧ����ϢΪ��");opGoodStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����90�ֵ�����Ϊ��"+numGood1);
			System.out.println("�ÿ�Ŀ�������ѧ����ϢΪ��");opBadStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����������Ϊ��"+numBad1);
			A.clear();//�������AԪ��
			B.clear();//�������BԪ��
			break;
		
		//c���� c
		case 3:
			double max2=0.0;//��Ϊ��ʱ�����洢�ȽϽ��
			String name2 = null;//��Ϊ��ʱ����������߳ɼ���ѧ������
			int id2 = 0;//��Ϊ��ʱ����������߳ɼ���ѧ��ѧ��
			double sum3=0.0;
			int numGood11=0;//�ÿ�Ŀ����90�ֵ�ѧ������
			int numBad11=0;//�ÿ�Ŀ�������ѧ������
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getC()>90)
				{
					A.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
					numGood11=numGood11+1;
				}
				if(students.get(i).getC()<60)
				{
					B.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
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
			System.out.println("�ÿ�Ŀ�ɼ���ߵ�ѧ������Ϊ��"+name2+"��ѧ��Ϊ��"+id2);
			System.out.println("�ÿ�Ŀ�γ̵�ƽ���ɼ��ǣ�"+sum3/students.size());
			System.out.println("�ÿ�Ŀ����90�ֵ�ѧ����ϢΪ��");opGoodStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����90�ֵ�����Ϊ��"+numGood11);
			System.out.println("�ÿ�Ŀ�������ѧ����ϢΪ��");opBadStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����������Ϊ��"+numBad11);
			A.clear();//�������AԪ��
			B.clear();//�������BԪ��
			break;
			
			
		//Java 
		case 4:
			double max3=0.0;//��Ϊ��ʱ�����洢�ȽϽ��
			String name3 = null;//��Ϊ��ʱ����������߳ɼ���ѧ������
			int id3 = 0;//��Ϊ��ʱ����������߳ɼ���ѧ��ѧ��
			double sum4=0.0;
			int numGood111=0;//�ÿ�Ŀ����90�ֵ�ѧ������
			int numBad111=0;//�ÿ�Ŀ�������ѧ������
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getJava()>90)
				{
					A.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
					numGood111=numGood111+1;
				}
				if(students.get(i).getJava()<60)
				{
					B.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
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
			System.out.println("�ÿ�Ŀ�ɼ���ߵ�ѧ������Ϊ��"+name3+"��ѧ��Ϊ��"+id3);
			System.out.println("�ÿ�Ŀ�γ̵�ƽ���ɼ��ǣ�"+sum4/students.size());
			System.out.println("�ÿ�Ŀ����90�ֵ�ѧ����ϢΪ��");opGoodStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����90�ֵ�����Ϊ��"+numGood111);
			System.out.println("�ÿ�Ŀ�������ѧ����ϢΪ��");opBadStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����������Ϊ��"+numBad111);
			A.clear();//�������AԪ��
			B.clear();//�������BԪ��
			break;
			
		//���ݿ�database
		default :
			double max4=0.0;//��Ϊ��ʱ�����洢�ȽϽ��
			String name4 = null;//��Ϊ��ʱ����������߳ɼ���ѧ������
			int id4 = 0;//��Ϊ��ʱ����������߳ɼ���ѧ��ѧ��
			double sum5=0.0;
			int numGood1111=0;//�ÿ�Ŀ����90�ֵ�ѧ������
			int numBad1111=0;//�ÿ�Ŀ�������ѧ������
			for(int i=0;i<students.size();i++)//
			{
				if(students.get(i).getDatabase()>90)
				{
					A.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
					numGood1111=numGood1111+1;
				}
				if(students.get(i).getDatabase()<60)
				{
					B.add(students.get(i));//�Ѹÿ�Ŀ����90�ֵ�ѧ����Ϣ���붯̬����A����
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
			System.out.println("�ÿ�Ŀ�ɼ���ߵ�ѧ������Ϊ��"+name4+"��ѧ��Ϊ��"+id4);
			System.out.println("�ÿ�Ŀ�γ̵�ƽ���ɼ��ǣ�"+sum5/students.size());
			System.out.println("�ÿ�Ŀ����90�ֵ�ѧ����ϢΪ��");opGoodStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����90�ֵ�����Ϊ��"+numGood1111);
			System.out.println("�ÿ�Ŀ�������ѧ����ϢΪ��");opBadStuMessage();//�����Ϣ�ķ���
			System.out.println("�ÿ�Ŀ����������Ϊ��"+numBad1111);
			A.clear();//�������AԪ��
			B.clear();//�������BԪ��
			break;
		}
	}
	

	

	
	
	
}