package homeworks;

public class Triangles {
    static void upsideDownTriangle(int rows, char symbol) {
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    static void leftAlignedTriangle(int rows, char symbol) {
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    static void pyramid(int rows, char symbol) {
        for (int i = 0, spaces = rows - 1, symbols = 1; i < rows; i++, spaces--, symbols += 2) {
            for (int j = spaces; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= symbols; j++) {
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
