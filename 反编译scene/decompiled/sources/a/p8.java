package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p8 implements Parcelable.ClassLoaderCreator<Toolbar.g> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toolbar.g createFromParcel(Parcel parcel) {
        return new Toolbar.g(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Toolbar.g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.g(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Toolbar.g[] newArray(int i) {
        return new Toolbar.g[i];
    }
}
