package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MallProductBean implements Parcelable {
    public static final Parcelable.Creator<MallProductBean> CREATOR = new Parcelable.Creator<MallProductBean>() { // from class: com.flydigi.data.bean.MallProductBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MallProductBean createFromParcel(Parcel source) {
            return new MallProductBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MallProductBean[] newArray(int size) {
            return new MallProductBean[size];
        }
    };

    @SerializedName("current_page")
    private int currentPage;

    @SerializedName("data")
    private List<DataBean> data;

    public static class DataBean implements Parcelable {
        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() { // from class: com.flydigi.data.bean.MallProductBean.DataBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        @SerializedName("allow_buy")
        private int allowBuy;

        @SerializedName("count_link")
        private String countLink;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f14332id;

        @SerializedName("img_id")
        private int imgId;

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

        public DataBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getAllowBuy() {
            return this.allowBuy;
        }

        public String getCountLink() {
            return this.countLink;
        }

        public int getId() {
            return this.f14332id;
        }

        public int getImgId() {
            return this.imgId;
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
            this.f14332id = id2;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
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

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f14332id);
            dest.writeString(this.name);
            dest.writeString(this.countLink);
            dest.writeString(this.price);
            dest.writeInt(this.stock);
            dest.writeString(this.mainImgUrl);
            dest.writeInt(this.imgId);
            dest.writeInt(this.soldNum);
            dest.writeString(this.listImgUrl);
            dest.writeInt(this.allowBuy);
            dest.writeString(this.tbLink);
        }

        public DataBean(Parcel in2) {
            this.f14332id = in2.readInt();
            this.name = in2.readString();
            this.countLink = in2.readString();
            this.price = in2.readString();
            this.stock = in2.readInt();
            this.mainImgUrl = in2.readString();
            this.imgId = in2.readInt();
            this.soldNum = in2.readInt();
            this.listImgUrl = in2.readString();
            this.allowBuy = in2.readInt();
            this.tbLink = in2.readString();
        }
    }

    public MallProductBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.currentPage);
        dest.writeTypedList(this.data);
    }

    public MallProductBean(Parcel in2) {
        this.currentPage = in2.readInt();
        this.data = in2.createTypedArrayList(DataBean.CREATOR);
    }
}
