package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class Tags implements Parcelable {

    @k
    public static final Parcelable.Creator<Tags> CREATOR = new Creator();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    @l
    private final Integer f14347id;

    @SerializedName("image")
    @l
    private final String image;

    @SerializedName(CommonNetImpl.TAG)
    @l
    private final String tag;

    public static final class Creator implements Parcelable.Creator<Tags> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final Tags createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new Tags(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final Tags[] newArray(int i10) {
            return new Tags[i10];
        }
    }

    public Tags() {
        this(null, null, null, 7, null);
    }

    public Tags(@l String str, @l Integer num, @l String str2) {
        this.image = str;
        this.f14347id = num;
        this.tag = str2;
    }

    public static /* synthetic */ Tags copy$default(Tags tags, String str, Integer num, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = tags.image;
        }
        if ((i10 & 2) != 0) {
            num = tags.f14347id;
        }
        if ((i10 & 4) != 0) {
            str2 = tags.tag;
        }
        return tags.copy(str, num, str2);
    }

    @l
    public final String component1() {
        return this.image;
    }

    @l
    public final Integer component2() {
        return this.f14347id;
    }

    @l
    public final String component3() {
        return this.tag;
    }

    @k
    public final Tags copy(@l String str, @l Integer num, @l String str2) {
        return new Tags(str, num, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tags)) {
            return false;
        }
        Tags tags = (Tags) obj;
        return f0.g(this.image, tags.image) && f0.g(this.f14347id, tags.f14347id) && f0.g(this.tag, tags.tag);
    }

    @l
    public final Integer getId() {
        return this.f14347id;
    }

    @l
    public final String getImage() {
        return this.image;
    }

    @l
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String str = this.image;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f14347id;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.tag;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @k
    public String toString() {
        return "Tags(image=" + this.image + ", id=" + this.f14347id + ", tag=" + this.tag + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        int iIntValue;
        f0.p(out, "out");
        out.writeString(this.image);
        Integer num = this.f14347id;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        out.writeString(this.tag);
    }

    public /* synthetic */ Tags(String str, Integer num, String str2, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str2);
    }
}
