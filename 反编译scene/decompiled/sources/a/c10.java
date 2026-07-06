package a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c10 implements Parcelable.ClassLoaderCreator<d10> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d10 createFromParcel(Parcel parcel) {
        return new d10(parcel, null, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d10 createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new d10(parcel, classLoader, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d10[] newArray(int i) {
        return new d10[i];
    }
}
