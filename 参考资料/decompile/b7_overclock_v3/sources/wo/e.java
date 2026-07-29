package wo;

import org.bouncycastle.crypto.r;

/* JADX INFO: loaded from: classes5.dex */
public class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f54770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f54772c;

    public e(byte[] bArr, int i10) {
        this(bArr, i10, null);
    }

    public e(byte[] bArr, int i10, byte[] bArr2) {
        this.f54770a = bArr;
        this.f54771b = i10;
        this.f54772c = bArr2;
    }

    public byte[] a() {
        return this.f54772c;
    }

    public int b() {
        return this.f54771b;
    }

    public byte[] c() {
        return this.f54770a;
    }
}
