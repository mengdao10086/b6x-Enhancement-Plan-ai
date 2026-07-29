package xm;

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
    public static m f55608a = new C0657a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static m f55609b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Hashtable f55610c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Hashtable f55611d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Hashtable f55612e = new Hashtable();

    /* JADX INFO: renamed from: xm.a$a, reason: collision with other inner class name */
    public static class C0657a extends m {
        @Override // co.m
        public l a() {
            BigInteger bigIntegerG = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger bigIntegerG2 = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger bigIntegerG3 = a.g("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger bigIntegerG4 = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new l(eVarE, a.d(eVarE, "0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    public static class b extends m {
        @Override // co.m
        public l a() {
            BigInteger bigIntegerG = a.g("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger bigIntegerG2 = a.g("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger bigIntegerG3 = a.g("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger bigIntegerG4 = a.g("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new l(eVarE, a.d(eVarE, "044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    static {
        f("wapip192v1", xm.b.J, f55609b);
        f("sm2p256v1", xm.b.F, f55608a);
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
        f55610c.put(Strings.k(str), yVar);
        f55612e.put(yVar, str);
        f55611d.put(yVar, mVar);
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
        m mVar = (m) f55611d.get(yVar);
        if (mVar == null) {
            return null;
        }
        return mVar.b();
    }

    public static String j(y yVar) {
        return (String) f55612e.get(yVar);
    }

    public static Enumeration k() {
        return f55612e.elements();
    }

    public static y l(String str) {
        return (y) f55610c.get(Strings.k(str));
    }
}
