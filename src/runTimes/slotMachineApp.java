package runTimes;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

public class slotMachineApp {
	static ArrayList<User> list;

	public static void main(String[] args) {

		File slot = new File("SMplay.wav");
		File lose = new File("SMlose.wav");

		int[] pull = new int[3];
		int userPosition;
		String userName = "";
		int userBalance = 0;
		String userContinue = "Y";
		list = fileIOHandler.readData();

		System.out.println("Welcome to THA HYPE Casino!");
		System.out.println();

		System.out.println("What is your name?");
		userName = Validator.getValidString("[A-Za-z-]+", 30);
		userPosition = searchUser(userName);

		if (userPosition == -1) {
			User user = new User();
			System.out.println("How much are you tryna lose?");
			userBalance = Validator.getValidInt(1, 200000);
			list.add(user.addUser(userName, userBalance));
			userPosition = list.size() - 1;
		} else {
			System.out.println("Welcome back! Your balance is " + list.get(userPosition).getAccountBalance());
		}

		while (true) {
			System.out.println("How much do you want to bet on this pull? ($1-$5)");
			LeverPull.setBet(Validator.getValidBet(1, list.get(userPosition).getAccountBalance()));
			list.get(userPosition).setAccountBalance(list.get(userPosition).getAccountBalance() - LeverPull.getBet());
			PlaySound(slot);
			pull = LeverPull.getSinglePull();
			
			if (!LeverPull.checkWin(pull)) {
				try {
					Thread.sleep(2700);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PlaySound(lose);
			}

			System.out.println("Your numbers");
			for (int i = 0; i < pull.length; i++) {
				System.out.print(pull[i] + " ");
			}



			System.out.println("\nYou now have " + list.get(userPosition).getAccountBalance() + " dollars left!");
			System.out.println("Would you like to pull again? (Y/N)");
			userContinue = Validator.readYorN("Y", "N");

			if (userContinue.equalsIgnoreCase("y")) {
				continue;
			} else {
				System.out.println("Making wise choices in your life, huh?  Have a good one.");
				fileIOHandler.saveData(list);
				break;
			}

		}

	}

	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		} catch (Exception e) {

		}
	}

	public static int searchUser(String name) {
		int up = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				up = i;
			}
		}
		return up;
	}
}
