package a;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f3466a;
    public final Runnable b;

    public wp0(Context context, Runnable runnable, Runnable runnable2) {
        f92.d(context, "context");
        this.f7811a = context;
        this.f3466a = runnable;
        this.b = runnable2;
    }

    public /* synthetic */ wp0(Context context, Runnable runnable, Runnable runnable2, int i, b92 b92Var) {
        this(context, (i & 2) != 0 ? null : runnable, (i & 4) != 0 ? null : runnable2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v12, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v18, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(a.b62<? super a.m42> r11) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.wp0.d(a.b62):java.lang.Object");
    }

    public final Context e() {
        return this.f7811a;
    }

    public final void f() {
        if (this.f3466a != null) {
            qc2.d(hf2.f6309a, qe2.c(), null, new tp0(this, null), 2, null);
        }
    }

    public final void g(Runnable runnable) {
        String strF = a70.f(false);
        String[] stringArray = this.f7811a.getResources().getStringArray(s61.su_alias_name);
        f92.c(stringArray, "context.resources.getStr…ay(R.array.su_alias_name)");
        String[] stringArray2 = this.f7811a.getResources().getStringArray(s61.config_su_alias);
        f92.c(stringArray2, "context.resources.getStr…(R.array.config_su_alias)");
        ArrayList arrayList = new ArrayList(stringArray2.length);
        int length = stringArray2.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray2[i];
            n30 n30Var = new n30();
            n30Var.i(stringArray[i2]);
            n30Var.j(str);
            arrayList.add(n30Var);
            i++;
            i2++;
        }
        Context context = this.f7811a;
        ArrayList arrayList2 = new ArrayList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList) {
            if (f92.a(((n30) obj).e(), strF)) {
                arrayList3.add(obj);
            }
        }
        l90 l90Var = new l90(context, arrayList2, new ArrayList(arrayList3), false);
        String string = this.f7811a.getString(u61.switch_root_cmd);
        f92.c(string, "context.getString(R.string.switch_root_cmd)");
        l90Var.m(string);
        l90Var.k(new vp0(this, runnable));
        l90Var.o();
    }
}
