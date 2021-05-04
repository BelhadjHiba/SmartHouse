package com.example.myapplication.houseManager;

public class PillBox {
    private String boxID;
    private boolean boxState = false;
    private Slot slot;
    private int nbSlots;
    private boolean boxLed = false;
    private boolean isLocked;

    public PillBox(int nbSlots){
        setNbSlots(nbSlots);
    }
    public PillBox(String boxID, boolean boxState, int nbSlots, boolean isLocked) {
        this.isLocked = isLocked;
        setBoxID(boxID);
        setBoxState(boxState);
        setNbSlots(nbSlots);
    }

    public PillBox() {
    }

    public String getBoxID() {
        return boxID;
    }

    public void setBoxID(String boxID) {
        this.boxID = boxID;
    }

    public boolean isBoxState() {
        return boxState;
    }

    public void setBoxState(boolean boxState) {
        this.boxState = boxState;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public int getNbSlots() {
        return nbSlots;
    }

    public void setNbSlots(int nbSlots) {
        this.nbSlots = nbSlots;
        for (int i=0; i<nbSlots; i++){
            Slot slot = new Slot();
            slot.getSlotID();
        }
    }

    public boolean getBoxLed() {
        return boxLed;
    }

    public void setBoxLed(boolean boxLed) {
        this.boxLed = boxLed;
    }

    public boolean onAlarmSet(){
        if (isLocked == false){
        System.out.println("Locked : "+isLocked);
        if (boxState == true){
            boxLed = false;
            System.out.println("boxLed : "+boxLed);
            System.out.println("success PillBox");
            return true;
        } else {
            boxLed = true;
            System.out.println("boxLed : "+boxLed);
            return false;
        }}
        else return false;

    }


}
