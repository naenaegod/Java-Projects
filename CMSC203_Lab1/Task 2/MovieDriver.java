import java.util.Scanner;
import java.lang.*;
/*
 * Program that accepts movie info and sends it to the movie object. Spits out results and loops if needed.
 */
public class MovieDriver {

	public static void main(String[] args) {
		boolean cont = false;
		Scanner reader = new Scanner(System.in); //new scanner object
		do
		{
			
			Movie newMovie = new Movie(); //new movie object
			
			System.out.println("What is the title of the movie? "); //prompt
			String title = reader.nextLine();
			newMovie.setTitle(title); //set title
			
			System.out.println("What is the rating of the movie? "); //prompt for rating and then enter in
			title = reader.nextLine();
			newMovie.setRating(title);
			
			System.out.println("What is the number of tickets sold? "); //prompt for num of tix;
			int num = reader.nextInt();
			newMovie.setSoldTickets(num);
			
			System.out.println(newMovie.toString());
			
			System.out.println("Do you want to do another? (y/n)");
			char ape = reader.next().charAt(0);
			ape = Character.toLowerCase(ape);  //continue if needed, lowercase for fullproof check
			if (ape == 'y')
			{
				cont = true;
			}
			else
			{
				cont = false;
			}
			
			reader.nextLine();
			
		} while (cont);
		reader.close();
		System.out.println("Goodbye.");
			
			
			
			
			
			
	}
	

}
