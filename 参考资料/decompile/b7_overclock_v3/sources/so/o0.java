package so;

import gm.l2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSStreamException;

/* JADX INFO: loaded from: classes5.dex */
public class o0 extends p0 {
    public int G;

    public class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OutputStream f50244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.y f50245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.j1 f50246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gm.j1 f50247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public gm.j1 f50248e;

        public a(OutputStream outputStream, gm.y yVar, gm.j1 j1Var, gm.j1 j1Var2, gm.j1 j1Var3) {
            this.f50244a = outputStream;
            this.f50245b = yVar;
            this.f50246c = j1Var;
            this.f50247d = j1Var2;
            this.f50248e = j1Var3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f50244a.close();
            this.f50248e.g();
            o0.this.f50283e.clear();
            if (o0.this.f50279a.size() != 0) {
                this.f50247d.a().write(new gm.n1(false, 0, (gm.h) t0.f(o0.this.f50279a)).getEncoded());
            }
            if (o0.this.f50280b.size() != 0) {
                this.f50247d.a().write(new gm.n1(false, 1, (gm.h) t0.f(o0.this.f50280b)).getEncoded());
            }
            gm.i iVar = new gm.i();
            for (b2 b2Var : o0.this.f50282d) {
                try {
                    iVar.a(b2Var.a(this.f50245b));
                    o0.this.f50283e.put(b2Var.g().x().L(), b2Var.e());
                } catch (CMSException e10) {
                    throw new CMSStreamException("exception generating signers: " + e10.getMessage(), e10);
                }
            }
            Iterator it2 = o0.this.f50281c.iterator();
            while (it2.hasNext()) {
                iVar.a(((d2) it2.next()).v());
            }
            this.f50247d.a().write(new l2(iVar).getEncoded());
            this.f50247d.g();
            this.f50246c.g();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f50244a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f50244a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f50244a.write(bArr, i10, i11);
        }
    }

    public o0() {
    }

    public o0(cs.n nVar) {
        super(nVar);
    }

    public final gm.t m(gm.y yVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        List list = this.f50279a;
        boolean z13 = false;
        if (list != null) {
            z10 = false;
            z11 = false;
            z12 = false;
            for (Object obj : list) {
                if (obj instanceof gm.n0) {
                    gm.n0 n0Var = (gm.n0) obj;
                    if (n0Var.q() == 1) {
                        z11 = true;
                    } else if (n0Var.q() == 2) {
                        z12 = true;
                    } else if (n0Var.q() == 3) {
                        z10 = true;
                    }
                }
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
        }
        if (z10) {
            return new gm.t(5L);
        }
        List list2 = this.f50280b;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next() instanceof gm.n0) {
                    z13 = true;
                }
            }
        }
        if (z13) {
            return new gm.t(5L);
        }
        if (z12) {
            return new gm.t(4L);
        }
        if (!z11 && !n(this.f50281c, this.f50282d) && mm.k.I2.C(yVar)) {
            return new gm.t(1L);
        }
        return new gm.t(3L);
    }

    public final boolean n(List list, List list2) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (mm.v0.B(((d2) it2.next()).v()).E().Q() == 3) {
                return true;
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            if (((b2) it3.next()).h() == 3) {
                return true;
            }
        }
        return false;
    }

    public List<zn.b> o() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = this.f50281c.iterator();
        while (it2.hasNext()) {
            arrayList.add(q0.f50286a.b(((d2) it2.next()).i(), this.f50284f));
        }
        Iterator it3 = this.f50282d.iterator();
        while (it3.hasNext()) {
            arrayList.add(((b2) it3.next()).g());
        }
        return arrayList;
    }

    public OutputStream p(gm.y yVar, OutputStream outputStream, boolean z10) throws IOException {
        return q(yVar, outputStream, z10, null);
    }

    public OutputStream q(gm.y yVar, OutputStream outputStream, boolean z10, OutputStream outputStream2) throws IOException {
        gm.j1 j1Var = new gm.j1(outputStream);
        j1Var.f(mm.k.J2);
        gm.j1 j1Var2 = new gm.j1(j1Var.a(), 0, true);
        j1Var2.f(m(yVar));
        HashSet hashSet = new HashSet();
        Iterator it2 = this.f50281c.iterator();
        while (it2.hasNext()) {
            t0.a(hashSet, (d2) it2.next(), this.f50284f);
        }
        Iterator it3 = this.f50282d.iterator();
        while (it3.hasNext()) {
            hashSet.add(((b2) it3.next()).g());
        }
        j1Var2.a().write(t0.d(hashSet).getEncoded());
        gm.j1 j1Var3 = new gm.j1(j1Var2.a());
        j1Var3.f(yVar);
        return new a(t0.c(this.f50282d, t0.m(outputStream2, z10 ? t0.e(j1Var3.a(), 0, true, this.G) : null)), yVar, j1Var, j1Var2, j1Var3);
    }

    public OutputStream r(OutputStream outputStream) throws IOException {
        return s(outputStream, false);
    }

    public OutputStream s(OutputStream outputStream, boolean z10) throws IOException {
        return p(mm.k.I2, outputStream, z10);
    }

    public OutputStream t(OutputStream outputStream, boolean z10, OutputStream outputStream2) throws IOException {
        return q(mm.k.I2, outputStream, z10, outputStream2);
    }

    public void u(int i10) {
        this.G = i10;
    }
}
