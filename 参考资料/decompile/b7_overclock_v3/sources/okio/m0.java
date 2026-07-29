package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b0\u00101J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\u000f\u001a\u00020\u0004*\u00020\u00022\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\b\rH\u0082\bR\u001a\u0010\u0014\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010&\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028G¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b,\u0010\u0007R\u0017\u0010/\u001a\u00020\b8G¢\u0006\f\n\u0004\b(\u0010-\u001a\u0004\b.\u0010\n¨\u00062"}, d2 = {"Lokio/m0;", "", "Lokio/r0;", "sink", "Lkotlin/z1;", "d", "a", "()Lokio/r0;", "Lokio/t0;", "b", "()Lokio/t0;", "c", "Lkotlin/Function1;", "Lkotlin/t;", "block", "e", "", "J", "i", "()J", "maxBufferSize", "Lokio/j;", "Lokio/j;", "f", "()Lokio/j;", "buffer", "", "Z", "g", "()Z", com.flydigi.sdk.bluetooth.l.f16298a, "(Z)V", "canceled", xf.j.f55230b, "n", "sinkClosed", "k", "o", "sourceClosed", "Lokio/r0;", "h", m0.k.f40564b, "(Lokio/r0;)V", "foldedSink", "p", "Lokio/t0;", "q", "source", "<init>", "(J)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f44142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final j f44143b = new j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f44145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f44146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public r0 f44147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final r0 f44148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final t0 f44149h;

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"okio/m0$a", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "Lokio/v0;", "U", "a", "Lokio/v0;", "timeout", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final v0 f44150a = new v0();

        public a() {
        }

        @Override // okio.r0
        @yt.k
        public v0 U() {
            return this.f44150a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
        
            r1 = kotlin.z1.f38230a;
         */
        @Override // okio.r0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void V0(@yt.k okio.j r13, long r14) {
            /*
                Method dump skipped, instruction units count: 291
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.m0.a.V0(okio.j, long):void");
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            j jVarF = m0.this.f();
            m0 m0Var = m0.this;
            synchronized (jVarF) {
                if (m0Var.j()) {
                    return;
                }
                r0 r0VarH = m0Var.h();
                if (r0VarH == null) {
                    if (m0Var.k() && m0Var.f().m2() > 0) {
                        throw new IOException("source is closed");
                    }
                    m0Var.n(true);
                    m0Var.f().notifyAll();
                    r0VarH = null;
                }
                z1 z1Var = z1.f38230a;
                if (r0VarH == null) {
                    return;
                }
                m0 m0Var2 = m0.this;
                v0 v0VarU = r0VarH.U();
                v0 v0VarU2 = m0Var2.p().U();
                long j10 = v0VarU.j();
                long jA = v0.f44219d.a(v0VarU2.j(), v0VarU.j());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                v0VarU.i(jA, timeUnit);
                if (!v0VarU.f()) {
                    if (v0VarU2.f()) {
                        v0VarU.e(v0VarU2.d());
                    }
                    try {
                        r0VarH.close();
                        v0VarU.i(j10, timeUnit);
                        if (v0VarU2.f()) {
                            v0VarU.a();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        v0VarU.i(j10, TimeUnit.NANOSECONDS);
                        if (v0VarU2.f()) {
                            v0VarU.a();
                        }
                        throw th2;
                    }
                }
                long jD = v0VarU.d();
                if (v0VarU2.f()) {
                    v0VarU.e(Math.min(v0VarU.d(), v0VarU2.d()));
                }
                try {
                    r0VarH.close();
                    v0VarU.i(j10, timeUnit);
                    if (v0VarU2.f()) {
                        v0VarU.e(jD);
                    }
                } catch (Throwable th3) {
                    v0VarU.i(j10, TimeUnit.NANOSECONDS);
                    if (v0VarU2.f()) {
                        v0VarU.e(jD);
                    }
                    throw th3;
                }
            }
        }

        @Override // okio.r0, java.io.Flushable
        public void flush() {
            r0 r0VarH;
            j jVarF = m0.this.f();
            m0 m0Var = m0.this;
            synchronized (jVarF) {
                if (!(!m0Var.j())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (m0Var.g()) {
                    throw new IOException("canceled");
                }
                r0VarH = m0Var.h();
                if (r0VarH == null) {
                    if (m0Var.k() && m0Var.f().m2() > 0) {
                        throw new IOException("source is closed");
                    }
                    r0VarH = null;
                }
                z1 z1Var = z1.f38230a;
            }
            if (r0VarH == null) {
                return;
            }
            m0 m0Var2 = m0.this;
            v0 v0VarU = r0VarH.U();
            v0 v0VarU2 = m0Var2.p().U();
            long j10 = v0VarU.j();
            long jA = v0.f44219d.a(v0VarU2.j(), v0VarU.j());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            v0VarU.i(jA, timeUnit);
            if (!v0VarU.f()) {
                if (v0VarU2.f()) {
                    v0VarU.e(v0VarU2.d());
                }
                try {
                    r0VarH.flush();
                    v0VarU.i(j10, timeUnit);
                    if (v0VarU2.f()) {
                        v0VarU.a();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    v0VarU.i(j10, TimeUnit.NANOSECONDS);
                    if (v0VarU2.f()) {
                        v0VarU.a();
                    }
                    throw th2;
                }
            }
            long jD = v0VarU.d();
            if (v0VarU2.f()) {
                v0VarU.e(Math.min(v0VarU.d(), v0VarU2.d()));
            }
            try {
                r0VarH.flush();
                v0VarU.i(j10, timeUnit);
                if (v0VarU2.f()) {
                    v0VarU.e(jD);
                }
            } catch (Throwable th3) {
                v0VarU.i(j10, TimeUnit.NANOSECONDS);
                if (v0VarU2.f()) {
                    v0VarU.e(jD);
                }
                throw th3;
            }
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"okio/m0$b", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "Lokio/v0;", "U", "a", "Lokio/v0;", "timeout", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final v0 f44152a = new v0();

        public b() {
        }

        @Override // okio.t0
        public long F1(@yt.k j sink, long j10) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            j jVarF = m0.this.f();
            m0 m0Var = m0.this;
            synchronized (jVarF) {
                if (!(!m0Var.k())) {
                    throw new IllegalStateException("closed".toString());
                }
                if (m0Var.g()) {
                    throw new IOException("canceled");
                }
                while (m0Var.f().m2() == 0) {
                    if (m0Var.j()) {
                        return -1L;
                    }
                    this.f44152a.k(m0Var.f());
                    if (m0Var.g()) {
                        throw new IOException("canceled");
                    }
                }
                long jF1 = m0Var.f().F1(sink, j10);
                m0Var.f().notifyAll();
                return jF1;
            }
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return this.f44152a;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            j jVarF = m0.this.f();
            m0 m0Var = m0.this;
            synchronized (jVarF) {
                m0Var.o(true);
                m0Var.f().notifyAll();
                z1 z1Var = z1.f38230a;
            }
        }
    }

    public m0(long j10) {
        this.f44142a = j10;
        if (!(j10 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("maxBufferSize < 1: ", Long.valueOf(i())).toString());
        }
        this.f44148g = new a();
        this.f44149h = new b();
    }

    @hk.h(name = "-deprecated_sink")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "sink", imports = {}))
    @yt.k
    public final r0 a() {
        return this.f44148g;
    }

    @hk.h(name = "-deprecated_source")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "source", imports = {}))
    @yt.k
    public final t0 b() {
        return this.f44149h;
    }

    public final void c() {
        synchronized (this.f44143b) {
            l(true);
            f().d();
            f().notifyAll();
            z1 z1Var = z1.f38230a;
        }
    }

    public final void d(@yt.k r0 sink) throws IOException {
        boolean zJ;
        j jVar;
        kotlin.jvm.internal.f0.p(sink, "sink");
        while (true) {
            synchronized (this.f44143b) {
                if (!(h() == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (g()) {
                    m(sink);
                    throw new IOException("canceled");
                }
                if (f().d0()) {
                    o(true);
                    m(sink);
                    return;
                } else {
                    zJ = j();
                    jVar = new j();
                    jVar.V0(f(), f().m2());
                    f().notifyAll();
                    z1 z1Var = z1.f38230a;
                }
            }
            try {
                sink.V0(jVar, jVar.m2());
                if (zJ) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th2) {
                synchronized (this.f44143b) {
                    o(true);
                    f().notifyAll();
                    z1 z1Var2 = z1.f38230a;
                    throw th2;
                }
            }
        }
    }

    public final void e(r0 r0Var, ik.l<? super r0, z1> lVar) {
        v0 v0VarU = r0Var.U();
        v0 v0VarU2 = p().U();
        long j10 = v0VarU.j();
        long jA = v0.f44219d.a(v0VarU2.j(), v0VarU.j());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        v0VarU.i(jA, timeUnit);
        if (!v0VarU.f()) {
            if (v0VarU2.f()) {
                v0VarU.e(v0VarU2.d());
            }
            try {
                lVar.i(r0Var);
                z1 z1Var = z1.f38230a;
                kotlin.jvm.internal.c0.d(1);
                v0VarU.i(j10, timeUnit);
                if (v0VarU2.f()) {
                    v0VarU.a();
                }
                kotlin.jvm.internal.c0.c(1);
                return;
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                v0VarU.i(j10, TimeUnit.NANOSECONDS);
                if (v0VarU2.f()) {
                    v0VarU.a();
                }
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        long jD = v0VarU.d();
        if (v0VarU2.f()) {
            v0VarU.e(Math.min(v0VarU.d(), v0VarU2.d()));
        }
        try {
            lVar.i(r0Var);
            z1 z1Var2 = z1.f38230a;
            kotlin.jvm.internal.c0.d(1);
            v0VarU.i(j10, timeUnit);
            if (v0VarU2.f()) {
                v0VarU.e(jD);
            }
            kotlin.jvm.internal.c0.c(1);
        } catch (Throwable th3) {
            kotlin.jvm.internal.c0.d(1);
            v0VarU.i(j10, TimeUnit.NANOSECONDS);
            if (v0VarU2.f()) {
                v0VarU.e(jD);
            }
            kotlin.jvm.internal.c0.c(1);
            throw th3;
        }
    }

    @yt.k
    public final j f() {
        return this.f44143b;
    }

    public final boolean g() {
        return this.f44144c;
    }

    @yt.l
    public final r0 h() {
        return this.f44147f;
    }

    public final long i() {
        return this.f44142a;
    }

    public final boolean j() {
        return this.f44145d;
    }

    public final boolean k() {
        return this.f44146e;
    }

    public final void l(boolean z10) {
        this.f44144c = z10;
    }

    public final void m(@yt.l r0 r0Var) {
        this.f44147f = r0Var;
    }

    public final void n(boolean z10) {
        this.f44145d = z10;
    }

    public final void o(boolean z10) {
        this.f44146e = z10;
    }

    @hk.h(name = "sink")
    @yt.k
    public final r0 p() {
        return this.f44148g;
    }

    @hk.h(name = "source")
    @yt.k
    public final t0 q() {
        return this.f44149h;
    }
}
