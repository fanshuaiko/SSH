import java.io.File;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("F:\\apache-tomcat-9.0.6\\webapps\\SSH\\file");
		String[] fileName = file.list();
		for (String string : fileName) {
			System.out.println(string);
		}
	}

}
