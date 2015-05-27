package com.egaranhani.batalhanaval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egaranhani on 26/05/2015.
 */
public class BattleShip {

    public BattleShip(int size){
        compartments = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            compartments.add(new ShipCompartment());
        }
    }

    public int size(){
        return compartments.size();
    }

    public boolean isDestroyed(){
        for (ShipCompartment compartment : compartments)
            if(compartment.status().equals(BoardSpace.STATUS.SHIP))
                return false;
        return true;
    }

    public ShipCompartment getCompartment(int pos){
        return compartments.get(pos);
    }

    private List<ShipCompartment> compartments;
}
