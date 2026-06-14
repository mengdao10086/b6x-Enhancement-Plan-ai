package a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f6963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f2180a = null;

    public o(Parcel parcel) {
        this.f6963a = j.f(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void q(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f6963a == null) {
                this.f6963a = new m(this);
            }
            parcel.writeStrongBinder(this.f6963a.asBinder());
        }
    }
}
