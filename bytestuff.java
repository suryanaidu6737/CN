import java.util.Scanner;

public class ByteStuffing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String FLAG = "01111110";
        final String ESC = "01111101";

        System.out.println("Enter binary bytes (8 bits each, space separated):");
        System.out.println("Example:");
        System.out.println("01000101 01111110 00100011 01111101 00010000");

        String input = sc.nextLine().trim();

        String[] data = input.split("\\s+");

        // -------- Byte Stuffing --------
        StringBuilder stuffed = new StringBuilder();

        stuffed.append(FLAG).append(" "); // Start Flag

        for (String b : data) {

            if (b.equals(FLAG) || b.equals(ESC)) {
                stuffed.append(ESC).append(" ");
            }

            stuffed.append(b).append(" ");
        }

        stuffed.append(FLAG); // End Flag

        System.out.println("\nStuffed Frame:");
        System.out.println(stuffed);

        // -------- Byte Destuffing --------
        String[] frame = stuffed.toString().split("\\s+");

        StringBuilder destuffed = new StringBuilder();

        for (int i = 1; i < frame.length - 1; i++) {

            if (frame[i].equals(ESC)) {
                i++; // Skip inserted ESC
            }

            destuffed.append(frame[i]).append(" ");
        }

        System.out.println("\nDestuffed Data:");
        System.out.println(destuffed.toString().trim());

        sc.close();
    }
}
