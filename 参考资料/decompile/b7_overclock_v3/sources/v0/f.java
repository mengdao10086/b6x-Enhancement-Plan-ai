package v0;

import android.util.Base64;
import androidx.annotation.RestrictTo;
import androidx.core.util.o;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f52464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f52465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f52466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f52467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f52468f;

    public f(@n0 String str, @n0 String str2, @n0 String str3, @n0 List<List<byte[]>> list) {
        this.f52463a = (String) o.l(str);
        this.f52464b = (String) o.l(str2);
        this.f52465c = (String) o.l(str3);
        this.f52466d = (List) o.l(list);
        this.f52467e = 0;
        this.f52468f = a(str, str2, str3);
    }

    public final String a(@n0 String str, @n0 String str2, @n0 String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    @p0
    public List<List<byte[]>> b() {
        return this.f52466d;
    }

    @g.e
    public int c() {
        return this.f52467e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public String d() {
        return this.f52468f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public String e() {
        return this.f52468f;
    }

    @n0
    public String f() {
        return this.f52463a;
    }

    @n0
    public String g() {
        return this.f52464b;
    }

    @n0
    public String h() {
        return this.f52465c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f52463a + ", mProviderPackage: " + this.f52464b + ", mQuery: " + this.f52465c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f52466d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f52466d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append(zc.a.f58317e);
        sb2.append("mCertificatesArray: " + this.f52467e);
        return sb2.toString();
    }

    public f(@n0 String str, @n0 String str2, @n0 String str3, @g.e int i10) {
        this.f52463a = (String) o.l(str);
        this.f52464b = (String) o.l(str2);
        this.f52465c = (String) o.l(str3);
        this.f52466d = null;
        o.a(i10 != 0);
        this.f52467e = i10;
        this.f52468f = a(str, str2, str3);
    }
}
