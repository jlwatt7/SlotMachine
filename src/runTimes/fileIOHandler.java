package runTimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class fileIOHandler {

	static String[] userInfo = new String[2];
	static String name = "";
	static int dollars = 0;

public static void saveData(ArrayList<User> customers) {

	Path userPath = Paths.get("UserInformation.txt");
	File userFile = userPath.toFile();

	try {
		FileReader read = new FileReader(userFile);
		BufferedReader in = new BufferedReader(read);
		
		FileWriter out = new FileWriter(userFile);
			
			for (int i = 0; i < customers.size(); i++) {
		User user = customers.get(i);
		userInfo[0] = user.getName();
		userInfo[1] = Integer.toString(user.getAccountBalance());
		
		out.append(userInfo[0] + "," + userInfo[1] +"\n");
			}
		out.close();
		in.close();
		
		} catch (FileNotFoundException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	} catch (IOException e) {
		// catches file not found exception and prints

		e.printStackTrace();
	}
}

public static ArrayList<User> readData() {
	int dollars = 0;
	String[] lineItem = new String[2];
	ArrayList<User> customers = new ArrayList<User>();

	Path userPath = Paths.get("UserInformation.txt");
	File UserFile = userPath.toFile();

	try {
		FileReader r = new FileReader(UserFile);
		BufferedReader in = new BufferedReader(r);
		String line = in.readLine();

		while (line != null) {
			if (!line.equals(""))
				lineItem = line.split(",");
			dollars = Integer.parseInt(lineItem[1]);
			User user = new User(lineItem[0], dollars);
			customers.add(user);
			line = in.readLine();
		}
		in.close();
	}

	catch (Exception e) {
		e.printStackTrace();
	}
	return customers;
}


}

