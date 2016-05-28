package crackinginterview;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class pushproject {

	/*
	 * @ take localurl and remote repositoryurl and push local project to
	 * particular repository
	 */

	public static void push(String localurl, String repositoryurl) throws IOException {

		File srcDir = new File(localurl);
		File destDir = new File(repositoryurl);
		FileUtils.copyDirectory(srcDir, destDir);

		System.out.println("Project store into the repository successfully");
	}

	/* @ successfully push project to repository */

}
