package com.egaranhani.batalhanaval;

/**
 * Created by egaranhani on 09/06/2015.
 */
public class OpponentBoardFragment extends BoardFragment{

    @Override
    protected int fragmentId() {
        return R.layout.opponent_board_fragment;
    }

    @Override
    protected int boardLayoutId() {
        return R.id.oponent_board_layout;
    }

    @Override
    protected Board getBoard() {
        return battleshipActivity.getOpponentBoard();
    }
}
