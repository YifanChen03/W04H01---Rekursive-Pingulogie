package pgdp.pingulogy;

public class RecursivePingulogy {

	public static int acc0 = 0;
	public static int acc1 = 0;
	public static int acc2 = 0;
	// task 1
	public static long pinguSequenceRec(int n, int p0, int p1, int p2) {
			//wenn n >= 0
			return pSR_go(n, p0, p1, p2);
	}

	public static long pSR_go(int n, long a0, long a1, long a2) {
		if (n == 0) {
			return a0;
		} else if (n == 1) {
			return a1;
		} else if (n == 2) {
			return a2;
		} else if (n > 0){
			//tails recursion indem Werte mit a0, a1, a2 zwischenberechnet werden
			return pSR_go(n - 1, a1, a2, a0 * 2 - a1 + a2);
		} else {
			return 2 * pSR_go(-n, a0, a1, a2);
		}
	}

	// task 2
	// Hint: pinguF and pinguM are not static (and must not be changed to it!)
	// more information in the main-method below
	public int pinguF(int n) {
		// TODO
		return -1;
	}

	public int pinguM(int n) {
		// TODO
		return -1;
	}

	// task 3
	public static int pinguCode(int n, int m) {
		// TODO
		return -1;
	}

	// task 4
	public static String pinguDNA(int f, int m) {
		// TODO
		return "TODO";
	}

	public static void main(String[] args) {
		// switch value to test other tasks
		int testTask = 1;

		switch (testTask) {
		case 1:
			System.out.println("Task 1 example output");
			for (int i = -122; i < 145; i++) {
				System.out.println(i + ": " + pinguSequenceRec(i, 1, 1, 2));
			}
			break;
		case 2:
			/**
			 * For better testing, pinguF and pinguM are not static. 
			 * Hence, you have to initialize a new RecursivePingulogy Object and 
			 * call the methods on that instance, as you can see below.
			 * You will learn more about object-oriented-programming in the lecture
			 * and week 05+.
			 */
			RecursivePingulogy rp = new RecursivePingulogy();
			System.out.print("Task 2 example output\npinguF: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguF(i) + ", ");
			}
			System.out.print("\npingM: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguM(i) + ", ");
			}
			break;
		case 3:
			System.out.println("Task 3 example output");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.println(i + ", " + j + ": " + pinguCode(i, j));
				}
				System.out.println("----------");
			}
			break;
		case 4:
			System.out.println("Task 4 example output");
			System.out.println("pinguDNA(21, 25) = " + pinguDNA(21, 25));
			break;
		default:
			System.out.println("There are only 4 tasks!");
			break;
		}
	}
}
