import java.util.Scanner;
public class Grade
{
 
  public static void main (String [] args){
      
    if (0 <= grade && grade <=100){
    final int BONUS_5 = 25;
    final int BONUS_4 = 15;
      int grade;
      int units;
      Scanner scan = new Scanner(System.in);
      System.out.println("enter grade & units");
      grade = scan.nextInt();
      units = scan.nextInt();
    
    }if (units == 5){
      grade += BONUS_5;
    }
    if (units == 4){
      grade += BONUS_4;
    }
    
    System.out.println("your final grade is:" + grade);
}
}