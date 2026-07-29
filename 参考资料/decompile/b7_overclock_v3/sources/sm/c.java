package sm;

import gm.c0;
import gm.f2;
import gm.s;
import gm.s1;
import gm.w;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f49866j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f49867k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f49868l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f49869m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49870n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f49871o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f49872p = 64;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f49873q = 127;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f49874r = 13;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f49875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.a f49876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.a f49877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f49878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.a f49879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f49880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.a f49881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.a f49882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49883i = 0;

    public c(gm.a aVar) throws IOException {
        O(aVar);
    }

    public c(gm.a aVar, f fVar, l lVar, e eVar, d dVar, k kVar, k kVar2) {
        M(aVar);
        N(new s1(2, fVar.b()));
        P(lVar);
        L(new s1(32, eVar.b()));
        K(dVar);
        try {
            I(new s1(false, 37, new f2(kVar.c())));
            J(new s1(false, 36, new f2(kVar2.c())));
        } catch (IOException e10) {
            throw new IllegalArgumentException("unable to encode dates: " + e10.getMessage());
        }
    }

    public static c E(Object obj) throws IOException {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(gm.a.K(obj));
        }
        return null;
    }

    public e A() {
        return new e(this.f49879e.I());
    }

    public gm.a B() {
        return this.f49876b;
    }

    public int C() {
        return this.f49883i;
    }

    public f D() throws IOException {
        if ((this.f49883i & 2) == 2) {
            return new f(this.f49877c.I());
        }
        throw new IOException("Certification authority reference not set");
    }

    public l F() {
        return this.f49878d;
    }

    public final c0 G() throws IOException {
        gm.i iVar = new gm.i(7);
        iVar.a(this.f49876b);
        iVar.a(this.f49877c);
        iVar.a(new s1(false, 73, this.f49878d));
        iVar.a(this.f49879e);
        iVar.a(this.f49880f);
        iVar.a(this.f49881g);
        iVar.a(this.f49882h);
        return new s1(78, iVar);
    }

    public final c0 H() throws IOException {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f49876b);
        iVar.a(new s1(false, 73, this.f49878d));
        iVar.a(this.f49879e);
        return new s1(78, iVar);
    }

    public final void I(gm.a aVar) throws IllegalArgumentException {
        if (aVar.H() == 37) {
            this.f49881g = aVar;
            this.f49883i |= 32;
        } else {
            throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EFFECTIVE_DATE tag :" + h.b(aVar));
        }
    }

    public final void J(gm.a aVar) throws IllegalArgumentException {
        if (aVar.H() != 36) {
            throw new IllegalArgumentException("Not an Iso7816Tags.APPLICATION_EXPIRATION_DATE tag");
        }
        this.f49882h = aVar;
        this.f49883i |= 64;
    }

    public final void K(d dVar) {
        this.f49880f = dVar;
        this.f49883i |= 16;
    }

    public final void L(gm.a aVar) throws IllegalArgumentException {
        if (aVar.H() != 32) {
            throw new IllegalArgumentException("Not an Iso7816Tags.CARDHOLDER_NAME tag");
        }
        this.f49879e = aVar;
        this.f49883i |= 8;
    }

    public final void M(gm.a aVar) throws IllegalArgumentException {
        if (aVar.H() == 41) {
            this.f49876b = aVar;
            this.f49883i |= 1;
        } else {
            throw new IllegalArgumentException("Not an Iso7816Tags.INTERCHANGE_PROFILE tag :" + h.b(aVar));
        }
    }

    public final void N(gm.a aVar) throws IllegalArgumentException {
        if (aVar.H() != 2) {
            throw new IllegalArgumentException("Not an Iso7816Tags.ISSUER_IDENTIFICATION_NUMBER tag");
        }
        this.f49877c = aVar;
        this.f49883i |= 2;
    }

    public final void O(gm.a aVar) throws IOException {
        if (aVar.H() != 78) {
            throw new IOException("Bad tag : not an iso7816 CERTIFICATE_CONTENT_TEMPLATE");
        }
        s sVar = new s(aVar.I());
        while (true) {
            c0 c0VarN = sVar.n();
            if (c0VarN == null) {
                sVar.close();
                return;
            }
            if (!(c0VarN instanceof gm.a)) {
                throw new IOException("Not a valid iso7816 content : not a ASN1ApplicationSpecific Object :" + h.b(aVar) + c0VarN.getClass());
            }
            gm.a aVar2 = (gm.a) c0VarN;
            int iH = aVar2.H();
            if (iH == 2) {
                N(aVar2);
            } else if (iH == 32) {
                L(aVar2);
            } else if (iH == 41) {
                M(aVar2);
            } else if (iH == 73) {
                P(l.x(aVar2.M(16)));
            } else if (iH == 76) {
                K(new d(aVar2));
            } else if (iH == 36) {
                J(aVar2);
            } else {
                if (iH != 37) {
                    this.f49883i = 0;
                    throw new IOException("Not a valid iso7816 ASN1ApplicationSpecific tag " + aVar2.H());
                }
                I(aVar2);
            }
        }
    }

    public final void P(l lVar) {
        this.f49878d = l.x(lVar);
        this.f49883i |= 4;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        try {
            int i10 = this.f49883i;
            if (i10 == 127) {
                return G();
            }
            if (i10 == 13) {
                return H();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public k x() {
        if ((this.f49883i & 32) == 32) {
            return new k(this.f49881g.I());
        }
        return null;
    }

    public k y() throws IOException {
        if ((this.f49883i & 64) == 64) {
            return new k(this.f49882h.I());
        }
        throw new IOException("certificate Expiration Date not set");
    }

    public d z() throws IOException {
        if ((this.f49883i & 16) == 16) {
            return this.f49880f;
        }
        throw new IOException("Certificate Holder Authorisation not set");
    }
}
