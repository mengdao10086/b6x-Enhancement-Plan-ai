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
public final class CommentListBean implements Parcelable {

    @k
    public static final Parcelable.Creator<CommentListBean> CREATOR = new Creator();

    @SerializedName("all_total")
    private final int allCount;

    @k
    private final ArrayList<CommentBean> list;
    private final int page;
    private final int total;

    public static final class Creator implements Parcelable.Creator<CommentListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentListBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 != i13; i14++) {
                arrayList.add(CommentBean.CREATOR.createFromParcel(parcel));
            }
            return new CommentListBean(i10, i11, i12, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentListBean[] newArray(int i10) {
            return new CommentListBean[i10];
        }
    }

    public CommentListBean() {
        this(0, 0, 0, null, 15, null);
    }

    public CommentListBean(int i10, int i11, int i12, @k ArrayList<CommentBean> list) {
        f0.p(list, "list");
        this.page = i10;
        this.total = i11;
        this.allCount = i12;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentListBean copy$default(CommentListBean commentListBean, int i10, int i11, int i12, ArrayList arrayList, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = commentListBean.page;
        }
        if ((i13 & 2) != 0) {
            i11 = commentListBean.total;
        }
        if ((i13 & 4) != 0) {
            i12 = commentListBean.allCount;
        }
        if ((i13 & 8) != 0) {
            arrayList = commentListBean.list;
        }
        return commentListBean.copy(i10, i11, i12, arrayList);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.total;
    }

    public final int component3() {
        return this.allCount;
    }

    @k
    public final ArrayList<CommentBean> component4() {
        return this.list;
    }

    @k
    public final CommentListBean copy(int i10, int i11, int i12, @k ArrayList<CommentBean> list) {
        f0.p(list, "list");
        return new CommentListBean(i10, i11, i12, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentListBean)) {
            return false;
        }
        CommentListBean commentListBean = (CommentListBean) obj;
        return this.page == commentListBean.page && this.total == commentListBean.total && this.allCount == commentListBean.allCount && f0.g(this.list, commentListBean.list);
    }

    public final int getAllCount() {
        return this.allCount;
    }

    @k
    public final ArrayList<CommentBean> getList() {
        return this.list;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((this.page * 31) + this.total) * 31) + this.allCount) * 31) + this.list.hashCode();
    }

    @k
    public String toString() {
        return "CommentListBean(page=" + this.page + ", total=" + this.total + ", allCount=" + this.allCount + ", list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.page);
        out.writeInt(this.total);
        out.writeInt(this.allCount);
        ArrayList<CommentBean> arrayList = this.list;
        out.writeInt(arrayList.size());
        Iterator<CommentBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }

    public /* synthetic */ CommentListBean(int i10, int i11, int i12, ArrayList arrayList, int i13, u uVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12, (i13 & 8) != 0 ? new ArrayList() : arrayList);
    }
}
