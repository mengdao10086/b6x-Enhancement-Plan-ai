package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lu implements Parcelable.ClassLoaderCreator<ViewPager.m> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewPager.m createFromParcel(Parcel parcel) {
        return new ViewPager.m(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ViewPager.m createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.m(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ViewPager.m[] newArray(int i) {
        return new ViewPager.m[i];
    }
}
