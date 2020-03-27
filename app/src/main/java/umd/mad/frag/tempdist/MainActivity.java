package umd.mad.frag.tempdist;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.distance_setting) {
            Toast.makeText(this, R.string.distance_setting, Toast.LENGTH_LONG).show();
        }
        else {
            return super.onContextItemSelected(item);
        }

        return true;
    }//end onOptionsItemSelected

    public void onClickConvert(View view) {

        EditText input = findViewById(R.id.inputField);
        TextView output = findViewById(R.id.outputField);
        double value = Double.parseDouble(input.getText().toString());
        UnitFragment fragment = (UnitFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        assert fragment != null;
        value = fragment.convert(value);
        output.setText(String.format(Locale.US, "%.2f", value));
    }

    public void onClickSwap(View view) {

        EditText input = findViewById(R.id.inputField);
        TextView output = findViewById(R.id.outputField);
        TextView unit1 = findViewById(R.id.unit1);
        TextView unit2 = findViewById(R.id.unit2);
        String temp;

        temp = input.getText().toString();
        input.setText(output.getText());
        output.setText(temp);

        temp = unit1.getText().toString();
        unit1.setText(unit2.getText());
        unit2.setText(temp);

        UnitFragment fragment = (UnitFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        assert fragment != null;
        fragment.swapUnits();

    }
}
