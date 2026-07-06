package a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class to extends fq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TimeInterpolator f7517a;
    public ArrayList<RecyclerView.d0> b = new ArrayList<>();
    public ArrayList<RecyclerView.d0> c = new ArrayList<>();
    public ArrayList<so> d = new ArrayList<>();
    public ArrayList<ro> e = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.d0>> f = new ArrayList<>();
    public ArrayList<ArrayList<so>> g = new ArrayList<>();
    public ArrayList<ArrayList<ro>> h = new ArrayList<>();
    public ArrayList<RecyclerView.d0> i = new ArrayList<>();
    public ArrayList<RecyclerView.d0> j = new ArrayList<>();
    public ArrayList<RecyclerView.d0> k = new ArrayList<>();
    public ArrayList<RecyclerView.d0> l = new ArrayList<>();

    @Override // a.fq
    public boolean A(RecyclerView.d0 d0Var) {
        a0(d0Var);
        this.b.add(d0Var);
        return true;
    }

    public void R(RecyclerView.d0 d0Var) {
        View view = d0Var.f4387a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.i.add(d0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new no(this, d0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    public void S(ro roVar) {
        RecyclerView.d0 d0Var = roVar.f2765a;
        View view = d0Var == null ? null : d0Var.f4387a;
        RecyclerView.d0 d0Var2 = roVar.f2766b;
        View view2 = d0Var2 != null ? d0Var2.f4387a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.l.add(roVar.f2765a);
            duration.translationX(roVar.c - roVar.f7318a);
            duration.translationY(roVar.d - roVar.b);
            duration.alpha(0.0f).setListener(new po(this, roVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.l.add(roVar.f2766b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new qo(this, roVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public void T(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
        View view = d0Var.f4387a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.j.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new oo(this, d0Var, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }

    public final void U(RecyclerView.d0 d0Var) {
        View view = d0Var.f4387a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.k.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new mo(this, d0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    public void V(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f4387a.animate().cancel();
        }
    }

    public void W() {
        if (p()) {
            return;
        }
        i();
    }

    public final void X(List<ro> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ro roVar = list.get(size);
            if (Z(roVar, d0Var) && roVar.f2765a == null && roVar.f2766b == null) {
                list.remove(roVar);
            }
        }
    }

    public final void Y(ro roVar) {
        RecyclerView.d0 d0Var = roVar.f2765a;
        if (d0Var != null) {
            Z(roVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = roVar.f2766b;
        if (d0Var2 != null) {
            Z(roVar, d0Var2);
        }
    }

    public final boolean Z(ro roVar, RecyclerView.d0 d0Var) {
        boolean z = false;
        if (roVar.f2766b == d0Var) {
            roVar.f2766b = null;
        } else {
            if (roVar.f2765a != d0Var) {
                return false;
            }
            roVar.f2765a = null;
            z = true;
        }
        d0Var.f4387a.setAlpha(1.0f);
        d0Var.f4387a.setTranslationX(0.0f);
        d0Var.f4387a.setTranslationY(0.0f);
        D(d0Var, z);
        return true;
    }

    public final void a0(RecyclerView.d0 d0Var) {
        if (f7517a == null) {
            f7517a = new ValueAnimator().getInterpolator();
        }
        d0Var.f4387a.animate().setInterpolator(f7517a);
        j(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f4387a;
        view.animate().cancel();
        int size = this.d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.d.get(size).f2910a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                F(d0Var);
                this.d.remove(size);
            }
        }
        X(this.e, d0Var);
        if (this.b.remove(d0Var)) {
            view.setAlpha(1.0f);
            H(d0Var);
        }
        if (this.c.remove(d0Var)) {
            view.setAlpha(1.0f);
            B(d0Var);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            ArrayList<ro> arrayList = this.h.get(size2);
            X(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.h.remove(size2);
            }
        }
        for (int size3 = this.g.size() - 1; size3 >= 0; size3--) {
            ArrayList<so> arrayList2 = this.g.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f2910a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    F(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.g.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                B(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f.remove(size5);
                }
            }
        }
        this.k.remove(d0Var);
        this.i.remove(d0Var);
        this.l.remove(d0Var);
        this.j.remove(d0Var);
        W();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            so soVar = this.d.get(size);
            View view = soVar.f2910a.f4387a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            F(soVar.f2910a);
            this.d.remove(size);
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            H(this.b.get(size2));
            this.b.remove(size2);
        }
        int size3 = this.c.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.c.get(size3);
            d0Var.f4387a.setAlpha(1.0f);
            B(d0Var);
            this.c.remove(size3);
        }
        for (int size4 = this.e.size() - 1; size4 >= 0; size4--) {
            Y(this.e.get(size4));
        }
        this.e.clear();
        if (p()) {
            for (int size5 = this.g.size() - 1; size5 >= 0; size5--) {
                ArrayList<so> arrayList = this.g.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    so soVar2 = arrayList.get(size6);
                    View view2 = soVar2.f2910a.f4387a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    F(soVar2.f2910a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f4387a.setAlpha(1.0f);
                    B(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.h.size() - 1; size9 >= 0; size9--) {
                ArrayList<ro> arrayList3 = this.h.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    Y(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.h.remove(arrayList3);
                    }
                }
            }
            V(this.k);
            V(this.j);
            V(this.i);
            V(this.l);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.c.isEmpty() && this.e.isEmpty() && this.d.isEmpty() && this.b.isEmpty() && this.j.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.l.isEmpty() && this.g.isEmpty() && this.f.isEmpty() && this.h.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean z = !this.b.isEmpty();
        boolean z2 = !this.d.isEmpty();
        boolean z3 = !this.e.isEmpty();
        boolean z4 = !this.c.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.d0> it = this.b.iterator();
            while (it.hasNext()) {
                U(it.next());
            }
            this.b.clear();
            if (z2) {
                ArrayList<so> arrayList = new ArrayList<>();
                arrayList.addAll(this.d);
                this.g.add(arrayList);
                this.d.clear();
                jo joVar = new jo(this, arrayList);
                if (z) {
                    eh.d0(arrayList.get(0).f2910a.f4387a, joVar, o());
                } else {
                    joVar.run();
                }
            }
            if (z3) {
                ArrayList<ro> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.e);
                this.h.add(arrayList2);
                this.e.clear();
                ko koVar = new ko(this, arrayList2);
                if (z) {
                    eh.d0(arrayList2.get(0).f2765a.f4387a, koVar, o());
                } else {
                    koVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.c);
                this.f.add(arrayList3);
                this.c.clear();
                lo loVar = new lo(this, arrayList3);
                if (z || z2 || z3) {
                    eh.d0(arrayList3.get(0).f4387a, loVar, (z ? o() : 0L) + Math.max(z2 ? n() : 0L, z3 ? m() : 0L));
                } else {
                    loVar.run();
                }
            }
        }
    }

    @Override // a.fq
    public boolean x(RecyclerView.d0 d0Var) {
        a0(d0Var);
        d0Var.f4387a.setAlpha(0.0f);
        this.c.add(d0Var);
        return true;
    }

    @Override // a.fq
    public boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4) {
        if (d0Var == d0Var2) {
            return z(d0Var, i, i2, i3, i4);
        }
        float translationX = d0Var.f4387a.getTranslationX();
        float translationY = d0Var.f4387a.getTranslationY();
        float alpha = d0Var.f4387a.getAlpha();
        a0(d0Var);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        d0Var.f4387a.setTranslationX(translationX);
        d0Var.f4387a.setTranslationY(translationY);
        d0Var.f4387a.setAlpha(alpha);
        if (d0Var2 != null) {
            a0(d0Var2);
            d0Var2.f4387a.setTranslationX(-i5);
            d0Var2.f4387a.setTranslationY(-i6);
            d0Var2.f4387a.setAlpha(0.0f);
        }
        this.e.add(new ro(d0Var, d0Var2, i, i2, i3, i4));
        return true;
    }

    @Override // a.fq
    public boolean z(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4) {
        View view = d0Var.f4387a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) d0Var.f4387a.getTranslationY());
        a0(d0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            F(d0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.d.add(new so(d0Var, translationX, translationY, i3, i4));
        return true;
    }
}
