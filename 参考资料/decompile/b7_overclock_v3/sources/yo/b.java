package yo;

import java.security.SecureRandom;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.l;
import org.bouncycastle.crypto.m;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.v;

/* JADX INFO: loaded from: classes5.dex */
public class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f57449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f57450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureRandom f57451c;

    public b(v vVar, SecureRandom secureRandom) {
        this.f57449a = vVar;
        this.f57450b = vVar.g();
        this.f57451c = secureRandom;
    }

    @Override // org.bouncycastle.crypto.m
    public boolean a(l lVar, byte[] bArr) {
        if (bArr.length + lVar.b().length != this.f57450b) {
            throw new DataLengthException("Message and witness secret lengths do not match.");
        }
        return org.bouncycastle.util.a.I(lVar.a(), c(lVar.b(), bArr));
    }

    @Override // org.bouncycastle.crypto.m
    public l b(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f57450b;
        if (length > i10 / 2) {
            throw new DataLengthException("Message to be committed to too large for digest.");
        }
        byte[] bArr2 = new byte[i10 - bArr.length];
        this.f57451c.nextBytes(bArr2);
        return new l(bArr2, c(bArr2, bArr));
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[this.f57449a.h()];
        this.f57449a.update(bArr, 0, bArr.length);
        this.f57449a.update(bArr2, 0, bArr2.length);
        this.f57449a.c(bArr3, 0);
        return bArr3;
    }
}
