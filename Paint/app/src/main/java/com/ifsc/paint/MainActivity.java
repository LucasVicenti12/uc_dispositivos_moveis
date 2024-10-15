package com.ifsc.paint;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    Button btnColor;
    Button btnSquare;
    Button btnImCircle;
    Button btnPath;
    SimplePaint simplePaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor = findViewById(R.id.btn_color);
        btnSquare = findViewById(R.id.btn_square);
        btnImCircle = findViewById(R.id.btn_circle);
        btnPath = findViewById(R.id.btn_path);
        simplePaint = findViewById(R.id.simplePaint);

        btnColor.setOnClickListener(view -> {
            new ColorPickerDialog.Builder(MainActivity.this)
                    .setTitle("Color picker dialog")
                    .setPreferenceName("MyColorPicker")
                    .setPositiveButton(
                            getString(R.string.confirm),
                            (ColorEnvelopeListener) (envelope, fromUser) -> setLayoutColor(envelope)
                    ).setNegativeButton(
                            getString(R.string.cancel),
                            (DialogInterface.OnClickListener) (dialogInterface, i) -> dialogInterface.dismiss()
                    ).attachAlphaSlideBar(true)
                    .attachBrightnessSlideBar(true)
                    .setBottomSpace(12)
                    .show();
        });

        btnSquare.setOnClickListener(view -> {
            simplePaint.setDrawType(Shapes.Square);
        });

        btnImCircle.setOnClickListener(view -> {
            simplePaint.setDrawType(Shapes.Circle);
        });

        btnPath.setOnClickListener(view -> {
            simplePaint.setDrawType(Shapes.Path);
        });
    }

    public void setLayoutColor(ColorEnvelope color){
        simplePaint.paint.setColor(color.getColor());
        btnColor.setBackgroundColor(color.getColor());
    }
}