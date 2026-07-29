package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.a0;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f3623a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashSet<View> f3625c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<a0.b> f3627e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<a0> f3624b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3626d = "ViewTransitionController";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<a0.b> f3628f = new ArrayList<>();

    public class a implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f3629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f3631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3632d;

        public a(final a0 val$viewTransition, final int val$listen_for_id, final boolean val$isSet, final int val$listen_for_value) {
            this.f3629a = val$viewTransition;
            this.f3630b = val$listen_for_id;
            this.f3631c = val$isSet;
            this.f3632d = val$listen_for_value;
        }

        @Override // androidx.constraintlayout.widget.i.a
        public void a(int id2, int value, int oldValue) {
            int iH = this.f3629a.h();
            this.f3629a.r(value);
            if (this.f3630b != id2 || iH == value) {
                return;
            }
            if (this.f3631c) {
                if (this.f3632d == value) {
                    int childCount = b0.this.f3623a.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = b0.this.f3623a.getChildAt(i10);
                        if (this.f3629a.m(childAt)) {
                            int currentState = b0.this.f3623a.getCurrentState();
                            androidx.constraintlayout.widget.d dVarH0 = b0.this.f3623a.H0(currentState);
                            a0 a0Var = this.f3629a;
                            b0 b0Var = b0.this;
                            a0Var.c(b0Var, b0Var.f3623a, currentState, dVarH0, childAt);
                        }
                    }
                    return;
                }
                return;
            }
            if (this.f3632d != value) {
                int childCount2 = b0.this.f3623a.getChildCount();
                for (int i11 = 0; i11 < childCount2; i11++) {
                    View childAt2 = b0.this.f3623a.getChildAt(i11);
                    if (this.f3629a.m(childAt2)) {
                        int currentState2 = b0.this.f3623a.getCurrentState();
                        androidx.constraintlayout.widget.d dVarH02 = b0.this.f3623a.H0(currentState2);
                        a0 a0Var2 = this.f3629a;
                        b0 b0Var2 = b0.this;
                        a0Var2.c(b0Var2, b0Var2.f3623a, currentState2, dVarH02, childAt2);
                    }
                }
            }
        }
    }

    public b0(MotionLayout layout) {
        this.f3623a = layout;
    }

    public void b(a0 viewTransition) {
        this.f3624b.add(viewTransition);
        this.f3625c = null;
        if (viewTransition.j() == 4) {
            i(viewTransition, true);
        } else if (viewTransition.j() == 5) {
            i(viewTransition, false);
        }
    }

    public void c(a0.b animation) {
        if (this.f3627e == null) {
            this.f3627e = new ArrayList<>();
        }
        this.f3627e.add(animation);
    }

    public void d() {
        ArrayList<a0.b> arrayList = this.f3627e;
        if (arrayList == null) {
            return;
        }
        Iterator<a0.b> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        this.f3627e.removeAll(this.f3628f);
        this.f3628f.clear();
        if (this.f3627e.isEmpty()) {
            this.f3627e = null;
        }
    }

    public boolean e(int viewTransitionId, o motionController) {
        for (a0 a0Var : this.f3624b) {
            if (a0Var.e() == viewTransitionId) {
                a0Var.f3590g.a(motionController);
                return true;
            }
        }
        return false;
    }

    public void f(int id2, boolean enable) {
        for (a0 a0Var : this.f3624b) {
            if (a0Var.e() == id2) {
                a0Var.o(enable);
                return;
            }
        }
    }

    public void g() {
        this.f3623a.invalidate();
    }

    public boolean h(int id2) {
        for (a0 a0Var : this.f3624b) {
            if (a0Var.e() == id2) {
                return a0Var.k();
            }
        }
        return false;
    }

    public final void i(a0 viewTransition, boolean isSet) {
        ConstraintLayout.getSharedValues().a(viewTransition.i(), new a(viewTransition, viewTransition.i(), isSet, viewTransition.g()));
    }

    public void j(int id2) {
        a0 next;
        Iterator<a0> it2 = this.f3624b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (next.e() == id2) {
                    break;
                }
            }
        }
        if (next != null) {
            this.f3625c = null;
            this.f3624b.remove(next);
        }
    }

    public void k(a0.b animation) {
        this.f3628f.add(animation);
    }

    public void l(MotionEvent event) {
        a0 a0Var;
        int currentState = this.f3623a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f3625c == null) {
            this.f3625c = new HashSet<>();
            for (a0 a0Var2 : this.f3624b) {
                int childCount = this.f3623a.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.f3623a.getChildAt(i10);
                    if (a0Var2.m(childAt)) {
                        childAt.getId();
                        this.f3625c.add(childAt);
                    }
                }
            }
        }
        float x10 = event.getX();
        float y10 = event.getY();
        Rect rect = new Rect();
        int action = event.getAction();
        ArrayList<a0.b> arrayList = this.f3627e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<a0.b> it2 = this.f3627e.iterator();
            while (it2.hasNext()) {
                it2.next().d(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.d dVarH0 = this.f3623a.H0(currentState);
            Iterator<a0> it3 = this.f3624b.iterator();
            while (it3.hasNext()) {
                a0 next = it3.next();
                if (next.u(action)) {
                    for (View view : this.f3625c) {
                        if (next.m(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                a0Var = next;
                                next.c(this, this.f3623a, currentState, dVarH0, view);
                            } else {
                                a0Var = next;
                            }
                            next = a0Var;
                        }
                    }
                }
            }
        }
    }

    public void m(int id2, View... views) {
        ArrayList arrayList = new ArrayList();
        for (a0 a0Var : this.f3624b) {
            if (a0Var.e() == id2) {
                for (View view : views) {
                    if (a0Var.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    n(a0Var, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
            }
        }
    }

    public final void n(a0 vt2, View... view) {
        int currentState = this.f3623a.getCurrentState();
        if (vt2.f3589f == 2) {
            vt2.c(this, this.f3623a, currentState, null, view);
            return;
        }
        if (currentState == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No support for ViewTransition within transition yet. Currently: ");
            sb2.append(this.f3623a.toString());
        } else {
            androidx.constraintlayout.widget.d dVarH0 = this.f3623a.H0(currentState);
            if (dVarH0 == null) {
                return;
            }
            vt2.c(this, this.f3623a, currentState, dVarH0, view);
        }
    }
}
