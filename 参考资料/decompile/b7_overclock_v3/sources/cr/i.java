package cr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class i implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f25819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25820c;

    public i(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    public i(int i10, byte[] bArr, boolean z10) {
        this.f25818a = i10;
        this.f25819b = org.bouncycastle.util.a.p(bArr);
        this.f25820c = z10;
    }

    public int a() {
        return this.f25818a;
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f25819b);
    }

    public boolean c() {
        return this.f25820c;
    }
}
