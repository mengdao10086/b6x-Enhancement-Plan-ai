package com.google.zxing.multi.qrcode;

import af.d;
import af.f;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import hf.c;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import ve.b;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class QRCodeMultiReader extends of.a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k[] f21363c = new k[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l[] f21364d = new l[0];

    public static final class SAComparator implements Comparator<k>, Serializable {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(k kVar, k kVar2) {
            Map<ResultMetadataType, Object> mapE = kVar.e();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) mapE.get(resultMetadataType)).intValue(), ((Integer) kVar2.e().get(resultMetadataType)).intValue());
        }
    }

    public static List<k> h(List<k> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<k> arrayList2 = new ArrayList();
        for (k kVar : list) {
            if (kVar.e().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(kVar);
            } else {
                arrayList.add(kVar);
            }
        }
        if (arrayList2.isEmpty()) {
            return list;
        }
        Collections.sort(arrayList2, new SAComparator());
        StringBuilder sb2 = new StringBuilder();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        for (k kVar2 : arrayList2) {
            sb2.append(kVar2.g());
            byte[] bArrD = kVar2.d();
            byteArrayOutputStream.write(bArrD, 0, bArrD.length);
            Iterable<byte[]> iterable = (Iterable) kVar2.e().get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                for (byte[] bArr : iterable) {
                    byteArrayOutputStream2.write(bArr, 0, bArr.length);
                }
            }
        }
        k kVar3 = new k(sb2.toString(), byteArrayOutputStream.toByteArray(), f21364d, BarcodeFormat.QR_CODE);
        if (byteArrayOutputStream2.size() > 0) {
            kVar3.j(ResultMetadataType.BYTE_SEGMENTS, Collections.singletonList(byteArrayOutputStream2.toByteArray()));
        }
        arrayList.add(kVar3);
        return arrayList;
    }

    @Override // hf.c
    public k[] b(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (f fVar : new com.google.zxing.multi.qrcode.detector.a(bVar.b()).n(map)) {
            try {
                d dVarC = f().c(fVar.a(), map);
                l[] lVarArrB = fVar.b();
                if (dVarC.f() instanceof com.google.zxing.qrcode.decoder.f) {
                    ((com.google.zxing.qrcode.decoder.f) dVarC.f()).a(lVarArrB);
                }
                k kVar = new k(dVarC.k(), dVarC.g(), lVarArrB, BarcodeFormat.QR_CODE);
                List<byte[]> listA = dVarC.a();
                if (listA != null) {
                    kVar.j(ResultMetadataType.BYTE_SEGMENTS, listA);
                }
                String strB = dVarC.b();
                if (strB != null) {
                    kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
                }
                if (dVarC.l()) {
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVarC.i()));
                    kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVarC.h()));
                }
                arrayList.add(kVar);
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f21363c : (k[]) h(arrayList).toArray(f21363c);
    }

    @Override // hf.c
    public k[] c(b bVar) throws NotFoundException {
        return b(bVar, null);
    }
}
