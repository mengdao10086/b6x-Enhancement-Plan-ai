package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a<T>> f6920b = new SparseArray<>(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a<T> f6921c;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f6922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a<T> f6925d;

        public a(Class<T> cls, int i10) {
            this.f6922a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        }

        public boolean a(int i10) {
            int i11 = this.f6923b;
            return i11 <= i10 && i10 < i11 + this.f6924c;
        }

        public T b(int i10) {
            return this.f6922a[i10 - this.f6923b];
        }
    }

    public f0(int i10) {
        this.f6919a = i10;
    }

    public a<T> a(a<T> aVar) {
        int iIndexOfKey = this.f6920b.indexOfKey(aVar.f6923b);
        if (iIndexOfKey < 0) {
            this.f6920b.put(aVar.f6923b, aVar);
            return null;
        }
        a<T> aVarValueAt = this.f6920b.valueAt(iIndexOfKey);
        this.f6920b.setValueAt(iIndexOfKey, aVar);
        if (this.f6921c == aVarValueAt) {
            this.f6921c = aVar;
        }
        return aVarValueAt;
    }

    public void b() {
        this.f6920b.clear();
    }

    public a<T> c(int i10) {
        return this.f6920b.valueAt(i10);
    }

    public T d(int i10) {
        a<T> aVar = this.f6921c;
        if (aVar == null || !aVar.a(i10)) {
            int iIndexOfKey = this.f6920b.indexOfKey(i10 - (i10 % this.f6919a));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.f6921c = this.f6920b.valueAt(iIndexOfKey);
        }
        return this.f6921c.b(i10);
    }

    public a<T> e(int i10) {
        a<T> aVar = this.f6920b.get(i10);
        if (this.f6921c == aVar) {
            this.f6921c = null;
        }
        this.f6920b.delete(i10);
        return aVar;
    }

    public int f() {
        return this.f6920b.size();
    }
}
