package crackinginterview;

import java.io.File;

public class deleterepo {

	/*
	 * @ This is for delete Repository which takes Repository url for
	 * persistence storage and delete from that location
	 */

	public static void delete(String repourl) {

		System.out.println("repourl :" + repourl);

		File file = new File(repourl);

		System.out.println(file.isDirectory());

		String[] entries = file.list();

		// recursively delete all the sub projects and documents which is inside
		// that directory

		for (String s : entries) {
			File currentFile = new File(file.getPath(), s);
			currentFile.delete();
		}

		// delete directory
		file.delete();

	}

	/*
	 * @ first delete all the file recursively and then delete the whole
	 * directory
	 */

}
