package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class e3 extends o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f29670d;

    public e3(int i10, int i11, boolean z10, j0 j0Var) {
        super(i10, i11, j0Var);
        this.f29670d = z10;
    }

    @Override // gm.o1
    public boolean c() {
        return this.f29670d;
    }

    @Override // gm.o1, gm.o0
    public o0 f(int i10, int i11) throws IOException {
        return 64 == i10 ? (t2) this.f29760c.b(i10, i11, this.f29670d) : new e3(i10, i11, this.f29670d, this.f29760c);
    }

    @Override // gm.o1, gm.o0
    public h g() throws IOException {
        if (this.f29670d) {
            return this.f29760c.j();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // gm.o1, gm.o0
    public o0 j() throws IOException {
        if (this.f29670d) {
            return this.f29760c.i();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // gm.o1, gm.h3
    public c0 o() throws IOException {
        return this.f29760c.b(this.f29758a, this.f29759b, this.f29670d);
    }

    @Override // gm.o1, gm.o0
    public h p(boolean z10, int i10) throws IOException {
        if (!z10) {
            return this.f29670d ? this.f29760c.d(i10) : this.f29760c.f(i10);
        }
        if (this.f29670d) {
            return this.f29760c.h(i10);
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }
}
