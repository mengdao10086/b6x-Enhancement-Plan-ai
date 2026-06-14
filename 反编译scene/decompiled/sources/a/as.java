package a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class as implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ba<String, String> f119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fs f120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yr f124a;
    public ArrayList<ks> l;
    public ArrayList<ks> m;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f116b = {2, 1, 3, 4};
    public static final or b = new ur();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ThreadLocal<ba<Animator, xr>> f5637a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f126a = getClass().getName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f118a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f129b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TimeInterpolator f125a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Integer> f127a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<View> f131b = new ArrayList<>();
    public ArrayList<String> c = null;
    public ArrayList<Class<?>> d = null;
    public ArrayList<Integer> e = null;
    public ArrayList<View> f = null;
    public ArrayList<Class<?>> g = null;
    public ArrayList<String> h = null;
    public ArrayList<Integer> i = null;
    public ArrayList<View> j = null;
    public ArrayList<Class<?>> k = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ls f122a = new ls();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ls f130b = new ls();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public is f121a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f128a = f116b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f132b = false;
    public ArrayList<Animator> n = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f117a = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f133c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f134d = false;
    public ArrayList<zr> o = null;
    public ArrayList<Animator> p = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public or f123a = b;

    public static boolean H(ks ksVar, ks ksVar2, String str) {
        Object obj = ksVar.f1686a.get(str);
        Object obj2 = ksVar2.f1686a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public static void d(ls lsVar, View view, ks ksVar) {
        lsVar.f6735a.put(view, ksVar);
        int id = view.getId();
        if (id >= 0) {
            if (lsVar.f1848a.indexOfKey(id) >= 0) {
                lsVar.f1848a.put(id, null);
            } else {
                lsVar.f1848a.put(id, view);
            }
        }
        String strH = eh.H(view);
        if (strH != null) {
            if (lsVar.b.containsKey(strH)) {
                lsVar.b.put(strH, null);
            } else {
                lsVar.b.put(strH, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (lsVar.f1847a.g(itemIdAtPosition) < 0) {
                    eh.s0(view, true);
                    lsVar.f1847a.i(itemIdAtPosition, view);
                    return;
                }
                View viewE = lsVar.f1847a.e(itemIdAtPosition);
                if (viewE != null) {
                    eh.s0(viewE, false);
                    lsVar.f1847a.i(itemIdAtPosition, null);
                }
            }
        }
    }

    public static ba<Animator, xr> x() {
        ba<Animator, xr> baVar = f5637a.get();
        if (baVar != null) {
            return baVar;
        }
        ba<Animator, xr> baVar2 = new ba<>();
        f5637a.set(baVar2);
        return baVar2;
    }

    public List<String> A() {
        return this.c;
    }

    public List<Class<?>> B() {
        return this.d;
    }

    public List<View> C() {
        return this.f131b;
    }

    public String[] D() {
        return null;
    }

    public ks E(View view, boolean z) {
        is isVar = this.f121a;
        if (isVar != null) {
            return isVar.E(view, z);
        }
        return (z ? this.f122a : this.f130b).f6735a.get(view);
    }

    public boolean F(ks ksVar, ks ksVar2) {
        if (ksVar == null || ksVar2 == null) {
            return false;
        }
        String[] strArrD = D();
        if (strArrD == null) {
            Iterator<String> it = ksVar.f1686a.keySet().iterator();
            while (it.hasNext()) {
                if (H(ksVar, ksVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrD) {
            if (!H(ksVar, ksVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.e;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.g;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.g.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.h != null && eh.H(view) != null && this.h.contains(eh.H(view))) {
            return false;
        }
        if ((this.f127a.size() == 0 && this.f131b.size() == 0 && (((arrayList = this.d) == null || arrayList.isEmpty()) && ((arrayList2 = this.c) == null || arrayList2.isEmpty()))) || this.f127a.contains(Integer.valueOf(id)) || this.f131b.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.c;
        if (arrayList6 != null && arrayList6.contains(eh.H(view))) {
            return true;
        }
        if (this.d != null) {
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                if (this.d.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void I(ba<View, ks> baVar, ba<View, ks> baVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && G(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && G(view)) {
                ks ksVar = baVar.get(viewValueAt);
                ks ksVar2 = baVar2.get(view);
                if (ksVar != null && ksVar2 != null) {
                    this.l.add(ksVar);
                    this.m.add(ksVar2);
                    baVar.remove(viewValueAt);
                    baVar2.remove(view);
                }
            }
        }
    }

    public final void J(ba<View, ks> baVar, ba<View, ks> baVar2) {
        ks ksVarRemove;
        for (int size = baVar.size() - 1; size >= 0; size--) {
            View viewI = baVar.i(size);
            if (viewI != null && G(viewI) && (ksVarRemove = baVar2.remove(viewI)) != null && G(ksVarRemove.f6635a)) {
                this.l.add(baVar.k(size));
                this.m.add(ksVarRemove);
            }
        }
    }

    public final void K(ba<View, ks> baVar, ba<View, ks> baVar2, fa<View> faVar, fa<View> faVar2) {
        View viewE;
        int iL = faVar.l();
        for (int i = 0; i < iL; i++) {
            View viewM = faVar.m(i);
            if (viewM != null && G(viewM) && (viewE = faVar2.e(faVar.h(i))) != null && G(viewE)) {
                ks ksVar = baVar.get(viewM);
                ks ksVar2 = baVar2.get(viewE);
                if (ksVar != null && ksVar2 != null) {
                    this.l.add(ksVar);
                    this.m.add(ksVar2);
                    baVar.remove(viewM);
                    baVar2.remove(viewE);
                }
            }
        }
    }

    public final void L(ba<View, ks> baVar, ba<View, ks> baVar2, ba<String, View> baVar3, ba<String, View> baVar4) {
        View view;
        int size = baVar3.size();
        for (int i = 0; i < size; i++) {
            View viewM = baVar3.m(i);
            if (viewM != null && G(viewM) && (view = baVar4.get(baVar3.i(i))) != null && G(view)) {
                ks ksVar = baVar.get(viewM);
                ks ksVar2 = baVar2.get(view);
                if (ksVar != null && ksVar2 != null) {
                    this.l.add(ksVar);
                    this.m.add(ksVar2);
                    baVar.remove(viewM);
                    baVar2.remove(view);
                }
            }
        }
    }

    public final void M(ls lsVar, ls lsVar2) {
        ba<View, ks> baVar = new ba<>(lsVar.f6735a);
        ba<View, ks> baVar2 = new ba<>(lsVar2.f6735a);
        int i = 0;
        while (true) {
            int[] iArr = this.f128a;
            if (i >= iArr.length) {
                c(baVar, baVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                J(baVar, baVar2);
            } else if (i2 == 2) {
                L(baVar, baVar2, lsVar.b, lsVar2.b);
            } else if (i2 == 3) {
                I(baVar, baVar2, lsVar.f1848a, lsVar2.f1848a);
            } else if (i2 == 4) {
                K(baVar, baVar2, lsVar.f1847a, lsVar2.f1847a);
            }
            i++;
        }
    }

    public void N(View view) {
        if (this.f134d) {
            return;
        }
        ba<Animator, xr> baVarX = x();
        int size = baVarX.size();
        lt ltVarD = ys.d(view);
        for (int i = size - 1; i >= 0; i--) {
            xr xrVarM = baVarX.m(i);
            if (xrVarM.f3610a != null && ltVarD.equals(xrVarM.f3609a)) {
                rq.b(baVarX.i(i));
            }
        }
        ArrayList<zr> arrayList = this.o;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.o.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((zr) arrayList2.get(i2)).a(this);
            }
        }
        this.f133c = true;
    }

    public void O(ViewGroup viewGroup) {
        xr xrVar;
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        M(this.f122a, this.f130b);
        ba<Animator, xr> baVarX = x();
        int size = baVarX.size();
        lt ltVarD = ys.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorI = baVarX.i(i);
            if (animatorI != null && (xrVar = baVarX.get(animatorI)) != null && xrVar.f3610a != null && ltVarD.equals(xrVar.f3609a)) {
                ks ksVar = xrVar.f3608a;
                View view = xrVar.f3610a;
                ks ksVarE = E(view, true);
                ks ksVarT = t(view, true);
                if (ksVarE == null && ksVarT == null) {
                    ksVarT = this.f130b.f6735a.get(view);
                }
                if (!(ksVarE == null && ksVarT == null) && xrVar.f7913a.F(ksVar, ksVarT)) {
                    if (animatorI.isRunning() || animatorI.isStarted()) {
                        animatorI.cancel();
                    } else {
                        baVarX.remove(animatorI);
                    }
                }
            }
        }
        o(viewGroup, this.f122a, this.f130b, this.l, this.m);
        T();
    }

    public as P(zr zrVar) {
        ArrayList<zr> arrayList = this.o;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(zrVar);
        if (this.o.size() == 0) {
            this.o = null;
        }
        return this;
    }

    public as Q(View view) {
        this.f131b.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.f133c) {
            if (!this.f134d) {
                ba<Animator, xr> baVarX = x();
                int size = baVarX.size();
                lt ltVarD = ys.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    xr xrVarM = baVarX.m(i);
                    if (xrVarM.f3610a != null && ltVarD.equals(xrVarM.f3609a)) {
                        rq.c(baVarX.i(i));
                    }
                }
                ArrayList<zr> arrayList = this.o;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.o.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((zr) arrayList2.get(i2)).b(this);
                    }
                }
            }
            this.f133c = false;
        }
    }

    public final void S(Animator animator, ba<Animator, xr> baVar) {
        if (animator != null) {
            animator.addListener(new vr(this, baVar));
            e(animator);
        }
    }

    public void T() {
        a0();
        ba<Animator, xr> baVarX = x();
        for (Animator animator : this.p) {
            if (baVarX.containsKey(animator)) {
                a0();
                S(animator, baVarX);
            }
        }
        this.p.clear();
        p();
    }

    public as U(long j) {
        this.f129b = j;
        return this;
    }

    public void V(yr yrVar) {
        this.f124a = yrVar;
    }

    public as W(TimeInterpolator timeInterpolator) {
        this.f125a = timeInterpolator;
        return this;
    }

    public void X(or orVar) {
        if (orVar == null) {
            orVar = b;
        }
        this.f123a = orVar;
    }

    public void Y(fs fsVar) {
        this.f120a = fsVar;
    }

    public as Z(long j) {
        this.f118a = j;
        return this;
    }

    public as a(zr zrVar) {
        if (this.o == null) {
            this.o = new ArrayList<>();
        }
        this.o.add(zrVar);
        return this;
    }

    public void a0() {
        if (this.f117a == 0) {
            ArrayList<zr> arrayList = this.o;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.o.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((zr) arrayList2.get(i)).c(this);
                }
            }
            this.f134d = false;
        }
        this.f117a++;
    }

    public as b(View view) {
        this.f131b.add(view);
        return this;
    }

    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f129b != -1) {
            str2 = str2 + "dur(" + this.f129b + ") ";
        }
        if (this.f118a != -1) {
            str2 = str2 + "dly(" + this.f118a + ") ";
        }
        if (this.f125a != null) {
            str2 = str2 + "interp(" + this.f125a + ") ";
        }
        if (this.f127a.size() <= 0 && this.f131b.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f127a.size() > 0) {
            for (int i = 0; i < this.f127a.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f127a.get(i);
            }
        }
        if (this.f131b.size() > 0) {
            for (int i2 = 0; i2 < this.f131b.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f131b.get(i2);
            }
        }
        return str3 + ")";
    }

    public final void c(ba<View, ks> baVar, ba<View, ks> baVar2) {
        for (int i = 0; i < baVar.size(); i++) {
            ks ksVarM = baVar.m(i);
            if (G(ksVarM.f6635a)) {
                this.l.add(ksVarM);
                this.m.add(null);
            }
        }
        for (int i2 = 0; i2 < baVar2.size(); i2++) {
            ks ksVarM2 = baVar2.m(i2);
            if (G(ksVarM2.f6635a)) {
                this.m.add(ksVarM2);
                this.l.add(null);
            }
        }
    }

    public void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new wr(this));
        animator.start();
    }

    public void f() {
        for (int size = this.n.size() - 1; size >= 0; size--) {
            this.n.get(size).cancel();
        }
        ArrayList<zr> arrayList = this.o;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.o.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((zr) arrayList2.get(i)).d(this);
        }
    }

    public abstract void g(ks ksVar);

    public final void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.e;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.g;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.g.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ks ksVar = new ks(view);
                    if (z) {
                        j(ksVar);
                    } else {
                        g(ksVar);
                    }
                    ksVar.f1685a.add(this);
                    i(ksVar);
                    d(z ? this.f122a : this.f130b, view, ksVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.i;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.j;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.k;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.k.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                h(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public void i(ks ksVar) {
        String[] strArrB;
        if (this.f120a == null || ksVar.f1686a.isEmpty() || (strArrB = this.f120a.b()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrB.length) {
                z = true;
                break;
            } else if (!ksVar.f1686a.containsKey(strArrB[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.f120a.a(ksVar);
    }

    public abstract void j(ks ksVar);

    public void k(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        ba<String, String> baVar;
        l(z);
        if ((this.f127a.size() > 0 || this.f131b.size() > 0) && (((arrayList = this.c) == null || arrayList.isEmpty()) && ((arrayList2 = this.d) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.f127a.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.f127a.get(i).intValue());
                if (viewFindViewById != null) {
                    ks ksVar = new ks(viewFindViewById);
                    if (z) {
                        j(ksVar);
                    } else {
                        g(ksVar);
                    }
                    ksVar.f1685a.add(this);
                    i(ksVar);
                    d(z ? this.f122a : this.f130b, viewFindViewById, ksVar);
                }
            }
            for (int i2 = 0; i2 < this.f131b.size(); i2++) {
                View view = this.f131b.get(i2);
                ks ksVar2 = new ks(view);
                if (z) {
                    j(ksVar2);
                } else {
                    g(ksVar2);
                }
                ksVar2.f1685a.add(this);
                i(ksVar2);
                d(z ? this.f122a : this.f130b, view, ksVar2);
            }
        } else {
            h(viewGroup, z);
        }
        if (z || (baVar = this.f119a) == null) {
            return;
        }
        int size = baVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.f122a.b.remove(this.f119a.i(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.f122a.b.put(this.f119a.m(i4), view2);
            }
        }
    }

    public void l(boolean z) {
        ls lsVar;
        if (z) {
            this.f122a.f6735a.clear();
            this.f122a.f1848a.clear();
            lsVar = this.f122a;
        } else {
            this.f130b.f6735a.clear();
            this.f130b.f1848a.clear();
            lsVar = this.f130b;
        }
        lsVar.f1847a.b();
    }

    @Override // 
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public as clone() {
        try {
            as asVar = (as) super.clone();
            asVar.p = new ArrayList<>();
            asVar.f122a = new ls();
            asVar.f130b = new ls();
            asVar.l = null;
            asVar.m = null;
            return asVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, ks ksVar, ks ksVar2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(android.view.ViewGroup r21, a.ls r22, a.ls r23, java.util.ArrayList<a.ks> r24, java.util.ArrayList<a.ks> r25) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.as.o(android.view.ViewGroup, a.ls, a.ls, java.util.ArrayList, java.util.ArrayList):void");
    }

    public void p() {
        int i = this.f117a - 1;
        this.f117a = i;
        if (i == 0) {
            ArrayList<zr> arrayList = this.o;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.o.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((zr) arrayList2.get(i2)).e(this);
                }
            }
            for (int i3 = 0; i3 < this.f122a.f1847a.l(); i3++) {
                View viewM = this.f122a.f1847a.m(i3);
                if (viewM != null) {
                    eh.s0(viewM, false);
                }
            }
            for (int i4 = 0; i4 < this.f130b.f1847a.l(); i4++) {
                View viewM2 = this.f130b.f1847a.m(i4);
                if (viewM2 != null) {
                    eh.s0(viewM2, false);
                }
            }
            this.f134d = true;
        }
    }

    public long q() {
        return this.f129b;
    }

    public yr r() {
        return this.f124a;
    }

    public TimeInterpolator s() {
        return this.f125a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r7 = r6.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r7 = r6.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a.ks t(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            a.is r0 = r6.f121a
            if (r0 == 0) goto L9
            a.ks r7 = r0.t(r7, r8)
            return r7
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<a.ks> r0 = r6.l
            goto L10
        Le:
            java.util.ArrayList<a.ks> r0 = r6.m
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1a:
            if (r4 >= r2) goto L2e
            java.lang.Object r5 = r0.get(r4)
            a.ks r5 = (a.ks) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f6635a
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<a.ks> r7 = r6.m
            goto L37
        L35:
            java.util.ArrayList<a.ks> r7 = r6.l
        L37:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            a.ks r1 = (a.ks) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.as.t(android.view.View, boolean):a.ks");
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f126a;
    }

    public or v() {
        return this.f123a;
    }

    public fs w() {
        return this.f120a;
    }

    public long y() {
        return this.f118a;
    }

    public List<Integer> z() {
        return this.f127a;
    }
}
