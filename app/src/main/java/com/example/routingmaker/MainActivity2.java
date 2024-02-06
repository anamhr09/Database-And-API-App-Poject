        package com.example.routingmaker;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;

        public class MainActivity2 extends AppCompatActivity {

            HashMap<String,String>hashMap;
            ArrayList<HashMap<String ,String>>arrayList=new ArrayList<>();
               ListView listView;
               ProgressBar pro ;
               LinearLayout header;



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);
                   listView=findViewById(R.id.listView);
                   pro=findViewById(R.id.pro);
                 header=findViewById(R.id.header);

                   String url="https://anamhr.xyz/app/userget.php" ;
                   pro.setVisibility(View.VISIBLE);

                RequestQueue requestQueue=Volley.newRequestQueue(MainActivity2.this);
                JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                            pro.setVisibility(View.GONE);


                                for (int x=0 ;x<response.length() ;x++){

                                    try {
                                        JSONObject jsonObject=response.getJSONObject(x);

                                        String id =jsonObject.getString("id") ;
                                        String name=jsonObject.getString("name");
                                        String phone=jsonObject.getString("Phone");
                                        String blood=jsonObject.getString("blood");

                                        hashMap=new HashMap<>();
                                        hashMap.put("Id",id);
                                        hashMap.put("Name",name);
                                        hashMap.put("Phone",phone);
                                        hashMap.put("Blood",blood);
                                        arrayList.add(hashMap);




                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }


                                }


                                if (arrayList.size()>0){
                                    MyAdapter myAdapter=new MyAdapter() ;
                                    listView.setAdapter(myAdapter);
                                }




                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {






                    }
                });



            requestQueue.add(jsonArrayRequest);





            header.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent =new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);


                }
            });


                                /*

                                ******** PHP Code To Get Data from Database And Create Json API ***********


        <?php
                    header("Content-Type: application/json");


  //Connect Php With Database //  $con = mysqli_connect("localhost","akqvhqvz_anamhr","Anam09@0@","akqvhqvz_my_database") ;

  //Select Database Table //  $sql = "SELECT * FROM user_data" ;
  //         Query               //  $result = mysqli_query($con,$sql);



 // Array Like HastMap       //  $data =array() ;

// Loop For Get All Data //   foreach($result as $item){

                              $Id = $item['id'] ;
                              $Name = $item['name'] ;
                              $Phone = $item['phone'] ;
                              $Blood = $item['blood'] ;


                        $userInfo['id']=$Id ;
                        $userInfo['name']=$Name ;
                        $userInfo['Phone']=$Phone ;
                        $userInfo['blood']=$Blood ;
                        array_push($data,$userInfo) ;

                          }

  // for Json Format //        echo json_encode($data) ;

                                                                                  ?>


                                 */








            }

            //*********************************************

            public class MyAdapter extends BaseAdapter{


                @Override
                public int getCount() {
                    return arrayList.size();
                }

                @Override
                public Object getItem(int position) {
                    return null;
                }

                @Override
                public long getItemId(int position) {
                    return 0;
                }

                @SuppressLint("MissingInflatedId")
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    LayoutInflater layoutInflater=getLayoutInflater();
                    View myView =   layoutInflater.inflate(R.layout.item,null);
                    TextView bloodGroup , dNAme ;
                    CardView cardView;

                    bloodGroup=myView.findViewById(R.id.bloodGroup);
                    dNAme=myView.findViewById(R.id.dName);
                    cardView=myView.findViewById(R.id.cardView);


                    hashMap=arrayList.get(position);
                    String name = hashMap.get("Name");
                    String phone = hashMap.get("Phone");
                    String blood = hashMap.get("Blood");

                    dNAme.setText(name);
                    bloodGroup.setText(blood);


                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent =new Intent(MainActivity2.this,MainActivity3.class);
                            startActivity(intent);

                           MainActivity3.N=name ;
                           MainActivity3.P=phone;
                           MainActivity3.B=blood;





                        }
                    });






                    return myView;
                }
            }

            //*********************************************

        }