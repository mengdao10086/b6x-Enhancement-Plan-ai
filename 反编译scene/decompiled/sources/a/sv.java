package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sv implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.e> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppBarLayout.BaseBehavior.e createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.e(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppBarLayout.BaseBehavior.e createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.e(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public AppBarLayout.BaseBehavior.e[] newArray(int i) {
        return new AppBarLayout.BaseBehavior.e[i];
    }
}
