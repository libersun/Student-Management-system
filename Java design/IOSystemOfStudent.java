package curriculum_Design;


import java.util.*;
import java.io.*;

public class IOSystemOfStudent {
	public  void saveSystemOfStudent(List<Student> students) throws IOException{//�ļ�����
		File fp=new File("D:\\students.txt");//����һ���ļ����ļ�·����
		if(!fp.exists()) {//�쳣����
			try {
				fp.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fp, false),"UTF-8"));//װ��ģʽ	������д���ļ���
			StringBuffer data = new StringBuffer();//����һ��ѭ���н�����ַ���������һ��ʱ��ʹ�� StringBuffer��(����һ���ַ����������Ѿ���Ķ���д������)
			for (int i = 0; i<students.size(); i++) {//��append���������ݽ��д���				
				//����洢ѧ����ʲô��Ϣ�洢����
				data.append(students.get(i).getId());//��ѧ��	
				data.append("," + students.get(i).getName());//������
				data.append("," + students.get(i).getAge());//������
				data.append("," + students.get(i).getMath());//����ѧ�ɼ�
				data.append("," + students.get(i).getEnglish());//��Ӣ��ɼ�
				data.append("," + students.get(i).getC());//��C���Գɼ�
				data.append("," + students.get(i).getJava());//��Java�ɼ�
				data.append("," + students.get(i).getDatabase());//�����ݿ�ɼ�
				data.append("," + students.get(i).getScore());//���ܳɼ�
				data.append("\n");
				}
			System.out.println("ѧ����Ϣ�ֱ��ǣ�ѧ�ţ����������䣬��ѧ�ɼ���Ӣ��ɼ���c���Գɼ���Java�ɼ������ݿ�ɼ����ܳɼ�");
			System.out.println(data);//���д�������
			bw.write(data.toString());//������д���ļ���
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("�ļ�д��ɹ�");
	}
	public List<Student> getSystemOfStudent()throws FileNotFoundException {//�ļ���ȡ
		File fp=new File("D:\\students.txt");
		List<Student> students=new ArrayList<Student>();
		String studentsInfo = "";
		try {
			if(fp.exists()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fp),"UTF-8"));//װ��ģʽ
				String infoData = null;
				while ((infoData = br.readLine()) != null) {//һ��һ�ж�ȡ	
					studentsInfo += infoData;			
					studentsInfo += "\n";				
				}
				br.close();
				String[] infoArr = studentsInfo.split("\n");//���ַ�����\n���
				for (int i=0; i<infoArr.length; i++) {	
					String[] stuArr = infoArr[i].split(",");//ÿ�а����Ų��	
					if (stuArr.length > 0) {		
						Student s = new Student();	
						s.setId(Integer.parseInt(stuArr[0]));	//��ȡѧ��		
						s.setName(stuArr[1]);					//��ȡ����
						s.setAge(Integer.parseInt(stuArr[2]));		//��ȡ����
						s.setMath(Double.parseDouble(stuArr[3]));	//��ȡ��ѧ�ɼ�
						s.setEnglish(Double.parseDouble(stuArr[4]));	//��ȡӢ��ɼ�
						s.setC(Double.parseDouble(stuArr[5]));	//��ȡc���Գɼ�
						s.setJava(Double.parseDouble(stuArr[6]));	//��ȡJava�ɼ�
						s.setDatabase(Double.parseDouble(stuArr[7]));	//��ȡ���ݿ�ɼ�
						s.setScore(Double.parseDouble(stuArr[8]));	//��ȡ�ܳɼ��ɼ�
						
						
						students.add(s); // ��ÿ��studentд���б�			
					}					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			return students;
	}
}