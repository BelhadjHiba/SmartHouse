package com.example.myapplication.houseManager;

import com.example.myapplication.MyAppGlobalVariables;

public class HouseManager extends MyAppGlobalVariables {
//PillBox p = new PillBox();
//Slot s = new Slot();
public HouseManager(){}
public void onAlarmSetHouse(PillBox pBox, Slot slot){
    setPillBoxDone(pBox.onAlarmSet());
    if (isPillBoxDone()){
        setSlotDone(slot.onAlarmSet());
        if (isSlotDone())
            System.out.println("pill Taken With Success");
    }
}
}
