package com.example.myapplication;

import android.app.Application;

public class MyAppGlobalVariables extends Application {
    private boolean pillBoxDone;
    private boolean slotDone;

    public boolean isPillBoxDone() {
        return pillBoxDone;
    }

    public void setPillBoxDone(boolean pillBoxDone) {
        this.pillBoxDone = pillBoxDone;
    }

    public boolean isSlotDone() {
        return slotDone;
    }

    public void setSlotDone(boolean slotDone) {
        this.slotDone = slotDone;
    }
}
