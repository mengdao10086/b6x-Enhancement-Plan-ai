package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceDetailBean implements Parcelable {
    public static final Parcelable.Creator<DeviceDetailBean> CREATOR = new Parcelable.Creator<DeviceDetailBean>() { // from class: com.flydigi.data.bean.DeviceDetailBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceDetailBean createFromParcel(Parcel source) {
            return new DeviceDetailBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceDetailBean[] newArray(int size) {
            return new DeviceDetailBean[size];
        }
    };

    @SerializedName("device_name")
    private String deviceName;

    @SerializedName(an.f23207ai)
    private String deviceType;

    @SerializedName("help")
    private HelpBean help;

    @SerializedName("list_pic")
    private String listPic;

    @SerializedName("qa_list")
    private List<QaListBean> qaList;

    @SerializedName("qa_title")
    private String qaTitle;

    @SerializedName("slogan")
    private String slogan;

    @SerializedName("type")
    private int type;
    private long version;

    public static class HelpBean implements Parcelable {
        public static final Parcelable.Creator<HelpBean> CREATOR = new Parcelable.Creator<HelpBean>() { // from class: com.flydigi.data.bean.DeviceDetailBean.HelpBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HelpBean createFromParcel(Parcel source) {
                return new HelpBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HelpBean[] newArray(int size) {
                return new HelpBean[size];
            }
        };

        @SerializedName("more_text")
        private String actionText;

        @SerializedName("data")
        private String data;

        @SerializedName("goods_id")
        private int goodId;

        @SerializedName("pic")
        private String pic;

        @SerializedName("title")
        private String title;

        @SerializedName("type")
        private int urlType;

        public HelpBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getActionText() {
            return this.actionText;
        }

        public String getData() {
            return this.data;
        }

        public int getGoodId() {
            return this.goodId;
        }

        public String getPic() {
            return this.pic;
        }

        public String getTitle() {
            return this.title;
        }

        public int getUrlType() {
            return this.urlType;
        }

        public String toString() {
            return "HelpBean{goodId=" + this.goodId + ", title='" + this.title + "', pic='" + this.pic + "', url='" + this.data + "', actionText='" + this.actionText + "', urlType=" + this.urlType + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.goodId);
            dest.writeString(this.title);
            dest.writeString(this.pic);
            dest.writeString(this.data);
            dest.writeString(this.actionText);
            dest.writeInt(this.urlType);
        }

        public HelpBean(Parcel in2) {
            this.goodId = in2.readInt();
            this.title = in2.readString();
            this.pic = in2.readString();
            this.data = in2.readString();
            this.actionText = in2.readString();
            this.urlType = in2.readInt();
        }
    }

    public static class QaListBean {
        public static final int TYPE_ARTICLE = 1;
        public static final int TYPE_WEBSITE = 2;

        @SerializedName("data")
        private String data;

        @SerializedName("type")
        private int dataType;

        @SerializedName("name")
        private String name;

        @SerializedName("pic")
        private String pic;

        public String getData() {
            return this.data;
        }

        public int getDataType() {
            return this.dataType;
        }

        public String getName() {
            return this.name;
        }

        public String getPic() {
            return this.pic;
        }

        public String toString() {
            return "QaListBean{name='" + this.name + "', data='" + this.data + "', pic='" + this.pic + "', dataType=" + this.dataType + '}';
        }
    }

    public DeviceDetailBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public HelpBean getHelp() {
        return this.help;
    }

    public String getListPic() {
        return this.listPic;
    }

    public List<QaListBean> getQaList() {
        return this.qaList;
    }

    public String getQaTitle() {
        return this.qaTitle;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public int getType() {
        return this.type;
    }

    public long getVersion() {
        return this.version;
    }

    public String toString() {
        return "DeviceDetailBean{version=" + this.version + ", deviceName='" + this.deviceName + "', deviceType='" + this.deviceType + "', listPic='" + this.listPic + "', slogan='" + this.slogan + "', type=" + this.type + ", qaList=" + this.qaList + ", qaTitle='" + this.qaTitle + "', help=" + this.help + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.version);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceType);
        dest.writeString(this.listPic);
        dest.writeString(this.slogan);
        dest.writeInt(this.type);
        dest.writeList(this.qaList);
        dest.writeString(this.qaTitle);
        dest.writeParcelable(this.help, flags);
    }

    public DeviceDetailBean(Parcel in2) {
        this.version = in2.readLong();
        this.deviceName = in2.readString();
        this.deviceType = in2.readString();
        this.listPic = in2.readString();
        this.slogan = in2.readString();
        this.type = in2.readInt();
        ArrayList arrayList = new ArrayList();
        this.qaList = arrayList;
        in2.readList(arrayList, QaListBean.class.getClassLoader());
        this.qaTitle = in2.readString();
        this.help = (HelpBean) in2.readParcelable(HelpBean.class.getClassLoader());
    }
}
