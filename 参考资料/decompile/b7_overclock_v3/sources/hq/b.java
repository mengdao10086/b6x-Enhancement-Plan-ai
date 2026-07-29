package hq;

import cs.g;
import cs.o;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import org.bouncycastle.jcajce.util.i;
import org.bouncycastle.operator.OperatorCreationException;
import xr.e1;
import xr.k2;

/* JADX INFO: loaded from: classes5.dex */
public class b implements iq.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fq.a f31408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f31409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f31410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECPublicKey f31411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f31412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f31413f;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OutputStream f31414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f31415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Signature f31416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f31417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ byte[] f31418e;

        public a(OutputStream outputStream, o oVar, Signature signature, byte[] bArr, byte[] bArr2) {
            this.f31414a = outputStream;
            this.f31415b = oVar;
            this.f31416c = signature;
            this.f31417d = bArr;
            this.f31418e = bArr2;
        }

        @Override // cs.g
        public zn.b a() {
            return null;
        }

        @Override // cs.g
        public OutputStream b() {
            return this.f31414a;
        }

        @Override // cs.g
        public boolean verify(byte[] bArr) {
            byte[] bArrC = this.f31415b.c();
            try {
                this.f31416c.initVerify(b.this.f31411d);
                this.f31416c.update(bArrC);
                byte[] bArr2 = this.f31417d;
                if (bArr2 == null || !org.bouncycastle.util.a.g(bArrC, bArr2)) {
                    this.f31416c.update(this.f31418e);
                } else {
                    this.f31416c.update(this.f31415b.c());
                }
                return this.f31416c.verify(bArr);
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage(), e10);
            }
        }
    }

    /* JADX INFO: renamed from: hq.b$b, reason: collision with other inner class name */
    public static class C0372b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.bouncycastle.jcajce.util.d f31420a = new org.bouncycastle.jcajce.util.c();

        public b a(fq.a aVar) {
            return new b(aVar, this.f31420a, null);
        }

        public C0372b b(String str) {
            this.f31420a = new org.bouncycastle.jcajce.util.g(str);
            return this;
        }

        public C0372b c(Provider provider) {
            this.f31420a = new i(provider);
            return this;
        }
    }

    public b(fq.a aVar, org.bouncycastle.jcajce.util.d dVar) {
        zn.b bVar;
        this.f31408a = aVar;
        this.f31413f = dVar;
        try {
            this.f31409b = aVar.getEncoded();
            k2 k2VarV = aVar.e().b().B().V();
            if (!(k2VarV.A() instanceof e1)) {
                throw new IllegalArgumentException("not public verification key");
            }
            e1 e1VarA = e1.A(k2VarV.A());
            this.f31412e = e1VarA.y();
            int iY = e1VarA.y();
            if (iY == 0 || iY == 1) {
                bVar = new zn.b(kn.d.f37592c);
            } else {
                if (iY != 3) {
                    throw new IllegalArgumentException("unknown key type");
                }
                bVar = new zn.b(kn.d.f37594d);
            }
            this.f31410c = bVar;
            this.f31411d = (ECPublicKey) new e(e1VarA, dVar).c();
        } catch (IOException e10) {
            throw new IllegalStateException("unable to extract parent data: " + e10.getMessage());
        }
    }

    public /* synthetic */ b(fq.a aVar, org.bouncycastle.jcajce.util.d dVar, a aVar2) {
        this(aVar, dVar);
    }

    @Override // iq.c
    public fq.a c() {
        return this.f31408a;
    }

    @Override // iq.c
    public boolean d() {
        return this.f31408a != null;
    }

    @Override // iq.c
    public g get(int i10) throws OperatorCreationException {
        byte[] bArrC;
        org.bouncycastle.jcajce.util.d dVar;
        String str;
        if (this.f31412e != i10) {
            throw new OperatorCreationException("wrong verifier for algorithm: " + i10);
        }
        try {
            o oVarA = new org.bouncycastle.operator.jcajce.d().c(this.f31413f).b().a(this.f31410c);
            try {
                OutputStream outputStreamB = oVarA.b();
                byte[] bArr = this.f31409b;
                outputStreamB.write(bArr, 0, bArr.length);
                byte[] bArrC2 = oVarA.c();
                if (this.f31408a.a().B()) {
                    byte[] bArrA = org.bouncycastle.oer.b.a(this.f31408a.e().b().B(), yr.a.L);
                    outputStreamB.write(bArrA, 0, bArrA.length);
                    bArrC = oVarA.c();
                } else {
                    bArrC = null;
                }
                byte[] bArr2 = bArrC;
                int i11 = this.f31412e;
                if (i11 == 0 || i11 == 1) {
                    dVar = this.f31413f;
                    str = "SHA256withECDSA";
                } else {
                    if (i11 != 3) {
                        throw new IllegalArgumentException("choice " + this.f31412e + " not supported");
                    }
                    dVar = this.f31413f;
                    str = "SHA384withECDSA";
                }
                return new a(outputStreamB, oVarA, dVar.a(str), bArr2, bArrC2);
            } catch (Exception e10) {
                throw new IllegalStateException(e10.getMessage(), e10);
            }
        } catch (Exception e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }
}
