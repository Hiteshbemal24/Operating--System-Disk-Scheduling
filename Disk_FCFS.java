import java.util.Scanner;

public class Disk_FCFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, head, i, j, k, seek = 0, max1, diff;
        float avg;

        System.out.println("Enter the max range of disk:");
        max1 = scanner.nextInt();

        System.out.println("Enter the size of the request queue:");
        n = scanner.nextInt();

        int[] queue = new int[n + 1];

        System.out.println("Enter the queue:");
        for (i = 1; i <= n; i++) {
            queue[i] = scanner.nextInt();
        }

        System.out.println("Enter the initial head position:");
        head = scanner.nextInt();
        queue[0] = head;

        for (j = 0; j <= n - 1; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.printf("Move is from %d to %d with seek %d\n", queue[j], queue[j + 1], diff);
        }

        System.out.printf("Total seek time is %d\n", seek);
        avg = seek / (float) n;

        System.out.printf("Average seek time is %f\n", avg);
        double throughput = (double) n / seek;
        System.out.println("Throughput is = " + throughput);

        scanner.close();
    }
}

