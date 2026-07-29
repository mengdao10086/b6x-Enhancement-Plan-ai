package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.google.gson.annotations.SerializedName;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import db.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RecommendConfigBean implements Parcelable {
    public static final Parcelable.Creator<RecommendConfigBean> CREATOR = new Parcelable.Creator<RecommendConfigBean>() { // from class: com.flydigi.data.bean.RecommendConfigBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendConfigBean createFromParcel(Parcel source) {
            return new RecommendConfigBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendConfigBean[] newArray(int size) {
            return new RecommendConfigBean[size];
        }
    };

    @SerializedName("gamepad_list")
    private List<RecommendConfig> gamepadList;

    @SerializedName("keyboard_mouse_list")
    private List<RecommendConfig> keyboardMouseList;

    @SerializedName("v1_list")
    private List<RecommendConfig> v1List;

    @SerializedName(d.f26139i)
    private long version;

    public RecommendConfigBean() {
        this.gamepadList = new ArrayList();
        this.v1List = new ArrayList();
        this.keyboardMouseList = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RecommendConfig> getGamepadList() {
        return this.gamepadList;
    }

    public List<RecommendConfig> getKeyboardMouseList() {
        return this.keyboardMouseList;
    }

    public List<RecommendConfig> getV1List() {
        return this.v1List;
    }

    public long getVersion() {
        return this.version;
    }

    public void setGamepadList(List<RecommendConfig> gamepadList) {
        this.gamepadList = gamepadList;
    }

    public void setKeyboardMouseList(List<RecommendConfig> keyboardMouseList) {
        this.keyboardMouseList = keyboardMouseList;
    }

    public void setV1List(List<RecommendConfig> v1List) {
        this.v1List = v1List;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String toString() {
        return "RecommendConfigBean{gamepadList=" + this.gamepadList.size() + ", v1List=" + this.v1List.size() + ", keyboardMouseList=" + this.keyboardMouseList.size() + ", version=" + this.version + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.gamepadList);
        dest.writeTypedList(this.v1List);
        dest.writeTypedList(this.keyboardMouseList);
        dest.writeLong(this.version);
    }

    public RecommendConfigBean(Parcel in2) {
        this.gamepadList = new ArrayList();
        this.v1List = new ArrayList();
        this.keyboardMouseList = new ArrayList();
        Parcelable.Creator<RecommendConfig> creator = RecommendConfig.CREATOR;
        this.gamepadList = in2.createTypedArrayList(creator);
        this.v1List = in2.createTypedArrayList(creator);
        this.keyboardMouseList = in2.createTypedArrayList(creator);
        this.version = in2.readLong();
    }

    public static class RecommendConfig implements Parcelable {
        public static final Parcelable.Creator<RecommendConfig> CREATOR = new Parcelable.Creator<RecommendConfig>() { // from class: com.flydigi.data.bean.RecommendConfigBean.RecommendConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecommendConfig createFromParcel(Parcel in2) {
                return new RecommendConfig(in2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecommendConfig[] newArray(int size) {
                return new RecommendConfig[size];
            }
        };
        public static final int TYPE_ARTICLE = 1;
        public static final int TYPE_CONFIG = 0;

        @SerializedName(CommentListFragment.M8)
        private int articleId;

        @SerializedName(CommentListFragment.O8)
        private int articleType;

        @SerializedName("cfg_url")
        private String configUrl;

        @SerializedName("desc_url")
        private String contentUrl;
        private String desc;

        @SerializedName(an.f23207ai)
        private String deviceType;

        @SerializedName("image_url")
        private String imageUrl;

        @SerializedName("likes_num")
        private int likesNum;

        @SerializedName(androidx.constraintlayout.widget.d.U1)
        private String ratio;

        @SerializedName(CommonNetImpl.TAG)
        private String tag;
        private String title;
        private int type;

        public RecommendConfig(Parcel in2) {
            this.type = in2.readInt();
            this.title = in2.readString();
            this.desc = in2.readString();
            this.articleId = in2.readInt();
            this.articleType = in2.readInt();
            this.contentUrl = in2.readString();
            this.configUrl = in2.readString();
            this.imageUrl = in2.readString();
            this.tag = in2.readString();
            this.likesNum = in2.readInt();
            this.ratio = in2.readString();
            this.deviceType = in2.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getArticleId() {
            return this.articleId;
        }

        public int getArticleType() {
            return this.articleType;
        }

        public String getConfigUrl() {
            return this.configUrl;
        }

        public String getContentUrl() {
            return this.contentUrl;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDeviceType() {
            return this.deviceType;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public int getLikesNum() {
            return this.likesNum;
        }

        public String getRatio() {
            return this.ratio;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public void setArticleType(int articleType) {
            this.articleType = articleType;
        }

        public void setConfigUrl(String configUrl) {
            this.configUrl = configUrl;
        }

        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public void setLikesNum(int likesNum) {
            this.likesNum = likesNum;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String toString() {
            return "RecommendConfig{type=" + this.type + ", title='" + this.title + "', articleId=" + this.articleId + "', configUrl=" + this.configUrl + "', deviceType=" + this.deviceType + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.type);
            dest.writeString(this.title);
            dest.writeString(this.desc);
            dest.writeInt(this.articleId);
            dest.writeInt(this.articleType);
            dest.writeString(this.contentUrl);
            dest.writeString(this.configUrl);
            dest.writeString(this.imageUrl);
            dest.writeString(this.tag);
            dest.writeInt(this.likesNum);
            dest.writeString(this.ratio);
            dest.writeString(this.deviceType);
        }

        public RecommendConfig() {
        }
    }
}
