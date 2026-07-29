package hf;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f31259a;

    public a(j jVar) {
        this.f31259a = jVar;
    }

    public static void b(l[] lVarArr, int i10, int i11) {
        if (lVarArr != null) {
            for (int i12 = 0; i12 < lVarArr.length; i12++) {
                l lVar = lVarArr[i12];
                if (lVar != null) {
                    lVarArr[i12] = new l(lVar.c() + i10, lVar.d() + i11);
                }
            }
        }
    }

    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return d(bVar, null);
    }

    @Override // ve.j
    public k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int iE = bVar.e() / 2;
        int iD = bVar.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.f31259a.d(bVar.a(0, 0, iE, iD), map);
                    } catch (NotFoundException unused) {
                        int i10 = iE / 2;
                        int i11 = iD / 2;
                        k kVarD = this.f31259a.d(bVar.a(i10, i11, iE, iD), map);
                        b(kVarD.f(), i10, i11);
                        return kVarD;
                    }
                } catch (NotFoundException unused2) {
                    k kVarD2 = this.f31259a.d(bVar.a(iE, iD, iE, iD), map);
                    b(kVarD2.f(), iE, iD);
                    return kVarD2;
                }
            } catch (NotFoundException unused3) {
                k kVarD3 = this.f31259a.d(bVar.a(0, iD, iE, iD), map);
                b(kVarD3.f(), 0, iD);
                return kVarD3;
            }
        } catch (NotFoundException unused4) {
            k kVarD4 = this.f31259a.d(bVar.a(iE, 0, iE, iD), map);
            b(kVarD4.f(), iE, 0);
            return kVarD4;
        }
    }

    @Override // ve.j
    public void reset() {
        this.f31259a.reset();
    }
}
