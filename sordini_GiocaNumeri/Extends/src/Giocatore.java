/**
 * Classe Giocatore che estende Thread.
 *
 * @see "UdA n. 1: Esercitazione n. 1 - Giocanumeri"
 * @author valerio sordini
 */

public class Giocatore extends Thread {
    private String nome;
    private String parola;
    private int numero;
    private int punteggio;

    public Giocatore(String nome, int numero, String parola) {
        this.nome = nome;
        this.numero = numero;
        setParola(parola.toUpperCase());
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

    public void gioca() {
        for (int i = 0; i < numero; i++) {
            System.out.println("Giocatore : " + nome + " i: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Errore nella transizione running-sleeping per " + nome + ": " + e.getMessage());
            }
            Thread.yield();
        }

        setPunteggio(getParola().length() * 10 + numero);

        System.out.println("\n---------\nGiocatore : " + nome + " " +
                "\nNumero: " + numero + " | Parola: " + getParola() +
                "\nPunteggio: " + punteggio);
    }

    @Override
    public void run() {
        gioca();
    }
}