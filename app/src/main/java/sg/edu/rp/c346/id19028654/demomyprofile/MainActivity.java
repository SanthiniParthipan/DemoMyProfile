package sg.edu.rp.c346.id19028654.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    RadioButton rbMale,rbFemale;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA= findViewById(R.id.editTextGPA);
        rgGender=findViewById(R.id.radioGroupGender);
        rbFemale=findViewById(R.id.radioButtonGenderFemale);
        rbMale=findViewById(R.id.radioButtonGenderMale);
        btnSave=findViewById(R.id.buttonSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        String strName=etName.getText().toString();
        String ftGpa=etGPA.getText().toString();
        int intGenderId =rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit=prefs.edit();
        preEdit.putString("name",strName);
        preEdit.putFloat("gpa", Float.parseFloat(ftGpa));
        preEdit.putInt("genderId",intGenderId);


        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName=prefs.getString("name","peter");
        float ftGPA=prefs.getFloat("gpa",0);
        int intGenderId =prefs.getInt(("genderId"),R.id.radioButtonGenderMale);
        etGPA.setText(ftGPA+"");
        etName.setText(strName);
        rgGender.check(intGenderId);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"saving",Toast.LENGTH_LONG).show();

            }
        });
    }

}
