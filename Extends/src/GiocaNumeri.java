import java.util.Scanner;

/**
 * Applicazione multithreading e diagramma degli stati.
 *
 * @see "UdA n. 1: Esercitazione n. 1 - Giocanumeri"
 * @author valerio sordini
 */
public class GiocaNumeri {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("INIZIO GIOCO");

        System.out.print("Inserisci numero per Giocatore 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Inserisci parola per Giocatore 1: ");
        String parola1 = scanner.next();

        System.out.print("Inserisci numero per Giocatore 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Inserisci parola per Giocatore 2: ");
        String parola2 = scanner.next();

        Giocatore g1 = new Giocatore("Monica", num1, parola1);
        g1.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Errore nella sospensione del main: " + e.getMessage());
        }

        Giocatore g2 = new Giocatore("Paolo", num2, parola2);
        g2.start();

        try {
            g1.join();
            g2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore nell'attesa dei thread: " + e.getMessage());
        }

        System.out.println("FINE GIOCO");
        scanner.close();
    }
}