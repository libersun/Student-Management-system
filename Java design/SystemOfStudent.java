package curriculum_Design;

import java.util.*;
import java.io.*;

public class SystemOfStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//��������ѡ��ѧ������ϵͳ����
		List<Student> students = new ArrayList<Student>();
		IOSystemOfStudent io=new IOSystemOfStudent();//�Զ�����࣬������ȡ��д���ļ���Ϊ��ʹ֮ǰ�����ѧ����Ϣ����������������������ģ���
		try {
			students =io.getSystemOfStudent(); //���ļ��ж�ȡѧ����Ϣ
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		School school = new School(students);
		while(true) {
			System.out.println("��ӭʹ��ѧ������ϵͳ");
			System.out.println("1 ���ѧ����Ϣ");
			System.out.println("2 ɾ��ѧ����Ϣ");
			System.out.println("3 �޸�ѧ����Ϣ");
			System.out.println("4 �ɼ�ͳ��");
			System.out.println("5 ѧ����Ϣ��ѯ");
			System.out.println("6 ���ѧ�����Ƴɼ�");
			System.out.println("7 ��ʾָ��ѧ�������гɼ�");
			System.out.println("8 �޸�ָ��ѧ���ɼ�");
			System.out.println("��������˳�");
			System.out.println("�������ѡ��");
			String x=sc.next();//�������֣�����ѡ��ѧ������ϵͳ�Ĳ���
			switch(x) {
			case "1":
				// ѧ����Ϣ�����
				System.out.println("������ѧ����ѧ�ţ�");
				int id = sc.nextInt();
				if(school.find(id)!=-2)
				{
					System.out.println("��ѧ���Ѵ��ڣ�");
				}
				else {
				System.out.println("������ѧ����������");
				String name = sc.next();
				System.out.println("������ѧ�������䣺");
				int age = sc.nextInt();
				
//				System.out.println("������ѧ���ĳɼ���");
//				double score = sc.nextDouble();
				school.addStudent(new Student(id, name, age));
				try {
					io.saveSystemOfStudent(students);//���������ӵ���Ϣ
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				break;
			case "2":
				// ѧ����Ϣ��ɾ��	
				System.out.println("������Ҫɾ����ѧ����ѧ�ţ�"); int sno1=sc.nextInt();
				school.removeStudent(sno1);
				try {
					io.saveSystemOfStudent(students);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "3":
				// ѧ����Ϣ���޸�		//�ĳ������ĳ�ѧ�����޸�
				 System.out.println("��������Ҫ�޸�ѧ����ѧ�ţ�"); int id1=sc.nextInt();
				 System.out.println("�����޸�Ϊ��");String name2=sc.next();
				 System.out.println("�����޸�Ϊ��"); int age1=sc.nextInt();
				 //System.out.println("�ɼ��޸�Ϊ��"); double score1=sc.nextDouble();
				 school.changeStudent(new Student(id1,name2,age1));
				 try {
					io.saveSystemOfStudent(students);//����ѧ����Ϣ���ļ���
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
				 
			case "4":
				school.opSubject();//�ɼ�ͳ�Ƶķ���
				//�����ܳɼ�����ѧ����Ϣ����
				System.out.println("�����ܳɼ���С�����������˳�����£�");
				school.sorted(); //���ܳɼ������ķ���
				try {
					io.saveSystemOfStudent(students);//�����������ѧ���б�
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
				
				
			case "5":
				// ѧ����Ϣ��ѯ
				System.out.println("������Ҫ��ѯ��ѧ����ѧ�ţ�");
				int id9 = sc.nextInt();
				school.seeked(id9);
				break;
			case "6":
				// ���ѧ�����Ƴɼ�
				System.out.println("������Ҫ¼��ɼ���ѧ����ѧ�ţ�");
				int id4 = sc.nextInt();
				school.inputAllScore(id4);//¼�����п�Ŀ�ɼ��ķ���
				 try {
						io.saveSystemOfStudent(students);//����ɼ���Ϣ���浽�ļ���
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
			case "7":
				// ��ʾѧ�����Ƴɼ�
				System.out.println("������Ҫ��ʾ�ɼ���ѧ����ѧ�ţ�");
				int id2 = sc.nextInt();
				school.outputAllScore(id2);//��ʾ����ѧ�����п�Ŀ�ɼ��ķ���
				break;
			case "8":
				// �޸�ѧ�����Ƴɼ�
				System.out.println("������Ҫ�޸ĳɼ���ѧ����ѧ�ţ�");
				int id5 = sc.nextInt();
				school.changeScore(id5);//�޸ĸ�ѧ������Ŀ�ɼ��ķ���
				 try {
						io.saveSystemOfStudent(students);//�����޸ĺ����Ϣ���ļ���
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				break;
				
			default:
				System.out.println("ллʹ��");
				System.exit(0);
				break;
			}
		}
	}
}