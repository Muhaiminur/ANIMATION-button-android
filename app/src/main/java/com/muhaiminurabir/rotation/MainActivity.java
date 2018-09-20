package com.muhaiminurabir.rotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.appolica.flubber.Flubber;
import com.example.circulardialog.CDialog;
import com.example.circulardialog.extras.CDConstants;
import com.theanilpaudel.rotatinganimation.Rotation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rotation)
    Button rotation;
    @BindView(R.id.img_rotate)
    ImageView imgRotate;
    @BindView(R.id.success)
    Button success;
    @BindView(R.id.rotate_animation)
    Button rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rotation)
    public void onRotationClicked() {
        Rotation rotation = new Rotation(imgRotate, 0, 350, 30, 10, Rotation.ABSOLUTE, Rotation.ABSOLUTE);
        rotation.roatateView(700);
        rotation.stopRotation(5000);
    }

    @OnClick(R.id.success)
    public void onSuccessClicked() {
        new CDialog(this).createAlert("CONGRATS",
                CDConstants.SUCCESS,   // Type of dialog
                CDConstants.LARGE)    //  size of dialog
                .setAnimation(CDConstants.SCALE_FROM_BOTTOM_TO_TOP)     //  Animation for enter/exit
                .setDuration(2000)   // in milliseconds
                .setTextSize(CDConstants.LARGE_TEXT_SIZE)  // CDConstants.LARGE_TEXT_SIZE, CDConstants.NORMAL_TEXT_SIZE
                .show();
    }

    @OnClick(R.id.rotate_animation)
    public void onViewClicked() {
        Flubber.with()
                .animation(Flubber.AnimationPreset.ZOOM_IN)
                .duration(1000)
                .autoStart(true)
                .createFor(imgRotate);
    }
}
