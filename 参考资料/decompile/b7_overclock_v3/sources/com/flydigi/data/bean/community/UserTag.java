package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class UserTag implements Parcelable {

    @k
    public static final Parcelable.Creator<UserTag> CREATOR = new Creator();

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    @l
    private final Integer f14349id;

    @SerializedName("tag_id")
    @l
    private final Integer tagId;

    @SerializedName(SocializeProtocolConstants.TAGS)
    @l
    private final Tags tags;

    @SerializedName("uid")
    @l
    private final Integer uid;

    public static final class Creator implements Parcelable.Creator<UserTag> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserTag createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new UserTag(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Tags.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserTag[] newArray(int i10) {
            return new UserTag[i10];
        }
    }

    public UserTag() {
        this(null, null, null, null, 15, null);
    }

    public UserTag(@l Integer num, @l Integer num2, @l Integer num3, @l Tags tags) {
        this.uid = num;
        this.tagId = num2;
        this.f14349id = num3;
        this.tags = tags;
    }

    public static /* synthetic */ UserTag copy$default(UserTag userTag, Integer num, Integer num2, Integer num3, Tags tags, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = userTag.uid;
        }
        if ((i10 & 2) != 0) {
            num2 = userTag.tagId;
        }
        if ((i10 & 4) != 0) {
            num3 = userTag.f14349id;
        }
        if ((i10 & 8) != 0) {
            tags = userTag.tags;
        }
        return userTag.copy(num, num2, num3, tags);
    }

    @l
    public final Integer component1() {
        return this.uid;
    }

    @l
    public final Integer component2() {
        return this.tagId;
    }

    @l
    public final Integer component3() {
        return this.f14349id;
    }

    @l
    public final Tags component4() {
        return this.tags;
    }

    @k
    public final UserTag copy(@l Integer num, @l Integer num2, @l Integer num3, @l Tags tags) {
        return new UserTag(num, num2, num3, tags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTag)) {
            return false;
        }
        UserTag userTag = (UserTag) obj;
        return f0.g(this.uid, userTag.uid) && f0.g(this.tagId, userTag.tagId) && f0.g(this.f14349id, userTag.f14349id) && f0.g(this.tags, userTag.tags);
    }

    @l
    public final Integer getId() {
        return this.f14349id;
    }

    @l
    public final Integer getTagId() {
        return this.tagId;
    }

    @l
    public final Tags getTags() {
        return this.tags;
    }

    @l
    public final Integer getUid() {
        return this.uid;
    }

    public int hashCode() {
        Integer num = this.uid;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.tagId;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f14349id;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Tags tags = this.tags;
        return iHashCode3 + (tags != null ? tags.hashCode() : 0);
    }

    @k
    public String toString() {
        return "UserTag(uid=" + this.uid + ", tagId=" + this.tagId + ", id=" + this.f14349id + ", tags=" + this.tags + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        Integer num = this.uid;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.tagId;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.f14349id;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Tags tags = this.tags;
        if (tags == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            tags.writeToParcel(out, i10);
        }
    }

    public /* synthetic */ UserTag(Integer num, Integer num2, Integer num3, Tags tags, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : tags);
    }
}
