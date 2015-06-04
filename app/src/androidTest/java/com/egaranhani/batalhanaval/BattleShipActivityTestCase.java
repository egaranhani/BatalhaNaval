package com.egaranhani.batalhanaval;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;
import android.widget.Button;

/**
 * Created by egaranhani on 03/06/2015.
 */
public class BattleShipActivityTestCase extends ActivityInstrumentationTestCase2<BattleShipActivity> {

    public BattleShipActivityTestCase() {
        super(BattleShipActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        int boardSize = 10;

        buttons = new Button[boardSize*boardSize];
        battleShipActivity = getActivity();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int id = i* boardSize + j;
                buttons[id] = (Button) battleShipActivity.findViewById(id);
            }
        }
    }

    public void testButtons(){
        for (Button b : buttons){
            assertEquals("", b.getText());
        }
    }

    private BattleShipActivity battleShipActivity;
    private Button[] buttons;
}