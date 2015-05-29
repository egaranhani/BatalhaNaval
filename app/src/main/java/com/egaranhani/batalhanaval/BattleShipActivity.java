package com.egaranhani.batalhanaval;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import sneer.android.Message;
import sneer.android.PartnerSession;

public class BattleShipActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameEngine = new BattleShipGame();

        int length = gameEngine.boardSize();
        buttons = new Button[length][length];

        setContentView(R.layout.activity_battle_ship);
        GridLayout layout = (GridLayout)findViewById(R.id.gridLayout);

        int id = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                final Button b = new Button(this);
                b.setId(id++);
                b.setText("");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        this.onClick(b);
                    }
                });

                if(gameEngine.myBoard().board()[i][j].equals(BoardSpace.STATUS.BLANK))
                    b.setBackgroundColor(Color.WHITE);
                else
                    b.setBackgroundColor(Color.BLUE);
                buttons[i][j] = b;
            }
        }

        Button myButton = new Button(this);
        myButton.setText("Push Me");

        layout.addView(myButton);
        startSession();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battle_ship, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startSession() {
        session = PartnerSession.join(this, new PartnerSession.Listener() {
            @Override
            public void onUpToDate() {
                refresh();
            }

            @Override
            public void onMessage(Message message) {
                handle(message);
            }
        });
    }

    private void refresh() {

    }

    private void handle(Message message) {
        if(message.wasSentByMe())
            return;

        if(waitingForOpponentMove)
            return;

        ShootAttempt attempt = (ShootAttempt) message.payload();
        gameEngine.response(attempt);
        //TODO: redraw opponent board
    }

    protected void onClick(View v){
        int buttonId = v.getId();
    }

    private BattleShipGame gameEngine;
    private PartnerSession session;
    private Button [][] buttons;
    private boolean waitingForOpponentMove;

}
