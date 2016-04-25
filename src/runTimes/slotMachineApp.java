package runTimes;
import java.util.*;
//import sun.audio.*;
//import java.io.*;

public class slotMachineApp {
 
public static void main(String[] args)
//throws Exception
{	
	//String slotSound = "77905__milton__playing-a-slot-machine.mp3";
	//InputStream in = new FileInputStream(slotSound);
	
	int [ ] pull = new int [3];
	User user = new User();
	String userContinue = "Y";
		
	System.out.println("Welcome to THA HYPE Casino!");
	System.out.println();
	
	System.out.println("What is your name?");
	user.setName(Validator.getValidString("[A-Za-z-]+", 30));
		
	System.out.println("How much are you tryna lose?");
	user.setAccountBalance(Validator.getValidInt(1,200000));
	
	while(userContinue.equalsIgnoreCase("Y")){
	System.out.println("How much do you want to bet on this pull? ($1-$5)");
	LeverPull.setBet(Validator.getValidBet(1,user.getAccountBalance()));
	user.setAccountBalance(user.getAccountBalance()-LeverPull.getBet());
	
	pull = LeverPull.getSinglePull();
	
	System.out.println("Your numbers");
	for (int i = 0; i < pull.length; i++) {
		System.out.print(pull[i]+" ");
	}
	System.out.println("\nYou now have "+ user.getAccountBalance() + " dollars left!");
	System.out.println("Would you like to pull again? (Y/N)");
	userContinue = Validator.readYorN("Y", "N");
	}
	}	
}
