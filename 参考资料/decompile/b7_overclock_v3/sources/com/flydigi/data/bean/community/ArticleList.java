package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.flydigi.base.widget.LoadingDialogFragment;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class ArticleList implements Parcelable {

    @k
    public static final Parcelable.Creator<ArticleList> CREATOR = new Creator();

    @SerializedName("list")
    @k
    private final List<ArticleBean> list;

    @SerializedName(LoadingDialogFragment.E8)
    @k
    private final List<NoticeBean> notice;

    @SerializedName("page")
    private final int page;

    @SerializedName("total")
    private final int total;

    @SerializedName("total_page")
    private final int totalPage;

    public static final class Creator implements Parcelable.Creator<ArticleList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleList createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 != i13; i14++) {
                arrayList.add(ArticleBean.CREATOR.createFromParcel(parcel));
            }
            int i15 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i15);
            for (int i16 = 0; i16 != i15; i16++) {
                arrayList2.add(NoticeBean.CREATOR.createFromParcel(parcel));
            }
            return new ArticleList(i10, i11, i12, arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleList[] newArray(int i10) {
            return new ArticleList[i10];
        }
    }

    public ArticleList(int i10, int i11, int i12, @k List<ArticleBean> list, @k List<NoticeBean> notice) {
        f0.p(list, "list");
        f0.p(notice, "notice");
        this.total = i10;
        this.totalPage = i11;
        this.page = i12;
        this.list = list;
        this.notice = notice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArticleList copy$default(ArticleList articleList, int i10, int i11, int i12, List list, List list2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = articleList.total;
        }
        if ((i13 & 2) != 0) {
            i11 = articleList.totalPage;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = articleList.page;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            list = articleList.list;
        }
        List list3 = list;
        if ((i13 & 16) != 0) {
            list2 = articleList.notice;
        }
        return articleList.copy(i10, i14, i15, list3, list2);
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
    public final List<ArticleBean> component4() {
        return this.list;
    }

    @k
    public final List<NoticeBean> component5() {
        return this.notice;
    }

    @k
    public final ArticleList copy(int i10, int i11, int i12, @k List<ArticleBean> list, @k List<NoticeBean> notice) {
        f0.p(list, "list");
        f0.p(notice, "notice");
        return new ArticleList(i10, i11, i12, list, notice);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArticleList)) {
            return false;
        }
        ArticleList articleList = (ArticleList) obj;
        return this.total == articleList.total && this.totalPage == articleList.totalPage && this.page == articleList.page && f0.g(this.list, articleList.list) && f0.g(this.notice, articleList.notice);
    }

    @k
    public final List<ArticleBean> getList() {
        return this.list;
    }

    @k
    public final List<NoticeBean> getNotice() {
        return this.notice;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public int hashCode() {
        return (((((((this.total * 31) + this.totalPage) * 31) + this.page) * 31) + this.list.hashCode()) * 31) + this.notice.hashCode();
    }

    @k
    public String toString() {
        return "ArticleList(total=" + this.total + ", totalPage=" + this.totalPage + ", page=" + this.page + ", list=" + this.list + ", notice=" + this.notice + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.total);
        out.writeInt(this.totalPage);
        out.writeInt(this.page);
        List<ArticleBean> list = this.list;
        out.writeInt(list.size());
        Iterator<ArticleBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
        List<NoticeBean> list2 = this.notice;
        out.writeInt(list2.size());
        Iterator<NoticeBean> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(out, i10);
        }
    }
}
