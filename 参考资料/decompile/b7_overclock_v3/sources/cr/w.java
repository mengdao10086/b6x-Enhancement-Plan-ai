package cr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class w implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25872a;

    public w(byte[] bArr) {
        this.f25872a = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25872a);
    }
}
