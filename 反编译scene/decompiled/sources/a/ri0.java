package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ri0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f2745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f2746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f2747a;
    public final String[] b;

    public ri0(Context context) {
        f92.d(context, "context");
        this.f7303a = context;
        String[] stringArray = context.getResources().getStringArray(s61.config_games_blacklist);
        f92.c(stringArray, "context.resources.getStr…y.config_games_blacklist)");
        this.f2747a = stringArray;
        PackageManager packageManager = this.f7303a.getPackageManager();
        f92.b(packageManager);
        this.f2746a = packageManager;
        SharedPreferences sharedPreferences = this.f7303a.getSharedPreferences("games", 0);
        f92.b(sharedPreferences);
        this.f2745a = sharedPreferences;
        this.b = new String[]{"libunity.so", "libil2cpp.so", "libue4.so", "libue.so", "libunreal.so", "libcocos2djs.so", "libcocos2dcpp.so"};
    }

    public final void a(List<String> list) {
        f92.d(list, "games");
        SharedPreferences.Editor editorEdit = this.f2745a.edit();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.putBoolean((String) it.next(), true);
        }
        editorEdit.apply();
    }

    public final ArrayList<String> b() {
        List<ApplicationInfo> installedApplications = this.f2746a.getInstalledApplications(0);
        f92.c(installedApplications, "packageManager.getInstalledApplications(0)");
        ArrayList<String> arrayList = new ArrayList<>();
        for (ApplicationInfo applicationInfo : installedApplications) {
            f92.c(applicationInfo, "info");
            if (e(applicationInfo) && !u42.k(this.f2747a, applicationInfo.packageName)) {
                arrayList.add(applicationInfo.packageName);
            }
        }
        return arrayList;
    }

    public final String[] c() {
        ArrayList<String> arrayListB = b();
        SharedPreferences.Editor editorEdit = this.f2745a.edit();
        for (String str : arrayListB) {
            if (!this.f2745a.contains(str)) {
                editorEdit.putBoolean(str, true);
            }
        }
        Iterator<T> it = this.f2745a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (u42.k(this.f2747a, entry.getKey())) {
                editorEdit.remove((String) entry.getKey());
            }
        }
        editorEdit.apply();
        Set<Map.Entry<String, ?>> setEntrySet = this.f2745a.getAll().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (f92.a(((Map.Entry) obj).getValue(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it2.next()).getKey());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final Boolean d(String str) {
        f92.d(str, "app");
        if (this.f2745a.contains(str)) {
            return Boolean.valueOf(this.f2745a.getBoolean(str, false));
        }
        try {
            ApplicationInfo applicationInfo = this.f2746a.getApplicationInfo(str, 128);
            f92.c(applicationInfo, "packageManager.getApplic…ageManager.GET_META_DATA)");
            boolean zE = e(applicationInfo);
            this.f2745a.edit().putBoolean(str, zE).apply();
            return Boolean.valueOf(zE);
        } catch (Exception unused) {
            this.f2745a.edit().putBoolean(str, false).apply();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.content.pm.ApplicationInfo r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ri0.e(android.content.pm.ApplicationInfo):boolean");
    }

    public final void f(String str, boolean z) {
        f92.d(str, "app");
        this.f2745a.edit().putBoolean(str, z).apply();
    }
}
