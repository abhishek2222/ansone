package aka.ansone;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


@Override
protected void onPause() {
    super.onPause();
    SharedPreferences sharedPreferences =
            getSharedPreferences( "gla.abhihek.sharedprefdemo", MODE_PRIVATE );
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("name", editText.getText().toString().trim());
    editor.putBoolean("bool", true);
    editor.apply();

}

@Override
protected void onResume() {
    super.onResume();
    SharedPreferences sharedPreferences =
            getSharedPreferences( "gla.abhishek.sharedprefdemo", MODE_PRIVATE);
    String s1 = sharedPreferences.getString( "name", false);
    Boolean remember = sharedPreferences.getBoolean( "bool", false);
    Toast.makeText( this, "bool" + remember, Toast.LENGTH_SHORT).show();
    editText.setText(s1);
}