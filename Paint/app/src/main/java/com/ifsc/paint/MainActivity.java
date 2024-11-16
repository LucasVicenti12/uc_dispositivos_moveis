package com.ifsc.paint;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    ImageButton btnImCircle;
//    Button btnColor;
//    Button btnSquare;
//    Button btnPath;
    SimplePaint simplePaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplePaint = findViewById(R.id.simplePaint);

        btnImCircle = findViewById(R.id.circle_button);

        btnImCircle.setOnClickListener(view -> simplePaint.setShape(Shapes.Circle));

//        btnColor = findViewById(R.id.btn_color);
//        btnSquare = findViewById(R.id.btn_square);
//        btnImCircle = findViewById(R.id.btn_circle);
//        btnPath = findViewById(R.id.btn_path);
//        simplePaint = findViewById(R.id.simplePaint);
//
//        btnColor.setOnClickListener(view -> {
//            new ColorPickerDialog.Builder(MainActivity.this)
//                    .setTitle("Color picker dialog")
//                    .setPreferenceName("MyColorPicker")
//                    .setPositiveButton(
//                            getString(R.string.confirm),
//                            (ColorEnvelopeListener) (envelope, fromUser) -> setLayoutColor(envelope)
//                    ).setNegativeButton(
//                            getString(R.string.cancel),
//                            (DialogInterface.OnClickListener) (dialogInterface, i) -> dialogInterface.dismiss()
//                    ).attachAlphaSlideBar(true)
//                    .attachBrightnessSlideBar(true)
//                    .setBottomSpace(12)
//                    .show();
//        });
//
//        btnSquare.setOnClickListener(view -> {
//            simplePaint.setShape(Shapes.Square);
//        });
//
//        btnImCircle.setOnClickListener(view -> {
//            simplePaint.setShape(Shapes.Circle);
//        });
//
//        btnPath.setOnClickListener(view -> {
//            simplePaint.setShape(Shapes.Finger);
//        });
    }

    public void setLayoutColor(ColorEnvelope color){
        simplePaint.setColor(color.getColor());
//        btnColor.setBackgroundColor(color.getColor());
    }
}