package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h8 implements Parcelable.ClassLoaderCreator<SearchView.o> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SearchView.o createFromParcel(Parcel parcel) {
        return new SearchView.o(parcel, null);
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SearchView.o createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.o(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SearchView.o[] newArray(int i) {
        return new SearchView.o[i];
    }
}
