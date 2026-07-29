package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.g0;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5592o = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f5593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f5594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f5595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f5596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f5601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5602j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f5603k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f5604l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f5605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f5606n;

    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f5947c.size();
        this.f5593a = new int[size * 6];
        if (!aVar.f5953i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f5594b = new ArrayList<>(size);
        this.f5595c = new int[size];
        this.f5596d = new int[size];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            g0.a aVar2 = aVar.f5947c.get(i10);
            int i12 = i11 + 1;
            this.f5593a[i11] = aVar2.f5964a;
            ArrayList<String> arrayList = this.f5594b;
            Fragment fragment = aVar2.f5965b;
            arrayList.add(fragment != null ? fragment.f5646f : null);
            int[] iArr = this.f5593a;
            int i13 = i12 + 1;
            iArr[i12] = aVar2.f5966c ? 1 : 0;
            int i14 = i13 + 1;
            iArr[i13] = aVar2.f5967d;
            int i15 = i14 + 1;
            iArr[i14] = aVar2.f5968e;
            int i16 = i15 + 1;
            iArr[i15] = aVar2.f5969f;
            iArr[i16] = aVar2.f5970g;
            this.f5595c[i10] = aVar2.f5971h.ordinal();
            this.f5596d[i10] = aVar2.f5972i.ordinal();
            i10++;
            i11 = i16 + 1;
        }
        this.f5597e = aVar.f5952h;
        this.f5598f = aVar.f5955k;
        this.f5599g = aVar.P;
        this.f5600h = aVar.f5956l;
        this.f5601i = aVar.f5957m;
        this.f5602j = aVar.f5958n;
        this.f5603k = aVar.f5959o;
        this.f5604l = aVar.f5960p;
        this.f5605m = aVar.f5961q;
        this.f5606n = aVar.f5962r;
    }

    public final void a(@g.n0 androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f5593a.length) {
                aVar.f5952h = this.f5597e;
                aVar.f5955k = this.f5598f;
                aVar.f5953i = true;
                aVar.f5956l = this.f5600h;
                aVar.f5957m = this.f5601i;
                aVar.f5958n = this.f5602j;
                aVar.f5959o = this.f5603k;
                aVar.f5960p = this.f5604l;
                aVar.f5961q = this.f5605m;
                aVar.f5962r = this.f5606n;
                return;
            }
            g0.a aVar2 = new g0.a();
            int i12 = i10 + 1;
            aVar2.f5964a = this.f5593a[i10];
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Instantiate ");
                sb2.append(aVar);
                sb2.append(" op #");
                sb2.append(i11);
                sb2.append(" base fragment #");
                sb2.append(this.f5593a[i12]);
            }
            aVar2.f5971h = Lifecycle.State.values()[this.f5595c[i11]];
            aVar2.f5972i = Lifecycle.State.values()[this.f5596d[i11]];
            int[] iArr = this.f5593a;
            int i13 = i12 + 1;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f5966c = z10;
            int i14 = i13 + 1;
            int i15 = iArr[i13];
            aVar2.f5967d = i15;
            int i16 = i14 + 1;
            int i17 = iArr[i14];
            aVar2.f5968e = i17;
            int i18 = i16 + 1;
            int i19 = iArr[i16];
            aVar2.f5969f = i19;
            int i20 = iArr[i18];
            aVar2.f5970g = i20;
            aVar.f5948d = i15;
            aVar.f5949e = i17;
            aVar.f5950f = i19;
            aVar.f5951g = i20;
            aVar.m(aVar2);
            i11++;
            i10 = i18 + 1;
        }
    }

    @g.n0
    public androidx.fragment.app.a b(@g.n0 FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.P = this.f5599g;
        for (int i10 = 0; i10 < this.f5594b.size(); i10++) {
            String str = this.f5594b.get(i10);
            if (str != null) {
                aVar.f5947c.get(i10).f5965b = fragmentManager.o0(str);
            }
        }
        aVar.U(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @g.n0
    public androidx.fragment.app.a e(@g.n0 FragmentManager fragmentManager, @g.n0 Map<String, Fragment> map) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        for (int i10 = 0; i10 < this.f5594b.size(); i10++) {
            String str = this.f5594b.get(i10);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment == null) {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.f5598f + " failed due to missing saved state for Fragment (" + str + ee.a.f26979d);
                }
                aVar.f5947c.get(i10).f5965b = fragment;
            }
        }
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f5593a);
        parcel.writeStringList(this.f5594b);
        parcel.writeIntArray(this.f5595c);
        parcel.writeIntArray(this.f5596d);
        parcel.writeInt(this.f5597e);
        parcel.writeString(this.f5598f);
        parcel.writeInt(this.f5599g);
        parcel.writeInt(this.f5600h);
        TextUtils.writeToParcel(this.f5601i, parcel, 0);
        parcel.writeInt(this.f5602j);
        TextUtils.writeToParcel(this.f5603k, parcel, 0);
        parcel.writeStringList(this.f5604l);
        parcel.writeStringList(this.f5605m);
        parcel.writeInt(this.f5606n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f5593a = parcel.createIntArray();
        this.f5594b = parcel.createStringArrayList();
        this.f5595c = parcel.createIntArray();
        this.f5596d = parcel.createIntArray();
        this.f5597e = parcel.readInt();
        this.f5598f = parcel.readString();
        this.f5599g = parcel.readInt();
        this.f5600h = parcel.readInt();
        this.f5601i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5602j = parcel.readInt();
        this.f5603k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5604l = parcel.createStringArrayList();
        this.f5605m = parcel.createStringArrayList();
        this.f5606n = parcel.readInt() != 0;
    }
}
