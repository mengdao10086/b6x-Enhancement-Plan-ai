package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class MyLikeArticleBean implements Parcelable {

    @k
    public static final Parcelable.Creator<MyLikeArticleBean> CREATOR = new Creator();

    @SerializedName("list")
    @k
    private final List<ArticleBean> list;

    @SerializedName("page")
    private final int page;

    @SerializedName("total")
    private final int total;

    public static final class Creator implements Parcelable.Creator<MyLikeArticleBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final MyLikeArticleBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i12);
            for (int i13 = 0; i13 != i12; i13++) {
                arrayList.add(ArticleBean.CREATOR.createFromParcel(parcel));
            }
            return new MyLikeArticleBean(i10, i11, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final MyLikeArticleBean[] newArray(int i10) {
            return new MyLikeArticleBean[i10];
        }
    }

    public MyLikeArticleBean(int i10, int i11, @k List<ArticleBean> list) {
        f0.p(list, "list");
        this.page = i10;
        this.total = i11;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyLikeArticleBean copy$default(MyLikeArticleBean myLikeArticleBean, int i10, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = myLikeArticleBean.page;
        }
        if ((i12 & 2) != 0) {
            i11 = myLikeArticleBean.total;
        }
        if ((i12 & 4) != 0) {
            list = myLikeArticleBean.list;
        }
        return myLikeArticleBean.copy(i10, i11, list);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.total;
    }

    @k
    public final List<ArticleBean> component3() {
        return this.list;
    }

    @k
    public final MyLikeArticleBean copy(int i10, int i11, @k List<ArticleBean> list) {
        f0.p(list, "list");
        return new MyLikeArticleBean(i10, i11, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyLikeArticleBean)) {
            return false;
        }
        MyLikeArticleBean myLikeArticleBean = (MyLikeArticleBean) obj;
        return this.page == myLikeArticleBean.page && this.total == myLikeArticleBean.total && f0.g(this.list, myLikeArticleBean.list);
    }

    @k
    public final List<ArticleBean> getList() {
        return this.list;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((this.page * 31) + this.total) * 31) + this.list.hashCode();
    }

    @k
    public String toString() {
        return "MyLikeArticleBean(page=" + this.page + ", total=" + this.total + ", list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.page);
        out.writeInt(this.total);
        List<ArticleBean> list = this.list;
        out.writeInt(list.size());
        Iterator<ArticleBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }
}
