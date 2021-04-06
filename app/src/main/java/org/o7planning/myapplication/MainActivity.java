package org.o7planning.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText textFullname;
    private  AutoCompleteTextView textCountry;
    private  MultiAutoCompleteTextView textProgrammingLanguage;

    private Button buttonSubmit;

    private String[] countries = {"Vietnam","England","Canada", "France","Australia"};

    private String[] languages={"Java ","CSharp","Visual Basic","Swift","C/C++", "Android Application"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFullname = (EditText) findViewById(R.id.editText);
        textCountry =(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        textProgrammingLanguage =(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        buttonSubmit= (Button) findViewById(R.id.button);

        ArrayAdapter adapterCountries
                = new ArrayAdapter(this,android.R.layout.simple_list_item_1,countries);

        textCountry.setAdapter(adapterCountries);

        // Set the minimum number of characters, to show suggestions
        textCountry.setThreshold(1);

        ArrayAdapter adapterLanguages
                = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);

        textProgrammingLanguage.setAdapter(adapterLanguages);

        textProgrammingLanguage.setThreshold(1);

        // The text separated by commas
        textProgrammingLanguage.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        buttonSubmit.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String text="Fullname: "+ this.textFullname.getText().toString()
                +"\nCountry: "+ this.textCountry.getText().toString()
                +"\nLanguages: "+ this.textProgrammingLanguage.getText().toString();

        Toast.makeText(this, text,Toast.LENGTH_LONG).show();

    }

}