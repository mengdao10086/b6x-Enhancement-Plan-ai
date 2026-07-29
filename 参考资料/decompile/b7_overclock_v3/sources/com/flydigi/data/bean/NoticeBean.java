package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.data.DataConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class NoticeBean implements Parcelable {
    public static final Parcelable.Creator<NoticeBean> CREATOR = new Parcelable.Creator<NoticeBean>() { // from class: com.flydigi.data.bean.NoticeBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeBean createFromParcel(Parcel in2) {
            return new NoticeBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoticeBean[] newArray(int size) {
            return new NoticeBean[size];
        }
    };
    private String deviceCode;

    @SerializedName("dialog")
    private List<DialogBean> dialog;

    /* JADX INFO: renamed from: top, reason: collision with root package name */
    @SerializedName("top")
    private List<TopBean> f14335top;

    @SerializedName("updateTime")
    private int updateTime;

    public static class ButtonBean implements Parcelable {
        public static final Parcelable.Creator<ButtonBean> CREATOR = new Parcelable.Creator<ButtonBean>() { // from class: com.flydigi.data.bean.NoticeBean.ButtonBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ButtonBean createFromParcel(Parcel source) {
                return new ButtonBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ButtonBean[] newArray(int size) {
                return new ButtonBean[size];
            }
        };

        @SerializedName("link")
        private String link;

        @SerializedName(DataConstant.COMMUNITY_MESSAGE_ID)
        private int messageId;

        @SerializedName("text")
        private String text;

        @SerializedName("type")
        private String type;

        public ButtonBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getLink() {
            return this.link;
        }

        public int getMessageId() {
            return this.messageId;
        }

        public String getText() {
            return this.text;
        }

        public String getType() {
            return this.type;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.text);
            dest.writeString(this.link);
            dest.writeString(this.type);
            dest.writeInt(this.messageId);
        }

        public ButtonBean(Parcel in2) {
            this.text = in2.readString();
            this.link = in2.readString();
            this.type = in2.readString();
            this.messageId = in2.readInt();
        }
    }

    public static class TopBean implements Parcelable {
        public static final Parcelable.Creator<TopBean> CREATOR = new Parcelable.Creator<TopBean>() { // from class: com.flydigi.data.bean.NoticeBean.TopBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TopBean createFromParcel(Parcel source) {
                return new TopBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TopBean[] newArray(int size) {
                return new TopBean[size];
            }
        };

        @SerializedName("button")
        private List<ButtonBean> button;

        @SerializedName("content")
        private String content;

        @SerializedName("cycle")
        private int cycle;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f14337id;
        private long lastShowTime;

        @SerializedName("message_type")
        private String messageType;

        @SerializedName("title")
        private String title;

        public TopBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public List<ButtonBean> getButton() {
            return this.button;
        }

        public String getContent() {
            return this.content;
        }

        public int getCycle() {
            return this.cycle;
        }

        public int getId() {
            return this.f14337id;
        }

        public long getLastShowTime() {
            return this.lastShowTime;
        }

        public String getMessageType() {
            return this.messageType;
        }

        public String getTitle() {
            return this.title;
        }

        public void setButton(List<ButtonBean> button) {
            this.button = button;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCycle(int cycle) {
            this.cycle = cycle;
        }

        public void setId(int id2) {
            this.f14337id = id2;
        }

        public void setLastShowTime(long lastShowTime) {
            this.lastShowTime = lastShowTime;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String toString() {
            return "TopBean{id=" + this.f14337id + ", title='" + this.title + "', content='" + this.content + "', messageType='" + this.messageType + "', cycle=" + this.cycle + ", button=" + this.button + ", lastShowTime=" + this.lastShowTime + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f14337id);
            dest.writeString(this.title);
            dest.writeString(this.content);
            dest.writeString(this.messageType);
            dest.writeInt(this.cycle);
            dest.writeList(this.button);
            dest.writeLong(this.lastShowTime);
        }

        public TopBean(Parcel in2) {
            this.f14337id = in2.readInt();
            this.title = in2.readString();
            this.content = in2.readString();
            this.messageType = in2.readString();
            this.cycle = in2.readInt();
            ArrayList arrayList = new ArrayList();
            this.button = arrayList;
            in2.readList(arrayList, ButtonBean.class.getClassLoader());
            this.lastShowTime = in2.readLong();
        }
    }

    public NoticeBean(Parcel in2) {
        this.f14335top = new ArrayList();
        this.dialog = new ArrayList();
        this.updateTime = in2.readInt();
        this.f14335top = in2.createTypedArrayList(TopBean.CREATOR);
        this.dialog = in2.createTypedArrayList(DialogBean.CREATOR);
        this.deviceCode = in2.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public List<DialogBean> getDialog() {
        return this.dialog;
    }

    public List<TopBean> getTop() {
        return this.f14335top;
    }

    public int getUpdateTime() {
        return this.updateTime;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public void setDialog(List<DialogBean> dialog) {
        this.dialog = dialog;
    }

    public void setTop(List<TopBean> top2) {
        this.f14335top = top2;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "NoticeBean{updateTime=" + this.updateTime + ", top=" + this.f14335top + ", dialog=" + this.dialog + ", deviceCode='" + this.deviceCode + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.updateTime);
        dest.writeTypedList(this.f14335top);
        dest.writeTypedList(this.dialog);
        dest.writeString(this.deviceCode);
    }

    public NoticeBean() {
        this.f14335top = new ArrayList();
        this.dialog = new ArrayList();
    }

    public static class DialogBean implements Parcelable {
        public static final Parcelable.Creator<DialogBean> CREATOR = new Parcelable.Creator<DialogBean>() { // from class: com.flydigi.data.bean.NoticeBean.DialogBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DialogBean createFromParcel(Parcel in2) {
                return new DialogBean(in2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DialogBean[] newArray(int size) {
                return new DialogBean[size];
            }
        };

        @SerializedName("button")
        private List<ButtonBean> button;

        @SerializedName("content")
        private String content;

        @SerializedName("cycle")
        private int cycle;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f14336id;

        @SerializedName("image")
        private String image;
        private long lastShowTime;

        @SerializedName("message_type")
        private String messageType;

        @SerializedName("title")
        private String title;

        public DialogBean(Parcel in2) {
            this.f14336id = in2.readInt();
            this.title = in2.readString();
            this.content = in2.readString();
            this.image = in2.readString();
            this.messageType = in2.readString();
            this.cycle = in2.readInt();
            this.button = in2.createTypedArrayList(ButtonBean.CREATOR);
            this.lastShowTime = in2.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public List<ButtonBean> getButton() {
            return this.button;
        }

        public String getContent() {
            return this.content;
        }

        public int getCycle() {
            return this.cycle;
        }

        public int getId() {
            return this.f14336id;
        }

        public String getImage() {
            return this.image;
        }

        public long getLastShowTime() {
            return this.lastShowTime;
        }

        public String getMessageType() {
            return this.messageType;
        }

        public String getTitle() {
            return this.title;
        }

        public void setButton(List<ButtonBean> button) {
            this.button = button;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCycle(int cycle) {
            this.cycle = cycle;
        }

        public void setId(int id2) {
            this.f14336id = id2;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setLastShowTime(long lastShowTime) {
            this.lastShowTime = lastShowTime;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f14336id);
            dest.writeString(this.title);
            dest.writeString(this.content);
            dest.writeString(this.image);
            dest.writeString(this.messageType);
            dest.writeInt(this.cycle);
            dest.writeTypedList(this.button);
            dest.writeLong(this.lastShowTime);
        }

        public DialogBean() {
        }
    }
}
