package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.f;
import androidx.core.view.u0;
import androidx.core.view.x0;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.h;
import g.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends SpecialEffectsController {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5853a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f5853a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5853a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5853a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5853a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    public class RunnableC0050b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f5854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5855b;

        public RunnableC0050b(List list, SpecialEffectsController.Operation operation) {
            this.f5854a = list;
            this.f5855b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5854a.contains(this.f5855b)) {
                this.f5854a.remove(this.f5855b);
                b.this.s(this.f5855b);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f5861e;

        public c(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, k kVar) {
            this.f5857a = viewGroup;
            this.f5858b = view;
            this.f5859c = z10;
            this.f5860d = operation;
            this.f5861e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5857a.endViewTransition(this.f5858b);
            if (this.f5859c) {
                this.f5860d.e().applyState(this.f5858b);
            }
            this.f5861e.a();
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f5860d);
                sb2.append(" has ended.");
            }
        }
    }

    public class d implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f5863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5864b;

        public d(Animator animator, SpecialEffectsController.Operation operation) {
            this.f5863a = animator;
            this.f5864b = operation;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f5863a.end();
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f5864b);
                sb2.append(" has been canceled.");
            }
        }
    }

    public class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f5868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f5869d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f5867b.endViewTransition(eVar.f5868c);
                e.this.f5869d.a();
            }
        }

        public e(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, k kVar) {
            this.f5866a = operation;
            this.f5867b = viewGroup;
            this.f5868c = view;
            this.f5869d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f5867b.post(new a());
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5866a);
                sb2.append(" has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5866a);
                sb2.append(" has reached onAnimationStart.");
            }
        }
    }

    public class f implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f5874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5875d;

        public f(View view, ViewGroup viewGroup, k kVar, SpecialEffectsController.Operation operation) {
            this.f5872a = view;
            this.f5873b = viewGroup;
            this.f5874c = kVar;
            this.f5875d = operation;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f5872a.clearAnimation();
            this.f5873b.endViewTransition(this.f5872a);
            this.f5874c.a();
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5875d);
                sb2.append(" has been cancelled.");
            }
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f5880d;

        public g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z10, androidx.collection.a aVar) {
            this.f5877a = operation;
            this.f5878b = operation2;
            this.f5879c = z10;
            this.f5880d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.a(this.f5877a.f(), this.f5878b.f(), this.f5879c, this.f5880d, false);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f5882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f5883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f5884c;

        public h(k0 k0Var, View view, Rect rect) {
            this.f5882a = k0Var;
            this.f5883b = view;
            this.f5884c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5882a.h(this.f5883b, this.f5884c);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f5886a;

        public i(ArrayList arrayList) {
            this.f5886a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.e(this.f5886a, 4);
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f5888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f5889b;

        public j(m mVar, SpecialEffectsController.Operation operation) {
            this.f5888a = mVar;
            this.f5889b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5888a.a();
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Transition for operation ");
                sb2.append(this.f5889b);
                sb2.append("has completed");
            }
        }
    }

    public static class k extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public h.a f5893e;

        public k(@g.n0 SpecialEffectsController.Operation operation, @g.n0 androidx.core.os.f fVar, boolean z10) {
            super(operation, fVar);
            this.f5892d = false;
            this.f5891c = z10;
        }

        @p0
        public h.a e(@g.n0 Context context) {
            if (this.f5892d) {
                return this.f5893e;
            }
            h.a aVarB = androidx.fragment.app.h.b(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.f5891c);
            this.f5893e = aVarB;
            this.f5892d = true;
            return aVarB;
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final SpecialEffectsController.Operation f5894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.n0
        public final androidx.core.os.f f5895b;

        public l(@g.n0 SpecialEffectsController.Operation operation, @g.n0 androidx.core.os.f fVar) {
            this.f5894a = operation;
            this.f5895b = fVar;
        }

        public void a() {
            this.f5894a.d(this.f5895b);
        }

        @g.n0
        public SpecialEffectsController.Operation b() {
            return this.f5894a;
        }

        @g.n0
        public androidx.core.os.f c() {
            return this.f5895b;
        }

        public boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.f5894a.f().C1);
            SpecialEffectsController.Operation.State stateE = this.f5894a.e();
            return stateFrom == stateE || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || stateE == state);
        }
    }

    public static class m extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final Object f5896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f5897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public final Object f5898e;

        public m(@g.n0 SpecialEffectsController.Operation operation, @g.n0 androidx.core.os.f fVar, boolean z10, boolean z11) {
            super(operation, fVar);
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f5896c = z10 ? operation.f().U2() : operation.f().c2();
                this.f5897d = z10 ? operation.f().I1() : operation.f().x1();
            } else {
                this.f5896c = z10 ? operation.f().X2() : operation.f().j2();
                this.f5897d = true;
            }
            if (!z11) {
                this.f5898e = null;
            } else if (z10) {
                this.f5898e = operation.f().Z2();
            } else {
                this.f5898e = operation.f().Y2();
            }
        }

        @p0
        public k0 e() {
            k0 k0VarF = f(this.f5896c);
            k0 k0VarF2 = f(this.f5898e);
            if (k0VarF == null || k0VarF2 == null || k0VarF == k0VarF2) {
                return k0VarF != null ? k0VarF : k0VarF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f5896c + " which uses a different Transition  type than its shared element transition " + this.f5898e);
        }

        @p0
        public final k0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            k0 k0Var = i0.f5980a;
            if (k0Var != null && k0Var.e(obj)) {
                return k0Var;
            }
            k0 k0Var2 = i0.f5981b;
            if (k0Var2 != null && k0Var2.e(obj)) {
                return k0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        @p0
        public Object g() {
            return this.f5898e;
        }

        @p0
        public Object h() {
            return this.f5896c;
        }

        public boolean i() {
            return this.f5898e != null;
        }

        public boolean j() {
            return this.f5897d;
        }
    }

    public b(@g.n0 ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(@g.n0 java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.f(java.util.List, boolean):void");
    }

    public void s(@g.n0 SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().C1);
    }

    public void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (x0.c(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    public void u(Map<String, View> map, @g.n0 View view) {
        String strX0 = u0.x0(view);
        if (strX0 != null) {
            map.put(strX0, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(@g.n0 androidx.collection.a<String, View> aVar, @g.n0 Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it2 = aVar.entrySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(u0.x0(it2.next().getValue()))) {
                it2.remove();
            }
        }
    }

    public final void w(@g.n0 List<k> list, @g.n0 List<SpecialEffectsController.Operation> list2, boolean z10, @g.n0 Map<SpecialEffectsController.Operation, Boolean> map) {
        int i10;
        boolean z11;
        SpecialEffectsController.Operation operation;
        ViewGroup viewGroupM = m();
        Context context = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        Iterator<k> it2 = list.iterator();
        boolean z12 = false;
        while (true) {
            i10 = 2;
            if (!it2.hasNext()) {
                break;
            }
            k next = it2.next();
            if (next.d()) {
                next.a();
            } else {
                h.a aVarE = next.e(context);
                if (aVarE == null) {
                    next.a();
                } else {
                    Animator animator = aVarE.f5974b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operationB = next.b();
                        Fragment fragmentF = operationB.f();
                        if (Boolean.TRUE.equals(map.get(operationB))) {
                            if (FragmentManager.W0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Ignoring Animator set on ");
                                sb2.append(fragmentF);
                                sb2.append(" as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            boolean z13 = operationB.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z13) {
                                list2.remove(operationB);
                            }
                            View view = fragmentF.C1;
                            viewGroupM.startViewTransition(view);
                            animator.addListener(new c(viewGroupM, view, z13, operationB, next));
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.W0(2)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Animator from operation ");
                                operation = operationB;
                                sb3.append(operation);
                                sb3.append(" has started.");
                            } else {
                                operation = operationB;
                            }
                            next.c().d(new d(animator, operation));
                            z12 = true;
                        }
                    }
                }
            }
        }
        for (k kVar : arrayList) {
            SpecialEffectsController.Operation operationB2 = kVar.b();
            Fragment fragmentF2 = operationB2.f();
            if (z10) {
                if (FragmentManager.W0(i10)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Ignoring Animation set on ");
                    sb4.append(fragmentF2);
                    sb4.append(" as Animations cannot run alongside Transitions.");
                }
                kVar.a();
            } else if (z12) {
                if (FragmentManager.W0(i10)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Ignoring Animation set on ");
                    sb5.append(fragmentF2);
                    sb5.append(" as Animations cannot run alongside Animators.");
                }
                kVar.a();
            } else {
                View view2 = fragmentF2.C1;
                Animation animation = (Animation) androidx.core.util.o.l(((h.a) androidx.core.util.o.l(kVar.e(context))).f5973a);
                if (operationB2.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                    z11 = z12;
                } else {
                    viewGroupM.startViewTransition(view2);
                    h.b bVar = new h.b(animation, viewGroupM, view2);
                    z11 = z12;
                    bVar.setAnimationListener(new e(operationB2, viewGroupM, view2, kVar));
                    view2.startAnimation(bVar);
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Animation from operation ");
                        sb6.append(operationB2);
                        sb6.append(" has started.");
                    }
                }
                kVar.c().d(new f(view2, viewGroupM, kVar, operationB2));
                z12 = z11;
                i10 = 2;
            }
        }
    }

    @g.n0
    public final Map<SpecialEffectsController.Operation, Boolean> x(@g.n0 List<m> list, @g.n0 List<SpecialEffectsController.Operation> list2, boolean z10, @p0 SpecialEffectsController.Operation operation, @p0 SpecialEffectsController.Operation operation2) {
        Iterator<m> it2;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        Object objK;
        androidx.collection.a aVar;
        ArrayList<View> arrayList3;
        b bVar;
        SpecialEffectsController.Operation operation5;
        ArrayList<View> arrayList4;
        Rect rect;
        k0 k0Var;
        SpecialEffectsController.Operation operation6;
        View view3;
        f0.k0 k0VarD2;
        f0.k0 k0VarK2;
        ArrayList<String> arrayList5;
        View view4;
        View view5;
        String strB;
        ArrayList<String> arrayList6;
        b bVar2 = this;
        boolean z11 = z10;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap map = new HashMap();
        k0 k0Var2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                k0 k0VarE = mVar.e();
                if (k0Var2 == null) {
                    k0Var2 = k0VarE;
                } else if (k0VarE != null && k0Var2 != k0VarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (k0Var2 == null) {
            for (m mVar2 : list) {
                map.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Object obj3 = null;
        View view7 = null;
        boolean z12 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || operation7 == null || operation8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList8;
                bVar = bVar2;
                operation5 = operation7;
                arrayList4 = arrayList7;
                rect = rect2;
                k0Var = k0Var2;
                operation6 = operation8;
                view3 = view6;
                view7 = view7;
            } else {
                Object objW = k0Var2.w(k0Var2.f(mVar3.g()));
                ArrayList<String> arrayListA3 = operation2.f().a3();
                ArrayList<String> arrayListA32 = operation.f().a3();
                ArrayList<String> arrayListB3 = operation.f().b3();
                View view8 = view7;
                int i10 = 0;
                while (i10 < arrayListB3.size()) {
                    int iIndexOf = arrayListA3.indexOf(arrayListB3.get(i10));
                    ArrayList<String> arrayList9 = arrayListB3;
                    if (iIndexOf != -1) {
                        arrayListA3.set(iIndexOf, arrayListA32.get(i10));
                    }
                    i10++;
                    arrayListB3 = arrayList9;
                }
                ArrayList<String> arrayListB32 = operation2.f().b3();
                if (z11) {
                    k0VarD2 = operation.f().d2();
                    k0VarK2 = operation2.f().k2();
                } else {
                    k0VarD2 = operation.f().k2();
                    k0VarK2 = operation2.f().d2();
                }
                int size = arrayListA3.size();
                HashMap map2 = map;
                int i11 = 0;
                while (i11 < size) {
                    aVar2.put(arrayListA3.get(i11), arrayListB32.get(i11));
                    i11++;
                    size = size;
                    view6 = view6;
                }
                View view9 = view6;
                if (FragmentManager.W0(2)) {
                    Iterator<String> it3 = arrayListB32.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        Iterator<String> it4 = it3;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Name: ");
                        sb2.append(next);
                        it3 = it4;
                    }
                    Iterator<String> it5 = arrayListA3.iterator();
                    while (it5.hasNext()) {
                        String next2 = it5.next();
                        Iterator<String> it6 = it5;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Name: ");
                        sb3.append(next2);
                        it5 = it6;
                    }
                }
                androidx.collection.a<String, View> aVar3 = new androidx.collection.a<>();
                bVar2.u(aVar3, operation.f().C1);
                aVar3.s(arrayListA3);
                if (k0VarD2 != null) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Executing exit callback for operation ");
                        sb4.append(operation7);
                    }
                    k0VarD2.d(arrayListA3, aVar3);
                    int size2 = arrayListA3.size() - 1;
                    while (size2 >= 0) {
                        String str = arrayListA3.get(size2);
                        View view10 = aVar3.get(str);
                        if (view10 == null) {
                            aVar2.remove(str);
                            arrayList6 = arrayListA3;
                        } else {
                            arrayList6 = arrayListA3;
                            if (!str.equals(u0.x0(view10))) {
                                aVar2.put(u0.x0(view10), (String) aVar2.remove(str));
                            }
                        }
                        size2--;
                        arrayListA3 = arrayList6;
                    }
                    arrayList5 = arrayListA3;
                } else {
                    arrayList5 = arrayListA3;
                    aVar2.s(aVar3.keySet());
                }
                androidx.collection.a<String, View> aVar4 = new androidx.collection.a<>();
                bVar2.u(aVar4, operation2.f().C1);
                aVar4.s(arrayListB32);
                aVar4.s(aVar2.values());
                if (k0VarK2 != null) {
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Executing enter callback for operation ");
                        sb5.append(operation8);
                    }
                    k0VarK2.d(arrayListB32, aVar4);
                    for (int size3 = arrayListB32.size() - 1; size3 >= 0; size3--) {
                        String str2 = arrayListB32.get(size3);
                        View view11 = aVar4.get(str2);
                        if (view11 == null) {
                            String strB2 = i0.b(aVar2, str2);
                            if (strB2 != null) {
                                aVar2.remove(strB2);
                            }
                        } else if (!str2.equals(u0.x0(view11)) && (strB = i0.b(aVar2, str2)) != null) {
                            aVar2.put(strB, u0.x0(view11));
                        }
                    }
                } else {
                    i0.d(aVar2, aVar4);
                }
                bVar2.v(aVar3, aVar2.keySet());
                bVar2.v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList8;
                    bVar = bVar2;
                    operation5 = operation7;
                    arrayList4 = arrayList7;
                    rect = rect2;
                    k0Var = k0Var2;
                    view7 = view8;
                    map = map2;
                    obj3 = null;
                    operation6 = operation8;
                    view3 = view9;
                } else {
                    i0.a(operation2.f(), operation.f(), z11, aVar3, true);
                    ArrayList<String> arrayList10 = arrayList5;
                    aVar = aVar2;
                    ArrayList<View> arrayList11 = arrayList8;
                    androidx.core.view.n0.a(m(), new g(operation2, operation, z10, aVar4));
                    arrayList7.addAll(aVar3.values());
                    if (arrayList10.isEmpty()) {
                        view7 = view8;
                    } else {
                        View view12 = aVar3.get(arrayList10.get(0));
                        k0Var2.r(objW, view12);
                        view7 = view12;
                    }
                    arrayList3 = arrayList11;
                    arrayList3.addAll(aVar4.values());
                    if (arrayListB32.isEmpty() || (view5 = aVar4.get(arrayListB32.get(0))) == null) {
                        bVar = this;
                        view4 = view9;
                    } else {
                        bVar = this;
                        androidx.core.view.n0.a(m(), bVar.new h(k0Var2, view5, rect2));
                        view4 = view9;
                        z12 = true;
                    }
                    k0Var2.u(objW, view4, arrayList7);
                    arrayList4 = arrayList7;
                    rect = rect2;
                    view3 = view4;
                    k0Var = k0Var2;
                    k0Var2.p(objW, null, null, null, null, objW, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation;
                    map = map2;
                    map.put(operation5, bool);
                    operation6 = operation2;
                    map.put(operation6, bool);
                    obj3 = objW;
                }
            }
            z11 = z10;
            arrayList7 = arrayList4;
            bVar2 = bVar;
            rect2 = rect;
            view6 = view3;
            operation8 = operation6;
            aVar2 = aVar;
            arrayList8 = arrayList3;
            operation7 = operation5;
            k0Var2 = k0Var;
        }
        View view13 = view7;
        androidx.collection.a aVar5 = aVar2;
        ArrayList<View> arrayList12 = arrayList8;
        b bVar3 = bVar2;
        SpecialEffectsController.Operation operation9 = operation7;
        ArrayList<View> arrayList13 = arrayList7;
        Rect rect3 = rect2;
        k0 k0Var3 = k0Var2;
        SpecialEffectsController.Operation operation10 = operation8;
        View view14 = view6;
        ArrayList arrayList14 = new ArrayList();
        Iterator<m> it7 = list.iterator();
        Object obj4 = null;
        Object objK2 = null;
        while (it7.hasNext()) {
            m next3 = it7.next();
            if (next3.d()) {
                map.put(next3.b(), Boolean.FALSE);
                next3.a();
            } else {
                Object objF = k0Var3.f(next3.h());
                SpecialEffectsController.Operation operationB = next3.b();
                boolean z13 = obj3 != null && (operationB == operation9 || operationB == operation10);
                if (objF == null) {
                    if (!z13) {
                        map.put(operationB, Boolean.FALSE);
                        next3.a();
                    }
                    arrayList2 = arrayList12;
                    arrayList = arrayList13;
                    it2 = it7;
                    view = view14;
                    objK = obj4;
                    operation3 = operation10;
                    view2 = view13;
                } else {
                    it2 = it7;
                    ArrayList<View> arrayList15 = new ArrayList<>();
                    Object obj5 = obj4;
                    bVar3.t(arrayList15, operationB.f().C1);
                    if (z13) {
                        if (operationB == operation9) {
                            arrayList15.removeAll(arrayList13);
                        } else {
                            arrayList15.removeAll(arrayList12);
                        }
                    }
                    if (arrayList15.isEmpty()) {
                        k0Var3.a(objF, view14);
                        arrayList2 = arrayList12;
                        arrayList = arrayList13;
                        view = view14;
                        operation4 = operationB;
                        obj2 = objK2;
                        operation3 = operation10;
                        obj = obj5;
                    } else {
                        k0Var3.b(objF, arrayList15);
                        view = view14;
                        obj = obj5;
                        arrayList = arrayList13;
                        obj2 = objK2;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        k0Var3.p(objF, objF, arrayList15, null, null, null, null);
                        if (operationB.e() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operationB;
                            list2.remove(operation4);
                            ArrayList<View> arrayList16 = new ArrayList<>(arrayList15);
                            arrayList16.remove(operation4.f().C1);
                            k0Var3.o(objF, operation4.f().C1, arrayList16);
                            androidx.core.view.n0.a(m(), bVar3.new i(arrayList15));
                        } else {
                            operation4 = operationB;
                        }
                    }
                    if (operation4.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList14.addAll(arrayList15);
                        if (z12) {
                            k0Var3.q(objF, rect3);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        k0Var3.r(objF, view2);
                    }
                    map.put(operation4, Boolean.TRUE);
                    if (next3.j()) {
                        objK2 = k0Var3.k(obj2, objF, null);
                        objK = obj;
                    } else {
                        objK = k0Var3.k(obj, objF, null);
                        objK2 = obj2;
                    }
                }
                operation10 = operation3;
                obj4 = objK;
                view13 = view2;
                view14 = view;
                arrayList13 = arrayList;
                arrayList12 = arrayList2;
                it7 = it2;
            }
        }
        ArrayList<View> arrayList17 = arrayList12;
        ArrayList<View> arrayList18 = arrayList13;
        SpecialEffectsController.Operation operation11 = operation10;
        Object objJ = k0Var3.j(objK2, obj4, obj3);
        if (objJ == null) {
            return map;
        }
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object objH = mVar4.h();
                SpecialEffectsController.Operation operationB2 = mVar4.b();
                boolean z14 = obj3 != null && (operationB2 == operation9 || operationB2 == operation11);
                if (objH != null || z14) {
                    if (u0.U0(m())) {
                        k0Var3.s(mVar4.b().f(), objJ, mVar4.c(), bVar3.new j(mVar4, operationB2));
                    } else {
                        if (FragmentManager.W0(2)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("SpecialEffectsController: Container ");
                            sb6.append(m());
                            sb6.append(" has not been laid out. Completing operation ");
                            sb6.append(operationB2);
                        }
                        mVar4.a();
                    }
                }
            }
        }
        if (!u0.U0(m())) {
            return map;
        }
        i0.e(arrayList14, 4);
        ArrayList<String> arrayListL = k0Var3.l(arrayList17);
        if (FragmentManager.W0(2)) {
            for (View view15 : arrayList18) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("View: ");
                sb7.append(view15);
                sb7.append(" Name: ");
                sb7.append(u0.x0(view15));
            }
            for (View view16 : arrayList17) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("View: ");
                sb8.append(view16);
                sb8.append(" Name: ");
                sb8.append(u0.x0(view16));
            }
        }
        k0Var3.c(m(), objJ);
        k0Var3.t(m(), arrayList18, arrayList17, arrayListL, aVar5);
        i0.e(arrayList14, 0);
        k0Var3.v(obj3, arrayList18, arrayList17);
        return map;
    }

    public final void y(@g.n0 List<SpecialEffectsController.Operation> list) {
        Fragment fragmentF = list.get(list.size() - 1).f();
        for (SpecialEffectsController.Operation operation : list) {
            operation.f().C2.f5692c = fragmentF.C2.f5692c;
            operation.f().C2.f5693d = fragmentF.C2.f5693d;
            operation.f().C2.f5694e = fragmentF.C2.f5694e;
            operation.f().C2.f5695f = fragmentF.C2.f5695f;
        }
    }
}
