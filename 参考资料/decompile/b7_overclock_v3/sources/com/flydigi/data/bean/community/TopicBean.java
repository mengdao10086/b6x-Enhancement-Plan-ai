package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class TopicBean implements Parcelable {

    @k
    public static final Parcelable.Creator<TopicBean> CREATOR = new Creator();

    @SerializedName("alt_type")
    private final int altType;

    @SerializedName("bg_image")
    @l
    private final String bgImage;

    @SerializedName("class_type")
    private final int classType;

    @SerializedName("archives_count")
    private final int count;

    @SerializedName("icon_image")
    @l
    private final String iconImage;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14348id;

    @SerializedName("nav")
    @l
    private final List<NavBean> nav;

    @SerializedName("share_link")
    @l
    private final String shareLink;

    @SerializedName("sub_title")
    @l
    private final String subTitle;

    @SerializedName("title")
    @l
    private final String title;

    @SerializedName("type")
    private final int type;

    public static final class Creator implements Parcelable.Creator<TopicBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final TopicBean createFromParcel(@k Parcel parcel) {
            ArrayList arrayList;
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i14 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    arrayList2.add(NavBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new TopicBean(i10, string, string2, i11, i12, i13, string3, string4, arrayList, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final TopicBean[] newArray(int i10) {
            return new TopicBean[i10];
        }
    }

    public TopicBean(int i10, @l String str, @l String str2, int i11, int i12, int i13, @l String str3, @l String str4, @l List<NavBean> list, int i14, @l String str5) {
        this.f14348id = i10;
        this.title = str;
        this.subTitle = str2;
        this.type = i11;
        this.classType = i12;
        this.altType = i13;
        this.iconImage = str3;
        this.bgImage = str4;
        this.nav = list;
        this.count = i14;
        this.shareLink = str5;
    }

    public final int component1() {
        return this.f14348id;
    }

    public final int component10() {
        return this.count;
    }

    @l
    public final String component11() {
        return this.shareLink;
    }

    @l
    public final String component2() {
        return this.title;
    }

    @l
    public final String component3() {
        return this.subTitle;
    }

    public final int component4() {
        return this.type;
    }

    public final int component5() {
        return this.classType;
    }

    public final int component6() {
        return this.altType;
    }

    @l
    public final String component7() {
        return this.iconImage;
    }

    @l
    public final String component8() {
        return this.bgImage;
    }

    @l
    public final List<NavBean> component9() {
        return this.nav;
    }

    @k
    public final TopicBean copy(int i10, @l String str, @l String str2, int i11, int i12, int i13, @l String str3, @l String str4, @l List<NavBean> list, int i14, @l String str5) {
        return new TopicBean(i10, str, str2, i11, i12, i13, str3, str4, list, i14, str5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopicBean)) {
            return false;
        }
        TopicBean topicBean = (TopicBean) obj;
        return this.f14348id == topicBean.f14348id && f0.g(this.title, topicBean.title) && f0.g(this.subTitle, topicBean.subTitle) && this.type == topicBean.type && this.classType == topicBean.classType && this.altType == topicBean.altType && f0.g(this.iconImage, topicBean.iconImage) && f0.g(this.bgImage, topicBean.bgImage) && f0.g(this.nav, topicBean.nav) && this.count == topicBean.count && f0.g(this.shareLink, topicBean.shareLink);
    }

    public final int getAltType() {
        return this.altType;
    }

    @l
    public final String getBgImage() {
        return this.bgImage;
    }

    public final int getClassType() {
        return this.classType;
    }

    public final int getCount() {
        return this.count;
    }

    @l
    public final String getIconImage() {
        return this.iconImage;
    }

    public final int getId() {
        return this.f14348id;
    }

    @l
    public final List<NavBean> getNav() {
        return this.nav;
    }

    @l
    public final String getShareLink() {
        return this.shareLink;
    }

    @l
    public final String getSubTitle() {
        return this.subTitle;
    }

    @l
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i10 = this.f14348id * 31;
        String str = this.title;
        int iHashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subTitle;
        int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type) * 31) + this.classType) * 31) + this.altType) * 31;
        String str3 = this.iconImage;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bgImage;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<NavBean> list = this.nav;
        int iHashCode5 = (((iHashCode4 + (list == null ? 0 : list.hashCode())) * 31) + this.count) * 31;
        String str5 = this.shareLink;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    @k
    public String toString() {
        return "TopicBean(id=" + this.f14348id + ", title=" + this.title + ", subTitle=" + this.subTitle + ", type=" + this.type + ", classType=" + this.classType + ", altType=" + this.altType + ", iconImage=" + this.iconImage + ", bgImage=" + this.bgImage + ", nav=" + this.nav + ", count=" + this.count + ", shareLink=" + this.shareLink + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.f14348id);
        out.writeString(this.title);
        out.writeString(this.subTitle);
        out.writeInt(this.type);
        out.writeInt(this.classType);
        out.writeInt(this.altType);
        out.writeString(this.iconImage);
        out.writeString(this.bgImage);
        List<NavBean> list = this.nav;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<NavBean> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i10);
            }
        }
        out.writeInt(this.count);
        out.writeString(this.shareLink);
    }

    public /* synthetic */ TopicBean(int i10, String str, String str2, int i11, int i12, int i13, String str3, String str4, List list, int i14, String str5, int i15, u uVar) {
        this(i10, (i15 & 2) != 0 ? null : str, (i15 & 4) != 0 ? null : str2, i11, i12, i13, (i15 & 64) != 0 ? null : str3, (i15 & 128) != 0 ? null : str4, (i15 & 256) != 0 ? null : list, i14, (i15 & 1024) != 0 ? null : str5);
    }
}
