package ve;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f53146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l[] f53148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BarcodeFormat f53149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<ResultMetadataType, Object> f53150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f53151g;

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, lVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(l[] lVarArr) {
        l[] lVarArr2 = this.f53148d;
        if (lVarArr2 == null) {
            this.f53148d = lVarArr;
            return;
        }
        if (lVarArr == null || lVarArr.length <= 0) {
            return;
        }
        l[] lVarArr3 = new l[lVarArr2.length + lVarArr.length];
        System.arraycopy(lVarArr2, 0, lVarArr3, 0, lVarArr2.length);
        System.arraycopy(lVarArr, 0, lVarArr3, lVarArr2.length, lVarArr.length);
        this.f53148d = lVarArr3;
    }

    public BarcodeFormat b() {
        return this.f53149e;
    }

    public int c() {
        return this.f53147c;
    }

    public byte[] d() {
        return this.f53146b;
    }

    public Map<ResultMetadataType, Object> e() {
        return this.f53150f;
    }

    public l[] f() {
        return this.f53148d;
    }

    public String g() {
        return this.f53145a;
    }

    public long h() {
        return this.f53151g;
    }

    public void i(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f53150f;
            if (map2 == null) {
                this.f53150f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f53150f == null) {
            this.f53150f = new EnumMap(ResultMetadataType.class);
        }
        this.f53150f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f53145a;
    }

    public k(String str, byte[] bArr, l[] lVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, lVarArr, barcodeFormat, j10);
    }

    public k(String str, byte[] bArr, int i10, l[] lVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f53145a = str;
        this.f53146b = bArr;
        this.f53147c = i10;
        this.f53148d = lVarArr;
        this.f53149e = barcodeFormat;
        this.f53150f = null;
        this.f53151g = j10;
    }
}
