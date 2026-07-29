package cr;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class s implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25849a;

    public s(byte[] bArr) {
        Objects.requireNonNull(bArr, "id string cannot be null");
        this.f25849a = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25849a);
    }
}
