package com.egaranhani.batalhanaval;

import android.os.Bundle;

/**
 * Created by egaranhani on 09/06/2015.
 */
public class MyBoardFragment extends BoardFragment{

    @Override
    protected int fragmentId() {
        return R.layout.my_board_fragment;
    }

    @Override
    protected int boardLayoutId() {
        return R.id.my_board_layout;
    }

    @Override
    protected Board getBoard() {
        return battleshipActivity.getMyBoard();
    }
}
