package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cb2 implements Iterator<ea2>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5776a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ db2 f374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ea2 f375a;
    public int b;
    public int c;
    public int d;

    public cb2(db2 db2Var) {
        this.f374a = db2Var;
        int iF = ga2.f(db2Var.f5881a, 0, db2Var.f544a.length());
        this.b = iF;
        this.c = iF;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            int r0 = r6.c
            r1 = 0
            if (r0 >= 0) goto Lc
            r6.f5776a = r1
            r0 = 0
            r6.f375a = r0
            goto L99
        Lc:
            a.db2 r0 = r6.f374a
            int r0 = a.db2.c(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L23
            int r0 = r6.d
            int r0 = r0 + r3
            r6.d = r0
            a.db2 r4 = r6.f374a
            int r4 = a.db2.c(r4)
            if (r0 >= r4) goto L31
        L23:
            int r0 = r6.c
            a.db2 r4 = r6.f374a
            java.lang.CharSequence r4 = a.db2.b(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L47
        L31:
            int r0 = r6.b
            a.ea2 r1 = new a.ea2
            a.db2 r4 = r6.f374a
            java.lang.CharSequence r4 = a.db2.b(r4)
            int r4 = a.ec2.H(r4)
            r1.<init>(r0, r4)
        L42:
            r6.f375a = r1
        L44:
            r6.c = r2
            goto L97
        L47:
            a.db2 r0 = r6.f374a
            a.k82 r0 = a.db2.a(r0)
            a.db2 r4 = r6.f374a
            java.lang.CharSequence r4 = a.db2.b(r4)
            int r5 = r6.c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.d(r4, r5)
            a.d42 r0 = (a.d42) r0
            if (r0 != 0) goto L73
            int r0 = r6.b
            a.ea2 r1 = new a.ea2
            a.db2 r4 = r6.f374a
            java.lang.CharSequence r4 = a.db2.b(r4)
            int r4 = a.ec2.H(r4)
            r1.<init>(r0, r4)
            goto L42
        L73:
            java.lang.Object r2 = r0.a()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.b()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.b
            a.ea2 r4 = a.ga2.i(r4, r2)
            r6.f375a = r4
            int r2 = r2 + r0
            r6.b = r2
            if (r0 != 0) goto L95
            r1 = r3
        L95:
            int r2 = r2 + r1
            goto L44
        L97:
            r6.f5776a = r3
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.cb2.a():void");
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ea2 next() {
        if (this.f5776a == -1) {
            a();
        }
        if (this.f5776a == 0) {
            throw new NoSuchElementException();
        }
        ea2 ea2Var = this.f375a;
        if (ea2Var == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.f375a = null;
        this.f5776a = -1;
        return ea2Var;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f5776a == -1) {
            a();
        }
        return this.f5776a == 1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
