package gm;

/* JADX INFO: loaded from: classes5.dex */
public class e2 extends v {
    public e2(String str) {
        this(str, false);
    }

    public e2(String str, boolean z10) {
        super(str, z10);
    }

    public e2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static e2 M(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof e2)) ? N(c0VarU) : new e2(z.I(c0VarU).J(), true);
    }

    public static e2 N(Object obj) {
        if (obj == null || (obj instanceof e2)) {
            return (e2) obj;
        }
        if (obj instanceof v) {
            return new e2(((v) obj).f29813a, false);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (e2) c0.D((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }
}
