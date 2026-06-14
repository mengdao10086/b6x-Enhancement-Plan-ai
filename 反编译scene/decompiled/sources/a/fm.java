package a;

import a.hn;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class fm implements Parcelable {
    public static final Parcelable.Creator<fm> CREATOR = new em();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f919a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Bundle f920b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f921b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f922b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f923c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f924c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public fm(Parcel parcel) {
        this.f919a = parcel.readString();
        this.f921b = parcel.readString();
        this.f922b = parcel.readInt() != 0;
        this.f6119a = parcel.readInt();
        this.b = parcel.readInt();
        this.f923c = parcel.readString();
        this.f924c = parcel.readInt() != 0;
        this.d = parcel.readInt() != 0;
        this.e = parcel.readInt() != 0;
        this.f917a = parcel.readBundle();
        this.f = parcel.readInt() != 0;
        this.f920b = parcel.readBundle();
        this.c = parcel.readInt();
    }

    public fm(Fragment fragment) {
        this.f919a = fragment.getClass().getName();
        this.f921b = fragment.f4267a;
        this.f922b = fragment.f4277d;
        this.f6119a = fragment.d;
        this.b = fragment.e;
        this.f923c = fragment.f4275c;
        this.f924c = fragment.j;
        this.d = fragment.f4276c;
        this.e = fragment.i;
        this.f917a = fragment.f4269b;
        this.f = fragment.h;
        this.c = fragment.f4253a.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment q(ClassLoader classLoader, fl flVar) {
        Fragment fragment;
        Bundle bundle;
        if (this.f918a == null) {
            Bundle bundle2 = this.f917a;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            Fragment fragmentA = flVar.a(classLoader, this.f919a);
            this.f918a = fragmentA;
            fragmentA.k1(this.f917a);
            Bundle bundle3 = this.f920b;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.f918a;
                bundle = this.f920b;
            } else {
                fragment = this.f918a;
                bundle = new Bundle();
            }
            fragment.f4260a = bundle;
            Fragment fragment2 = this.f918a;
            fragment2.f4267a = this.f921b;
            fragment2.f4277d = this.f922b;
            fragment2.f = true;
            fragment2.d = this.f6119a;
            fragment2.e = this.b;
            fragment2.f4275c = this.f923c;
            fragment2.j = this.f924c;
            fragment2.f4276c = this.d;
            fragment2.i = this.e;
            fragment2.h = this.f;
            fragment2.f4253a = hn.b.values()[this.c];
            if (yl.h) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f918a);
            }
        }
        return this.f918a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f919a);
        sb.append(" (");
        sb.append(this.f921b);
        sb.append(")}:");
        if (this.f922b) {
            sb.append(" fromLayout");
        }
        if (this.b != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.b));
        }
        String str = this.f923c;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f923c);
        }
        if (this.f924c) {
            sb.append(" retainInstance");
        }
        if (this.d) {
            sb.append(" removing");
        }
        if (this.e) {
            sb.append(" detached");
        }
        if (this.f) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f919a);
        parcel.writeString(this.f921b);
        parcel.writeInt(this.f922b ? 1 : 0);
        parcel.writeInt(this.f6119a);
        parcel.writeInt(this.b);
        parcel.writeString(this.f923c);
        parcel.writeInt(this.f924c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeBundle(this.f917a);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeBundle(this.f920b);
        parcel.writeInt(this.c);
    }
}
