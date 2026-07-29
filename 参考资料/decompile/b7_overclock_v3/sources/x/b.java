package x;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b extends androidx.constraintlayout.core.state.a {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f54822n0;

    public b(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.f54822n0 = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public void apply() {
        Iterator<Object> it2 = this.f3129l0.iterator();
        while (it2.hasNext()) {
            ConstraintReference constraintReferenceE = this.f3127j0.e(it2.next());
            constraintReferenceE.v();
            Object obj = this.S;
            if (obj != null) {
                constraintReferenceE.D0(obj);
            } else {
                Object obj2 = this.T;
                if (obj2 != null) {
                    constraintReferenceE.C0(obj2);
                } else {
                    constraintReferenceE.D0(State.f3120j);
                }
            }
            Object obj3 = this.U;
            if (obj3 != null) {
                constraintReferenceE.p(obj3);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    constraintReferenceE.o(obj4);
                } else {
                    constraintReferenceE.o(State.f3120j);
                }
            }
            float f10 = this.f54822n0;
            if (f10 != 0.5f) {
                constraintReferenceE.I0(f10);
            }
        }
    }
}
