package ir;

import ir.e;
import ir.i;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c0 extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f35643a = "bc_wtnaf";

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i.b f35644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte f35645b;

        public a(i.b bVar, byte b10) {
            this.f35644a = bVar;
            this.f35645b = b10;
        }

        @Override // ir.p
        public q a(q qVar) {
            if (qVar instanceof d0) {
                return qVar;
            }
            d0 d0Var = new d0();
            d0Var.b(x.f(this.f35644a, this.f35645b));
            return d0Var;
        }
    }

    public static i.b d(i.b bVar, byte[] bArr) {
        e.b bVar2 = (e.b) bVar.i();
        i.b[] bVarArrA = ((d0) bVar2.E(bVar, f35643a, new a(bVar, bVar2.o().v().byteValue()))).a();
        i.b[] bVarArr = new i.b[bVarArrA.length];
        for (int i10 = 0; i10 < bVarArrA.length; i10++) {
            bVarArr[i10] = (i.b) bVarArrA[i10].A();
        }
        i.b bVar3 = (i.b) bVar.i().w();
        int i11 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i11++;
            byte b10 = bArr[length];
            if (b10 != 0) {
                bVar3 = (i.b) bVar3.P(i11).a(b10 > 0 ? bVarArrA[b10 >>> 1] : bVarArr[(-b10) >>> 1]);
                i11 = 0;
            }
        }
        return i11 > 0 ? bVar3.P(i11) : bVar3;
    }

    @Override // ir.b
    public i c(i iVar, BigInteger bigInteger) {
        if (!(iVar instanceof i.b)) {
            throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
        }
        i.b bVar = (i.b) iVar;
        e.b bVar2 = (e.b) bVar.i();
        int iV = bVar2.v();
        byte bByteValue = bVar2.o().v().byteValue();
        byte bC = x.c(bByteValue);
        return e(bVar, x.p(bigInteger, iV, bByteValue, bVar2.K(), bC, (byte) 10), bByteValue, bC);
    }

    public final i.b e(i.b bVar, e0 e0Var, byte b10, byte b11) {
        e0[] e0VarArr = b10 == 0 ? x.f35743f : x.f35745h;
        return d(bVar, x.t(b11, e0Var, (byte) 4, BigInteger.valueOf(16L), x.j(b11, 4), e0VarArr));
    }
}
