package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hy0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ly0 f6354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f1265a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy0(int i, List list, ly0 ly0Var) {
        super(1);
        this.b = i;
        this.f1265a = list;
        this.f6354a = ly0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        Object next;
        f92.d(l30Var, "$receiver");
        l30Var.E("loadAvg", Double.valueOf(((jn0) this.f6354a.b.get(this.b)).c()));
        l30Var.E("loadMax", Double.valueOf(((jn0) this.f6354a.b.get(this.b)).d()));
        l30Var.E("loadSum", Double.valueOf(((jn0) this.f6354a.b.get(this.b)).e()));
        l30Var.E("duration", Long.valueOf(((jn0) this.f6354a.b.get(this.b)).b()));
        l30Var.E("comm", ((jn0) this.f6354a.b.get(this.b)).a());
        ArrayList arrayList = this.f6354a.f1858a;
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            Iterator it2 = this.f1265a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (((in0) next).f() == jLongValue) {
                        break;
                    }
                }
            }
            in0 in0Var = (in0) next;
            arrayList2.add(in0Var != null ? Double.valueOf(in0Var.d()) : 0);
        }
        l30Var.D("loads", arrayList2);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
