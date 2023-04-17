package com.example.mafi_emi_calulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edta,edtm,edtemi,edtdp;
    AppCompatButton btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edta=findViewById(R.id.edta);
        edtm=findViewById(R.id.edtm);
        edtemi=findViewById(R.id.edtemi);
        // edttemi=findViewById(R.id.edttemi);
        edtdp=findViewById(R.id.edtdp);
        // edtTotal=findViewById(R.id.edtTotal);
        btn1=findViewById(R.id.btn1);
        // btn2=findViewById(R.id.btn2);

        Intent intent=getIntent();
        String m=intent.getStringExtra("MONTH");
        String d=intent.getStringExtra("DP");
        String T=intent.getStringExtra("BTN");
        edtm.setText(m);
        edtdp.setText(d);
        edta.setText(T);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a =Integer.parseInt(edta.getText().toString());
                int m=Integer.parseInt(edtm.getText().toString());
                int d=Integer.parseInt(edtdp.getText().toString());
                int x=(a*13)/(12*100);
                int y=x*m;
                int z=(a+y)/m;
                // System.out.println("EMI:- "+ z);
                // edtemi.setText(z);
                int c=z*m;
                //  System.out.println("EMI total "+ c);
                // edttemi.setText(c);
                //  System.out.println("Enter dp Amount: ");
                // int dp=sc.nextInt();
                int t=c+d;
                //edtTotal.setText(t);
                //  System.out.println("Total "+ t );
                edtemi.setText(z+"-"+c+"-"+t);
            }
        });



    }
}