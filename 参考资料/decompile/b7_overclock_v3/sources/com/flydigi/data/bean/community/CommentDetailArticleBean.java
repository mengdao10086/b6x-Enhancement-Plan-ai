package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.flydigi.community.ui.comment.CommentListFragment;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class CommentDetailArticleBean implements Parcelable {

    @k
    public static final Parcelable.Creator<CommentDetailArticleBean> CREATOR = new Creator();

    @SerializedName(CommentListFragment.O8)
    private final int articleType;

    @SerializedName("info_id")
    private final int infoId;

    @SerializedName("is_comment")
    private final int isComment;

    public static final class Creator implements Parcelable.Creator<CommentDetailArticleBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentDetailArticleBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new CommentDetailArticleBean(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentDetailArticleBean[] newArray(int i10) {
            return new CommentDetailArticleBean[i10];
        }
    }

    public CommentDetailArticleBean() {
        this(0, 0, 0, 7, null);
    }

    public CommentDetailArticleBean(int i10, int i11, int i12) {
        this.articleType = i10;
        this.isComment = i11;
        this.infoId = i12;
    }

    public static /* synthetic */ CommentDetailArticleBean copy$default(CommentDetailArticleBean commentDetailArticleBean, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = commentDetailArticleBean.articleType;
        }
        if ((i13 & 2) != 0) {
            i11 = commentDetailArticleBean.isComment;
        }
        if ((i13 & 4) != 0) {
            i12 = commentDetailArticleBean.infoId;
        }
        return commentDetailArticleBean.copy(i10, i11, i12);
    }

    public final int component1() {
        return this.articleType;
    }

    public final int component2() {
        return this.isComment;
    }

    public final int component3() {
        return this.infoId;
    }

    @k
    public final CommentDetailArticleBean copy(int i10, int i11, int i12) {
        return new CommentDetailArticleBean(i10, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentDetailArticleBean)) {
            return false;
        }
        CommentDetailArticleBean commentDetailArticleBean = (CommentDetailArticleBean) obj;
        return this.articleType == commentDetailArticleBean.articleType && this.isComment == commentDetailArticleBean.isComment && this.infoId == commentDetailArticleBean.infoId;
    }

    public final int getArticleType() {
        return this.articleType;
    }

    public final int getInfoId() {
        return this.infoId;
    }

    public int hashCode() {
        return (((this.articleType * 31) + this.isComment) * 31) + this.infoId;
    }

    public final int isComment() {
        return this.isComment;
    }

    @k
    public String toString() {
        return "CommentDetailArticleBean(articleType=" + this.articleType + ", isComment=" + this.isComment + ", infoId=" + this.infoId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.articleType);
        out.writeInt(this.isComment);
        out.writeInt(this.infoId);
    }

    public /* synthetic */ CommentDetailArticleBean(int i10, int i11, int i12, int i13, u uVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
    }
}
