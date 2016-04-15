package vlem;

/**
 * Created by valentin on 09/04/15.
 */
public interface InterfaceBowling {

    /**
     * Fonction vérifiant que la partie contient un nombre correct de lancers.
     * @param partie La partie du joueur.
     * @return true si la taille est correcte.
     */
    boolean correctLength(String partie);

    /**
     * Fonction vérifiant que le score du round courant est valide.
     * @param partie La partie du joueur.
     * @param current Lancer actuel (doit correspondre à un début de round).
     * @return true si le format du round est correct.
     */
    boolean correctRound(String partie, int current);

    /**
     * Fonction vérifiant si une partie est correctement formée.
     * @param partie La partie du joueur.
     * @return true si le format de la partie est correct.
     */
    boolean correctGame(String partie);

    /**
     * Fonction permettant de récupérer le score final du joueur.
     * @param partie La partie du joueur.
     * @return Le score du joueur.
     */
    int score(String partie);
}
