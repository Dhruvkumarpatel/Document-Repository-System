package crackinginterview;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.RepositoryIdHelper;

public class Retriveprocess {

	/*
	 * @ take localurl and remote repositoryurl and push repository project to
	 * particular localurl
	 */

	public static void retrive(String Repositoryurl, String localurl) throws IOException {

		File srcDir = new File(Repositoryurl);
		File destDir = new File(localurl);
		FileUtils.copyDirectory(srcDir, destDir);

		System.out.println("Project store into the local directory successfully");

	}

	/* @ successfully push project to repository */
}
