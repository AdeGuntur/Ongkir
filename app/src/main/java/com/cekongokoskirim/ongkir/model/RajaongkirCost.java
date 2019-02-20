package com.cekongokoskirim.ongkir.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RajaongkirCost {
    @SerializedName("results")
    private List<CostResult> results = null;

    public List<CostResult> getResults() {
        return results;
    }
}
