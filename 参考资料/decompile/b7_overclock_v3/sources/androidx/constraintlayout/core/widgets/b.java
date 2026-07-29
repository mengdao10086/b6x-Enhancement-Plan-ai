package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3389a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3390b = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[PHI: r15 r16
  0x0044: PHI (r15v3 boolean) = (r15v1 boolean), (r15v32 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0044: PHI (r16v3 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[PHI: r15 r16
  0x0046: PHI (r15v30 boolean) = (r15v1 boolean), (r15v32 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0046: PHI (r16v5 boolean) = (r16v1 boolean), (r16v7 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x03b2 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r39v0, types: [androidx.constraintlayout.core.d] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(androidx.constraintlayout.core.widgets.d r38, androidx.constraintlayout.core.d r39, int r40, int r41, androidx.constraintlayout.core.widgets.c r42) {
        /*
            Method dump skipped, instruction units count: 1358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.b.a(androidx.constraintlayout.core.widgets.d, androidx.constraintlayout.core.d, int, int, androidx.constraintlayout.core.widgets.c):void");
    }

    public static void b(d dVar, androidx.constraintlayout.core.d dVar2, ArrayList<ConstraintWidget> arrayList, int i10) {
        c[] cVarArr;
        int i11;
        int i12;
        if (i10 == 0) {
            i11 = dVar.M1;
            cVarArr = dVar.P1;
            i12 = 0;
        } else {
            int i13 = dVar.N1;
            cVarArr = dVar.O1;
            i11 = i13;
            i12 = 2;
        }
        for (int i14 = 0; i14 < i11; i14++) {
            c cVar = cVarArr[i14];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f3391a)) {
                a(dVar, dVar2, i10, i12, cVar);
            }
        }
    }
}
