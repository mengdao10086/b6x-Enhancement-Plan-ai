package dm;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import dm.h;
import f0.v;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.collections.s;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.g0;
import okhttp3.h0;
import okhttp3.r;
import okio.ByteString;
import qk.m;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u000554-+/BA\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010H\u001a\u00020\r\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010K\u001a\u00020\u000f\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010M\u001a\u00020\u000f¢\u0006\u0004\bN\u0010OJ\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012J!\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#J\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bJ\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001bH\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006H\u0016J\u000e\u00106\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0006J\u001a\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u001bH\u0016J \u00109\u001a\u00020\u00042\u0006\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u001b2\u0006\u00108\u001a\u00020\u000fJ\u000f\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0000¢\u0006\u0004\b<\u0010=J\u001c\u0010@\u001a\u00020\u000b2\n\u0010/\u001a\u00060>j\u0002`?2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u001a\u0010B\u001a\u00020A8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Ldm/e;", "Lokhttp3/g0;", "Ldm/h$a;", "Ldm/f;", "", "u", "Lokio/ByteString;", "data", "", "formatOpcode", "B", "Lkotlin/z1;", i1.a.W4, "Lokhttp3/b0;", i1.a.f31577d5, "", "g", CommonNetImpl.CANCEL, "Lokhttp3/a0;", "client", "q", "Lokhttp3/d0;", "response", "Lokhttp3/internal/connection/c;", "exchange", "o", "(Lokhttp3/d0;Lokhttp3/internal/connection/c;)V", "", "name", "Ldm/e$d;", "streams", "t", "v", "x", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "n", "D", "C", "y", an.aD, "text", "d", "bytes", "c", "payload", "e", "h", "code", "reason", "i", "b", "a", "w", "f", "cancelAfterCloseMillis", "p", i1.a.S4, "()Z", "F", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", SsManifestParser.e.J, "Lokhttp3/h0;", "listener", "Lokhttp3/h0;", an.aB, "()Lokhttp3/h0;", "Lul/d;", "taskRunner", "originalRequest", "Ljava/util/Random;", "random", "pingIntervalMillis", "extensions", "minimumDeflateSize", "<init>", "(Lul/d;Lokhttp3/b0;Lokhttp3/h0;Ljava/util/Random;JLdm/f;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e implements g0, h.a {
    public static final long B = 16777216;
    public static final long C = 60000;
    public static final long D = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final b0 f26319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final h0 f26320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final Random f26321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f26322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public dm.f f26323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f26324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final String f26325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public okhttp3.e f26326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public ul.a f26327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public dm.h f26328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public i f26329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @k
    public ul.c f26330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public String f26331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public d f26332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @k
    public final ArrayDeque<ByteString> f26333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @k
    public final ArrayDeque<Object> f26334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f26335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f26336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f26337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @l
    public String f26338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f26339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f26340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f26341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f26342x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f26343y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @k
    public static final b f26318z = new b(null);

    @k
    public static final List<Protocol> A = s.k(Protocol.HTTP_1_1);

    @d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ldm/e$a;", "", "", "code", "I", "b", "()I", "Lokio/ByteString;", "reason", "Lokio/ByteString;", "c", "()Lokio/ByteString;", "", "cancelAfterCloseMillis", "J", "a", "()J", "<init>", "(ILokio/ByteString;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final ByteString f26345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f26346c;

        public a(int i10, @l ByteString byteString, long j10) {
            this.f26344a = i10;
            this.f26345b = byteString;
            this.f26346c = j10;
        }

        public final long a() {
            return this.f26346c;
        }

        public final int b() {
            return this.f26344a;
        }

        @l
        public final ByteString c() {
            return this.f26345b;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Ldm/e$b;", "", "", "CANCEL_AFTER_CLOSE_MILLIS", "J", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "", "Lokhttp3/Protocol;", "ONLY_HTTP1", "Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Ldm/e$c;", "", "", "formatOpcode", "I", "b", "()I", "Lokio/ByteString;", "data", "Lokio/ByteString;", "a", "()Lokio/ByteString;", "<init>", "(ILokio/ByteString;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public final ByteString f26348b;

        public c(int i10, @k ByteString data) {
            f0.p(data, "data");
            this.f26347a = i10;
            this.f26348b = data;
        }

        @k
        public final ByteString a() {
            return this.f26348b;
        }

        public final int b() {
            return this.f26347a;
        }
    }

    @d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ldm/e$d;", "Ljava/io/Closeable;", "", "client", "Z", "a", "()Z", "Lokio/l;", "source", "Lokio/l;", "d", "()Lokio/l;", "Lokio/k;", "sink", "Lokio/k;", "c", "()Lokio/k;", "<init>", "(ZLokio/l;Lokio/k;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static abstract class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f26349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public final okio.l f26350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @k
        public final okio.k f26351c;

        public d(boolean z10, @k okio.l source, @k okio.k sink) {
            f0.p(source, "source");
            f0.p(sink, "sink");
            this.f26349a = z10;
            this.f26350b = source;
            this.f26351c = sink;
        }

        public final boolean a() {
            return this.f26349a;
        }

        @k
        public final okio.k c() {
            return this.f26351c;
        }

        @k
        public final okio.l d() {
            return this.f26350b;
        }
    }

    /* JADX INFO: renamed from: dm.e$e, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Ldm/e$e;", "Lul/a;", "", "f", "<init>", "(Ldm/e;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class C0299e extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f26352e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0299e(e this$0) {
            super(f0.C(this$0.f26331m, " writer"), false, 2, null);
            f0.p(this$0, "this$0");
            this.f26352e = this$0;
        }

        @Override // ul.a
        public long f() {
            try {
                return this.f26352e.E() ? 0L : -1L;
            } catch (IOException e10) {
                this.f26352e.r(e10, null);
                return -1L;
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"dm/e$f", "Lokhttp3/f;", "Lokhttp3/e;", v.E0, "Lokhttp3/d0;", "response", "Lkotlin/z1;", "c", "Ljava/io/IOException;", "e", "d", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class f implements okhttp3.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f26354b;

        public f(b0 b0Var) {
            this.f26354b = b0Var;
        }

        @Override // okhttp3.f
        public void c(@k okhttp3.e call, @k okhttp3.d0 response) throws IOException {
            f0.p(call, "call");
            f0.p(response, "response");
            okhttp3.internal.connection.c cVarZ = response.Z();
            try {
                e.this.o(response, cVarZ);
                f0.m(cVarZ);
                d dVarM = cVarZ.m();
                dm.f fVarA = dm.f.f26361g.a(response.h1());
                e.this.f26323e = fVarA;
                if (!e.this.u(fVarA)) {
                    e eVar = e.this;
                    synchronized (eVar) {
                        eVar.f26334p.clear();
                        eVar.f(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    e.this.t(rl.f.f48804i + " WebSocket " + this.f26354b.q().V(), dVarM);
                    e.this.s().f(e.this, response);
                    e.this.v();
                } catch (Exception e10) {
                    e.this.r(e10, null);
                }
            } catch (IOException e11) {
                if (cVarZ != null) {
                    cVarZ.v();
                }
                e.this.r(e11, response);
                rl.f.o(response);
            }
        }

        @Override // okhttp3.f
        public void d(@k okhttp3.e call, @k IOException e10) {
            f0.p(call, "call");
            f0.p(e10, "e");
            e.this.r(e10, null);
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$c", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class g extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f26355e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ e f26356f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f26357g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, e eVar, long j10) {
            super(str, false, 2, null);
            this.f26355e = str;
            this.f26356f = eVar;
            this.f26357g = j10;
        }

        @Override // ul.a
        public long f() {
            this.f26356f.F();
            return this.f26357g;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class h extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f26358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f26359f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f26360g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, e eVar) {
            super(str, z10);
            this.f26358e = str;
            this.f26359f = z10;
            this.f26360g = eVar;
        }

        @Override // ul.a
        public long f() {
            this.f26360g.cancel();
            return -1L;
        }
    }

    public e(@k ul.d taskRunner, @k b0 originalRequest, @k h0 listener, @k Random random, long j10, @l dm.f fVar, long j11) {
        f0.p(taskRunner, "taskRunner");
        f0.p(originalRequest, "originalRequest");
        f0.p(listener, "listener");
        f0.p(random, "random");
        this.f26319a = originalRequest;
        this.f26320b = listener;
        this.f26321c = random;
        this.f26322d = j10;
        this.f26323e = fVar;
        this.f26324f = j11;
        this.f26330l = taskRunner.j();
        this.f26333o = new ArrayDeque<>();
        this.f26334p = new ArrayDeque<>();
        this.f26337s = -1;
        if (!f0.g(Constants.HTTP_GET, originalRequest.m())) {
            throw new IllegalArgumentException(f0.C("Request must be GET: ", originalRequest.m()).toString());
        }
        ByteString.a aVar = ByteString.f44029c;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        z1 z1Var = z1.f38230a;
        this.f26325g = ByteString.a.p(aVar, bArr, 0, 0, 3, null).h();
    }

    public final void A() {
        if (!rl.f.f48803h || Thread.holdsLock(this)) {
            ul.a aVar = this.f26327i;
            if (aVar != null) {
                ul.c.p(this.f26330l, aVar, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    public final synchronized boolean B(ByteString byteString, int i10) {
        if (!this.f26339u && !this.f26336r) {
            if (this.f26335q + ((long) byteString.x0()) > B) {
                f(1001, null);
                return false;
            }
            this.f26335q += (long) byteString.x0();
            this.f26334p.add(new c(i10, byteString));
            A();
            return true;
        }
        return false;
    }

    public final synchronized int C() {
        return this.f26340v;
    }

    public final void D() throws InterruptedException {
        this.f26330l.u();
        this.f26330l.l().await(10L, TimeUnit.SECONDS);
    }

    public final boolean E() throws IOException {
        d dVar;
        String str;
        dm.h hVar;
        Closeable closeable;
        synchronized (this) {
            if (this.f26339u) {
                return false;
            }
            i iVar = this.f26329k;
            ByteString byteStringPoll = this.f26333o.poll();
            int i10 = -1;
            Object obj = null;
            if (byteStringPoll == null) {
                Object objPoll = this.f26334p.poll();
                if (objPoll instanceof a) {
                    int i11 = this.f26337s;
                    str = this.f26338t;
                    if (i11 != -1) {
                        d dVar2 = this.f26332n;
                        this.f26332n = null;
                        hVar = this.f26328j;
                        this.f26328j = null;
                        closeable = this.f26329k;
                        this.f26329k = null;
                        this.f26330l.u();
                        obj = objPoll;
                        i10 = i11;
                        dVar = dVar2;
                    } else {
                        long jA = ((a) objPoll).a();
                        this.f26330l.n(new h(f0.C(this.f26331m, " cancel"), true, this), TimeUnit.MILLISECONDS.toNanos(jA));
                        i10 = i11;
                        dVar = null;
                        hVar = null;
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    dVar = null;
                    str = null;
                    hVar = null;
                }
                closeable = hVar;
                obj = objPoll;
            } else {
                dVar = null;
                str = null;
                hVar = null;
                closeable = null;
            }
            z1 z1Var = z1.f38230a;
            try {
                if (byteStringPoll != null) {
                    f0.m(iVar);
                    iVar.k(byteStringPoll);
                } else if (obj instanceof c) {
                    c cVar = (c) obj;
                    f0.m(iVar);
                    iVar.h(cVar.b(), cVar.a());
                    synchronized (this) {
                        this.f26335q -= (long) cVar.a().x0();
                    }
                } else {
                    if (!(obj instanceof a)) {
                        throw new AssertionError();
                    }
                    a aVar = (a) obj;
                    f0.m(iVar);
                    iVar.d(aVar.b(), aVar.c());
                    if (dVar != null) {
                        h0 h0Var = this.f26320b;
                        f0.m(str);
                        h0Var.a(this, i10, str);
                    }
                }
                return true;
            } finally {
                if (dVar != null) {
                    rl.f.o(dVar);
                }
                if (hVar != null) {
                    rl.f.o(hVar);
                }
                if (closeable != null) {
                    rl.f.o(closeable);
                }
            }
        }
    }

    public final void F() {
        synchronized (this) {
            if (this.f26339u) {
                return;
            }
            i iVar = this.f26329k;
            if (iVar == null) {
                return;
            }
            int i10 = this.f26343y ? this.f26340v : -1;
            this.f26340v++;
            this.f26343y = true;
            z1 z1Var = z1.f38230a;
            if (i10 == -1) {
                try {
                    iVar.i(ByteString.f44030d);
                    return;
                } catch (IOException e10) {
                    r(e10, null);
                    return;
                }
            }
            r(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f26322d + "ms (after " + (i10 - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // okhttp3.g0
    @k
    public b0 T() {
        return this.f26319a;
    }

    @Override // okhttp3.g0
    public boolean a(@k ByteString bytes) {
        f0.p(bytes, "bytes");
        return B(bytes, 2);
    }

    @Override // okhttp3.g0
    public boolean b(@k String text) {
        f0.p(text, "text");
        return B(ByteString.f44029c.l(text), 1);
    }

    @Override // dm.h.a
    public void c(@k ByteString bytes) throws IOException {
        f0.p(bytes, "bytes");
        this.f26320b.e(this, bytes);
    }

    @Override // okhttp3.g0
    public void cancel() {
        okhttp3.e eVar = this.f26326h;
        f0.m(eVar);
        eVar.cancel();
    }

    @Override // dm.h.a
    public void d(@k String text) throws IOException {
        f0.p(text, "text");
        this.f26320b.d(this, text);
    }

    @Override // dm.h.a
    public synchronized void e(@k ByteString payload) {
        f0.p(payload, "payload");
        if (!this.f26339u && (!this.f26336r || !this.f26334p.isEmpty())) {
            this.f26333o.add(payload);
            A();
            this.f26341w++;
        }
    }

    @Override // okhttp3.g0
    public boolean f(int i10, @l String str) {
        return p(i10, str, 60000L);
    }

    @Override // okhttp3.g0
    public synchronized long g() {
        return this.f26335q;
    }

    @Override // dm.h.a
    public synchronized void h(@k ByteString payload) {
        f0.p(payload, "payload");
        this.f26342x++;
        this.f26343y = false;
    }

    @Override // dm.h.a
    public void i(int i10, @k String reason) {
        d dVar;
        dm.h hVar;
        i iVar;
        f0.p(reason, "reason");
        boolean z10 = true;
        if (!(i10 != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.f26337s != -1) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalStateException("already closed".toString());
            }
            this.f26337s = i10;
            this.f26338t = reason;
            dVar = null;
            if (this.f26336r && this.f26334p.isEmpty()) {
                d dVar2 = this.f26332n;
                this.f26332n = null;
                hVar = this.f26328j;
                this.f26328j = null;
                iVar = this.f26329k;
                this.f26329k = null;
                this.f26330l.u();
                dVar = dVar2;
            } else {
                hVar = null;
                iVar = null;
            }
            z1 z1Var = z1.f38230a;
        }
        try {
            this.f26320b.b(this, i10, reason);
            if (dVar != null) {
                this.f26320b.a(this, i10, reason);
            }
        } finally {
            if (dVar != null) {
                rl.f.o(dVar);
            }
            if (hVar != null) {
                rl.f.o(hVar);
            }
            if (iVar != null) {
                rl.f.o(iVar);
            }
        }
    }

    public final void n(long j10, @k TimeUnit timeUnit) throws InterruptedException {
        f0.p(timeUnit, "timeUnit");
        this.f26330l.l().await(j10, timeUnit);
    }

    public final void o(@k okhttp3.d0 response, @l okhttp3.internal.connection.c cVar) throws IOException {
        f0.p(response, "response");
        if (response.W() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.W() + zc.f.f58383m + response.m1() + '\'');
        }
        String strM0 = okhttp3.d0.M0(response, HttpHeaders.CONNECTION, null, 2, null);
        if (!kotlin.text.u.L1(HttpHeaders.UPGRADE, strM0, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + ((Object) strM0) + '\'');
        }
        String strM02 = okhttp3.d0.M0(response, HttpHeaders.UPGRADE, null, 2, null);
        if (!kotlin.text.u.L1("websocket", strM02, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + ((Object) strM02) + '\'');
        }
        String strM03 = okhttp3.d0.M0(response, "Sec-WebSocket-Accept", null, 2, null);
        String strH = ByteString.f44029c.l(f0.C(this.f26325g, dm.g.f26370b)).u0().h();
        if (f0.g(strH, strM03)) {
            if (cVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strH + "' but was '" + ((Object) strM03) + '\'');
    }

    public final synchronized boolean p(int i10, @l String str, long j10) {
        dm.g.f26369a.d(i10);
        ByteString byteStringL = null;
        if (str != null) {
            byteStringL = ByteString.f44029c.l(str);
            if (!(((long) byteStringL.x0()) <= 123)) {
                throw new IllegalArgumentException(f0.C("reason.size() > 123: ", str).toString());
            }
        }
        if (!this.f26339u && !this.f26336r) {
            this.f26336r = true;
            this.f26334p.add(new a(i10, byteStringL, j10));
            A();
            return true;
        }
        return false;
    }

    public final void q(@k a0 client) {
        f0.p(client, "client");
        if (this.f26319a.i(dm.f.f26362h) != null) {
            r(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        a0 a0VarF = client.g0().r(r.NONE).f0(A).f();
        b0 b0VarB = this.f26319a.n().n(HttpHeaders.UPGRADE, "websocket").n(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).n("Sec-WebSocket-Key", this.f26325g).n("Sec-WebSocket-Version", "13").n(dm.f.f26362h, "permessage-deflate").b();
        okhttp3.internal.connection.e eVar = new okhttp3.internal.connection.e(a0VarF, b0VarB, true);
        this.f26326h = eVar;
        f0.m(eVar);
        eVar.b0(new f(b0VarB));
    }

    public final void r(@k Exception e10, @l okhttp3.d0 d0Var) {
        f0.p(e10, "e");
        synchronized (this) {
            if (this.f26339u) {
                return;
            }
            this.f26339u = true;
            d dVar = this.f26332n;
            this.f26332n = null;
            dm.h hVar = this.f26328j;
            this.f26328j = null;
            i iVar = this.f26329k;
            this.f26329k = null;
            this.f26330l.u();
            z1 z1Var = z1.f38230a;
            try {
                this.f26320b.c(this, e10, d0Var);
            } finally {
                if (dVar != null) {
                    rl.f.o(dVar);
                }
                if (hVar != null) {
                    rl.f.o(hVar);
                }
                if (iVar != null) {
                    rl.f.o(iVar);
                }
            }
        }
    }

    @k
    public final h0 s() {
        return this.f26320b;
    }

    public final void t(@k String name, @k d streams) throws IOException {
        f0.p(name, "name");
        f0.p(streams, "streams");
        dm.f fVar = this.f26323e;
        f0.m(fVar);
        synchronized (this) {
            this.f26331m = name;
            this.f26332n = streams;
            this.f26329k = new i(streams.a(), streams.c(), this.f26321c, fVar.f26363a, fVar.i(streams.a()), this.f26324f);
            this.f26327i = new C0299e(this);
            long j10 = this.f26322d;
            if (j10 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j10);
                this.f26330l.n(new g(f0.C(name, " ping"), this, nanos), nanos);
            }
            if (!this.f26334p.isEmpty()) {
                A();
            }
            z1 z1Var = z1.f38230a;
        }
        this.f26328j = new dm.h(streams.a(), streams.d(), this, fVar.f26363a, fVar.i(!streams.a()));
    }

    public final boolean u(dm.f fVar) {
        if (!fVar.f26368f && fVar.f26364b == null) {
            return fVar.f26366d == null || new m(8, 15).p(fVar.f26366d.intValue());
        }
        return false;
    }

    public final void v() throws IOException {
        while (this.f26337s == -1) {
            dm.h hVar = this.f26328j;
            f0.m(hVar);
            hVar.c();
        }
    }

    public final synchronized boolean w(@k ByteString payload) {
        f0.p(payload, "payload");
        if (!this.f26339u && (!this.f26336r || !this.f26334p.isEmpty())) {
            this.f26333o.add(payload);
            A();
            return true;
        }
        return false;
    }

    public final boolean x() throws IOException {
        try {
            dm.h hVar = this.f26328j;
            f0.m(hVar);
            hVar.c();
            return this.f26337s == -1;
        } catch (Exception e10) {
            r(e10, null);
            return false;
        }
    }

    public final synchronized int y() {
        return this.f26341w;
    }

    public final synchronized int z() {
        return this.f26342x;
    }
}
