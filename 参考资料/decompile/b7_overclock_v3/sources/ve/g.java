package ve;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.a0;
import com.google.zxing.oned.t;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements n {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53133a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f53133a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53133a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f53133a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f53133a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f53133a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f53133a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f53133a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f53133a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f53133a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f53133a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f53133a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f53133a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f53133a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        n kVar;
        switch (a.f53133a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new com.google.zxing.oned.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new com.google.zxing.oned.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new of.b();
                break;
            case 6:
                kVar = new com.google.zxing.oned.e();
                break;
            case 7:
                kVar = new com.google.zxing.oned.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new com.google.zxing.oned.n();
                break;
            case 10:
                kVar = new kf.d();
                break;
            case 11:
                kVar = new com.google.zxing.oned.b();
                break;
            case 12:
                kVar = new df.b();
                break;
            case 13:
                kVar = new we.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return kVar.b(str, barcodeFormat, i10, i11, map);
    }
}
