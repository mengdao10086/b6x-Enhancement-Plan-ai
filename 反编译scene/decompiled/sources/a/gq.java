package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gq implements Parcelable.Creator<StaggeredGridLayoutManager.d.a> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.d.a createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.d.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.d.a[] newArray(int i) {
        return new StaggeredGridLayoutManager.d.a[i];
    }
}
