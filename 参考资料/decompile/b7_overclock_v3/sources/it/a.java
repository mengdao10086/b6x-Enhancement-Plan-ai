package it;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class a implements n {
    @Override // it.n
    public byte[] a(cs.o oVar, un.i[] iVarArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 <= iVarArr.length - 2; i10 += 2) {
            arrayList.add(o.c(oVar, o.i(oVar, iVarArr[i10]), o.i(oVar, iVarArr[i10 + 1])));
        }
        if (iVarArr.length % 2 == 1) {
            arrayList.add(o.i(oVar, iVarArr[iVarArr.length - 1]));
        }
        while (true) {
            ArrayList arrayList2 = new ArrayList((arrayList.size() + 1) / 2);
            for (int i11 = 0; i11 <= arrayList.size() - 2; i11 += 2) {
                arrayList2.add(o.c(oVar, (byte[]) arrayList.get(i11), (byte[]) arrayList.get(i11 + 1)));
            }
            if (arrayList.size() % 2 == 1) {
                arrayList2.add(arrayList.get(arrayList.size() - 1));
            }
            if (arrayList2.size() <= 1) {
                return (byte[]) arrayList2.get(0);
            }
            arrayList = arrayList2;
        }
    }
}
