package okhttp3.internal.cache;

import com.google.common.net.HttpHeaders;
import com.tencent.open.SocialConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.t;
import rl.f;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0003\u0005B\u001d\b\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache/c;", "", "Lokhttp3/b0;", "a", "Lokhttp3/b0;", "b", "()Lokhttp3/b0;", "networkRequest", "Lokhttp3/d0;", "Lokhttp3/d0;", "()Lokhttp3/d0;", "cacheResponse", "<init>", "(Lokhttp3/b0;Lokhttp3/d0;)V", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final a f43753c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final b0 f43754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final okhttp3.d0 f43755b;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lokhttp3/internal/cache/c$a;", "", "Lokhttp3/d0;", "response", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(@yt.k okhttp3.d0 r5, @yt.k okhttp3.b0 r6) {
            /*
                r4 = this;
                java.lang.String r0 = "response"
                kotlin.jvm.internal.f0.p(r5, r0)
                java.lang.String r0 = "request"
                kotlin.jvm.internal.f0.p(r6, r0)
                int r0 = r5.W()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L65
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L65
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L65
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L65
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L65
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L65
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L3b
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L65
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L65
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L65
                switch(r0) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r2
            L3b:
                r0 = 2
                java.lang.String r1 = "Expires"
                r3 = 0
                java.lang.String r0 = okhttp3.d0.M0(r5, r1, r3, r0, r3)
                if (r0 != 0) goto L65
                okhttp3.d r0 = r5.M()
                int r0 = r0.n()
                r1 = -1
                if (r0 != r1) goto L65
                okhttp3.d r0 = r5.M()
                boolean r0 = r0.m()
                if (r0 != 0) goto L65
                okhttp3.d r0 = r5.M()
                boolean r0 = r0.l()
                if (r0 != 0) goto L65
                return r2
            L65:
                okhttp3.d r5 = r5.M()
                boolean r5 = r5.s()
                if (r5 != 0) goto L7a
                okhttp3.d r5 = r6.g()
                boolean r5 = r5.s()
                if (r5 != 0) goto L7a
                r2 = 1
            L7a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.c.a.a(okhttp3.d0, okhttp3.b0):boolean");
        }
    }

    @d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\rR\u0018\u0010$\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lokhttp3/internal/cache/c$b;", "", "Lokhttp3/internal/cache/c;", "b", "", "g", "c", "", "d", "a", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "f", "J", "nowMillis", "Lokhttp3/b0;", "e", "()Lokhttp3/b0;", "Lokhttp3/d0;", "Lokhttp3/d0;", "cacheResponse", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "lastModified", "lastModifiedString", "h", "expires", "i", "sentRequestMillis", j.f55230b, "receivedResponseMillis", "k", "etag", "", com.flydigi.sdk.bluetooth.l.f16298a, "I", "ageSeconds", "<init>", "(JLokhttp3/b0;Lokhttp3/d0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f43756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public final b0 f43757b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final okhttp3.d0 f43758c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public Date f43759d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @l
        public String f43760e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @l
        public Date f43761f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @l
        public String f43762g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @l
        public Date f43763h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f43764i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f43765j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @l
        public String f43766k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f43767l;

        public b(long j10, @k b0 request, @l okhttp3.d0 d0Var) {
            f0.p(request, "request");
            this.f43756a = j10;
            this.f43757b = request;
            this.f43758c = d0Var;
            this.f43767l = -1;
            if (d0Var != null) {
                this.f43764i = d0Var.Y1();
                this.f43765j = d0Var.L1();
                t tVarH1 = d0Var.h1();
                int i10 = 0;
                int size = tVarH1.size();
                while (i10 < size) {
                    int i11 = i10 + 1;
                    String strJ = tVarH1.j(i10);
                    String strR = tVarH1.r(i10);
                    if (kotlin.text.u.L1(strJ, HttpHeaders.DATE, true)) {
                        this.f43759d = vl.c.a(strR);
                        this.f43760e = strR;
                    } else if (kotlin.text.u.L1(strJ, HttpHeaders.EXPIRES, true)) {
                        this.f43763h = vl.c.a(strR);
                    } else if (kotlin.text.u.L1(strJ, HttpHeaders.LAST_MODIFIED, true)) {
                        this.f43761f = vl.c.a(strR);
                        this.f43762g = strR;
                    } else if (kotlin.text.u.L1(strJ, HttpHeaders.ETAG, true)) {
                        this.f43766k = strR;
                    } else if (kotlin.text.u.L1(strJ, HttpHeaders.AGE, true)) {
                        this.f43767l = f.k0(strR, -1);
                    }
                    i10 = i11;
                }
            }
        }

        public final long a() {
            Date date = this.f43759d;
            long jMax = date != null ? Math.max(0L, this.f43765j - date.getTime()) : 0L;
            int i10 = this.f43767l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f43765j;
            return jMax + (j10 - this.f43764i) + (this.f43756a - j10);
        }

        @k
        public final c b() {
            c cVarC = c();
            return (cVarC.b() == null || !this.f43757b.g().u()) ? cVarC : new c(null, null);
        }

        public final c c() {
            if (this.f43758c == null) {
                return new c(this.f43757b, null);
            }
            if (this.f43757b.l() && this.f43758c.b0() == null) {
                return new c(this.f43757b, null);
            }
            if (!c.f43753c.a(this.f43758c, this.f43757b)) {
                return new c(this.f43757b, null);
            }
            okhttp3.d dVarG = this.f43757b.g();
            if (dVarG.r() || f(this.f43757b)) {
                return new c(this.f43757b, null);
            }
            okhttp3.d dVarM = this.f43758c.M();
            long jA = a();
            long jD = d();
            if (dVarG.n() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(dVarG.n()));
            }
            long millis = 0;
            long millis2 = dVarG.p() != -1 ? TimeUnit.SECONDS.toMillis(dVarG.p()) : 0L;
            if (!dVarM.q() && dVarG.o() != -1) {
                millis = TimeUnit.SECONDS.toMillis(dVarG.o());
            }
            if (!dVarM.r()) {
                long j10 = millis2 + jA;
                if (j10 < millis + jD) {
                    d0.a aVarS1 = this.f43758c.s1();
                    if (j10 >= jD) {
                        aVarS1.a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && g()) {
                        aVarS1.a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, aVarS1.c());
                }
            }
            String str = this.f43766k;
            String str2 = HttpHeaders.IF_MODIFIED_SINCE;
            if (str != null) {
                str2 = HttpHeaders.IF_NONE_MATCH;
            } else if (this.f43761f != null) {
                str = this.f43762g;
            } else {
                if (this.f43759d == null) {
                    return new c(this.f43757b, null);
                }
                str = this.f43760e;
            }
            t.a aVarM = this.f43757b.k().m();
            f0.m(str);
            aVarM.g(str2, str);
            return new c(this.f43757b.n().o(aVarM.i()).b(), this.f43758c);
        }

        public final long d() {
            Long lValueOf;
            okhttp3.d0 d0Var = this.f43758c;
            f0.m(d0Var);
            if (d0Var.M().n() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.n());
            }
            Date date = this.f43763h;
            if (date != null) {
                Date date2 = this.f43759d;
                lValueOf = date2 != null ? Long.valueOf(date2.getTime()) : null;
                long time = date.getTime() - (lValueOf == null ? this.f43765j : lValueOf.longValue());
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f43761f == null || this.f43758c.V1().q().O() != null) {
                return 0L;
            }
            Date date3 = this.f43759d;
            lValueOf = date3 != null ? Long.valueOf(date3.getTime()) : null;
            long jLongValue = lValueOf == null ? this.f43764i : lValueOf.longValue();
            Date date4 = this.f43761f;
            f0.m(date4);
            long time2 = jLongValue - date4.getTime();
            if (time2 > 0) {
                return time2 / ((long) 10);
            }
            return 0L;
        }

        @k
        public final b0 e() {
            return this.f43757b;
        }

        public final boolean f(b0 b0Var) {
            return (b0Var.i(HttpHeaders.IF_MODIFIED_SINCE) == null && b0Var.i(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }

        public final boolean g() {
            okhttp3.d0 d0Var = this.f43758c;
            f0.m(d0Var);
            return d0Var.M().n() == -1 && this.f43763h == null;
        }
    }

    public c(@l b0 b0Var, @l okhttp3.d0 d0Var) {
        this.f43754a = b0Var;
        this.f43755b = d0Var;
    }

    @l
    public final okhttp3.d0 a() {
        return this.f43755b;
    }

    @l
    public final b0 b() {
        return this.f43754a;
    }
}
