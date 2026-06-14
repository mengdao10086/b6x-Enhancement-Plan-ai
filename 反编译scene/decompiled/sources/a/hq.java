package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hq implements Parcelable.Creator<StaggeredGridLayoutManager.e> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.e createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.e(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public StaggeredGridLayoutManager.e[] newArray(int i) {
        return new StaggeredGridLayoutManager.e[i];
    }
}
