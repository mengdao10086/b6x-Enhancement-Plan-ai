package a;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q6 extends View.BaseSavedState {
    public static final Parcelable.Creator<q6> CREATOR = new p6();
    public boolean b;

    public q6(Parcel parcel) {
        super(parcel);
        this.b = parcel.readByte() != 0;
    }

    public q6(Parcelable parcelable) {
        super(parcelable);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
    }
}
