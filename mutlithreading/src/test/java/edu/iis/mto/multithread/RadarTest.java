package edu.iis.mto.multithread;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(10)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        BetterRadar radar = new BetterRadar(batteryMock,1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(10)
    void launchPatriotSevenTimesWhenNoticesAScudMissle(){
        BetterRadar radar = new BetterRadar(batteryMock,7);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock,times(7)).launchPatriot(enemyMissle);
    }

}
