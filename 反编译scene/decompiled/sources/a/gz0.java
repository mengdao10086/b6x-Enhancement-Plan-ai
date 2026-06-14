package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArraySet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f1075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<g50> f1076a;

    public gz0(Context context) {
        f92.d(context, "context");
        this.f6255a = context;
        this.f1075a = context.getSharedPreferences("scene_actions", 0);
        ArrayList<g50> arrayListA = new xx0(this.f6255a).a();
        ArrayList arrayList = new ArrayList(z42.m(arrayListA, 10));
        for (g50 g50Var : arrayListA) {
            g50 g50Var2 = new g50();
            g50Var2.d(g50Var.b());
            g50Var2.c(g50Var.a());
            arrayList.add(g50Var2);
        }
        this.f1076a = arrayList;
    }

    public final Set<String> a(String str) {
        f92.d(str, "app");
        Set<String> stringSet = this.f1075a.getStringSet(str, null);
        return stringSet != null ? stringSet : new ArraySet();
    }

    public final List<g50> b(String str) {
        f92.d(str, "app");
        gz0 gz0Var = new gz0(this.f6255a);
        List<g50> list = gz0Var.f1076a;
        Set<String> setA = gz0Var.a(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (setA.contains(((g50) obj).a())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void c(String str, Set<String> set) {
        f92.d(str, "app");
        f92.d(set, "actions");
        (set.size() == 0 ? this.f1075a.edit().remove(str) : this.f1075a.edit().putStringSet(str, set)).apply();
    }
}
