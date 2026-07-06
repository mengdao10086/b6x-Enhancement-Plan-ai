package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ox implements Parcelable.ClassLoaderCreator<CheckableImageButton.b> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CheckableImageButton.b createFromParcel(Parcel parcel) {
        return new CheckableImageButton.b(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CheckableImageButton.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CheckableImageButton.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public CheckableImageButton.b[] newArray(int i) {
        return new CheckableImageButton.b[i];
    }
}
