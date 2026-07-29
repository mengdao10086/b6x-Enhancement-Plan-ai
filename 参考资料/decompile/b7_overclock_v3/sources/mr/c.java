package mr;

import ir.p;
import ir.q;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41575a = "bc_endo";

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mr.a f41576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ir.i f41577b;

        public a(mr.a aVar, ir.i iVar) {
            this.f41576a = aVar;
            this.f41577b = iVar;
        }

        @Override // ir.p
        public q a(q qVar) {
            b bVar = qVar instanceof b ? (b) qVar : null;
            if (b(bVar, this.f41576a)) {
                return bVar;
            }
            ir.i iVarA = this.f41576a.a().a(this.f41577b);
            b bVar2 = new b();
            bVar2.c(this.f41576a);
            bVar2.d(iVarA);
            return bVar2;
        }

        public final boolean b(b bVar, mr.a aVar) {
            return (bVar == null || bVar.a() != aVar || bVar.b() == null) ? false : true;
        }
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        boolean z10 = bigInteger2.signum() < 0;
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2.abs());
        boolean zTestBit = bigIntegerMultiply.testBit(i10 - 1);
        BigInteger bigIntegerShiftRight = bigIntegerMultiply.shiftRight(i10);
        if (zTestBit) {
            bigIntegerShiftRight = bigIntegerShiftRight.add(ir.d.f35647b);
        }
        return z10 ? bigIntegerShiftRight.negate() : bigIntegerShiftRight;
    }

    public static BigInteger[] b(i iVar, BigInteger bigInteger) {
        int iB = iVar.b();
        BigInteger bigIntegerA = a(bigInteger, iVar.c(), iB);
        BigInteger bigIntegerA2 = a(bigInteger, iVar.d(), iB);
        return new BigInteger[]{bigInteger.subtract(bigIntegerA.multiply(iVar.e()).add(bigIntegerA2.multiply(iVar.g()))), bigIntegerA.multiply(iVar.f()).add(bigIntegerA2.multiply(iVar.h())).negate()};
    }

    public static ir.i c(mr.a aVar, ir.i iVar) {
        return ((b) iVar.i().E(iVar, f41575a, new a(aVar, iVar))).b();
    }
}
