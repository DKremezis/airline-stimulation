import java.util.Random;

class Tickets { 
  
  static int counter = 0;
  
  private int ticketNumber;
  private Passenger myPassenger;
  private String myAirline;
  private Flight myFlight;
  private int price;
  
  public Tickets (){
  }
  
  
  public Tickets (Passenger myPassenger, Flight myFlight) {
    this.myPassenger = myPassenger;
    this.myFlight = myFlight;
    this.myAirline = myAirline;
    ticketNumber = counter;
    price = generatePrice();
    counter++;
  }
  
  public int getTicketNumber() {
    return ticketNumber;
  }
  
  public Passenger getMyPassenger(){
    return myPassenger;
  }
  
  public String getMyAirline(){
    return myAirline;
  }
  
  public Flight getMyFlight(){
    return myFlight;
  }
  
  public void setTicketNumber(int ticketNumber){
    this.ticketNumber = ticketNumber;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  public void setMyPassenger(Passenger myPassenger){
    this.myPassenger = myPassenger;
  }
  
  public void setMyFlight(Flight myFlight){
    this.myFlight = myFlight;
  }
  
  
  public int generatePrice(){
    return this.myFlight.getFilledSeats() * 10 + 100; 
  }
    
    
   public Flight returnFlight(){
     return myFlight;
   }
  
    
  public String toString(){
    return "Passenger: " + myPassenger.returnName() + myFlight.toString() + "\nPrice: $" + price + "\n" +
            "Ticket Number: " + ticketNumber + "\n";
  }
    
}
