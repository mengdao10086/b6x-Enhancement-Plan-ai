package a;

import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class so0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uo0 f7418a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so0(uo0 uo0Var) {
        super(1);
        this.f7418a = uo0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        wr0 wr0Var = new wr0();
        Set<String> setC = wr0Var.j().c();
        f92.c(setC, "fas.whiteListFile.keys");
        l30Var.D("fas_whitelist", setC);
        Set<String> setC2 = wr0Var.e().c();
        f92.c(setC2, "fas.blackListFile.keys");
        l30Var.D("fas_blacklist", setC2);
        ArrayList<ApplicationInfo> arrayListA = new pj0().a(this.f7418a.f7617a.f7712a);
        f92.c(arrayListA, "UninstalledApp().getList(context)");
        ArrayList arrayList = new ArrayList(z42.m(arrayListA, 10));
        Iterator<T> it = arrayListA.iterator();
        while (it.hasNext()) {
            arrayList.add(((ApplicationInfo) it.next()).packageName);
        }
        l30Var.D("uninstalled", arrayList);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
