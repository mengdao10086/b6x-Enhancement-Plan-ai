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
public final class LikeCommentBean implements Parcelable {

    @k
    public static final Parcelable.Creator<LikeCommentBean> CREATOR = new Creator();

    @SerializedName(CommonNetImpl.RESULT)
    private final int result;

    public static final class Creator implements Parcelable.Creator<LikeCommentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final LikeCommentBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new LikeCommentBean(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final LikeCommentBean[] newArray(int i10) {
            return new LikeCommentBean[i10];
        }
    }

    public LikeCommentBean(int i10) {
        this.result = i10;
    }

    public static /* synthetic */ LikeCommentBean copy$default(LikeCommentBean likeCommentBean, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = likeCommentBean.result;
        }
        return likeCommentBean.copy(i10);
    }

    public final int component1() {
        return this.result;
    }

    @k
    public final LikeCommentBean copy(int i10) {
        return new LikeCommentBean(i10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LikeCommentBean) && this.result == ((LikeCommentBean) obj).result;
    }

    public final int getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result;
    }

    @k
    public String toString() {
        return "LikeCommentBean(result=" + this.result + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.result);
    }
}
