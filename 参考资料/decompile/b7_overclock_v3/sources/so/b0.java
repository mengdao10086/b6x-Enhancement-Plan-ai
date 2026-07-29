package so;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class b0 {

    public static class a implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zn.b f50063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gm.y f50064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h0 f50065c;

        public a(zn.b bVar, gm.y yVar, h0 h0Var) {
            this.f50063a = bVar;
            this.f50064b = yVar;
            this.f50065c = h0Var;
        }

        @Override // so.i0
        public gm.y a() {
            return this.f50064b;
        }

        @Override // so.i0
        public InputStream c() throws CMSException, IOException {
            return this.f50065c.c();
        }
    }

    public static class b implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public cs.o f50066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gm.y f50067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h0 f50068c;

        public class a extends FilterInputStream {
            public a(InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                int i10 = ((FilterInputStream) this).in.read();
                if (i10 >= 0) {
                    b.this.f50066a.b().write(i10);
                }
                return i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
                if (i12 >= 0) {
                    b.this.f50066a.b().write(bArr, i10, i12);
                }
                return i12;
            }
        }

        public b(cs.o oVar, gm.y yVar, h0 h0Var) {
            this.f50066a = oVar;
            this.f50067b = yVar;
            this.f50068c = h0Var;
        }

        @Override // so.i0
        public gm.y a() {
            return this.f50067b;
        }

        @Override // so.i0
        public InputStream c() throws CMSException, IOException {
            return new a(this.f50068c.c());
        }

        public byte[] d() {
            return this.f50066a.c();
        }
    }

    public static class c implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zn.b f50070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gm.y f50071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h0 f50072c;

        public c(zn.b bVar, gm.y yVar, h0 h0Var) {
            this.f50070a = bVar;
            this.f50071b = yVar;
            this.f50072c = h0Var;
        }

        @Override // so.i0
        public gm.y a() {
            return this.f50071b;
        }

        @Override // so.i0
        public InputStream c() throws CMSException, IOException {
            return this.f50072c.c();
        }
    }

    public static y1 a(gm.h0 h0Var, zn.b bVar, i0 i0Var) {
        return b(h0Var, bVar, i0Var, null);
    }

    public static y1 b(gm.h0 h0Var, zn.b bVar, i0 i0Var, so.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != h0Var.size(); i10++) {
            c(arrayList, mm.o0.y(h0Var.J(i10)), bVar, i0Var, aVar);
        }
        return new y1(arrayList);
    }

    public static void c(List list, mm.o0 o0Var, zn.b bVar, i0 i0Var, so.a aVar) {
        Object t1Var;
        gm.h hVarX = o0Var.x();
        if (hVarX instanceof mm.d0) {
            t1Var = new j1((mm.d0) hVarX, bVar, i0Var, aVar);
        } else if (hVarX instanceof mm.a0) {
            t1Var = new b1((mm.a0) hVarX, bVar, i0Var, aVar);
        } else if (hVarX instanceof mm.c0) {
            f1.q(list, (mm.c0) hVarX, bVar, i0Var, aVar);
            return;
        } else if (!(hVarX instanceof mm.l0)) {
            return;
        } else {
            t1Var = new t1((mm.l0) hVarX, bVar, i0Var, aVar);
        }
        list.add(t1Var);
    }
}
