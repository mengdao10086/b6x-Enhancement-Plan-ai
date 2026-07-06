package a;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class is extends as {
    public int b;
    public ArrayList<as> q = new ArrayList<>();
    public boolean e = true;
    public boolean f = false;
    public int c = 0;

    @Override // a.as
    public void N(View view) {
        super.N(view);
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).N(view);
        }
    }

    @Override // a.as
    public void R(View view) {
        super.R(view);
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).R(view);
        }
    }

    @Override // a.as
    public void T() {
        if (this.q.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.e) {
            Iterator<as> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().T();
            }
            return;
        }
        for (int i = 1; i < this.q.size(); i++) {
            this.q.get(i - 1).a(new gs(this, this.q.get(i)));
        }
        as asVar = this.q.get(0);
        if (asVar != null) {
            asVar.T();
        }
    }

    @Override // a.as
    public /* bridge */ /* synthetic */ as U(long j) {
        k0(j);
        return this;
    }

    @Override // a.as
    public void V(yr yrVar) {
        super.V(yrVar);
        this.c |= 8;
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).V(yrVar);
        }
    }

    @Override // a.as
    public void X(or orVar) {
        super.X(orVar);
        this.c |= 4;
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.get(i).X(orVar);
            }
        }
    }

    @Override // a.as
    public void Y(fs fsVar) {
        super.Y(fsVar);
        this.c |= 2;
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).Y(fsVar);
        }
    }

    @Override // a.as
    public String b0(String str) {
        String strB0 = super.b0(str);
        for (int i = 0; i < this.q.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strB0);
            sb.append("\n");
            sb.append(this.q.get(i).b0(str + "  "));
            strB0 = sb.toString();
        }
        return strB0;
    }

    @Override // a.as
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public is a(zr zrVar) {
        super.a(zrVar);
        return this;
    }

    @Override // a.as
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public is b(View view) {
        for (int i = 0; i < this.q.size(); i++) {
            this.q.get(i).b(view);
        }
        super.b(view);
        return this;
    }

    public is e0(as asVar) {
        f0(asVar);
        long j = ((as) this).f129b;
        if (j >= 0) {
            asVar.U(j);
        }
        if ((this.c & 1) != 0) {
            asVar.W(s());
        }
        if ((this.c & 2) != 0) {
            asVar.Y(w());
        }
        if ((this.c & 4) != 0) {
            asVar.X(v());
        }
        if ((this.c & 8) != 0) {
            asVar.V(r());
        }
        return this;
    }

    @Override // a.as
    public void f() {
        super.f();
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).f();
        }
    }

    public final void f0(as asVar) {
        this.q.add(asVar);
        asVar.f121a = this;
    }

    @Override // a.as
    public void g(ks ksVar) {
        if (G(ksVar.f6635a)) {
            for (as asVar : this.q) {
                if (asVar.G(ksVar.f6635a)) {
                    asVar.g(ksVar);
                    ksVar.f1685a.add(asVar);
                }
            }
        }
    }

    public as g0(int i) {
        if (i < 0 || i >= this.q.size()) {
            return null;
        }
        return this.q.get(i);
    }

    public int h0() {
        return this.q.size();
    }

    @Override // a.as
    public void i(ks ksVar) {
        super.i(ksVar);
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i).i(ksVar);
        }
    }

    @Override // a.as
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public is P(zr zrVar) {
        super.P(zrVar);
        return this;
    }

    @Override // a.as
    public void j(ks ksVar) {
        if (G(ksVar.f6635a)) {
            for (as asVar : this.q) {
                if (asVar.G(ksVar.f6635a)) {
                    asVar.j(ksVar);
                    ksVar.f1685a.add(asVar);
                }
            }
        }
    }

    @Override // a.as
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public is Q(View view) {
        for (int i = 0; i < this.q.size(); i++) {
            this.q.get(i).Q(view);
        }
        super.Q(view);
        return this;
    }

    public is k0(long j) {
        ArrayList<as> arrayList;
        super.U(j);
        if (((as) this).f129b >= 0 && (arrayList = this.q) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.q.get(i).U(j);
            }
        }
        return this;
    }

    @Override // a.as
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public is W(TimeInterpolator timeInterpolator) {
        this.c |= 1;
        ArrayList<as> arrayList = this.q;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.q.get(i).W(timeInterpolator);
            }
        }
        super.W(timeInterpolator);
        return this;
    }

    @Override // a.as
    /* JADX INFO: renamed from: m */
    public as clone() {
        is isVar = (is) super.clone();
        isVar.q = new ArrayList<>();
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            isVar.f0(this.q.get(i).clone());
        }
        return isVar;
    }

    public is m0(int i) {
        if (i == 0) {
            this.e = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.e = false;
        }
        return this;
    }

    @Override // a.as
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public is Z(long j) {
        super.Z(j);
        return this;
    }

    @Override // a.as
    public void o(ViewGroup viewGroup, ls lsVar, ls lsVar2, ArrayList<ks> arrayList, ArrayList<ks> arrayList2) {
        long jY = y();
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            as asVar = this.q.get(i);
            if (jY > 0 && (this.e || i == 0)) {
                long jY2 = asVar.y();
                if (jY2 > 0) {
                    asVar.Z(jY2 + jY);
                } else {
                    asVar.Z(jY);
                }
            }
            asVar.o(viewGroup, lsVar, lsVar2, arrayList, arrayList2);
        }
    }

    public final void o0() {
        hs hsVar = new hs(this);
        Iterator<as> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().a(hsVar);
        }
        this.b = this.q.size();
    }
}
