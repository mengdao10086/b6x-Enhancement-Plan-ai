package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3468a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3469b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3470c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3471d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3472e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3473f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3474g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3475h = 64;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3476i = 128;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3477j = 256;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3478k = 512;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f3479l = 1024;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3480m = 257;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean[] f3481n = new boolean[3];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3482o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f3483p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3484q = 2;

    public static void a(d dVar, androidx.constraintlayout.core.d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f3273t = -1;
        constraintWidget.f3275u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.f3238b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f3238b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i10 = constraintWidget.Q.f3205g;
            int iM0 = dVar.m0() - constraintWidget.S.f3205g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.f3207i = dVar2.u(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.f3207i = dVar2.u(constraintAnchor2);
            dVar2.f(constraintWidget.Q.f3207i, i10);
            dVar2.f(constraintWidget.S.f3207i, iM0);
            constraintWidget.f3273t = 2;
            constraintWidget.C1(i10, iM0);
        }
        if (dVar.f3238b0[1] == dimensionBehaviour2 || constraintWidget.f3238b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i11 = constraintWidget.R.f3205g;
        int iD = dVar.D() - constraintWidget.T.f3205g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.R;
        constraintAnchor3.f3207i = dVar2.u(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.T;
        constraintAnchor4.f3207i = dVar2.u(constraintAnchor4);
        dVar2.f(constraintWidget.R.f3207i, i11);
        dVar2.f(constraintWidget.T.f3207i, iD);
        if (constraintWidget.f3262n0 > 0 || constraintWidget.l0() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.U;
            constraintAnchor5.f3207i = dVar2.u(constraintAnchor5);
            dVar2.f(constraintWidget.U.f3207i, constraintWidget.f3262n0 + i11);
        }
        constraintWidget.f3275u = 2;
        constraintWidget.X1(i11, iD);
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
