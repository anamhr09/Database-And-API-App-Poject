package com.example.routingmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView Name,Phone,Blood;
    LinearLayout header;
    ImageView massage,call ;

    public static String N ="" ;
    public static String P ="" ;
    public static String B ="" ;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Name=findViewById(R.id.Name);
        Phone=findViewById(R.id.Phone);
        Blood=findViewById(R.id.Blood);
        header=findViewById(R.id.header);
        massage=findViewById(R.id.massage);
        call=findViewById(R.id.call);

        Name.setText(N);
        Phone.setText(P);
        Blood.setText(B);


        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);

            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+P)) ;
                startActivity(intent);


            }
        });

        massage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity3.this,"Coming Soon",Toast.LENGTH_LONG);

            }
        });










    }
}