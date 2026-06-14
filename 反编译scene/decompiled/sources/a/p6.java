package a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p6 implements Parcelable.Creator<q6> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public q6 createFromParcel(Parcel parcel) {
        return new q6(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q6[] newArray(int i) {
        return new q6[i];
    }
}
