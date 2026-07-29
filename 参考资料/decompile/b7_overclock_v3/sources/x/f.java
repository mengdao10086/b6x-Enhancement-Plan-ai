package x;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public class f implements e, androidx.constraintlayout.core.state.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f54829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.f f54831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54832d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f54833e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f54834f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f54835g;

    public f(State state) {
        this.f54829a = state;
    }

    @Override // x.e, androidx.constraintlayout.core.state.c
    public ConstraintWidget a() {
        if (this.f54831c == null) {
            this.f54831c = new androidx.constraintlayout.core.widgets.f();
        }
        return this.f54831c;
    }

    @Override // x.e, androidx.constraintlayout.core.state.c
    public void apply() {
        this.f54831c.B2(this.f54830b);
        int i10 = this.f54832d;
        if (i10 != -1) {
            this.f54831c.w2(i10);
            return;
        }
        int i11 = this.f54833e;
        if (i11 != -1) {
            this.f54831c.x2(i11);
        } else {
            this.f54831c.y2(this.f54834f);
        }
    }

    @Override // androidx.constraintlayout.core.state.c
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            this.f54831c = (androidx.constraintlayout.core.widgets.f) constraintWidget;
        } else {
            this.f54831c = null;
        }
    }

    @Override // androidx.constraintlayout.core.state.c
    public void c(Object obj) {
        this.f54835g = obj;
    }

    @Override // androidx.constraintlayout.core.state.c
    public e d() {
        return null;
    }

    public f e(Object obj) {
        this.f54832d = -1;
        this.f54833e = this.f54829a.f(obj);
        this.f54834f = 0.0f;
        return this;
    }

    public int f() {
        return this.f54830b;
    }

    public f g(float f10) {
        this.f54832d = -1;
        this.f54833e = -1;
        this.f54834f = f10;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.c
    public Object getKey() {
        return this.f54835g;
    }

    public void h(int i10) {
        this.f54830b = i10;
    }

    public f i(Object obj) {
        this.f54832d = this.f54829a.f(obj);
        this.f54833e = -1;
        this.f54834f = 0.0f;
        return this;
    }
}
