package a;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e90 {
    public e90() {
    }

    public /* synthetic */ e90(b92 b92Var) {
        this();
    }

    public final l90 a(Context context, ArrayList<n30> arrayList, int i, g82<? super Integer, m42> g82Var) {
        ArrayList arrayList2;
        f92.d(context, "context");
        f92.d(arrayList, "items");
        if (i > -1) {
            arrayList2 = new ArrayList();
            arrayList2.add(arrayList.get(i));
        } else {
            arrayList2 = new ArrayList();
        }
        l90 l90Var = new l90(context, arrayList, arrayList2, false);
        if (g82Var != null) {
            l90Var.k(new d90(g82Var));
        }
        return l90Var;
    }

    public final l90 b(Context context, String[] strArr, int i, g82<? super Integer, m42> g82Var) {
        f92.d(context, "context");
        f92.d(strArr, "items");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            n30 n30Var = new n30();
            n30Var.i(str);
            n30Var.j(str);
            arrayList.add(n30Var);
        }
        return a(context, new ArrayList<>(arrayList), i, g82Var);
    }
}
