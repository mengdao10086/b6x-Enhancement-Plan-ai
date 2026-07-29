package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class m0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25558c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25560b;

    public m0() {
        this(1);
    }

    public m0(int i10) {
        this.f25560b = i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f25559a = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Null";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f25560b;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (!this.f25559a) {
            throw new IllegalStateException("Null engine not initialised");
        }
        int i12 = this.f25560b;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i13 = 0;
        while (true) {
            int i14 = this.f25560b;
            if (i13 >= i14) {
                return i14;
            }
            bArr2[i11 + i13] = bArr[i10 + i13];
            i13++;
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
