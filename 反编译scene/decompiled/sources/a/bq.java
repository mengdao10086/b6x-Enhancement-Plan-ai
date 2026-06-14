package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bq implements Parcelable.ClassLoaderCreator<RecyclerView.y> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y createFromParcel(Parcel parcel) {
        return new RecyclerView.y(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.y(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public RecyclerView.y[] newArray(int i) {
        return new RecyclerView.y[i];
    }
}
