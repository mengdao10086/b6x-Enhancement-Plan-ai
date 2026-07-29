package x;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class h extends d {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54837a;

        static {
            int[] iArr = new int[State.Chain.values().length];
            f54837a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54837a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54837a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public void apply() {
        Iterator<Object> it2 = this.f3129l0.iterator();
        while (it2.hasNext()) {
            this.f3127j0.e(it2.next()).v();
        }
        Iterator<Object> it3 = this.f3129l0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it3.hasNext()) {
            ConstraintReference constraintReferenceE = this.f3127j0.e(it3.next());
            if (constraintReference2 == null) {
                Object obj = this.S;
                if (obj != null) {
                    constraintReferenceE.D0(obj).b0(this.f3089o).d0(this.f3095u);
                } else {
                    Object obj2 = this.T;
                    if (obj2 != null) {
                        constraintReferenceE.C0(obj2).b0(this.f3089o).d0(this.f3095u);
                    } else {
                        constraintReferenceE.D0(State.f3120j);
                    }
                }
                constraintReference2 = constraintReferenceE;
            }
            if (constraintReference != null) {
                constraintReference.p(constraintReferenceE.getKey());
                constraintReferenceE.C0(constraintReference.getKey());
            }
            constraintReference = constraintReferenceE;
        }
        if (constraintReference != null) {
            Object obj3 = this.U;
            if (obj3 != null) {
                constraintReference.p(obj3).b0(this.f3090p).d0(this.f3096v);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    constraintReference.o(obj4).b0(this.f3090p).d0(this.f3096v);
                } else {
                    constraintReference.o(State.f3120j);
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f10 = this.f54827n0;
        if (f10 != 0.5f) {
            constraintReference2.I0(f10);
        }
        int i10 = a.f54837a[this.f54828o0.ordinal()];
        if (i10 == 1) {
            constraintReference2.u0(0);
        } else if (i10 == 2) {
            constraintReference2.u0(1);
        } else {
            if (i10 != 3) {
                return;
            }
            constraintReference2.u0(2);
        }
    }
}
