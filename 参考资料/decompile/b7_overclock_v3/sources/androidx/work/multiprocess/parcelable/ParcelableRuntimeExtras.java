package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import x2.b;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableRuntimeExtras implements Parcelable {
    public static final Parcelable.Creator<ParcelableRuntimeExtras> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WorkerParameters.a f8726a;

    public class a implements Parcelable.Creator<ParcelableRuntimeExtras> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableRuntimeExtras createFromParcel(Parcel parcel) {
            return new ParcelableRuntimeExtras(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableRuntimeExtras[] newArray(int i10) {
            return new ParcelableRuntimeExtras[i10];
        }
    }

    public ParcelableRuntimeExtras(@n0 WorkerParameters.a aVar) {
        this.f8726a = aVar;
    }

    @n0
    public WorkerParameters.a a() {
        return this.f8726a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        List<String> list;
        int i11 = Build.VERSION.SDK_INT;
        List<Uri> list2 = null;
        Network network = i11 >= 28 ? this.f8726a.f8311c : null;
        boolean z10 = network != null;
        b.b(parcel, z10);
        if (z10) {
            parcel.writeParcelable(network, i10);
        }
        if (i11 >= 24) {
            WorkerParameters.a aVar = this.f8726a;
            list2 = aVar.f8310b;
            list = aVar.f8309a;
        } else {
            list = null;
        }
        boolean z11 = (list2 == null || list2.isEmpty()) ? false : true;
        b.b(parcel, z11);
        if (z11) {
            int size = list2.size();
            Uri[] uriArr = new Uri[size];
            for (int i12 = 0; i12 < size; i12++) {
                uriArr[i12] = list2.get(i12);
            }
            parcel.writeParcelableArray(uriArr, i10);
        }
        boolean z12 = (list == null || list.isEmpty()) ? false : true;
        b.b(parcel, z12);
        if (z12) {
            parcel.writeStringList(list);
        }
    }

    public ParcelableRuntimeExtras(@n0 Parcel parcel) {
        ArrayList arrayList;
        ClassLoader classLoader = getClass().getClassLoader();
        Network network = b.a(parcel) ? (Network) parcel.readParcelable(classLoader) : null;
        if (b.a(parcel)) {
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((Uri) parcelable);
            }
        } else {
            arrayList = null;
        }
        ArrayList<String> arrayListCreateStringArrayList = b.a(parcel) ? parcel.createStringArrayList() : null;
        WorkerParameters.a aVar = new WorkerParameters.a();
        this.f8726a = aVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            aVar.f8311c = network;
        }
        if (i10 >= 24) {
            if (arrayList != null) {
                aVar.f8310b = arrayList;
            }
            if (arrayListCreateStringArrayList != null) {
                aVar.f8309a = arrayListCreateStringArrayList;
            }
        }
    }
}
