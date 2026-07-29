package hm;

import co.l;
import co.m;
import co.n;
import gm.y;
import ir.b0;
import ir.e;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import jt.h;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f31363a = new C0369a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Hashtable f31364b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Hashtable f31365c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Hashtable f31366d = new Hashtable();

    /* JADX INFO: renamed from: hm.a$a, reason: collision with other inner class name */
    public static class C0369a extends m {
        @Override // co.m
        public l a() {
            BigInteger bigIntegerG = a.g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger bigIntegerG2 = a.g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger bigIntegerG3 = a.g("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger bigIntegerG4 = a.g("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new l(eVarE, a.d(eVarE, "04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    static {
        f("FRP256v1", b.f31367a, f31363a);
    }

    public static n d(e eVar, String str) {
        n nVar = new n(eVar, h.d(str));
        b0.c(nVar.x());
        return nVar;
    }

    public static e e(e eVar) {
        return eVar;
    }

    public static void f(String str, y yVar, m mVar) {
        f31364b.put(Strings.k(str), yVar);
        f31366d.put(yVar, str);
        f31365c.put(yVar, mVar);
    }

    public static BigInteger g(String str) {
        return new BigInteger(1, h.d(str));
    }

    public static l h(String str) {
        y yVarL = l(str);
        if (yVarL == null) {
            return null;
        }
        return i(yVarL);
    }

    public static l i(y yVar) {
        m mVar = (m) f31365c.get(yVar);
        if (mVar == null) {
            return null;
        }
        return mVar.b();
    }

    public static String j(y yVar) {
        return (String) f31366d.get(yVar);
    }

    public static Enumeration k() {
        return f31366d.elements();
    }

    public static y l(String str) {
        return (y) f31364b.get(Strings.k(str));
    }
}
