package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rp implements Parcelable.Creator<LinearLayoutManager.d> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayoutManager.d createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.d(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutManager.d[] newArray(int i) {
        return new LinearLayoutManager.d[i];
    }
}
