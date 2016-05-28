package crackinginterview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*@ This class maintain persistence storage location url according to repository stored on that location*/

public class Filemanipulation {

	final static String filepath = "src/temp.csv";

	/*
	 * @ method just insert Repository url in file when the Repository is
	 * created
	 */

	public static void Fileinsertion(FileWriter outputfile, String Repourl) throws IOException {

		outputfile.append(Repourl);

		outputfile.append("\n");

		outputfile.flush();

		outputfile.close();

	}

	/* @ Repository URL store into file successfully */

	/*
	 * @ method just return Repository url from file when the Repository is
	 * retrived
	 */

	public static String searchurlinfile(String reponame) {
		try {

			File file = new File(filepath);

			Scanner o = new Scanner(file);

			while (o.hasNextLine()) {

				String line = o.nextLine();

				if (line.endsWith(reponame)) {
					return line;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/* @ Repository URL retrived from file successfully */

	/*
	 * @ method just delete Repository url from file when the Repository is
	 * deleted
	 */

	public static void deletefile(String reponame) {

		try {

			File file = new File(filepath);

			FileWriter writer = new FileWriter(filepath);

			Scanner o = new Scanner(file);

			while (o.hasNextLine()) {

				String line = o.nextLine();

				if (line.endsWith(reponame)) {

					String newtext = line.replaceAll(line, " ");

					writer.write(newtext);

					System.out.println("Done successfully");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* @ Repository URL deleted from file successfully */

}
