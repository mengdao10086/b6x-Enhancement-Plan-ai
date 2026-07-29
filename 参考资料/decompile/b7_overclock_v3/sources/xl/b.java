package xl;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import fh.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okio.ByteString;
import okio.t0;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0010B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lxl/b;", "", "Lokio/ByteString;", "name", "a", "", "", "d", "", "Lxl/a;", "STATIC_HEADER_TABLE", "[Lxl/a;", "c", "()[Lxl/a;", "NAME_TO_FIRST_INDEX", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final b f55371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f55372b = 15;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55373c = 31;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55374d = 63;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55375e = 127;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55376f = 4096;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55377g = 16384;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final xl.a[] f55378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final Map<ByteString, Integer> f55379i;

    static {
        b bVar = new b();
        f55371a = bVar;
        ByteString byteString = xl.a.f55364l;
        ByteString byteString2 = xl.a.f55365m;
        ByteString byteString3 = xl.a.f55366n;
        ByteString byteString4 = xl.a.f55363k;
        f55378h = new xl.a[]{new xl.a(xl.a.f55367o, ""), new xl.a(byteString, Constants.HTTP_GET), new xl.a(byteString, Constants.HTTP_POST), new xl.a(byteString2, fh.a.f28350w), new xl.a(byteString2, "/index.html"), new xl.a(byteString3, "http"), new xl.a(byteString3, "https"), new xl.a(byteString4, "200"), new xl.a(byteString4, "204"), new xl.a(byteString4, "206"), new xl.a(byteString4, "304"), new xl.a(byteString4, "400"), new xl.a(byteString4, "404"), new xl.a(byteString4, "500"), new xl.a("accept-charset", ""), new xl.a("accept-encoding", "gzip, deflate"), new xl.a("accept-language", ""), new xl.a("accept-ranges", ""), new xl.a(a.g.f28415f, ""), new xl.a("access-control-allow-origin", ""), new xl.a("age", ""), new xl.a("allow", ""), new xl.a("authorization", ""), new xl.a("cache-control", ""), new xl.a("content-disposition", ""), new xl.a("content-encoding", ""), new xl.a("content-language", ""), new xl.a(fh.e.f28449f, ""), new xl.a("content-location", ""), new xl.a("content-range", ""), new xl.a(fh.e.f28453j, ""), new xl.a("cookie", ""), new xl.a(fh.e.f28447d, ""), new xl.a("etag", ""), new xl.a("expect", ""), new xl.a("expires", ""), new xl.a(w.h.f53783c, ""), new xl.a(e.f55523k, ""), new xl.a("if-match", ""), new xl.a("if-modified-since", ""), new xl.a("if-none-match", ""), new xl.a("if-range", ""), new xl.a("if-unmodified-since", ""), new xl.a("last-modified", ""), new xl.a("link", ""), new xl.a(SocializeConstants.KEY_LOCATION, ""), new xl.a("max-forwards", ""), new xl.a("proxy-authenticate", ""), new xl.a("proxy-authorization", ""), new xl.a("range", ""), new xl.a("referer", ""), new xl.a("refresh", ""), new xl.a("retry-after", ""), new xl.a("server", ""), new xl.a("set-cookie", ""), new xl.a("strict-transport-security", ""), new xl.a(e.f55526n, ""), new xl.a("user-agent", ""), new xl.a("vary", ""), new xl.a(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, ""), new xl.a("www-authenticate", "")};
        f55379i = bVar.d();
    }

    @yt.k
    public final ByteString a(@yt.k ByteString name) throws IOException {
        f0.p(name, "name");
        int iX0 = name.x0();
        int i10 = 0;
        while (i10 < iX0) {
            int i11 = i10 + 1;
            byte bV = name.v(i10);
            if (65 <= bV && bV <= 90) {
                throw new IOException(f0.C("PROTOCOL_ERROR response malformed: mixed case name: ", name.O0()));
            }
            i10 = i11;
        }
        return name;
    }

    @yt.k
    public final Map<ByteString, Integer> b() {
        return f55379i;
    }

    @yt.k
    public final xl.a[] c() {
        return f55378h;
    }

    public final Map<ByteString, Integer> d() {
        xl.a[] aVarArr = f55378h;
        LinkedHashMap linkedHashMap = new LinkedHashMap(aVarArr.length);
        int length = aVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            xl.a[] aVarArr2 = f55378h;
            if (!linkedHashMap.containsKey(aVarArr2[i10].f55368a)) {
                linkedHashMap.put(aVarArr2[i10].f55368a, Integer.valueOf(i10));
            }
            i10 = i11;
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        f0.o(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    @d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002¨\u0006&"}, d2 = {"Lxl/b$a;", "", "", "Lxl/a;", "e", "", "i", "Lkotlin/z1;", l.f16298a, "firstByte", "prefixMask", "n", "Lokio/ByteString;", "k", "a", "b", "bytesToRecover", "d", "index", m0.k.f40564b, "c", "q", SsManifestParser.e.J, "nameIndex", "o", "p", "f", "", "h", "entry", "g", xf.j.f55230b, "Lokio/t0;", "source", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lokio/t0;II)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f55381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<xl.a> f55382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final okio.l f55383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @hk.e
        @yt.k
        public xl.a[] f55384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f55385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @hk.e
        public int f55386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @hk.e
        public int f55387h;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @hk.i
        public a(@yt.k t0 source, int i10) {
            this(source, i10, 0, 4, null);
            f0.p(source, "source");
        }

        @hk.i
        public a(@yt.k t0 source, int i10, int i11) {
            f0.p(source, "source");
            this.f55380a = i10;
            this.f55381b = i11;
            this.f55382c = new ArrayList();
            this.f55383d = okio.f0.e(source);
            this.f55384e = new xl.a[8];
            this.f55385f = r2.length - 1;
        }

        public final void a() {
            int i10 = this.f55381b;
            int i11 = this.f55387h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            m.w2(this.f55384e, null, 0, 0, 6, null);
            this.f55385f = this.f55384e.length - 1;
            this.f55386g = 0;
            this.f55387h = 0;
        }

        public final int c(int i10) {
            return this.f55385f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f55384e.length;
                while (true) {
                    length--;
                    i11 = this.f55385f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    xl.a aVar = this.f55384e[length];
                    f0.m(aVar);
                    int i13 = aVar.f55370c;
                    i10 -= i13;
                    this.f55387h -= i13;
                    this.f55386g--;
                    i12++;
                }
                xl.a[] aVarArr = this.f55384e;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f55386g);
                this.f55385f += i12;
            }
            return i12;
        }

        @yt.k
        public final List<xl.a> e() {
            List<xl.a> listQ5 = CollectionsKt___CollectionsKt.Q5(this.f55382c);
            this.f55382c.clear();
            return listQ5;
        }

        public final ByteString f(int i10) throws IOException {
            if (h(i10)) {
                return b.f55371a.c()[i10].f55368a;
            }
            int iC = c(i10 - b.f55371a.c().length);
            if (iC >= 0) {
                xl.a[] aVarArr = this.f55384e;
                if (iC < aVarArr.length) {
                    xl.a aVar = aVarArr[iC];
                    f0.m(aVar);
                    return aVar.f55368a;
                }
            }
            throw new IOException(f0.C("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        public final void g(int i10, xl.a aVar) {
            this.f55382c.add(aVar);
            int i11 = aVar.f55370c;
            if (i10 != -1) {
                xl.a aVar2 = this.f55384e[c(i10)];
                f0.m(aVar2);
                i11 -= aVar2.f55370c;
            }
            int i12 = this.f55381b;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f55387h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f55386g + 1;
                xl.a[] aVarArr = this.f55384e;
                if (i13 > aVarArr.length) {
                    xl.a[] aVarArr2 = new xl.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f55385f = this.f55384e.length - 1;
                    this.f55384e = aVarArr2;
                }
                int i14 = this.f55385f;
                this.f55385f = i14 - 1;
                this.f55384e[i14] = aVar;
                this.f55386g++;
            } else {
                this.f55384e[i10 + c(i10) + iD] = aVar;
            }
            this.f55387h += i11;
        }

        public final boolean h(int i10) {
            return i10 >= 0 && i10 <= b.f55371a.c().length - 1;
        }

        public final int i() {
            return this.f55381b;
        }

        public final int j() throws IOException {
            return rl.f.d(this.f55383d.readByte(), 255);
        }

        @yt.k
        public final ByteString k() throws IOException {
            int iJ = j();
            boolean z10 = (iJ & 128) == 128;
            long jN = n(iJ, 127);
            if (!z10) {
                return this.f55383d.y(jN);
            }
            okio.j jVar = new okio.j();
            i.f55587a.b(this.f55383d, jN, jVar);
            return jVar.Z0();
        }

        public final void l() throws IOException {
            while (!this.f55383d.d0()) {
                int iD = rl.f.d(this.f55383d.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & 128) == 128) {
                    m(n(iD, 127) - 1);
                } else if (iD == 64) {
                    p();
                } else if ((iD & 64) == 64) {
                    o(n(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iN = n(iD, 31);
                    this.f55381b = iN;
                    if (iN < 0 || iN > this.f55380a) {
                        throw new IOException(f0.C("Invalid dynamic table size update ", Integer.valueOf(this.f55381b)));
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    r();
                } else {
                    q(n(iD, 15) - 1);
                }
            }
        }

        public final void m(int i10) throws IOException {
            if (h(i10)) {
                this.f55382c.add(b.f55371a.c()[i10]);
                return;
            }
            int iC = c(i10 - b.f55371a.c().length);
            if (iC >= 0) {
                xl.a[] aVarArr = this.f55384e;
                if (iC < aVarArr.length) {
                    List<xl.a> list = this.f55382c;
                    xl.a aVar = aVarArr[iC];
                    f0.m(aVar);
                    list.add(aVar);
                    return;
                }
            }
            throw new IOException(f0.C("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        public final int n(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i11 + (iJ << i13);
                }
                i11 += (iJ & 127) << i13;
                i13 += 7;
            }
        }

        public final void o(int i10) throws IOException {
            g(-1, new xl.a(f(i10), k()));
        }

        public final void p() throws IOException {
            g(-1, new xl.a(b.f55371a.a(k()), k()));
        }

        public final void q(int i10) throws IOException {
            this.f55382c.add(new xl.a(f(i10), k()));
        }

        public final void r() throws IOException {
            this.f55382c.add(new xl.a(b.f55371a.a(k()), k()));
        }

        public /* synthetic */ a(t0 t0Var, int i10, int i11, int i12, u uVar) {
            this(t0Var, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* JADX INFO: renamed from: xl.b$b, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002¨\u0006\u001d"}, d2 = {"Lxl/b$b;", "", "", "Lxl/a;", "headerBlock", "Lkotlin/z1;", "g", "", "value", "prefixMask", "bits", "h", "Lokio/ByteString;", "data", "f", "headerTableSizeSetting", "e", "b", "bytesToRecover", "c", "entry", "d", "a", "", "useCompression", "Lokio/j;", "out", "<init>", "(IZLokio/j;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0653b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @hk.e
        public int f55388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f55389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final okio.j f55390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f55391d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f55392e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @hk.e
        public int f55393f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @hk.e
        @yt.k
        public xl.a[] f55394g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f55395h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @hk.e
        public int f55396i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @hk.e
        public int f55397j;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @hk.i
        public C0653b(int i10, @yt.k okio.j out) {
            this(i10, false, out, 2, null);
            f0.p(out, "out");
        }

        @hk.i
        public C0653b(int i10, boolean z10, @yt.k okio.j out) {
            f0.p(out, "out");
            this.f55388a = i10;
            this.f55389b = z10;
            this.f55390c = out;
            this.f55391d = Integer.MAX_VALUE;
            this.f55393f = i10;
            this.f55394g = new xl.a[8];
            this.f55395h = r2.length - 1;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @hk.i
        public C0653b(@yt.k okio.j out) {
            this(0, false, out, 3, null);
            f0.p(out, "out");
        }

        public final void a() {
            int i10 = this.f55393f;
            int i11 = this.f55397j;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        public final void b() {
            m.w2(this.f55394g, null, 0, 0, 6, null);
            this.f55395h = this.f55394g.length - 1;
            this.f55396i = 0;
            this.f55397j = 0;
        }

        public final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f55394g.length;
                while (true) {
                    length--;
                    i11 = this.f55395h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    xl.a aVar = this.f55394g[length];
                    f0.m(aVar);
                    i10 -= aVar.f55370c;
                    int i13 = this.f55397j;
                    xl.a aVar2 = this.f55394g[length];
                    f0.m(aVar2);
                    this.f55397j = i13 - aVar2.f55370c;
                    this.f55396i--;
                    i12++;
                }
                xl.a[] aVarArr = this.f55394g;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f55396i);
                xl.a[] aVarArr2 = this.f55394g;
                int i14 = this.f55395h;
                Arrays.fill(aVarArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f55395h += i12;
            }
            return i12;
        }

        public final void d(xl.a aVar) {
            int i10 = aVar.f55370c;
            int i11 = this.f55393f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f55397j + i10) - i11);
            int i12 = this.f55396i + 1;
            xl.a[] aVarArr = this.f55394g;
            if (i12 > aVarArr.length) {
                xl.a[] aVarArr2 = new xl.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f55395h = this.f55394g.length - 1;
                this.f55394g = aVarArr2;
            }
            int i13 = this.f55395h;
            this.f55395h = i13 - 1;
            this.f55394g[i13] = aVar;
            this.f55396i++;
            this.f55397j += i10;
        }

        public final void e(int i10) {
            this.f55388a = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f55393f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f55391d = Math.min(this.f55391d, iMin);
            }
            this.f55392e = true;
            this.f55393f = iMin;
            a();
        }

        public final void f(@yt.k ByteString data) throws IOException {
            f0.p(data, "data");
            if (this.f55389b) {
                i iVar = i.f55587a;
                if (iVar.d(data) < data.x0()) {
                    okio.j jVar = new okio.j();
                    iVar.c(data, jVar);
                    ByteString byteStringZ0 = jVar.Z0();
                    h(byteStringZ0.x0(), 127, 128);
                    this.f55390c.B1(byteStringZ0);
                    return;
                }
            }
            h(data.x0(), 127, 0);
            this.f55390c.B1(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(@yt.k java.util.List<xl.a> r15) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 271
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xl.b.C0653b.g(java.util.List):void");
        }

        public final void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f55390c.writeByte(i10 | i12);
                return;
            }
            this.f55390c.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f55390c.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f55390c.writeByte(i13);
        }

        public /* synthetic */ C0653b(int i10, boolean z10, okio.j jVar, int i11, u uVar) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, jVar);
        }
    }
}
