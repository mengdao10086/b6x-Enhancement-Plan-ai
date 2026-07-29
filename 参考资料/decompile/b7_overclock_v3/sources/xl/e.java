package xl;

import com.google.common.net.HttpHeaders;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.t;
import okio.r0;
import okio.t0;
import okio.v0;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lxl/e;", "Lvl/d;", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "", "contentLength", "Lokio/r0;", "i", "Lkotlin/z1;", "b", "f", "a", "", "expectContinue", "Lokhttp3/d0$a;", "d", "Lokhttp3/d0;", "response", "g", "Lokio/t0;", "c", "Lokhttp3/t;", "h", CommonNetImpl.CANCEL, "Lokhttp3/internal/connection/RealConnection;", e.f55522j, "Lokhttp3/internal/connection/RealConnection;", "e", "()Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/a0;", "client", "Lvl/g;", "chain", "Lxl/d;", "http2Connection", "<init>", "(Lokhttp3/a0;Lokhttp3/internal/connection/RealConnection;Lvl/g;Lxl/d;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e implements vl.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final RealConnection f55532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final vl.g f55533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final d f55534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public volatile g f55535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final Protocol f55536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f55537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f55521i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final String f55522j = "connection";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final String f55523k = "host";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public static final String f55524l = "keep-alive";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public static final String f55525m = "proxy-connection";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public static final String f55527o = "te";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public static final String f55526n = "transfer-encoding";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public static final String f55528p = "encoding";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.k
    public static final String f55529q = "upgrade";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.k
    public static final List<String> f55530r = rl.f.C(f55522j, f55523k, f55524l, f55525m, f55527o, f55526n, f55528p, f55529q, xl.a.f55359g, xl.a.f55360h, xl.a.f55361i, xl.a.f55362j);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @yt.k
    public static final List<String> f55531s = rl.f.C(f55522j, f55523k, f55524l, f55525m, f55527o, f55526n, f55528p, f55529q);

    @d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lxl/e$a;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "", "Lxl/a;", "a", "Lokhttp3/t;", "headerBlock", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/d0$a;", "b", "", "CONNECTION", "Ljava/lang/String;", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", HttpHeaders.TE, "TRANSFER_ENCODING", "UPGRADE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final List<xl.a> a(@yt.k b0 request) {
            f0.p(request, "request");
            t tVarK = request.k();
            ArrayList arrayList = new ArrayList(tVarK.size() + 4);
            arrayList.add(new xl.a(xl.a.f55364l, request.m()));
            arrayList.add(new xl.a(xl.a.f55365m, vl.i.f53218a.c(request.q())));
            String strI = request.i(HttpHeaders.HOST);
            if (strI != null) {
                arrayList.add(new xl.a(xl.a.f55367o, strI));
            }
            arrayList.add(new xl.a(xl.a.f55366n, request.q().X()));
            int i10 = 0;
            int size = tVarK.size();
            while (i10 < size) {
                int i11 = i10 + 1;
                String strJ = tVarK.j(i10);
                Locale US = Locale.US;
                f0.o(US, "US");
                String lowerCase = strJ.toLowerCase(US);
                f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!e.f55530r.contains(lowerCase) || (f0.g(lowerCase, e.f55527o) && f0.g(tVarK.r(i10), "trailers"))) {
                    arrayList.add(new xl.a(lowerCase, tVarK.r(i10)));
                }
                i10 = i11;
            }
            return arrayList;
        }

        @yt.k
        public final d0.a b(@yt.k t headerBlock, @yt.k Protocol protocol) throws IOException {
            f0.p(headerBlock, "headerBlock");
            f0.p(protocol, "protocol");
            t.a aVar = new t.a();
            int size = headerBlock.size();
            vl.k kVarB = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                String strJ = headerBlock.j(i10);
                String strR = headerBlock.r(i10);
                if (f0.g(strJ, xl.a.f55358f)) {
                    kVarB = vl.k.f53222d.b(f0.C("HTTP/1.1 ", strR));
                } else if (!e.f55531s.contains(strJ)) {
                    aVar.g(strJ, strR);
                }
                i10 = i11;
            }
            if (kVarB != null) {
                return new d0.a().B(protocol).g(kVarB.f53228b).y(kVarB.f53229c).w(aVar.i());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public e(@yt.k a0 client, @yt.k RealConnection connection, @yt.k vl.g chain, @yt.k d http2Connection) {
        f0.p(client, "client");
        f0.p(connection, "connection");
        f0.p(chain, "chain");
        f0.p(http2Connection, "http2Connection");
        this.f55532c = connection;
        this.f55533d = chain;
        this.f55534e = http2Connection;
        List<Protocol> listI0 = client.i0();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f55536g = listI0.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // vl.d
    public void a() throws IOException {
        g gVar = this.f55535f;
        f0.m(gVar);
        gVar.o().close();
    }

    @Override // vl.d
    public void b(@yt.k b0 request) throws IOException {
        f0.p(request, "request");
        if (this.f55535f != null) {
            return;
        }
        this.f55535f = this.f55534e.j2(f55521i.a(request), request.f() != null);
        if (this.f55537h) {
            g gVar = this.f55535f;
            f0.m(gVar);
            gVar.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        g gVar2 = this.f55535f;
        f0.m(gVar2);
        v0 v0VarX = gVar2.x();
        long jN = this.f55533d.n();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v0VarX.i(jN, timeUnit);
        g gVar3 = this.f55535f;
        f0.m(gVar3);
        gVar3.L().i(this.f55533d.p(), timeUnit);
    }

    @Override // vl.d
    @yt.k
    public t0 c(@yt.k okhttp3.d0 response) {
        f0.p(response, "response");
        g gVar = this.f55535f;
        f0.m(gVar);
        return gVar.r();
    }

    @Override // vl.d
    public void cancel() {
        this.f55537h = true;
        g gVar = this.f55535f;
        if (gVar == null) {
            return;
        }
        gVar.f(ErrorCode.CANCEL);
    }

    @Override // vl.d
    @l
    public d0.a d(boolean z10) throws IOException {
        g gVar = this.f55535f;
        f0.m(gVar);
        d0.a aVarB = f55521i.b(gVar.H(), this.f55536g);
        if (z10 && aVarB.j() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // vl.d
    @yt.k
    public RealConnection e() {
        return this.f55532c;
    }

    @Override // vl.d
    public void f() throws IOException {
        this.f55534e.flush();
    }

    @Override // vl.d
    public long g(@yt.k okhttp3.d0 response) {
        f0.p(response, "response");
        if (vl.e.c(response)) {
            return rl.f.A(response);
        }
        return 0L;
    }

    @Override // vl.d
    @yt.k
    public t h() {
        g gVar = this.f55535f;
        f0.m(gVar);
        return gVar.I();
    }

    @Override // vl.d
    @yt.k
    public r0 i(@yt.k b0 request, long j10) {
        f0.p(request, "request");
        g gVar = this.f55535f;
        f0.m(gVar);
        return gVar.o();
    }
}
