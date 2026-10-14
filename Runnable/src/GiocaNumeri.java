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
        Thread t1 = new Thread(g1);
        t1.start();

        long inizioGioco = System.currentTimeMillis();

        Giocatore g2 = new Giocatore("Paolo", num2, parola2);
        Thread t2 = new Thread(g2);
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("Errore nell'attesa dei thread: " + e.getMessage());
        }

        long fineGioco = System.currentTimeMillis();
        long durataGioco = fineGioco - inizioGioco;

        g1.comunica();
        g2.comunica();

        System.out.println("\nTempo totale di gioco: " + durataGioco + " ms");

        System.out.println("\nFINE GIOCO");
        scanner.close();
    }
}