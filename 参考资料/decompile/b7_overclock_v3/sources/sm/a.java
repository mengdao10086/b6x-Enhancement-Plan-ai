package sm;

import gm.c0;
import gm.f2;
import gm.s;
import gm.s1;
import gm.w;
import gm.y;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f49855d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f49856e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f49857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f49858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f49859c;

    public a(gm.a aVar) throws IOException {
        K(aVar);
    }

    public a(s sVar) throws IOException {
        J(sVar);
    }

    public a(c cVar, byte[] bArr) throws IOException {
        this.f49857a = cVar;
        this.f49858b = org.bouncycastle.util.a.p(bArr);
        this.f49859c = this.f49859c | f49855d | f49856e;
    }

    public static a G(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new a(gm.a.K(obj));
        } catch (IOException e10) {
            throw new ASN1ParsingException("unable to parse data: " + e10.getMessage(), e10);
        }
    }

    public k A() throws IOException {
        return this.f49857a.x();
    }

    public k B() throws IOException {
        return this.f49857a.y();
    }

    public y C() throws IOException {
        return this.f49857a.z().z();
    }

    public j D() throws IOException {
        return new j(this.f49857a.z().x() & 31);
    }

    public int E() throws IOException {
        return this.f49857a.z().x() & 192;
    }

    public e F() throws IOException {
        return this.f49857a.A();
    }

    public int H() throws IOException {
        return this.f49857a.z().x();
    }

    public byte[] I() {
        return org.bouncycastle.util.a.p(this.f49858b);
    }

    public final void J(s sVar) throws IOException {
        while (true) {
            c0 c0VarN = sVar.n();
            if (c0VarN == null) {
                return;
            }
            if (!(c0VarN instanceof gm.a)) {
                throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
            }
            K((gm.a) c0VarN);
        }
    }

    public final void K(gm.a aVar) throws IOException {
        int i10;
        int i11;
        this.f49859c = 0;
        if (aVar.H() != 33) {
            throw new IOException("not a CARDHOLDER_CERTIFICATE :" + aVar.H());
        }
        s sVar = new s(aVar.I());
        while (true) {
            c0 c0VarN = sVar.n();
            if (c0VarN == null) {
                sVar.close();
                if (this.f49859c == (f49856e | f49855d)) {
                    return;
                }
                throw new IOException("invalid CARDHOLDER_CERTIFICATE :" + aVar.H());
            }
            if (!(c0VarN instanceof gm.a)) {
                throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
            }
            gm.a aVar2 = (gm.a) c0VarN;
            int iH = aVar2.H();
            if (iH == 55) {
                this.f49858b = aVar2.I();
                i10 = this.f49859c;
                i11 = f49856e;
            } else {
                if (iH != 78) {
                    throw new IOException("Invalid tag, not an Iso7816CertificateStructure :" + aVar2.H());
                }
                this.f49857a = c.E(aVar2);
                i10 = this.f49859c;
                i11 = f49855d;
            }
            this.f49859c = i10 | i11;
        }
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f49857a);
        try {
            iVar.a(new s1(false, 55, new f2(this.f49858b)));
            return new s1(33, iVar);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }

    public f x() throws IOException {
        return this.f49857a.D();
    }

    public c y() {
        return this.f49857a;
    }

    public int z() {
        return this.f49857a.C();
    }
}
