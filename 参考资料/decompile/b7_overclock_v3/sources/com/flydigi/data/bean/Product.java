package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class Product {

    @SerializedName("coupon_content")
    private String couponContent;

    @SerializedName("coupon_link")
    private String couponLink;

    public String getCouponContent() {
        return this.couponContent;
    }

    public String getCouponLink() {
        return this.couponLink;
    }
}
