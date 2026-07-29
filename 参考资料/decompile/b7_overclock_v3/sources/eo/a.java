package eo;

import cs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.util.r;
import p000do.f;
import zn.b1;
import zn.i;
import zo.c0;

/* JADX INFO: loaded from: classes5.dex */
public class a extends f {

    public static class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteArrayOutputStream f27083a;

        public b() {
            this.f27083a = new ByteArrayOutputStream();
        }

        @Override // cs.o
        public zn.b a() {
            return new zn.b(on.b.f44365i);
        }

        @Override // cs.o
        public OutputStream b() {
            return this.f27083a;
        }

        @Override // cs.o
        public byte[] c() {
            byte[] byteArray = this.f27083a.toByteArray();
            this.f27083a.reset();
            c0 c0Var = new c0();
            c0Var.update(byteArray, 0, byteArray.length);
            byte[] bArr = new byte[c0Var.h()];
            c0Var.c(bArr, 0);
            return bArr;
        }
    }

    public a() {
        super(new b());
    }

    public a(o oVar) {
        super(oVar);
    }

    public i h(np.c cVar) throws IOException {
        return super.c(r.a(cVar));
    }

    public b1 i(np.c cVar) throws IOException {
        return super.e(r.a(cVar));
    }
}
