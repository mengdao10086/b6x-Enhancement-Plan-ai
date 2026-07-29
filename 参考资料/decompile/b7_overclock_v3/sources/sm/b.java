package sm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.s1;
import gm.w;
import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49860e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49861f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.a f49862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f49863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f49864c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f49865d;

    public b(gm.a aVar) throws IOException {
        this.f49865d = null;
        this.f49862a = aVar;
        if (!aVar.P() || aVar.H() != 7) {
            D(aVar);
            return;
        }
        f0 f0VarJ = f0.J(aVar.M(16));
        D(gm.a.K(f0VarJ.K(0)));
        this.f49865d = gm.a.K(f0VarJ.K(f0VarJ.size() - 1)).I();
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new b(gm.a.K(obj));
        } catch (IOException e10) {
            throw new ASN1ParsingException("unable to parse data: " + e10.getMessage(), e10);
        }
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f49865d);
    }

    public l B() {
        return this.f49863b.F();
    }

    public boolean C() {
        return this.f49865d != null;
    }

    public final void D(gm.a aVar) throws IOException {
        if (aVar.H() != 33) {
            throw new IOException("not a CARDHOLDER_CERTIFICATE in request:" + aVar.H());
        }
        int i10 = 0;
        Enumeration enumerationL = f0.J(aVar.M(16)).L();
        while (enumerationL.hasMoreElements()) {
            gm.a aVarK = gm.a.K(enumerationL.nextElement());
            int iH = aVarK.H();
            if (iH == 55) {
                this.f49864c = aVarK.I();
                i10 |= 2;
            } else {
                if (iH != 78) {
                    throw new IOException("Invalid tag, not an CV Certificate Request element:" + aVarK.H());
                }
                this.f49863b = c.E(aVarK);
                i10 |= 1;
            }
        }
        if ((i10 & 3) != 0) {
            return;
        }
        throw new IOException("Invalid CARDHOLDER_CERTIFICATE in request:" + aVar.H());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.a aVar = this.f49862a;
        if (aVar != null) {
            return aVar;
        }
        gm.i iVar = new gm.i(2);
        iVar.a(this.f49863b);
        try {
            iVar.a(new s1(false, 55, new f2(this.f49864c)));
            return new s1(33, iVar);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }

    public c x() {
        return this.f49863b;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f49864c);
    }
}
