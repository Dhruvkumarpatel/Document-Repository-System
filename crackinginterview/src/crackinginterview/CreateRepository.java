package crackinginterview;

import java.io.File;
import java.util.ArrayList;

public class CreateRepository {

	static String URl = "src\\persistance storage";

	/*
	 * @ Take the repository name, create repository using URl and send back the
	 * whole path
	 */

	public static String returnurl(String repositoryname) {

		File file = new File(URl + "\\" + repositoryname);

		if (!file.exists()) {

			file.mkdirs();

			System.out.println("Repository created successfully");

		} else {

			return "yes";
		}

		return URl + "\\" + repositoryname;
	}

	/* @ generate repository/directory successfully */

}
