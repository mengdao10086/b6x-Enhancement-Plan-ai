package gm;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Exception;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends c0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f29632a;

    public a(n0 n0Var) {
        G(n0Var.r());
        this.f29632a = n0Var;
    }

    public static int G(int i10) {
        if (64 == i10) {
            return i10;
        }
        throw new IllegalArgumentException();
    }

    public static a K(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        try {
            return K(c0.D((byte[]) obj));
        } catch (IOException e10) {
            throw new IllegalArgumentException("Failed to construct object from byte[]: " + e10.getMessage());
        }
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return this.f29632a.A(z10);
    }

    @Override // gm.c0
    public c0 E() {
        return new s1((n0) this.f29632a.E());
    }

    @Override // gm.c0
    public c0 F() {
        return new t2((n0) this.f29632a.F());
    }

    public int H() {
        return this.f29632a.q();
    }

    public byte[] I() {
        return this.f29632a.O();
    }

    public c0 J() throws IOException {
        return this.f29632a.L().b();
    }

    public c0 L() throws IOException {
        return J();
    }

    public c0 M(int i10) throws IOException {
        return this.f29632a.M(false, i10);
    }

    public n0 N() {
        return this.f29632a;
    }

    public boolean O(int i10) {
        return this.f29632a.e(64, i10);
    }

    public boolean P() {
        return this.f29632a.V();
    }

    @Override // gm.o0
    public boolean e(int i10, int i11) {
        return this.f29632a.e(i10, i11);
    }

    @Override // gm.o0
    public o0 f(int i10, int i11) throws IOException {
        return this.f29632a.f(i10, i11);
    }

    @Override // gm.o0
    public h g() throws IOException {
        return this.f29632a.g();
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return this.f29632a.hashCode();
    }

    @Override // gm.o0
    public o0 j() throws IOException {
        return this.f29632a.j();
    }

    @Override // gm.o0
    public h l(int i10, boolean z10) throws IOException {
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // gm.h3
    public final c0 o() {
        return this;
    }

    @Override // gm.o0
    public h p(boolean z10, int i10) throws IOException {
        return this.f29632a.p(z10, i10);
    }

    @Override // gm.o0
    public int q() {
        return this.f29632a.q();
    }

    @Override // gm.o0
    public int r() {
        return 64;
    }

    @Override // gm.b
    public h readObject() throws IOException {
        return g();
    }

    @Override // gm.o0
    public boolean s(int i10) {
        return false;
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        n0 n0Var;
        if (c0Var instanceof a) {
            n0Var = ((a) c0Var).f29632a;
        } else {
            if (!(c0Var instanceof n0)) {
                return false;
            }
            n0Var = (n0) c0Var;
        }
        return this.f29632a.C(n0Var);
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        this.f29632a.y(b0Var, z10);
    }

    @Override // gm.c0
    public boolean z() {
        return this.f29632a.z();
    }
}
