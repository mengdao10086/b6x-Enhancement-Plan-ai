package cm;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;
import okio.w0;
import rl.f;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\u0011\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¨\u0006\u001a"}, d2 = {"Lcm/d;", "Ljavax/net/ssl/HostnameVerifier;", "", xl.e.f55523k, "Ljavax/net/ssl/SSLSession;", com.umeng.analytics.pro.d.aw, "", "verify", "Ljava/security/cert/X509Certificate;", "certificate", "e", "", "a", "ipAddress", "h", "hostname", "g", "b", "d", "pattern", "f", "", "type", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final d f10964a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10965b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10966c = 7;

    @k
    public final List<String> a(@k X509Certificate certificate) {
        f0.p(certificate, "certificate");
        return CollectionsKt___CollectionsKt.y4(c(certificate, 7), c(certificate, 2));
    }

    public final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale US = Locale.US;
        f0.o(US, "US");
        String lowerCase = str.toLowerCase(US);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public final List<String> c(X509Certificate x509Certificate, int i10) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt__CollectionsKt.E();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && f0.g(list.get(0), Integer.valueOf(i10)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt__CollectionsKt.E();
        }
    }

    public final boolean d(String str) {
        return str.length() == ((int) w0.l(str, 0, 0, 3, null));
    }

    public final boolean e(@k String host, @k X509Certificate certificate) {
        f0.p(host, "host");
        f0.p(certificate, "certificate");
        return f.k(host) ? h(host, certificate) : g(host, certificate);
    }

    public final boolean f(String str, String str2) {
        if (!(str == null || str.length() == 0) && !u.v2(str, j3.b.f36044h, false, 2, null) && !u.K1(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !u.v2(str2, j3.b.f36044h, false, 2, null) && !u.K1(str2, "..", false, 2, null)) {
                if (!u.K1(str, j3.b.f36044h, false, 2, null)) {
                    str = f0.C(str, j3.b.f36044h);
                }
                String str3 = str;
                if (!u.K1(str2, j3.b.f36044h, false, 2, null)) {
                    str2 = f0.C(str2, j3.b.f36044h);
                }
                String strB = b(str2);
                if (!StringsKt__StringsKt.W2(strB, "*", false, 2, null)) {
                    return f0.g(str3, strB);
                }
                if (!u.v2(strB, "*.", false, 2, null) || StringsKt__StringsKt.r3(strB, '*', 1, false, 4, null) != -1 || str3.length() < strB.length() || f0.g("*.", strB)) {
                    return false;
                }
                String strSubstring = strB.substring(1);
                f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (!u.K1(str3, strSubstring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - strSubstring.length();
                return length <= 0 || StringsKt__StringsKt.F3(str3, '.', length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }

    public final boolean g(String str, X509Certificate x509Certificate) {
        String strB = b(str);
        List<String> listC = c(x509Certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = listC.iterator();
        while (it2.hasNext()) {
            if (f10964a.f(strB, (String) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(String str, X509Certificate x509Certificate) {
        String strE = rl.a.e(str);
        List<String> listC = c(x509Certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = listC.iterator();
        while (it2.hasNext()) {
            if (f0.g(strE, rl.a.e((String) it2.next()))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@k String host, @k SSLSession session) {
        f0.p(host, "host");
        f0.p(session, "session");
        if (!d(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return e(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
