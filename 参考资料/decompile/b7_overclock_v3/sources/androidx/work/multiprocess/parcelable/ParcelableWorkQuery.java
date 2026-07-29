package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.w;
import g.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import u2.x;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkQuery implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkQuery> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8738a;

    public class a implements Parcelable.Creator<ParcelableWorkQuery> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkQuery createFromParcel(Parcel parcel) {
            return new ParcelableWorkQuery(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkQuery[] newArray(int i10) {
            return new ParcelableWorkQuery[i10];
        }
    }

    public ParcelableWorkQuery(@n0 w wVar) {
        this.f8738a = wVar;
    }

    @n0
    public w a() {
        return this.f8738a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        List<UUID> listA = this.f8738a.a();
        parcel.writeInt(listA.size());
        if (!listA.isEmpty()) {
            Iterator<UUID> it2 = listA.iterator();
            while (it2.hasNext()) {
                parcel.writeString(it2.next().toString());
            }
        }
        parcel.writeStringList(this.f8738a.d());
        parcel.writeStringList(this.f8738a.c());
        List<WorkInfo.State> listB = this.f8738a.b();
        parcel.writeInt(listB.size());
        if (listB.isEmpty()) {
            return;
        }
        Iterator<WorkInfo.State> it3 = listB.iterator();
        while (it3.hasNext()) {
            parcel.writeInt(x.j(it3.next()));
        }
    }

    public ParcelableWorkQuery(@n0 Parcel parcel) {
        List listEmptyList = Collections.emptyList();
        int i10 = parcel.readInt();
        if (i10 > 0) {
            listEmptyList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                listEmptyList.add(UUID.fromString(parcel.readString()));
            }
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
        List<WorkInfo.State> listEmptyList2 = Collections.emptyList();
        int i12 = parcel.readInt();
        if (i12 > 0) {
            listEmptyList2 = new ArrayList<>(i12);
            for (int i13 = 0; i13 < i12; i13++) {
                listEmptyList2.add(x.g(parcel.readInt()));
            }
        }
        this.f8738a = w.a.f(listEmptyList).d(arrayListCreateStringArrayList).c(arrayListCreateStringArrayList2).b(listEmptyList2).e();
    }
}
