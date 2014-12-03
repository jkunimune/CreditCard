// Credit Card verification driver

import java.util.Scanner;

public class CreditCardLabDriver
{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String[] types = {"Invalid", "Master Card", "Visa", "American Express", "Discover", "Diners Club/ Carte Blanche"};


    CreditCard test = new CreditCard();

    while (true) {
      System.out.println("Do you want to test or generate a number?");
      String choice = in.nextLine();
      
      if (choice.indexOf("est") >= 0) {
        System.out.println("Okay. Enter a number to be tested");
        String num = in.nextLine();
        
        System.out.print("Is "+num+" a valid credit card number? ");
        if (test.verify(num))
          System.out.println("Yes.");
        else
          System.out.println("No.");
        
        System.out.print("Credit card type is: ");
        System.out.println(types[test.findType(num)]);
        System.out.println("");
      }
      
      else if (choice.indexOf("enerate") >= 0) {
        System.out.println("Generate it is. What kind of card do you want?");
        String type = in.nextLine();
        
        if (type.equalsIgnoreCase("Master Card"))
          System.out.println(test.randomNumber(1));
        else if (type.equalsIgnoreCase("Visa"))
          System.out.println(test.randomNumber(2));
        else if (type.equalsIgnoreCase("American Express"))
          System.out.println(test.randomNumber(3));
        else if (type.equalsIgnoreCase("Discover"))
          System.out.println(test.randomNumber(4));
        else if (type.equalsIgnoreCase("Diners Club/ Carte Blanche") ||
                 type.equalsIgnoreCase("Diners Club") ||
                 type.equalsIgnoreCase("Carte Blanche"))
          System.out.println(test.randomNumber(5));
        else if (type.equalsIgnoreCase("Other") ||
                 type.equalsIgnoreCase("None") ||
                 type.equalsIgnoreCase("Random"))
          System.out.println(test.randomNumber(0));
        else
          System.out.println("I don't know what that is. Here, have a random one.\n"+test.randomNumber(0)+"\n");
      }
      
      else
        System.out.print("I'm afraid I don't understand. Please explicitly state which one you want. ");
    }
  }
}