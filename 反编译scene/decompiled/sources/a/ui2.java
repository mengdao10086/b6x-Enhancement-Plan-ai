package a;

import a.vi2;
import java.lang.Comparable;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ui2<T extends vi2 & Comparable<? super T>> {
    public volatile int _size = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f7602a;

    public final void a(T t) {
        if (be2.a()) {
            if (!(t.c() == null)) {
                throw new AssertionError();
            }
        }
        t.d(this);
        vi2[] vi2VarArrF = f();
        int iC = c();
        j(iC + 1);
        vi2VarArrF[iC] = t;
        t.f(iC);
        l(iC);
    }

    public final T b() {
        T[] tArr = this.f7602a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T t;
        synchronized (this) {
            t = (T) b();
        }
        return t;
    }

    public final T[] f() {
        T[] tArr = this.f7602a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new vi2[4];
            this.f7602a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        f92.c(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((vi2[]) objArrCopyOf);
        this.f7602a = tArr3;
        return tArr3;
    }

    public final boolean g(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.c() == null) {
                z = false;
            } else {
                int iA = t.a();
                if (be2.a()) {
                    if (!(iA >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(iA);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T h(int r8) {
        /*
            r7 = this;
            boolean r0 = a.be2.a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1a
            int r0 = r7.c()
            if (r0 <= 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 == 0) goto L14
            goto L1a
        L14:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L1a:
            T extends a.vi2 & java.lang.Comparable<? super T>[] r0 = r7.f7602a
            a.f92.b(r0)
            int r3 = r7.c()
            r4 = -1
            int r3 = r3 + r4
            r7.j(r3)
            int r3 = r7.c()
            if (r8 >= r3) goto L57
            int r3 = r7.c()
            r7.m(r8, r3)
            int r3 = r8 + (-1)
            int r3 = r3 / 2
            if (r8 <= 0) goto L54
            r5 = r0[r8]
            a.f92.b(r5)
            java.lang.Comparable r5 = (java.lang.Comparable) r5
            r6 = r0[r3]
            a.f92.b(r6)
            int r5 = r5.compareTo(r6)
            if (r5 >= 0) goto L54
            r7.m(r8, r3)
            r7.l(r3)
            goto L57
        L54:
            r7.k(r8)
        L57:
            int r8 = r7.c()
            r8 = r0[r8]
            a.f92.b(r8)
            boolean r3 = a.be2.a()
            if (r3 == 0) goto L76
            a.ui2 r3 = r8.c()
            if (r3 != r7) goto L6d
            r1 = r2
        L6d:
            if (r1 == 0) goto L70
            goto L76
        L70:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L76:
            r1 = 0
            r8.d(r1)
            r8.f(r4)
            int r2 = r7.c()
            r0[r2] = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ui2.h(int):a.vi2");
    }

    public final T i() {
        T t;
        synchronized (this) {
            t = c() > 0 ? (T) h(0) : null;
        }
        return t;
    }

    public final void j(int i) {
        this._size = i;
    }

    public final void k(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= c()) {
                return;
            }
            T[] tArr = this.f7602a;
            f92.b(tArr);
            int i3 = i2 + 1;
            if (i3 < c()) {
                T t = tArr[i3];
                f92.b(t);
                T t2 = tArr[i2];
                f92.b(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            f92.b(t3);
            T t4 = tArr[i2];
            f92.b(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    public final void l(int i) {
        while (i > 0) {
            T[] tArr = this.f7602a;
            f92.b(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            f92.b(t);
            T t2 = tArr[i];
            f92.b(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    public final void m(int i, int i2) {
        T[] tArr = this.f7602a;
        f92.b(tArr);
        T t = tArr[i2];
        f92.b(t);
        T t2 = tArr[i];
        f92.b(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.f(i);
        t2.f(i2);
    }
}
