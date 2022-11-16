package pgdp.pingulogy;

public class RecursivePingulogy {

	public static int acc0 = 0;
	public static int acc1 = 0;
	public static int acc2 = 0;
	// task 1
	public static long pinguSequenceRec(int n, int p0, int p1, int p2) {
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
		if (n == 0) {
			return 1;
		}
		return n - pinguM(pinguF(n - 1));
	}

	public int pinguM(int n) {
		if (n == 0) {
			return 0;
		}
		return n - pinguF(pinguM(n - 1));
	}

	// task 3
	public static int pinguCode(int n, int m) {
		return pC_go(n, m, 0);
	}

	public static int pC_go(int n, int m, int acc) {
		if (n == 0) {
			return m + acc;
		} else if ((n + acc) % 2 == 0) {
			//Math.floor nicht nötig, da int automatisch abrundet
			return pC_go(m, n / 2, acc + n / 2);
		} else {
			return pC_go(n - 1, m / 2, acc + m);
		}
	}

	// task 4
	public static String pinguDNA(int f, int m) {
		//f = Integer.parseInt(Integer.toBinaryString(f));
		//m = Integer.parseInt(Integer.toBinaryString(m));

		if (f == 0 && m == 0) {
			return "";
		} else if (f == 0 && m > 0) {
			//return pinguDNA(f, Integer.parseInt(Integer.toString(m), 2) / 2) + "A";
			return pinguDNA(f, m / 2) + "A";
		} else if (f > 0 && m == 0) {
			//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, m) + "T";
			return pinguDNA(f / 2, m) + "T";
		} else {
			if (f % 2 == m % 2) {
				if (f > m) {
					//f = Integer.parseInt(Integer.toString(f), 2) / 2;
					//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, Integer.parseInt(Integer.toString(m), 2) / 2) + "GT";
					return pinguDNA(f / 2, m / 2) + "GT";
				} else if (f < m){
					//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, Integer.parseInt(Integer.toString(m), 2) / 2) + "GA";
					return pinguDNA(f / 2, m / 2) + "GA";
				} else {
					//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, Integer.parseInt(Integer.toString(m), 2) / 2) + "GC";
					return pinguDNA(f / 2, m / 2) + "GC";
				}
			} else if (f % 2 == 1) {
				//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, Integer.parseInt(Integer.toString(m), 2) / 2) + "TC";
				return pinguDNA(f / 2, m / 2) + "TC";
			} else {
				//return pinguDNA(Integer.parseInt(Integer.toString(f), 2) / 2, Integer.parseInt(Integer.toString(m), 2) / 2) + "AC";
				return pinguDNA(f / 2, m / 2) + "AC";
			}
		}
	}

	public static void main(String[] args) {
		// switch value to test other tasks
		int testTask = 4;

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