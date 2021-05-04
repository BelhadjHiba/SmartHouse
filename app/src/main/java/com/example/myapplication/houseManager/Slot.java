package com.example.myapplication.houseManager;

public class Slot extends PillBox {
    private int slotID = 0;
    private boolean slotLed = false;
    private boolean slotState = false;
    private boolean isLocked ;
    private boolean isEmpty;

    public Slot(){}
    public Slot(boolean slotLed, boolean slotState, boolean isEmpty) {
        super();
        this.isEmpty = isEmpty;
        setSlotLed(slotLed);
        setSlotState(slotState);
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.slotLed = isLocked;
    }
    public int getSlotID() {
        return slotID;
    }

    public void setSlotID() {
        this.slotID++;
    }

    public boolean isSlotLed() {
        return slotLed;
    }

    public void setSlotLed(boolean isLed) {
        this.slotLed = isLed;
    }

    public boolean getSlotState() {
        return slotState;
    }

    public void setSlotState(boolean isSelected) {
        if (isLocked == false)
            this.slotState = true;
    }
    public boolean onAlarmStarted(){
        if (isLocked == false){
            System.out.println("Locked slot : "+isLocked);

                slotLed = true;
                System.out.println("slotLed : "+slotLed);

            if (slotState == true){
                slotLed = false;
                System.out.println("slotLed : "+slotLed);
                System.out.println("success Slot");
                return true;
            } else {
                System.out.println("failed Slot");
                return false;
            }
        }
        else return false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
