package com.kelinlang.test;

import com.google.gson.JsonArray;

/**
 * @author dengjun
 *         实现的主要功能。
 * @CreateDate 2017/7/5 0005
 */

public class FlowParamSync {
    private String upLimitMaxValue;
    private String downLimitMaxValue;
    private String reportFrequency;
    private String reportBatchSize;
    private String remainingThreshold;
    private JsonArray userTrafficCls;

    public String getUpLimitMaxValue() {
        return upLimitMaxValue;
    }

    public void setUpLimitMaxValue(String upLimitMaxValue) {
        this.upLimitMaxValue = upLimitMaxValue;
    }

    public String getDownLimitMaxValue() {
        return downLimitMaxValue;
    }

    public void setDownLimitMaxValue(String downLimitMaxValue) {
        this.downLimitMaxValue = downLimitMaxValue;
    }

    public String getReportFrequency() {
        return reportFrequency;
    }

    public void setReportFrequency(String reportFrequency) {
        this.reportFrequency = reportFrequency;
    }

    public String getReportBatchSize() {
        return reportBatchSize;
    }

    public void setReportBatchSize(String reportBatchSize) {
        this.reportBatchSize = reportBatchSize;
    }

    public String getRemainingThreshold() {
        return remainingThreshold;
    }

    public void setRemainingThreshold(String remainingThreshold) {
        this.remainingThreshold = remainingThreshold;
    }

    public JsonArray getUserTrafficCls() {
        return userTrafficCls;
    }

    public void setUserTrafficCls(JsonArray userTrafficCls) {
        this.userTrafficCls = userTrafficCls;
    }
}
