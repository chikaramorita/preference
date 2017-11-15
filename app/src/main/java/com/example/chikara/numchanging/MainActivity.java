package com.example.chikara.numchanging;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private String Sample = "Sample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.editText1);

                String str = editText.getText().toString();



                SharedPreferences pref = getSharedPreferences("settings", MODE_PRIVATE);

                SharedPreferences.Editor editor = pref.edit();

                editor.putString("name", str);

                editor.commit();



               /* Toast.makeText(MainActivity.this, str + "さんを登録しました。",

                        Toast.LENGTH_SHORT).show();
*/
                SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
                String userName = preferences.getString("name", "");

                TextView text = (TextView)findViewById(R.id.textView);
                text.setText(userName);


            }

        });



        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        String userName = preferences.getString("name", "");

        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(userName);
    }

}