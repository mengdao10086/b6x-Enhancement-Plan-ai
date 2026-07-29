package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4497c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseIntArray f4498a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<Integer, HashSet<WeakReference<a>>> f4499b = new HashMap<>();

    public interface a {
        void a(int key, int newValue, int oldValue);
    }

    public void a(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.f4499b.get(Integer.valueOf(key));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f4499b.put(Integer.valueOf(key), hashSet);
        }
        hashSet.add(new WeakReference<>(listener));
    }

    public void b() {
        this.f4499b.clear();
    }

    public void c(int key, int value) {
        int i10 = this.f4498a.get(key, -1);
        if (i10 == value) {
            return;
        }
        this.f4498a.put(key, value);
        HashSet<WeakReference<a>> hashSet = this.f4499b.get(Integer.valueOf(key));
        if (hashSet == null) {
            return;
        }
        Iterator<WeakReference<a>> it2 = hashSet.iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            a aVar = it2.next().get();
            if (aVar != null) {
                aVar.a(key, value, i10);
            } else {
                z10 = true;
            }
        }
        if (z10) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<a> weakReference : hashSet) {
                if (weakReference.get() == null) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public int d(int key) {
        return this.f4498a.get(key, -1);
    }

    public void e(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.f4499b.get(Integer.valueOf(key));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference<a> weakReference : hashSet) {
            a aVar = weakReference.get();
            if (aVar == null || aVar == listener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void f(a listener) {
        Iterator<Integer> it2 = this.f4499b.keySet().iterator();
        while (it2.hasNext()) {
            e(it2.next().intValue(), listener);
        }
    }
}
