package ya;

import android.net.Uri;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import ya.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.p0
    public final g f57132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f57133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w0 f57134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f57135e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f57136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public final Object f57137b;

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f57136a.equals(bVar.f57136a) && hd.u0.c(this.f57137b, bVar.f57137b);
        }

        public int hashCode() {
            int iHashCode = this.f57136a.hashCode() * 31;
            Object obj = this.f57137b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }

        public b(Uri uri, @g.p0 Object obj) {
            this.f57136a = uri;
            this.f57137b = obj;
        }
    }

    public static final class c {
        public float A;
        public float B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public String f57138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public Uri f57139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.p0
        public String f57140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f57141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f57142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f57143f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f57144g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f57145h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @g.p0
        public Uri f57146i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, String> f57147j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @g.p0
        public UUID f57148k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f57149l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f57150m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f57151n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List<Integer> f57152o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @g.p0
        public byte[] f57153p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List<StreamKey> f57154q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @g.p0
        public String f57155r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<h> f57156s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @g.p0
        public Uri f57157t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @g.p0
        public Object f57158u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @g.p0
        public Object f57159v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @g.p0
        public w0 f57160w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f57161x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f57162y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f57163z;

        public c A(w0 w0Var) {
            this.f57160w = w0Var;
            return this;
        }

        public c B(@g.p0 String str) {
            this.f57140c = str;
            return this;
        }

        public c C(@g.p0 List<StreamKey> list) {
            this.f57154q = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c D(@g.p0 List<h> list) {
            this.f57156s = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c E(@g.p0 Object obj) {
            this.f57159v = obj;
            return this;
        }

        public c F(@g.p0 Uri uri) {
            this.f57139b = uri;
            return this;
        }

        public c G(@g.p0 String str) {
            return F(str == null ? null : Uri.parse(str));
        }

        public v0 a() {
            g gVar;
            hd.a.i(this.f57146i == null || this.f57148k != null);
            Uri uri = this.f57139b;
            if (uri != null) {
                String str = this.f57140c;
                UUID uuid = this.f57148k;
                e eVar = uuid != null ? new e(uuid, this.f57146i, this.f57147j, this.f57149l, this.f57151n, this.f57150m, this.f57152o, this.f57153p) : null;
                Uri uri2 = this.f57157t;
                g gVar2 = new g(uri, str, eVar, uri2 != null ? new b(uri2, this.f57158u) : null, this.f57154q, this.f57155r, this.f57156s, this.f57159v);
                String string = this.f57138a;
                if (string == null) {
                    string = uri.toString();
                }
                this.f57138a = string;
                gVar = gVar2;
            } else {
                gVar = null;
            }
            String str2 = (String) hd.a.g(this.f57138a);
            d dVar = new d(this.f57141d, this.f57142e, this.f57143f, this.f57144g, this.f57145h);
            f fVar = new f(this.f57161x, this.f57162y, this.f57163z, this.A, this.B);
            w0 w0VarA = this.f57160w;
            if (w0VarA == null) {
                w0VarA = new w0.b().a();
            }
            return new v0(str2, dVar, gVar, fVar, w0VarA);
        }

        public c b(@g.p0 Uri uri) {
            return c(uri, null);
        }

        public c c(@g.p0 Uri uri, @g.p0 Object obj) {
            this.f57157t = uri;
            this.f57158u = obj;
            return this;
        }

        public c d(@g.p0 String str) {
            return b(str != null ? Uri.parse(str) : null);
        }

        public c e(long j10) {
            hd.a.a(j10 == Long.MIN_VALUE || j10 >= 0);
            this.f57142e = j10;
            return this;
        }

        public c f(boolean z10) {
            this.f57144g = z10;
            return this;
        }

        public c g(boolean z10) {
            this.f57143f = z10;
            return this;
        }

        public c h(long j10) {
            hd.a.a(j10 >= 0);
            this.f57141d = j10;
            return this;
        }

        public c i(boolean z10) {
            this.f57145h = z10;
            return this;
        }

        public c j(@g.p0 String str) {
            this.f57155r = str;
            return this;
        }

        public c k(boolean z10) {
            this.f57151n = z10;
            return this;
        }

        public c l(@g.p0 byte[] bArr) {
            this.f57153p = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public c m(@g.p0 Map<String, String> map) {
            this.f57147j = (map == null || map.isEmpty()) ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(map));
            return this;
        }

        public c n(@g.p0 Uri uri) {
            this.f57146i = uri;
            return this;
        }

        public c o(@g.p0 String str) {
            this.f57146i = str == null ? null : Uri.parse(str);
            return this;
        }

        public c p(boolean z10) {
            this.f57149l = z10;
            return this;
        }

        public c q(boolean z10) {
            this.f57150m = z10;
            return this;
        }

        public c r(boolean z10) {
            s(z10 ? Arrays.asList(2, 1) : Collections.emptyList());
            return this;
        }

        public c s(@g.p0 List<Integer> list) {
            this.f57152o = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c t(@g.p0 UUID uuid) {
            this.f57148k = uuid;
            return this;
        }

        public c u(long j10) {
            this.f57163z = j10;
            return this;
        }

        public c v(float f10) {
            this.B = f10;
            return this;
        }

        public c w(long j10) {
            this.f57162y = j10;
            return this;
        }

        public c x(float f10) {
            this.A = f10;
            return this;
        }

        public c y(long j10) {
            this.f57161x = j10;
            return this;
        }

        public c z(@g.p0 String str) {
            this.f57138a = str;
            return this;
        }

        public c() {
            this.f57142e = Long.MIN_VALUE;
            this.f57152o = Collections.emptyList();
            this.f57147j = Collections.emptyMap();
            this.f57154q = Collections.emptyList();
            this.f57156s = Collections.emptyList();
            this.f57161x = ya.g.f56663b;
            this.f57162y = ya.g.f56663b;
            this.f57163z = ya.g.f56663b;
            this.A = -3.4028235E38f;
            this.B = -3.4028235E38f;
        }

        public c(v0 v0Var) {
            this();
            d dVar = v0Var.f57135e;
            this.f57142e = dVar.f57165b;
            this.f57143f = dVar.f57166c;
            this.f57144g = dVar.f57167d;
            this.f57141d = dVar.f57164a;
            this.f57145h = dVar.f57168e;
            this.f57138a = v0Var.f57131a;
            this.f57160w = v0Var.f57134d;
            f fVar = v0Var.f57133c;
            this.f57161x = fVar.f57178a;
            this.f57162y = fVar.f57179b;
            this.f57163z = fVar.f57180c;
            this.A = fVar.f57181d;
            this.B = fVar.f57182e;
            g gVar = v0Var.f57132b;
            if (gVar != null) {
                this.f57155r = gVar.f57188f;
                this.f57140c = gVar.f57184b;
                this.f57139b = gVar.f57183a;
                this.f57154q = gVar.f57187e;
                this.f57156s = gVar.f57189g;
                this.f57159v = gVar.f57190h;
                e eVar = gVar.f57185c;
                if (eVar != null) {
                    this.f57146i = eVar.f57170b;
                    this.f57147j = eVar.f57171c;
                    this.f57149l = eVar.f57172d;
                    this.f57151n = eVar.f57174f;
                    this.f57150m = eVar.f57173e;
                    this.f57152o = eVar.f57175g;
                    this.f57148k = eVar.f57169a;
                    this.f57153p = eVar.a();
                }
                b bVar = gVar.f57186d;
                if (bVar != null) {
                    this.f57157t = bVar.f57136a;
                    this.f57158u = bVar.f57137b;
                }
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f57164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f57165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f57166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f57167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f57168e;

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f57164a == dVar.f57164a && this.f57165b == dVar.f57165b && this.f57166c == dVar.f57166c && this.f57167d == dVar.f57167d && this.f57168e == dVar.f57168e;
        }

        public int hashCode() {
            long j10 = this.f57164a;
            int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
            long j11 = this.f57165b;
            return ((((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f57166c ? 1 : 0)) * 31) + (this.f57167d ? 1 : 0)) * 31) + (this.f57168e ? 1 : 0);
        }

        public d(long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.f57164a = j10;
            this.f57165b = j11;
            this.f57166c = z10;
            this.f57167d = z11;
            this.f57168e = z12;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f57169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public final Uri f57170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f57171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f57172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f57173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f57174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<Integer> f57175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @g.p0
        public final byte[] f57176h;

        @g.p0
        public byte[] a() {
            byte[] bArr = this.f57176h;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f57169a.equals(eVar.f57169a) && hd.u0.c(this.f57170b, eVar.f57170b) && hd.u0.c(this.f57171c, eVar.f57171c) && this.f57172d == eVar.f57172d && this.f57174f == eVar.f57174f && this.f57173e == eVar.f57173e && this.f57175g.equals(eVar.f57175g) && Arrays.equals(this.f57176h, eVar.f57176h);
        }

        public int hashCode() {
            int iHashCode = this.f57169a.hashCode() * 31;
            Uri uri = this.f57170b;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f57171c.hashCode()) * 31) + (this.f57172d ? 1 : 0)) * 31) + (this.f57174f ? 1 : 0)) * 31) + (this.f57173e ? 1 : 0)) * 31) + this.f57175g.hashCode()) * 31) + Arrays.hashCode(this.f57176h);
        }

        public e(UUID uuid, @g.p0 Uri uri, Map<String, String> map, boolean z10, boolean z11, boolean z12, List<Integer> list, @g.p0 byte[] bArr) {
            hd.a.a((z11 && uri == null) ? false : true);
            this.f57169a = uuid;
            this.f57170b = uri;
            this.f57171c = map;
            this.f57172d = z10;
            this.f57174f = z11;
            this.f57173e = z12;
            this.f57175g = list;
            this.f57176h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f57177f = new f(ya.g.f56663b, ya.g.f56663b, ya.g.f56663b, -3.4028235E38f, -3.4028235E38f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f57178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f57179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f57180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f57181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f57182e;

        public f(long j10, long j11, long j12, float f10, float f11) {
            this.f57178a = j10;
            this.f57179b = j11;
            this.f57180c = j12;
            this.f57181d = f10;
            this.f57182e = f11;
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f57178a == fVar.f57178a && this.f57179b == fVar.f57179b && this.f57180c == fVar.f57180c && this.f57181d == fVar.f57181d && this.f57182e == fVar.f57182e;
        }

        public int hashCode() {
            long j10 = this.f57178a;
            long j11 = this.f57179b;
            int i10 = ((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f57180c;
            int i11 = (i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            float f10 = this.f57181d;
            int iFloatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
            float f11 = this.f57182e;
            return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f57183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.p0
        public final String f57184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.p0
        public final e f57185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public final b f57186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<StreamKey> f57187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @g.p0
        public final String f57188f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<h> f57189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @g.p0
        public final Object f57190h;

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f57183a.equals(gVar.f57183a) && hd.u0.c(this.f57184b, gVar.f57184b) && hd.u0.c(this.f57185c, gVar.f57185c) && hd.u0.c(this.f57186d, gVar.f57186d) && this.f57187e.equals(gVar.f57187e) && hd.u0.c(this.f57188f, gVar.f57188f) && this.f57189g.equals(gVar.f57189g) && hd.u0.c(this.f57190h, gVar.f57190h);
        }

        public int hashCode() {
            int iHashCode = this.f57183a.hashCode() * 31;
            String str = this.f57184b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            e eVar = this.f57185c;
            int iHashCode3 = (iHashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            b bVar = this.f57186d;
            int iHashCode4 = (((iHashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.f57187e.hashCode()) * 31;
            String str2 = this.f57188f;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f57189g.hashCode()) * 31;
            Object obj = this.f57190h;
            return iHashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        public g(Uri uri, @g.p0 String str, @g.p0 e eVar, @g.p0 b bVar, List<StreamKey> list, @g.p0 String str2, List<h> list2, @g.p0 Object obj) {
            this.f57183a = uri;
            this.f57184b = str;
            this.f57185c = eVar;
            this.f57186d = bVar;
            this.f57187e = list;
            this.f57188f = str2;
            this.f57189g = list2;
            this.f57190h = obj;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f57191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f57192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.p0
        public final String f57193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f57194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f57195e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @g.p0
        public final String f57196f;

        public h(Uri uri, String str, @g.p0 String str2) {
            this(uri, str, str2, 0);
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f57191a.equals(hVar.f57191a) && this.f57192b.equals(hVar.f57192b) && hd.u0.c(this.f57193c, hVar.f57193c) && this.f57194d == hVar.f57194d && this.f57195e == hVar.f57195e && hd.u0.c(this.f57196f, hVar.f57196f);
        }

        public int hashCode() {
            int iHashCode = ((this.f57191a.hashCode() * 31) + this.f57192b.hashCode()) * 31;
            String str = this.f57193c;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f57194d) * 31) + this.f57195e) * 31;
            String str2 = this.f57196f;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public h(Uri uri, String str, @g.p0 String str2, int i10) {
            this(uri, str, str2, i10, 0, null);
        }

        public h(Uri uri, String str, @g.p0 String str2, int i10, int i11, @g.p0 String str3) {
            this.f57191a = uri;
            this.f57192b = str;
            this.f57193c = str2;
            this.f57194d = i10;
            this.f57195e = i11;
            this.f57196f = str3;
        }
    }

    public static v0 b(Uri uri) {
        return new c().F(uri).a();
    }

    public static v0 c(String str) {
        return new c().G(str).a();
    }

    public c a() {
        return new c();
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return hd.u0.c(this.f57131a, v0Var.f57131a) && this.f57135e.equals(v0Var.f57135e) && hd.u0.c(this.f57132b, v0Var.f57132b) && hd.u0.c(this.f57133c, v0Var.f57133c) && hd.u0.c(this.f57134d, v0Var.f57134d);
    }

    public int hashCode() {
        int iHashCode = this.f57131a.hashCode() * 31;
        g gVar = this.f57132b;
        return ((((((iHashCode + (gVar != null ? gVar.hashCode() : 0)) * 31) + this.f57133c.hashCode()) * 31) + this.f57135e.hashCode()) * 31) + this.f57134d.hashCode();
    }

    public v0(String str, d dVar, @g.p0 g gVar, f fVar, w0 w0Var) {
        this.f57131a = str;
        this.f57132b = gVar;
        this.f57133c = fVar;
        this.f57134d = w0Var;
        this.f57135e = dVar;
    }
}
