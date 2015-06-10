package com.egaranhani.batalhanaval;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * Created by egaranhani on 08/06/2015.
 */
abstract public class BoardFragment extends Fragment {

    public interface MyBoardActivity {
        public Board getMyBoard();
        public Board getOpponentBoard();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(fragmentId(), container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            battleshipActivity = (MyBoardActivity)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement BoardActivity");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        board = getBoard();
        int boardSize = board.getBoardSize();
        createLabels(boardSize);
        createBoardButtons(boardSize);
    }

    private void createLabels(int boardSize) {
        GridLayout layout = (GridLayout)getView().findViewById(boardLayoutId());
        for (int i = 0; i < boardSize; i++) {
            TextView columnLabel = createLabel(0, i);
            columnLabel.setText(columnLabel(i));
            layout.addView(columnLabel);
        }
        for (int i = 0; i < boardSize; i++) {
            TextView rowLabel = createLabel(i, 0);
            rowLabel.setText(rowLabel(i));
            layout.addView(rowLabel);
        }
    }

    private String columnLabel(int index){
        return "A" + index;
    }

    private String rowLabel(int index){
        return String.valueOf(index+1);
    }

    private TextView createLabel(int row, int col){
        TextView text = new TextView(getActivity());
        GridLayout.LayoutParams params = getLayoutParams(row, col);
        text.setTextSize(8);
        return text;
    }

    private void createBoardButtons(int boardSize) {
        buttons = new Button[boardSize][boardSize];
        GridLayout layout = (GridLayout)getView().findViewById(boardLayoutId());
        int layoutHeight = layout.getMeasuredHeight();
        int layoutWidth = layout.getWidth();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int id = i*boardSize + j;
                final Button b = createButton(id, i, j, layoutHeight/boardSize, layoutWidth/boardSize);
                layout.addView(b);
                buttons[i][j] = b;
            }
        }
    }

    private Button createButton(int id, int row, int col, int buttonHeight, int buttonWidth) {
        final Button b = new Button(getActivity());
        if(getView().findViewById(id) != null)
            throw new RuntimeException("ID " + String.valueOf(id) + " já existe");
        b.setId(id);
//        b.setText(" ");
        b.setTextSize(8);
        b.setText(String.valueOf(id));
        GridLayout.LayoutParams params = getLayoutParams(row+1, col+1);
        b.setLayoutParams(params);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(b);
            }
        });
        if(board.board()[row][col].status().equals(BoardSpace.STATUS.BLANK))
            b.setBackgroundColor(Color.WHITE);
        else
            b.setBackgroundColor(Color.BLUE);
        return b;
    }

    private GridLayout.LayoutParams getLayoutParams(int row, int col) {
        GridLayout.Spec rowSpec = GridLayout.spec(row);
        GridLayout.Spec colSpec = GridLayout.spec(col);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
        params.setMargins(1, 1, 1, 1);
//        params.height = buttonHeight/11;
//        params.width = buttonWidth/11;
        params.height = 90;
        params.width = 63;
        return params;
    }

    protected void onButtonClick(View v){
        int buttonId = v.getId();
    }

    abstract protected int boardLayoutId();
    abstract protected Board getBoard();
    abstract protected int fragmentId();

    protected MyBoardActivity battleshipActivity;
    private String [] rowLabels;
    private String [] colLabels;
    private Button[][] buttons;
    private Board board;
}
