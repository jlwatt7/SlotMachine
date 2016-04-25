package runTimes;

public class LeverPull {

	private static int[] singlePull = new int[3];
	public static int bet;

	public static int getRoll() {
		return (int) (Math.random() * 9) + 1;
	}

	public static int[] getSinglePull() {
		for (int i = 0; i < singlePull.length; i++) {
			singlePull[i] = getRoll();
		}
		return singlePull;
	}

	public static boolean checkWin(int[] pull) {
		boolean ret = true;

		for (int i = 1; i < pull.length; i++) {
			while (ret) {
				if (pull[i - 1] == pull[i])
					ret = true;
				ret = false;
			}

		}
		return ret;
	}

	public static int addWinnings() {
		if (checkWin(singlePull))
			return singlePull[0] * bet;

		return 0;
	}

	public static int getBet() {
		return bet;
	}

	public static void setBet(int bet) {
		LeverPull.bet = bet;
	}

}
