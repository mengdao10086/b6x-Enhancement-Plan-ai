package kf;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import ve.n;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f37248a = 30;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37249b = 2;

    public static af.b c(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        af.b bVar = new af.b(bArr[0].length + i11, bArr.length + i11);
        bVar.b();
        int i12 = (bVar.i() - i10) - 1;
        int i13 = 0;
        while (i13 < bArr.length) {
            byte[] bArr2 = bArr[i13];
            for (int i14 = 0; i14 < bArr[0].length; i14++) {
                if (bArr2[i14] == 1) {
                    bVar.s(i14 + i10, i12);
                }
            }
            i13++;
            i12--;
        }
        return bVar;
    }

    public static af.b d(nf.d dVar, String str, int i10, int i11, int i12, int i13, boolean z10) throws WriterException {
        boolean z11;
        dVar.f(str, i10, z10);
        byte[][] bArrC = dVar.g().c(1, 4);
        if ((i12 > i11) != (bArrC[0].length < bArrC.length)) {
            bArrC = e(bArrC);
            z11 = true;
        } else {
            z11 = false;
        }
        int iMin = Math.min(i11 / bArrC[0].length, i12 / bArrC.length);
        if (iMin <= 1) {
            return c(bArrC, i13);
        }
        byte[][] bArrC2 = dVar.g().c(iMin, iMin * 4);
        if (z11) {
            bArrC2 = e(bArrC2);
        }
        return c(bArrC2, i13);
    }

    public static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int length = (bArr.length - i10) - 1;
            for (int i11 = 0; i11 < bArr[0].length; i11++) {
                bArr2[i11][length] = bArr[i10][i11];
            }
        }
        return bArr2;
    }

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        int i12;
        int i13;
        boolean z10;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        nf.d dVar = new nf.d();
        boolean z11 = false;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                dVar.i(Boolean.parseBoolean(map.get(encodeHintType).toString()));
            }
            EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                dVar.j(Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                nf.c cVar = (nf.c) map.get(encodeHintType3);
                dVar.k(cVar.a(), cVar.c(), cVar.b(), cVar.d());
            }
            EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
            int i14 = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
            int i15 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                dVar.l(Charset.forName(map.get(encodeHintType6).toString()));
            }
            EncodeHintType encodeHintType7 = EncodeHintType.PDF417_AUTO_ECI;
            if (map.containsKey(encodeHintType7) && Boolean.parseBoolean(map.get(encodeHintType7).toString())) {
                z11 = true;
            }
            i13 = i14;
            i12 = i15;
            z10 = z11;
        } else {
            i12 = 2;
            i13 = 30;
            z10 = false;
        }
        return d(dVar, str, i12, i10, i11, i13, z10);
    }
}
