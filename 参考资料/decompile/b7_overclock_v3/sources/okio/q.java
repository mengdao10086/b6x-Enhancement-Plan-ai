package okio;

import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Closeable;
import java.io.IOException;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002*.B\u000f\u0012\u0006\u0010-\u001a\u00020)¢\u0006\u0004\b2\u00103J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J&\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0018J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0003J\u0010\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001dJ\u0016\u0010!\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\nJ(\u0010#\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH$J(\u0010$\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH$J\b\u0010%\u001a\u00020\nH$J\u0010\u0010&\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003H$J\b\u0010'\u001a\u00020\u0003H$J\b\u0010(\u001a\u00020\nH$R\u0017\u0010-\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010!R\u0016\u00101\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010&¨\u00064"}, d2 = {"Lokio/q;", "Ljava/io/Closeable;", "Lokio/Closeable;", "", "fileOffset", "Lokio/j;", "sink", "byteCount", i1.a.T4, "source", "Lkotlin/z1;", "p1", "", "array", "", "arrayOffset", "P", i1.a.f31577d5, m9.h.f40774q, "size", "F0", "m1", m9.h.B, "flush", "Lokio/t0;", "h1", m0.k.f40564b, CommonNetImpl.POSITION, "b0", "Lokio/r0;", "G0", "i", com.flydigi.sdk.bluetooth.l.f16298a, "Z", "close", an.aD, "M", "u", "I", "L", "n", "", "a", "k", "()Z", "readWrite", "b", "closed", "c", "openStreamCount", "<init>", "(Z)V", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class q implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f44181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f44182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44183c;

    @kotlin.d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\r\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lokio/q$a;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "Lokio/q;", "a", "Lokio/q;", "c", "()Lokio/q;", "fileHandle", "b", "J", "d", "()J", "h", "(J)V", CommonNetImpl.POSITION, "", "Z", "()Z", "f", "(Z)V", "closed", "<init>", "(Lokio/q;J)V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final q f44184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f44185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f44186c;

        public a(@yt.k q fileHandle, long j10) {
            kotlin.jvm.internal.f0.p(fileHandle, "fileHandle");
            this.f44184a = fileHandle;
            this.f44185b = j10;
        }

        @Override // okio.r0
        @yt.k
        public v0 U() {
            return v0.f44220e;
        }

        @Override // okio.r0
        public void V0(@yt.k j source, long j10) throws IOException {
            kotlin.jvm.internal.f0.p(source, "source");
            if (!(!this.f44186c)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f44184a.p1(this.f44185b, source, j10);
            this.f44185b += j10;
        }

        public final boolean a() {
            return this.f44186c;
        }

        @yt.k
        public final q c() {
            return this.f44184a;
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f44186c) {
                return;
            }
            this.f44186c = true;
            synchronized (this.f44184a) {
                q qVarC = c();
                qVarC.f44183c--;
                if (c().f44183c == 0 && c().f44182b) {
                    z1 z1Var = z1.f38230a;
                    this.f44184a.n();
                }
            }
        }

        public final long d() {
            return this.f44185b;
        }

        public final void f(boolean z10) {
            this.f44186c = z10;
        }

        @Override // okio.r0, java.io.Flushable
        public void flush() throws IOException {
            if (!(!this.f44186c)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f44184a.u();
        }

        public final void h(long j10) {
            this.f44185b = j10;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lokio/q$b;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "Lokio/q;", "a", "Lokio/q;", "c", "()Lokio/q;", "fileHandle", "b", "J", "d", "()J", "h", "(J)V", CommonNetImpl.POSITION, "", "Z", "()Z", "f", "(Z)V", "closed", "<init>", "(Lokio/q;J)V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final q f44187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f44188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f44189c;

        public b(@yt.k q fileHandle, long j10) {
            kotlin.jvm.internal.f0.p(fileHandle, "fileHandle");
            this.f44187a = fileHandle;
            this.f44188b = j10;
        }

        @Override // okio.t0
        public long F1(@yt.k j sink, long j10) throws IOException {
            kotlin.jvm.internal.f0.p(sink, "sink");
            if (!(!this.f44189c)) {
                throw new IllegalStateException("closed".toString());
            }
            long jW = this.f44187a.W(this.f44188b, sink, j10);
            if (jW != -1) {
                this.f44188b += jW;
            }
            return jW;
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return v0.f44220e;
        }

        public final boolean a() {
            return this.f44189c;
        }

        @yt.k
        public final q c() {
            return this.f44187a;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f44189c) {
                return;
            }
            this.f44189c = true;
            synchronized (this.f44187a) {
                q qVarC = c();
                qVarC.f44183c--;
                if (c().f44183c == 0 && c().f44182b) {
                    z1 z1Var = z1.f38230a;
                    this.f44187a.n();
                }
            }
        }

        public final long d() {
            return this.f44188b;
        }

        public final void f(boolean z10) {
            this.f44189c = z10;
        }

        public final void h(long j10) {
            this.f44188b = j10;
        }
    }

    public q(boolean z10) {
        this.f44181a = z10;
    }

    public static /* synthetic */ r0 M0(q qVar, long j10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        return qVar.G0(j10);
    }

    public static /* synthetic */ t0 i1(q qVar, long j10, int i10, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        return qVar.h1(j10);
    }

    public final void F0(long j10) throws IOException {
        if (!this.f44181a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        I(j10);
    }

    @yt.k
    public final r0 G0(long j10) throws IOException {
        if (!this.f44181a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f44183c++;
        }
        return new a(this, j10);
    }

    public abstract void I(long j10) throws IOException;

    public abstract long L() throws IOException;

    public abstract void M(long j10, @yt.k byte[] bArr, int i10, int i11) throws IOException;

    public final int P(long j10, @yt.k byte[] array, int i10, int i11) throws IOException {
        kotlin.jvm.internal.f0.p(array, "array");
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        return z(j10, array, i10, i11);
    }

    public final long T(long j10, @yt.k j sink, long j11) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        return W(j10, sink, j11);
    }

    public final long W(long j10, j jVar, long j11) throws IOException {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j11)).toString());
        }
        long j12 = j10 + j11;
        long j13 = j10;
        while (true) {
            if (j13 >= j12) {
                break;
            }
            p0 p0VarP2 = jVar.p2(1);
            int iZ = z(j13, p0VarP2.f44174a, p0VarP2.f44176c, (int) Math.min(j12 - j13, 8192 - r8));
            if (iZ == -1) {
                if (p0VarP2.f44175b == p0VarP2.f44176c) {
                    jVar.f44116a = p0VarP2.b();
                    q0.d(p0VarP2);
                }
                if (j10 == j13) {
                    return -1L;
                }
            } else {
                p0VarP2.f44176c += iZ;
                long j14 = iZ;
                j13 += j14;
                jVar.i2(jVar.m2() + j14);
            }
        }
        return j13 - j10;
    }

    public final void Z(@yt.k r0 sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        boolean z10 = false;
        if (!(sink instanceof n0)) {
            if ((sink instanceof a) && ((a) sink).c() == this) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
            }
            a aVar = (a) sink;
            if (!(!aVar.a())) {
                throw new IllegalStateException("closed".toString());
            }
            aVar.h(j10);
            return;
        }
        n0 n0Var = (n0) sink;
        r0 r0Var = n0Var.f44160a;
        if ((r0Var instanceof a) && ((a) r0Var).c() == this) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        a aVar2 = (a) r0Var;
        if (!(!aVar2.a())) {
            throw new IllegalStateException("closed".toString());
        }
        n0Var.E();
        aVar2.h(j10);
    }

    public final void b0(@yt.k t0 source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        boolean z10 = false;
        if (!(source instanceof o0)) {
            if ((source instanceof b) && ((b) source).c() == this) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            b bVar = (b) source;
            if (!(!bVar.a())) {
                throw new IllegalStateException("closed".toString());
            }
            bVar.h(j10);
            return;
        }
        o0 o0Var = (o0) source;
        t0 t0Var = o0Var.f44167a;
        if (!((t0Var instanceof b) && ((b) t0Var).c() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        b bVar2 = (b) t0Var;
        if (!(!bVar2.a())) {
            throw new IllegalStateException("closed".toString());
        }
        long jM2 = o0Var.f44168b.m2();
        long jD = j10 - (bVar2.d() - jM2);
        if (0 <= jD && jD < jM2) {
            z10 = true;
        }
        if (z10) {
            o0Var.skip(jD);
        } else {
            o0Var.f44168b.d();
            bVar2.h(j10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.f44182b) {
                return;
            }
            this.f44182b = true;
            if (this.f44183c != 0) {
                return;
            }
            z1 z1Var = z1.f38230a;
            n();
        }
    }

    public final long d1() throws IOException {
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        return L();
    }

    public final void flush() throws IOException {
        if (!this.f44181a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        u();
    }

    @yt.k
    public final t0 h1(long j10) throws IOException {
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f44183c++;
        }
        return new b(this, j10);
    }

    @yt.k
    public final r0 i() throws IOException {
        return G0(d1());
    }

    public final boolean k() {
        return this.f44181a;
    }

    public final void k1(long j10, @yt.k j source, long j11) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        if (!this.f44181a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        p1(j10, source, j11);
    }

    public final long l(@yt.k r0 sink) throws IOException {
        long jM2;
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (sink instanceof n0) {
            n0 n0Var = (n0) sink;
            jM2 = n0Var.f44161b.m2();
            sink = n0Var.f44160a;
        } else {
            jM2 = 0;
        }
        if (!((sink instanceof a) && ((a) sink).c() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        a aVar = (a) sink;
        if (!aVar.a()) {
            return aVar.d() + jM2;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final long m(@yt.k t0 source) throws IOException {
        long jM2;
        kotlin.jvm.internal.f0.p(source, "source");
        if (source instanceof o0) {
            o0 o0Var = (o0) source;
            jM2 = o0Var.f44168b.m2();
            source = o0Var.f44167a;
        } else {
            jM2 = 0;
        }
        if (!((source instanceof b) && ((b) source).c() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        b bVar = (b) source;
        if (!bVar.a()) {
            return bVar.d() - jM2;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void m1(long j10, @yt.k byte[] array, int i10, int i11) throws IOException {
        kotlin.jvm.internal.f0.p(array, "array");
        if (!this.f44181a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.f44182b)) {
                throw new IllegalStateException("closed".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        M(j10, array, i10, i11);
    }

    public abstract void n() throws IOException;

    public final void p1(long j10, j jVar, long j11) throws IOException {
        a1.e(jVar.m2(), 0L, j11);
        long j12 = j11 + j10;
        while (j10 < j12) {
            p0 p0Var = jVar.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            int iMin = (int) Math.min(j12 - j10, p0Var.f44176c - p0Var.f44175b);
            M(j10, p0Var.f44174a, p0Var.f44175b, iMin);
            p0Var.f44175b += iMin;
            long j13 = iMin;
            j10 += j13;
            jVar.i2(jVar.m2() - j13);
            if (p0Var.f44175b == p0Var.f44176c) {
                jVar.f44116a = p0Var.b();
                q0.d(p0Var);
            }
        }
    }

    public abstract void u() throws IOException;

    public abstract int z(long j10, @yt.k byte[] bArr, int i10, int i11) throws IOException;
}
