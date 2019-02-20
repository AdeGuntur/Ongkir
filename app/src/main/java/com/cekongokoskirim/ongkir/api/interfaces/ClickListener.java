package com.cekongokoskirim.ongkir.api.interfaces;

import com.cekongokoskirim.ongkir.model.CityResult;
import com.cekongokoskirim.ongkir.model.ProvinceResult;

public interface ClickListener {
    void onProvinceItemClick(ProvinceResult provinceResult);
    void onCityItemClick(CityResult cityResult);
}
