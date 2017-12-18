import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;

class Main {
  public static void main(String[] args){

    //Declaring arraylists that will be needed for objects

    Scanner in = new Scanner(System.in);
    Random x = new Random();
    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Tickets> tickets = new ArrayList<Tickets>();
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    ArrayList<Tickets> usersTickets = new ArrayList<Tickets>();
    
    Airline line = new Airline();
    line.setName("Aegean");
    
    //Setting airline name & creating 10000 random passengers
    
    for (int i=0; i<10000; i++){
      passengers.add( new Passenger() );
    }
    
    //Creating the flights
    
      for (int k=1; k<=31; k++){  
        for (int i=6; i<=22; i++){
          flights.add( new Flight("New York", "Athens", k, i) );
        }
      }
      
      for (int k=1; k<=31; k++){  
        for (int i=6; i<=22; i++){
          flights.add( new Flight("Athens", "New York", k, i) );
        }
      }
      
      //Each passenger books a random flight!
      
    for (int i=0; i<10000; i++){
      while (tickets.size() == i){ 
        int randFlight = x.nextInt(1054);
        if (flights.get(randFlight).hasSpace() ){
            tickets.add( new Tickets (passengers.get(i), flights.get(randFlight) ) );
            flights.get(randFlight).addSeat();
        }
      }
    }
                          //introduction
    intro(flights);  
    
                          //Getting user's info
    
    System.out.println("Thanks for choosing " + line.getName() + "." );
    System.out.println("Enter first name and last name:  ");
    String fname = in.next();
      if (UserWantsToExit(fname) ) sayGoodbye();
    String lname = in.next();
      if (UserWantsToExit(lname) ) sayGoodbye();
    System.out.println("Enter city: ");
    String city = in.next();
      if (UserWantsToExit(city) ) sayGoodbye();
      int str = checkInput("Street Number:",in);
    System.out.println("phone number: ");
      while (!in.hasNextLong() ){
          in.next();
          System.out.print("Please enter only numbers for phone:");
      }   long phone = in.nextLong();
    
      Passenger user = new Passenger(fname, lname, city, str, phone);
      
    System.out.println("Would you like to book or cancel a flight? Type 'exit' if you want to exit.");
    
    
                  //stimulation for booking flights starts here
    
    while(true){
      in = new Scanner(System.in);
      String answer = in.next();
      if (UserWantsToExit(answer) ) break;
      while (!answer.equals("book") && !answer.equals("cancel") ){
        error();
        answer = in.next();
        if (UserWantsToExit(answer) ) break;
      }
            //Here the user has chosen to book a flight
            
      if (UserWantsToExit(answer) ) break;
      if (answer.equals("book") ){
        System.out.println("Select day of departure for the month August 2017. ");
        int date = checkInput("Date: ", in);
        while ( (date!= (int)date) && date<1 || date>31){
          error();
          date = checkInput("Date: ", in);
        }
        System.out.println("Destination: ");
        in = new Scanner(System.in);
        answer = in.nextLine();
        if (UserWantsToExit(answer) ) break;
        answer = fixedString(answer);
        while (!answer.equals("New York") && !answer.equals("Athens") ){
          error();
           in = new Scanner(System.in);
           answer = in.nextLine();
           answer = fixedString(answer);
        }  
          System.out.println("\nAvailable flights: \n");
          for (int i=0; i<=1053; i++){
              if (flights.get(i).getDate() == date && flights.get(i).getDestination().equals(answer) ){
                if (flights.get(i).hasSpace() ){
                  System.out.println( flights.get(i).toString() + "\nPrice: $" + line.generatePrice(flights.get(i) ) );
                  flights.get(i).checkForLimitedSeating();
                }
              }
          }
          System.out.print("\nChoose your flight by typing the ");
          double time = checkIfDouble("flight number or departure time.",in);
          for (int i=0; i<=1053; i++){
            if (flights.get(i).getDate() == date && flights.get(i).getDestination().equals(answer) ){
              if ( flights.get(i).hasSpace() ) {
                if (flights.get(i).getDepartureTime() == time || flights.get(i).getFlightNumber() == time){ 
                Tickets userTicket = new Tickets(user, flights.get(i) );
                flights.get(i).addSeat();
                System.out.println("\nFlight Booked Successfully: \n" + userTicket.toString() );
                usersTickets.add(userTicket);
                break;
                }
              }
            }
            else if (i==1053){
                error(); 
                break;
              }
          }
        }
        
            //Here the user has chosen to cancel a flight
            
        boolean tickNumbCheck = false;
        if (answer.equals("cancel") ){
          if (usersTickets.isEmpty() ) {
            System.out.println("\nNo flights to cancel. To book a flight type 'book' or type 'exit' to exit. ");
            continue;
          }
          System.out.println("\nPlease, enter ticket number: ");
          int input = in.nextInt();
          for (int i=0; i<usersTickets.size(); i++){
            if (usersTickets.get(i).getTicketNumber() == input) { 
              System.out.println("\n" + usersTickets.get(i).toString() + "\nCancel flight?");
              answer = in.next();
            
              if (answer.equals("yes") ){
                line.issueRefund(usersTickets.get(i) );
                usersTickets.get(i).returnFlight().subtractSeat(); 
                line.cancel(usersTickets.get(i) );
                usersTickets.remove(i);
                tickNumbCheck=true;
                break;
              }
              else if (!answer.equals("yes") ){
                System.out.println("\nCancelation aborted.");
                tickNumbCheck=true;
                break;
              }
            }
          }
          if (!tickNumbCheck){
          System.out.println("\nSorry, there is no such ticket number in your records.");
          }
        }
        System.out.println("\nType 'book' or 'cancel' to book or cancel another flight\nType 'exit' if you're done");
      
    } 
    
    //End of mainloop. Print the booked flights (if any);
   
   System.out.println("\nYour Flights: ");
   
   for (Tickets t:usersTickets) System.out.println("-----------------------------\n" +t.toString() );
      
    System.out.println("\nThank you for choosing " + line.getName() + ".\nGoodbye!");  
      
  }
  
  //Some static methods in order to have a cleaner main 

  public static void error(){
    System.out.println("\nInvalid input. Try again");
  }
  
  public static void sayGoodbye(){
    System.out.println("\nGoodbye!");
    System.exit(0);
  }
  
  public static String fixedString(String x){
    String fixed;
    x = x.toLowerCase();
    if (x.length()>6 ) return fixed = x.substring(0,1).toUpperCase() + x.substring(1,4) 
                                      + x.substring(4,5).toUpperCase() + x.substring(5);
    else if (x.length()<=6 ) return fixed = x.substring(0,1).toUpperCase() + x.substring(1).toLowerCase();
    return x;
  }
  
  public static void intro(ArrayList flights){
    System.out.println("Welcome to Aegean's booking flight stimulation. The airline solely carries out flights between New York and Athens.\nThere are " + flights.size() + " flights for the month of August.\n" );
  }
  
  public static int checkInput(String message, Scanner in){
    while (true){
      try{
        System.out.println(message);
        int x = in.nextInt();
        return x;
      }catch (InputMismatchException n){
        System.out.print("Please enter a number for ");
        in.nextLine();
      }
    }
  }
  
  public static double checkIfDouble(String message, Scanner in){
    while (true){
      try{
        System.out.println(message);
        double x = in.nextDouble();
        return x;
      }catch (InputMismatchException n){
        System.out.print("Please enter a number for ");
        in.nextLine();
      }
    }
  }
  
  public static boolean UserWantsToExit(String str){
    if (str.equals("exit") ) return true;
    return false;
  }
  
}