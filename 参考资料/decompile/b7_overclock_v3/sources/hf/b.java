package hf;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31260b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31261c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k[] f31262d = new k[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f31263a;

    public b(j jVar) {
        this.f31263a = jVar;
    }

    public static k d(k kVar, int i10, int i11) {
        l[] lVarArrF = kVar.f();
        if (lVarArrF == null) {
            return kVar;
        }
        l[] lVarArr = new l[lVarArrF.length];
        for (int i12 = 0; i12 < lVarArrF.length; i12++) {
            l lVar = lVarArrF[i12];
            if (lVar != null) {
                lVarArr[i12] = new l(lVar.c() + i10, lVar.d() + i11);
            }
        }
        k kVar2 = new k(kVar.g(), kVar.d(), kVar.c(), lVarArr, kVar.b(), kVar.h());
        kVar2.i(kVar.e());
        return kVar2;
    }

    public final void a(ve.b bVar, Map<DecodeHintType, ?> map, List<k> list, int i10, int i11, int i12) {
        boolean z10;
        float f10;
        float f11;
        int i13;
        int i14;
        int i15;
        int i16;
        if (i12 > 4) {
            return;
        }
        try {
            k kVarD = this.f31263a.d(bVar, map);
            Iterator<k> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().g().equals(kVarD.g())) {
                        z10 = true;
                        break;
                    }
                } else {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                list.add(d(kVarD, i10, i11));
            }
            l[] lVarArrF = kVarD.f();
            if (lVarArrF == null || lVarArrF.length == 0) {
                return;
            }
            int iE = bVar.e();
            int iD = bVar.d();
            float f12 = iE;
            float f13 = iD;
            float f14 = 0.0f;
            float f15 = 0.0f;
            for (l lVar : lVarArrF) {
                if (lVar != null) {
                    float fC = lVar.c();
                    float fD = lVar.d();
                    if (fC < f12) {
                        f12 = fC;
                    }
                    if (fD < f13) {
                        f13 = fD;
                    }
                    if (fC > f14) {
                        f14 = fC;
                    }
                    if (fD > f15) {
                        f15 = fD;
                    }
                }
            }
            if (f12 > 100.0f) {
                f10 = f14;
                f11 = f13;
                i13 = iD;
                i14 = iE;
                a(bVar.a(0, 0, (int) f12, iD), map, list, i10, i11, i12 + 1);
            } else {
                f10 = f14;
                f11 = f13;
                i13 = iD;
                i14 = iE;
            }
            if (f11 > 100.0f) {
                int i17 = (int) f11;
                i15 = i14;
                a(bVar.a(0, 0, i15, i17), map, list, i10, i11, i12 + 1);
            } else {
                i15 = i14;
            }
            float f16 = f10;
            if (f16 < i15 - 100) {
                int i18 = (int) f16;
                i16 = i13;
                a(bVar.a(i18, 0, i15 - i18, i16), map, list, i10 + i18, i11, i12 + 1);
            } else {
                i16 = i13;
            }
            if (f15 < i16 - 100) {
                int i19 = (int) f15;
                a(bVar.a(0, i19, i15, i16 - i19), map, list, i10, i11 + i19, i12 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    @Override // hf.c
    public k[] b(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(bVar, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.b();
        }
        return (k[]) arrayList.toArray(f31262d);
    }

    @Override // hf.c
    public k[] c(ve.b bVar) throws NotFoundException {
        return b(bVar, null);
    }
}
