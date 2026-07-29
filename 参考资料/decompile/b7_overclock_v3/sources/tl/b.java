package tl;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import hk.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import m0.k;
import okio.ByteString;
import okio.t0;
import okio.v0;
import rl.f;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002D\u0005B5\b\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010A\u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0017\u00106\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010@\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b?\u00103¨\u0006E"}, d2 = {"Ltl/b;", "", "", "upstreamSize", "Lkotlin/z1;", "b", "Lokio/ByteString;", k.f40564b, "Lokio/t0;", "n", "prefix", "metadataSize", "u", "v", "Ljava/io/RandomAccessFile;", m7.a.f40702b, "Ljava/io/RandomAccessFile;", "f", "()Ljava/io/RandomAccessFile;", "p", "(Ljava/io/RandomAccessFile;)V", "upstream", "Lokio/t0;", "h", "()Lokio/t0;", SsManifestParser.e.J, "(Lokio/t0;)V", "upstreamPos", "J", j.f55230b, "()J", an.aB, "(J)V", "bufferMaxSize", "d", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "k", "()Ljava/lang/Thread;", "t", "(Ljava/lang/Thread;)V", "Lokio/j;", "upstreamBuffer", "Lokio/j;", "i", "()Lokio/j;", "", "complete", "Z", "e", "()Z", "o", "(Z)V", "buffer", "c", "", "sourceCount", "I", "g", "()I", "q", "(I)V", l.f16298a, "isClosed", "metadata", "<init>", "(Ljava/io/RandomAccessFile;Lokio/t0;JLokio/ByteString;J)V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final a f51317k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f51318l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f51319m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @e
    @yt.k
    public static final ByteString f51320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @e
    @yt.k
    public static final ByteString f51321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f51322p = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public RandomAccessFile f51323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public t0 f51324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f51325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ByteString f51326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f51327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public Thread f51328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final okio.j f51329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final okio.j f51331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51332j;

    @d0(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0018"}, d2 = {"Ltl/b$a;", "", "Ljava/io/File;", m7.a.f40702b, "Lokio/t0;", "upstream", "Lokio/ByteString;", "metadata", "", "bufferMaxSize", "Ltl/b;", "a", "b", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final b a(@yt.k File file, @yt.k t0 upstream, @yt.k ByteString metadata, long j10) throws IOException {
            f0.p(file, "file");
            f0.p(upstream, "upstream");
            f0.p(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            b bVar = new b(randomAccessFile, upstream, 0L, metadata, j10, null);
            randomAccessFile.setLength(0L);
            bVar.u(b.f51321o, -1L, -1L);
            return bVar;
        }

        @yt.k
        public final b b(@yt.k File file) throws IOException {
            f0.p(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            f0.o(channel, "randomAccessFile.channel");
            tl.a aVar = new tl.a(channel);
            okio.j jVar = new okio.j();
            aVar.a(0L, jVar, 32L);
            if (!f0.g(jVar.y(r1.x0()), b.f51320n)) {
                throw new IOException("unreadable cache file");
            }
            long j10 = jVar.readLong();
            long j11 = jVar.readLong();
            okio.j jVar2 = new okio.j();
            aVar.a(j10 + 32, jVar2, j11);
            return new b(randomAccessFile, null, j10, jVar2.Z0(), 0L, null);
        }
    }

    /* JADX INFO: renamed from: tl.b$b, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Ltl/b$b;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "<init>", "(Ltl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class C0582b implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final v0 f51333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public tl.a f51334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f51335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f51336d;

        public C0582b(b this$0) {
            f0.p(this$0, "this$0");
            this.f51336d = this$0;
            this.f51333a = new v0();
            RandomAccessFile randomAccessFileF = this$0.f();
            f0.m(randomAccessFileF);
            FileChannel channel = randomAccessFileF.getChannel();
            f0.o(channel, "file!!.channel");
            this.f51334b = new tl.a(channel);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        
            if (r4 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        
            r10 = java.lang.Math.min(r21, r19.f51336d.j() - r19.f51335c);
            r2 = r19.f51334b;
            kotlin.jvm.internal.f0.m(r2);
            r2.a(r19.f51335c + 32, r20, r10);
            r19.f51335c += r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        
            return r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
        
            r0 = r19.f51336d.h();
            kotlin.jvm.internal.f0.m(r0);
            r14 = r0.F1(r19.f51336d.i(), r19.f51336d.d());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        
            if (r14 != (-1)) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        
            r0 = r19.f51336d;
            r0.b(r0.j());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
        
            r2 = r19.f51336d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        
            r2.t(null);
            r2.notifyAll();
            r0 = kotlin.z1.f38230a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cf, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
        
            r11 = java.lang.Math.min(r14, r21);
            r19.f51336d.i().u(r20, 0, r11);
            r19.f51335c += r11;
            r13 = r19.f51334b;
            kotlin.jvm.internal.f0.m(r13);
            r13.b(r19.f51336d.j() + 32, r19.f51336d.i().clone(), r14);
            r2 = r19.f51336d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x010b, code lost:
        
            r2.c().V0(r2.i(), r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0124, code lost:
        
            if (r2.c().m2() <= r2.d()) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0126, code lost:
        
            r2.c().skip(r2.c().m2() - r2.d());
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x013a, code lost:
        
            r2.s(r2.j() + r14);
            r0 = kotlin.z1.f38230a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0144, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0145, code lost:
        
            r2 = r19.f51336d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0147, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0148, code lost:
        
            r2.t(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x014e, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x014f, code lost:
        
            return r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0157, code lost:
        
            r2 = r19.f51336d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0159, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
        
            r2.t(null);
            r2.notifyAll();
            r3 = kotlin.z1.f38230a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        
            throw r0;
         */
        @Override // okio.t0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long F1(@yt.k okio.j r20, long r21) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 374
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: tl.b.C0582b.F1(okio.j, long):long");
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return this.f51333a;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f51334b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f51334b = null;
            b bVar = this.f51336d;
            synchronized (bVar) {
                bVar.q(bVar.g() - 1);
                if (bVar.g() == 0) {
                    RandomAccessFile randomAccessFileF = bVar.f();
                    bVar.p(null);
                    randomAccessFile = randomAccessFileF;
                }
                z1 z1Var = z1.f38230a;
            }
            if (randomAccessFile == null) {
                return;
            }
            f.o(randomAccessFile);
        }
    }

    static {
        ByteString.a aVar = ByteString.f44029c;
        f51320n = aVar.l("OkHttp cache v1\n");
        f51321o = aVar.l("OkHttp DIRTY :(\n");
    }

    public b(RandomAccessFile randomAccessFile, t0 t0Var, long j10, ByteString byteString, long j11) {
        this.f51323a = randomAccessFile;
        this.f51324b = t0Var;
        this.f51325c = j10;
        this.f51326d = byteString;
        this.f51327e = j11;
        this.f51329g = new okio.j();
        this.f51330h = this.f51324b == null;
        this.f51331i = new okio.j();
    }

    public /* synthetic */ b(RandomAccessFile randomAccessFile, t0 t0Var, long j10, ByteString byteString, long j11, u uVar) {
        this(randomAccessFile, t0Var, j10, byteString, j11);
    }

    public final void b(long j10) throws IOException {
        v(j10);
        RandomAccessFile randomAccessFile = this.f51323a;
        f0.m(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        u(f51320n, j10, this.f51326d.x0());
        RandomAccessFile randomAccessFile2 = this.f51323a;
        f0.m(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            o(true);
            z1 z1Var = z1.f38230a;
        }
        t0 t0Var = this.f51324b;
        if (t0Var != null) {
            f.o(t0Var);
        }
        this.f51324b = null;
    }

    @yt.k
    public final okio.j c() {
        return this.f51331i;
    }

    public final long d() {
        return this.f51327e;
    }

    public final boolean e() {
        return this.f51330h;
    }

    @yt.l
    public final RandomAccessFile f() {
        return this.f51323a;
    }

    public final int g() {
        return this.f51332j;
    }

    @yt.l
    public final t0 h() {
        return this.f51324b;
    }

    @yt.k
    public final okio.j i() {
        return this.f51329g;
    }

    public final long j() {
        return this.f51325c;
    }

    @yt.l
    public final Thread k() {
        return this.f51328f;
    }

    public final boolean l() {
        return this.f51323a == null;
    }

    @yt.k
    public final ByteString m() {
        return this.f51326d;
    }

    @yt.l
    public final t0 n() {
        synchronized (this) {
            if (f() == null) {
                return null;
            }
            q(g() + 1);
            return new C0582b(this);
        }
    }

    public final void o(boolean z10) {
        this.f51330h = z10;
    }

    public final void p(@yt.l RandomAccessFile randomAccessFile) {
        this.f51323a = randomAccessFile;
    }

    public final void q(int i10) {
        this.f51332j = i10;
    }

    public final void r(@yt.l t0 t0Var) {
        this.f51324b = t0Var;
    }

    public final void s(long j10) {
        this.f51325c = j10;
    }

    public final void t(@yt.l Thread thread) {
        this.f51328f = thread;
    }

    public final void u(ByteString byteString, long j10, long j11) throws IOException {
        okio.j jVar = new okio.j();
        jVar.B1(byteString);
        jVar.writeLong(j10);
        jVar.writeLong(j11);
        if (!(jVar.m2() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.f51323a;
        f0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        f0.o(channel, "file!!.channel");
        new tl.a(channel).b(0L, jVar, 32L);
    }

    public final void v(long j10) throws IOException {
        okio.j jVar = new okio.j();
        jVar.B1(this.f51326d);
        RandomAccessFile randomAccessFile = this.f51323a;
        f0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        f0.o(channel, "file!!.channel");
        new tl.a(channel).b(32 + j10, jVar, this.f51326d.x0());
    }
}
