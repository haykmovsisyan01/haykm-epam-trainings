package homeworks.triangles;

public class Triangles {
    public static void upsideDownTriangle(int rows, char symbol) {
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static void leftAlignedTriangle(int rows, char symbol) {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public static void pyramid(int rows, char symbol) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print(symbol);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        leftAlignedTriangle(4, '*');

        System.out.println("\n==================================================\n");

        leftAlignedTriangle(6, '#');

        System.out.println("\n==================================================\n");

        upsideDownTriangle(3, '*');

        System.out.println("\n==================================================\n");

        upsideDownTriangle(11, '|');

        System.out.println("\n==================================================\n");

        pyramid(4, '*');

        System.out.println("\n==================================================\n");

        pyramid(5, 'X');
    }
}
