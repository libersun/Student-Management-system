package curriculum_Design;


import java.util.*;
import java.io.*;

public class IOSystemOfStudent {
	public  void saveSystemOfStudent(List<Student> students) throws IOException{//文件保存
		File fp=new File("D:\\students.txt");//创建一个文件（文件路径）
		if(!fp.exists()) {//异常处理
			try {
				fp.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fp, false),"UTF-8"));//装饰模式	把数据写到文件里
			StringBuffer data = new StringBuffer();//当在一个循环中将许多字符串连接在一起时，使用 StringBuffer。(定义一个字符串，用来把具体的东西写进这里)
			for (int i = 0; i<students.size(); i++) {//用append方法将数据进行处理				
				//具体存储学生的什么信息存储在这
				data.append(students.get(i).getId());//存学号	
				data.append("," + students.get(i).getName());//存姓名
				data.append("," + students.get(i).getAge());//存年龄
				data.append("," + students.get(i).getMath());//存数学成绩
				data.append("," + students.get(i).getEnglish());//存英语成绩
				data.append("," + students.get(i).getC());//存C语言成绩
				data.append("," + students.get(i).getJava());//存Java成绩
				data.append("," + students.get(i).getDatabase());//存数据库成绩
				data.append("," + students.get(i).getScore());//存总成绩
				data.append("\n");
				}
			System.out.println("学生信息分别是：学号，姓名，年龄，数学成绩，英语成绩，c语言成绩，Java成绩，数据库成绩，总成绩");
			System.out.println(data);//输出写入的数据
			bw.write(data.toString());//将数据写入文件中
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("文件写入成功");
	}
	public List<Student> getSystemOfStudent()throws FileNotFoundException {//文件读取
		File fp=new File("D:\\students.txt");
		List<Student> students=new ArrayList<Student>();
		String studentsInfo = "";
		try {
			if(fp.exists()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fp),"UTF-8"));//装饰模式
				String infoData = null;
				while ((infoData = br.readLine()) != null) {//一行一行读取	
					studentsInfo += infoData;			
					studentsInfo += "\n";				
				}
				br.close();
				String[] infoArr = studentsInfo.split("\n");//将字符串按\n拆分
				for (int i=0; i<infoArr.length; i++) {	
					String[] stuArr = infoArr[i].split(",");//每行按逗号拆分	
					if (stuArr.length > 0) {		
						Student s = new Student();	
						s.setId(Integer.parseInt(stuArr[0]));	//读取学号		
						s.setName(stuArr[1]);					//读取姓名
						s.setAge(Integer.parseInt(stuArr[2]));		//读取年龄
						s.setMath(Double.parseDouble(stuArr[3]));	//读取数学成绩
						s.setEnglish(Double.parseDouble(stuArr[4]));	//读取英语成绩
						s.setC(Double.parseDouble(stuArr[5]));	//读取c语言成绩
						s.setJava(Double.parseDouble(stuArr[6]));	//读取Java成绩
						s.setDatabase(Double.parseDouble(stuArr[7]));	//读取数据库成绩
						s.setScore(Double.parseDouble(stuArr[8]));	//读取总成绩成绩
						
						
						students.add(s); // 将每个student写入列表			
					}					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			return students;
	}
}