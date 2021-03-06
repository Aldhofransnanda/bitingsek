package id.sch.smktelkom_mlg.tugas01.xiirpl1006.bitingsek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Spinner spRasa;
    CheckBox cbS, cbM, cbL, cbXL;
    RadioButton rbMakan, rbBawa;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        spRasa = (Spinner) findViewById(R.id.spinnerRasa);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbL = (CheckBox) findViewById(R.id.checkBoxL);
        cbXL = (CheckBox) findViewById(R.id.checkBoxXL);
        rbMakan = (RadioButton) findViewById(R.id.radioButtonMakan);
        rbBawa = (RadioButton) findViewById(R.id.radioButtonBawa);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else {
            etNama.setText(nama);
        }

        String hasil = "Size                       : \n";
        int startlen = hasil.length();
        if (cbS.isChecked()) hasil += cbS.getText() + "\n";
        if (cbM.isChecked()) hasil += cbM.getText() + "\n";
        if (cbL.isChecked()) hasil += cbL.getText() + "\n";
        if (cbXL.isChecked()) hasil += cbXL.getText() + "\n";

        String hasil2;
        if (rbMakan.isChecked()) {
            hasil2 = "Orderan               : \n" + rbMakan.getText().toString() + "\n";
        } else if (rbBawa.isChecked()) {
            hasil2 = "Orderan              : \n" + rbBawa.getText().toString() + "\n";
        } else {
            hasil2 = "Orderan               : \nBelum memilih\n";
        }

        String hasil3 = "Harga                      : \n";
        if (cbS.isChecked()) hasil3 += cbS.getText() + " - Rp. 5000\n";
        if (cbM.isChecked()) hasil3 += cbM.getText() + " - Rp. 10000\n";
        if (cbL.isChecked()) hasil3 += cbL.getText() + " - Rp. 15000\n";
        if (cbXL.isChecked()) hasil3 += cbXL.getText() + " - Rp. 20000\n";


        tvHasil.setText("Nama Customer  : \n" + nama +
                "\n\nRasa                      : \n" + spRasa.getSelectedItem().toString() +
                "\n\n" + hasil +
                "\n" + hasil2 +
                "\n" + hasil3);
    }
}
