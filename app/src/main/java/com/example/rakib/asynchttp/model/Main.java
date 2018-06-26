
package com.example.rakib.asynchttp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Main {

    @SerializedName("humidity")
    private Long mHumidity;
    @SerializedName("pressure")
    private Long mPressure;
    @SerializedName("temp")
    private Double mTemp;
    @SerializedName("temp_max")
    private Double mTempMax;
    @SerializedName("temp_min")
    private Double mTempMin;

    public Long getHumidity() {
        return mHumidity;
    }

    public Long getPressure() {
        return mPressure;
    }

    public Double getTemp() {
        return mTemp;
    }

    public Double getTempMax() {
        return mTempMax;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public static class Builder {

        private Long mHumidity;
        private Long mPressure;
        private Double mTemp;
        private Double mTempMax;
        private Double mTempMin;

        public Main.Builder withHumidity(Long humidity) {
            mHumidity = humidity;
            return this;
        }

        public Main.Builder withPressure(Long pressure) {
            mPressure = pressure;
            return this;
        }

        public Main.Builder withTemp(Double temp) {
            mTemp = temp;
            return this;
        }

        public Main.Builder withTempMax(Double tempMax) {
            mTempMax = tempMax;
            return this;
        }

        public Main.Builder withTempMin(Double tempMin) {
            mTempMin = tempMin;
            return this;
        }

        public Main build() {
            Main main = new Main();
            main.mHumidity = mHumidity;
            main.mPressure = mPressure;
            main.mTemp = mTemp;
            main.mTempMax = mTempMax;
            main.mTempMin = mTempMin;
            return main;
        }

    }

}
