package yn;

import gm.h;
import gm.p2;
import gm.y;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements xn.f {
    public static Hashtable j(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    @Override // xn.f
    public int a(xn.d dVar) {
        xn.c[] cVarArrC = dVar.C();
        int iHashCode = 0;
        for (int i10 = 0; i10 != cVarArrC.length; i10++) {
            if (cVarArrC[i10].C()) {
                xn.a[] aVarArrB = cVarArrC[i10].B();
                for (int i11 = 0; i11 != aVarArrB.length; i11++) {
                    iHashCode = (iHashCode ^ aVarArrB[i11].y().hashCode()) ^ i(aVarArrB[i11].z());
                }
            } else {
                iHashCode = (iHashCode ^ cVarArrC[i10].z().y().hashCode()) ^ i(cVarArrC[i10].z().z());
            }
        }
        return iHashCode;
    }

    @Override // xn.f
    public boolean c(xn.d dVar, xn.d dVar2) {
        xn.c[] cVarArrC = dVar.C();
        xn.c[] cVarArrC2 = dVar2.C();
        if (cVarArrC.length != cVarArrC2.length) {
            return false;
        }
        boolean z10 = (cVarArrC[0].z() == null || cVarArrC2[0].z() == null) ? false : !cVarArrC[0].z().y().C(cVarArrC2[0].z().y());
        for (int i10 = 0; i10 != cVarArrC.length; i10++) {
            if (!l(z10, cVarArrC[i10], cVarArrC2)) {
                return false;
            }
        }
        return true;
    }

    @Override // xn.f
    public h f(y yVar, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return k(yVar, str);
        }
        try {
            return d.q(str, 1);
        } catch (IOException unused) {
            throw new ASN1ParsingException("can't recode value for oid " + yVar.L());
        }
    }

    public final int i(h hVar) {
        return d.d(hVar).hashCode();
    }

    public h k(y yVar, String str) {
        return new p2(str);
    }

    public final boolean l(boolean z10, xn.c cVar, xn.c[] cVarArr) {
        if (z10) {
            for (int length = cVarArr.length - 1; length >= 0; length--) {
                if (cVarArr[length] != null && m(cVar, cVarArr[length])) {
                    cVarArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i10 = 0; i10 != cVarArr.length; i10++) {
                if (cVarArr[i10] != null && m(cVar, cVarArr[i10])) {
                    cVarArr[i10] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m(xn.c cVar, xn.c cVar2) {
        return d.k(cVar, cVar2);
    }
}
