package jp.techacademy.takashi.sasaki.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("debug", "" + hourOfDay + ":" + minute);
                        TextView textView = (TextView) findViewById(R.id.textView);
                        /**
                         *  2:00 ~  9:59 では「おはよう」
                         * 10:00 ~ 17:59 では「こんにちは」
                         * 18:00 ~  1:59 では「こんばんは」
                         */
                        if (2 <= hourOfDay && hourOfDay < 10) {
                            Log.d("debug", "おはよう");
                            textView.setText("おはよう");
                        } else if (10 <= hourOfDay && hourOfDay < 18) {
                            Log.d("debug", "こんにちは");
                            textView.setText("こんにちは");
                        } else {
                            Log.d("debug", "こんばんは");
                            textView.setText("こんばんは");
                        }
                    }
                }, 13, 0, true);
        timePickerDialog.show();
    }
}
