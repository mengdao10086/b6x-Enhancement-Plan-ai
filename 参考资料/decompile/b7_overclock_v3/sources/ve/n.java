package ve;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface n {
    af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException;

    af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException;
}
