package com.example.routingmaker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,blood ;
    ProgressBar pro ;
    CardView click;
    LinearLayout header;
    TextView error;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        blood=findViewById(R.id.blood);
        pro=findViewById(R.id.pro);
        click=findViewById(R.id.click);
        header=findViewById(R.id.header);
        error=findViewById(R.id.error);


        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);


            }
        });




        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String Name = name.getText().toString();
               String Phone =phone.getText().toString();
               String Blood=blood.getText().toString();
               String url ="https://anamhr.xyz/app/user.php?n="+Name+"&p="+Phone+"&b="+Blood ;



               pro.setVisibility(View.VISIBLE);
                StringRequest stringRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    pro.setVisibility(View.GONE);

                    new AlertDialog.Builder(MainActivity.this).setTitle("Input Result")
                            .setMessage(response)
                            .show();




                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {





                    }
                }) ;


             if (name.length()>0 && phone.length()>0 && blood.length()>0){

                 RequestQueue requestQueue=Volley.newRequestQueue(MainActivity.this);
                 requestQueue.add(stringRequest);



             }else {

                 error.setError("Please Fill Up All Input");


             }







            }
        });




        /// ************************    ******************************************************

        /*


        This poject backend PHP Code For Data Inseart into Database ??
        *
                   <?php

            $con = mysqli_connect("localhost","akqvhqvz_anamhr","Anam09@0@","akqvhqvz_my_database") ;

            if(mysqli_connect_errno() )
                echo "Did Not Connect To Database ! <br>" . mysqli_connect_error();
            else
                echo " Yes Connected To Database " ;

             $Name =$_GET['n'] ;
             $Phone=$_GET['p'] ;
             $blood=$_GET['b'] ;


                $sql = "INSERT INTO user_data(name,phone,blood) VALUES('$Name','$Phone','$blood') " ;
            $result = mysqli_query($con,$sql);

            if($result){

                echo "<br> Data Submitted" ;
            }else{

                echo "Data Not Submitted" ;
            }



	?>

        *
        * */
/// ************************ ********************************






}


//************************************




}
