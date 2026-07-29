package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.t;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4018a = "TransitionBuilder";

    public static t.b a(t scene, int transitionId, int startConstraintSetId, androidx.constraintlayout.widget.d startConstraintSet, int endConstraintSetId, androidx.constraintlayout.widget.d endConstraintSet) {
        t.b bVar = new t.b(transitionId, scene, startConstraintSetId, endConstraintSetId);
        b(scene, bVar, startConstraintSet, endConstraintSet);
        return bVar;
    }

    public static void b(t scene, t.b transition, androidx.constraintlayout.widget.d startConstraintSet, androidx.constraintlayout.widget.d endConstraintSet) {
        int I = transition.I();
        int iB = transition.B();
        scene.j0(I, startConstraintSet);
        scene.j0(iB, endConstraintSet);
    }

    public static void c(MotionLayout layout) {
        t tVar = layout.C1;
        if (tVar == null) {
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
        if (!tVar.s0(layout)) {
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        if (tVar.f3908c == null || tVar.s().isEmpty()) {
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
