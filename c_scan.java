import java.util.Scanner;

public class c_scan {
    public static int find(int[] d, int n, int disk) {
        for (int i = 0; i < n - 1; i++) {
            if (d[i] > disk) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i, j, n;
        int disk;   // loc of head
        int temp, max;
        int dloc;   // loc of disk in array
        int no_t;

        System.out.println("Enter total number of tracks:");
        no_t = scanner.nextInt();

        System.out.println("Enter number of locations:");
        n = scanner.nextInt();

        int[] d = new int[n + 1]; // disk queue

        System.out.println("Enter position of head:");
        disk = scanner.nextInt();

        System.out.println("Enter elements of disk queue:");
        for (i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }

        for (i = 0; i < n - 1; i++) {    // sorting disk locations
            for (j = i + 1; j < n; j++) {
                if (d[i] > d[j]) {
                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        System.out.println("Elements after sorting:");
        for (i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }

        int prev_head;
        System.out.println("\nEnter previous head position:");
        prev_head = scanner.nextInt();

        String direction;
        System.out.println("Enter direction (left or right):");
        direction = scanner.next();

        int c;
        int sum = 0;

        if (prev_head > disk)
            c = 1;
        else
            c = 2;

        // Override c with user-defined direction
        if (direction.equalsIgnoreCase("left")) {
            c = 1;
        } else if (direction.equalsIgnoreCase("right")) {
            c = 2;
        } else {
            System.out.println("Invalid direction input. Defaulting to previous direction.");
        }

        // go towards left
        if (c == 1) {
            int previous = find(d, n, disk);

            previous = previous - 1;

            sum += Math.abs(disk - d[previous]);

            System.out.print(disk + "->");

            for (i = previous; i >= 0; i--) {
                System.out.print(d[i] + " ->");
                if (i != 0) {
                    int dr = Math.abs(d[i] - d[i - 1]);
                    sum += dr;
                } else if (i == 0) {
                    sum += d[i];
                }
            }

            System.out.print("0 ->");
            sum += no_t - 1 - d[n - 1];

            for (i = n - 1; i >= previous + 1; i--) {
                System.out.print(d[i] + " ->");

                if (i != previous + 1) {
                    int dr = Math.abs(d[i] - d[i - 1]);
                    sum += dr;
                }
            }

            System.out.println("\nMovement of total cylinders: " + sum);
        }

        // go towards right
        else if (c == 2) {
            int previous = find(d, n, disk);

            sum += Math.abs(d[previous] - disk);

            System.out.print(disk + "->");

            for (i = previous; i < n; i++) {
                System.out.print(d[i] + " ->");
                if (i != n - 1)
                    sum += Math.abs(d[i + 1] - d[i]);
                else if (i == n - 1)
                    sum += Math.abs(no_t - 1 - d[i]);
            }

            System.out.print("0 ->");
            sum += d[0];

            for (i = 0; i <= previous - 1; i++) {
                System.out.print(d[i] + " ->");

                if (i != previous - 1)
                    sum += Math.abs(d[i + 1] - d[i]);
            }

            System.out.println("\nMovement of total cylinders: " + sum);
            double throughput = (double) n / sum;
            System.out.println("Throughput is = " + throughput);
        }

        scanner.close();
    }
}
