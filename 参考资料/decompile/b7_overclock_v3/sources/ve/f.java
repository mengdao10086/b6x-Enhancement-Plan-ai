package ve;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.oned.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j[] f53130c = new j[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f53131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j[] f53132b;

    @Override // ve.j
    public k a(b bVar) throws NotFoundException {
        e(null);
        return b(bVar);
    }

    public final k b(b bVar) throws NotFoundException {
        j[] jVarArr = this.f53132b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.b();
                }
                try {
                    return jVar.d(bVar, this.f53131a);
                } catch (ReaderException unused) {
                }
            }
            Map<DecodeHintType, ?> map = this.f53131a;
            if (map != null && map.containsKey(DecodeHintType.ALSO_INVERTED)) {
                bVar.b().d();
                for (j jVar2 : this.f53132b) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw NotFoundException.b();
                    }
                    try {
                        return jVar2.d(bVar, this.f53131a);
                    } catch (ReaderException unused2) {
                    }
                }
            }
        }
        throw NotFoundException.b();
    }

    public k c(b bVar) throws NotFoundException {
        if (this.f53132b == null) {
            e(null);
        }
        return b(bVar);
    }

    @Override // ve.j
    public k d(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        e(map);
        return b(bVar);
    }

    public void e(Map<DecodeHintType, ?> map) {
        this.f53131a = map;
        boolean z10 = true;
        boolean z11 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z10 = false;
            }
            if (z10 && !z11) {
                arrayList.add(new o(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new of.a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new df.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new we.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new kf.b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new ff.a());
            }
            if (z10 && z11) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z11) {
                arrayList.add(new o(map));
            }
            arrayList.add(new of.a());
            arrayList.add(new df.a());
            arrayList.add(new we.b());
            arrayList.add(new kf.b());
            arrayList.add(new ff.a());
            if (z11) {
                arrayList.add(new o(map));
            }
        }
        this.f53132b = (j[]) arrayList.toArray(f53130c);
    }

    @Override // ve.j
    public void reset() {
        j[] jVarArr = this.f53132b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.reset();
            }
        }
    }
}
