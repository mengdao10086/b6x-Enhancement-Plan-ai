package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MyMessageBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<MyMessageBean> CREATOR = new Parcelable.Creator<MyMessageBean>() { // from class: com.flydigi.data.bean.MyMessageBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyMessageBean createFromParcel(Parcel in2) {
            return new MyMessageBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MyMessageBean[] newArray(int size) {
            return new MyMessageBean[size];
        }
    };

    @SerializedName("list")
    private List<Message> list;

    @SerializedName("page")
    private int page;

    @SerializedName("total")
    private int total;

    public MyMessageBean(Parcel in2) {
        this.total = in2.readInt();
        this.page = in2.readInt();
        this.list = in2.createTypedArrayList(Message.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Message> getList() {
        return this.list;
    }

    public int getPage() {
        return this.page;
    }

    public int getTotal() {
        return this.total;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String toString() {
        return "CommunityMyMessageBean{total=" + this.total + ", page=" + this.page + ", list=" + this.list + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeInt(this.page);
        dest.writeTypedList(this.list);
    }

    public MyMessageBean() {
    }

    public static class Message implements Parcelable, Serializable {
        public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() { // from class: com.flydigi.data.bean.MyMessageBean.Message.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Message createFromParcel(Parcel in2) {
                return new Message(in2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Message[] newArray(int size) {
                return new Message[size];
            }
        };

        @SerializedName(CommentListFragment.O8)
        private int articleType;

        @SerializedName("author")
        private String author;

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("comment_id")
        private int commentId;

        @SerializedName("floor")
        private int floor;

        @SerializedName("from_adminid")
        private String fromAdminId;

        @SerializedName("from_uid")
        private String fromUid;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private int f14334id;

        @SerializedName("info_id")
        private int infoId;

        @SerializedName("isread")
        private int isRead;

        @SerializedName("message")
        private String message;

        @SerializedName("text")
        private String text;

        @SerializedName("time")
        private String time;

        @SerializedName("time_text")
        private String timeText;

        @SerializedName("type")
        private String type;

        public Message(Parcel in2) {
            this.f14334id = in2.readInt();
            this.fromUid = in2.readString();
            this.fromAdminId = in2.readString();
            this.message = in2.readString();
            this.time = in2.readString();
            this.infoId = in2.readInt();
            this.type = in2.readString();
            this.floor = in2.readInt();
            this.articleType = in2.readInt();
            this.isRead = in2.readInt();
            this.commentId = in2.readInt();
            this.timeText = in2.readString();
            this.avatar = in2.readString();
            this.author = in2.readString();
            this.text = in2.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getArticleType() {
            return this.articleType;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public int getCommentId() {
            return this.commentId;
        }

        public int getFloor() {
            return this.floor;
        }

        public String getFromAdminId() {
            return this.fromAdminId;
        }

        public String getFromUid() {
            return this.fromUid;
        }

        public int getId() {
            return this.f14334id;
        }

        public int getInfoId() {
            return this.infoId;
        }

        public int getIsRead() {
            return this.isRead;
        }

        public String getMessage() {
            return this.message;
        }

        public String getText() {
            return this.text;
        }

        public String getTime() {
            return this.time;
        }

        public String getTimeText() {
            return this.timeText;
        }

        public String getType() {
            return this.type;
        }

        public void setArticleType(int articleType) {
            this.articleType = articleType;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public void setFromAdminId(String fromAdminId) {
            this.fromAdminId = fromAdminId;
        }

        public void setFromUid(String fromUid) {
            this.fromUid = fromUid;
        }

        public void setId(int id2) {
            this.f14334id = id2;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public void setIsRead(int isRead) {
            this.isRead = isRead;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setTimeText(String timeText) {
            this.timeText = timeText;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String toString() {
            return "Message{id='" + this.f14334id + "', fromUid='" + this.fromUid + "', fromAdminId='" + this.fromAdminId + "', message='" + this.message + "', time='" + this.time + "', infoId='" + this.infoId + "', type='" + this.type + "', floor=" + this.floor + ", articleType=" + this.articleType + ", isRead=" + this.isRead + ", commentId='" + this.commentId + "', timeText='" + this.timeText + "', avatar='" + this.avatar + "', author='" + this.author + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f14334id);
            dest.writeString(this.fromUid);
            dest.writeString(this.fromAdminId);
            dest.writeString(this.message);
            dest.writeString(this.time);
            dest.writeInt(this.infoId);
            dest.writeString(this.type);
            dest.writeInt(this.floor);
            dest.writeInt(this.articleType);
            dest.writeInt(this.isRead);
            dest.writeInt(this.commentId);
            dest.writeString(this.timeText);
            dest.writeString(this.avatar);
            dest.writeString(this.author);
            dest.writeString(this.text);
        }

        public Message() {
        }
    }
}
