package services;
import Classes.Jeu;
import Classes.Point;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class boucle {

    private boolean stopLoop = false;


    @Scheduled(fixedRate = 1000)
    public void executeTask(Jeu j) {

        if (stopLoop) {
            System.out.println("Boucle interrompue ");
            return;
        }

          System.out.println("Tâche exécutée chaque seconde.");


        if (eventHappened()) {
            stopLoop = true;
        }
    }

    private boolean eventHappened(Point p) {
        if(p.getPositionX()>10) {
            return true;
        }
    }




}
