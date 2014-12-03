public class CreditCard {
  public boolean verify(String num) {
    if (num.length() < 12 || num.length() > 16) // return false if invalid length
      return false;
    
    if (findType(num) == 0) // return false if no type
      return false;
    
    int sum = 0; // initialize sum variable
    
    for (int i = num.length()-1; i >= 0; i --) { // for all of the characers in num
      if (num.length()%2 == i%2) // if placement is even
        sum += Integer.parseInt(num.substring(i,i+1))/5 + Integer.parseInt(num.substring(i,i+1))*2%10; // add double tens place and double ones place of that one digit
      else // if placement is odd
        sum += Integer.parseInt(num.substring(i,i+1)); // just add digit to sum
    }
        
    return sum%10 == 0; // valid if divisible by 10
  }
  
  
  public int findType(String num) {
    if (num.length() < 4) // if there are no first 4 digits, then throw it out
      return 0;
    if (num.substring(0,1).equals("4")) // if first digit is 4, Visa
      return 2;
    if (Integer.parseInt(num.substring(0,2)) > 50 && Integer.parseInt(num.substring(0,2)) < 56) // if first digits are 51-55, MC
      return 1;
    if (num.substring(0,2).equals("34") || num.substring(0,2).equals("37")) // if first two digits are 34, 37, AmEx
      return 3;
    if (num.substring(0,2).equals("36") || num.substring(0,2).equals("38")) // if they are 36 or 38, Diner thing
      return 5;
    if (Integer.parseInt(num.substring(0,3)) > 299 && Integer.parseInt(num.substring(0,3)) < 306) // if first 3 digits are between 300 and 305, also Diner thing
      return 5;
    if (num.substring(0,4).equals("6011")) // if starts with 6011, discover
      return 4;
    return 0; // otherwise, other
  }
  
  
  public String randomNumber(int type) {
    String randNum;
    switch (type) { // initialises the output so that it starts with the proper characters
      case 1:
        randNum = Integer.toString((int)(Math.random()*5+51));
        break;
      case 2:
        randNum = "4";
        break;
      case 3:
        randNum = Integer.toString((int)(Math.random()*2)*3+34);
        break;
      case 4:
        randNum = "6011";
        break;
      case 5:
        if (Math.random()<.5)
          randNum = Integer.toString((int)(Math.random()*2)*2+36);
        else
          randNum = Integer.toString((int)((Math.random()*2)*6+300));
        break;
      default:
        randNum = "";
    }
    
    for (int i = randNum.length(); i < 15; i ++) // puts on random numbers until length is 15
      randNum += Integer.toString((int)(Math.random()*10));
    
    for (int i = 0; i < 10; i ++) // checks 0-9 to see which final digit will make it valid (there is always exactly one)
      if (verify(randNum + i))
        return randNum + i;
    
    return "ERROR"; // if, somehow, it does not find it, then math is broken so return "ERROR"
  }
}