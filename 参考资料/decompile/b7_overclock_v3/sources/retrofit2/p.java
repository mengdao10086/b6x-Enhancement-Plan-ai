package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.s;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f48670m = " \"<>^`{}|\\?#";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f48672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.u f48673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public String f48674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public u.a f48675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0.a f48676e = new b0.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t.a f48677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public okhttp3.w f48678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f48679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public x.a f48680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public s.a f48681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public c0 f48682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f48669l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f48671n = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static class a extends c0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f48683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final okhttp3.w f48684c;

        public a(c0 c0Var, okhttp3.w wVar) {
            this.f48683b = c0Var;
            this.f48684c = wVar;
        }

        @Override // okhttp3.c0
        public long a() throws IOException {
            return this.f48683b.a();
        }

        @Override // okhttp3.c0
        public okhttp3.w b() {
            return this.f48684c;
        }

        @Override // okhttp3.c0
        public void r(okio.k kVar) throws IOException {
            this.f48683b.r(kVar);
        }
    }

    public p(String str, okhttp3.u uVar, @Nullable String str2, @Nullable okhttp3.t tVar, @Nullable okhttp3.w wVar, boolean z10, boolean z11, boolean z12) {
        this.f48672a = str;
        this.f48673b = uVar;
        this.f48674c = str2;
        this.f48678g = wVar;
        this.f48679h = z10;
        if (tVar != null) {
            this.f48677f = tVar.m();
        } else {
            this.f48677f = new t.a();
        }
        if (z11) {
            this.f48681j = new s.a();
        } else if (z12) {
            x.a aVar = new x.a();
            this.f48680i = aVar;
            aVar.g(okhttp3.x.f43998l);
        }
    }

    public static String i(String str, boolean z10) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || f48670m.indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                okio.j jVar = new okio.j();
                jVar.W0(str, 0, iCharCount);
                j(jVar, str, iCharCount, length, z10);
                return jVar.y1();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public static void j(okio.j jVar, String str, int i10, int i11, boolean z10) {
        okio.j jVar2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || f48670m.indexOf(iCodePointAt) != -1 || (!z10 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (jVar2 == null) {
                        jVar2 = new okio.j();
                    }
                    jVar2.H(iCodePointAt);
                    while (!jVar2.d0()) {
                        int i12 = jVar2.readByte() & 255;
                        jVar.writeByte(37);
                        char[] cArr = f48669l;
                        jVar.writeByte(cArr[(i12 >> 4) & 15]);
                        jVar.writeByte(cArr[i12 & 15]);
                    }
                } else {
                    jVar.H(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    public void a(String str, String str2, boolean z10) {
        if (z10) {
            this.f48681j.b(str, str2);
        } else {
            this.f48681j.a(str, str2);
        }
    }

    public void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f48677f.b(str, str2);
            return;
        }
        try {
            this.f48678g = okhttp3.w.h(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e10);
        }
    }

    public void c(okhttp3.t tVar) {
        this.f48677f.e(tVar);
    }

    public void d(okhttp3.t tVar, c0 c0Var) {
        this.f48680i.c(tVar, c0Var);
    }

    public void e(x.c cVar) {
        this.f48680i.d(cVar);
    }

    public void f(String str, String str2, boolean z10) {
        if (this.f48674c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z10);
        String strReplace = this.f48674c.replace(zc.a.f58316d + str + zc.a.f58317e, strI);
        if (!f48671n.matcher(strReplace).matches()) {
            this.f48674c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public void g(String str, @Nullable String str2, boolean z10) {
        String str3 = this.f48674c;
        if (str3 != null) {
            u.a aVarI = this.f48673b.I(str3);
            this.f48675d = aVarI;
            if (aVarI == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f48673b + ", Relative: " + this.f48674c);
            }
            this.f48674c = null;
        }
        if (z10) {
            this.f48675d.c(str, str2);
        } else {
            this.f48675d.g(str, str2);
        }
    }

    public <T> void h(Class<T> cls, @Nullable T t10) {
        this.f48676e.z(cls, t10);
    }

    public b0.a k() {
        okhttp3.u uVarW;
        u.a aVar = this.f48675d;
        if (aVar != null) {
            uVarW = aVar.h();
        } else {
            uVarW = this.f48673b.W(this.f48674c);
            if (uVarW == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f48673b + ", Relative: " + this.f48674c);
            }
        }
        c0 aVar2 = this.f48682k;
        if (aVar2 == null) {
            s.a aVar3 = this.f48681j;
            if (aVar3 != null) {
                aVar2 = aVar3.c();
            } else {
                x.a aVar4 = this.f48680i;
                if (aVar4 != null) {
                    aVar2 = aVar4.f();
                } else if (this.f48679h) {
                    aVar2 = c0.h(null, new byte[0]);
                }
            }
        }
        okhttp3.w wVar = this.f48678g;
        if (wVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, wVar);
            } else {
                this.f48677f.b("Content-Type", wVar.toString());
            }
        }
        return this.f48676e.D(uVarW).o(this.f48677f.i()).p(this.f48672a, aVar2);
    }

    public void l(c0 c0Var) {
        this.f48682k = c0Var;
    }

    public void m(Object obj) {
        this.f48674c = obj.toString();
    }
}
