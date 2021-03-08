package com.example.gpa_virgoo1_calculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button compute;
    EditText g1input,g2input,g3input,g4input,g5input;
    TextView t;
    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compute=(Button)findViewById(R.id.compute);
        g1input=(EditText)findViewById(R.id.g1input);
        g2input=(EditText)findViewById(R.id.g2input);
        g3input=(EditText)findViewById(R.id.g3input);
        g4input=(EditText)findViewById(R.id.g4input);
        g5input=(EditText)findViewById(R.id.g5input);
        t=(TextView)findViewById(R.id.gpa);
        t.setBackgroundColor(Color.WHITE);
        compute.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                float g1, g2, g3, g4, g5;
                if (count % 2 == 0) {
                    if (g1input.getText().toString().equals("") || g2input.getText().toString().equals("") || g3input.getText().toString().equals("") || g4input.getText().toString().equals("") || g5input.getText().toString().equals("")) {
                        t.setText("Enter grades in all fields");
                    }
                    else {
                        g1 = Float.parseFloat(g1input.getText().toString());
                        g2 = Float.parseFloat(g2input.getText().toString());
                        g3 = Float.parseFloat(g3input.getText().toString());
                        g4 = Float.parseFloat(g4input.getText().toString());
                        g5 = Float.parseFloat(g5input.getText().toString());
                        float sum = g1 + g2 + g3 + g4 + g5;
                        float avg;
                        avg = sum / 5;
                        if (avg < 60) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.RED);
                        } else if (avg > 60 && avg < 80) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.YELLOW);
                        } else if (avg >= 80 && avg <= 100) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        compute.setText("Clear");
                    }

                }
                else
                {
                    g1input.setText("");
                    g2input.setText("");
                    g3input.setText("");
                    g4input.setText("");
                    g5input.setText("");
                    t.setText("");
                    compute.setText("Compute GPA");
                    t.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}
