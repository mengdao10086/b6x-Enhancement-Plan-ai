package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ConstraintReference implements x.e {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final State f3127j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final State.Helper f3128k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ArrayList<Object> f3129l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public y.b f3130m0;

    public a(State state, State.Helper helper) {
        super(state);
        this.f3129l0 = new ArrayList<>();
        this.f3127j0 = state;
        this.f3128k0 = helper;
    }

    public a L0(Object... objArr) {
        Collections.addAll(this.f3129l0, objArr);
        return this;
    }

    public y.b M0() {
        return this.f3130m0;
    }

    public State.Helper N0() {
        return this.f3128k0;
    }

    public void O0(y.b bVar) {
        this.f3130m0 = bVar;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public ConstraintWidget a() {
        return M0();
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.c
    public void apply() {
    }
}
