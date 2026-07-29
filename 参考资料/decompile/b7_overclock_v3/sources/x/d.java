package x;

import androidx.constraintlayout.core.state.State;

/* JADX INFO: loaded from: classes2.dex */
public class d extends androidx.constraintlayout.core.state.a {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f54827n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public State.Chain f54828o0;

    public d(State state, State.Helper helper) {
        super(state, helper);
        this.f54827n0 = 0.5f;
        this.f54828o0 = State.Chain.SPREAD;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public d m(float f10) {
        this.f54827n0 = f10;
        return this;
    }

    public float Q0() {
        return this.f54827n0;
    }

    public State.Chain R0() {
        return State.Chain.SPREAD;
    }

    public d S0(State.Chain chain) {
        this.f54828o0 = chain;
        return this;
    }
}
