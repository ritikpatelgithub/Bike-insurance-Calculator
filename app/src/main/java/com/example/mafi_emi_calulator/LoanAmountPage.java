package com.example.mafi_emi_calulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoanAmountPage extends AppCompatActivity {
    EditText edtb,edta,edtp,edtm,edtd,edtt;
    AppCompatButton btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_amount_page);
        edtb=findViewById(R.id.edtb);
        edta=findViewById(R.id.edta);
        edtp=findViewById(R.id.edtp);
        edtm=findViewById(R.id.edtm);
        edtd=findViewById(R.id.edtd);
        edtt=findViewById(R.id.edtt);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        Intent intent = new Intent(LoanAmountPage.this,MainActivity.class);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m=edtm.getText().toString();
                String d=edtd.getText().toString();
                String T=edtt.getText().toString();

                intent.putExtra("MONTH",m);
                intent.putExtra("DP",d);
                intent.putExtra("BTN",T);
                startActivity(intent);

            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b=edtb.getText().toString().trim();
                String ac=edta.getText().toString().trim();
                String m1=edtp.getText().toString().trim();
                String m=edtm.getText().toString().trim();
                if (TextUtils.isEmpty(b)){
                    edtb.setError("It is Empty");
                }
                if (TextUtils.isEmpty(ac)){
                    edta.setError("It is Empty");
                }
                if (TextUtils.isEmpty(m1)){
                    edtp.setError("It is Empty");
                }
                if (TextUtils.isEmpty(m)){
                    edtb.setError("It is Empty");
                }


                int n1=Integer.parseInt(edtb.getText().toString());
                int n2=Integer.parseInt(edta.getText().toString());
                int n3=Integer.parseInt(edtp.getText().toString());
                int n4=Integer.parseInt(edtd.getText().toString());
                int a=Integer.parseInt(edtm.getText().toString());
                int c = 0;
                if (a==12){
                    c=2174;
                } else if (a==18 ||a==24) {
                    c=2298;

                } else if (a==30 ||a==36) {
                    c=2922;
                } else if (a==42 ||a==48) {
                    c=3046;
                }
                int x=(n1+n2+n3+c);
                int y=x-n4;
                edtt.setText("G.A-  "+x+"\n L.A-  "+y);


            }
        });


    }
}