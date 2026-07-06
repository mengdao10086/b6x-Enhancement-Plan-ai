package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class qc2 {
    public static final <T> fe2<T> a(wd2 wd2Var, l62 l62Var, zd2 zd2Var, k82<? super wd2, ? super b62<? super T>, ? extends Object> k82Var) {
        l62 l62VarC = ld2.c(wd2Var, l62Var);
        he2 dg2Var = zd2Var.b() ? new dg2(l62VarC, k82Var) : new he2(l62VarC, true);
        ((hc2) dg2Var).I0(zd2Var, dg2Var, k82Var);
        return (fe2<T>) dg2Var;
    }

    public static /* synthetic */ fe2 b(wd2 wd2Var, l62 l62Var, zd2 zd2Var, k82 k82Var, int i, Object obj) {
        if ((i & 1) != 0) {
            l62Var = m62.f6776a;
        }
        if ((i & 2) != 0) {
            zd2Var = zd2.DEFAULT;
        }
        return oc2.a(wd2Var, l62Var, zd2Var, k82Var);
    }

    public static final qf2 c(wd2 wd2Var, l62 l62Var, zd2 zd2Var, k82<? super wd2, ? super b62<? super m42>, ? extends Object> k82Var) {
        l62 l62VarC = ld2.c(wd2Var, l62Var);
        hc2 eg2Var = zd2Var.b() ? new eg2(l62VarC, k82Var) : new lg2(l62VarC, true);
        eg2Var.I0(zd2Var, eg2Var, k82Var);
        return eg2Var;
    }

    public static /* synthetic */ qf2 d(wd2 wd2Var, l62 l62Var, zd2 zd2Var, k82 k82Var, int i, Object obj) {
        if ((i & 1) != 0) {
            l62Var = m62.f6776a;
        }
        if ((i & 2) != 0) {
            zd2Var = zd2.DEFAULT;
        }
        return oc2.c(wd2Var, l62Var, zd2Var, k82Var);
    }

    public static final <T> Object e(l62 l62Var, k82<? super wd2, ? super b62<? super T>, ? extends Object> k82Var, b62<? super T> b62Var) {
        Object objJ0;
        l62 l62VarC = b62Var.c();
        l62 l62VarPlus = l62VarC.plus(l62Var);
        bh2.a(l62VarPlus);
        if (l62VarPlus == l62VarC) {
            ji2 ji2Var = new ji2(l62VarPlus, b62Var);
            objJ0 = yi2.b(ji2Var, ji2Var, k82Var);
        } else if (f92.a((e62) l62VarPlus.get(e62.f5972a), (e62) l62VarC.get(e62.f5972a))) {
            yg2 yg2Var = new yg2(l62VarPlus, b62Var);
            Object objC = ti2.c(l62VarPlus, null);
            try {
                Object objB = yi2.b(yg2Var, yg2Var, k82Var);
                ti2.a(l62VarPlus, objC);
                objJ0 = objB;
            } catch (Throwable th) {
                ti2.a(l62VarPlus, objC);
                throw th;
            }
        } else {
            ne2 ne2Var = new ne2(l62VarPlus, b62Var);
            ne2Var.E0();
            xi2.b(k82Var, ne2Var, ne2Var);
            objJ0 = ne2Var.J0();
        }
        if (objJ0 == r62.c()) {
            z62.c(b62Var);
        }
        return objJ0;
    }
}
