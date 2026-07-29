package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f5789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Bundle f5790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f5791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bundle f5793m;

    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f5781a = fragment.getClass().getName();
        this.f5782b = fragment.f5646f;
        this.f5783c = fragment.f5657o;
        this.f5784d = fragment.f5668x;
        this.f5785e = fragment.f5669y;
        this.f5786f = fragment.f5670z;
        this.f5787g = fragment.C;
        this.f5788h = fragment.f5655m;
        this.f5789i = fragment.B;
        this.f5790j = fragment.f5647g;
        this.f5791k = fragment.A;
        this.f5792l = fragment.I7.ordinal();
    }

    @g.n0
    public Fragment a(@g.n0 k kVar, @g.n0 ClassLoader classLoader) {
        Fragment fragmentA = kVar.a(classLoader, this.f5781a);
        Bundle bundle = this.f5790j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.c5(this.f5790j);
        fragmentA.f5646f = this.f5782b;
        fragmentA.f5657o = this.f5783c;
        fragmentA.f5659q = true;
        fragmentA.f5668x = this.f5784d;
        fragmentA.f5669y = this.f5785e;
        fragmentA.f5670z = this.f5786f;
        fragmentA.C = this.f5787g;
        fragmentA.f5655m = this.f5788h;
        fragmentA.B = this.f5789i;
        fragmentA.A = this.f5791k;
        fragmentA.I7 = Lifecycle.State.values()[this.f5792l];
        Bundle bundle2 = this.f5793m;
        if (bundle2 != null) {
            fragmentA.f5642b = bundle2;
        } else {
            fragmentA.f5642b = new Bundle();
        }
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @g.n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f5781a);
        sb2.append(" (");
        sb2.append(this.f5782b);
        sb2.append(")}:");
        if (this.f5783c) {
            sb2.append(" fromLayout");
        }
        if (this.f5785e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f5785e));
        }
        String str = this.f5786f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f5786f);
        }
        if (this.f5787g) {
            sb2.append(" retainInstance");
        }
        if (this.f5788h) {
            sb2.append(" removing");
        }
        if (this.f5789i) {
            sb2.append(" detached");
        }
        if (this.f5791k) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f5781a);
        parcel.writeString(this.f5782b);
        parcel.writeInt(this.f5783c ? 1 : 0);
        parcel.writeInt(this.f5784d);
        parcel.writeInt(this.f5785e);
        parcel.writeString(this.f5786f);
        parcel.writeInt(this.f5787g ? 1 : 0);
        parcel.writeInt(this.f5788h ? 1 : 0);
        parcel.writeInt(this.f5789i ? 1 : 0);
        parcel.writeBundle(this.f5790j);
        parcel.writeInt(this.f5791k ? 1 : 0);
        parcel.writeBundle(this.f5793m);
        parcel.writeInt(this.f5792l);
    }

    public FragmentState(Parcel parcel) {
        this.f5781a = parcel.readString();
        this.f5782b = parcel.readString();
        this.f5783c = parcel.readInt() != 0;
        this.f5784d = parcel.readInt();
        this.f5785e = parcel.readInt();
        this.f5786f = parcel.readString();
        this.f5787g = parcel.readInt() != 0;
        this.f5788h = parcel.readInt() != 0;
        this.f5789i = parcel.readInt() != 0;
        this.f5790j = parcel.readBundle();
        this.f5791k = parcel.readInt() != 0;
        this.f5793m = parcel.readBundle();
        this.f5792l = parcel.readInt();
    }
}
