package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<a0> f5133b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<a0, a> f5134c = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f5135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.v f5136b;

        public a(@g.n0 Lifecycle lifecycle, @g.n0 androidx.lifecycle.v vVar) {
            this.f5135a = lifecycle;
            this.f5136b = vVar;
            lifecycle.a(vVar);
        }

        public void a() {
            this.f5135a.d(this.f5136b);
            this.f5136b = null;
        }
    }

    public w(@g.n0 Runnable runnable) {
        this.f5132a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a0 a0Var, androidx.lifecycle.y yVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(a0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, a0 a0Var, androidx.lifecycle.y yVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(a0Var);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(a0Var);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.f5133b.remove(a0Var);
            this.f5132a.run();
        }
    }

    public void c(@g.n0 a0 a0Var) {
        this.f5133b.add(a0Var);
        this.f5132a.run();
    }

    public void d(@g.n0 final a0 a0Var, @g.n0 androidx.lifecycle.y yVar) {
        c(a0Var);
        Lifecycle lifecycleE = yVar.e();
        a aVarRemove = this.f5134c.remove(a0Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f5134c.put(a0Var, new a(lifecycleE, new androidx.lifecycle.v() { // from class: androidx.core.view.u
            @Override // androidx.lifecycle.v
            public final void c(androidx.lifecycle.y yVar2, Lifecycle.Event event) {
                this.f5087a.f(a0Var, yVar2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@g.n0 final a0 a0Var, @g.n0 androidx.lifecycle.y yVar, @g.n0 final Lifecycle.State state) {
        Lifecycle lifecycleE = yVar.e();
        a aVarRemove = this.f5134c.remove(a0Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f5134c.put(a0Var, new a(lifecycleE, new androidx.lifecycle.v() { // from class: androidx.core.view.v
            @Override // androidx.lifecycle.v
            public final void c(androidx.lifecycle.y yVar2, Lifecycle.Event event) {
                this.f5128a.g(state, a0Var, yVar2, event);
            }
        }));
    }

    public void h(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
        Iterator<a0> it2 = this.f5133b.iterator();
        while (it2.hasNext()) {
            it2.next().c(menu, menuInflater);
        }
    }

    public void i(@g.n0 Menu menu) {
        Iterator<a0> it2 = this.f5133b.iterator();
        while (it2.hasNext()) {
            it2.next().b(menu);
        }
    }

    public boolean j(@g.n0 MenuItem menuItem) {
        Iterator<a0> it2 = this.f5133b.iterator();
        while (it2.hasNext()) {
            if (it2.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@g.n0 Menu menu) {
        Iterator<a0> it2 = this.f5133b.iterator();
        while (it2.hasNext()) {
            it2.next().d(menu);
        }
    }

    public void l(@g.n0 a0 a0Var) {
        this.f5133b.remove(a0Var);
        a aVarRemove = this.f5134c.remove(a0Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f5132a.run();
    }
}
