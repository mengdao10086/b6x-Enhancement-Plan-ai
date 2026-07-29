package i6;

import com.blankj.utilcode.util.i0;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31871a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31872b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31873c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31874d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecimalFormat f31875e = new DecimalFormat();

    public static void a(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        int i13 = 0;
        if ((i12 < 0) || (i12 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        if (!z10) {
            int i14 = (i12 - 1) * 8;
            while (i13 < i12) {
                bArr[i13 + i11] = (byte) (((255 << i14) & i10) >> i14);
                i14 -= 8;
                i13++;
            }
            return;
        }
        int i15 = 0;
        for (int i16 = i12 - 1; i16 >= 0; i16--) {
            bArr[i15 + i11] = (byte) (((255 << i13) & i10) >> i13);
            i13 += 8;
            i15++;
        }
    }

    public static int b(byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = 0;
        if ((i11 < 0) || (i11 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        int i13 = (i11 - 1) * 8;
        if (z10) {
            for (int i14 = (i11 + i10) - 1; i14 >= i10; i14--) {
                i12 |= (bArr[i14] & 255) << i13;
                i13 -= 8;
            }
        } else {
            for (int i15 = i10; i15 < i10 + i11; i15++) {
                i12 |= (bArr[i15] & 255) << i13;
                i13 -= 8;
            }
        }
        return i12;
    }

    public static short c(byte[] bArr, int i10, int i11, boolean z10) {
        short s10 = 0;
        if ((i11 < 0) || (i11 > 2)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 2");
        }
        int i12 = (i11 - 1) * 8;
        if (z10) {
            for (int i13 = (i11 + i10) - 1; i13 >= i10; i13--) {
                s10 = (short) (((bArr[i13] & 255) << i12) | s10);
                i12 -= 8;
            }
        } else {
            for (int i14 = i10; i14 < i10 + i11; i14++) {
                s10 = (short) (s10 | ((bArr[i14] & 255) << i12));
                i12 -= 8;
            }
        }
        return s10;
    }

    public static String d(int i10) {
        return String.format("0x%04X", Integer.valueOf(i10 & 65535));
    }

    public static String e(double d10) {
        if (d10 <= 1.0d) {
            f31875e.setMaximumFractionDigits(2);
        } else {
            f31875e.setMaximumFractionDigits(1);
        }
        return f31875e.format(d10) + i0.f11861z + a.f31863g;
    }

    public static String f(byte[] bArr) {
        if (bArr == null) {
            return i0.f11859x;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(String.format("0x%02x ", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }
}
