package gq;

import cs.g;
import ds.j;
import java.io.IOException;
import java.io.OutputStream;
import np.m0;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.v;
import org.bouncycastle.operator.OperatorCreationException;
import xr.e1;
import xr.k2;

/* JADX INFO: loaded from: classes5.dex */
public class b implements iq.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fq.a f29926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f29927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f29928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f29929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29930e;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f29931a;

        public a(s sVar) {
            this.f29931a = sVar;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f29931a.update((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f29931a.update(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f29931a.update(bArr, i10, i11);
        }
    }

    /* JADX INFO: renamed from: gq.b$b, reason: collision with other inner class name */
    public class C0351b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rp.a f29933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f29934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s f29935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f29936d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ byte[] f29937e;

        public C0351b(OutputStream outputStream, s sVar, byte[] bArr, byte[] bArr2) throws OperatorCreationException {
            this.f29934b = outputStream;
            this.f29935c = sVar;
            this.f29936d = bArr;
            this.f29937e = bArr2;
            this.f29933a = new rp.a(new rp.f(), j.f26492b.a(b.this.f29928c));
        }

        @Override // cs.g
        public zn.b a() {
            return null;
        }

        @Override // cs.g
        public OutputStream b() {
            return this.f29934b;
        }

        @Override // cs.g
        public boolean verify(byte[] bArr) {
            int iH = this.f29935c.h();
            byte[] bArr2 = new byte[iH];
            this.f29935c.c(bArr2, 0);
            this.f29933a.a(false, b.this.f29929d);
            this.f29933a.update(bArr2, 0, iH);
            byte[] bArr3 = this.f29936d;
            if (bArr3 == null || !org.bouncycastle.util.a.g(bArr2, bArr3)) {
                rp.a aVar = this.f29933a;
                byte[] bArr4 = this.f29937e;
                aVar.update(bArr4, 0, bArr4.length);
            } else {
                int iH2 = this.f29935c.h();
                byte[] bArr5 = new byte[iH2];
                this.f29935c.c(bArr5, 0);
                this.f29933a.update(bArr5, 0, iH2);
            }
            return this.f29933a.d(bArr);
        }
    }

    public b(fq.a aVar) throws IOException {
        zn.b bVar;
        this.f29926a = aVar;
        this.f29927b = aVar.getEncoded();
        k2 k2VarV = aVar.e().b().B().V();
        if (!(k2VarV.A() instanceof e1)) {
            throw new IllegalStateException("not public verification key");
        }
        e1 e1VarA = e1.A(k2VarV.A());
        this.f29930e = e1VarA.y();
        int iY = e1VarA.y();
        if (iY == 0 || iY == 1) {
            bVar = new zn.b(kn.d.f37592c);
        } else {
            if (iY != 3) {
                throw new IllegalStateException("unknown key type");
            }
            bVar = new zn.b(kn.d.f37594d);
        }
        this.f29928c = bVar;
        this.f29929d = (m0) new f(e1VarA).c();
    }

    @Override // iq.c
    public fq.a c() {
        return this.f29926a;
    }

    @Override // iq.c
    public boolean d() {
        return this.f29926a != null;
    }

    @Override // iq.c
    public g get(int i10) throws OperatorCreationException {
        if (this.f29930e != i10) {
            throw new OperatorCreationException("wrong verifier for algorithm: " + i10);
        }
        v vVarA = j.f26492b.a(this.f29928c);
        byte[] bArr = new byte[vVarA.h()];
        byte[] bArr2 = this.f29927b;
        vVarA.update(bArr2, 0, bArr2.length);
        vVarA.c(bArr, 0);
        byte[] bArr3 = this.f29926a.a().B() ? new byte[vVarA.h()] : null;
        if (bArr3 != null) {
            byte[] bArrA = org.bouncycastle.oer.b.a(this.f29926a.e().b().B(), yr.a.L);
            vVarA.update(bArrA, 0, bArrA.length);
            vVarA.c(bArr3, 0);
        }
        return new C0351b(new a(vVarA), vVarA, bArr3, bArr);
    }
}
