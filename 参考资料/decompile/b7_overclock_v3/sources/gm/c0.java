package gm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 extends w {
    public static c0 D(byte[] bArr) throws IOException {
        s sVar = new s(bArr);
        try {
            c0 c0VarN = sVar.n();
            if (sVar.available() == 0) {
                return c0VarN;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract int A(boolean z10) throws IOException;

    public final boolean B(h hVar) {
        return this == hVar || (hVar != null && x(hVar.b()));
    }

    public final boolean C(c0 c0Var) {
        return this == c0Var || x(c0Var);
    }

    public c0 E() {
        return this;
    }

    public c0 F() {
        return this;
    }

    @Override // gm.w, gm.h
    public final c0 b() {
        return this;
    }

    @Override // gm.w
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && x(((h) obj).b());
    }

    @Override // gm.w
    public abstract int hashCode();

    @Override // gm.w
    public void t(OutputStream outputStream) throws IOException {
        b0 b0VarB = b0.b(outputStream);
        b0VarB.z(this, true);
        b0VarB.e();
    }

    @Override // gm.w
    public void u(OutputStream outputStream, String str) throws IOException {
        b0 b0VarC = b0.c(outputStream, str);
        b0VarC.z(this, true);
        b0VarC.e();
    }

    public abstract boolean x(c0 c0Var);

    public abstract void y(b0 b0Var, boolean z10) throws IOException;

    public abstract boolean z();
}
