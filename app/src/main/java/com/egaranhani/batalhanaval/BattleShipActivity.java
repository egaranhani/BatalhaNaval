package com.egaranhani.batalhanaval;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

        boardSize = gameEngine.boardSize();
        buttons = new Button[boardSize][boardSize];

        setContentView(R.layout.activity_battle_ship);
        createBoardButtons();
//        startSession();
    }

    private void createBoardButtons() {
        GridLayout layout = (GridLayout)findViewById(R.id.mainLayout);
        int layoutWidth = layout.getMeasuredWidth();
        int layoutHeight = layout.getMeasuredHeight();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int id = i*boardSize + j;
                final Button b = createButton(id, i+2, j, layoutHeight/boardSize, layoutWidth/boardSize);

                if(gameEngine.myBoard().board()[i][j].equals(BoardSpace.STATUS.BLANK))
                    b.setBackgroundColor(Color.WHITE);
                else
                    b.setBackgroundColor(Color.BLUE);
                layout.addView(b);
                buttons[i][j] = b;
            }
        }
    }

    private Button createButton(int id, int row, int col, int buttonHeight, int buttonWidth) {
        final Button b = new Button(this);
        if(findViewById(id) != null)
            throw new RuntimeException("ID " + String.valueOf(id) + " já existe");
        b.setId(id);
//        b.setText(" ");
        b.setTextSize(8);
        b.setText(String.valueOf(id));
        GridLayout.Spec rowSpec = GridLayout.spec(row);
        GridLayout.Spec colSpec = GridLayout.spec(col);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
        params.setMargins(1, 1, 1, 1);
        params.height = 90;
        params.width = 63;
        b.setLayoutParams(params);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(b);
            }
        });
        return b;
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

    protected void onButtonClick(View v){
        int buttonId = v.getId();
    }

    private BattleShipGame gameEngine;
    private PartnerSession session;
    private Button [][] buttons;
    private int boardSize;
    private boolean waitingForOpponentMove;

}
