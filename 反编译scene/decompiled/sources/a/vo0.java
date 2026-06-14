package a;

import android.content.Context;
import android.content.SharedPreferences;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vo0 extends r50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f3294a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public vo0(Context context) {
        super(null, 1, 0 == true ? 1 : 0);
        f92.d(context, "context");
        this.f7712a = context;
        this.f3294a = new String[]{"random_id2", "user_name", "activate_v2_type", hz0.f1282a.y(), hz0.f1282a.x(), hz0.f1282a.c0(), hz0.f1282a.z(), hz0.f1282a.C()};
    }

    public final List<String> A() throws e30 {
        String strB = B();
        if (!(strB.length() > 0)) {
            return null;
        }
        g30 g30VarN = r50.n(this, no0.f6937a.a() + "/sync-download", new l30(new po0(strB)), 0L, 4, null);
        if (g30VarN == null) {
            return null;
        }
        Iterator<String> itK = g30VarN.k();
        f92.c(itK, "response.keys()");
        while (itK.hasNext()) {
            String next = itK.next();
            Object objB = g30VarN.b(next);
            if ((objB instanceof g30) && next != null && next.hashCode() == 93090393 && next.equals("array")) {
                g30 g30Var = (g30) objB;
                Iterator<String> itK2 = g30Var.k();
                f92.c(itK2, "subItem.keys()");
                while (itK2.hasNext()) {
                    String next2 = itK2.next();
                    if (f92.a(next2, "uninstalled")) {
                        d30 d30VarF = g30Var.f(next2);
                        f92.c(d30VarF, "subItem.getJSONArray(key)");
                        Object[] objArrC = C(d30VarF);
                        ArrayList arrayList = new ArrayList(objArrC.length);
                        for (Object obj : objArrC) {
                            arrayList.add(String.valueOf(obj));
                        }
                        return arrayList;
                    }
                }
            }
        }
        return null;
    }

    public final String B() {
        return new wm0().a();
    }

    public final Object[] C(d30 d30Var) {
        int iG = d30Var.g();
        Object[] objArr = new Object[iG];
        for (int i = 0; i < iG; i++) {
            objArr[i] = d30Var.a(i);
        }
        return objArr;
    }

    public final void D(g30 g30Var, String str) {
        SharedPreferences.Editor editorEdit = Scene.f4798a.c().getSharedPreferences(str, 0).edit();
        Iterator<String> itK = g30Var.k();
        f92.c(itK, "obj.keys()");
        while (itK.hasNext()) {
            String next = itK.next();
            Object objB = g30Var.b(next);
            if (objB instanceof String) {
                editorEdit.putString(next, (String) objB);
            } else if (objB instanceof Boolean) {
                editorEdit.putBoolean(next, ((Boolean) objB).booleanValue());
            } else if (objB instanceof Integer) {
                editorEdit.putInt(next, ((Number) objB).intValue());
            } else if (objB instanceof Long) {
                editorEdit.putLong(next, ((Number) objB).longValue());
            } else if (objB instanceof Float) {
                editorEdit.putFloat(next, ((Number) objB).floatValue());
            }
        }
        editorEdit.apply();
    }

    public final Map<String, Object> E(String str) {
        SharedPreferences sharedPreferences = Scene.f4798a.c().getSharedPreferences(str, 0);
        f92.c(sharedPreferences, "Scene.context.getSharedP…xt.MODE_PRIVATE\n        )");
        Map<String, ?> all = sharedPreferences.getAll();
        f92.c(all, "Scene.context.getSharedP…ODE_PRIVATE\n        ).all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if ((entry.getValue() == null || u42.k(this.f3294a, entry.getKey())) ? false : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public final boolean F() {
        String string;
        String strB = B();
        if (!(strB.length() > 0)) {
            return false;
        }
        fz0 fz0Var = new fz0(this.f7712a);
        HashMap map = new HashMap();
        Iterator<String> it = fz0Var.c().iterator();
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            f92.c(next, "app");
            StringBuilder sb = new StringBuilder();
            String str2 = (String) map.get(next);
            if (str2 != null) {
                str = str2;
            }
            sb.append(str);
            sb.append("F,");
            map.put(next, sb.toString());
        }
        for (String str3 : fz0Var.d()) {
            f92.c(str3, "app");
            StringBuilder sb2 = new StringBuilder();
            String str4 = (String) map.get(str3);
            if (str4 == null) {
                str4 = "";
            }
            sb2.append(str4);
            sb2.append("L,");
            map.put(str3, sb2.toString());
        }
        g30 g30VarN = r50.n(this, no0.f6937a.a() + "/sync-upload", new l30(new uo0(this, strB, map)), 0L, 4, null);
        return (g30VarN == null || (string = g30VarN.toString()) == null || !ec2.C(string, "true", false, 2, null)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0049, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z() throws a.e30 {
        /*
            Method dump skipped, instruction units count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.vo0.z():boolean");
    }
}
