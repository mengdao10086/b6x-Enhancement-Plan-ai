package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import g.v0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class j0 extends k0 {

    public class a extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f5983a;

        public a(Rect rect) {
            this.f5983a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f5983a;
        }
    }

    public class b implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5986b;

        public b(View view, ArrayList arrayList) {
            this.f5985a = view;
            this.f5986b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.b(transition, this);
            this.f5985a.setVisibility(8);
            int size = this.f5986b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f5986b.get(i10)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            f.b(transition, this);
            f.a(transition, this);
        }
    }

    public class c implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f5988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f5990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f5992e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5993f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f5988a = obj;
            this.f5989b = arrayList;
            this.f5990c = obj2;
            this.f5991d = arrayList2;
            this.f5992e = obj3;
            this.f5993f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.b(transition, this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f5988a;
            if (obj != null) {
                j0.this.n(obj, this.f5989b, null);
            }
            Object obj2 = this.f5990c;
            if (obj2 != null) {
                j0.this.n(obj2, this.f5991d, null);
            }
            Object obj3 = this.f5992e;
            if (obj3 != null) {
                j0.this.n(obj3, this.f5993f, null);
            }
        }
    }

    public class d implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f5995a;

        public d(Runnable runnable) {
            this.f5995a = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f5995a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    public class e extends Transition.EpicenterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f5997a;

        public e(Rect rect) {
            this.f5997a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f5997a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f5997a;
        }
    }

    @v0(19)
    public static class f {
        public static void a(@g.n0 Transition transition, @g.n0 Transition.TransitionListener transitionListener) {
            transition.addListener(transitionListener);
        }

        public static void b(@g.n0 Transition transition, @g.n0 Transition.TransitionListener transitionListener) {
            transition.removeListener(transitionListener);
        }
    }

    public static boolean x(Transition transition) {
        return (k0.i(transition.getTargetIds()) && k0.i(transition.getTargetNames()) && k0.i(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.k0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.k0
    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i10 < transitionCount) {
                b(transitionSet.getTransitionAt(i10), arrayList);
                i10++;
            }
            return;
        }
        if (x(transition) || !k0.i(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            transition.addTarget(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.k0
    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.k0
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.k0
    public Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.k0
    public Object j(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.k0
    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.k0
    public void m(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.k0
    public void n(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i10 < transitionCount) {
                n(transitionSet.getTransitionAt(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (x(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i10 < size) {
            transition.addTarget(arrayList2.get(i10));
            i10++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.k0
    public void o(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.k0
    public void p(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.k0
    public void q(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    @Override // androidx.fragment.app.k0
    public void r(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.k0
    public void s(@g.n0 Fragment fragment, @g.n0 Object obj, @g.n0 androidx.core.os.f fVar, @g.n0 Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    @Override // androidx.fragment.app.k0
    public void u(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k0.d(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.k0
    public void v(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            n(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.k0
    public Object w(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }
}
