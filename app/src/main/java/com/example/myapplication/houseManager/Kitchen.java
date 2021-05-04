package com.example.myapplication.houseManager;

public class Kitchen {
    private Drawer drawer;

    public Kitchen(Drawer drawer) {
        this.drawer = drawer;
    }

    public Drawer getDrawer() {
        return drawer;
    }

    public void setDrawer(Drawer drawer) {
        this.drawer = drawer;
    }
}
