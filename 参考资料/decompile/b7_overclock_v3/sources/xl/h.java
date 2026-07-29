package xl;

import com.flydigi.sdk.bluetooth.l;
import com.umeng.analytics.pro.an;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.internal.http2.ErrorCode;
import xl.b;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00107\u001a\u00020\u0013¢\u0006\u0004\b8\u00109J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J(\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0007J(\u0010\u001b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0004J\u001e\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007J\u001e\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#J\u0016\u0010(\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&J&\u0010+\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J$\u0010.\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010/\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020&H\u0002R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Lxl/h;", "Ljava/io/Closeable;", "Lkotlin/z1;", "c", "Lxl/k;", "peerSettings", "a", "", "streamId", "promisedStreamId", "", "Lxl/a;", "requestHeaders", "u", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", an.aD, m0.k.f40564b, "", "outFinished", "Lokio/j;", "source", "byteCount", "d", "flags", "buffer", "f", "settings", "I", "ack", "payload1", "payload2", "n", "lastGoodStreamId", "", "debugData", "k", "", "windowSizeIncrement", "L", fd.c.f28042f, "type", "h", "close", "headerBlock", l.f16298a, "M", "Lxl/b$b;", "hpackWriter", "Lxl/b$b;", "i", "()Lxl/b$b;", "Lokio/k;", "sink", "client", "<init>", "(Lokio/k;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final a f55579g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Logger f55580h = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final okio.k f55581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f55582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final okio.j f55583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final b.C0653b f55586f;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lxl/h$a;", "", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public h(@yt.k okio.k sink, boolean z10) {
        f0.p(sink, "sink");
        this.f55581a = sink;
        this.f55582b = z10;
        okio.j jVar = new okio.j();
        this.f55583c = jVar;
        this.f55584d = 16384;
        this.f55586f = new b.C0653b(0, false, jVar, 3, null);
    }

    public final synchronized void I(@yt.k k settings) throws IOException {
        f0.p(settings, "settings");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        int i10 = 0;
        h(0, settings.l() * 6, 4, 0);
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (settings.i(i10)) {
                this.f55581a.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                this.f55581a.writeInt(settings.b(i10));
            }
            i10 = i11;
        }
        this.f55581a.flush();
    }

    public final synchronized void L(int i10, long j10) throws IOException {
        if (this.f55585e) {
            throw new IOException("closed");
        }
        if (!(j10 != 0 && j10 <= 2147483647L)) {
            throw new IllegalArgumentException(f0.C("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j10)).toString());
        }
        h(i10, 4, 8, 0);
        this.f55581a.writeInt((int) j10);
        this.f55581a.flush();
    }

    public final void M(int i10, long j10) throws IOException {
        while (j10 > 0) {
            long jMin = Math.min(this.f55584d, j10);
            j10 -= jMin;
            h(i10, (int) jMin, 9, j10 == 0 ? 4 : 0);
            this.f55581a.V0(this.f55583c, jMin);
        }
    }

    public final synchronized void a(@yt.k k peerSettings) throws IOException {
        f0.p(peerSettings, "peerSettings");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        this.f55584d = peerSettings.g(this.f55584d);
        if (peerSettings.d() != -1) {
            this.f55586f.e(peerSettings.d());
        }
        h(0, 0, 4, 1);
        this.f55581a.flush();
    }

    public final synchronized void c() throws IOException {
        if (this.f55585e) {
            throw new IOException("closed");
        }
        if (this.f55582b) {
            Logger logger = f55580h;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(rl.f.y(f0.C(">> CONNECTION ", c.f55399b.B()), new Object[0]));
            }
            this.f55581a.B1(c.f55399b);
            this.f55581a.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f55585e = true;
        this.f55581a.close();
    }

    public final synchronized void d(boolean z10, int i10, @yt.l okio.j jVar, int i11) throws IOException {
        if (this.f55585e) {
            throw new IOException("closed");
        }
        f(i10, z10 ? 1 : 0, jVar, i11);
    }

    public final void f(int i10, int i11, @yt.l okio.j jVar, int i12) throws IOException {
        h(i10, i12, 0, i11);
        if (i12 > 0) {
            okio.k kVar = this.f55581a;
            f0.m(jVar);
            kVar.V0(jVar, i12);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.f55585e) {
            throw new IOException("closed");
        }
        this.f55581a.flush();
    }

    public final void h(int i10, int i11, int i12, int i13) throws IOException {
        Logger logger = f55580h;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.f55398a.c(false, i10, i11, i12, i13));
        }
        if (!(i11 <= this.f55584d)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f55584d + ": " + i11).toString());
        }
        if (!((Integer.MIN_VALUE & i10) == 0)) {
            throw new IllegalArgumentException(f0.C("reserved bit set: ", Integer.valueOf(i10)).toString());
        }
        rl.f.p0(this.f55581a, i11);
        this.f55581a.writeByte(i12 & 255);
        this.f55581a.writeByte(i13 & 255);
        this.f55581a.writeInt(i10 & Integer.MAX_VALUE);
    }

    @yt.k
    public final b.C0653b i() {
        return this.f55586f;
    }

    public final synchronized void k(int i10, @yt.k ErrorCode errorCode, @yt.k byte[] debugData) throws IOException {
        f0.p(errorCode, "errorCode");
        f0.p(debugData, "debugData");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        h(0, debugData.length + 8, 7, 0);
        this.f55581a.writeInt(i10);
        this.f55581a.writeInt(errorCode.getHttpCode());
        if (!(debugData.length == 0)) {
            this.f55581a.write(debugData);
        }
        this.f55581a.flush();
    }

    public final synchronized void l(boolean z10, int i10, @yt.k List<xl.a> headerBlock) throws IOException {
        f0.p(headerBlock, "headerBlock");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        this.f55586f.g(headerBlock);
        long jM2 = this.f55583c.m2();
        long jMin = Math.min(this.f55584d, jM2);
        int i11 = jM2 == jMin ? 4 : 0;
        if (z10) {
            i11 |= 1;
        }
        h(i10, (int) jMin, 1, i11);
        this.f55581a.V0(this.f55583c, jMin);
        if (jM2 > jMin) {
            M(i10, jM2 - jMin);
        }
    }

    public final int m() {
        return this.f55584d;
    }

    public final synchronized void n(boolean z10, int i10, int i11) throws IOException {
        if (this.f55585e) {
            throw new IOException("closed");
        }
        h(0, 8, 6, z10 ? 1 : 0);
        this.f55581a.writeInt(i10);
        this.f55581a.writeInt(i11);
        this.f55581a.flush();
    }

    public final synchronized void u(int i10, int i11, @yt.k List<xl.a> requestHeaders) throws IOException {
        f0.p(requestHeaders, "requestHeaders");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        this.f55586f.g(requestHeaders);
        long jM2 = this.f55583c.m2();
        int iMin = (int) Math.min(((long) this.f55584d) - 4, jM2);
        long j10 = iMin;
        h(i10, iMin + 4, 5, jM2 == j10 ? 4 : 0);
        this.f55581a.writeInt(i11 & Integer.MAX_VALUE);
        this.f55581a.V0(this.f55583c, j10);
        if (jM2 > j10) {
            M(i10, jM2 - j10);
        }
    }

    public final synchronized void z(int i10, @yt.k ErrorCode errorCode) throws IOException {
        f0.p(errorCode, "errorCode");
        if (this.f55585e) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        h(i10, 4, 3, 0);
        this.f55581a.writeInt(errorCode.getHttpCode());
        this.f55581a.flush();
    }
}
