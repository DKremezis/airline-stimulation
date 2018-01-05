class Airline { 
  
  public String name;
  
  public Airline () {
    name = "Default";
  }
  
  public String getName () { 
    return name;
  }
  
  public void setName (String x) { 
    this.name = x;
  }
  
  public int generatePrice(Flight f){
    return f.getFilledSeats() * 10 + 100; 
  }
  
  public void cancel (Tickets t){
    t = null;
  }
  
  public void issueRefund(Tickets t){
    System.out.println("\nThe amount of $" + t.getPrice() + " has been returned into your account." ); 
  }
  
  public int cost(Tickets t){
    return t.getPrice();
  }
  
  
}