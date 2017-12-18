import java.util.Random;
import java.util.ArrayList;

class Passenger { 
  
  static String[] fNames = { "Alan", "Adam", "Aaron", "Albert", "Anthony", "Andreas", "Abram", "Bob", "Bill", "Ben", "Bernie", "Barry", "Boris", "Christopher", "Carmine", "Carlos", "Charlie", "Christian", "Chuck", "Derrick", "Dimitris", "David", "Dennis", "Darrell", "Dino", "Edwin", "Ellias", "Emanuel", "Erik", "Freddy", "Frank", "Gabriel", "Gavin", "Gayle", "Gerrard", "Gilbert", "Harry", "Henry", "Homer", "Ivan", "Jake", "Jacob", "James", "Jean", "John", "Maria", "Jessica", "Helen",
  "Karl", "Kevin", "Kurtis", "Lance", "Lauren", "Leonard", "Lewis", "Matt", "Mark", "Marvin", "Matthew", "Ned", "Neal", "Norman", "Nick", "Oliver", "Orlando", "Pablo", "Paris", "Patrick", "Paul", "Pedro", "Peter", "Philip", "Rafael", "Richard", "Rick", "Reynaldo", "Robert", "Ronald", "Ryan", "Sammy", "Samuel", "Scott", "Sean", "Sebastian", "Sergio","Shedlon", "Stan", "Steven", "Stewart", "Ted", "Theodore", "Taylor", "Timothy", "Tom", "Tonnie", "Trevor", "Wallace", "Wilbert", "William", "Wilferd", "Willy", "Xavier", "Young", "Zack", "Zach", "Amanda", "Jaimie", "Upahar", "Irene", "Loren", "Christina", "Anna Maria", "Melanie", "Claire", "Katherine", "Lea", "Nantia", "Delilah", "Margaret", "Dory", "Nina", "Fran", "Amy", "Lola", "Rita", "Joy", "Gabriella", "Georgia","Jasmine"};
  static String[] lNames = {"Anderson", "Allison", "Andreou", "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Thomas", "Jackson", "White", "Harris", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez" , "King", "Wright" , "Nikolaou", "Antoniou", "Papastamatis", "Papanastasiou", "Filikakis", "Lopez", "Hill", "Scott", "Green", "Baker", "Gonzalez", "Nelson", "Carter", "Markesinis", "Diamantidis", "Stafanakis", "Kremezis", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Cambell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Cook", "Morgan", "Bell", "Murphy", "Diamantopoulou", "Savvas", "Zafeirakis", "Hristou", "Baily", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Grey", "Ramirez", "James", "Watson", "Warson", "Herrera", "Brooks", "Kelly","Sanders", "Ross", "Henderson", "Coleman", "Kouzanis", "Stylianopoulos", "Filipaki", "Foster", "Griffin", "Ford", "Hamilton", "Graham", "West", "Jordan" , "Owen", "Freeman" , "Tucker", "Porter", "Henry" , "Daniels", "Perkins", "Carroll", "Snyder", "Hristodoulopoulos", "Katrakis", "Spiliopoulos", "Demetropoulou", "Drakontaidi", "Hart", "Schimdt" };
  static String[] addresses = {"Queens", "Brooklyn", "the Bronx", "Staten Island", "Manhattan" };
  
  private String firstName;
  private String lastName;
  private String address1;
  private int address2;
  private long phone;
  
  public Passenger() { 
    firstName = pickone(fNames);
    lastName = pickone(lNames);
    address1 = pickone(addresses);
    address2 = generateAddress();
    phone = generatePhone();
  }
  
  public Passenger(String firstName, String lastName, String address1, int address2, long phone){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address1 = address1;
    this.address2 = address2;
    this.phone = phone;
  }
  
  public String getFirstName () {
    return firstName;
  }
  
  public String getLastName(){
    return lastName;
  }
  
  public String getAdrress1(){
    return address1;
  }
  
  public int getAdrress2(){
    return address2;
  }
  
  public long getPhone(){
    return phone;
  }
  
  private String pickone(String[] choices){
    Random x = new Random();
    return choices[ x.nextInt(choices.length) ];
  }
  
  private int generatePhone(){
    Random x = new Random();
    int answer = x.nextInt(9999999);
    return answer;
  }
  
  private int generateAddress(){
    Random x = new Random();
    int answer = x.nextInt(99);
    return answer;
  }
  
  public String toString () { 
    return "Name: " + firstName + " " + lastName + "\nAddress: " + address1 + ", " + address2 + "th street\nPhone number: " + phone;
  }
  
  public String returnName(){
    return firstName + " " + lastName;
  }
}
