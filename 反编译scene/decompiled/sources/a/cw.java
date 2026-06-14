package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cw implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.g> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BottomSheetBehavior.g createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.g(parcel, (ClassLoader) null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BottomSheetBehavior.g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.g(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BottomSheetBehavior.g[] newArray(int i) {
        return new BottomSheetBehavior.g[i];
    }
}
