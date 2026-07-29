package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.os.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.k0;
import androidx.transition.q;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class j extends k0 {

    public class a extends q.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f7878a;

        public a(Rect rect) {
            this.f7878a = rect;
        }

        @Override // androidx.transition.q.f
        public Rect a(@n0 q qVar) {
            return this.f7878a;
        }
    }

    public class b implements q.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7881b;

        public b(View view, ArrayList arrayList) {
            this.f7880a = view;
            this.f7881b = arrayList;
        }

        @Override // androidx.transition.q.h
        public void a(@n0 q qVar) {
            qVar.p0(this);
            qVar.a(this);
        }

        @Override // androidx.transition.q.h
        public void b(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void c(@n0 q qVar) {
            qVar.p0(this);
            this.f7880a.setVisibility(8);
            int size = this.f7881b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f7881b.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.q.h
        public void d(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void e(@n0 q qVar) {
        }
    }

    public class c extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f7883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f7885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f7887e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7888f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f7883a = obj;
            this.f7884b = arrayList;
            this.f7885c = obj2;
            this.f7886d = arrayList2;
            this.f7887e = obj3;
            this.f7888f = arrayList3;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void a(@n0 q qVar) {
            Object obj = this.f7883a;
            if (obj != null) {
                j.this.n(obj, this.f7884b, null);
            }
            Object obj2 = this.f7885c;
            if (obj2 != null) {
                j.this.n(obj2, this.f7886d, null);
            }
            Object obj3 = this.f7887e;
            if (obj3 != null) {
                j.this.n(obj3, this.f7888f, null);
            }
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            qVar.p0(this);
        }
    }

    public class d implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f7890a;

        public d(q qVar) {
            this.f7890a = qVar;
        }

        @Override // androidx.core.os.f.b
        public void onCancel() {
            this.f7890a.cancel();
        }
    }

    public class e implements q.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f7892a;

        public e(Runnable runnable) {
            this.f7892a = runnable;
        }

        @Override // androidx.transition.q.h
        public void a(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void b(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void c(@n0 q qVar) {
            this.f7892a.run();
        }

        @Override // androidx.transition.q.h
        public void d(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void e(@n0 q qVar) {
        }
    }

    public class f extends q.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f7894a;

        public f(Rect rect) {
            this.f7894a = rect;
        }

        @Override // androidx.transition.q.f
        public Rect a(@n0 q qVar) {
            Rect rect = this.f7894a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f7894a;
        }
    }

    public static boolean x(q qVar) {
        return (k0.i(qVar.R()) && k0.i(qVar.S()) && k0.i(qVar.V())) ? false : true;
    }

    @Override // androidx.fragment.app.k0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((q) obj).c(view);
        }
    }

    @Override // androidx.fragment.app.k0
    public void b(Object obj, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        if (qVar == null) {
            return;
        }
        int i10 = 0;
        if (qVar instanceof v) {
            v vVar = (v) qVar;
            int iQ0 = vVar.Q0();
            while (i10 < iQ0) {
                b(vVar.P0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (x(qVar) || !k0.i(qVar.Y())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            qVar.c(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.k0
    public void c(ViewGroup viewGroup, Object obj) {
        u.b(viewGroup, (q) obj);
    }

    @Override // androidx.fragment.app.k0
    public boolean e(Object obj) {
        return obj instanceof q;
    }

    @Override // androidx.fragment.app.k0
    public Object f(Object obj) {
        if (obj != null) {
            return ((q) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.k0
    public Object j(Object obj, Object obj2, Object obj3) {
        q qVarZ0 = (q) obj;
        q qVar = (q) obj2;
        q qVar2 = (q) obj3;
        if (qVarZ0 != null && qVar != null) {
            qVarZ0 = new v().M0(qVarZ0).M0(qVar).Z0(1);
        } else if (qVarZ0 == null) {
            qVarZ0 = qVar != null ? qVar : null;
        }
        if (qVar2 == null) {
            return qVarZ0;
        }
        v vVar = new v();
        if (qVarZ0 != null) {
            vVar.M0(qVarZ0);
        }
        vVar.M0(qVar2);
        return vVar;
    }

    @Override // androidx.fragment.app.k0
    public Object k(Object obj, Object obj2, Object obj3) {
        v vVar = new v();
        if (obj != null) {
            vVar.M0((q) obj);
        }
        if (obj2 != null) {
            vVar.M0((q) obj2);
        }
        if (obj3 != null) {
            vVar.M0((q) obj3);
        }
        return vVar;
    }

    @Override // androidx.fragment.app.k0
    public void m(Object obj, View view) {
        if (obj != null) {
            ((q) obj).r0(view);
        }
    }

    @Override // androidx.fragment.app.k0
    public void n(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        int i10 = 0;
        if (qVar instanceof v) {
            v vVar = (v) qVar;
            int iQ0 = vVar.Q0();
            while (i10 < iQ0) {
                n(vVar.P0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (x(qVar)) {
            return;
        }
        List<View> listY = qVar.Y();
        if (listY.size() == arrayList.size() && listY.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                qVar.c(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                qVar.r0(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.k0
    public void o(Object obj, View view, ArrayList<View> arrayList) {
        ((q) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.k0
    public void p(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((q) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.k0
    public void q(Object obj, Rect rect) {
        if (obj != null) {
            ((q) obj).z0(new f(rect));
        }
    }

    @Override // androidx.fragment.app.k0
    public void r(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((q) obj).z0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.k0
    public void s(@n0 Fragment fragment, @n0 Object obj, @n0 androidx.core.os.f fVar, @n0 Runnable runnable) {
        q qVar = (q) obj;
        fVar.d(new d(qVar));
        qVar.a(new e(runnable));
    }

    @Override // androidx.fragment.app.k0
    public void u(Object obj, View view, ArrayList<View> arrayList) {
        v vVar = (v) obj;
        List<View> listY = vVar.Y();
        listY.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k0.d(listY, arrayList.get(i10));
        }
        listY.add(view);
        arrayList.add(view);
        b(vVar, arrayList);
    }

    @Override // androidx.fragment.app.k0
    public void v(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        v vVar = (v) obj;
        if (vVar != null) {
            vVar.Y().clear();
            vVar.Y().addAll(arrayList2);
            n(vVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.k0
    public Object w(Object obj) {
        if (obj == null) {
            return null;
        }
        v vVar = new v();
        vVar.M0((q) obj);
        return vVar;
    }
}
