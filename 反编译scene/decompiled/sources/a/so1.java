package a;

import android.content.Context;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class so1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Display.Mode> f2911a;

    public so1(Context context, List<Display.Mode> list) {
        f92.d(context, "context");
        f92.d(list, "items");
        this.f7419a = context;
        this.f2911a = list;
    }

    public final void a(Integer num, g82<? super Integer, m42> g82Var) {
        String strValueOf;
        f92.d(g82Var, "onOK");
        if (num == null || (strValueOf = String.valueOf(num.intValue())) == null) {
            strValueOf = "";
        }
        List<Display.Mode> list = this.f2911a;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        for (Display.Mode mode : list) {
            n30 n30Var = new n30();
            n30Var.i(Math.round(mode.getRefreshRate()) + "Hz");
            n30Var.j(String.valueOf(Math.round(mode.getRefreshRate())));
            arrayList.add(n30Var);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        n30 n30Var2 = new n30();
        n30Var2.i(this.f7419a.getString(u61._default));
        n30Var2.j("");
        m42 m42Var = m42.f6769a;
        arrayList2.add(0, n30Var2);
        Context context = this.f7419a;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (f92.a(((n30) obj).e(), strValueOf)) {
                arrayList3.add(obj);
            }
        }
        l90 l90Var = new l90(context, arrayList2, new ArrayList(arrayList3), false);
        String string = this.f7419a.getString(u61.detail_refresh_rate);
        f92.c(string, "context.getString(R.string.detail_refresh_rate)");
        l90Var.m(string);
        l90Var.k(new ro1(g82Var));
        l90Var.o();
    }
}
