package yn;

/* JADX INFO: loaded from: classes5.dex */
public class b extends c {
    public static final xn.f R = new b();

    @Override // yn.a, xn.f
    public boolean c(xn.d dVar, xn.d dVar2) {
        xn.c[] cVarArrC = dVar.C();
        xn.c[] cVarArrC2 = dVar2.C();
        if (cVarArrC.length != cVarArrC2.length) {
            return false;
        }
        for (int i10 = 0; i10 != cVarArrC.length; i10++) {
            if (!m(cVarArrC[i10], cVarArrC2[i10])) {
                return false;
            }
        }
        return true;
    }
}
