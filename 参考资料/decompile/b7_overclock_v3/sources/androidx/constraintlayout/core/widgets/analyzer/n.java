package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.blankj.utilcode.util.i0;
import com.umeng.socialize.utils.DeviceConfigInternal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f3373g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f3374h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3376b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3378d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f3375a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3377c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<a> f3379e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3380f = -1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<ConstraintWidget> f3381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3386f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3387g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.core.d dVar, int i10) {
            this.f3381a = new WeakReference<>(constraintWidget);
            this.f3382b = dVar.O(constraintWidget.Q);
            this.f3383c = dVar.O(constraintWidget.R);
            this.f3384d = dVar.O(constraintWidget.S);
            this.f3385e = dVar.O(constraintWidget.T);
            this.f3386f = dVar.O(constraintWidget.U);
            this.f3387g = i10;
        }

        public void a() {
            ConstraintWidget constraintWidget = this.f3381a.get();
            if (constraintWidget != null) {
                constraintWidget.p1(this.f3382b, this.f3383c, this.f3384d, this.f3385e, this.f3386f, this.f3387g);
            }
        }
    }

    public n(int i10) {
        int i11 = f3374h;
        f3374h = i11 + 1;
        this.f3376b = i11;
        this.f3378d = i10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f3375a.contains(constraintWidget)) {
            return false;
        }
        this.f3375a.add(constraintWidget);
        return true;
    }

    public void b() {
        if (this.f3379e != null && this.f3377c) {
            for (int i10 = 0; i10 < this.f3379e.size(); i10++) {
                this.f3379e.get(i10).a();
            }
        }
    }

    public void c(ArrayList<n> arrayList) {
        int size = this.f3375a.size();
        if (this.f3380f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                n nVar = arrayList.get(i10);
                if (this.f3380f == nVar.f3376b) {
                    m(this.f3378d, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void d() {
        this.f3375a.clear();
    }

    public final boolean e(ConstraintWidget constraintWidget) {
        return this.f3375a.contains(constraintWidget);
    }

    public int f() {
        return this.f3376b;
    }

    public int g() {
        return this.f3378d;
    }

    public final String h() {
        int i10 = this.f3378d;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : DeviceConfigInternal.UNKNOW;
    }

    public boolean i(n nVar) {
        for (int i10 = 0; i10 < this.f3375a.size(); i10++) {
            if (nVar.e(this.f3375a.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return this.f3377c;
    }

    public final int k(int i10, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviourZ = constraintWidget.z(i10);
        if (dimensionBehaviourZ == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviourZ == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviourZ == ConstraintWidget.DimensionBehaviour.FIXED) {
            return i10 == 0 ? constraintWidget.m0() : constraintWidget.D();
        }
        return -1;
    }

    public int l(androidx.constraintlayout.core.d dVar, int i10) {
        if (this.f3375a.size() == 0) {
            return 0;
        }
        return q(dVar, this.f3375a, i10);
    }

    public void m(int i10, n nVar) {
        for (ConstraintWidget constraintWidget : this.f3375a) {
            nVar.a(constraintWidget);
            if (i10 == 0) {
                constraintWidget.S0 = nVar.f();
            } else {
                constraintWidget.T0 = nVar.f();
            }
        }
        this.f3380f = nVar.f3376b;
    }

    public void n(boolean z10) {
        this.f3377c = z10;
    }

    public void o(int i10) {
        this.f3378d = i10;
    }

    public int p() {
        return this.f3375a.size();
    }

    public final int q(androidx.constraintlayout.core.d dVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int iO;
        int iO2;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) arrayList.get(0).U();
        dVar.Y();
        dVar2.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(dVar, false);
        }
        if (i10 == 0 && dVar2.M1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 0);
        }
        if (i10 == 1 && dVar2.N1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.T();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f3379e = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f3379e.add(new a(arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            iO = dVar.O(dVar2.Q);
            iO2 = dVar.O(dVar2.S);
            dVar.Y();
        } else {
            iO = dVar.O(dVar2.R);
            iO2 = dVar.O(dVar2.T);
            dVar.Y();
        }
        return iO2 - iO;
    }

    public String toString() {
        String str = h() + " [" + this.f3376b + "] <";
        Iterator<ConstraintWidget> it2 = this.f3375a.iterator();
        while (it2.hasNext()) {
            str = str + i0.f11861z + it2.next().y();
        }
        return str + " >";
    }
}
