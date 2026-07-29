package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.transition.q;
import com.bumptech.glide.load.engine.GlideException;
import g.d0;
import g.n0;
import g.p0;
import g2.r;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class v extends q {
    public static final int R7 = 1;
    public static final int S7 = 2;
    public static final int T7 = 4;
    public static final int U7 = 8;
    public static final int V7 = 0;
    public static final int W7 = 1;
    public ArrayList<q> M7;
    public boolean N7;
    public int O7;
    public boolean P7;
    public int Q7;

    public class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f8004a;

        public a(q qVar) {
            this.f8004a = qVar;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            this.f8004a.w0();
            qVar.p0(this);
        }
    }

    public static class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v f8006a;

        public b(v vVar) {
            this.f8006a = vVar;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void a(@n0 q qVar) {
            v vVar = this.f8006a;
            if (vVar.P7) {
                return;
            }
            vVar.F0();
            this.f8006a.P7 = true;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            v vVar = this.f8006a;
            int i10 = vVar.O7 - 1;
            vVar.O7 = i10;
            if (i10 == 0) {
                vVar.P7 = false;
                vVar.s();
            }
            qVar.p0(this);
        }
    }

    public v() {
        this.M7 = new ArrayList<>();
        this.N7 = true;
        this.P7 = false;
        this.Q7 = 0;
    }

    @Override // androidx.transition.q
    @n0
    public q A(@n0 View view, boolean z10) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).A(view, z10);
        }
        return super.A(view, z10);
    }

    @Override // androidx.transition.q
    @n0
    public q B(@n0 Class<?> cls, boolean z10) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).B(cls, z10);
        }
        return super.B(cls, z10);
    }

    @Override // androidx.transition.q
    @n0
    public q C(@n0 String str, boolean z10) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).C(str, z10);
        }
        return super.C(str, z10);
    }

    @Override // androidx.transition.q
    public void C0(g2.k kVar) {
        super.C0(kVar);
        this.Q7 |= 4;
        if (this.M7 != null) {
            for (int i10 = 0; i10 < this.M7.size(); i10++) {
                this.M7.get(i10).C0(kVar);
            }
        }
    }

    @Override // androidx.transition.q
    public void D0(g2.p pVar) {
        super.D0(pVar);
        this.Q7 |= 2;
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).D0(pVar);
        }
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void F(ViewGroup viewGroup) {
        super.F(viewGroup);
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).F(viewGroup);
        }
    }

    @Override // androidx.transition.q
    public String G0(String str) {
        String strG0 = super.G0(str);
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strG0);
            sb2.append("\n");
            sb2.append(this.M7.get(i10).G0(str + GlideException.a.f12263d));
            strG0 = sb2.toString();
        }
        return strG0;
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public v a(@n0 q.h hVar) {
        return (v) super.a(hVar);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public v b(@d0 int i10) {
        for (int i11 = 0; i11 < this.M7.size(); i11++) {
            this.M7.get(i11).b(i10);
        }
        return (v) super.b(i10);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public v c(@n0 View view) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).c(view);
        }
        return (v) super.c(view);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public v d(@n0 Class<?> cls) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).d(cls);
        }
        return (v) super.d(cls);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public v e(@n0 String str) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).e(str);
        }
        return (v) super.e(str);
    }

    @n0
    public v M0(@n0 q qVar) {
        N0(qVar);
        long j10 = this.f7958c;
        if (j10 >= 0) {
            qVar.y0(j10);
        }
        if ((this.Q7 & 1) != 0) {
            qVar.A0(J());
        }
        if ((this.Q7 & 2) != 0) {
            qVar.D0(O());
        }
        if ((this.Q7 & 4) != 0) {
            qVar.C0(N());
        }
        if ((this.Q7 & 8) != 0) {
            qVar.z0(I());
        }
        return this;
    }

    public final void N0(@n0 q qVar) {
        this.M7.add(qVar);
        qVar.f7974r = this;
    }

    public int O0() {
        return !this.N7 ? 1 : 0;
    }

    @p0
    public q P0(int i10) {
        if (i10 < 0 || i10 >= this.M7.size()) {
            return null;
        }
        return this.M7.get(i10);
    }

    public int Q0() {
        return this.M7.size();
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public v p0(@n0 q.h hVar) {
        return (v) super.p0(hVar);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public v q0(@d0 int i10) {
        for (int i11 = 0; i11 < this.M7.size(); i11++) {
            this.M7.get(i11).q0(i10);
        }
        return (v) super.q0(i10);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public v r0(@n0 View view) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).r0(view);
        }
        return (v) super.r0(view);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public v s0(@n0 Class<?> cls) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).s0(cls);
        }
        return (v) super.s0(cls);
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public v t0(@n0 String str) {
        for (int i10 = 0; i10 < this.M7.size(); i10++) {
            this.M7.get(i10).t0(str);
        }
        return (v) super.t0(str);
    }

    @n0
    public v W0(@n0 q qVar) {
        this.M7.remove(qVar);
        qVar.f7974r = null;
        return this;
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public v y0(long j10) {
        ArrayList<q> arrayList;
        super.y0(j10);
        if (this.f7958c >= 0 && (arrayList = this.M7) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.M7.get(i10).y0(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public v A0(@p0 TimeInterpolator timeInterpolator) {
        this.Q7 |= 1;
        ArrayList<q> arrayList = this.M7;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.M7.get(i10).A0(timeInterpolator);
            }
        }
        return (v) super.A0(timeInterpolator);
    }

    @n0
    public v Z0(int i10) {
        if (i10 == 0) {
            this.N7 = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
            this.N7 = false;
        }
        return this;
    }

    @Override // androidx.transition.q
    @n0
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public v E0(long j10) {
        return (v) super.E0(j10);
    }

    public final void b1() {
        b bVar = new b(this);
        Iterator<q> it2 = this.M7.iterator();
        while (it2.hasNext()) {
            it2.next().a(bVar);
        }
        this.O7 = this.M7.size();
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).cancel();
        }
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        if (f0(qVar.f28973b)) {
            for (q qVar2 : this.M7) {
                if (qVar2.f0(qVar.f28973b)) {
                    qVar2.j(qVar);
                    qVar.f28974c.add(qVar2);
                }
            }
        }
    }

    @Override // androidx.transition.q
    public void l(g2.q qVar) {
        super.l(qVar);
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).l(qVar);
        }
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        if (f0(qVar.f28973b)) {
            for (q qVar2 : this.M7) {
                if (qVar2.f0(qVar.f28973b)) {
                    qVar2.m(qVar);
                    qVar.f28974c.add(qVar2);
                }
            }
        }
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n0(View view) {
        super.n0(view);
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).n0(view);
        }
    }

    @Override // androidx.transition.q
    /* JADX INFO: renamed from: p */
    public q clone() {
        v vVar = (v) super.clone();
        vVar.M7 = new ArrayList<>();
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            vVar.N0(this.M7.get(i10).clone());
        }
        return vVar;
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void r(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<g2.q> arrayList, ArrayList<g2.q> arrayList2) {
        long jQ = Q();
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            q qVar = this.M7.get(i10);
            if (jQ > 0 && (this.N7 || i10 == 0)) {
                long jQ2 = qVar.Q();
                if (jQ2 > 0) {
                    qVar.E0(jQ2 + jQ);
                } else {
                    qVar.E0(jQ);
                }
            }
            qVar.r(viewGroup, rVar, rVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void u0(View view) {
        super.u0(view);
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).u0(view);
        }
    }

    @Override // androidx.transition.q
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void w0() {
        if (this.M7.isEmpty()) {
            F0();
            s();
            return;
        }
        b1();
        if (this.N7) {
            Iterator<q> it2 = this.M7.iterator();
            while (it2.hasNext()) {
                it2.next().w0();
            }
            return;
        }
        for (int i10 = 1; i10 < this.M7.size(); i10++) {
            this.M7.get(i10 - 1).a(new a(this.M7.get(i10)));
        }
        q qVar = this.M7.get(0);
        if (qVar != null) {
            qVar.w0();
        }
    }

    @Override // androidx.transition.q
    public void x0(boolean z10) {
        super.x0(z10);
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).x0(z10);
        }
    }

    @Override // androidx.transition.q
    @n0
    public q y(int i10, boolean z10) {
        for (int i11 = 0; i11 < this.M7.size(); i11++) {
            this.M7.get(i11).y(i10, z10);
        }
        return super.y(i10, z10);
    }

    @Override // androidx.transition.q
    public void z0(q.f fVar) {
        super.z0(fVar);
        this.Q7 |= 8;
        int size = this.M7.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M7.get(i10).z0(fVar);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public v(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M7 = new ArrayList<>();
        this.N7 = true;
        this.P7 = false;
        this.Q7 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7926i);
        Z0(j0.n.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
