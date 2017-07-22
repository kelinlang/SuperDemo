package com.kelinlang.test;

import com.google.gson.JsonArray;

/**
 * @author dengjun
 *         实现的主要功能。
 * @CreateDate 2017/7/5 0005
 */

public class PackagesFlowReportInfo {
    private JsonArray reports;
    private String createTime;


    public JsonArray getReports() {
        return reports;
    }

    public void setReports(JsonArray reports) {
        this.reports = reports;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
