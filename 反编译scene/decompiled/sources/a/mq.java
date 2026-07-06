package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mq {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ia<RecyclerView.d0, lq> f1978a = new ia<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa<RecyclerView.d0> f6833a = new fa<>();

    public interface a {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    public void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        lq lqVarB = this.f1978a.get(d0Var);
        if (lqVarB == null) {
            lqVarB = lq.b();
            this.f1978a.put(d0Var, lqVarB);
        }
        lqVarB.f1844a |= 2;
        lqVarB.f1845a = bVar;
    }

    public void b(RecyclerView.d0 d0Var) {
        lq lqVarB = this.f1978a.get(d0Var);
        if (lqVarB == null) {
            lqVarB = lq.b();
            this.f1978a.put(d0Var, lqVarB);
        }
        lqVarB.f1844a |= 1;
    }

    public void c(long j, RecyclerView.d0 d0Var) {
        this.f6833a.i(j, d0Var);
    }

    public void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        lq lqVarB = this.f1978a.get(d0Var);
        if (lqVarB == null) {
            lqVarB = lq.b();
            this.f1978a.put(d0Var, lqVarB);
        }
        lqVarB.b = bVar;
        lqVarB.f1844a |= 8;
    }

    public void e(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        lq lqVarB = this.f1978a.get(d0Var);
        if (lqVarB == null) {
            lqVarB = lq.b();
            this.f1978a.put(d0Var, lqVarB);
        }
        lqVarB.f1845a = bVar;
        lqVarB.f1844a |= 4;
    }

    public void f() {
        this.f1978a.clear();
        this.f6833a.b();
    }

    public RecyclerView.d0 g(long j) {
        return this.f6833a.e(j);
    }

    public boolean h(RecyclerView.d0 d0Var) {
        lq lqVar = this.f1978a.get(d0Var);
        return (lqVar == null || (lqVar.f1844a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.d0 d0Var) {
        lq lqVar = this.f1978a.get(d0Var);
        return (lqVar == null || (lqVar.f1844a & 4) == 0) ? false : true;
    }

    public void j() {
        lq.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    public final RecyclerView.l.b l(RecyclerView.d0 d0Var, int i) {
        lq lqVarM;
        RecyclerView.l.b bVar;
        int iF = this.f1978a.f(d0Var);
        if (iF >= 0 && (lqVarM = this.f1978a.m(iF)) != null) {
            int i2 = lqVarM.f1844a;
            if ((i2 & i) != 0) {
                lqVarM.f1844a = (~i) & i2;
                if (i == 4) {
                    bVar = lqVarM.f1845a;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = lqVarM.b;
                }
                if ((lqVarM.f1844a & 12) == 0) {
                    this.f1978a.k(iF);
                    lq.c(lqVarM);
                }
                return bVar;
            }
        }
        return null;
    }

    public RecyclerView.l.b m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    public RecyclerView.l.b n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(a.mq.a r7) {
        /*
            r6 = this;
            a.ia<androidx.recyclerview.widget.RecyclerView$d0, a.lq> r0 = r6.f1978a
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L8:
            if (r0 < 0) goto L63
            a.ia<androidx.recyclerview.widget.RecyclerView$d0, a.lq> r1 = r6.f1978a
            java.lang.Object r1 = r1.i(r0)
            androidx.recyclerview.widget.RecyclerView$d0 r1 = (androidx.recyclerview.widget.RecyclerView.d0) r1
            a.ia<androidx.recyclerview.widget.RecyclerView$d0, a.lq> r2 = r6.f1978a
            java.lang.Object r2 = r2.k(r0)
            a.lq r2 = (a.lq) r2
            int r3 = r2.f1844a
            r4 = r3 & 3
            r5 = 3
            if (r4 != r5) goto L25
        L21:
            r7.a(r1)
            goto L5d
        L25:
            r4 = r3 & 1
            if (r4 == 0) goto L34
            androidx.recyclerview.widget.RecyclerView$l$b r3 = r2.f1845a
            if (r3 != 0) goto L2e
            goto L21
        L2e:
            androidx.recyclerview.widget.RecyclerView$l$b r4 = r2.b
        L30:
            r7.d(r1, r3, r4)
            goto L5d
        L34:
            r4 = r3 & 14
            r5 = 14
            if (r4 != r5) goto L42
        L3a:
            androidx.recyclerview.widget.RecyclerView$l$b r3 = r2.f1845a
            androidx.recyclerview.widget.RecyclerView$l$b r4 = r2.b
            r7.b(r1, r3, r4)
            goto L5d
        L42:
            r4 = r3 & 12
            r5 = 12
            if (r4 != r5) goto L50
            androidx.recyclerview.widget.RecyclerView$l$b r3 = r2.f1845a
            androidx.recyclerview.widget.RecyclerView$l$b r4 = r2.b
            r7.c(r1, r3, r4)
            goto L5d
        L50:
            r4 = r3 & 4
            if (r4 == 0) goto L58
            androidx.recyclerview.widget.RecyclerView$l$b r3 = r2.f1845a
            r4 = 0
            goto L30
        L58:
            r3 = r3 & 8
            if (r3 == 0) goto L5d
            goto L3a
        L5d:
            a.lq.c(r2)
            int r0 = r0 + (-1)
            goto L8
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.mq.o(a.mq$a):void");
    }

    public void p(RecyclerView.d0 d0Var) {
        lq lqVar = this.f1978a.get(d0Var);
        if (lqVar == null) {
            return;
        }
        lqVar.f1844a &= -2;
    }

    public void q(RecyclerView.d0 d0Var) {
        int iL = this.f6833a.l() - 1;
        while (true) {
            if (iL < 0) {
                break;
            }
            if (d0Var == this.f6833a.m(iL)) {
                this.f6833a.k(iL);
                break;
            }
            iL--;
        }
        lq lqVarRemove = this.f1978a.remove(d0Var);
        if (lqVarRemove != null) {
            lq.c(lqVarRemove);
        }
    }
}
