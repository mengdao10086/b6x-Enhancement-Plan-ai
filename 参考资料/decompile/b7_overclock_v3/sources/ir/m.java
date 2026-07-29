package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f35717a = "bc_fixed_point";

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f35718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f35719b;

        public a(e eVar, i iVar) {
            this.f35718a = eVar;
            this.f35719b = iVar;
        }

        @Override // ir.p
        public q a(q qVar) {
            l lVar = qVar instanceof l ? (l) qVar : null;
            int iA = m.a(this.f35718a);
            int i10 = iA > 250 ? 6 : 5;
            int i11 = 1 << i10;
            if (b(lVar, i11)) {
                return lVar;
            }
            int i12 = ((iA + i10) - 1) / i10;
            i[] iVarArr = new i[i10 + 1];
            iVarArr[0] = this.f35719b;
            for (int i13 = 1; i13 < i10; i13++) {
                iVarArr[i13] = iVarArr[i13 - 1].L(i12);
            }
            iVarArr[i10] = iVarArr[0].J(iVarArr[1]);
            this.f35718a.C(iVarArr);
            i[] iVarArr2 = new i[i11];
            iVarArr2[0] = iVarArr[0];
            for (int i14 = i10 - 1; i14 >= 0; i14--) {
                i iVar = iVarArr[i14];
                int i15 = 1 << i14;
                for (int i16 = i15; i16 < i11; i16 += i15 << 1) {
                    iVarArr2[i16] = iVarArr2[i16 - i15].a(iVar);
                }
            }
            this.f35718a.C(iVarArr2);
            l lVar2 = new l();
            lVar2.d(this.f35718a.f(iVarArr2, 0, i11));
            lVar2.e(iVarArr[i10]);
            lVar2.f(i10);
            return lVar2;
        }

        public final boolean b(l lVar, int i10) {
            return lVar != null && c(lVar.a(), i10);
        }

        public final boolean c(g gVar, int i10) {
            return gVar != null && gVar.c() >= i10;
        }
    }

    public static int a(e eVar) {
        BigInteger bigIntegerY = eVar.y();
        return bigIntegerY == null ? eVar.v() + 1 : bigIntegerY.bitLength();
    }

    public static l b(q qVar) {
        if (qVar instanceof l) {
            return (l) qVar;
        }
        return null;
    }

    public static l c(i iVar) {
        e eVarI = iVar.i();
        return (l) eVarI.E(iVar, f35717a, new a(eVarI, iVar));
    }
}
