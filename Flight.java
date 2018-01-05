import java.util.Random;

class Flight {
  
  static int counter=101;
  
  private int flightNumber;
  private int seats; 
  private int filledSeats;
  private int flightLength;
  private String airline; 
  private int date;
  private String originAirport;
  private String destination;
  private double departureTime;
  

  public Flight(String originAirport, String destination, int date, double departTime){
  
    this.flightNumber = counter;
    this.originAirport = originAirport;
    this.destination = destination;
    this.flightLength = 8;
    this.seats = 12;
    this.filledSeats = 0;
    this.date = date;
    this.departureTime = departTime;
    counter++;
    if (counter==118) counter=101;
  }
  
  public Flight(int date, double departureTime){
    this.date = date;
    this.departureTime = departureTime;
  }
  
  public double getDepartureTime(){
    return departureTime;
  }
  
  public int getDate(){
    return date;
  }

  public int getFlightNumber(){
    return flightNumber;
  }
  
  public int getSeats(){
    return seats;
  }
  
  public int getFilledSeats(){
    return filledSeats;
  }
  
  public String getOriginAirport(){
    return originAirport;
  }
  public String getDestination(){
    return destination;
  }
  
  public void setFlightNumber (int flightNumber){
    this.flightNumber = flightNumber;
  }
  
  public void addSeat(){
    filledSeats++;
  }
  
  public void subtractSeat(){
    filledSeats--;
  }
  
  public boolean hasSpace(){
    return this.filledSeats < this.seats;
  }
  
  public void checkForLimitedSeating(){
    if (this.filledSeats > 10) System.out.println("--->LIMITED SEATING!");
  }
  
  
  public String toString(){
    return "\nFlight Number: " + flightNumber + "\nFrom: " + originAirport + " to: " + destination + "\nDate: 8/" + date + "/17" + "   Take off: " + departureTime +"0";
  }
  
  
}