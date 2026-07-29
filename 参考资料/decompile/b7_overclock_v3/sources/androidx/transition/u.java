package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7994c = "TransitionManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q f7995d = new g2.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<q>>>> f7996e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ArrayList<ViewGroup> f7997f = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.collection.a<n, q> f7998a = new androidx.collection.a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.collection.a<n, androidx.collection.a<n, q>> f7999b = new androidx.collection.a<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f8000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f8001b;

        /* JADX INFO: renamed from: androidx.transition.u$a$a, reason: collision with other inner class name */
        public class C0075a extends t {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.collection.a f8002a;

            public C0075a(androidx.collection.a aVar) {
                this.f8002a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.t, androidx.transition.q.h
            public void c(@n0 q qVar) {
                ((ArrayList) this.f8002a.get(a.this.f8001b)).remove(qVar);
                qVar.p0(this);
            }
        }

        public a(q qVar, ViewGroup viewGroup) {
            this.f8000a = qVar;
            this.f8001b = viewGroup;
        }

        public final void a() {
            this.f8001b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f8001b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!u.f7997f.remove(this.f8001b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<q>> aVarE = u.e();
            ArrayList<q> arrayList = aVarE.get(this.f8001b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarE.put(this.f8001b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f8000a);
            this.f8000a.a(new C0075a(aVarE));
            this.f8000a.n(this.f8001b, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((q) it2.next()).u0(this.f8001b);
                }
            }
            this.f8000a.o0(this.f8001b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            u.f7997f.remove(this.f8001b);
            ArrayList<q> arrayList = u.e().get(this.f8001b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<q> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().u0(this.f8001b);
                }
            }
            this.f8000a.o(true);
        }
    }

    public static void a(@n0 ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(@n0 ViewGroup viewGroup, @p0 q qVar) {
        if (f7997f.contains(viewGroup) || !u0.U0(viewGroup)) {
            return;
        }
        f7997f.add(viewGroup);
        if (qVar == null) {
            qVar = f7995d;
        }
        q qVarClone = qVar.clone();
        j(viewGroup, qVarClone);
        n.g(viewGroup, null);
        i(viewGroup, qVarClone);
    }

    public static void c(n nVar, q qVar) {
        ViewGroup viewGroupE = nVar.e();
        if (f7997f.contains(viewGroupE)) {
            return;
        }
        n nVarC = n.c(viewGroupE);
        if (qVar == null) {
            if (nVarC != null) {
                nVarC.b();
            }
            nVar.a();
            return;
        }
        f7997f.add(viewGroupE);
        q qVarClone = qVar.clone();
        if (nVarC != null && nVarC.f()) {
            qVarClone.x0(true);
        }
        j(viewGroupE, qVarClone);
        nVar.a();
        i(viewGroupE, qVarClone);
    }

    public static void d(ViewGroup viewGroup) {
        f7997f.remove(viewGroup);
        ArrayList<q> arrayList = e().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ((q) arrayList2.get(size)).F(viewGroup);
        }
    }

    public static androidx.collection.a<ViewGroup, ArrayList<q>> e() {
        androidx.collection.a<ViewGroup, ArrayList<q>> aVar;
        WeakReference<androidx.collection.a<ViewGroup, ArrayList<q>>> weakReference = f7996e.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<q>> aVar2 = new androidx.collection.a<>();
        f7996e.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void g(@n0 n nVar) {
        c(nVar, f7995d);
    }

    public static void h(@n0 n nVar, @p0 q qVar) {
        c(nVar, qVar);
    }

    public static void i(ViewGroup viewGroup, q qVar) {
        if (qVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(qVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void j(ViewGroup viewGroup, q qVar) {
        ArrayList<q> arrayList = e().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().n0(viewGroup);
            }
        }
        if (qVar != null) {
            qVar.n(viewGroup, true);
        }
        n nVarC = n.c(viewGroup);
        if (nVarC != null) {
            nVarC.b();
        }
    }

    public final q f(n nVar) {
        n nVarC;
        androidx.collection.a<n, q> aVar;
        q qVar;
        ViewGroup viewGroupE = nVar.e();
        if (viewGroupE != null && (nVarC = n.c(viewGroupE)) != null && (aVar = this.f7999b.get(nVar)) != null && (qVar = aVar.get(nVarC)) != null) {
            return qVar;
        }
        q qVar2 = this.f7998a.get(nVar);
        return qVar2 != null ? qVar2 : f7995d;
    }

    public void k(@n0 n nVar, @n0 n nVar2, @p0 q qVar) {
        androidx.collection.a<n, q> aVar = this.f7999b.get(nVar2);
        if (aVar == null) {
            aVar = new androidx.collection.a<>();
            this.f7999b.put(nVar2, aVar);
        }
        aVar.put(nVar, qVar);
    }

    public void l(@n0 n nVar, @p0 q qVar) {
        this.f7998a.put(nVar, qVar);
    }

    public void m(@n0 n nVar) {
        c(nVar, f(nVar));
    }
}
