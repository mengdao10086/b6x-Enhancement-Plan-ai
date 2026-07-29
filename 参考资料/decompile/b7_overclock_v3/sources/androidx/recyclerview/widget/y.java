package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.u0;
import g.n0;
import g.p0;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class y extends androidx.core.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f7240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f7241e;

    public static class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final y f7242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<View, androidx.core.view.a> f7243e = new WeakHashMap();

        public a(@n0 y yVar) {
            this.f7242d = yVar;
        }

        @Override // androidx.core.view.a
        public boolean a(@n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        @p0
        public a1.e b(@n0 View view) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // androidx.core.view.a
        public void f(@n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            if (this.f7242d.o() || this.f7242d.f7240d.getLayoutManager() == null) {
                super.g(view, dVar);
                return;
            }
            this.f7242d.f7240d.getLayoutManager().h1(view, dVar);
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                aVar.g(view, dVar);
            } else {
                super.g(view, dVar);
            }
        }

        @Override // androidx.core.view.a
        public void h(@n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public boolean i(@n0 ViewGroup viewGroup, @n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f7243e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (this.f7242d.o() || this.f7242d.f7240d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f7242d.f7240d.getLayoutManager().B1(view, i10, bundle);
        }

        @Override // androidx.core.view.a
        public void l(@n0 View view, int i10) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        @Override // androidx.core.view.a
        public void m(@n0 View view, @n0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f7243e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        public androidx.core.view.a n(View view) {
            return this.f7243e.remove(view);
        }

        public void o(View view) {
            androidx.core.view.a aVarE = u0.E(view);
            if (aVarE == null || aVarE == this) {
                return;
            }
            this.f7243e.put(view, aVarE);
        }
    }

    public y(@n0 RecyclerView recyclerView) {
        this.f7240d = recyclerView;
        androidx.core.view.a aVarN = n();
        if (aVarN == null || !(aVarN instanceof a)) {
            this.f7241e = new a(this);
        } else {
            this.f7241e = (a) aVarN;
        }
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().d1(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.a
    public void g(View view, a1.d dVar) {
        super.g(view, dVar);
        if (o() || this.f7240d.getLayoutManager() == null) {
            return;
        }
        this.f7240d.getLayoutManager().f1(dVar);
    }

    @Override // androidx.core.view.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f7240d.getLayoutManager() == null) {
            return false;
        }
        return this.f7240d.getLayoutManager().z1(i10, bundle);
    }

    @n0
    public androidx.core.view.a n() {
        return this.f7241e;
    }

    public boolean o() {
        return this.f7240d.D0();
    }
}
