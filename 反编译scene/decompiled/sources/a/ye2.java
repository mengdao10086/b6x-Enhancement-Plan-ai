package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ye2 implements Runnable, Comparable<ye2>, re2, vi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7976a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3687a;

    public ye2(long j) {
        this.f3686a = j;
    }

    @Override // a.vi2
    public int a() {
        return this.f7976a;
    }

    @Override // a.re2
    public final synchronized void b() {
        Object obj = this.f3687a;
        if (obj == df2.f5894a) {
            return;
        }
        if (!(obj instanceof ze2)) {
            obj = null;
        }
        ze2 ze2Var = (ze2) obj;
        if (ze2Var != null) {
            ze2Var.g(this);
        }
        this.f3687a = df2.f5894a;
    }

    @Override // a.vi2
    public ui2<?> c() {
        Object obj = this.f3687a;
        if (!(obj instanceof ui2)) {
            obj = null;
        }
        return (ui2) obj;
    }

    @Override // a.vi2
    public void d(ui2<?> ui2Var) {
        if (!(this.f3687a != df2.f5894a)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.f3687a = ui2Var;
    }

    @Override // a.vi2
    public void f(int i) {
        this.f7976a = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(ye2 ye2Var) {
        long j = this.f3686a - ye2Var.f3686a;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0040 A[Catch: all -> 0x004a, TryCatch #0 {, blocks: (B:9:0x000d, B:17:0x0021, B:25:0x0037, B:27:0x0040, B:28:0x0044, B:18:0x0024, B:22:0x002e), top: B:37:0x000d, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized int h(long r8, a.ze2 r10, a.af2 r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Object r0 = r7.f3687a     // Catch: java.lang.Throwable -> L4d
            a.li2 r1 = a.df2.b()     // Catch: java.lang.Throwable -> L4d
            if (r0 != r1) goto Lc
            r8 = 2
        La:
            monitor-exit(r7)
            return r8
        Lc:
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L4d
            a.vi2 r0 = r10.b()     // Catch: java.lang.Throwable -> L4a
            a.ye2 r0 = (a.ye2) r0     // Catch: java.lang.Throwable -> L4a
            boolean r11 = a.af2.L(r11)     // Catch: java.lang.Throwable -> L4a
            if (r11 == 0) goto L1d
            r8 = 1
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r7)
            return r8
        L1d:
            r1 = 0
            if (r0 != 0) goto L24
        L21:
            r10.f8065a = r8     // Catch: java.lang.Throwable -> L4a
            goto L37
        L24:
            long r3 = r0.f3686a     // Catch: java.lang.Throwable -> L4a
            long r5 = r3 - r8
            int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r11 < 0) goto L2d
            goto L2e
        L2d:
            r8 = r3
        L2e:
            long r3 = r10.f8065a     // Catch: java.lang.Throwable -> L4a
            long r3 = r8 - r3
            int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r11 <= 0) goto L37
            goto L21
        L37:
            long r8 = r7.f3686a     // Catch: java.lang.Throwable -> L4a
            long r3 = r10.f8065a     // Catch: java.lang.Throwable -> L4a
            long r8 = r8 - r3
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L44
            long r8 = r10.f8065a     // Catch: java.lang.Throwable -> L4a
            r7.f3686a = r8     // Catch: java.lang.Throwable -> L4a
        L44:
            r10.a(r7)     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
            r8 = 0
            goto La
        L4a:
            r8 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L4d
            throw r8     // Catch: java.lang.Throwable -> L4d
        L4d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ye2.h(long, a.ze2, a.af2):int");
    }

    public final boolean i(long j) {
        return j - this.f3686a >= 0;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f3686a + ']';
    }
}
