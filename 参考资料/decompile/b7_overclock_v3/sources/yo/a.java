package yo;

import java.security.SecureRandom;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.l;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.v;

/* JADX INFO: loaded from: classes5.dex */
public class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f57446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f57447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureRandom f57448c;

    public a(v vVar, SecureRandom secureRandom) {
        this.f57446a = vVar;
        this.f57447b = vVar.g();
        this.f57448c = secureRandom;
    }

    @Override // org.bouncycastle.crypto.m
    public boolean a(l lVar, byte[] bArr) {
        if (bArr.length + lVar.b().length != this.f57447b) {
            throw new DataLengthException("Message and witness secret lengths do not match.");
        }
        return org.bouncycastle.util.a.I(lVar.a(), c(lVar.b(), bArr));
    }

    @Override // org.bouncycastle.crypto.m
    public l b(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f57447b;
        if (length > i10 / 2) {
            throw new DataLengthException("Message to be committed to too large for digest.");
        }
        byte[] bArr2 = new byte[i10 - bArr.length];
        this.f57448c.nextBytes(bArr2);
        return new l(bArr2, c(bArr2, bArr));
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[this.f57446a.h()];
        this.f57446a.update(bArr, 0, bArr.length);
        this.f57446a.update(bArr2, 0, bArr2.length);
        this.f57446a.update((byte) (bArr2.length >>> 8));
        this.f57446a.update((byte) bArr2.length);
        this.f57446a.c(bArr3, 0);
        return bArr3;
    }
}
