package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;
import static se.lexicon.exceptions.workshop.util.UserInput.*;

public class Main {

	public static void main(String[] args) {

		List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
		List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

		List<String> lastNames = null;
		try {
			lastNames = CSVReader_Writer.getLastNames();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

		Person test = nameService.getNewRandomPerson();
		System.out.println(test);

		boolean testing = true;
		while (testing) {
			System.out.println("\nAdd new name: 1-Male, 2-Female, 3-Last name\n4-Get a random person, 0-Quit");
			switch (getIntFromLimit(4, 0)) {
			case 1:
				System.out.println("Male First Name: ");
				nameService.addMaleFirstName(getNoEmptyString());
				break;
			case 2:
				System.out.println("Female First Name: ");
				nameService.addFemaleFirstName(getNoEmptyString());
				break;
			case 3:
				System.out.println("Last Name: ");
				nameService.addLastName(getNoEmptyString());
				break;
			case 4:
				test = nameService.getNewRandomPerson();
				System.out.println(test);
				break;
			default:
				testing = false;
			}
		}
		System.out.println("End");
	}

}
