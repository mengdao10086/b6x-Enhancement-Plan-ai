package a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.flexbox.FlexboxLayoutManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wu implements Parcelable.Creator<FlexboxLayoutManager.e> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FlexboxLayoutManager.e createFromParcel(Parcel parcel) {
        return new FlexboxLayoutManager.e(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FlexboxLayoutManager.e[] newArray(int i) {
        return new FlexboxLayoutManager.e[i];
    }
}
