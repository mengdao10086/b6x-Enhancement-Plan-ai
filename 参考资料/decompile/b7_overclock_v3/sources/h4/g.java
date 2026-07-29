package h4;

import android.net.Uri;
import android.text.TextUtils;
import g.n0;
import g.p0;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g implements c4.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f30455j = "@#&=*+-_.,:!?()/~'%;$";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f30456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final URL f30457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final String f30458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public String f30459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public URL f30460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public volatile byte[] f30461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f30462i;

    public g(URL url) {
        this(url, h.f30464b);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f30458e;
        return str != null ? str : ((URL) v4.m.d(this.f30457d)).toString();
    }

    public final byte[] d() {
        if (this.f30461h == null) {
            this.f30461h = c().getBytes(c4.b.f9745b);
        }
        return this.f30461h;
    }

    public Map<String, String> e() {
        return this.f30456c.a();
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f30456c.equals(gVar.f30456c);
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f30459f)) {
            String string = this.f30458e;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) v4.m.d(this.f30457d)).toString();
            }
            this.f30459f = Uri.encode(string, f30455j);
        }
        return this.f30459f;
    }

    public final URL g() throws MalformedURLException {
        if (this.f30460g == null) {
            this.f30460g = new URL(f());
        }
        return this.f30460g;
    }

    public String h() {
        return f();
    }

    @Override // c4.b
    public int hashCode() {
        if (this.f30462i == 0) {
            int iHashCode = c().hashCode();
            this.f30462i = iHashCode;
            this.f30462i = (iHashCode * 31) + this.f30456c.hashCode();
        }
        return this.f30462i;
    }

    public URL i() throws MalformedURLException {
        return g();
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f30464b);
    }

    public g(URL url, h hVar) {
        this.f30457d = (URL) v4.m.d(url);
        this.f30458e = null;
        this.f30456c = (h) v4.m.d(hVar);
    }

    public g(String str, h hVar) {
        this.f30457d = null;
        this.f30458e = v4.m.b(str);
        this.f30456c = (h) v4.m.d(hVar);
    }
}
