import java.util.Scanner;

public class sstf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int head;
        System.out.println("Enter head position:");
        head = scanner.nextInt();

        int n, i;
        System.out.println("Enter total requests:");
        n = scanner.nextInt();

        int[] queue1 = new int[n];
        int[] done = new int[n];

        System.out.println("Enter requests:");
        for (i = 0; i < n; i++) {
            queue1[i] = scanner.nextInt();
            done[i] = 0;
        }

        System.out.print(head + "->");

        int temp1 = head;
        int count1 = 0, j, sum = 0;
        while (count1 != n) {
            int temp = 100000;
            int k = -1;
            for (j = 0; j < n; j++) {
                if (temp1 != queue1[j] && done[j] == 0) {
                    if (temp > Math.abs(temp1 - queue1[j])) {
                        temp = Math.abs(temp1 - queue1[j]);
                        k = j;
                    }
                }
            }
            sum += temp;
            System.out.print(queue1[k] + "->");
            count1++;
            temp1 = queue1[k];
            done[k] = 1;
        }
        System.out.println();
        System.out.println("Total head movement is = " + sum);
        double throughput = (double) n / sum;
        System.out.println("Throughput is = " + throughput);
        scanner.close();
    }
}
