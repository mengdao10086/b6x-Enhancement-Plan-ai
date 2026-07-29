package com.google.zxing.oned;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class q implements ve.j {
    public static float e(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    public static void f(af.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iL = aVar.l();
        if (i10 >= iL) {
            throw NotFoundException.b();
        }
        boolean z10 = !aVar.h(i10);
        while (i10 < iL) {
            if (aVar.h(i10) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                i11++;
                if (i11 == length) {
                    break;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            i10++;
        }
        if (i11 != length) {
            if (i11 != length - 1 || i10 != iL) {
                throw NotFoundException.b();
            }
        }
    }

    public static void g(af.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zH = aVar.h(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (aVar.h(i10) != zH) {
                length--;
                zH = !zH;
            }
        }
        if (length >= 0) {
            throw NotFoundException.b();
        }
        f(aVar, i10 + 1, iArr);
    }

    @Override // ve.j
    public ve.k a(ve.b bVar) throws NotFoundException, FormatException {
        return d(bVar, null);
    }

    public abstract ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ve.k c(ve.b r22, java.util.Map<com.google.zxing.DecodeHintType, ?> r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.q.c(ve.b, java.util.Map):ve.k");
    }

    @Override // ve.j
    public ve.k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return c(bVar, map);
        } catch (NotFoundException e10) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !bVar.g()) {
                throw e10;
            }
            ve.b bVarH = bVar.h();
            ve.k kVarC = c(bVarH, map);
            Map<ResultMetadataType, Object> mapE = kVarC.e();
            int iIntValue = 270;
            if (mapE != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (mapE.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) mapE.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            kVarC.j(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            ve.l[] lVarArrF = kVarC.f();
            if (lVarArrF != null) {
                int iD = bVarH.d();
                for (int i10 = 0; i10 < lVarArrF.length; i10++) {
                    lVarArrF[i10] = new ve.l((iD - lVarArrF[i10].d()) - 1.0f, lVarArrF[i10].c());
                }
            }
            return kVarC;
        }
    }

    @Override // ve.j
    public void reset() {
    }
}
