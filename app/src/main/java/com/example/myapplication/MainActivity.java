package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.houseManager.HouseManager;
import com.example.myapplication.houseManager.PillBox;
import com.example.myapplication.houseManager.Slot;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    HouseManager hm = new HouseManager();
    PillBox p = new PillBox();
    Slot s = new Slot();
    Button btn ;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView);
        getFromDB();
        addOnClickAction();
    }
    void addOnClickAction(){
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getFromDB();
        hm.onAlarmSetHouse(p,s);
        switch (txt.getText().toString()) {
            case "Start Event" : {
                txt.setText("PillBox State");
                btn.setText("Open");
                p.onAlarmSet();
                db.collection("PillBox").document("Ibuprofen").update("isLocked" , false, "boxLed" , true);
            }; break;
            case "PillBox State" : {
                txt.setText("Slot State");
                btn.setText("Open");
                p.setBoxState(true);
                p.onAlarmSet();
                db.collection("PillBox").document("Ibuprofen").update("boxLed", false, "boxState", true);
                s.onAlarmStarted();
                db.collection("PillBox").document("Ibuprofen").collection("Slot").document("2").update("isLocked", false, "slotLed", true);
                s.setIsLocked(p.onAlarmSet());
                s.onAlarmStarted();
            }; break;
            case "Slot State" : {
                txt.setText("Empty Slot");
                btn.setText("Empty");
                s.setSlotState(true);
                s.onAlarmStarted();
                db.collection("PillBox").document("Ibuprofen").collection("Slot").document("2").update("slotState", true, "slotLed", false);
            }; break;
            case "Empty Slot" : {
                txt.setText("Close");
                btn.setText("Close");
                s.setEmpty(true);
                db.collection("PillBox").document("Ibuprofen").collection("Slot").document("2").update("isEmpty", true);
            }; break;
            case "Close" : {
                txt.setText("Done");
                btn.setText("Done");
                s.setIsLocked(true);
                p.setIsLocked(true);
                db.collection("PillBox").document("Ibuprofen").collection("Slot").document("2").update("isLocked", true);
                db.collection("PillBox").document("Ibuprofen").update("isLocked", true);
            }; break;
        }
    }
});
    }
    void getFromDB(){
        db.collection("PillBox").document("Ibuprofen").get().addOnSuccessListener(this, new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                p = documentSnapshot.toObject(PillBox.class);
            }
        });
        db.collection("PillBox").document("Ibuprofen").collection("Slot").document("2").get().addOnSuccessListener(this, new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                s = documentSnapshot.toObject(Slot.class);
            }
        });
    }
}