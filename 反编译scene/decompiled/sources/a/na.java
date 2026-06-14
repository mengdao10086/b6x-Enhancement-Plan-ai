package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class na implements Parcelable.ClassLoaderCreator<CoordinatorLayout.h> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout.h createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.h(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout.h createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.h(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout.h[] newArray(int i) {
        return new CoordinatorLayout.h[i];
    }
}
