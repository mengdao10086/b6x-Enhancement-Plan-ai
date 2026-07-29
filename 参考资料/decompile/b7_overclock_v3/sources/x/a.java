package x;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a extends androidx.constraintlayout.core.state.a {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f54821n0;

    public a(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.f54821n0 = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public void apply() {
        Iterator<Object> it2 = this.f3129l0.iterator();
        while (it2.hasNext()) {
            ConstraintReference constraintReferenceE = this.f3127j0.e(it2.next());
            constraintReferenceE.u();
            Object obj = this.O;
            if (obj != null) {
                constraintReferenceE.A0(obj);
            } else {
                Object obj2 = this.P;
                if (obj2 != null) {
                    constraintReferenceE.z0(obj2);
                } else {
                    constraintReferenceE.A0(State.f3120j);
                }
            }
            Object obj3 = this.Q;
            if (obj3 != null) {
                constraintReferenceE.A(obj3);
            } else {
                Object obj4 = this.R;
                if (obj4 != null) {
                    constraintReferenceE.z(obj4);
                } else {
                    constraintReferenceE.z(State.f3120j);
                }
            }
            float f10 = this.f54821n0;
            if (f10 != 0.5f) {
                constraintReferenceE.X(f10);
            }
        }
    }
}
