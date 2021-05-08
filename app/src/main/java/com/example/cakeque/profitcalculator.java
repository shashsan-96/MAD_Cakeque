package com.example.cakeque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class profitcalculator extends AppCompatActivity {

    private EditText billAmount;
    private SeekBar seekbar;
    private TextView seekbarTextview;
    private TextView tipTextView;
    private Button calButton;
    private  TextView totalTextView;
    private  int seekbarPrecentage;
    private  Float billamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profitcalculator);

        billAmount = findViewById((R.id.edit_billAmount));
        seekbar = findViewById(R.id.profit_seekbar);
        seekbarTextview = findViewById(R.id.Text_seek);
        tipTextView = findViewById(R.id.text_tip);
        calButton = findViewById(R.id.btn_calc);
        totalTextView = findViewById(R.id.text_tipTotal);

        seekbarTextview.setText(String.valueOf(seekbar.getProgress())+"%");
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarTextview.setText(String.valueOf(seekBar.getProgress())+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPrecentage = seekbar.getProgress();
            }
        });

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate(){
        Float result = 0.0f;

        if(!billAmount.getText().toString().equals("")) {

            billamount = Float.parseFloat(billAmount.getText().toString());

            result = billamount * seekbarPrecentage / 100;

            tipTextView.setText("Profit Rs."+String.valueOf(result));
            totalTextView.setText("Charge Ammount Rs."+(billamount+result));
        }else{

            Toast.makeText(this, "please enter your cost for cake", Toast.LENGTH_SHORT).show();

        }



        }
    }
