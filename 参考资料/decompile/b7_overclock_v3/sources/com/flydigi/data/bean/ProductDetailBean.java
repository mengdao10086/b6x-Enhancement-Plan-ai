package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ProductDetailBean {

    @SerializedName("allow_buy")
    private int allowBuy;

    @SerializedName("count_link")
    private String countLink;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f14338id;

    @SerializedName("img_id")
    private int imgId;

    @SerializedName("imgs")
    private List<ImgsBean> imgs;

    @SerializedName("list_img_url")
    private String listImgUrl;

    @SerializedName("main_img_url")
    private String mainImgUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    @SerializedName("sold_num")
    private int soldNum;

    @SerializedName("stock")
    private int stock;

    @SerializedName("tb_link")
    private String tbLink;

    public static class ImgsBean {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f14339id;

        @SerializedName("img_url")
        private ImgUrlBean imgUrl;

        @SerializedName("order")
        private int order;

        @SerializedName("url")
        private String url;

        public static class ImgUrlBean {

            @SerializedName("update_time")
            private String updateTime;

            @SerializedName("url")
            private String url;

            public String getUpdateTime() {
                return this.updateTime;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public int getId() {
            return this.f14339id;
        }

        public ImgUrlBean getImgUrl() {
            return this.imgUrl;
        }

        public int getOrder() {
            return this.order;
        }

        public String getUrl() {
            return this.url;
        }

        public void setId(int id2) {
            this.f14339id = id2;
        }

        public void setImgUrl(ImgUrlBean imgUrl) {
            this.imgUrl = imgUrl;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public int getAllowBuy() {
        return this.allowBuy;
    }

    public String getCountLink() {
        return this.countLink;
    }

    public int getId() {
        return this.f14338id;
    }

    public int getImgId() {
        return this.imgId;
    }

    public List<ImgsBean> getImgs() {
        return this.imgs;
    }

    public String getListImgUrl() {
        return this.listImgUrl;
    }

    public String getMainImgUrl() {
        return this.mainImgUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public int getSoldNum() {
        return this.soldNum;
    }

    public int getStock() {
        return this.stock;
    }

    public String getTbLink() {
        return this.tbLink;
    }

    public void setAllowBuy(int allowBuy) {
        this.allowBuy = allowBuy;
    }

    public void setCountLink(String countLink) {
        this.countLink = countLink;
    }

    public void setId(int id2) {
        this.f14338id = id2;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public void setListImgUrl(String listImgUrl) {
        this.listImgUrl = listImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSoldNum(int soldNum) {
        this.soldNum = soldNum;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTbLink(String tbLink) {
        this.tbLink = tbLink;
    }
}
