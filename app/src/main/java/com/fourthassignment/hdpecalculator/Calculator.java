package com.fourthassignment.hdpecalculator;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.fourthassignment.hdpecalculator.DBHelper.DBHelper;

import java.text.DecimalFormat;

public class Calculator extends Fragment {
    SQLiteDatabase sqLiteDatabase;
    DecimalFormat decimalFormat;
    DecimalFormat addCommaFormatter;
    private DBHelper dbHelper;
    private EditText txtWeight, txtPricePerKg, txtRate, txtVat,
            txtRateWithVat, txtQuantity, txtDiscount, txtSubTotal, txtTotal;
    private Button btnClear;

    public Calculator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        dbHelper = new DBHelper(getContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        decimalFormat = new DecimalFormat("#.##");
        addCommaFormatter = new DecimalFormat("#,##,##,###.##");
        Bundle bundle = getActivity().getIntent().getExtras();

        txtWeight = view.findViewById(R.id.txtWeight);
        txtPricePerKg = view.findViewById(R.id.txtPricePerKg);
        txtRate = view.findViewById(R.id.txtRate);
        txtVat = view.findViewById(R.id.txtVat);
        txtRateWithVat = view.findViewById(R.id.txtRateWithVat);
        txtQuantity = view.findViewById(R.id.txtQuantity);
        txtDiscount = view.findViewById(R.id.txtDiscount);
        txtSubTotal = view.findViewById(R.id.txtSubTotal);
        txtTotal = view.findViewById(R.id.txtTotal);

        if (bundle != null) {
            String unitWeight = dbHelper.getUnitWeight(bundle.getString("pipe"), bundle.getString("size"), sqLiteDatabase);
            txtWeight.setText(unitWeight);
        }

        btnClear = view.findViewById(R.id.btnClear);


        txtPricePerKg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (txtPricePerKg.getText().toString().isEmpty()){
                    emptyPricePerKg();
                }else{
                    calculateRateVat();
                }
            }
        });

        txtQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (txtQuantity.getText().toString().isEmpty()){
                    emptyQuantity();
                }else {
                    calculateSubTotal();
                }
            }
        });

        txtDiscount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (txtDiscount.getText().toString().isEmpty()){
                    emptyDiscount();
                }else {
                    calculateTotal();
                }
            }
        });
    }

    private void calculateRateVat() {
        float unitWeight = Float.parseFloat(txtWeight.getText().toString());
        float priceKg = Float.parseFloat(txtPricePerKg.getText().toString());
        float rate = unitWeight * priceKg;
        float vat = 0.13f * rate;
        float rateVat = rate + vat;

        txtRate.setText("" + addCommaFormatter.format(rate));
        txtVat.setText("" + addCommaFormatter.format(vat));
        txtRateWithVat.setText("" + addCommaFormatter.format(rateVat));

        if (!txtQuantity.getText().toString().isEmpty()) {
            calculateSubTotal();
            calculateTotal();
        }
    }

    private void calculateSubTotal() {
        if (!txtRateWithVat.getText().toString().isEmpty()) {
            float quantity = Float.parseFloat(txtQuantity.getText().toString());
            float rateVat = Float.parseFloat(txtRateWithVat.getText().toString().replace(",",""));
            float subTotal = quantity * rateVat;

            txtSubTotal.setText("" + addCommaFormatter.format(subTotal));
            if (!txtDiscount.getText().toString().isEmpty()) {
                calculateTotal();
            } else {
                txtTotal.setText("" + addCommaFormatter.format(subTotal));
            }
        }
    }

    private void calculateTotal() {
        if (!txtSubTotal.getText().toString().isEmpty()) {
            float discount = Float.parseFloat(txtDiscount.getText().toString());
            float subTotal = Float.parseFloat(txtSubTotal.getText().toString().replace(",",""));
            float discountAmount = subTotal * (discount / 100f);
            float total = subTotal - discountAmount;

            txtTotal.setText("" + addCommaFormatter.format(total));
        }
    }

    private void clearAll() {
        txtPricePerKg.setText("");
        txtRate.setText("");
        txtVat.setText("");
        txtRateWithVat.setText("");
        txtQuantity.setText("");
        txtDiscount.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
    }

    private void emptyPricePerKg() {
        txtRate.setText("");
        txtVat.setText("");
        txtRateWithVat.setText("");
        txtQuantity.setText("");
        txtDiscount.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
    }

    private void emptyQuantity(){
        txtDiscount.setText("");
        txtSubTotal.setText("");
        txtTotal.setText("");
    }

    private void emptyDiscount(){
        txtTotal.setText("");
    }
}
