import java.util.Scanner;

public class BitStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String FLAG = "01111110";

        System.out.print("Enter binary data: ");
        String data = sc.nextLine();

        String stuffed = "";
        int count = 0;

        // Bit Stuffing
        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);

            if (bit == '1') {
                count++;
                stuffed += bit;

                if (count == 5) {
                    stuffed += '0';
                    count = 0;
                }
            } else {
                stuffed += bit;
                count = 0;
            }
        }

        String frame = FLAG + stuffed + FLAG;

        System.out.println("Bit Stuffed Frame: " + frame);

        // Destuffing
        String temp = frame.substring(8, frame.length() - 8);
        String destuffed = "";
        count = 0;

        for (int i = 0; i < temp.length(); i++) {
            char bit = temp.charAt(i);

            if (bit == '1') {
                count++;
                destuffed += bit;

                if (count == 5) {
                    i++; // Skip stuffed 0
                    count = 0;
                }
            } else {
                destuffed += bit;
                count = 0;
            }
        }

        System.out.println("Bit Destuffed Data: " + destuffed);
    }
}
