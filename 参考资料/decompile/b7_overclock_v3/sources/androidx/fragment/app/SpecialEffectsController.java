package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.f;
import androidx.core.view.u0;
import androidx.fragment.R;
import g.p0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f5824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Operation> f5825b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Operation> f5826c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5827d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5828e = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f5837a;

        public a(d dVar) {
            this.f5837a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialEffectsController.this.f5825b.contains(this.f5837a)) {
                this.f5837a.e().applyState(this.f5837a.f().C1);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f5839a;

        public b(d dVar) {
            this.f5839a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialEffectsController.this.f5825b.remove(this.f5839a);
            SpecialEffectsController.this.f5826c.remove(this.f5839a);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f5842b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f5842b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5842b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5842b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f5841a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5841a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5841a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5841a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class d extends Operation {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @g.n0
        public final d0 f5843h;

        public d(@g.n0 Operation.State state, @g.n0 Operation.LifecycleImpact lifecycleImpact, @g.n0 d0 d0Var, @g.n0 androidx.core.os.f fVar) {
            super(state, lifecycleImpact, d0Var.k(), fVar);
            this.f5843h = d0Var;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.f5843h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void l() {
            if (g() != Operation.LifecycleImpact.ADDING) {
                if (g() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.f5843h.k();
                    View viewV4 = fragmentK.V4();
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Clearing focus ");
                        sb2.append(viewV4.findFocus());
                        sb2.append(" on view ");
                        sb2.append(viewV4);
                        sb2.append(" for Fragment ");
                        sb2.append(fragmentK);
                    }
                    viewV4.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f5843h.k();
            View viewFindFocus = fragmentK2.C1.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.h5(viewFindFocus);
                if (FragmentManager.W0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("requestFocus: Saved focused view ");
                    sb3.append(viewFindFocus);
                    sb3.append(" for Fragment ");
                    sb3.append(fragmentK2);
                }
            }
            View viewV42 = f().V4();
            if (viewV42.getParent() == null) {
                this.f5843h.b();
                viewV42.setAlpha(0.0f);
            }
            if (viewV42.getAlpha() == 0.0f && viewV42.getVisibility() == 0) {
                viewV42.setVisibility(4);
            }
            viewV42.setAlpha(fragmentK2.T2());
        }
    }

    public SpecialEffectsController(@g.n0 ViewGroup viewGroup) {
        this.f5824a = viewGroup;
    }

    @g.n0
    public static SpecialEffectsController n(@g.n0 ViewGroup viewGroup, @g.n0 FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.O0());
    }

    @g.n0
    public static SpecialEffectsController o(@g.n0 ViewGroup viewGroup, @g.n0 n0 n0Var) {
        int i10 = R.id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController specialEffectsControllerA = n0Var.a(viewGroup);
        viewGroup.setTag(i10, specialEffectsControllerA);
        return specialEffectsControllerA;
    }

    public final void a(@g.n0 Operation.State state, @g.n0 Operation.LifecycleImpact lifecycleImpact, @g.n0 d0 d0Var) {
        synchronized (this.f5825b) {
            androidx.core.os.f fVar = new androidx.core.os.f();
            Operation operationH = h(d0Var.k());
            if (operationH != null) {
                operationH.k(state, lifecycleImpact);
                return;
            }
            d dVar = new d(state, lifecycleImpact, d0Var, fVar);
            this.f5825b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    public void b(@g.n0 Operation.State state, @g.n0 d0 d0Var) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, d0Var);
    }

    public void c(@g.n0 d0 d0Var) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, d0Var);
    }

    public void d(@g.n0 d0 d0Var) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, d0Var);
    }

    public void e(@g.n0 d0 d0Var) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, d0Var);
    }

    public abstract void f(@g.n0 List<Operation> list, boolean z10);

    public void g() {
        if (this.f5828e) {
            return;
        }
        if (!u0.O0(this.f5824a)) {
            j();
            this.f5827d = false;
            return;
        }
        synchronized (this.f5825b) {
            if (!this.f5825b.isEmpty()) {
                ArrayList<Operation> arrayList = new ArrayList(this.f5826c);
                this.f5826c.clear();
                for (Operation operation : arrayList) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Cancelling operation ");
                        sb2.append(operation);
                    }
                    operation.b();
                    if (!operation.i()) {
                        this.f5826c.add(operation);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f5825b);
                this.f5825b.clear();
                this.f5826c.addAll(arrayList2);
                FragmentManager.W0(2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Operation) it2.next()).l();
                }
                f(arrayList2, this.f5827d);
                this.f5827d = false;
                FragmentManager.W0(2);
            }
        }
    }

    @p0
    public final Operation h(@g.n0 Fragment fragment) {
        for (Operation operation : this.f5825b) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    @p0
    public final Operation i(@g.n0 Fragment fragment) {
        for (Operation operation : this.f5826c) {
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public void j() {
        FragmentManager.W0(2);
        boolean zO0 = u0.O0(this.f5824a);
        synchronized (this.f5825b) {
            q();
            Iterator<Operation> it2 = this.f5825b.iterator();
            while (it2.hasNext()) {
                it2.next().l();
            }
            for (Operation operation : new ArrayList(this.f5826c)) {
                if (FragmentManager.W0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(zO0 ? "" : "Container " + this.f5824a + " is not attached to window. ");
                    sb2.append("Cancelling running operation ");
                    sb2.append(operation);
                }
                operation.b();
            }
            for (Operation operation2 : new ArrayList(this.f5825b)) {
                if (FragmentManager.W0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    sb3.append(zO0 ? "" : "Container " + this.f5824a + " is not attached to window. ");
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                }
                operation2.b();
            }
        }
    }

    public void k() {
        if (this.f5828e) {
            FragmentManager.W0(2);
            this.f5828e = false;
            g();
        }
    }

    @p0
    public Operation.LifecycleImpact l(@g.n0 d0 d0Var) {
        Operation operationH = h(d0Var.k());
        Operation.LifecycleImpact lifecycleImpactG = operationH != null ? operationH.g() : null;
        Operation operationI = i(d0Var.k());
        return (operationI == null || !(lifecycleImpactG == null || lifecycleImpactG == Operation.LifecycleImpact.NONE)) ? lifecycleImpactG : operationI.g();
    }

    @g.n0
    public ViewGroup m() {
        return this.f5824a;
    }

    public void p() {
        synchronized (this.f5825b) {
            q();
            this.f5828e = false;
            int size = this.f5825b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f5825b.get(size);
                Operation.State stateFrom = Operation.State.from(operation.f().C1);
                Operation.State stateE = operation.e();
                Operation.State state = Operation.State.VISIBLE;
                if (stateE == state && stateFrom != state) {
                    this.f5828e = operation.f().y3();
                    break;
                }
                size--;
            }
        }
    }

    public final void q() {
        for (Operation operation : this.f5825b) {
            if (operation.g() == Operation.LifecycleImpact.ADDING) {
                operation.k(Operation.State.from(operation.f().V4().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void r(boolean z10) {
        this.f5827d = z10;
    }

    public static class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public State f5829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.n0
        public LifecycleImpact f5830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.n0
        public final Fragment f5831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.n0
        public final List<Runnable> f5832d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.n0
        public final HashSet<androidx.core.os.f> f5833e = new HashSet<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5834f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5835g = false;

        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        public class a implements f.b {
            public a() {
            }

            @Override // androidx.core.os.f.b
            public void onCancel() {
                Operation.this.b();
            }
        }

        public Operation(@g.n0 State state, @g.n0 LifecycleImpact lifecycleImpact, @g.n0 Fragment fragment, @g.n0 androidx.core.os.f fVar) {
            this.f5829a = state;
            this.f5830b = lifecycleImpact;
            this.f5831c = fragment;
            fVar.d(new a());
        }

        public final void a(@g.n0 Runnable runnable) {
            this.f5832d.add(runnable);
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f5834f = true;
            if (this.f5833e.isEmpty()) {
                c();
                return;
            }
            Iterator it2 = new ArrayList(this.f5833e).iterator();
            while (it2.hasNext()) {
                ((androidx.core.os.f) it2.next()).a();
            }
        }

        @g.i
        public void c() {
            if (this.f5835g) {
                return;
            }
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SpecialEffectsController: ");
                sb2.append(this);
                sb2.append(" has called complete.");
            }
            this.f5835g = true;
            Iterator<Runnable> it2 = this.f5832d.iterator();
            while (it2.hasNext()) {
                it2.next().run();
            }
        }

        public final void d(@g.n0 androidx.core.os.f fVar) {
            if (this.f5833e.remove(fVar) && this.f5833e.isEmpty()) {
                c();
            }
        }

        @g.n0
        public State e() {
            return this.f5829a;
        }

        @g.n0
        public final Fragment f() {
            return this.f5831c;
        }

        @g.n0
        public LifecycleImpact g() {
            return this.f5830b;
        }

        public final boolean h() {
            return this.f5834f;
        }

        public final boolean i() {
            return this.f5835g;
        }

        public final void j(@g.n0 androidx.core.os.f fVar) {
            l();
            this.f5833e.add(fVar);
        }

        public final void k(@g.n0 State state, @g.n0 LifecycleImpact lifecycleImpact) {
            int i10 = c.f5842b[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.f5829a == State.REMOVED) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: For fragment ");
                        sb2.append(this.f5831c);
                        sb2.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        sb2.append(this.f5830b);
                        sb2.append(" to ADDING.");
                    }
                    this.f5829a = State.VISIBLE;
                    this.f5830b = LifecycleImpact.ADDING;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.W0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.f5831c);
                    sb3.append(" mFinalState = ");
                    sb3.append(this.f5829a);
                    sb3.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb3.append(this.f5830b);
                    sb3.append(" to REMOVING.");
                }
                this.f5829a = State.REMOVED;
                this.f5830b = LifecycleImpact.REMOVING;
                return;
            }
            if (i10 == 3 && this.f5829a != State.REMOVED) {
                if (FragmentManager.W0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: For fragment ");
                    sb4.append(this.f5831c);
                    sb4.append(" mFinalState = ");
                    sb4.append(this.f5829a);
                    sb4.append(" -> ");
                    sb4.append(state);
                    sb4.append(". ");
                }
                this.f5829a = state;
            }
        }

        public void l() {
        }

        @g.n0
        public String toString() {
            return "Operation " + zc.a.f58316d + Integer.toHexString(System.identityHashCode(this)) + "} " + zc.a.f58316d + "mFinalState = " + this.f5829a + "} " + zc.a.f58316d + "mLifecycleImpact = " + this.f5830b + "} " + zc.a.f58316d + "mFragment = " + this.f5831c + zc.a.f58317e;
        }

        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @g.n0
            public static State from(@g.n0 View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            public void applyState(@g.n0 View view) {
                int i10 = c.f5841a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.W0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Removing view ");
                            sb2.append(view);
                            sb2.append(" from container ");
                            sb2.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (FragmentManager.W0(2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("SpecialEffectsController: Setting view ");
                    sb5.append(view);
                    sb5.append(" to INVISIBLE");
                }
                view.setVisibility(4);
            }

            @g.n0
            public static State from(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }
        }
    }
}
