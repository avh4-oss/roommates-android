package com.mattieapps.roommates;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

/**
 * Created by andrewmattie on 11/19/14.
 */
public class TipCalActivity extends BaseActivity {

    Button mPickGratuityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        FloatingActionButton fabButton = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_flip))
                .withButtonColor(Color.LTGRAY)
                .withGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL)
                .withMargins(0, 0, 0, 16)
                .create();

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipCalActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mPickGratuityBtn = (Button) findViewById(R.id.pickGratuityBtn);
        mPickGratuityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getApplication())
                        .title("Gratuity amount")
                        .content("Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.")
                        .theme(Theme.LIGHT)  // the default is light, so you don't need this line
                        .positiveText("Agree")  // the default for textual dialogs (not list or custom view dialogs) is 'OK'
                        .negativeText("Disagree")  // leaving this line out will remove the negative button
                        .build()
                        .show();
            }
        });
    }
}