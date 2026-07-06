package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class uu implements Parcelable.Creator<FlexboxLayout.a> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout.a createFromParcel(Parcel parcel) {
        return new FlexboxLayout.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout.a[] newArray(int i) {
        return new FlexboxLayout.a[i];
    }
}
