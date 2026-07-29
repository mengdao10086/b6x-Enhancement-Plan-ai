package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ExistingWorkPolicy;
import androidx.work.x;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l2.g;
import l2.i;
import l2.j;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkContinuationImpl implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f8730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExistingWorkPolicy[] f8729b = ExistingWorkPolicy.values();
    public static final Parcelable.Creator<ParcelableWorkContinuationImpl> CREATOR = new a();

    public class a implements Parcelable.Creator<ParcelableWorkContinuationImpl> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkContinuationImpl createFromParcel(@n0 Parcel parcel) {
            return new ParcelableWorkContinuationImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkContinuationImpl[] newArray(int i10) {
            return new ParcelableWorkContinuationImpl[i10];
        }
    }

    public ParcelableWorkContinuationImpl(@n0 g gVar) {
        this.f8730a = new b(gVar);
    }

    @n0
    public b a() {
        return this.f8730a;
    }

    @n0
    public g b(@n0 i iVar) {
        return this.f8730a.f(iVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        String strB = this.f8730a.b();
        boolean z10 = !TextUtils.isEmpty(strB);
        x2.b.b(parcel, z10);
        if (z10) {
            parcel.writeString(strB);
        }
        parcel.writeInt(this.f8730a.a().ordinal());
        List<? extends x> listD = this.f8730a.d();
        parcel.writeInt(listD.size());
        if (!listD.isEmpty()) {
            for (int i11 = 0; i11 < listD.size(); i11++) {
                parcel.writeParcelable(new ParcelableWorkRequest(listD.get(i11)), i10);
            }
        }
        List<b> listC = this.f8730a.c();
        boolean z11 = (listC == null || listC.isEmpty()) ? false : true;
        x2.b.b(parcel, z11);
        if (z11) {
            parcel.writeInt(listC.size());
            for (int i12 = 0; i12 < listC.size(); i12++) {
                parcel.writeParcelable(new ParcelableWorkContinuationImpl(listC.get(i12)), i10);
            }
        }
    }

    public ParcelableWorkContinuationImpl(@n0 b bVar) {
        this.f8730a = bVar;
    }

    public ParcelableWorkContinuationImpl(@n0 Parcel parcel) {
        ArrayList arrayList = null;
        String string = x2.b.a(parcel) ? parcel.readString() : null;
        ExistingWorkPolicy existingWorkPolicy = f8729b[parcel.readInt()];
        int i10 = parcel.readInt();
        ArrayList arrayList2 = new ArrayList(i10);
        ClassLoader classLoader = getClass().getClassLoader();
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList2.add((j) ((ParcelableWorkRequest) parcel.readParcelable(classLoader)).a());
        }
        if (x2.b.a(parcel)) {
            int i12 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i12);
            for (int i13 = 0; i13 < i12; i13++) {
                arrayList3.add(((ParcelableWorkContinuationImpl) parcel.readParcelable(classLoader)).a());
            }
            arrayList = arrayList3;
        }
        this.f8730a = new b(string, existingWorkPolicy, arrayList2, arrayList);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ExistingWorkPolicy f8732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<? extends x> f8733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<b> f8734d;

        public b(@n0 g gVar) {
            this.f8731a = gVar.k();
            this.f8732b = gVar.i();
            this.f8733c = gVar.m();
            List<g> listL = gVar.l();
            this.f8734d = null;
            if (listL != null) {
                this.f8734d = new ArrayList(listL.size());
                Iterator<g> it2 = listL.iterator();
                while (it2.hasNext()) {
                    this.f8734d.add(new b(it2.next()));
                }
            }
        }

        @p0
        public static List<g> e(@n0 i iVar, @p0 List<b> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (b bVar : list) {
                arrayList.add(new g(iVar, bVar.b(), bVar.a(), bVar.d(), e(iVar, bVar.c())));
            }
            return arrayList;
        }

        @n0
        public ExistingWorkPolicy a() {
            return this.f8732b;
        }

        @p0
        public String b() {
            return this.f8731a;
        }

        @p0
        public List<b> c() {
            return this.f8734d;
        }

        @n0
        public List<? extends x> d() {
            return this.f8733c;
        }

        @n0
        public g f(@n0 i iVar) {
            return new g(iVar, b(), a(), d(), e(iVar, c()));
        }

        public b(@p0 String str, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<? extends x> list, @p0 List<b> list2) {
            this.f8731a = str;
            this.f8732b = existingWorkPolicy;
            this.f8733c = list;
            this.f8734d = list2;
        }
    }
}
