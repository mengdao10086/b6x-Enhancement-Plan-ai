package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class LikeArticleBean implements Parcelable {

    @k
    public static final Parcelable.Creator<LikeArticleBean> CREATOR = new Creator();

    @SerializedName(CommonNetImpl.RESULT)
    private final int result;

    public static final class Creator implements Parcelable.Creator<LikeArticleBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final LikeArticleBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new LikeArticleBean(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final LikeArticleBean[] newArray(int i10) {
            return new LikeArticleBean[i10];
        }
    }

    public LikeArticleBean(int i10) {
        this.result = i10;
    }

    public static /* synthetic */ LikeArticleBean copy$default(LikeArticleBean likeArticleBean, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = likeArticleBean.result;
        }
        return likeArticleBean.copy(i10);
    }

    public final int component1() {
        return this.result;
    }

    @k
    public final LikeArticleBean copy(int i10) {
        return new LikeArticleBean(i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LikeArticleBean) && this.result == ((LikeArticleBean) obj).result;
    }

    public final int getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result;
    }

    @k
    public String toString() {
        return "LikeArticleBean(result=" + this.result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.result);
    }
}
