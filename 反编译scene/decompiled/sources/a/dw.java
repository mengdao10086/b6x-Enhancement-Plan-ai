package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dw implements Parcelable.ClassLoaderCreator<MaterialButton.c> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MaterialButton.c createFromParcel(Parcel parcel) {
        return new MaterialButton.c(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialButton.c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new MaterialButton.c(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public MaterialButton.c[] newArray(int i) {
        return new MaterialButton.c[i];
    }
}
