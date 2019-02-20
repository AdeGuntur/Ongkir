package com.cekongokoskirim.ongkir.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cekongokoskirim.ongkir.api.BaseApi;
import com.cekongokoskirim.ongkir.api.Response;
import com.cekongokoskirim.ongkir.R;
import com.cekongokoskirim.ongkir.adapter.CostAdapter;
import com.cekongokoskirim.ongkir.model.Cost;
import  com.cekongokoskirim.ongkir.model.CostResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CostActivity extends AppCompatActivity {
    RecyclerView recyclerCost;
    List<Cost> costs = new ArrayList<>();
    CostAdapter costAdapter = new CostAdapter(costs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);

        String token = getIntent().getStringExtra(Response.TOKEN);
        String origin = getIntent().getStringExtra(Response.ORIGIN);
        String destination = getIntent().getStringExtra(Response.DESTINATION);
        String weight = getIntent().getStringExtra(Response.WEIGHT);
        String courier = getIntent().getStringExtra(Response.COURIER).toLowerCase();

        recyclerCost = findViewById(R.id.rv_cost);
        recyclerCost.setLayoutManager(new LinearLayoutManager(this));
        recyclerCost.setAdapter(costAdapter);
        getCost(token, origin, destination, weight, courier);
    }

    public void getCost(String token, String origin, String dest, String weight, String courier){
        BaseApi.getServices().getCost(token, origin, dest, weight, courier).enqueue(new Callback<CostResponse>() {
            @Override
            public void onResponse(Call<CostResponse> call, retrofit2.Response response) {
                if (response.isSuccessful()){
                    costs.addAll(response.body().getRajaongkir().getResults().get(0).getCosts());
                    costAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(CostActivity.this,Response.ERROR_NOT_SUCCESS, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CostResponse> call, Throwable t) {

            }
        });
    }
}
