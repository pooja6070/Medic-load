package com.android.pharmacy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.pharmacy.adapters.PharmacyListAdapter;
import com.android.pharmacy.model.PharmacyModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PharmacyListAdapter.PharmacyListClickListener {
private Button btnsearch;
private EditText editsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnsearch = findViewById(R.id.btnSearch);
editsearch = findViewById(R.id.editSearch);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pharmacy List");


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(MainActivity.this, "Data found !!", Toast.LENGTH_SHORT).show();
                    editsearch.requestFocus();
                    List<PharmacyModel> pharmacyModelList =  getPharmacyData();
                    initRecyclerView(pharmacyModelList);
            }
        });
    }

    private void initRecyclerView(List<PharmacyModel> pharmacyModelList) {
        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PharmacyListAdapter adapter = new PharmacyListAdapter(pharmacyModelList, this);
        recyclerView.setAdapter(adapter);
    }

    private List<PharmacyModel> getPharmacyData() {
        InputStream is = getResources().openRawResource(R.raw.pharmacy);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while(( n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0,n);
            }
        }catch (Exception e) {

        }

        String jsonStr = writer.toString();
        Gson gson = new Gson();
        PharmacyModel[] pharmacyModels =  gson.fromJson(jsonStr, PharmacyModel[].class);
        List<PharmacyModel> restList = Arrays.asList(pharmacyModels);

        return  restList;

    }

    @Override
    public void onItemClick(PharmacyModel pharmacyModel) {
        Intent intent = new Intent(MainActivity.this, PharmacyMenuActivity.class);
        intent.putExtra("PharmacyModel", pharmacyModel);
        startActivity(intent);

    }
}