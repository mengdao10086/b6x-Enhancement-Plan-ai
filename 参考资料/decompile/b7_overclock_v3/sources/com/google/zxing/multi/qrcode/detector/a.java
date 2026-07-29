package com.google.zxing.multi.qrcode.detector;

import af.b;
import af.f;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.qrcode.detector.c;
import com.google.zxing.qrcode.detector.e;
import java.util.ArrayList;
import java.util.Map;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f[] f21372c = new f[0];

    public a(b bVar) {
        super(bVar);
    }

    public f[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        e[] eVarArrU = new MultiFinderPatternFinder(h(), map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).u(map);
        if (eVarArrU.length == 0) {
            throw NotFoundException.b();
        }
        ArrayList arrayList = new ArrayList();
        for (e eVar : eVarArrU) {
            try {
                arrayList.add(j(eVar));
            } catch (ReaderException unused) {
            }
        }
        return arrayList.isEmpty() ? f21372c : (f[]) arrayList.toArray(f21372c);
    }
}
