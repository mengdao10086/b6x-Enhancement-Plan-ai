package xl;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;
import ul.c;
import xl.f;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\b\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u0015\b\u0000\u0012\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0002J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\u001a\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J-\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\"\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0015J\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010'\u001a\u00020#H\u0000¢\u0006\u0004\b(\u0010&J\u001f\u0010*\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0015H\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010/\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\rJ\u0006\u00101\u001a\u00020\rJ\u0006\u00102\u001a\u00020\rJ\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\r2\u0006\u0010'\u001a\u00020#J\b\u00105\u001a\u00020\rH\u0016J)\u00109\u001a\u00020\r2\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b9\u0010:J\u001c\u0010>\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020<H\u0007J\u000e\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020?J\u000e\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0015J\u000f\u0010D\u001a\u00020\rH\u0000¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0000¢\u0006\u0004\bF\u0010GJ%\u0010H\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\bH\u0010IJ-\u0010K\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010J\u001a\u00020\u0007H\u0000¢\u0006\u0004\bK\u0010LJ/\u0010O\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010N\u001a\u00020M2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0007H\u0000¢\u0006\u0004\bO\u0010PJ\u001f\u0010Q\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\bQ\u0010&R\u001a\u0010R\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u00102\u001a\u0004\bS\u0010TR\u001a\u0010V\u001a\u00020U8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR&\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0Z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001a\u0010`\u001a\u00020_8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\"\u0010d\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bj\u0010e\u001a\u0004\bk\u0010g\"\u0004\bl\u0010iR\u0017\u0010m\u001a\u00020?8\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR\"\u0010q\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010n\u001a\u0004\br\u0010p\"\u0004\bs\u0010tR$\u0010v\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR$\u0010z\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bz\u0010w\u001a\u0004\b{\u0010yR$\u0010|\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b|\u0010w\u001a\u0004\b}\u0010yR$\u0010~\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b~\u0010w\u001a\u0004\b\u007f\u0010yR \u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R!\u0010\u008b\u0001\u001a\u00070\u008a\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006\u0097\u0001"}, d2 = {"Lxl/d;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lxl/a;", "requestHeaders", "", "out", "Lxl/g;", "i2", "Ljava/io/IOException;", "e", "Lkotlin/z1;", "F0", m9.h.C, "id", "C1", "streamId", "r2", "(I)Lxl/g;", "", "read", "B2", "(J)V", "p2", "j2", "outFinished", "alternating", "D2", "(IZLjava/util/List;)V", "Lokio/j;", "buffer", "byteCount", "C2", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "I2", "(ILokhttp3/internal/http2/ErrorCode;)V", "statusCode", "H2", "unacknowledgedBytesRead", "J2", "(IJ)V", "reply", "payload1", "payload2", "F2", "G2", "E2", "Z", "flush", "x2", "close", "connectionCode", "streamCode", "cause", "b0", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lul/d;", "taskRunner", "z2", "Lxl/k;", "settings", "w2", "nowNs", "h2", "s2", "()V", "q2", "(I)Z", "n2", "(ILjava/util/List;)V", "inFinished", "m2", "(ILjava/util/List;Z)V", "Lokio/l;", "source", "l2", "(ILokio/l;IZ)V", "o2", "client", "G0", "()Z", "Lxl/d$c;", "listener", "Lxl/d$c;", "h1", "()Lxl/d$c;", "", "streams", "Ljava/util/Map;", "L1", "()Ljava/util/Map;", "", "connectionName", "Ljava/lang/String;", "M0", "()Ljava/lang/String;", "lastGoodStreamId", "I", m9.h.f40774q, "()I", "t2", "(I)V", "nextStreamId", "i1", "u2", "okHttpSettings", "Lxl/k;", m9.h.B, "()Lxl/k;", "peerSettings", "m1", "v2", "(Lxl/k;)V", "<set-?>", "readBytesTotal", "J", "s1", "()J", "readBytesAcknowledged", "p1", "writeBytesTotal", "Y1", "writeBytesMaximum", "V1", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "z1", "()Ljava/net/Socket;", "Lxl/h;", "writer", "Lxl/h;", "f2", "()Lxl/h;", "Lxl/d$d;", "readerRunnable", "Lxl/d$d;", "u1", "()Lxl/d$d;", "Lxl/d$a;", "builder", "<init>", "(Lxl/d$a;)V", "a", "b", "c", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d implements Closeable {
    public static final int C1 = 3;

    @yt.k
    public static final b D = new b(null);

    @yt.k
    public static final xl.k K0;
    public static final int K1 = 1000000000;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f55422k0 = 16777216;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f55423k1 = 1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f55424v1 = 2;

    @yt.k
    public final xl.h A;

    @yt.k
    public final C0654d B;

    @yt.k
    public final Set<Integer> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f55425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final c f55426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Map<Integer, xl.g> f55427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final String f55428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final ul.d f55432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final ul.c f55433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public final ul.c f55434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public final ul.c f55435k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public final xl.j f55436l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f55437m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f55438n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f55439o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f55440p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f55441q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f55442r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f55443s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public final xl.k f55444t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public xl.k f55445u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f55446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f55447w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f55448x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f55449y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @yt.k
    public final Socket f55450z;

    @d0(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bF\u0010GJ.\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0014R\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\t\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lxl/d$a;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lokio/l;", "source", "Lokio/k;", "sink", "y", "Lxl/d$c;", "listener", "k", "Lxl/j;", "pushObserver", m0.k.f40564b, "", "pingIntervalMillis", com.flydigi.sdk.bluetooth.l.f16298a, "Lxl/d;", "a", "", "client", "Z", "b", "()Z", "n", "(Z)V", "Lul/d;", "taskRunner", "Lul/d;", xf.j.f55230b, "()Lul/d;", "Ljava/net/Socket;", "h", "()Ljava/net/Socket;", "t", "(Ljava/net/Socket;)V", "connectionName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "Lokio/l;", "i", "()Lokio/l;", "u", "(Lokio/l;)V", "Lokio/k;", "g", "()Lokio/k;", an.aB, "(Lokio/k;)V", "Lxl/d$c;", "d", "()Lxl/d$c;", "p", "(Lxl/d$c;)V", "Lxl/j;", "f", "()Lxl/j;", SsManifestParser.e.J, "(Lxl/j;)V", "I", "e", "()I", "q", "(I)V", "<init>", "(ZLul/d;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f55451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final ul.d f55452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Socket f55453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f55454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public okio.l f55455e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public okio.k f55456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public c f55457g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.k
        public xl.j f55458h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f55459i;

        public a(boolean z10, @yt.k ul.d taskRunner) {
            f0.p(taskRunner, "taskRunner");
            this.f55451a = z10;
            this.f55452b = taskRunner;
            this.f55457g = c.f55461b;
            this.f55458h = xl.j.f55595b;
        }

        public static /* synthetic */ a z(a aVar, Socket socket, String str, okio.l lVar, okio.k kVar, int i10, Object obj) throws IOException {
            if ((i10 & 2) != 0) {
                str = rl.f.S(socket);
            }
            if ((i10 & 4) != 0) {
                lVar = okio.f0.e(okio.f0.v(socket));
            }
            if ((i10 & 8) != 0) {
                kVar = okio.f0.d(okio.f0.q(socket));
            }
            return aVar.y(socket, str, lVar, kVar);
        }

        @yt.k
        public final d a() {
            return new d(this);
        }

        public final boolean b() {
            return this.f55451a;
        }

        @yt.k
        public final String c() {
            String str = this.f55454d;
            if (str != null) {
                return str;
            }
            f0.S("connectionName");
            return null;
        }

        @yt.k
        public final c d() {
            return this.f55457g;
        }

        public final int e() {
            return this.f55459i;
        }

        @yt.k
        public final xl.j f() {
            return this.f55458h;
        }

        @yt.k
        public final okio.k g() {
            okio.k kVar = this.f55456f;
            if (kVar != null) {
                return kVar;
            }
            f0.S("sink");
            return null;
        }

        @yt.k
        public final Socket h() {
            Socket socket = this.f55453c;
            if (socket != null) {
                return socket;
            }
            f0.S("socket");
            return null;
        }

        @yt.k
        public final okio.l i() {
            okio.l lVar = this.f55455e;
            if (lVar != null) {
                return lVar;
            }
            f0.S("source");
            return null;
        }

        @yt.k
        public final ul.d j() {
            return this.f55452b;
        }

        @yt.k
        public final a k(@yt.k c listener) {
            f0.p(listener, "listener");
            p(listener);
            return this;
        }

        @yt.k
        public final a l(int i10) {
            q(i10);
            return this;
        }

        @yt.k
        public final a m(@yt.k xl.j pushObserver) {
            f0.p(pushObserver, "pushObserver");
            r(pushObserver);
            return this;
        }

        public final void n(boolean z10) {
            this.f55451a = z10;
        }

        public final void o(@yt.k String str) {
            f0.p(str, "<set-?>");
            this.f55454d = str;
        }

        public final void p(@yt.k c cVar) {
            f0.p(cVar, "<set-?>");
            this.f55457g = cVar;
        }

        public final void q(int i10) {
            this.f55459i = i10;
        }

        public final void r(@yt.k xl.j jVar) {
            f0.p(jVar, "<set-?>");
            this.f55458h = jVar;
        }

        public final void s(@yt.k okio.k kVar) {
            f0.p(kVar, "<set-?>");
            this.f55456f = kVar;
        }

        public final void t(@yt.k Socket socket) {
            f0.p(socket, "<set-?>");
            this.f55453c = socket;
        }

        public final void u(@yt.k okio.l lVar) {
            f0.p(lVar, "<set-?>");
            this.f55455e = lVar;
        }

        @hk.i
        @yt.k
        public final a v(@yt.k Socket socket) throws IOException {
            f0.p(socket, "socket");
            return z(this, socket, null, null, null, 14, null);
        }

        @hk.i
        @yt.k
        public final a w(@yt.k Socket socket, @yt.k String peerName) throws IOException {
            f0.p(socket, "socket");
            f0.p(peerName, "peerName");
            return z(this, socket, peerName, null, null, 12, null);
        }

        @hk.i
        @yt.k
        public final a x(@yt.k Socket socket, @yt.k String peerName, @yt.k okio.l source) throws IOException {
            f0.p(socket, "socket");
            f0.p(peerName, "peerName");
            f0.p(source, "source");
            return z(this, socket, peerName, source, null, 8, null);
        }

        @hk.i
        @yt.k
        public final a y(@yt.k Socket socket, @yt.k String peerName, @yt.k okio.l source, @yt.k okio.k sink) throws IOException {
            String strC;
            f0.p(socket, "socket");
            f0.p(peerName, "peerName");
            f0.p(source, "source");
            f0.p(sink, "sink");
            t(socket);
            if (b()) {
                strC = rl.f.f48804i + zc.f.f58383m + peerName;
            } else {
                strC = f0.C("MockWebServer ", peerName);
            }
            o(strC);
            u(source);
            s(sink);
            return this;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lxl/d$b;", "", "Lxl/k;", "DEFAULT_SETTINGS", "Lxl/k;", "a", "()Lxl/k;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @yt.k
        public final xl.k a() {
            return d.K0;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lxl/d$c;", "", "Lxl/g;", "stream", "Lkotlin/z1;", "f", "Lxl/d;", xl.e.f55522j, "Lxl/k;", "settings", "e", "<init>", "()V", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final b f55460a = new b(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @hk.e
        @yt.k
        public static final c f55461b = new a();

        @d0(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"xl/d$c$a", "Lxl/d$c;", "Lxl/g;", "stream", "Lkotlin/z1;", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends c {
            @Override // xl.d.c
            public void f(@yt.k xl.g stream) throws IOException {
                f0.p(stream, "stream");
                stream.d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lxl/d$c$b;", "", "Lxl/d$c;", "REFUSE_INCOMING_STREAMS", "Lxl/d$c;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class b {
            public b() {
            }

            public /* synthetic */ b(u uVar) {
                this();
            }
        }

        public void e(@yt.k d connection, @yt.k xl.k settings) {
            f0.p(connection, "connection");
            f0.p(settings, "settings");
        }

        public abstract void f(@yt.k xl.g gVar) throws IOException;
    }

    /* JADX INFO: renamed from: xl.d$d, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u00105\u001a\u000204¢\u0006\u0004\b9\u0010:J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J.\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J \u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016J(\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0005H\u0016J&\u0010,\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J8\u00103\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020#H\u0016R\u001a\u00105\u001a\u0002048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lxl/d$d;", "Lxl/f$c;", "Lkotlin/Function0;", "Lkotlin/z1;", an.aD, "", "inFinished", "", "streamId", "Lokio/l;", "source", fd.c.f28042f, "g", "associatedStreamId", "", "Lxl/a;", "headerBlock", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "n", "clearPrevious", "Lxl/k;", "settings", "p", "w", "b", "ack", "payload1", "payload2", xf.j.f55230b, "lastGoodStreamId", "Lokio/ByteString;", "debugData", an.aB, "", "windowSizeIncrement", "e", "streamDependency", "weight", "exclusive", "k", "promisedStreamId", "requestHeaders", SsManifestParser.e.J, "", "origin", "protocol", xl.e.f55523k, "port", "maxAge", "f", "Lxl/f;", "reader", "Lxl/f;", "x", "()Lxl/f;", "<init>", "(Lxl/d;Lxl/f;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class C0654d implements f.c, ik.a<z1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final xl.f f55462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f55463b;

        /* JADX INFO: renamed from: xl.d$d$a */
        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends ul.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f55464e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f55465f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d f55466g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f55467h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z10, d dVar, Ref.ObjectRef objectRef) {
                super(str, z10);
                this.f55464e = str;
                this.f55465f = z10;
                this.f55466g = dVar;
                this.f55467h = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ul.a
            public long f() {
                this.f55466g.h1().e(this.f55466g, (xl.k) this.f55467h.element);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: xl.d$d$b */
        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class b extends ul.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f55468e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f55469f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d f55470g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ xl.g f55471h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z10, d dVar, xl.g gVar) {
                super(str, z10);
                this.f55468e = str;
                this.f55469f = z10;
                this.f55470g = dVar;
                this.f55471h = gVar;
            }

            @Override // ul.a
            public long f() {
                try {
                    this.f55470g.h1().f(this.f55471h);
                    return -1L;
                } catch (IOException e10) {
                    zl.h.f58636a.g().m(f0.C("Http2Connection.Listener failure for ", this.f55470g.M0()), 4, e10);
                    try {
                        this.f55471h.d(ErrorCode.PROTOCOL_ERROR, e10);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: xl.d$d$c */
        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class c extends ul.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f55472e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f55473f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ d f55474g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f55475h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ int f55476i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z10, d dVar, int i10, int i11) {
                super(str, z10);
                this.f55472e = str;
                this.f55473f = z10;
                this.f55474g = dVar;
                this.f55475h = i10;
                this.f55476i = i11;
            }

            @Override // ul.a
            public long f() {
                this.f55474g.F2(true, this.f55475h, this.f55476i);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: xl.d$d$d, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0655d extends ul.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f55477e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ boolean f55478f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ C0654d f55479g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ boolean f55480h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ xl.k f55481i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0655d(String str, boolean z10, C0654d c0654d, boolean z11, xl.k kVar) {
                super(str, z10);
                this.f55477e = str;
                this.f55478f = z10;
                this.f55479g = c0654d;
                this.f55480h = z11;
                this.f55481i = kVar;
            }

            @Override // ul.a
            public long f() {
                this.f55479g.w(this.f55480h, this.f55481i);
                return -1L;
            }
        }

        public C0654d(@yt.k d this$0, xl.f reader) {
            f0.p(this$0, "this$0");
            f0.p(reader, "reader");
            this.f55463b = this$0;
            this.f55462a = reader;
        }

        @Override // xl.f.c
        public void b() {
        }

        @Override // xl.f.c
        public void d(boolean z10, int i10, int i11, @yt.k List<xl.a> headerBlock) {
            f0.p(headerBlock, "headerBlock");
            if (this.f55463b.q2(i10)) {
                this.f55463b.m2(i10, headerBlock, z10);
                return;
            }
            d dVar = this.f55463b;
            synchronized (dVar) {
                xl.g gVarC1 = dVar.C1(i10);
                if (gVarC1 != null) {
                    z1 z1Var = z1.f38230a;
                    gVarC1.z(rl.f.c0(headerBlock), z10);
                    return;
                }
                if (dVar.f55431g) {
                    return;
                }
                if (i10 <= dVar.d1()) {
                    return;
                }
                if (i10 % 2 == dVar.i1() % 2) {
                    return;
                }
                xl.g gVar = new xl.g(i10, dVar, false, z10, rl.f.c0(headerBlock));
                dVar.t2(i10);
                dVar.L1().put(Integer.valueOf(i10), gVar);
                dVar.f55432h.j().n(new b(dVar.M0() + '[' + i10 + "] onStream", true, dVar, gVar), 0L);
            }
        }

        @Override // xl.f.c
        public void e(int i10, long j10) {
            if (i10 == 0) {
                d dVar = this.f55463b;
                synchronized (dVar) {
                    dVar.f55449y = dVar.V1() + j10;
                    dVar.notifyAll();
                    z1 z1Var = z1.f38230a;
                }
                return;
            }
            xl.g gVarC1 = this.f55463b.C1(i10);
            if (gVarC1 != null) {
                synchronized (gVarC1) {
                    gVarC1.a(j10);
                    z1 z1Var2 = z1.f38230a;
                }
            }
        }

        @Override // xl.f.c
        public void f(int i10, @yt.k String origin, @yt.k ByteString protocol, @yt.k String host, int i11, long j10) {
            f0.p(origin, "origin");
            f0.p(protocol, "protocol");
            f0.p(host, "host");
        }

        @Override // xl.f.c
        public void g(boolean z10, int i10, @yt.k okio.l source, int i11) throws IOException {
            f0.p(source, "source");
            if (this.f55463b.q2(i10)) {
                this.f55463b.l2(i10, source, i11, z10);
                return;
            }
            xl.g gVarC1 = this.f55463b.C1(i10);
            if (gVarC1 == null) {
                this.f55463b.I2(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                this.f55463b.B2(j10);
                source.skip(j10);
                return;
            }
            gVarC1.y(source, i11);
            if (z10) {
                gVarC1.z(rl.f.f48797b, true);
            }
        }

        @Override // xl.f.c
        public void j(boolean z10, int i10, int i11) {
            if (!z10) {
                this.f55463b.f55433i.n(new c(f0.C(this.f55463b.M0(), " ping"), true, this.f55463b, i10, i11), 0L);
                return;
            }
            d dVar = this.f55463b;
            synchronized (dVar) {
                if (i10 == 1) {
                    dVar.f55438n++;
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        dVar.f55442r++;
                        dVar.notifyAll();
                    }
                    z1 z1Var = z1.f38230a;
                } else {
                    dVar.f55440p++;
                }
            }
        }

        @Override // xl.f.c
        public void k(int i10, int i11, int i12, boolean z10) {
        }

        @Override // xl.f.c
        public void n(int i10, @yt.k ErrorCode errorCode) {
            f0.p(errorCode, "errorCode");
            if (this.f55463b.q2(i10)) {
                this.f55463b.o2(i10, errorCode);
                return;
            }
            xl.g gVarR2 = this.f55463b.r2(i10);
            if (gVarR2 == null) {
                return;
            }
            gVarR2.A(errorCode);
        }

        @Override // ik.a
        public /* bridge */ /* synthetic */ z1 o() throws Throwable {
            z();
            return z1.f38230a;
        }

        @Override // xl.f.c
        public void p(boolean z10, @yt.k xl.k settings) {
            f0.p(settings, "settings");
            this.f55463b.f55433i.n(new C0655d(f0.C(this.f55463b.M0(), " applyAndAckSettings"), true, this, z10, settings), 0L);
        }

        @Override // xl.f.c
        public void r(int i10, int i11, @yt.k List<xl.a> requestHeaders) {
            f0.p(requestHeaders, "requestHeaders");
            this.f55463b.n2(i11, requestHeaders);
        }

        @Override // xl.f.c
        public void s(int i10, @yt.k ErrorCode errorCode, @yt.k ByteString debugData) {
            int i11;
            Object[] array;
            f0.p(errorCode, "errorCode");
            f0.p(debugData, "debugData");
            debugData.x0();
            d dVar = this.f55463b;
            synchronized (dVar) {
                i11 = 0;
                array = dVar.L1().values().toArray(new xl.g[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                dVar.f55431g = true;
                z1 z1Var = z1.f38230a;
            }
            xl.g[] gVarArr = (xl.g[]) array;
            int length = gVarArr.length;
            while (i11 < length) {
                xl.g gVar = gVarArr[i11];
                i11++;
                if (gVar.k() > i10 && gVar.v()) {
                    gVar.A(ErrorCode.REFUSED_STREAM);
                    this.f55463b.r2(gVar.k());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, xl.k] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void w(boolean z10, @yt.k xl.k settings) {
            ?? r13;
            long jE;
            int i10;
            xl.g[] gVarArr;
            f0.p(settings, "settings");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            xl.h hVarF2 = this.f55463b.f2();
            d dVar = this.f55463b;
            synchronized (hVarF2) {
                synchronized (dVar) {
                    xl.k kVarM1 = dVar.m1();
                    if (z10) {
                        r13 = settings;
                    } else {
                        xl.k kVar = new xl.k();
                        kVar.j(kVarM1);
                        kVar.j(settings);
                        r13 = kVar;
                    }
                    objectRef.element = r13;
                    jE = ((long) r13.e()) - ((long) kVarM1.e());
                    i10 = 0;
                    if (jE == 0 || dVar.L1().isEmpty()) {
                        gVarArr = null;
                    } else {
                        Object[] array = dVar.L1().values().toArray(new xl.g[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        gVarArr = (xl.g[]) array;
                    }
                    dVar.v2((xl.k) objectRef.element);
                    dVar.f55435k.n(new a(f0.C(dVar.M0(), " onSettings"), true, dVar, objectRef), 0L);
                    z1 z1Var = z1.f38230a;
                }
                try {
                    dVar.f2().a((xl.k) objectRef.element);
                } catch (IOException e10) {
                    dVar.F0(e10);
                }
                z1 z1Var2 = z1.f38230a;
            }
            if (gVarArr != null) {
                int length = gVarArr.length;
                while (i10 < length) {
                    xl.g gVar = gVarArr[i10];
                    i10++;
                    synchronized (gVar) {
                        gVar.a(jE);
                        z1 z1Var3 = z1.f38230a;
                    }
                }
            }
        }

        @yt.k
        public final xl.f x() {
            return this.f55462a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, xl.f] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void z() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.f55462a.d(this);
                    while (this.f55462a.c(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.f55463b.b0(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e11) {
                        e10 = e11;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        d dVar = this.f55463b;
                        dVar.b0(errorCode4, errorCode4, e10);
                        errorCode = dVar;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f55463b.b0(errorCode, errorCode2, e10);
                    rl.f.o(this.f55462a);
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                this.f55463b.b0(errorCode, errorCode2, e10);
                rl.f.o(this.f55462a);
                throw th;
            }
            errorCode2 = this.f55462a;
            rl.f.o(errorCode2);
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class e extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55483f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55484g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55485h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ okio.j f55486i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f55487j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f55488k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z10, d dVar, int i10, okio.j jVar, int i11, boolean z11) {
            super(str, z10);
            this.f55482e = str;
            this.f55483f = z10;
            this.f55484g = dVar;
            this.f55485h = i10;
            this.f55486i = jVar;
            this.f55487j = i11;
            this.f55488k = z11;
        }

        @Override // ul.a
        public long f() {
            try {
                boolean zD = this.f55484g.f55436l.d(this.f55485h, this.f55486i, this.f55487j, this.f55488k);
                if (zD) {
                    this.f55484g.f2().z(this.f55485h, ErrorCode.CANCEL);
                }
                if (!zD && !this.f55488k) {
                    return -1L;
                }
                synchronized (this.f55484g) {
                    this.f55484g.C.remove(Integer.valueOf(this.f55485h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class f extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55490f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55491g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55492h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ List f55493i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f55494j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z10, d dVar, int i10, List list, boolean z11) {
            super(str, z10);
            this.f55489e = str;
            this.f55490f = z10;
            this.f55491g = dVar;
            this.f55492h = i10;
            this.f55493i = list;
            this.f55494j = z11;
        }

        @Override // ul.a
        public long f() {
            boolean zB = this.f55491g.f55436l.b(this.f55492h, this.f55493i, this.f55494j);
            if (zB) {
                try {
                    this.f55491g.f2().z(this.f55492h, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zB && !this.f55494j) {
                return -1L;
            }
            synchronized (this.f55491g) {
                this.f55491g.C.remove(Integer.valueOf(this.f55492h));
            }
            return -1L;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class g extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55495e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55496f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55497g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55498h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ List f55499i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z10, d dVar, int i10, List list) {
            super(str, z10);
            this.f55495e = str;
            this.f55496f = z10;
            this.f55497g = dVar;
            this.f55498h = i10;
            this.f55499i = list;
        }

        @Override // ul.a
        public long f() {
            if (!this.f55497g.f55436l.a(this.f55498h, this.f55499i)) {
                return -1L;
            }
            try {
                this.f55497g.f2().z(this.f55498h, ErrorCode.CANCEL);
                synchronized (this.f55497g) {
                    this.f55497g.C.remove(Integer.valueOf(this.f55498h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class h extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55500e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55502g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55503h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ ErrorCode f55504i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, d dVar, int i10, ErrorCode errorCode) {
            super(str, z10);
            this.f55500e = str;
            this.f55501f = z10;
            this.f55502g = dVar;
            this.f55503h = i10;
            this.f55504i = errorCode;
        }

        @Override // ul.a
        public long f() {
            this.f55502g.f55436l.c(this.f55503h, this.f55504i);
            synchronized (this.f55502g) {
                this.f55502g.C.remove(Integer.valueOf(this.f55503h));
                z1 z1Var = z1.f38230a;
            }
            return -1L;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class i extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55507g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z10, d dVar) {
            super(str, z10);
            this.f55505e = str;
            this.f55506f = z10;
            this.f55507g = dVar;
        }

        @Override // ul.a
        public long f() {
            this.f55507g.F2(false, 2, 0);
            return -1L;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$c", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class j extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55508e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f55509f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f55510g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, d dVar, long j10) {
            super(str, false, 2, null);
            this.f55508e = str;
            this.f55509f = dVar;
            this.f55510g = j10;
        }

        @Override // ul.a
        public long f() {
            boolean z10;
            synchronized (this.f55509f) {
                if (this.f55509f.f55438n < this.f55509f.f55437m) {
                    z10 = true;
                } else {
                    this.f55509f.f55437m++;
                    z10 = false;
                }
            }
            if (z10) {
                this.f55509f.F0(null);
                return -1L;
            }
            this.f55509f.F2(false, 1, 0);
            return this.f55510g;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class k extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ ErrorCode f55515i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z10, d dVar, int i10, ErrorCode errorCode) {
            super(str, z10);
            this.f55511e = str;
            this.f55512f = z10;
            this.f55513g = dVar;
            this.f55514h = i10;
            this.f55515i = errorCode;
        }

        @Override // ul.a
        public long f() {
            try {
                this.f55513g.H2(this.f55514h, this.f55515i);
                return -1L;
            } catch (IOException e10) {
                this.f55513g.F0(e10);
                return -1L;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class l extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f55516e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f55517f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f55518g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f55519h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f55520i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z10, d dVar, int i10, long j10) {
            super(str, z10);
            this.f55516e = str;
            this.f55517f = z10;
            this.f55518g = dVar;
            this.f55519h = i10;
            this.f55520i = j10;
        }

        @Override // ul.a
        public long f() {
            try {
                this.f55518g.f2().L(this.f55519h, this.f55520i);
                return -1L;
            } catch (IOException e10) {
                this.f55518g.F0(e10);
                return -1L;
            }
        }
    }

    static {
        xl.k kVar = new xl.k();
        kVar.k(7, 65535);
        kVar.k(5, 16384);
        K0 = kVar;
    }

    public d(@yt.k a builder) {
        f0.p(builder, "builder");
        boolean zB = builder.b();
        this.f55425a = zB;
        this.f55426b = builder.d();
        this.f55427c = new LinkedHashMap();
        String strC = builder.c();
        this.f55428d = strC;
        this.f55430f = builder.b() ? 3 : 2;
        ul.d dVarJ = builder.j();
        this.f55432h = dVarJ;
        ul.c cVarJ = dVarJ.j();
        this.f55433i = cVarJ;
        this.f55434j = dVarJ.j();
        this.f55435k = dVarJ.j();
        this.f55436l = builder.f();
        xl.k kVar = new xl.k();
        if (builder.b()) {
            kVar.k(7, 16777216);
        }
        this.f55444t = kVar;
        this.f55445u = K0;
        this.f55449y = r2.e();
        this.f55450z = builder.h();
        this.A = new xl.h(builder.g(), zB);
        this.B = new C0654d(this, new xl.f(builder.i(), zB));
        this.C = new LinkedHashSet();
        if (builder.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            cVarJ.n(new j(f0.C(strC, " ping"), this, nanos), nanos);
        }
    }

    public static /* synthetic */ void A2(d dVar, boolean z10, ul.d dVar2, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            dVar2 = ul.d.f52208i;
        }
        dVar.z2(z10, dVar2);
    }

    public final synchronized void B2(long j10) {
        long j11 = this.f55446v + j10;
        this.f55446v = j11;
        long j12 = j11 - this.f55447w;
        if (j12 >= this.f55444t.e() / 2) {
            J2(0, j12);
            this.f55447w += j12;
        }
    }

    @yt.l
    public final synchronized xl.g C1(int i10) {
        return this.f55427c.get(Integer.valueOf(i10));
    }

    public final void C2(int i10, boolean z10, @yt.l okio.j jVar, long j10) throws IOException {
        int iMin;
        long j11;
        if (j10 == 0) {
            this.A.d(z10, i10, jVar, 0);
            return;
        }
        while (j10 > 0) {
            synchronized (this) {
                while (Y1() >= V1()) {
                    try {
                        if (!L1().containsKey(Integer.valueOf(i10))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j10, V1() - Y1()), f2().m());
                j11 = iMin;
                this.f55448x = Y1() + j11;
                z1 z1Var = z1.f38230a;
            }
            j10 -= j11;
            this.A.d(z10 && j10 == 0, i10, jVar, iMin);
        }
    }

    public final void D2(int i10, boolean z10, @yt.k List<xl.a> alternating) throws IOException {
        f0.p(alternating, "alternating");
        this.A.l(z10, i10, alternating);
    }

    public final void E2() throws InterruptedException {
        synchronized (this) {
            this.f55441q++;
        }
        F2(false, 3, 1330343787);
    }

    public final void F0(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        b0(errorCode, errorCode, iOException);
    }

    public final void F2(boolean z10, int i10, int i11) {
        try {
            this.A.n(z10, i10, i11);
        } catch (IOException e10) {
            F0(e10);
        }
    }

    public final boolean G0() {
        return this.f55425a;
    }

    public final void G2() throws InterruptedException {
        E2();
        Z();
    }

    public final void H2(int i10, @yt.k ErrorCode statusCode) throws IOException {
        f0.p(statusCode, "statusCode");
        this.A.z(i10, statusCode);
    }

    public final void I2(int i10, @yt.k ErrorCode errorCode) {
        f0.p(errorCode, "errorCode");
        this.f55433i.n(new k(this.f55428d + '[' + i10 + "] writeSynReset", true, this, i10, errorCode), 0L);
    }

    public final void J2(int i10, long j10) {
        this.f55433i.n(new l(this.f55428d + '[' + i10 + "] windowUpdate", true, this, i10, j10), 0L);
    }

    @yt.k
    public final Map<Integer, xl.g> L1() {
        return this.f55427c;
    }

    @yt.k
    public final String M0() {
        return this.f55428d;
    }

    public final long V1() {
        return this.f55449y;
    }

    public final long Y1() {
        return this.f55448x;
    }

    public final synchronized void Z() throws InterruptedException {
        while (this.f55442r < this.f55441q) {
            wait();
        }
    }

    public final void b0(@yt.k ErrorCode connectionCode, @yt.k ErrorCode streamCode, @yt.l IOException iOException) {
        int i10;
        f0.p(connectionCode, "connectionCode");
        f0.p(streamCode, "streamCode");
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        try {
            x2(connectionCode);
        } catch (IOException unused) {
        }
        Object[] array = null;
        synchronized (this) {
            if (!L1().isEmpty()) {
                array = L1().values().toArray(new xl.g[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                L1().clear();
            }
            z1 z1Var = z1.f38230a;
        }
        xl.g[] gVarArr = (xl.g[]) array;
        if (gVarArr != null) {
            for (xl.g gVar : gVarArr) {
                try {
                    gVar.d(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            f2().close();
        } catch (IOException unused3) {
        }
        try {
            z1().close();
        } catch (IOException unused4) {
        }
        this.f55433i.u();
        this.f55434j.u();
        this.f55435k.u();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final int d1() {
        return this.f55429e;
    }

    @yt.k
    public final xl.h f2() {
        return this.A;
    }

    public final void flush() throws IOException {
        this.A.flush();
    }

    @yt.k
    public final c h1() {
        return this.f55426b;
    }

    public final synchronized boolean h2(long j10) {
        if (this.f55431g) {
            return false;
        }
        if (this.f55440p < this.f55439o) {
            if (j10 >= this.f55443s) {
                return false;
            }
        }
        return true;
    }

    public final int i1() {
        return this.f55430f;
    }

    public final xl.g i2(int i10, List<xl.a> list, boolean z10) throws IOException {
        int iI1;
        xl.g gVar;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.A) {
            synchronized (this) {
                if (i1() > 1073741823) {
                    x2(ErrorCode.REFUSED_STREAM);
                }
                if (this.f55431g) {
                    throw new ConnectionShutdownException();
                }
                iI1 = i1();
                u2(i1() + 2);
                gVar = new xl.g(iI1, this, z12, false, null);
                z11 = !z10 || Y1() >= V1() || gVar.t() >= gVar.s();
                if (gVar.w()) {
                    L1().put(Integer.valueOf(iI1), gVar);
                }
                z1 z1Var = z1.f38230a;
            }
            if (i10 == 0) {
                f2().l(z12, iI1, list);
            } else {
                if (!(true ^ G0())) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                f2().u(i10, iI1, list);
            }
        }
        if (z11) {
            this.A.flush();
        }
        return gVar;
    }

    @yt.k
    public final xl.g j2(@yt.k List<xl.a> requestHeaders, boolean z10) throws IOException {
        f0.p(requestHeaders, "requestHeaders");
        return i2(0, requestHeaders, z10);
    }

    @yt.k
    public final xl.k k1() {
        return this.f55444t;
    }

    public final synchronized int k2() {
        return this.f55427c.size();
    }

    public final void l2(int i10, @yt.k okio.l source, int i11, boolean z10) throws IOException {
        f0.p(source, "source");
        okio.j jVar = new okio.j();
        long j10 = i11;
        source.U1(j10);
        source.F1(jVar, j10);
        this.f55434j.n(new e(this.f55428d + '[' + i10 + "] onData", true, this, i10, jVar, i11, z10), 0L);
    }

    @yt.k
    public final xl.k m1() {
        return this.f55445u;
    }

    public final void m2(int i10, @yt.k List<xl.a> requestHeaders, boolean z10) {
        f0.p(requestHeaders, "requestHeaders");
        this.f55434j.n(new f(this.f55428d + '[' + i10 + "] onHeaders", true, this, i10, requestHeaders, z10), 0L);
    }

    public final void n2(int i10, @yt.k List<xl.a> requestHeaders) {
        f0.p(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.C.contains(Integer.valueOf(i10))) {
                I2(i10, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.C.add(Integer.valueOf(i10));
            this.f55434j.n(new g(this.f55428d + '[' + i10 + "] onRequest", true, this, i10, requestHeaders), 0L);
        }
    }

    public final void o2(int i10, @yt.k ErrorCode errorCode) {
        f0.p(errorCode, "errorCode");
        this.f55434j.n(new h(this.f55428d + '[' + i10 + "] onReset", true, this, i10, errorCode), 0L);
    }

    public final long p1() {
        return this.f55447w;
    }

    @yt.k
    public final xl.g p2(int i10, @yt.k List<xl.a> requestHeaders, boolean z10) throws IOException {
        f0.p(requestHeaders, "requestHeaders");
        if (!this.f55425a) {
            return i2(i10, requestHeaders, z10);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean q2(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    @yt.l
    public final synchronized xl.g r2(int i10) {
        xl.g gVarRemove;
        gVarRemove = this.f55427c.remove(Integer.valueOf(i10));
        notifyAll();
        return gVarRemove;
    }

    public final long s1() {
        return this.f55446v;
    }

    public final void s2() {
        synchronized (this) {
            long j10 = this.f55440p;
            long j11 = this.f55439o;
            if (j10 < j11) {
                return;
            }
            this.f55439o = j11 + 1;
            this.f55443s = System.nanoTime() + ((long) 1000000000);
            z1 z1Var = z1.f38230a;
            this.f55433i.n(new i(f0.C(this.f55428d, " ping"), true, this), 0L);
        }
    }

    @hk.i
    public final void start() throws IOException {
        A2(this, false, null, 3, null);
    }

    public final void t2(int i10) {
        this.f55429e = i10;
    }

    @yt.k
    public final C0654d u1() {
        return this.B;
    }

    public final void u2(int i10) {
        this.f55430f = i10;
    }

    public final void v2(@yt.k xl.k kVar) {
        f0.p(kVar, "<set-?>");
        this.f55445u = kVar;
    }

    public final void w2(@yt.k xl.k settings) throws IOException {
        f0.p(settings, "settings");
        synchronized (this.A) {
            synchronized (this) {
                if (this.f55431g) {
                    throw new ConnectionShutdownException();
                }
                k1().j(settings);
                z1 z1Var = z1.f38230a;
            }
            f2().I(settings);
        }
    }

    public final void x2(@yt.k ErrorCode statusCode) throws IOException {
        f0.p(statusCode, "statusCode");
        synchronized (this.A) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.f55431g) {
                    return;
                }
                this.f55431g = true;
                intRef.element = d1();
                z1 z1Var = z1.f38230a;
                f2().k(intRef.element, statusCode, rl.f.f48796a);
            }
        }
    }

    @hk.i
    public final void y2(boolean z10) throws IOException {
        A2(this, z10, null, 2, null);
    }

    @yt.k
    public final Socket z1() {
        return this.f55450z;
    }

    @hk.i
    public final void z2(boolean z10, @yt.k ul.d taskRunner) throws IOException {
        f0.p(taskRunner, "taskRunner");
        if (z10) {
            this.A.c();
            this.A.I(this.f55444t);
            if (this.f55444t.e() != 65535) {
                this.A.L(0, r6 - 65535);
            }
        }
        taskRunner.j().n(new c.b(this.f55428d, true, this.B), 0L);
    }
}
