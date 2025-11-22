/* group members:
 1- Saleh Essam Altubaishi - 446106300
 2- Mansour Salem Mohammed AlHammam-446105491
 3- Omar Mohamed O Baaiz-445109219
 */

// class:21753

// admin pasword:123

// https://github.com/OmarBaaiz/Library-Simulation-CSC111

package project;
import java.util.Scanner;
public class Library_Simulator {

	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);// Setup the input reader

	        // Predefined members
	        Member user1 = new Member(1, "User 1", 0);
	        Member user2 = new Member(2, "User 2", 0);
	        Member user3 = new Member(3, "User 3", 0);

	        boolean running= true;
	     // Start of the main program loop
	        while (running) {
	        	// Display the main menu options
	        	System.out.println("\n ( Welcome to the Library Simulation ))");
	            System.out.println("");
	            System.out.println(" choose an option:");
	            System.out.println("");
	            System.out.println("Enter 1 to login as " + user1.getName() + "   ID: " + user1.getId() );
	            System.out.println("Enter 2 to login as " + user2.getName() + "   ID: " + user2.getId() );
	            System.out.println("Enter 3 to login as " + user3.getName() + "   ID: " + user3.getId() );
	            System.out.println("Enter 4 to login as Administrator");
	            System.out.println("Enter 5 to Exit the Program");
	            System.out.println("");
	            System.out.print("Enter your choice: ");

	            int choice = input.nextInt(); // Read the user's choice
	            input.nextLine();// Consume the newline character

                // *** MAIN MENU LOGIC: USING SWITCH STATEMENT ***
                switch (choice) {
             // Cases 1, 2, and 3 handle regular member logins
                case 1:
                    case 2:
                    case 3:
                        Member current;
                     // Determine which user object was selected
                        if (choice == 1)
                            current = user1;
                        else if (choice == 2)
                            current = user2;
                        else
                            current = user3;

                        current.reset();
                        boolean sessionActive = true;// Control variable for the member session loop
                     // Display the member menu
                        while (sessionActive) {
                            System.out.println("\nWelcome  " + current.getName() );
                           System.out.println("");
                            System.out.println("Enter 1 to  View Borrowed Books Count");
                            System.out.println("Enter 2 to Borrow Book");
                            System.out.println("Enter 3 to Return Book");
                            System.out.println("Enter 4 to View Session Summary");
                            System.out.println("Enter 5 to Exit to Main Menu");
                           System.out.println("");
                            System.out.print("Choose an option: ");

                            int userOption = input.nextInt();
                            input.nextLine();

                            //  USER SESSION LOGIC: USING IF/ELSE IF STATEMENTS 
                            if (userOption == 1) {
                                current.viewBorrowedCount();
                            } else if (userOption == 2) {
                                current.borrowOne();
                            } else if (userOption == 3) {
                                current.returnOne();
                            } else if (userOption == 4) {
                                current.displayStatistics();
                            } else if (userOption == 5) {
                                System.out.println("Session ended. Total books currently borrowed: " + current.getBorrowedCount());
                                sessionActive = false;// Exit the member session loop
                            } else {
                                System.out.println("Invalid option. Try again please.");
                            }
                        }
                        break; // End of member login case

                    case 4:
                    	// Administrator login case
                    	System.out.print("Enter admin password: ");
                        String password = input.nextLine();
                     // Check the fixed admin password
                        if (!password.equals("123")) {
                            System.out.println("incorrect password");
                        } else {
                            boolean adminActive = true; // Control variable for the admin loop
                         // Start of the administrator loop
                            while (adminActive) {
                            	// Display the administrator menu                             
                            	System.out.println("\n Administrator Menu ");
                                System.out.println("");
                            	System.out.println("Enter 1 to View Total Revenue");
                                System.out.println("Enter 2 to Most Frequent Operation");
                                System.out.println("Enter 3 to Exit to Main Menu");
                               System.out.println("");
                                System.out.print("Choose an option: ");

                                int adminChoice = input.nextInt();
                                input.nextLine();
                             // Use a switch for the administrator menu
                                switch (adminChoice) {
                                    case 1:
                                    	// Display total accumulated revenue
                                        System.out.println("Total Revenue from all borrow operations: " + Member.TotalRevenue);
                                        break;
                                    case 2:
                                    	// Determine which operation (Borrow or Return) happened more often
                                    	System.out.println("Most Frequent Operation:");
                                        if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {
                                            System.out.println("- No operations performed yet.");
                                        } else if (Member.TotalBorrows > Member.TotalReturns) {
                                            System.out.println("- Borrow");
                                        } else if (Member.TotalReturns > Member.TotalBorrows) {
                                            System.out.println("- Return");
                                        } else {
                                            System.out.println("- Borrow and Return are both equivalent");
                                        }
                                        break; // End of admin login case
                                    case 3:
                                        adminActive = false; // Exit the administrator loop
                                        break;
                                    default:
                                        System.out.println("Invalid option. Try again please");
                                        break;
                                }
                            }
                        }
                        break;

                    case 5:// Exit the entire program
                        System.out.println("Thank you for using the Library Simulation. Have a nice day. ");
                        running = false;
                        break;

                    default:// Handles any choice that is not 1, 2, 3, 4, or 5
                        System.out.println("Invalid option. Try again please.");
                        break;
                }
	        }// Handles any choice that is not 1, 2, 3, 4, or 5

	        input.close(); // Close the Scanner object to free up resources
    } 
	    }
	Refactor code with Member class
