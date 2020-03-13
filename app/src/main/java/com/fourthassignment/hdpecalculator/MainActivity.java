package com.fourthassignment.hdpecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SmartMaterialSpinner spPipe, spSize;
    private List<String> pipeList;
    private List<String> pn6Size;
    private List<String> pn10Size;
    private List<String> pn12Size;
    private List<String> pn16Size;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPipeSpinner();
    }

    private void initPipeSpinner() {
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);
        spPipe = findViewById(R.id.spinner_pipe);
        spSize = findViewById(R.id.spinner_size);
        pipeList = new ArrayList<>();
        pipeList.add("PN 6");
        pipeList.add("PN 10");
        pipeList.add("PN 12.5");
        pipeList.add("PN 16");

        spPipe.setItem(pipeList);

        spPipe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pn6SizeList();
                        spSize.setVisibility(View.VISIBLE);
                        btnGo.setVisibility(View.GONE);
                        spSize.setItem(pn6Size);
                        break;
                    case 1:
                        pn10SizeList();
                        spSize.setVisibility(View.VISIBLE);
                        btnGo.setVisibility(View.GONE);
                        spSize.setItem(pn10Size);
                        break;
                    case 2:
                        pn12SizeList();
                        spSize.setVisibility(View.VISIBLE);
                        btnGo.setVisibility(View.GONE);
                        spSize.setItem(pn12Size);
                        break;
                    case 3:
                        pn16SizeList();
                        spSize.setVisibility(View.VISIBLE);
                        btnGo.setVisibility(View.GONE);
                        spSize.setItem(pn16Size);
                        break;
                    default:
                        break;
                }

                spSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        btnGo.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


    }

    private void pn6SizeList() {
        pn6Size = new ArrayList<>();
        pn6Size.add("50.00 mm - 50.50 mm");
        pn6Size.add("63.00 mm - 63.60 mm");
        pn6Size.add("75.00 mm - 75.70 mm");
        pn6Size.add("90.00 mm - 90.90 mm");
        pn6Size.add("110.00 mm - 111.00 mm");
        pn6Size.add("125.00 mm - 126.20 mm");
        pn6Size.add("140.00 mm - 141.30 mm");
        pn6Size.add("160.00 mm - 161.50 mm");
        pn6Size.add("180.00 mm - 181.70 mm");
        pn6Size.add("200.00 mm - 201.80 mm");
        pn6Size.add("225.00 mm - 227.00 mm");
        pn6Size.add("250.00 mm - 252.30 mm");
        pn6Size.add("280.00 mm - 282.60 mm");
        pn6Size.add("315.00 mm - 317.90 mm");
    }

    private void pn10SizeList() {
        pn10Size = new ArrayList<>();
        pn10Size.add("32.00 mm - 32.30 mm");
        pn10Size.add("40.00 mm - 40.40 mm");
        pn10Size.add("50.00 mm - 50.50 mm");
        pn10Size.add("63.00 mm - 63.60 mm");
        pn10Size.add("75.00 mm - 75.70 mm");
        pn10Size.add("90.00 mm - 90.90 mm");
        pn10Size.add("110.00 mm - 111.00 mm");
        pn10Size.add("125.00 mm - 126.20 mm");
        pn10Size.add("140.00 mm - 141.30 mm");
        pn10Size.add("160.00 mm - 161.50 mm");
        pn10Size.add("180.00 mm - 181.70 mm");
        pn10Size.add("200.00 mm - 201.80 mm");
        pn10Size.add("225.00 mm - 227.00 mm");
        pn10Size.add("250.00 mm - 252.30 mm");
        pn10Size.add("280.00 mm - 282.60 mm");
        pn10Size.add("315.00 mm - 317.90 mm");
    }

    private void pn12SizeList() {
        pn12Size = new ArrayList<>();
        pn12Size.add("25.00 mm - 25.30 mm");
        pn12Size.add("32.00 mm - 32.30 mm");
        pn12Size.add("40.00 mm - 40.40 mm");
        pn12Size.add("50.00 mm - 50.50 mm");
        pn12Size.add("63.00 mm - 63.60 mm");
        pn12Size.add("75.00 mm - 75.70 mm");
        pn12Size.add("90.00 mm - 90.90 mm");
        pn12Size.add("110.00 mm - 111.00 mm");
        pn12Size.add("125.00 mm - 126.20 mm");
        pn12Size.add("140.00 mm - 141.30 mm");
        pn12Size.add("160.00 mm - 161.50 mm");
        pn12Size.add("180.00 mm - 181.70 mm");
        pn12Size.add("200.00 mm - 201.80 mm");
        pn12Size.add("225.00 mm - 227.00 mm");
        pn12Size.add("250.00 mm - 252.30 mm");
        pn12Size.add("280.00 mm - 282.60 mm");
        pn12Size.add("315.00 mm - 317.90 mm");
    }

    private void pn16SizeList() {
        pn16Size = new ArrayList<>();
        pn16Size.add("20.00 mm - 20.30 mm");
        pn16Size.add("25.00 mm - 25.30 mm");
        pn16Size.add("32.00 mm - 32.30 mm");
        pn16Size.add("40.00 mm - 40.40 mm");
        pn16Size.add("50.00 mm - 50.50 mm");
        pn16Size.add("63.00 mm - 63.60 mm");
        pn16Size.add("75.00 mm - 75.70 mm");
        pn16Size.add("90.00 mm - 90.90 mm");
        pn16Size.add("110.00 mm - 111.00 mm");
        pn16Size.add("125.00 mm - 126.20 mm");
        pn16Size.add("140.00 mm - 141.30 mm");
        pn16Size.add("160.00 mm - 161.50 mm");
        pn16Size.add("180.00 mm - 181.70 mm");
        pn16Size.add("200.00 mm - 201.80 mm");
        pn16Size.add("225.00 mm - 227.00 mm");
        pn16Size.add("250.00 mm - 252.30 mm");
        pn16Size.add("280.00 mm - 282.60 mm");
        pn16Size.add("315.00 mm - 317.90 mm");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnGo:
                Intent intent = new Intent(this,Calculator.class);
                intent.putExtra("pipe",spPipe.getSelectedItem().toString());
                intent.putExtra("size",spSize.getSelectedItem().toString());
                startActivity(intent);
        }
    }
}
