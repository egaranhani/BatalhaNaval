package com.egaranhani.batalhanaval;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class BattleShipActivityTest extends ActivityUnitTestCase<BattleShipActivity> {
    public BattleShipActivityTest() {
        super(BattleShipActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        launchIntent = new Intent(getInstrumentation().getTargetContext(), BattleShipActivity.class);
        startActivity(launchIntent, null, null);
        getButtons();
    }

    public void testButtonsClick(){
        startActivity(launchIntent, null, null);
        getButtons();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                final Intent clickLaunchIntent = getStartedActivityIntent();
                assertNotNull("Intent was null", clickLaunchIntent);
                assertTrue(isFinishCalled());
            }
        }
    }

    private void getButtons() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int id = (i*boardSize) + j;
                buttons[i][j] = (Button)battleShipActivity.findViewById(id);
            }
        }
    }

    private BattleShipActivity battleShipActivity;
    private Instrumentation instrumentation;
    private Intent launchIntent;
    private Button[][] buttons;
    private int boardSize = Board.BOARD_SIZE;

}