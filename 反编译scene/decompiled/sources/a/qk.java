package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qk implements Parcelable.ClassLoaderCreator<DrawerLayout.f> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f createFromParcel(Parcel parcel) {
        return new DrawerLayout.f(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.f(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public DrawerLayout.f[] newArray(int i) {
        return new DrawerLayout.f[i];
    }
}
