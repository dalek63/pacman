package Services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Boucle {

    @Scheduled(fixedRate = 1000)
    public void boucle() {


        // Grille de visualisation de la partie
        /*
        int rows = 10;
        int cols = 10;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("X ");
            }
            System.out.println();
        }

        */
        System.out.print("X ");

    }
}
