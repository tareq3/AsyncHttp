
package com.example.rakib.asynchttp.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CategoryResponse {

    @SerializedName("category")
    private List<Category> mCategory;
    @SerializedName("error")
    private Boolean mError;

    public List<Category> getCategory() {
        return mCategory;
    }

    public Boolean getError() {
        return mError;
    }

    public static class Builder {

        private List<Category> mCategory;
        private Boolean mError;

        public CategoryResponse.Builder withCategory(List<Category> category) {
            mCategory = category;
            return this;
        }

        public CategoryResponse.Builder withError(Boolean error) {
            mError = error;
            return this;
        }

        public CategoryResponse build() {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.mCategory = mCategory;
            categoryResponse.mError = mError;
            return categoryResponse;
        }

    }

}
