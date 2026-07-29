package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class NavBean implements Parcelable {
    public static final int TYPE_CONFIG = 3;
    public static final int TYPE_HOT = 1;
    public static final int TYPE_NEWEST = 2;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14345id;

    @SerializedName("name")
    @k
    private final String name;

    @SerializedName("topic_id")
    private final int topicId;

    @SerializedName("type")
    private final int type;

    @k
    public static final Companion Companion = new Companion(null);

    @k
    public static final Parcelable.Creator<NavBean> CREATOR = new Creator();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public static final class Creator implements Parcelable.Creator<NavBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final NavBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new NavBean(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final NavBean[] newArray(int i10) {
            return new NavBean[i10];
        }
    }

    public NavBean(int i10, @k String name, int i11, int i12) {
        f0.p(name, "name");
        this.topicId = i10;
        this.name = name;
        this.f14345id = i11;
        this.type = i12;
    }

    public static /* synthetic */ NavBean copy$default(NavBean navBean, int i10, String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = navBean.topicId;
        }
        if ((i13 & 2) != 0) {
            str = navBean.name;
        }
        if ((i13 & 4) != 0) {
            i11 = navBean.f14345id;
        }
        if ((i13 & 8) != 0) {
            i12 = navBean.type;
        }
        return navBean.copy(i10, str, i11, i12);
    }

    public final int component1() {
        return this.topicId;
    }

    @k
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.f14345id;
    }

    public final int component4() {
        return this.type;
    }

    @k
    public final NavBean copy(int i10, @k String name, int i11, int i12) {
        f0.p(name, "name");
        return new NavBean(i10, name, i11, i12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavBean)) {
            return false;
        }
        NavBean navBean = (NavBean) obj;
        return this.topicId == navBean.topicId && f0.g(this.name, navBean.name) && this.f14345id == navBean.f14345id && this.type == navBean.type;
    }

    public final int getId() {
        return this.f14345id;
    }

    @k
    public final String getName() {
        return this.name;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.topicId * 31) + this.name.hashCode()) * 31) + this.f14345id) * 31) + this.type;
    }

    @k
    public String toString() {
        return "NavBean(topicId=" + this.topicId + ", name=" + this.name + ", id=" + this.f14345id + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.topicId);
        out.writeString(this.name);
        out.writeInt(this.f14345id);
        out.writeInt(this.type);
    }
}
