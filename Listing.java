import java.util.*;
import java.io.*;

// Start Class
public class Listing 
{
  
  // Listing Attributes  
  private String listingName;
  private int listingDate;

  // Constructor
  public Listing(String name, int date) 
  {
    this.listingName = name;
    this.listingDate = date;
  }

  // Updates listing date
  public void updateDate(int newDate) 
  {
    this.listingDate = newDate;
  }

  // Returns listing date
  public int getDate() 
  {
    return this.listingDate;
  }

  // Updates listing name
  public void updateName(String newName) 
  {
    this.listingName = newName;
  }
  
  // Returns listing name
  public String getName() 
  {
    return this.listingName;
  }

  // Start Main method
  public static void main(String[] args) 
  {
    // Variables  
    Scanner scanner = new Scanner(System.in);
    String input;
    HashMap<String, Listing> listings = new HashMap<String, Listing>(); // maps addresses to most recent listings
    String[] tokens;
    
    // Loop to iterate over input
    while (scanner.hasNextLine()) 
    {
      // Split input by commas
      input = scanner.nextLine();
      tokens = input.split(",");
      
      // Remove whitespace at the beginning
      while (tokens[1].charAt(0) == ' ') 
      {
        tokens[1] = tokens[1].substring(1);
      }
      
      while (tokens[2].charAt(0) == ' ') {
        tokens[2] = tokens[2].substring(1);
      }

      // Update listing if it exists in the map and is more recent
      if (listings.containsKey(tokens[1]) && listings.get(tokens[1]).getDate() < Integer.parseInt(tokens[2])) 
      {
        listings.get(tokens[1]).updateName(tokens[0]);
        listings.get(tokens[1]).updateDate(Integer.parseInt(tokens[2]));
      }
      
      // Add listing to map if it does not exist
      else if (!listings.containsKey(tokens[1])) 
      {
        listings.put(tokens[1], new Listing(tokens[0], Integer.parseInt(tokens[2])));
      }
    }
    
    // Output for listings
    String output = "(";
    
    // Add all listings to the Map
    for (Map.Entry<String, Listing> listing : listings.entrySet()) 
    {
      output += listing.getValue().getName() + ", ";
    }
    
    // Remove extra whitespace at the end and add ending bracket
    output = output.substring(0, output.length() - 2) + ")";

    System.out.println(output);
    
  } // end of Main Method
  
  
} // end of Class