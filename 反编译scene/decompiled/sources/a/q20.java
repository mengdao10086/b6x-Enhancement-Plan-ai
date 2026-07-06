package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q20 implements Parcelable.ClassLoaderCreator<TextInputLayout.h> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TextInputLayout.h createFromParcel(Parcel parcel) {
        return new TextInputLayout.h(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextInputLayout.h createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.h(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TextInputLayout.h[] newArray(int i) {
        return new TextInputLayout.h[i];
    }
}
