package vo;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.s;
import zo.e0;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f53293q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f53294r = 10;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f53295s = 20;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f53296t = 30;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f53297u = 40;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f53298v = 50;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f53299w = 60;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f53300x = 70;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f53302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f53303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SecureRandom f53304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BigInteger f53305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BigInteger f53306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BigInteger f53307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f53308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BigInteger f53309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BigInteger f53310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BigInteger f53311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BigInteger f53312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BigInteger f53313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BigInteger f53314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BigInteger f53315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f53316p;

    public a(String str, char[] cArr) {
        this(str, cArr, c.f53322c);
    }

    public a(String str, char[] cArr, b bVar) {
        this(str, cArr, bVar, new e0(), n.f());
    }

    public a(String str, char[] cArr, b bVar, s sVar, SecureRandom secureRandom) {
        g.w(str, "participantId");
        g.w(cArr, "password");
        g.w(bVar, "p");
        g.w(sVar, so.d.f50128b);
        g.w(secureRandom, "random");
        if (cArr.length == 0) {
            throw new IllegalArgumentException("Password must not be empty.");
        }
        this.f53301a = str;
        this.f53302b = org.bouncycastle.util.a.Q(cArr, cArr.length);
        this.f53305e = bVar.b();
        this.f53306f = bVar.c();
        this.f53307g = bVar.a();
        this.f53303c = sVar;
        this.f53304d = secureRandom;
        this.f53316p = 0;
    }

    public BigInteger a() {
        int i10 = this.f53316p;
        if (i10 >= 50) {
            throw new IllegalStateException("Key already calculated for " + this.f53301a);
        }
        if (i10 < 40) {
            throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.f53301a);
        }
        BigInteger bigIntegerH = g.h(this.f53302b);
        org.bouncycastle.util.a.f0(this.f53302b, (char) 0);
        this.f53302b = null;
        BigInteger bigIntegerE = g.e(this.f53305e, this.f53306f, this.f53314n, this.f53310j, bigIntegerH, this.f53315o);
        this.f53309i = null;
        this.f53310j = null;
        this.f53315o = null;
        this.f53316p = 50;
        return bigIntegerE;
    }

    public d b() {
        if (this.f53316p >= 10) {
            throw new IllegalStateException("Round1 payload already created for " + this.f53301a);
        }
        this.f53309i = g.k(this.f53306f, this.f53304d);
        this.f53310j = g.l(this.f53306f, this.f53304d);
        this.f53311k = g.c(this.f53305e, this.f53307g, this.f53309i);
        this.f53312l = g.c(this.f53305e, this.f53307g, this.f53310j);
        BigInteger[] bigIntegerArrJ = g.j(this.f53305e, this.f53306f, this.f53307g, this.f53311k, this.f53309i, this.f53301a, this.f53303c, this.f53304d);
        BigInteger[] bigIntegerArrJ2 = g.j(this.f53305e, this.f53306f, this.f53307g, this.f53312l, this.f53310j, this.f53301a, this.f53303c, this.f53304d);
        this.f53316p = 10;
        return new d(this.f53301a, this.f53311k, this.f53312l, bigIntegerArrJ, bigIntegerArrJ2);
    }

    public e c() {
        int i10 = this.f53316p;
        if (i10 >= 30) {
            throw new IllegalStateException("Round2 payload already created for " + this.f53301a);
        }
        if (i10 < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.f53301a);
        }
        BigInteger bigIntegerB = g.b(this.f53305e, this.f53311k, this.f53313m, this.f53314n);
        BigInteger bigIntegerI = g.i(this.f53306f, this.f53310j, g.h(this.f53302b));
        BigInteger bigIntegerA = g.a(this.f53305e, this.f53306f, bigIntegerB, bigIntegerI);
        BigInteger[] bigIntegerArrJ = g.j(this.f53305e, this.f53306f, bigIntegerB, bigIntegerA, bigIntegerI, this.f53301a, this.f53303c, this.f53304d);
        this.f53316p = 30;
        return new e(this.f53301a, bigIntegerA, bigIntegerArrJ);
    }

    public f d(BigInteger bigInteger) {
        int i10 = this.f53316p;
        if (i10 >= 60) {
            throw new IllegalStateException("Round3 payload already created for " + this.f53301a);
        }
        if (i10 >= 50) {
            BigInteger bigIntegerG = g.g(this.f53301a, this.f53308h, this.f53311k, this.f53312l, this.f53313m, this.f53314n, bigInteger, this.f53303c);
            this.f53316p = 60;
            return new f(this.f53301a, bigIntegerG);
        }
        throw new IllegalStateException("Keying material must be calculated prior to creating Round3 payload for " + this.f53301a);
    }

    public int e() {
        return this.f53316p;
    }

    public void f(d dVar) throws CryptoException {
        if (this.f53316p >= 20) {
            throw new IllegalStateException("Validation already attempted for round1 payload for" + this.f53301a);
        }
        this.f53308h = dVar.e();
        this.f53313m = dVar.a();
        this.f53314n = dVar.b();
        BigInteger[] bigIntegerArrC = dVar.c();
        BigInteger[] bigIntegerArrD = dVar.d();
        g.x(this.f53301a, dVar.e());
        g.u(this.f53314n);
        g.z(this.f53305e, this.f53306f, this.f53307g, this.f53313m, bigIntegerArrC, dVar.e(), this.f53303c);
        g.z(this.f53305e, this.f53306f, this.f53307g, this.f53314n, bigIntegerArrD, dVar.e(), this.f53303c);
        this.f53316p = 20;
    }

    public void g(e eVar) throws CryptoException {
        int i10 = this.f53316p;
        if (i10 >= 40) {
            throw new IllegalStateException("Validation already attempted for round2 payload for" + this.f53301a);
        }
        if (i10 < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.f53301a);
        }
        BigInteger bigIntegerB = g.b(this.f53305e, this.f53313m, this.f53311k, this.f53312l);
        this.f53315o = eVar.a();
        BigInteger[] bigIntegerArrB = eVar.b();
        g.x(this.f53301a, eVar.c());
        g.y(this.f53308h, eVar.c());
        g.t(bigIntegerB);
        g.z(this.f53305e, this.f53306f, bigIntegerB, this.f53315o, bigIntegerArrB, eVar.c(), this.f53303c);
        this.f53316p = 40;
    }

    public void h(f fVar, BigInteger bigInteger) throws CryptoException {
        int i10 = this.f53316p;
        if (i10 >= 70) {
            throw new IllegalStateException("Validation already attempted for round3 payload for" + this.f53301a);
        }
        if (i10 < 50) {
            throw new IllegalStateException("Keying material must be calculated validated prior to validating Round3 payload for " + this.f53301a);
        }
        g.x(this.f53301a, fVar.b());
        g.y(this.f53308h, fVar.b());
        g.v(this.f53301a, this.f53308h, this.f53311k, this.f53312l, this.f53313m, this.f53314n, bigInteger, this.f53303c, fVar.a());
        this.f53311k = null;
        this.f53312l = null;
        this.f53313m = null;
        this.f53314n = null;
        this.f53316p = 70;
    }
}
