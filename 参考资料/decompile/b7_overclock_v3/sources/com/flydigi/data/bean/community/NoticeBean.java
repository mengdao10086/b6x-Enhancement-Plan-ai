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
public final class NoticeBean implements Parcelable {

    @k
    public static final Parcelable.Creator<NoticeBean> CREATOR = new Creator();

    @SerializedName("data")
    @k
    private final String data;

    @SerializedName("data_type")
    @k
    private final String dataType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14346id;

    @SerializedName(CommonNetImpl.TAG)
    @l
    private final String tag;

    @SerializedName("title")
    @l
    private final String title;

    public static final class Creator implements Parcelable.Creator<NoticeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final NoticeBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new NoticeBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final NoticeBean[] newArray(int i10) {
            return new NoticeBean[i10];
        }
    }

    public NoticeBean(@k String data, @k String dataType, int i10, @l String str, @l String str2) {
        f0.p(data, "data");
        f0.p(dataType, "dataType");
        this.data = data;
        this.dataType = dataType;
        this.f14346id = i10;
        this.tag = str;
        this.title = str2;
    }

    public static /* synthetic */ NoticeBean copy$default(NoticeBean noticeBean, String str, String str2, int i10, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = noticeBean.data;
        }
        if ((i11 & 2) != 0) {
            str2 = noticeBean.dataType;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            i10 = noticeBean.f14346id;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str3 = noticeBean.tag;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = noticeBean.title;
        }
        return noticeBean.copy(str, str5, i12, str6, str4);
    }

    @k
    public final String component1() {
        return this.data;
    }

    @k
    public final String component2() {
        return this.dataType;
    }

    public final int component3() {
        return this.f14346id;
    }

    @l
    public final String component4() {
        return this.tag;
    }

    @l
    public final String component5() {
        return this.title;
    }

    @k
    public final NoticeBean copy(@k String data, @k String dataType, int i10, @l String str, @l String str2) {
        f0.p(data, "data");
        f0.p(dataType, "dataType");
        return new NoticeBean(data, dataType, i10, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoticeBean)) {
            return false;
        }
        NoticeBean noticeBean = (NoticeBean) obj;
        return f0.g(this.data, noticeBean.data) && f0.g(this.dataType, noticeBean.dataType) && this.f14346id == noticeBean.f14346id && f0.g(this.tag, noticeBean.tag) && f0.g(this.title, noticeBean.title);
    }

    @k
    public final String getData() {
        return this.data;
    }

    @k
    public final String getDataType() {
        return this.dataType;
    }

    public final int getId() {
        return this.f14346id;
    }

    @l
    public final String getTag() {
        return this.tag;
    }

    @l
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((this.data.hashCode() * 31) + this.dataType.hashCode()) * 31) + this.f14346id) * 31;
        String str = this.tag;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @k
    public String toString() {
        return "NoticeBean(data=" + this.data + ", dataType=" + this.dataType + ", id=" + this.f14346id + ", tag=" + this.tag + ", title=" + this.title + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeString(this.data);
        out.writeString(this.dataType);
        out.writeInt(this.f14346id);
        out.writeString(this.tag);
        out.writeString(this.title);
    }

    public /* synthetic */ NoticeBean(String str, String str2, int i10, String str3, String str4, int i11, u uVar) {
        this(str, str2, i10, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4);
    }
}
