/**
 * Classe Giocatore che implementa Runnable.
 *
 * @see "UdA n. 1: Esercitazione n. 1 - Giocanumeri"
 * @author valerio sordini
 */
public class Giocatore implements Runnable {
    private String nome;
    private String parola;
    private int numero;
    private int punteggio;
    private long durataGiocatore;

    public Giocatore(String nome, int numero, String parola) {
        this.nome = nome;
        this.numero = numero;
        setParola(parola.toUpperCase());
    }

    public void gioca() {
        Thread t = Thread.currentThread();
        System.out.println("THREAD INFO: " +
                "\nID: " + t.getId() +
                "\nNome: " + t.getName() +
                "\nPriorità: " + t.getPriority() +
                "\nStato: " + t.getState() + "\n");

        long inizioGiocatore = System.currentTimeMillis();

        for (int i = 0; i < numero; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Errore nella transizione running-sleeping per " + nome + ": " + e.getMessage());
            }
            Thread.yield();
        }

        long fineGiocatore = System.currentTimeMillis();
        durataGiocatore = fineGiocatore - inizioGiocatore;

        setPunteggio(getParola().length() * 10 + numero);
    }

    public void comunica() {
        System.out.println("\n---------\nGiocatore : " + nome + " " +
        "\nNumero: " + numero + " | Parola: " + getParola() +
                "\nPunteggio: " + punteggio + " | Tempo: " + durataGiocatore + " ms");
    }

    @Override
    public void run() {
        gioca();
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getNumero() {
        return numero;
    }
}