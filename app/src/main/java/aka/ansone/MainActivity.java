package aka.ansone;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mail,pass;
    private Button login;
    String dMail,dPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        login=findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mail.getText().toString().equals(dMail)&&pass.getText().toString().equals(dPass)){
                    Toast.makeText(MainActivity.this, "Correct, Login successful", Toast.LENGTH_SHORT).show();

                }else if (mail.getText().toString().equals("")||pass.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "enter id and password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "id or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences=getSharedPreferences("abhishek02.sharedprefdemo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("mail","abhishek.singh_mca18@gla.ac.in");
        editor.putString("pass","12345");
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("abhishek02.sharedprefdemo",MODE_PRIVATE);
        dMail=sharedPreferences.getString("mail","user");
        dPass=sharedPreferences.getString("pass","password");

    }


}