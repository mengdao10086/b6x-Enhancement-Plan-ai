package gm;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class k3 extends f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f29728c;

    public k3(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "'encoded' cannot be null");
        this.f29728c = bArr;
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        byte[] bArrU = U();
        return bArrU != null ? b0.i(z10, bArrU.length) : super.F().A(z10);
    }

    @Override // gm.f0, gm.c0
    public c0 E() {
        T();
        return super.E();
    }

    @Override // gm.f0, gm.c0
    public c0 F() {
        T();
        return super.F();
    }

    @Override // gm.f0
    public h K(int i10) {
        T();
        return super.K(i10);
    }

    @Override // gm.f0
    public Enumeration L() {
        byte[] bArrU = U();
        return bArrU != null ? new j3(bArrU) : super.L();
    }

    @Override // gm.f0
    public d N() {
        return ((f0) F()).N();
    }

    @Override // gm.f0
    public l O() {
        return ((f0) F()).O();
    }

    @Override // gm.f0
    public z P() {
        return ((f0) F()).P();
    }

    @Override // gm.f0
    public h0 Q() {
        return ((f0) F()).Q();
    }

    @Override // gm.f0
    public h[] R() {
        T();
        return super.R();
    }

    @Override // gm.f0
    public h[] S() {
        T();
        return super.S();
    }

    public final synchronized void T() {
        if (this.f29728c != null) {
            s sVar = new s(this.f29728c, true);
            try {
                i iVarI = sVar.I();
                sVar.close();
                this.f29678a = iVarI.j();
                this.f29728c = null;
            } catch (IOException e10) {
                throw new ASN1ParsingException("malformed ASN.1: " + e10, e10);
            }
        }
    }

    public final synchronized byte[] U() {
        return this.f29728c;
    }

    @Override // gm.f0, gm.c0, gm.w
    public int hashCode() {
        T();
        return super.hashCode();
    }

    @Override // gm.f0, org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<h> iterator() {
        T();
        return super.iterator();
    }

    @Override // gm.f0
    public int size() {
        T();
        return super.size();
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        byte[] bArrU = U();
        if (bArrU != null) {
            b0Var.r(z10, 48, bArrU);
        } else {
            super.F().y(b0Var, z10);
        }
    }
}
