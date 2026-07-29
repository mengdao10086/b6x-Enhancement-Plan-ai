package id;

import com.google.android.exoplayer2.ParserException;
import g.p0;
import hd.c0;
import hd.d0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f32175d = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final List<byte[]> f32176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f32178c;

    public e(@p0 List<byte[]> list, int i10, @p0 String str) {
        this.f32176a = list;
        this.f32177b = i10;
        this.f32178c = str;
    }

    public static e a(c0 c0Var) throws ParserException {
        try {
            c0Var.T(21);
            int iG = c0Var.G() & 3;
            int iG2 = c0Var.G();
            int iE = c0Var.e();
            int i10 = 0;
            for (int i11 = 0; i11 < iG2; i11++) {
                c0Var.T(1);
                int iM = c0Var.M();
                for (int i12 = 0; i12 < iM; i12++) {
                    int iM2 = c0Var.M();
                    i10 += iM2 + 4;
                    c0Var.T(iM2);
                }
            }
            c0Var.S(iE);
            byte[] bArr = new byte[i10];
            String strC = null;
            int i13 = 0;
            for (int i14 = 0; i14 < iG2; i14++) {
                int iG3 = c0Var.G() & 127;
                int iM3 = c0Var.M();
                for (int i15 = 0; i15 < iM3; i15++) {
                    int iM4 = c0Var.M();
                    byte[] bArr2 = hd.y.f31231b;
                    System.arraycopy(bArr2, 0, bArr, i13, bArr2.length);
                    int length = i13 + bArr2.length;
                    System.arraycopy(c0Var.d(), c0Var.e(), bArr, length, iM4);
                    if (iG3 == 33 && i15 == 0) {
                        strC = hd.d.c(new d0(bArr, length, length + iM4));
                    }
                    i13 = length + iM4;
                    c0Var.T(iM4);
                }
            }
            return new e(i10 == 0 ? null : Collections.singletonList(bArr), iG + 1, strC);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw new ParserException("Error parsing HEVC config", e10);
        }
    }
}
