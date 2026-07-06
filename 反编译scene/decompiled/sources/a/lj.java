package a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lj implements Parcelable.Creator<NestedScrollView.c> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NestedScrollView.c createFromParcel(Parcel parcel) {
        return new NestedScrollView.c(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView.c[] newArray(int i) {
        return new NestedScrollView.c[i];
    }
}
