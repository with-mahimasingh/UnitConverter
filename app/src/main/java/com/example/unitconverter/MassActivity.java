package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MassActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayAdapter<CharSequence> fromSpinnerAdapter, toSpinnerAdapter;
    private android.widget.ArrayAdapter ArrayAdapter;
    Spinner fromSpinner, toSpinner;
    EditText fromEditText, toEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        fromSpinner = (Spinner) findViewById(R.id.spinner_from);
        toSpinner = (Spinner) findViewById(R.id.spinner_to);
        fromEditText = (EditText) findViewById(R.id.editText_from);
        toEditText = (EditText) findViewById(R.id.editText_to);
        fromSpinnerAdapter = android.widget.ArrayAdapter.createFromResource(this,
                R.array.mass_units, android.R.layout.simple_spinner_item);
        fromSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromSpinnerAdapter);
        toSpinnerAdapter = android.widget.ArrayAdapter.createFromResource(this,
                R.array.mass_units, android.R.layout.simple_spinner_item);
        toSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toSpinnerAdapter);
        String  fromText=fromEditText.getText().toString();
        String  toText=toEditText.getText().toString();

        ImageButton swapping = (ImageButton) findViewById(R.id.swap);

        swapping.setOnClickListener(view -> {
            int positionSpinner1 = fromSpinner.getSelectedItemPosition();
            int positionSpinner2 = toSpinner.getSelectedItemPosition();

            if (fromSpinner.getAdapter().equals(fromSpinnerAdapter)) {
                fromSpinner.setAdapter(toSpinnerAdapter);
                toSpinner.setAdapter(fromSpinnerAdapter);

            } else {

                toSpinner.setAdapter(fromSpinnerAdapter);
                fromSpinner.setAdapter(toSpinnerAdapter);

            }
            fromEditText.getText().clear();
            toEditText.getText().clear();
            fromSpinner.setSelection(positionSpinner2);
            toSpinner.setSelection(positionSpinner1);
        });

    }



    public void convert_mass(View view) {
        fromSpinner = (Spinner) findViewById(R.id.spinner_from);
        toSpinner = (Spinner) findViewById(R.id.spinner_to);
        fromEditText = (EditText) findViewById(R.id.editText_from);
        toEditText = (EditText) findViewById(R.id.editText_to);
        int positionSpinner1 = fromSpinner.getSelectedItemPosition();
        int positionSpinner2 = toSpinner.getSelectedItemPosition();
        if (positionSpinner1==(positionSpinner2)) {
            Toast.makeText(getApplicationContext(), "Cannot convert to the same unit!", Toast.LENGTH_SHORT).show();
            toEditText.setText("");
            return;
        }
        try {
            fromSpinner = (Spinner) findViewById(R.id.spinner_from);
            toSpinner = (Spinner) findViewById(R.id.spinner_to);
            fromEditText = (EditText) findViewById(R.id.editText_from);
            toEditText = (EditText) findViewById(R.id.editText_to);

            // Get the string from the Spinners and number from the EditText
            String fromString = (String) fromSpinner.getSelectedItem();
            String toString = (String) toSpinner.getSelectedItem();
            double input = Double.parseDouble(fromEditText.getText().toString());

            // Convert the strings to something in our Unit enu,
            Conversion.Unit fromUnit = Conversion.Unit.fromString(fromString);
            Conversion.Unit toUnit = Conversion.Unit.fromString(toString);

            // Create a converter object and convert!

            Conversion converter = new Conversion(fromUnit, toUnit);
            double result = converter.convert(input);
            toEditText.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
        }
    }

    @Override
    public void onClick(View v) {

    }
}
