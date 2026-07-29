package d0;

import androidx.annotation.RestrictTo;
import androidx.collection.l;
import androidx.core.util.n;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n.a<ArrayList<T>> f25920a = new n.b(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<T, ArrayList<T>> f25921b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f25922c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<T> f25923d = new HashSet<>();

    public void a(@n0 T t10, @n0 T t11) {
        if (!this.f25921b.containsKey(t10) || !this.f25921b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f25921b.get(t10);
        if (arrayListF == null) {
            arrayListF = f();
            this.f25921b.put(t10, arrayListF);
        }
        arrayListF.add(t11);
    }

    public void b(@n0 T t10) {
        if (this.f25921b.containsKey(t10)) {
            return;
        }
        this.f25921b.put(t10, null);
    }

    public void c() {
        int size = this.f25921b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListO = this.f25921b.o(i10);
            if (arrayListO != null) {
                k(arrayListO);
            }
        }
        this.f25921b.clear();
    }

    public boolean d(@n0 T t10) {
        return this.f25921b.containsKey(t10);
    }

    public final void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (hashSet.contains(t10)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t10);
        ArrayList<T> arrayList2 = this.f25921b.get(t10);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                e(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(t10);
        arrayList.add(t10);
    }

    @n0
    public final ArrayList<T> f() {
        ArrayList<T> arrayListA = this.f25920a.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    @p0
    public List g(@n0 T t10) {
        return this.f25921b.get(t10);
    }

    @p0
    public List<T> h(@n0 T t10) {
        int size = this.f25921b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListO = this.f25921b.o(i10);
            if (arrayListO != null && arrayListO.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f25921b.k(i10));
            }
        }
        return arrayList;
    }

    @n0
    public ArrayList<T> i() {
        this.f25922c.clear();
        this.f25923d.clear();
        int size = this.f25921b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f25921b.k(i10), this.f25922c, this.f25923d);
        }
        return this.f25922c;
    }

    public boolean j(@n0 T t10) {
        int size = this.f25921b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListO = this.f25921b.o(i10);
            if (arrayListO != null && arrayListO.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    public final void k(@n0 ArrayList<T> arrayList) {
        arrayList.clear();
        this.f25920a.b(arrayList);
    }

    public int l() {
        return this.f25921b.size();
    }
}
