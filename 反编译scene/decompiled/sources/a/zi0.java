package a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zi0 {
    public final oz0 a(String str) {
        f92.d(str, "dir");
        oz0 oz0Var = new oz0();
        oz0Var.f2344a = new ArrayList<>();
        ArrayList<n50> arrayListH = y60.f7952a.h(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListH) {
            n50 n50Var = (n50) obj;
            if (!n50Var.g() && (f92.a(n50Var.d(), "uevent") ^ true)) {
                arrayList.add(obj);
            }
        }
        oz0Var.f7067a = str;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            oz0Var.f2344a.add(b((n50) it.next()));
        }
        return oz0Var;
    }

    public final pz0 b(n50 n50Var) {
        pz0 pz0Var = new pz0();
        pz0Var.f2484a = n50Var.d();
        pz0Var.f2488c = n50Var.b();
        return pz0Var;
    }
}
