package androidx.recyclerview.widget;

import androidx.core.util.n;
import androidx.recyclerview.widget.RecyclerView;
import g.i1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7013c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @i1
    public final androidx.collection.l<RecyclerView.e0, a> f7014a = new androidx.collection.l<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i1
    public final androidx.collection.h<RecyclerView.e0> f7015b = new androidx.collection.h<>();

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7016d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f7017e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7018f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7019g = 8;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7020h = 3;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7021i = 12;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f7022j = 14;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static n.a<a> f7023k = new n.b(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public RecyclerView.l.d f7025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public RecyclerView.l.d f7026c;

        public static void a() {
            while (f7023k.a() != null) {
            }
        }

        public static a b() {
            a aVarA = f7023k.a();
            return aVarA == null ? new a() : aVarA;
        }

        public static void c(a aVar) {
            aVar.f7024a = 0;
            aVar.f7025b = null;
            aVar.f7026c = null;
            f7023k.b(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.e0 e0Var);

        void b(RecyclerView.e0 e0Var, @p0 RecyclerView.l.d dVar, RecyclerView.l.d dVar2);

        void c(RecyclerView.e0 e0Var, @n0 RecyclerView.l.d dVar, @p0 RecyclerView.l.d dVar2);

        void d(RecyclerView.e0 e0Var, @n0 RecyclerView.l.d dVar, @n0 RecyclerView.l.d dVar2);
    }

    public void a(RecyclerView.e0 e0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f7014a.get(e0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f7014a.put(e0Var, aVarB);
        }
        aVarB.f7024a |= 2;
        aVarB.f7025b = dVar;
    }

    public void b(RecyclerView.e0 e0Var) {
        a aVarB = this.f7014a.get(e0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f7014a.put(e0Var, aVarB);
        }
        aVarB.f7024a |= 1;
    }

    public void c(long j10, RecyclerView.e0 e0Var) {
        this.f7015b.n(j10, e0Var);
    }

    public void d(RecyclerView.e0 e0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f7014a.get(e0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f7014a.put(e0Var, aVarB);
        }
        aVarB.f7026c = dVar;
        aVarB.f7024a |= 8;
    }

    public void e(RecyclerView.e0 e0Var, RecyclerView.l.d dVar) {
        a aVarB = this.f7014a.get(e0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f7014a.put(e0Var, aVarB);
        }
        aVarB.f7025b = dVar;
        aVarB.f7024a |= 4;
    }

    public void f() {
        this.f7014a.clear();
        this.f7015b.b();
    }

    public RecyclerView.e0 g(long j10) {
        return this.f7015b.h(j10);
    }

    public boolean h(RecyclerView.e0 e0Var) {
        a aVar = this.f7014a.get(e0Var);
        return (aVar == null || (aVar.f7024a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.e0 e0Var) {
        a aVar = this.f7014a.get(e0Var);
        return (aVar == null || (aVar.f7024a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.e0 e0Var) {
        p(e0Var);
    }

    public final RecyclerView.l.d l(RecyclerView.e0 e0Var, int i10) {
        a aVarO;
        RecyclerView.l.d dVar;
        int iG = this.f7014a.g(e0Var);
        if (iG >= 0 && (aVarO = this.f7014a.o(iG)) != null) {
            int i11 = aVarO.f7024a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                aVarO.f7024a = i12;
                if (i10 == 4) {
                    dVar = aVarO.f7025b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    dVar = aVarO.f7026c;
                }
                if ((i12 & 12) == 0) {
                    this.f7014a.m(iG);
                    a.c(aVarO);
                }
                return dVar;
            }
        }
        return null;
    }

    @p0
    public RecyclerView.l.d m(RecyclerView.e0 e0Var) {
        return l(e0Var, 8);
    }

    @p0
    public RecyclerView.l.d n(RecyclerView.e0 e0Var) {
        return l(e0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f7014a.size() - 1; size >= 0; size--) {
            RecyclerView.e0 e0VarK = this.f7014a.k(size);
            a aVarM = this.f7014a.m(size);
            int i10 = aVarM.f7024a;
            if ((i10 & 3) == 3) {
                bVar.a(e0VarK);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.d dVar = aVarM.f7025b;
                if (dVar == null) {
                    bVar.a(e0VarK);
                } else {
                    bVar.c(e0VarK, dVar, aVarM.f7026c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(e0VarK, aVarM.f7025b, aVarM.f7026c);
            } else if ((i10 & 12) == 12) {
                bVar.d(e0VarK, aVarM.f7025b, aVarM.f7026c);
            } else if ((i10 & 4) != 0) {
                bVar.c(e0VarK, aVarM.f7025b, null);
            } else if ((i10 & 8) != 0) {
                bVar.b(e0VarK, aVarM.f7025b, aVarM.f7026c);
            }
            a.c(aVarM);
        }
    }

    public void p(RecyclerView.e0 e0Var) {
        a aVar = this.f7014a.get(e0Var);
        if (aVar == null) {
            return;
        }
        aVar.f7024a &= -2;
    }

    public void q(RecyclerView.e0 e0Var) {
        int iW = this.f7015b.w() - 1;
        while (true) {
            if (iW < 0) {
                break;
            }
            if (e0Var == this.f7015b.x(iW)) {
                this.f7015b.s(iW);
                break;
            }
            iW--;
        }
        a aVarRemove = this.f7014a.remove(e0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
