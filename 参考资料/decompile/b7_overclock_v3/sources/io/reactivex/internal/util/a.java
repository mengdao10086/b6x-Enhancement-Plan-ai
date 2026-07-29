package io.reactivex.internal.util;

import dj.r;

/* JADX INFO: loaded from: classes5.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f35252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f35253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35254d;

    /* JADX INFO: renamed from: io.reactivex.internal.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0399a<T> extends r<T> {
        @Override // dj.r
        boolean a(T t10);
    }

    public a(int i10) {
        this.f35251a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f35252b = objArr;
        this.f35253c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean a(bu.d<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f35252b
            int r1 = r4.f35251a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(bu.d):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean b(xi.g0<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f35252b
            int r1 = r4.f35251a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.b(xi.g0):boolean");
    }

    public void c(T t10) {
        int i10 = this.f35251a;
        int i11 = this.f35254d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f35253c[i10] = objArr;
            this.f35253c = objArr;
            i11 = 0;
        }
        this.f35253c[i11] = t10;
        this.f35254d = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(io.reactivex.internal.util.a.InterfaceC0399a<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f35252b
            int r1 = r4.f35251a
        L4:
            if (r0 == 0) goto L1d
            r2 = 0
        L7:
            if (r2 >= r1) goto L18
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L18
        Le:
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L15
            return
        L15:
            int r2 = r2 + 1
            goto L7
        L18:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.d(io.reactivex.internal.util.a$a):void");
    }

    public <S> void e(S s10, dj.d<? super S, ? super T> dVar) throws Exception {
        Object[] objArr = this.f35252b;
        int i10 = this.f35251a;
        while (true) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null || dVar.a(s10, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i10];
        }
    }

    public void f(T t10) {
        this.f35252b[0] = t10;
    }
}
