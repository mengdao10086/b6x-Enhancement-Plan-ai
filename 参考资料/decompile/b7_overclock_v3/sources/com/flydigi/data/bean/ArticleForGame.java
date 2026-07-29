package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ArticleForGame {

    @SerializedName("archives")
    private ArchivesBean archives;

    @SerializedName(CommentListFragment.M8)
    private int articleId;

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("model_control")
    private GameControlBean gameControlBean;

    @SerializedName("is_have_button")
    private int isHaveButton;

    @SerializedName("jump_data")
    private String jumpData;

    @SerializedName("jump_type")
    private int jumpType;

    @SerializedName("pkgname")
    private String pkgname;

    public static class ArchivesBean implements Parcelable {
        public static final Parcelable.Creator<ArchivesBean> CREATOR = new Parcelable.Creator<ArchivesBean>() { // from class: com.flydigi.data.bean.ArticleForGame.ArchivesBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ArchivesBean createFromParcel(Parcel source) {
                return new ArchivesBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ArchivesBean[] newArray(int size) {
                return new ArchivesBean[size];
            }
        };

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private String f14322id;

        @SerializedName("title")
        private String title;

        @SerializedName("type")
        private int type;

        public ArchivesBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getId() {
            return this.f14322id;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public void setId(String id2) {
            this.f14322id = id2;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String toString() {
            return "ArchivesBean{id='" + this.f14322id + "', title='" + this.title + "', type=" + this.type + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.f14322id);
            dest.writeString(this.title);
            dest.writeInt(this.type);
        }

        public ArchivesBean(Parcel in2) {
            this.f14322id = in2.readString();
            this.title = in2.readString();
            this.type = in2.readInt();
        }
    }

    public static class GameControlBean implements Parcelable {
        public static final Parcelable.Creator<GameControlBean> CREATOR = new Parcelable.Creator<GameControlBean>() { // from class: com.flydigi.data.bean.ArticleForGame.GameControlBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GameControlBean createFromParcel(Parcel source) {
                return new GameControlBean(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GameControlBean[] newArray(int size) {
                return new GameControlBean[size];
            }
        };

        @SerializedName("box_content")
        private String noticeContent;

        @SerializedName("box_title")
        private String noticeTitle;

        @SerializedName("pkgname")
        private String packageName;

        @SerializedName("state")
        private int state;

        @SerializedName("title")
        private String title;

        public GameControlBean() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getNoticeContent() {
            return this.noticeContent;
        }

        public String getNoticeTitle() {
            return this.noticeTitle;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int getState() {
            return this.state;
        }

        public String getTitle() {
            return this.title;
        }

        public String toString() {
            return "GameControlBean{title='" + this.title + "', packageName='" + this.packageName + "', state=" + this.state + ", noticeTitle='" + this.noticeTitle + "', noticeContent='" + this.noticeContent + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.packageName);
            dest.writeInt(this.state);
            dest.writeString(this.noticeTitle);
            dest.writeString(this.noticeContent);
        }

        public GameControlBean(Parcel in2) {
            this.title = in2.readString();
            this.packageName = in2.readString();
            this.state = in2.readInt();
            this.noticeTitle = in2.readString();
            this.noticeContent = in2.readString();
        }
    }

    public ArchivesBean getArchives() {
        return this.archives;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public GameControlBean getGameControlBean() {
        return this.gameControlBean;
    }

    public int getIsHaveButton() {
        return this.isHaveButton;
    }

    public String getJumpData() {
        return this.jumpData;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getPkgname() {
        return this.pkgname;
    }

    public void setArchives(ArchivesBean archives) {
        this.archives = archives;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setGameControlBean(GameControlBean gameControlBean) {
        this.gameControlBean = gameControlBean;
    }

    public void setIsHaveButton(int isHaveButton) {
        this.isHaveButton = isHaveButton;
    }

    public void setJumpData(String jumpData) {
        this.jumpData = jumpData;
    }

    public void setJumpType(int jumpType) {
        this.jumpType = jumpType;
    }

    public void setPkgname(String pkgname) {
        this.pkgname = pkgname;
    }

    public String toString() {
        return "ArticleForGame{articleId=" + this.articleId + ", pkgname='" + this.pkgname + "', isHaveButton=" + this.isHaveButton + ", buttonText='" + this.buttonText + "', jumpType=" + this.jumpType + ", jumpData='" + this.jumpData + "', archives=" + this.archives + ", gameControlBean=" + this.gameControlBean + '}';
    }
}
