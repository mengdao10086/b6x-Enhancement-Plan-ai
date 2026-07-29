package hd;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f31229a = new SparseBooleanArray();

    public void a(int i10) {
        this.f31229a.append(i10, true);
    }

    public void b() {
        this.f31229a.clear();
    }

    public boolean c(int i10) {
        return this.f31229a.get(i10);
    }

    public boolean d(int... iArr) {
        for (int i10 : iArr) {
            if (c(i10)) {
                return true;
            }
        }
        return false;
    }

    public int e(int i10) {
        a.a(i10 >= 0 && i10 < f());
        return this.f31229a.keyAt(i10);
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f31229a.equals(((x) obj).f31229a);
        }
        return false;
    }

    public int f() {
        return this.f31229a.size();
    }

    public int hashCode() {
        return this.f31229a.hashCode();
    }
}
