package so;

import gm.b3;
import gm.l2;
import gm.n2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class z extends a0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f50355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f50356z;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cs.d0 f50357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f50358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OutputStream f50359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gm.j1 f50360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public gm.j1 f50361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public gm.j1 f50362f;

        public a(cs.d0 d0Var, OutputStream outputStream, gm.j1 j1Var, gm.j1 j1Var2, gm.j1 j1Var3) {
            this.f50357a = d0Var;
            this.f50359c = outputStream;
            this.f50358b = d0Var.b(outputStream);
            this.f50360d = j1Var;
            this.f50361e = j1Var2;
            this.f50362f = j1Var3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f50358b.close();
            cs.d0 d0Var = this.f50357a;
            if (d0Var instanceof cs.b0) {
                this.f50359c.write(((cs.b0) d0Var).d());
                this.f50359c.close();
            }
            this.f50362f.g();
            d dVar = z.this.f50057b;
            if (dVar != null) {
                this.f50361e.f(new n2(false, 1, (gm.h) new gm.l1(dVar.a(Collections.EMPTY_MAP).h())));
            }
            this.f50361e.g();
            this.f50360d.g();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f50358b.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f50358b.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f50358b.write(bArr, i10, i11);
        }
    }

    public final OutputStream d(gm.y yVar, OutputStream outputStream, cs.d0 d0Var) throws CMSException, IOException {
        gm.i iVar = new gm.i();
        cs.q key = d0Var.getKey();
        Iterator it2 = this.f50056a.iterator();
        while (it2.hasNext()) {
            iVar.a(((w1) it2.next()).a(key));
        }
        return g(yVar, outputStream, iVar, d0Var);
    }

    public final gm.t e(gm.i iVar) {
        return this.f50057b != null ? new gm.t(mm.t.x(this.f50058c, new b3(iVar), new b3())) : new gm.t(mm.t.x(this.f50058c, new b3(iVar), null));
    }

    public OutputStream f(gm.y yVar, OutputStream outputStream, cs.d0 d0Var) throws CMSException, IOException {
        return d(yVar, outputStream, d0Var);
    }

    public OutputStream g(gm.y yVar, OutputStream outputStream, gm.i iVar, cs.d0 d0Var) throws IOException {
        gm.j1 j1Var = new gm.j1(outputStream);
        j1Var.f(mm.k.L2);
        gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
        j1Var2.f(e(iVar));
        mm.g0 g0Var = this.f50058c;
        if (g0Var != null) {
            j1Var2.f(new n2(false, 0, (gm.h) g0Var));
        }
        if (this.f50356z) {
            j1Var2.a().write(new gm.l1(iVar).getEncoded());
        } else {
            j1Var2.a().write(new l2(iVar).getEncoded());
        }
        gm.j1 j1Var3 = new gm.j1(j1Var2.a());
        j1Var3.f(yVar);
        j1Var3.a().write(d0Var.a().getEncoded());
        return new a(d0Var, t0.e(j1Var3.a(), 0, false, this.f50355y), j1Var, j1Var2, j1Var3);
    }

    public OutputStream h(OutputStream outputStream, cs.d0 d0Var) throws CMSException, IOException {
        return d(new gm.y(mm.k.I2.L()), outputStream, d0Var);
    }

    public OutputStream i(OutputStream outputStream, gm.i iVar, cs.d0 d0Var) throws CMSException {
        try {
            gm.j1 j1Var = new gm.j1(outputStream);
            j1Var.f(mm.k.L2);
            gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
            org.bouncycastle.util.g l1Var = this.f50356z ? new gm.l1(iVar) : new l2(iVar);
            j1Var2.f(e(iVar));
            mm.g0 g0Var = this.f50058c;
            if (g0Var != null) {
                j1Var2.f(new n2(false, 0, (gm.h) g0Var));
            }
            j1Var2.a().write(l1Var.getEncoded());
            gm.j1 j1Var3 = new gm.j1(j1Var2.a());
            j1Var3.f(mm.k.I2);
            j1Var3.a().write(d0Var.a().getEncoded());
            return new a(d0Var, t0.e(j1Var3.a(), 0, false, this.f50355y), j1Var, j1Var2, j1Var3);
        } catch (IOException e10) {
            throw new CMSException("exception decoding algorithm parameters.", e10);
        }
    }

    public void j(boolean z10) {
        this.f50356z = z10;
    }

    public void k(int i10) {
        this.f50355y = i10;
    }
}
