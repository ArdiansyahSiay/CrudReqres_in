
package com.example.jsongetsinggeluser.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    List<Data> dataList;

    List<Support> supportList;

    public List<Support> getSupportList() {
        return supportList;
    }

    public void setSupportList(List<Support> supportList) {
        this.supportList = supportList;
    }


    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("support")
    @Expose
    private Support support;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
