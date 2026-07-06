package a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oa<T> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mf<ArrayList<T>> f2220a = new nf(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia<T, ArrayList<T>> f6999a = new ia<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<T> f2221a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashSet<T> f2222a = new HashSet<>();

    public void a(T t, T t2) {
        if (!this.f6999a.containsKey(t) || !this.f6999a.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f6999a.get(t);
        if (arrayListF == null) {
            arrayListF = f();
            this.f6999a.put(t, arrayListF);
        }
        arrayListF.add(t2);
    }

    public void b(T t) {
        if (this.f6999a.containsKey(t)) {
            return;
        }
        this.f6999a.put(t, null);
    }

    public void c() {
        int size = this.f6999a.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM = this.f6999a.m(i);
            if (arrayListM != null) {
                k(arrayListM);
            }
        }
        this.f6999a.clear();
    }

    public boolean d(T t) {
        return this.f6999a.containsKey(t);
    }

    public final void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f6999a.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    public final ArrayList<T> f() {
        ArrayList<T> arrayListA = this.f2220a.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    public List g(T t) {
        return this.f6999a.get(t);
    }

    public List<T> h(T t) {
        int size = this.f6999a.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM = this.f6999a.m(i);
            if (arrayListM != null && arrayListM.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f6999a.i(i));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f2221a.clear();
        this.f2222a.clear();
        int size = this.f6999a.size();
        for (int i = 0; i < size; i++) {
            e(this.f6999a.i(i), this.f2221a, this.f2222a);
        }
        return this.f2221a;
    }

    public boolean j(T t) {
        int size = this.f6999a.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListM = this.f6999a.m(i);
            if (arrayListM != null && arrayListM.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2220a.b(arrayList);
    }
}
