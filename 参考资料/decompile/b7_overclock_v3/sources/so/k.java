package so;

import gm.l2;
import gm.n2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class k extends l {
    public int A;
    public boolean B;
    public cs.y C;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OutputStream f50205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.j1 f50206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.j1 f50207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gm.j1 f50208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public cs.y f50209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public cs.o f50210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public gm.y f50211g;

        public a(cs.y yVar, cs.o oVar, gm.y yVar2, OutputStream outputStream, gm.j1 j1Var, gm.j1 j1Var2, gm.j1 j1Var3) {
            this.f50209e = yVar;
            this.f50210f = oVar;
            this.f50211g = yVar2;
            this.f50205a = outputStream;
            this.f50206b = j1Var;
            this.f50207c = j1Var2;
            this.f50208d = j1Var3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Map mapUnmodifiableMap;
            this.f50205a.close();
            this.f50208d.g();
            cs.o oVar = this.f50210f;
            if (oVar != null) {
                mapUnmodifiableMap = Collections.unmodifiableMap(k.this.d(this.f50211g, oVar.a(), this.f50209e.a(), this.f50210f.c()));
                k kVar = k.this;
                if (kVar.f50213y == null) {
                    kVar.f50213y = new u0();
                }
                l2 l2Var = new l2(k.this.f50213y.a(mapUnmodifiableMap).h());
                OutputStream outputStreamB = this.f50209e.b();
                outputStreamB.write(l2Var.v(gm.j.f29713a));
                outputStreamB.close();
                this.f50207c.f(new n2(false, 2, (gm.h) l2Var));
            } else {
                mapUnmodifiableMap = Collections.EMPTY_MAP;
            }
            this.f50207c.f(new gm.f2(this.f50209e.d()));
            if (k.this.f50214z != null) {
                this.f50207c.f(new n2(false, 3, (gm.h) new gm.l1(k.this.f50214z.a(mapUnmodifiableMap).h())));
            }
            this.f50207c.g();
            this.f50206b.g();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f50205a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f50205a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f50205a.write(bArr, i10, i11);
        }
    }

    public OutputStream g(gm.y yVar, OutputStream outputStream, cs.y yVar2) throws CMSException {
        return h(yVar, outputStream, yVar2, null);
    }

    public OutputStream h(gm.y yVar, OutputStream outputStream, cs.y yVar2, cs.o oVar) throws CMSException {
        this.C = yVar2;
        try {
            gm.i iVar = new gm.i();
            Iterator it2 = this.f50056a.iterator();
            while (it2.hasNext()) {
                iVar.a(((w1) it2.next()).a(yVar2.getKey()));
            }
            gm.j1 j1Var = new gm.j1(outputStream);
            j1Var.f(mm.k.P2);
            gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
            j1Var2.f(new gm.t(mm.f.x(this.f50058c)));
            mm.g0 g0Var = this.f50058c;
            if (g0Var != null) {
                j1Var2.f(new n2(false, 0, (gm.h) g0Var));
            }
            if (this.B) {
                j1Var2.a().write(new gm.l1(iVar).getEncoded());
            } else {
                j1Var2.a().write(new l2(iVar).getEncoded());
            }
            j1Var2.a().write(yVar2.a().getEncoded());
            if (oVar != null) {
                j1Var2.f(new n2(false, 1, (gm.h) oVar.a()));
            }
            gm.j1 j1Var3 = new gm.j1(j1Var2.a());
            j1Var3.f(yVar);
            OutputStream outputStreamE = t0.e(j1Var3.a(), 0, true, this.A);
            return new a(yVar2, oVar, yVar, oVar != null ? new kt.e(outputStreamE, oVar.b()) : new kt.e(outputStreamE, yVar2.b()), j1Var, j1Var2, j1Var3);
        } catch (IOException e10) {
            throw new CMSException("exception decoding algorithm parameters.", e10);
        }
    }

    public OutputStream i(OutputStream outputStream, cs.y yVar) throws CMSException {
        return g(mm.k.I2, outputStream, yVar);
    }

    public OutputStream j(OutputStream outputStream, cs.y yVar, cs.o oVar) throws CMSException {
        return h(mm.k.I2, outputStream, yVar, oVar);
    }

    public void k(boolean z10) {
        this.B = z10;
    }

    public void l(int i10) {
        this.A = i10;
    }
}
