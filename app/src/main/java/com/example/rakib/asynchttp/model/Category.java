
package com.example.rakib.asynchttp.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Category {

    @SerializedName("c_id")
    private Long mCId;
    @SerializedName("c_name")
    private String mCName;
    @SerializedName("no_item")
    private Long mNoItem;

    public Long getCId() {
        return mCId;
    }

    public String getCName() {
        return mCName;
    }

    public Long getNoItem() {
        return mNoItem;
    }

    public static class Builder {

        private Long mCId;
        private String mCName;
        private Long mNoItem;

        public Category.Builder withCId(Long cId) {
            mCId = cId;
            return this;
        }

        public Category.Builder withCName(String cName) {
            mCName = cName;
            return this;
        }

        public Category.Builder withNoItem(Long noItem) {
            mNoItem = noItem;
            return this;
        }

        public Category build() {
            Category category = new Category();
            category.mCId = mCId;
            category.mCName = mCName;
            category.mNoItem = mNoItem;
            return category;
        }

    }

}
