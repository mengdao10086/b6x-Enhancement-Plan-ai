package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.flydigi.data.bean.CfgInfoBean;
import com.flydigi.data.bean.ContentAddBean;
import com.flydigi.data.bean.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class ArticleBean implements Parcelable {
    public static final int COMMENT_TYPE_AUDIT = 1;
    public static final int COMMENT_TYPE_CLOSE = 0;
    public static final int COMMENT_TYPE_OPEN = 2;

    @k
    public static final String STATE_IN_AUDIT = "hidden";

    @k
    public static final String STATE_PUBLISHED = "normal";

    @k
    public static final String STATE_REJECT = "fail";
    public static final int TYPE_OFFICIAL = 0;
    public static final int TYPE_OFFICIAL_CONFIG = 3;
    public static final int TYPE_USER = 1;
    public static final int TYPE_USER_CONFIG = 2;

    @SerializedName("author")
    @l
    private final String author;

    @SerializedName(CommentListFragment.N8)
    private final int authorId;

    @SerializedName("avatar")
    @l
    private final String avatar;

    @SerializedName("cfg_id")
    private final int cfgId;

    @SerializedName("cfg_info")
    @l
    private final CfgInfoBean cfgInfo;

    @SerializedName("comments")
    private final int comments;

    @SerializedName("content")
    @l
    private final String content;

    @SerializedName("createtime")
    private final long createTime;

    @SerializedName("description")
    @l
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14343id;

    @SerializedName("image")
    @l
    private final List<ContentAddBean> image;

    @SerializedName("is_comment")
    private int isComment;

    @SerializedName("is_like")
    private int isLike;

    @SerializedName("is_top")
    private final int isTop;

    @SerializedName("likes")
    private int likes;

    @SerializedName("reason")
    @l
    private final ReasonBean reason;

    @SerializedName("share_num")
    private int shareCount;

    @SerializedName("status")
    @l
    private String status;

    @SerializedName("title")
    @l
    private final String title;

    @SerializedName("topics")
    @l
    private final List<ArticleTopic> topics;

    @SerializedName("type")
    private final int type;

    @SerializedName("uid")
    private final int uid;

    @SerializedName("updatetime")
    private final long updateTime;

    @SerializedName("user_info")
    @l
    private final UserInfo userInfo;

    @SerializedName("video_file")
    @l
    private final String videoFile;

    @SerializedName("video_img")
    @l
    private final String videoImg;

    @SerializedName("video_index_id")
    private final int videoIndex;

    @SerializedName("views")
    @k
    private final String views;

    @k
    public static final Companion Companion = new Companion(null);

    @k
    public static final Parcelable.Creator<ArticleBean> CREATOR = new Creator();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public static final class Creator implements Parcelable.Creator<ArticleBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleBean createFromParcel(@k Parcel parcel) {
            ArrayList arrayList;
            int i10;
            ArrayList arrayList2;
            f0.p(parcel, "parcel");
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i14 = parcel.readInt();
                arrayList = new ArrayList(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    arrayList.add(ArticleTopic.CREATOR.createFromParcel(parcel));
                }
            }
            String string4 = parcel.readString();
            int i16 = parcel.readInt();
            int i17 = parcel.readInt();
            int i18 = parcel.readInt();
            int i19 = parcel.readInt();
            int i20 = parcel.readInt();
            String string5 = parcel.readString();
            long j10 = parcel.readLong();
            long j11 = parcel.readLong();
            int i21 = parcel.readInt();
            CfgInfoBean cfgInfoBean = (CfgInfoBean) parcel.readParcelable(ArticleBean.class.getClassLoader());
            if (parcel.readInt() == 0) {
                i10 = i20;
                arrayList2 = null;
            } else {
                int i22 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i22);
                i10 = i20;
                int i23 = 0;
                while (i23 != i22) {
                    arrayList3.add(parcel.readParcelable(ArticleBean.class.getClassLoader()));
                    i23++;
                    i22 = i22;
                }
                arrayList2 = arrayList3;
            }
            return new ArticleBean(i11, i12, i13, string, string2, string3, arrayList, string4, i16, i17, i18, i19, i10, string5, j10, j11, i21, cfgInfoBean, arrayList2, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : UserInfo.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : ReasonBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleBean[] newArray(int i10) {
            return new ArticleBean[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArticleBean(int i10, int i11, int i12, @l String str, @l String str2, @l String str3, @l List<ArticleTopic> list, @k String views, int i13, int i14, int i15, int i16, int i17, @l String str4, long j10, long j11, int i18, @l CfgInfoBean cfgInfoBean, @l List<? extends ContentAddBean> list2, @l String str5, @l String str6, int i19, @l UserInfo userInfo, int i20, int i21, @l String str7, @l String str8, @l ReasonBean reasonBean) {
        f0.p(views, "views");
        this.f14343id = i10;
        this.type = i11;
        this.isTop = i12;
        this.title = str;
        this.description = str2;
        this.content = str3;
        this.topics = list;
        this.views = views;
        this.shareCount = i13;
        this.isComment = i14;
        this.comments = i15;
        this.likes = i16;
        this.isLike = i17;
        this.status = str4;
        this.updateTime = j10;
        this.createTime = j11;
        this.cfgId = i18;
        this.cfgInfo = cfgInfoBean;
        this.image = list2;
        this.videoImg = str5;
        this.videoFile = str6;
        this.videoIndex = i19;
        this.userInfo = userInfo;
        this.authorId = i20;
        this.uid = i21;
        this.author = str7;
        this.avatar = str8;
        this.reason = reasonBean;
    }

    public final int component1() {
        return this.f14343id;
    }

    public final int component10() {
        return this.isComment;
    }

    public final int component11() {
        return this.comments;
    }

    public final int component12() {
        return this.likes;
    }

    public final int component13() {
        return this.isLike;
    }

    @l
    public final String component14() {
        return this.status;
    }

    public final long component15() {
        return this.updateTime;
    }

    public final long component16() {
        return this.createTime;
    }

    public final int component17() {
        return this.cfgId;
    }

    @l
    public final CfgInfoBean component18() {
        return this.cfgInfo;
    }

    @l
    public final List<ContentAddBean> component19() {
        return this.image;
    }

    public final int component2() {
        return this.type;
    }

    @l
    public final String component20() {
        return this.videoImg;
    }

    @l
    public final String component21() {
        return this.videoFile;
    }

    public final int component22() {
        return this.videoIndex;
    }

    @l
    public final UserInfo component23() {
        return this.userInfo;
    }

    public final int component24() {
        return this.authorId;
    }

    public final int component25() {
        return this.uid;
    }

    @l
    public final String component26() {
        return this.author;
    }

    @l
    public final String component27() {
        return this.avatar;
    }

    @l
    public final ReasonBean component28() {
        return this.reason;
    }

    public final int component3() {
        return this.isTop;
    }

    @l
    public final String component4() {
        return this.title;
    }

    @l
    public final String component5() {
        return this.description;
    }

    @l
    public final String component6() {
        return this.content;
    }

    @l
    public final List<ArticleTopic> component7() {
        return this.topics;
    }

    @k
    public final String component8() {
        return this.views;
    }

    public final int component9() {
        return this.shareCount;
    }

    @k
    public final ArticleBean copy(int i10, int i11, int i12, @l String str, @l String str2, @l String str3, @l List<ArticleTopic> list, @k String views, int i13, int i14, int i15, int i16, int i17, @l String str4, long j10, long j11, int i18, @l CfgInfoBean cfgInfoBean, @l List<? extends ContentAddBean> list2, @l String str5, @l String str6, int i19, @l UserInfo userInfo, int i20, int i21, @l String str7, @l String str8, @l ReasonBean reasonBean) {
        f0.p(views, "views");
        return new ArticleBean(i10, i11, i12, str, str2, str3, list, views, i13, i14, i15, i16, i17, str4, j10, j11, i18, cfgInfoBean, list2, str5, str6, i19, userInfo, i20, i21, str7, str8, reasonBean);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleBean)) {
            return false;
        }
        ArticleBean articleBean = (ArticleBean) obj;
        return this.f14343id == articleBean.f14343id && this.type == articleBean.type && this.isTop == articleBean.isTop && f0.g(this.title, articleBean.title) && f0.g(this.description, articleBean.description) && f0.g(this.content, articleBean.content) && f0.g(this.topics, articleBean.topics) && f0.g(this.views, articleBean.views) && this.shareCount == articleBean.shareCount && this.isComment == articleBean.isComment && this.comments == articleBean.comments && this.likes == articleBean.likes && this.isLike == articleBean.isLike && f0.g(this.status, articleBean.status) && this.updateTime == articleBean.updateTime && this.createTime == articleBean.createTime && this.cfgId == articleBean.cfgId && f0.g(this.cfgInfo, articleBean.cfgInfo) && f0.g(this.image, articleBean.image) && f0.g(this.videoImg, articleBean.videoImg) && f0.g(this.videoFile, articleBean.videoFile) && this.videoIndex == articleBean.videoIndex && f0.g(this.userInfo, articleBean.userInfo) && this.authorId == articleBean.authorId && this.uid == articleBean.uid && f0.g(this.author, articleBean.author) && f0.g(this.avatar, articleBean.avatar) && f0.g(this.reason, articleBean.reason);
    }

    @l
    public final String getAuthor() {
        return this.author;
    }

    public final int getAuthorId() {
        return this.authorId;
    }

    @l
    public final String getAvatar() {
        return this.avatar;
    }

    public final int getCfgId() {
        return this.cfgId;
    }

    @l
    public final CfgInfoBean getCfgInfo() {
        return this.cfgInfo;
    }

    public final int getComments() {
        return this.comments;
    }

    @l
    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @l
    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.f14343id;
    }

    @l
    public final List<ContentAddBean> getImage() {
        return this.image;
    }

    public final int getLikes() {
        return this.likes;
    }

    @l
    public final ReasonBean getReason() {
        return this.reason;
    }

    public final int getShareCount() {
        return this.shareCount;
    }

    @l
    public final String getStatus() {
        return this.status;
    }

    @l
    public final String getTitle() {
        return this.title;
    }

    @l
    public final List<ArticleTopic> getTopics() {
        return this.topics;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUid() {
        return this.uid;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @l
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @l
    public final String getVideoFile() {
        return this.videoFile;
    }

    @l
    public final String getVideoImg() {
        return this.videoImg;
    }

    public final int getVideoIndex() {
        return this.videoIndex;
    }

    @k
    public final String getViews() {
        return this.views;
    }

    public int hashCode() {
        int i10 = ((((this.f14343id * 31) + this.type) * 31) + this.isTop) * 31;
        String str = this.title;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.content;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<ArticleTopic> list = this.topics;
        int iHashCode4 = (((((((((((((iHashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.views.hashCode()) * 31) + this.shareCount) * 31) + this.isComment) * 31) + this.comments) * 31) + this.likes) * 31) + this.isLike) * 31;
        String str4 = this.status;
        int iHashCode5 = (((((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + a.a(this.updateTime)) * 31) + a.a(this.createTime)) * 31) + this.cfgId) * 31;
        CfgInfoBean cfgInfoBean = this.cfgInfo;
        int iHashCode6 = (iHashCode5 + (cfgInfoBean == null ? 0 : cfgInfoBean.hashCode())) * 31;
        List<ContentAddBean> list2 = this.image;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str5 = this.videoImg;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.videoFile;
        int iHashCode9 = (((iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.videoIndex) * 31;
        UserInfo userInfo = this.userInfo;
        int iHashCode10 = (((((iHashCode9 + (userInfo == null ? 0 : userInfo.hashCode())) * 31) + this.authorId) * 31) + this.uid) * 31;
        String str7 = this.author;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.avatar;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ReasonBean reasonBean = this.reason;
        return iHashCode12 + (reasonBean != null ? reasonBean.hashCode() : 0);
    }

    public final int isComment() {
        return this.isComment;
    }

    public final int isLike() {
        return this.isLike;
    }

    public final boolean isLiked() {
        return this.isLike == 1;
    }

    public final int isTop() {
        return this.isTop;
    }

    public final void setComment(int i10) {
        this.isComment = i10;
    }

    public final void setLike(int i10) {
        this.isLike = i10;
    }

    public final void setLikes(int i10) {
        this.likes = i10;
    }

    public final void setShareCount(int i10) {
        this.shareCount = i10;
    }

    public final void setStatus(@l String str) {
        this.status = str;
    }

    @k
    public String toString() {
        return "ArticleBean(id=" + this.f14343id + ", type=" + this.type + ", isTop=" + this.isTop + ", title=" + this.title + ", description=" + this.description + ", content=" + this.content + ", topics=" + this.topics + ", views=" + this.views + ", shareCount=" + this.shareCount + ", isComment=" + this.isComment + ", comments=" + this.comments + ", likes=" + this.likes + ", isLike=" + this.isLike + ", status=" + this.status + ", updateTime=" + this.updateTime + ", createTime=" + this.createTime + ", cfgId=" + this.cfgId + ", cfgInfo=" + this.cfgInfo + ", image=" + this.image + ", videoImg=" + this.videoImg + ", videoFile=" + this.videoFile + ", videoIndex=" + this.videoIndex + ", userInfo=" + this.userInfo + ", authorId=" + this.authorId + ", uid=" + this.uid + ", author=" + this.author + ", avatar=" + this.avatar + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.f14343id);
        out.writeInt(this.type);
        out.writeInt(this.isTop);
        out.writeString(this.title);
        out.writeString(this.description);
        out.writeString(this.content);
        List<ArticleTopic> list = this.topics;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<ArticleTopic> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i10);
            }
        }
        out.writeString(this.views);
        out.writeInt(this.shareCount);
        out.writeInt(this.isComment);
        out.writeInt(this.comments);
        out.writeInt(this.likes);
        out.writeInt(this.isLike);
        out.writeString(this.status);
        out.writeLong(this.updateTime);
        out.writeLong(this.createTime);
        out.writeInt(this.cfgId);
        out.writeParcelable(this.cfgInfo, i10);
        List<ContentAddBean> list2 = this.image;
        if (list2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list2.size());
            Iterator<ContentAddBean> it3 = list2.iterator();
            while (it3.hasNext()) {
                out.writeParcelable(it3.next(), i10);
            }
        }
        out.writeString(this.videoImg);
        out.writeString(this.videoFile);
        out.writeInt(this.videoIndex);
        UserInfo userInfo = this.userInfo;
        if (userInfo == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            userInfo.writeToParcel(out, i10);
        }
        out.writeInt(this.authorId);
        out.writeInt(this.uid);
        out.writeString(this.author);
        out.writeString(this.avatar);
        ReasonBean reasonBean = this.reason;
        if (reasonBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            reasonBean.writeToParcel(out, i10);
        }
    }

    public /* synthetic */ ArticleBean(int i10, int i11, int i12, String str, String str2, String str3, List list, String str4, int i13, int i14, int i15, int i16, int i17, String str5, long j10, long j11, int i18, CfgInfoBean cfgInfoBean, List list2, String str6, String str7, int i19, UserInfo userInfo, int i20, int i21, String str8, String str9, ReasonBean reasonBean, int i22, u uVar) {
        this(i10, i11, i12, (i22 & 8) != 0 ? null : str, (i22 & 16) != 0 ? null : str2, (i22 & 32) != 0 ? null : str3, (i22 & 64) != 0 ? null : list, str4, i13, i14, i15, i16, i17, (i22 & 8192) != 0 ? null : str5, j10, j11, i18, (131072 & i22) != 0 ? null : cfgInfoBean, (262144 & i22) != 0 ? null : list2, (524288 & i22) != 0 ? null : str6, (1048576 & i22) != 0 ? null : str7, i19, (4194304 & i22) != 0 ? null : userInfo, (8388608 & i22) != 0 ? 0 : i20, i21, (33554432 & i22) != 0 ? null : str8, (67108864 & i22) != 0 ? null : str9, (i22 & 134217728) != 0 ? null : reasonBean);
    }
}
