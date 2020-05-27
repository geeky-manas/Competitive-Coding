import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FROGV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int p = sc.nextInt();
		int[] a = new int[n];
		long[] b = new long[n];
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = a[i];
		}
		Arrays.sort(b);
		map.put(b[n - 1], k + b[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			if (k + b[i] >= b[i + 1])
				map.put(b[i], map.get(b[i + 1]));
			else
				map.put(b[i], b[i] + k);
		}
		for (int i = 0; i < p; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			long min = Math.min(a[x - 1], a[y - 1]);
			long max = Math.max(a[x - 1], a[y - 1]);
			if (map.get(min) >= max)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		sc.close();

	}

}
