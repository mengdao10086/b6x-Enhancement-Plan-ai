package pr;

import co.l;
import com.blankj.utilcode.util.i0;
import ir.e;
import ir.f;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TreeSet;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f47012a = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SecureRandom f47013b = new SecureRandom();

    public static int a(f fVar) {
        int iG = fVar.g();
        int iA = 31 - j.a(iG);
        int i10 = 1;
        f fVarA = fVar;
        while (iA > 0) {
            fVarA = fVarA.s(i10).a(fVarA);
            iA--;
            i10 = iG >>> iA;
            if ((i10 & 1) != 0) {
                fVarA = fVarA.p().a(fVar);
            }
        }
        if (fVarA.j()) {
            return 0;
        }
        if (fVarA.i()) {
            return 1;
        }
        throw new IllegalStateException("Internal error in trace calculation");
    }

    public static ArrayList b(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static void c(l lVar) {
        PrintStream printStream;
        StringBuilder sb2;
        e eVarY = lVar.y();
        int iV = eVarY.v();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < iV; i10++) {
            if ((i10 & 1) != 0 || i10 == 0) {
                if (a(eVarY.n(f47012a.shiftLeft(i10))) != 0) {
                    arrayList.add(j.g(i10));
                    printStream = System.out;
                    sb2 = new StringBuilder();
                    sb2.append(i0.f11861z);
                    sb2.append(i10);
                    printStream.print(sb2.toString());
                }
            } else if (arrayList.contains(j.g(i10 >>> 1))) {
                arrayList.add(j.g(i10));
                printStream = System.out;
                sb2 = new StringBuilder();
                sb2.append(i0.f11861z);
                sb2.append(i10);
                printStream.print(sb2.toString());
            }
        }
        System.out.println();
        for (int i11 = 0; i11 < 1000; i11++) {
            BigInteger bigInteger = new BigInteger(iV, f47013b);
            int iA = a(eVarY.n(bigInteger));
            int i12 = 0;
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                if (bigInteger.testBit(((Integer) arrayList.get(i13)).intValue())) {
                    i12 ^= 1;
                }
            }
            if (iA != i12) {
                throw new IllegalStateException("Optimized-trace sanity check failed");
            }
        }
    }

    public static void d(String[] strArr) {
        TreeSet<String> treeSet = new TreeSet(b(co.e.e()));
        treeSet.addAll(b(ap.a.m()));
        for (String str : treeSet) {
            l lVarJ = ap.a.j(str);
            if (lVarJ == null) {
                lVarJ = co.e.b(str);
            }
            if (lVarJ != null && ir.c.m(lVarJ.y())) {
                System.out.print(str + ":");
                c(lVarJ);
            }
        }
    }

    public static void e(l lVar) {
        if (!ir.c.m(lVar.y())) {
            throw new IllegalArgumentException("Trace only defined over characteristic-2 fields");
        }
        c(lVar);
    }
}
