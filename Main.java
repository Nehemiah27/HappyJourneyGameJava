package journey;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to Nehemiah's Happy Journey Game\n\n" + "About the Game:-\n\n"
				+ "There are 3 Officials(represented with the letter 'b') and \n"
				+ "The Officials are holding luggage(represented with the letter 'a')\n"
				+ "The Officials are waiting in the Lobby with their Luggage\n"
				+ "After a day long Meeting, Officials got tired\n"
				+ "Company managed to arrange only one Servant to help the Officials\n"
				+ "The goal is to make the Officials reach the cab with their luggage\n\n"
				+ "There are 3 constraints\n\n" + "Constraint no.1:\n" + "At any point of time,\n"
				+ "Officals either in Cab/at Lobby should be lesser/equal to the Luggage\n"
				+ "Otherwise, Officials might think the company have impolite culture\n"
				+ "That might also leads to an Unhappy Journey\n\n" + "Contraint no. 2:\n"
				+ "The Servant can handle entities that are lesser/equal to 2\n" + "i.e., He can handle\n"
				+ "       a. Offical+Luggage\n" + "       b. Luggage+Luggage\n" + "       c. Official+Official\n\n"
				+ "Constraint no. 3:\n" + "The Servant has autophobia\n"
				+ "So, he told the Officials that he needs atleast one entity with him\n"
				+ "Official/Luggage in the process of helping the officials reach the cab\n\n"
				+ "Is it possible for the Officals to have a Happy Journey\n"
				+ "If yes, Can you please tell the steps to guide the Servant\n\n"
				+ "Please note the the letter 'x' indicates blank/no entity at Cab/Lobby\n"
				+ "Also note, Incase, you want one entity to be reached at Once\n"
				+ "In such case, enter the letter 'n', for the pair entity\n\n");

		while (true) {
			char[] lobby = { 'a', 'a', 'a', 'b', 'b', 'b' };
			char[] cab = { 'x', 'x', 'x', 'x', 'x', 'x' };
			System.out.println("Now, The Entities in the Lobby are");
			for (int i = 0; i < 6; i++) {
				System.out.print(lobby[i] + " ");
			}
			System.out.println();
			System.out.println("Now, The Entities in the Cab are ");
			for (int i = 0; i < 6; i++) {
				System.out.print(cab[i] + " ");
			}
			System.out.println();
			System.out.println("Now, The Servant is at Lobby");
			System.out.println("Lets start the Game!");
			System.out.println();
			int auditor = 0;
			int moves = 0;
			int countOfaInLobby = 0;
			int countOfbInLobby = 0;
			int countOfaInCab = 0;
			int countOfbInCab = 0;
			int countOfX = 0;
			while (auditor != 6) {
				System.out.print("Enter/Select the pair that Servant should have now from the ");
				if (moves % 2 == 0) {
					System.out.println("Lobby");
				} else {
					System.out.println("Cab");
				}
				char input1 = scn.next().charAt(0);
				char input2 = scn.next().charAt(0);
				while ((input1 != 'a' && input1 != 'b' && input1 != 'n')
						|| (input2 != 'a' && input2 != 'b' && input2 != 'n')) {
					System.out.print("Servant is confused with the Inputs provided by you\n"
							+ "Please, Check your inputs & command once more for 2 entities\n");
					input1 = scn.next().charAt(0);
					input2 = scn.next().charAt(0);

				}
				while (input1 == 'n' && input2 == 'n') {
					System.out.println("You need to Select atleast One Entity");
					input1 = scn.next().charAt(0);
					input2 = scn.next().charAt(0);
					while ((input1 != 'a' && input1 != 'b' && input1 != 'n')
							|| (input2 != 'a' && input2 != 'b' && input2 != 'n')) {
						System.out.print("Servant is confused with the Inputs provided by you\n"
								+ "Please, Check your inputs & command once more for 2 entities\n");
						input1 = scn.next().charAt(0);
						input2 = scn.next().charAt(0);

					}
				}

				if (input1 == 'n') {
					input1 = 'y';
				}
				if (input2 == 'n') {
					input2 = 'y';
				}
				char place1 = input1;
				char place2 = input2;

				if (moves % 2 == 0) {
					for (int i = 0; i < 6; i++) {
						if (lobby[i] == input1 && input1 != 'y') {
							lobby[i] = 'x';
							input1 = 'y';
						}
						if (lobby[i] == input2 && input2 != 'y') {
							lobby[i] = 'x';
							input2 = 'y';
						}
						if (cab[i] == 'x' && place1 != 'y') {
							cab[i] = place1;
							place1 = 'y';
						}
						if (cab[i] == 'x' && place2 != 'y') {
							cab[i] = place2;
							place2 = 'y';
						}
					}
					System.out.println("Now, The Entities in the Lobby are ");
					for (int i = 0; i < 6; i++) {
						System.out.print(lobby[i] + " ");
					}
					System.out.println();
					System.out.println("Now, The Entities in the Cab are ");
					for (int i = 0; i < 6; i++) {
						System.out.print(cab[i] + " ");
					}
					System.out.println();
					System.out.println("The Servant has now reached the Cab");
				} else {
					for (int i = 0; i < 6; i++) {
						if (cab[i] == input1 && input1 != 'y') {
							cab[i] = 'x';
							input1 = 'y';
						}
						if (cab[i] == input2 && input2 != 'y') {
							cab[i] = 'x';
							input2 = 'y';
						}
						if (lobby[i] == 'x' && place1 != 'y') {
							lobby[i] = place1;
							place1 = 'y';
						}
						if (lobby[i] == 'x' && place2 != 'y') {
							lobby[i] = place2;
							place2 = 'y';
						}
					}
					System.out.println("Now, The Entities in the Lobby are ");
					for (int i = 0; i < 6; i++) {
						System.out.print(lobby[i] + " ");
					}
					System.out.println();

					System.out.println("Now, The Entities in the Cab are ");
					for (int i = 0; i < 6; i++) {
						System.out.print(cab[i] + " ");
					}
					System.out.println();
					System.out.println("The Servant has now reached the Lobby");
				}
				for (int i = 0; i < 6; i++) {
					if (lobby[i] == 'x') {
						auditor++;
						countOfX++;
					}
					if (cab[i] == 'x') {
						countOfX++;
					}
					if (lobby[i] == 'a') {
						countOfaInLobby++;
					}

					if (lobby[i] == 'b') {
						countOfbInLobby++;
					}
					if (cab[i] == 'a') {
						countOfaInCab++;
					}

					if (cab[i] == 'b') {
						countOfbInCab++;
					}
				}
				if (countOfaInLobby != 0 && countOfbInLobby > countOfaInLobby) {
					auditor = 6;

					System.out.print("\nReason for the Wrong Step is that the Lobby Violated the Rule\n"
							+ "The entities in the Lobby are\n");
					System.out.println();
					for (int j = 0; j < 6; j++) {
						System.out.print(lobby[j] + " ");
					}
				} else if (countOfaInCab != 0 && countOfbInCab > countOfaInCab) {
					auditor = 6;
					System.out.print("\nReason for the Wrong Step is that the Cab Violated the Rule\n"
							+ "The entities in the Cab are\n");
					for (int j = 0; j < 6; j++) {
						System.out.print(cab[j] + " ");
					}
				} else if (countOfX != 6) {
					auditor = 6;
				}

				else {
					countOfaInLobby = 0;
					countOfbInLobby = 0;
					countOfaInCab = 0;
					countOfbInCab = 0;
					countOfX = 0;
				}
				if (auditor != 6) {
					auditor = 0;
				}
				moves++;
				System.out.println();
			}
			int check = 0;
			for (int i = 0; i < 6; i++) {
				if (lobby[i] == 'x') {
					check++;
				}
			}
			if (moves < 11 && check == 6) {
				System.out.println("Kudos to you!\n" + "You are Super Smart & Amazing\n"
						+ "You've completed the game in " + moves + " " + "Steps\n"
						+ "Even, the admin is not able to find such an optimized approach\n"
						+ "Can you reach/mail at nehemiah2015s@gmail.com\n"
						+ "He has a surprise for you, He is willing to buy a Coffee for you\n" + "See you Soon!");
			} else if (check == 6 && moves > 11) {
				System.out.println("Great!\n" + "You played the game Safely & you completed it in " + moves + " "
						+ "steps\n" + "You can also play it with even in lesser steps to become smarter\n"
						+ "Be Smart & Be Safe");
			} else if (moves == 11 && check == 6) {
				System.out.println("Congratulations!\n" + "You've played the game Safely & Smartly\n"
						+ "Happy Journey & Thanks for Playing the game");
			} else {
				System.out.println("Officals got annoyed, Its an Unhappy Journey\n"
						+ "Officials & Servant are now Helpless!\n" + "Game Over!\n");
			}
			System.out.println("Want to Play again?(y/n)");
			char rePlay = scn.next().charAt(0);
			if (rePlay == 'n') {
				break;
			} else if (rePlay != 'y') {
				System.out.println("Please provide a valid Input(y/n)");
				rePlay = scn.next().charAt(0);
			}
		}
		scn.close();
	}
}