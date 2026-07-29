package gf;

import af.d;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29402b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29403c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29404d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cf.c f29405a = new cf.c(cf.a.f10941o);

    public final void a(byte[] bArr, int i10, int i11, int i12, int i13) throws ChecksumException {
        int i14 = i11 + i12;
        int i15 = i13 == 0 ? 1 : 2;
        int[] iArr = new int[i14 / i15];
        for (int i16 = 0; i16 < i14; i16++) {
            if (i13 == 0 || i16 % 2 == i13 - 1) {
                iArr[i16 / i15] = bArr[i16 + i10] & 255;
            }
        }
        try {
            this.f29405a.a(iArr, i12 / i15);
            for (int i17 = 0; i17 < i11; i17++) {
                if (i13 == 0 || i17 % 2 == i13 - 1) {
                    bArr[i17 + i10] = (byte) iArr[i17 / i15];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.b();
        }
    }

    public d b(af.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public d c(af.b bVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        byte[] bArr;
        byte[] bArrA = new a(bVar).a();
        a(bArrA, 0, 10, 10, 0);
        int i10 = bArrA[0] & 15;
        if (i10 == 2 || i10 == 3 || i10 == 4) {
            a(bArrA, 20, 84, 40, 1);
            a(bArrA, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i10 != 5) {
                throw FormatException.b();
            }
            a(bArrA, 20, 68, 56, 1);
            a(bArrA, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArrA, 0, bArr, 0, 10);
        System.arraycopy(bArrA, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i10);
    }
}
