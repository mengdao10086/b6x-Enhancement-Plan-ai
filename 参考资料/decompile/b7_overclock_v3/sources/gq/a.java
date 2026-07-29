package gq;

import ds.j;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import np.k0;
import np.l0;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.v;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class a implements iq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f29919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f29920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f29921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f29922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f29923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y f29924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f29925g;

    public a(l0 l0Var) {
        this(l0Var, null);
    }

    public a(l0 l0Var, fq.a aVar) {
        zn.b bVar;
        this.f29919a = l0Var;
        y yVarJ = ((k0) l0Var.d()).j();
        this.f29924f = yVarJ;
        this.f29920b = aVar;
        if (yVarJ.C(rn.d.H) || yVarJ.C(tn.b.f51379u)) {
            bVar = new zn.b(kn.d.f37592c);
        } else {
            if (!yVarJ.C(tn.b.f51383y)) {
                throw new IllegalArgumentException("unknown key type");
            }
            bVar = new zn.b(kn.d.f37594d);
        }
        this.f29921c = bVar;
        try {
            v vVarA = j.f26492b.a(this.f29921c);
            this.f29922d = vVarA;
            if (aVar == null) {
                this.f29923e = null;
                byte[] bArr = new byte[vVarA.h()];
                this.f29925g = bArr;
                vVarA.c(bArr, 0);
                return;
            }
            try {
                byte[] encoded = aVar.getEncoded();
                this.f29923e = encoded;
                byte[] bArr2 = new byte[vVarA.h()];
                this.f29925g = bArr2;
                vVarA.update(encoded, 0, encoded.length);
                vVarA.c(bArr2, 0);
            } catch (IOException e10) {
                throw new IllegalStateException("signer certificate encoding failed: " + e10.getMessage());
            }
        } catch (OperatorCreationException unused) {
            throw new IllegalStateException("cannot recognise digest type: " + this.f29921c.x());
        }
    }

    @Override // iq.b
    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f29925g);
    }

    @Override // iq.b
    public OutputStream b() {
        return new gp.d(this.f29922d);
    }

    @Override // iq.b
    public fq.a c() {
        return this.f29920b;
    }

    @Override // iq.b
    public boolean d() {
        return this.f29923e == null;
    }

    @Override // iq.b
    public zn.b e() {
        return this.f29921c;
    }

    @Override // iq.b
    public byte[] getSignature() {
        int iH = this.f29922d.h();
        byte[] bArr = new byte[iH];
        this.f29922d.c(bArr, 0);
        rp.a aVar = new rp.a(new rp.f(), this.f29922d);
        aVar.a(true, this.f29919a);
        aVar.update(bArr, 0, iH);
        byte[] bArr2 = this.f29925g;
        aVar.update(bArr2, 0, bArr2.length);
        return aVar.e();
    }
}
