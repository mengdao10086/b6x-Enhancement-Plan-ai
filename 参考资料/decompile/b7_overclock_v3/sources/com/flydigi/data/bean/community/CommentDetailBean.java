package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class CommentDetailBean implements Parcelable {

    @k
    public static final Parcelable.Creator<CommentDetailBean> CREATOR = new Creator();

    @SerializedName("article")
    @l
    private final CommentDetailArticleBean article;

    @SerializedName("floorHost")
    @l
    private final CommentBean floorHost;

    @SerializedName("list")
    @k
    private final ArrayList<CommentBean> list;

    @SerializedName("page")
    private final int page;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName("total")
    private final int total;

    @SerializedName("total_page")
    private final int totalPage;

    public static final class Creator implements Parcelable.Creator<CommentDetailBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentDetailBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 != i13; i14++) {
                arrayList.add(CommentBean.CREATOR.createFromParcel(parcel));
            }
            return new CommentDetailBean(i10, i11, i12, arrayList, parcel.readInt() == 0 ? null : CommentBean.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? CommentDetailArticleBean.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentDetailBean[] newArray(int i10) {
            return new CommentDetailBean[i10];
        }
    }

    public CommentDetailBean() {
        this(0, 0, 0, null, null, null, 0, 127, null);
    }

    public CommentDetailBean(int i10, int i11, int i12, @k ArrayList<CommentBean> list, @l CommentBean commentBean, @l CommentDetailArticleBean commentDetailArticleBean, int i13) {
        f0.p(list, "list");
        this.total = i10;
        this.totalPage = i11;
        this.page = i12;
        this.list = list;
        this.floorHost = commentBean;
        this.article = commentDetailArticleBean;
        this.pageSize = i13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentDetailBean copy$default(CommentDetailBean commentDetailBean, int i10, int i11, int i12, ArrayList arrayList, CommentBean commentBean, CommentDetailArticleBean commentDetailArticleBean, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = commentDetailBean.total;
        }
        if ((i14 & 2) != 0) {
            i11 = commentDetailBean.totalPage;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            i12 = commentDetailBean.page;
        }
        int i16 = i12;
        if ((i14 & 8) != 0) {
            arrayList = commentDetailBean.list;
        }
        ArrayList arrayList2 = arrayList;
        if ((i14 & 16) != 0) {
            commentBean = commentDetailBean.floorHost;
        }
        CommentBean commentBean2 = commentBean;
        if ((i14 & 32) != 0) {
            commentDetailArticleBean = commentDetailBean.article;
        }
        CommentDetailArticleBean commentDetailArticleBean2 = commentDetailArticleBean;
        if ((i14 & 64) != 0) {
            i13 = commentDetailBean.pageSize;
        }
        return commentDetailBean.copy(i10, i15, i16, arrayList2, commentBean2, commentDetailArticleBean2, i13);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.totalPage;
    }

    public final int component3() {
        return this.page;
    }

    @k
    public final ArrayList<CommentBean> component4() {
        return this.list;
    }

    @l
    public final CommentBean component5() {
        return this.floorHost;
    }

    @l
    public final CommentDetailArticleBean component6() {
        return this.article;
    }

    public final int component7() {
        return this.pageSize;
    }

    @k
    public final CommentDetailBean copy(int i10, int i11, int i12, @k ArrayList<CommentBean> list, @l CommentBean commentBean, @l CommentDetailArticleBean commentDetailArticleBean, int i13) {
        f0.p(list, "list");
        return new CommentDetailBean(i10, i11, i12, list, commentBean, commentDetailArticleBean, i13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentDetailBean)) {
            return false;
        }
        CommentDetailBean commentDetailBean = (CommentDetailBean) obj;
        return this.total == commentDetailBean.total && this.totalPage == commentDetailBean.totalPage && this.page == commentDetailBean.page && f0.g(this.list, commentDetailBean.list) && f0.g(this.floorHost, commentDetailBean.floorHost) && f0.g(this.article, commentDetailBean.article) && this.pageSize == commentDetailBean.pageSize;
    }

    @l
    public final CommentDetailArticleBean getArticle() {
        return this.article;
    }

    @l
    public final CommentBean getFloorHost() {
        return this.floorHost;
    }

    @k
    public final ArrayList<CommentBean> getList() {
        return this.list;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        int iHashCode = ((((((this.total * 31) + this.totalPage) * 31) + this.page) * 31) + this.list.hashCode()) * 31;
        CommentBean commentBean = this.floorHost;
        int iHashCode2 = (iHashCode + (commentBean == null ? 0 : commentBean.hashCode())) * 31;
        CommentDetailArticleBean commentDetailArticleBean = this.article;
        return ((iHashCode2 + (commentDetailArticleBean != null ? commentDetailArticleBean.hashCode() : 0)) * 31) + this.pageSize;
    }

    @k
    public String toString() {
        return "CommentDetailBean(total=" + this.total + ", totalPage=" + this.totalPage + ", page=" + this.page + ", list=" + this.list + ", floorHost=" + this.floorHost + ", article=" + this.article + ", pageSize=" + this.pageSize + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.total);
        out.writeInt(this.totalPage);
        out.writeInt(this.page);
        ArrayList<CommentBean> arrayList = this.list;
        out.writeInt(arrayList.size());
        Iterator<CommentBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
        CommentBean commentBean = this.floorHost;
        if (commentBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            commentBean.writeToParcel(out, i10);
        }
        CommentDetailArticleBean commentDetailArticleBean = this.article;
        if (commentDetailArticleBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            commentDetailArticleBean.writeToParcel(out, i10);
        }
        out.writeInt(this.pageSize);
    }

    public /* synthetic */ CommentDetailBean(int i10, int i11, int i12, ArrayList arrayList, CommentBean commentBean, CommentDetailArticleBean commentDetailArticleBean, int i13, int i14, u uVar) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? new ArrayList() : arrayList, (i14 & 16) != 0 ? null : commentBean, (i14 & 32) != 0 ? null : commentDetailArticleBean, (i14 & 64) != 0 ? 0 : i13);
    }
}
