package com.egaranhani.batalhanaval;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import sneer.android.Message;
import sneer.android.PartnerSession;

public class BattleShipActivity extends Activity
    implements BoardFragment.MyBoardActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_ship);
        if (findViewById(R.id.board_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            BoardFragment myBoard = new MyBoardFragment();
//            myBoard.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.board_container, myBoard).commit();
        }
        gameEngine = new BattleShipGame();
//        startSession();
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

    @Override
    public Board getMyBoard() {
        return gameEngine.myBoard();
    }

    @Override
    public Board getOpponentBoard() {
        return gameEngine.opponentBoard();
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
    private BattleShipGame gameEngine;
    private PartnerSession session;

    private boolean waitingForOpponentMove;
}
