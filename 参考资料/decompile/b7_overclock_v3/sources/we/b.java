package we;

import af.d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.aztec.decoder.Decoder;
import java.util.List;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements j {
    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, FormatException {
        return d(bVar, null);
    }

    @Override // ve.j
    public k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        l[] lVarArrB;
        l[] lVarArrB2;
        FormatException formatException;
        m mVar;
        xe.a aVar = new xe.a(bVar.b());
        d dVarC = null;
        try {
            a aVarB = aVar.b(false);
            lVarArrB = aVarB.b();
            try {
                lVarArrB2 = lVarArrB;
                formatException = null;
                dVarC = new Decoder().c(aVarB);
                e = null;
            } catch (FormatException e10) {
                e = e10;
                lVarArrB2 = lVarArrB;
                formatException = e;
                e = null;
            } catch (NotFoundException e11) {
                e = e11;
                lVarArrB2 = lVarArrB;
                formatException = null;
            }
        } catch (FormatException e12) {
            e = e12;
            lVarArrB = null;
        } catch (NotFoundException e13) {
            e = e13;
            lVarArrB = null;
        }
        if (dVarC == null) {
            try {
                a aVarB2 = aVar.b(true);
                lVarArrB2 = aVarB2.b();
                dVarC = new Decoder().c(aVarB2);
            } catch (FormatException | NotFoundException e14) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e14;
            }
        }
        l[] lVarArr = lVarArrB2;
        if (map != null && (mVar = (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (l lVar : lVarArr) {
                mVar.a(lVar);
            }
        }
        k kVar = new k(dVarC.k(), dVarC.g(), dVarC.e(), lVarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List<byte[]> listA = dVarC.a();
        if (listA != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarC.b();
        if (strB != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]z" + dVarC.j());
        return kVar;
    }

    @Override // ve.j
    public void reset() {
    }
}
