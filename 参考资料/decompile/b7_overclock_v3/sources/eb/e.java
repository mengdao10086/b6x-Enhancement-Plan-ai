package eb;

import com.google.android.exoplayer2.Format;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f26769f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f26770g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26771h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26772i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f26773j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f26774k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f26775l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f26776m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f26777n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f26778o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f26779p = 64;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f26780q = 128;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f26781r = 256;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f26782s = 512;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f26783t = 1024;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f26784u = 2048;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f26785v = 4096;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f26786w = 8192;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f26787x = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format f26789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Format f26790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f26791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f26792e;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public e(String str, Format format, Format format2, int i10, int i11) {
        hd.a.a(i10 == 0 || i11 == 0);
        this.f26788a = hd.a.e(str);
        this.f26789b = (Format) hd.a.g(format);
        this.f26790c = (Format) hd.a.g(format2);
        this.f26791d = i10;
        this.f26792e = i11;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f26791d == eVar.f26791d && this.f26792e == eVar.f26792e && this.f26788a.equals(eVar.f26788a) && this.f26789b.equals(eVar.f26789b) && this.f26790c.equals(eVar.f26790c);
    }

    public int hashCode() {
        return ((((((((527 + this.f26791d) * 31) + this.f26792e) * 31) + this.f26788a.hashCode()) * 31) + this.f26789b.hashCode()) * 31) + this.f26790c.hashCode();
    }
}
