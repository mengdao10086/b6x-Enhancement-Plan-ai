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
public final class UserInfo implements Parcelable {

    @k
    public static final Parcelable.Creator<UserInfo> CREATOR = new Creator();

    @SerializedName("avatar")
    @l
    private final String avatar;

    @SerializedName("uid")
    @l
    private final Integer uid;

    @SerializedName("user_tag")
    @l
    private final List<UserTag> userTag;

    @SerializedName("username")
    @l
    private final String username;

    public static final class Creator implements Parcelable.Creator<UserInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserInfo createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            ArrayList arrayList = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int i10 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i10);
                for (int i11 = 0; i11 != i10; i11++) {
                    arrayList2.add(UserTag.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new UserInfo(numValueOf, arrayList, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final UserInfo[] newArray(int i10) {
            return new UserInfo[i10];
        }
    }

    public UserInfo() {
        this(null, null, null, null, 15, null);
    }

    public UserInfo(@l Integer num, @l List<UserTag> list, @l String str, @l String str2) {
        this.uid = num;
        this.userTag = list;
        this.avatar = str;
        this.username = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, Integer num, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = userInfo.uid;
        }
        if ((i10 & 2) != 0) {
            list = userInfo.userTag;
        }
        if ((i10 & 4) != 0) {
            str = userInfo.avatar;
        }
        if ((i10 & 8) != 0) {
            str2 = userInfo.username;
        }
        return userInfo.copy(num, list, str, str2);
    }

    @l
    public final Integer component1() {
        return this.uid;
    }

    @l
    public final List<UserTag> component2() {
        return this.userTag;
    }

    @l
    public final String component3() {
        return this.avatar;
    }

    @l
    public final String component4() {
        return this.username;
    }

    @k
    public final UserInfo copy(@l Integer num, @l List<UserTag> list, @l String str, @l String str2) {
        return new UserInfo(num, list, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return f0.g(this.uid, userInfo.uid) && f0.g(this.userTag, userInfo.userTag) && f0.g(this.avatar, userInfo.avatar) && f0.g(this.username, userInfo.username);
    }

    @l
    public final String getAvatar() {
        return this.avatar;
    }

    @l
    public final Integer getUid() {
        return this.uid;
    }

    @l
    public final List<UserTag> getUserTag() {
        return this.userTag;
    }

    @l
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        Integer num = this.uid;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<UserTag> list = this.userTag;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.avatar;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.username;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @k
    public String toString() {
        return "UserInfo(uid=" + this.uid + ", userTag=" + this.userTag + ", avatar=" + this.avatar + ", username=" + this.username + ')';
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
        List<UserTag> list = this.userTag;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<UserTag> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(out, i10);
            }
        }
        out.writeString(this.avatar);
        out.writeString(this.username);
    }

    public /* synthetic */ UserInfo(Integer num, List list, String str, String str2, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : list, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2);
    }
}
