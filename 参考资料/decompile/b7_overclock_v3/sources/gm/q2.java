package gm;

/* JADX INFO: loaded from: classes5.dex */
public class q2 extends s0 {
    public q2(byte[] bArr) {
        this(bArr, true);
    }

    public q2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static q2 M(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof q2)) ? N(c0VarU) : new q2(z.I(c0VarU).J(), true);
    }

    public static q2 N(Object obj) {
        if (obj == null || (obj instanceof q2)) {
            return (q2) obj;
        }
        if (obj instanceof s0) {
            return new q2(((s0) obj).f29804a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error getInstance: " + e10.toString());
        }
    }
}
