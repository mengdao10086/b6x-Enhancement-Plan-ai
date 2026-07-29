package gm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class o1 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f29760c;

    public o1(int i10, int i11, j0 j0Var) {
        this.f29758a = i10;
        this.f29759b = i11;
        this.f29760c = j0Var;
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException(e10.getMessage());
        }
    }

    public boolean c() {
        return true;
    }

    @Override // gm.o0
    public boolean e(int i10, int i11) {
        return this.f29758a == i10 && this.f29759b == i11;
    }

    @Override // gm.o0
    public o0 f(int i10, int i11) throws IOException {
        return 64 == i10 ? new z0(i11, this.f29760c) : new o1(i10, i11, this.f29760c);
    }

    @Override // gm.o0
    public h g() throws IOException {
        return this.f29760c.j();
    }

    @Override // gm.o0
    public o0 j() throws IOException {
        return this.f29760c.i();
    }

    @Override // gm.o0
    public h l(int i10, boolean z10) throws IOException {
        if (128 == r()) {
            return p(z10, i10);
        }
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public c0 o() throws IOException {
        return this.f29760c.c(this.f29758a, this.f29759b);
    }

    @Override // gm.o0
    public h p(boolean z10, int i10) throws IOException {
        return z10 ? this.f29760c.h(i10) : this.f29760c.e(i10);
    }

    @Override // gm.o0
    public int q() {
        return this.f29759b;
    }

    @Override // gm.o0
    public int r() {
        return this.f29758a;
    }

    @Override // gm.o0
    public boolean s(int i10) {
        return this.f29758a == 128 && this.f29759b == i10;
    }
}
