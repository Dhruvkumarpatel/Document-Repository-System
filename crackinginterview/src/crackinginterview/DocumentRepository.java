package crackinginterview;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/*@ Main class which contains main functionality create Repository, store projcts into Repository and retrive project from repository */

public class DocumentRepository {

	public static void main(String args[]) throws IOException {

		/*
		 * @ Scanner just allow user to create Repository in this system same
		 * like Github
		 */

		Scanner o = new Scanner(System.in);

		System.out.println("please Create Repository to store your projects");

		System.out.println("please Enter Repository name");

		// Enter Repository name
		String repositoryname = o.nextLine();

		// according to name automatically create the Repository at my
		// persistence location
		String repositoryurl = CreateRepository.returnurl(repositoryname);

		// i used file to store and retrive project url
		FileWriter persistence = new FileWriter("src/temp.csv", true);

		// if it is already exists then display following message
		if (repositoryurl.equalsIgnoreCase("yes")) {
			System.out.println("Repository already exists");
		} else {

			// otherwise insert Repository url into file
			Filemanipulation.Fileinsertion(persistence, repositoryurl);
		}

		// Next Phase for PUSH(store), Retrive and Delete Repository(Project
		// Main Directory)
		System.out.println("Choose Following options");

		System.out.println("Enter 1 for PUSH your project");

		System.out.println("Enter 2 for retrive your project");

		System.out.println("Enter 3 for delete repository");

		// Enter your selection
		int selection = o.nextInt();

		switch (selection) {
		// push your project from your location to this system persistence
		// storage
		case 1:

			Scanner b = new Scanner(System.in);

			System.out.println("Enter Local project Url");

			// Enter url from your project which you want to commit,push or
			// store in created Repository system
			String projecturl = b.nextLine();

			// Repository name should be unique if it is present then you can't
			// able to create new Repository with the same name
			System.out.println("Enter Repository name");

			// Enter name
			String repository = b.nextLine();

			// According to name below method return Repository url from file
			String reporemoteurl = Filemanipulation.searchurlinfile(repository);

			// Just commit and push project from local directory to this system
			// persistence storage
			pushproject.push(projecturl, reporemoteurl);

			break;

		// Retrive Project
		case 2:

			Scanner c = new Scanner(System.in);

			// same enter your location where you want to clone or Retrive
			// project from Repository location to your system
			System.out.println("Enter local url where you want to retrive your project && enter Repository name");

			// Enter local url
			String retrivurl = c.nextLine();

			// Enter Repository name
			String retrivereponame = c.nextLine();

			// According to Repository name below method just return Repository
			// url
			String repourl = Filemanipulation.searchurlinfile(retrivereponame);

			// This method clone project from Repository url to your local url
			Retriveprocess.retrive(repourl, retrivurl);

			break;

		// Delete Repository
		case 3:

			// Enter Repository name to delete operation
			Scanner d = new Scanner(System.in);

			System.out.println("Enter Repository name for delete that repository");

			// Enter Repository name
			String repo = d.nextLine();

			// this method retun repository url from file
			String repodeleteurl = Filemanipulation.searchurlinfile(repo);

			// Delete Repository url from file which is for persistence storage
			Filemanipulation.deletefile(repo);

			// delete whole Repository from persistence storage
			deleterepo.delete(repodeleteurl);

			break;

		default:
			break;
		}

	}

}

/* @ successfully done all the functionality */
