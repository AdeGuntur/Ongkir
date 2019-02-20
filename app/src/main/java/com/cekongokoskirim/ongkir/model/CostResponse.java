package com.cekongokoskirim.ongkir.model;

import com.google.gson.annotations.SerializedName;

public class CostResponse {
    @SerializedName("rajaongkir")
    private RajaongkirCost rajaongkir;

    public RajaongkirCost getRajaongkir() {
        return rajaongkir;
    }
}
