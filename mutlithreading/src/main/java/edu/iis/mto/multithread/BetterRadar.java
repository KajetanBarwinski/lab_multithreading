package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {
    private PatriotBattery battery;
    private final int missilecount;
    private final Executor missilethreadhandler;

    public BetterRadar(PatriotBattery battery,int missilecount) {
        this.battery = battery;
        this.missilecount=missilecount;
        this.missilethreadhandler=Runnable::run;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> battery.launchPatriot(enemyMissle);

        for(int i=0;i<missilecount;i++)
            missilethreadhandler.execute(launchPatriotTask);
    }

}
