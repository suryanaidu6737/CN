import java.util.Scanner;

public class ByteStuffing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String FLAG = "7E";
        String ESC = "7D";

        System.out.println("Enter data bytes in hexadecimal (space separated):");
        System.out.println("Example: 45 7E 23 7D 10");

        String input = sc.nextLine().toUpperCase();

        String[] data = input.split("\\s+");

        // ---------------- Byte Stuffing ----------------
        StringBuilder stuffed = new StringBuilder();

        // Start Flag
        stuffed.append(FLAG).append(" ");

        for (String b : data) {

            if (b.equals(FLAG) || b.equals(ESC)) {
                stuffed.append(ESC).append(" ");
            }

            stuffed.append(b).append(" ");
        }

        // End Flag
        stuffed.append(FLAG);

        System.out.println("\nStuffed Frame:");
        System.out.println(stuffed);

        // ---------------- Byte Destuffing ----------------
        String[] frame = stuffed.toString().split("\\s+");

        StringBuilder destuffed = new StringBuilder();

        for (int i = 1; i < frame.length - 1; i++) {

            if (frame[i].equals(ESC)) {
                i++;                // Skip inserted ESC
            }

            destuffed.append(frame[i]).append(" ");
        }

        System.out.println("\nDestuffed Data:");
        System.out.println(destuffed.toString().trim());

        sc.close();
    }
}
