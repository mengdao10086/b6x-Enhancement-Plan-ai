package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class ArticleReadLog extends LogAction {
    public static final Parcelable.Creator<ArticleReadLog> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13283a = "推荐";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13284b = "外设";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13285c = "置顶公告";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13286d = "弹窗公告";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13287e = "商城";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13288f = "游戏";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13289g = "内链";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13290h = "搜索";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13291i = "消息";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13292j = "启动页";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13293k = "我发布的帖子";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13294l = "推荐配置";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13295m = "收藏";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13296n = "浏览器";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13297o = "未定义";

    @SerializedName(CommentListFragment.M8)
    private String articleId;

    @SerializedName("referer")
    private String source;

    public class a implements Parcelable.Creator<ArticleReadLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArticleReadLog createFromParcel(Parcel source) {
            return new ArticleReadLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArticleReadLog[] newArray(int size) {
            return new ArticleReadLog[size];
        }
    }

    public ArticleReadLog() {
    }

    public String B0() {
        return this.articleId;
    }

    public String D0() {
        return this.source;
    }

    public void E0(final String articleId) {
        this.articleId = articleId;
    }

    public void F0(final String source) {
        this.source = source;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction
    public String toString() {
        return "ArticleReadLog{source='" + this.source + "', articleId='" + this.articleId + "'}";
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.source);
        dest.writeString(this.articleId);
    }

    public ArticleReadLog(Parcel in2) {
        super(in2);
        this.source = in2.readString();
        this.articleId = in2.readString();
    }
}
