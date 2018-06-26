
package com.example.rakib.asynchttp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class London {

    @SerializedName("base")
    private String mBase;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("cod")
    private Long mCod;
    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("dt")
    private Long mDt;
    @SerializedName("id")
    private Long mId;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("name")
    private String mName;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("visibility")
    private Long mVisibility;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("wind")
    private Wind mWind;

    public String getBase() {
        return mBase;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public Long getCod() {
        return mCod;
    }

    public Coord getCoord() {
        return mCoord;
    }

    public Long getDt() {
        return mDt;
    }

    public Long getId() {
        return mId;
    }

    public Main getMain() {
        return mMain;
    }

    public String getName() {
        return mName;
    }

    public Sys getSys() {
        return mSys;
    }

    public Long getVisibility() {
        return mVisibility;
    }

    public List<Weather> getWeather() {
        return mWeather;
    }

    public Wind getWind() {
        return mWind;
    }

    public static class Builder {

        private String mBase;
        private Clouds mClouds;
        private Long mCod;
        private Coord mCoord;
        private Long mDt;
        private Long mId;
        private Main mMain;
        private String mName;
        private Sys mSys;
        private Long mVisibility;
        private List<Weather> mWeather;
        private Wind mWind;

        public London.Builder withBase(String base) {
            mBase = base;
            return this;
        }

        public London.Builder withClouds(Clouds clouds) {
            mClouds = clouds;
            return this;
        }

        public London.Builder withCod(Long cod) {
            mCod = cod;
            return this;
        }

        public London.Builder withCoord(Coord coord) {
            mCoord = coord;
            return this;
        }

        public London.Builder withDt(Long dt) {
            mDt = dt;
            return this;
        }

        public London.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public London.Builder withMain(Main main) {
            mMain = main;
            return this;
        }

        public London.Builder withName(String name) {
            mName = name;
            return this;
        }

        public London.Builder withSys(Sys sys) {
            mSys = sys;
            return this;
        }

        public London.Builder withVisibility(Long visibility) {
            mVisibility = visibility;
            return this;
        }

        public London.Builder withWeather(List<Weather> weather) {
            mWeather = weather;
            return this;
        }

        public London.Builder withWind(Wind wind) {
            mWind = wind;
            return this;
        }

        public London build() {
            London london = new London();
            london.mBase = mBase;
            london.mClouds = mClouds;
            london.mCod = mCod;
            london.mCoord = mCoord;
            london.mDt = mDt;
            london.mId = mId;
            london.mMain = mMain;
            london.mName = mName;
            london.mSys = mSys;
            london.mVisibility = mVisibility;
            london.mWeather = mWeather;
            london.mWind = mWind;
            return london;
        }

    }

}
