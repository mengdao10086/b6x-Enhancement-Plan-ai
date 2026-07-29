package x;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class g extends d {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54836a;

        static {
            int[] iArr = new int[State.Chain.values().length];
            f54836a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54836a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54836a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.a, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public void apply() {
        Iterator<Object> it2 = this.f3129l0.iterator();
        while (it2.hasNext()) {
            this.f3127j0.e(it2.next()).u();
        }
        Iterator<Object> it3 = this.f3129l0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it3.hasNext()) {
            ConstraintReference constraintReferenceE = this.f3127j0.e(it3.next());
            if (constraintReference2 == null) {
                Object obj = this.O;
                if (obj != null) {
                    constraintReferenceE.A0(obj).b0(this.f3087m).d0(this.f3093s);
                } else {
                    Object obj2 = this.P;
                    if (obj2 != null) {
                        constraintReferenceE.z0(obj2).b0(this.f3087m).d0(this.f3093s);
                    } else {
                        Object obj3 = this.K;
                        if (obj3 != null) {
                            constraintReferenceE.A0(obj3).b0(this.f3085k).d0(this.f3091q);
                        } else {
                            Object obj4 = this.L;
                            if (obj4 != null) {
                                constraintReferenceE.z0(obj4).b0(this.f3085k).d0(this.f3091q);
                            } else {
                                constraintReferenceE.A0(State.f3120j);
                            }
                        }
                    }
                }
                constraintReference2 = constraintReferenceE;
            }
            if (constraintReference != null) {
                constraintReference.A(constraintReferenceE.getKey());
                constraintReferenceE.z0(constraintReference.getKey());
            }
            constraintReference = constraintReferenceE;
        }
        if (constraintReference != null) {
            Object obj5 = this.Q;
            if (obj5 != null) {
                constraintReference.A(obj5).b0(this.f3088n).d0(this.f3094t);
            } else {
                Object obj6 = this.R;
                if (obj6 != null) {
                    constraintReference.z(obj6).b0(this.f3088n).d0(this.f3094t);
                } else {
                    Object obj7 = this.M;
                    if (obj7 != null) {
                        constraintReference.A(obj7).b0(this.f3086l).d0(this.f3092r);
                    } else {
                        Object obj8 = this.N;
                        if (obj8 != null) {
                            constraintReference.z(obj8).b0(this.f3086l).d0(this.f3092r);
                        } else {
                            constraintReference.z(State.f3120j);
                        }
                    }
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f10 = this.f54827n0;
        if (f10 != 0.5f) {
            constraintReference2.X(f10);
        }
        int i10 = a.f54836a[this.f54828o0.ordinal()];
        if (i10 == 1) {
            constraintReference2.r0(0);
        } else if (i10 == 2) {
            constraintReference2.r0(1);
        } else {
            if (i10 != 3) {
                return;
            }
            constraintReference2.r0(2);
        }
    }
}
