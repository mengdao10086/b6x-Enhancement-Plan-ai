package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends a0 {
    public static TimeInterpolator A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f6962z = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6963o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6964p = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<j> f6965q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList<i> f6966r = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<ArrayList<RecyclerView.e0>> f6967s = new ArrayList<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<ArrayList<j>> f6968t = new ArrayList<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<ArrayList<i>> f6969u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6970v = new ArrayList<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6971w = new ArrayList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6972x = new ArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<RecyclerView.e0> f6973y = new ArrayList<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6974a;

        public a(ArrayList arrayList) {
            this.f6974a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f6974a) {
                h.this.b0(jVar.f7008a, jVar.f7009b, jVar.f7010c, jVar.f7011d, jVar.f7012e);
            }
            this.f6974a.clear();
            h.this.f6968t.remove(this.f6974a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6976a;

        public b(ArrayList arrayList) {
            this.f6976a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = this.f6976a.iterator();
            while (it2.hasNext()) {
                h.this.a0((i) it2.next());
            }
            this.f6976a.clear();
            h.this.f6969u.remove(this.f6976a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6978a;

        public c(ArrayList arrayList) {
            this.f6978a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = this.f6978a.iterator();
            while (it2.hasNext()) {
                h.this.Z((RecyclerView.e0) it2.next());
            }
            this.f6978a.clear();
            h.this.f6967s.remove(this.f6978a);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.e0 f6980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f6981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f6982c;

        public d(RecyclerView.e0 e0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6980a = e0Var;
            this.f6981b = viewPropertyAnimator;
            this.f6982c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6981b.setListener(null);
            this.f6982c.setAlpha(1.0f);
            h.this.N(this.f6980a);
            h.this.f6972x.remove(this.f6980a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.O(this.f6980a);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.e0 f6984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f6985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f6986c;

        public e(RecyclerView.e0 e0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6984a = e0Var;
            this.f6985b = view;
            this.f6986c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6985b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6986c.setListener(null);
            h.this.H(this.f6984a);
            h.this.f6970v.remove(this.f6984a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.I(this.f6984a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.e0 f6988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f6990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f6992e;

        public f(RecyclerView.e0 e0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f6988a = e0Var;
            this.f6989b = i10;
            this.f6990c = view;
            this.f6991d = i11;
            this.f6992e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f6989b != 0) {
                this.f6990c.setTranslationX(0.0f);
            }
            if (this.f6991d != 0) {
                this.f6990c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6992e.setListener(null);
            h.this.L(this.f6988a);
            h.this.f6971w.remove(this.f6988a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.M(this.f6988a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f6994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f6995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f6996c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6994a = iVar;
            this.f6995b = viewPropertyAnimator;
            this.f6996c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6995b.setListener(null);
            this.f6996c.setAlpha(1.0f);
            this.f6996c.setTranslationX(0.0f);
            this.f6996c.setTranslationY(0.0f);
            h.this.J(this.f6994a.f7002a, true);
            h.this.f6973y.remove(this.f6994a.f7002a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.K(this.f6994a.f7002a, true);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.h$h, reason: collision with other inner class name */
    public class C0064h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f6998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f6999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f7000c;

        public C0064h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f6998a = iVar;
            this.f6999b = viewPropertyAnimator;
            this.f7000c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6999b.setListener(null);
            this.f7000c.setAlpha(1.0f);
            this.f7000c.setTranslationX(0.0f);
            this.f7000c.setTranslationY(0.0f);
            h.this.J(this.f6998a.f7003b, false);
            h.this.f6973y.remove(this.f6998a.f7003b);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.K(this.f6998a.f7003b, false);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.e0 f7008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7012e;

        public j(RecyclerView.e0 e0Var, int i10, int i11, int i12, int i13) {
            this.f7008a = e0Var;
            this.f7009b = i10;
            this.f7010c = i11;
            this.f7011d = i12;
            this.f7012e = i13;
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean D(RecyclerView.e0 e0Var) {
        i0(e0Var);
        e0Var.itemView.setAlpha(0.0f);
        this.f6964p.add(e0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean E(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i10, int i11, int i12, int i13) {
        if (e0Var == e0Var2) {
            return F(e0Var, i10, i11, i12, i13);
        }
        float translationX = e0Var.itemView.getTranslationX();
        float translationY = e0Var.itemView.getTranslationY();
        float alpha = e0Var.itemView.getAlpha();
        i0(e0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        e0Var.itemView.setTranslationX(translationX);
        e0Var.itemView.setTranslationY(translationY);
        e0Var.itemView.setAlpha(alpha);
        if (e0Var2 != null) {
            i0(e0Var2);
            e0Var2.itemView.setTranslationX(-i14);
            e0Var2.itemView.setTranslationY(-i15);
            e0Var2.itemView.setAlpha(0.0f);
        }
        this.f6966r.add(new i(e0Var, e0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean F(RecyclerView.e0 e0Var, int i10, int i11, int i12, int i13) {
        View view = e0Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) e0Var.itemView.getTranslationY());
        i0(e0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            L(e0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f6965q.add(new j(e0Var, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean G(RecyclerView.e0 e0Var) {
        i0(e0Var);
        this.f6963o.add(e0Var);
        return true;
    }

    public void Z(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6970v.add(e0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m()).setListener(new e(e0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    public void a0(i iVar) {
        RecyclerView.e0 e0Var = iVar.f7002a;
        View view = e0Var == null ? null : e0Var.itemView;
        RecyclerView.e0 e0Var2 = iVar.f7003b;
        View view2 = e0Var2 != null ? e0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(n());
            this.f6973y.add(iVar.f7002a);
            duration.translationX(iVar.f7006e - iVar.f7004c);
            duration.translationY(iVar.f7007f - iVar.f7005d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f6973y.add(iVar.f7003b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(n()).alpha(1.0f).setListener(new C0064h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public void b0(RecyclerView.e0 e0Var, int i10, int i11, int i12, int i13) {
        View view = e0Var.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6971w.add(e0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).setListener(new f(e0Var, i14, view, i15, viewPropertyAnimatorAnimate)).start();
    }

    public final void c0(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f6972x.add(e0Var);
        viewPropertyAnimatorAnimate.setDuration(p()).alpha(0.0f).setListener(new d(e0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    public void d0(List<RecyclerView.e0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void e0() {
        if (q()) {
            return;
        }
        j();
    }

    public final void f0(List<i> list, RecyclerView.e0 e0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (h0(iVar, e0Var) && iVar.f7002a == null && iVar.f7003b == null) {
                list.remove(iVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(@n0 RecyclerView.e0 e0Var, @n0 List<Object> list) {
        return !list.isEmpty() || super.g(e0Var, list);
    }

    public final void g0(i iVar) {
        RecyclerView.e0 e0Var = iVar.f7002a;
        if (e0Var != null) {
            h0(iVar, e0Var);
        }
        RecyclerView.e0 e0Var2 = iVar.f7003b;
        if (e0Var2 != null) {
            h0(iVar, e0Var2);
        }
    }

    public final boolean h0(i iVar, RecyclerView.e0 e0Var) {
        boolean z10 = false;
        if (iVar.f7003b == e0Var) {
            iVar.f7003b = null;
        } else {
            if (iVar.f7002a != e0Var) {
                return false;
            }
            iVar.f7002a = null;
            z10 = true;
        }
        e0Var.itemView.setAlpha(1.0f);
        e0Var.itemView.setTranslationX(0.0f);
        e0Var.itemView.setTranslationY(0.0f);
        J(e0Var, z10);
        return true;
    }

    public final void i0(RecyclerView.e0 e0Var) {
        if (A == null) {
            A = new ValueAnimator().getInterpolator();
        }
        e0Var.itemView.animate().setInterpolator(A);
        k(e0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k(RecyclerView.e0 e0Var) {
        View view = e0Var.itemView;
        view.animate().cancel();
        int size = this.f6965q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f6965q.get(size).f7008a == e0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                L(e0Var);
                this.f6965q.remove(size);
            }
        }
        f0(this.f6966r, e0Var);
        if (this.f6963o.remove(e0Var)) {
            view.setAlpha(1.0f);
            N(e0Var);
        }
        if (this.f6964p.remove(e0Var)) {
            view.setAlpha(1.0f);
            H(e0Var);
        }
        for (int size2 = this.f6969u.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f6969u.get(size2);
            f0(arrayList, e0Var);
            if (arrayList.isEmpty()) {
                this.f6969u.remove(size2);
            }
        }
        for (int size3 = this.f6968t.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f6968t.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f7008a == e0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    L(e0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f6968t.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f6967s.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.e0> arrayList3 = this.f6967s.get(size5);
            if (arrayList3.remove(e0Var)) {
                view.setAlpha(1.0f);
                H(e0Var);
                if (arrayList3.isEmpty()) {
                    this.f6967s.remove(size5);
                }
            }
        }
        this.f6972x.remove(e0Var);
        this.f6970v.remove(e0Var);
        this.f6973y.remove(e0Var);
        this.f6971w.remove(e0Var);
        e0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void l() {
        int size = this.f6965q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f6965q.get(size);
            View view = jVar.f7008a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            L(jVar.f7008a);
            this.f6965q.remove(size);
        }
        for (int size2 = this.f6963o.size() - 1; size2 >= 0; size2--) {
            N(this.f6963o.get(size2));
            this.f6963o.remove(size2);
        }
        int size3 = this.f6964p.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.e0 e0Var = this.f6964p.get(size3);
            e0Var.itemView.setAlpha(1.0f);
            H(e0Var);
            this.f6964p.remove(size3);
        }
        for (int size4 = this.f6966r.size() - 1; size4 >= 0; size4--) {
            g0(this.f6966r.get(size4));
        }
        this.f6966r.clear();
        if (q()) {
            for (int size5 = this.f6968t.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f6968t.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f7008a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    L(jVar2.f7008a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f6968t.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f6967s.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.e0> arrayList2 = this.f6967s.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.e0 e0Var2 = arrayList2.get(size8);
                    e0Var2.itemView.setAlpha(1.0f);
                    H(e0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f6967s.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f6969u.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f6969u.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    g0(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f6969u.remove(arrayList3);
                    }
                }
            }
            d0(this.f6972x);
            d0(this.f6971w);
            d0(this.f6970v);
            d0(this.f6973y);
            j();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean q() {
        return (this.f6964p.isEmpty() && this.f6966r.isEmpty() && this.f6965q.isEmpty() && this.f6963o.isEmpty() && this.f6971w.isEmpty() && this.f6972x.isEmpty() && this.f6970v.isEmpty() && this.f6973y.isEmpty() && this.f6968t.isEmpty() && this.f6967s.isEmpty() && this.f6969u.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void x() {
        boolean z10 = !this.f6963o.isEmpty();
        boolean z11 = !this.f6965q.isEmpty();
        boolean z12 = !this.f6966r.isEmpty();
        boolean z13 = !this.f6964p.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.e0> it2 = this.f6963o.iterator();
            while (it2.hasNext()) {
                c0(it2.next());
            }
            this.f6963o.clear();
            if (z11) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f6965q);
                this.f6968t.add(arrayList);
                this.f6965q.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    u0.q1(arrayList.get(0).f7008a.itemView, aVar, p());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f6966r);
                this.f6969u.add(arrayList2);
                this.f6966r.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    u0.q1(arrayList2.get(0).f7002a.itemView, bVar, p());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList<RecyclerView.e0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f6964p);
                this.f6967s.add(arrayList3);
                this.f6964p.clear();
                c cVar = new c(arrayList3);
                if (z10 || z11 || z12) {
                    u0.q1(arrayList3.get(0).itemView, cVar, (z10 ? p() : 0L) + Math.max(z11 ? o() : 0L, z12 ? n() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.e0 f7002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.e0 f7003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7006e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7007f;

        public i(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
            this.f7002a = e0Var;
            this.f7003b = e0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f7002a + ", newHolder=" + this.f7003b + ", fromX=" + this.f7004c + ", fromY=" + this.f7005d + ", toX=" + this.f7006e + ", toY=" + this.f7007f + '}';
        }

        public i(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i10, int i11, int i12, int i13) {
            this(e0Var, e0Var2);
            this.f7004c = i10;
            this.f7005d = i11;
            this.f7006e = i12;
            this.f7007f = i13;
        }
    }
}
