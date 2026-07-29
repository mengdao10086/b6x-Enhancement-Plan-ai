package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f5607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BackStackRecordState> f5608b;

    public class a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    public BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.f5607a = list;
        this.f5608b = list2;
    }

    @g.n0
    public List<androidx.fragment.app.a> a(@g.n0 FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap map2 = new HashMap(this.f5607a.size());
        for (String str : this.f5607a) {
            Fragment fragment = map.get(str);
            if (fragment != null) {
                map2.put(fragment.f5646f, fragment);
            } else {
                FragmentState fragmentStateC = fragmentManager.H0().C(str, null);
                if (fragmentStateC != null) {
                    Fragment fragmentA = fragmentStateC.a(fragmentManager.G0(), fragmentManager.J0().g().getClassLoader());
                    map2.put(fragmentA.f5646f, fragmentA);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackStackRecordState> it2 = this.f5608b.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().e(fragmentManager, map2));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@g.n0 Parcel parcel, int i10) {
        parcel.writeStringList(this.f5607a);
        parcel.writeTypedList(this.f5608b);
    }

    public BackStackState(@g.n0 Parcel parcel) {
        this.f5607a = parcel.createStringArrayList();
        this.f5608b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
