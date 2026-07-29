package xl;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;
import okio.t0;
import okio.v0;
import qk.v;
import xl.b;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003!\"\bB\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006#"}, d2 = {"Lxl/f;", "Ljava/io/Closeable;", "Lxl/f$c;", "handler", "Lkotlin/z1;", "d", "", "requireSettings", "c", "close", "", fd.c.f28042f, "flags", "streamId", "k", "padding", "", "Lxl/a;", "i", "f", "n", m0.k.f40564b, an.aD, "I", "u", l.f16298a, "h", "L", "Lokio/l;", "source", "client", "<init>", "(Lokio/l;Z)V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f55538e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final Logger f55539f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final okio.l f55540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final b f55542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final b.a f55543d;

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lxl/f$a;", "", "", fd.c.f28042f, "flags", "padding", "b", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final Logger a() {
            return f.f55539f;
        }

        public final int b(int i10, int i11, int i12) throws IOException {
            if ((i11 & 8) != 0) {
                i10--;
            }
            if (i12 <= i10) {
                return i10 - i12;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i12 + " > remaining length " + i10);
        }
    }

    @d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006#"}, d2 = {"Lxl/f$b;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "Lkotlin/z1;", "close", "i", "", fd.c.f28042f, "I", "d", "()I", m0.k.f40564b, "(I)V", "flags", "a", "k", "streamId", "h", "u", xc.d.f55080k0, "c", l.f16298a, "padding", "f", "n", "Lokio/l;", "source", "<init>", "(Lokio/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final okio.l f55544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f55545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f55546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f55547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f55548e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f55549f;

        public b(@yt.k okio.l source) {
            f0.p(source, "source");
            this.f55544a = source;
        }

        @Override // okio.t0
        public long F1(@yt.k okio.j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            while (true) {
                int i10 = this.f55548e;
                if (i10 != 0) {
                    long jF1 = this.f55544a.F1(sink, Math.min(j10, i10));
                    if (jF1 == -1) {
                        return -1L;
                    }
                    this.f55548e -= (int) jF1;
                    return jF1;
                }
                this.f55544a.skip(this.f55549f);
                this.f55549f = 0;
                if ((this.f55546c & 4) != 0) {
                    return -1L;
                }
                i();
            }
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return this.f55544a.U();
        }

        public final int a() {
            return this.f55546c;
        }

        public final int c() {
            return this.f55548e;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int d() {
            return this.f55545b;
        }

        public final int f() {
            return this.f55549f;
        }

        public final int h() {
            return this.f55547d;
        }

        public final void i() throws IOException {
            int i10 = this.f55547d;
            int iV = rl.f.V(this.f55544a);
            this.f55548e = iV;
            this.f55545b = iV;
            int iD = rl.f.d(this.f55544a.readByte(), 255);
            this.f55546c = rl.f.d(this.f55544a.readByte(), 255);
            a aVar = f.f55538e;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(xl.c.f55398a.c(true, this.f55547d, this.f55545b, iD, this.f55546c));
            }
            int i11 = this.f55544a.readInt() & Integer.MAX_VALUE;
            this.f55547d = i11;
            if (iD == 9) {
                if (i11 != i10) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        public final void k(int i10) {
            this.f55546c = i10;
        }

        public final void l(int i10) {
            this.f55548e = i10;
        }

        public final void m(int i10) {
            this.f55545b = i10;
        }

        public final void n(int i10) {
            this.f55549f = i10;
        }

        public final void u(int i10) {
            this.f55547d = i10;
        }
    }

    @d0(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\tH&J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H&J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J(\u0010&\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0002H&J&\u0010)\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J8\u00100\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020 H&¨\u00061"}, d2 = {"Lxl/f$c;", "", "", "inFinished", "", "streamId", "Lokio/l;", "source", fd.c.f28042f, "Lkotlin/z1;", "g", "associatedStreamId", "", "Lxl/a;", "headerBlock", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "n", "clearPrevious", "Lxl/k;", "settings", "p", "b", "ack", "payload1", "payload2", xf.j.f55230b, "lastGoodStreamId", "Lokio/ByteString;", "debugData", an.aB, "", "windowSizeIncrement", "e", "streamDependency", "weight", "exclusive", "k", "promisedStreamId", "requestHeaders", SsManifestParser.e.J, "", "origin", "protocol", e.f55523k, "port", "maxAge", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface c {
        void b();

        void d(boolean z10, int i10, int i11, @yt.k List<xl.a> list);

        void e(int i10, long j10);

        void f(int i10, @yt.k String str, @yt.k ByteString byteString, @yt.k String str2, int i11, long j10);

        void g(boolean z10, int i10, @yt.k okio.l lVar, int i11) throws IOException;

        void j(boolean z10, int i10, int i11);

        void k(int i10, int i11, int i12, boolean z10);

        void n(int i10, @yt.k ErrorCode errorCode);

        void p(boolean z10, @yt.k k kVar);

        void r(int i10, int i11, @yt.k List<xl.a> list) throws IOException;

        void s(int i10, @yt.k ErrorCode errorCode, @yt.k ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(xl.c.class.getName());
        f0.o(logger, "getLogger(Http2::class.java.name)");
        f55539f = logger;
    }

    public f(@yt.k okio.l source, boolean z10) {
        f0.p(source, "source");
        this.f55540a = source;
        this.f55541b = z10;
        b bVar = new b(source);
        this.f55542c = bVar;
        this.f55543d = new b.a(bVar, 4096, 0, 4, null);
    }

    public final void I(c cVar, int i10, int i11, int i12) throws IOException {
        int i13;
        if (i12 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i11 & 1) != 0) {
            if (i10 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.b();
            return;
        }
        if (i10 % 6 != 0) {
            throw new IOException(f0.C("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i10)));
        }
        k kVar = new k();
        qk.k kVarB1 = v.B1(v.W1(0, i10), 6);
        int iG = kVarB1.g();
        int iJ = kVarB1.j();
        int iL = kVarB1.l();
        if ((iL > 0 && iG <= iJ) || (iL < 0 && iJ <= iG)) {
            while (true) {
                int i14 = iG + iL;
                int iE = rl.f.e(this.f55540a.readShort(), 65535);
                i13 = this.f55540a.readInt();
                if (iE != 2) {
                    if (iE == 3) {
                        iE = 4;
                    } else if (iE == 4) {
                        iE = 7;
                        if (i13 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                    } else if (iE == 5 && (i13 < 16384 || i13 > 16777215)) {
                        break;
                    }
                } else if (i13 != 0 && i13 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                kVar.k(iE, i13);
                if (iG == iJ) {
                    break;
                } else {
                    iG = i14;
                }
            }
            throw new IOException(f0.C("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(i13)));
        }
        cVar.p(false, kVar);
    }

    public final void L(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException(f0.C("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i10)));
        }
        long jF = rl.f.f(this.f55540a.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.e(i12, jF);
    }

    public final boolean c(boolean z10, @yt.k c handler) throws IOException {
        f0.p(handler, "handler");
        try {
            this.f55540a.U1(9L);
            int iV = rl.f.V(this.f55540a);
            if (iV > 16384) {
                throw new IOException(f0.C("FRAME_SIZE_ERROR: ", Integer.valueOf(iV)));
            }
            int iD = rl.f.d(this.f55540a.readByte(), 255);
            int iD2 = rl.f.d(this.f55540a.readByte(), 255);
            int i10 = this.f55540a.readInt() & Integer.MAX_VALUE;
            Logger logger = f55539f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(xl.c.f55398a.c(true, i10, iV, iD, iD2));
            }
            if (z10 && iD != 4) {
                throw new IOException(f0.C("Expected a SETTINGS frame but was ", xl.c.f55398a.b(iD)));
            }
            switch (iD) {
                case 0:
                    f(handler, iV, iD2, i10);
                    return true;
                case 1:
                    k(handler, iV, iD2, i10);
                    return true;
                case 2:
                    n(handler, iV, iD2, i10);
                    return true;
                case 3:
                    z(handler, iV, iD2, i10);
                    return true;
                case 4:
                    I(handler, iV, iD2, i10);
                    return true;
                case 5:
                    u(handler, iV, iD2, i10);
                    return true;
                case 6:
                    l(handler, iV, iD2, i10);
                    return true;
                case 7:
                    h(handler, iV, iD2, i10);
                    return true;
                case 8:
                    L(handler, iV, iD2, i10);
                    return true;
                default:
                    this.f55540a.skip(iV);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f55540a.close();
    }

    public final void d(@yt.k c handler) throws IOException {
        f0.p(handler, "handler");
        if (this.f55541b) {
            if (!c(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        okio.l lVar = this.f55540a;
        ByteString byteString = xl.c.f55399b;
        ByteString byteStringY = lVar.y(byteString.x0());
        Logger logger = f55539f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(rl.f.y(f0.C("<< CONNECTION ", byteStringY.B()), new Object[0]));
        }
        if (!f0.g(byteString, byteStringY)) {
            throw new IOException(f0.C("Expected a connection header but was ", byteStringY.O0()));
        }
    }

    public final void f(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        if ((i11 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (i11 & 8) != 0 ? rl.f.d(this.f55540a.readByte(), 255) : 0;
        cVar.g(z10, i12, this.f55540a, f55538e.b(i10, i11, iD));
        this.f55540a.skip(iD);
    }

    public final void h(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 < 8) {
            throw new IOException(f0.C("TYPE_GOAWAY length < 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i13 = this.f55540a.readInt();
        int i14 = this.f55540a.readInt();
        int i15 = i10 - 8;
        ErrorCode errorCodeA = ErrorCode.Companion.a(i14);
        if (errorCodeA == null) {
            throw new IOException(f0.C("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(i14)));
        }
        ByteString byteStringY = ByteString.f44030d;
        if (i15 > 0) {
            byteStringY = this.f55540a.y(i15);
        }
        cVar.s(i13, errorCodeA, byteStringY);
    }

    public final List<xl.a> i(int i10, int i11, int i12, int i13) throws IOException {
        this.f55542c.l(i10);
        b bVar = this.f55542c;
        bVar.m(bVar.c());
        this.f55542c.n(i11);
        this.f55542c.k(i12);
        this.f55542c.u(i13);
        this.f55543d.l();
        return this.f55543d.e();
    }

    public final void k(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z10 = (i11 & 1) != 0;
        int iD = (i11 & 8) != 0 ? rl.f.d(this.f55540a.readByte(), 255) : 0;
        if ((i11 & 32) != 0) {
            m(cVar, i12);
            i10 -= 5;
        }
        cVar.d(z10, i12, -1, i(f55538e.b(i10, i11, iD), iD, i11, i12));
    }

    public final void l(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 8) {
            throw new IOException(f0.C("TYPE_PING length != 8: ", Integer.valueOf(i10)));
        }
        if (i12 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.j((i11 & 1) != 0, this.f55540a.readInt(), this.f55540a.readInt());
    }

    public final void m(c cVar, int i10) throws IOException {
        int i11 = this.f55540a.readInt();
        cVar.k(i10, i11 & Integer.MAX_VALUE, rl.f.d(this.f55540a.readByte(), 255) + 1, (Integer.MIN_VALUE & i11) != 0);
    }

    public final void n(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 == 5) {
            if (i12 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            m(cVar, i12);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i10 + " != 5");
        }
    }

    public final void u(c cVar, int i10, int i11, int i12) throws IOException {
        if (i12 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (i11 & 8) != 0 ? rl.f.d(this.f55540a.readByte(), 255) : 0;
        cVar.r(i12, this.f55540a.readInt() & Integer.MAX_VALUE, i(f55538e.b(i10 - 4, i11, iD), iD, i11, i12));
    }

    public final void z(c cVar, int i10, int i11, int i12) throws IOException {
        if (i10 != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i10 + " != 4");
        }
        if (i12 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i13 = this.f55540a.readInt();
        ErrorCode errorCodeA = ErrorCode.Companion.a(i13);
        if (errorCodeA == null) {
            throw new IOException(f0.C("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(i13)));
        }
        cVar.n(i12, errorCodeA);
    }
}
