package a;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, String> f2797a;

    public rx0(Context context, String str) {
        if (str.startsWith("/")) {
            this.f7339a = str;
        } else {
            this.f7339a = c60.f5764a.d(context, str);
        }
        this.f2797a = g();
    }

    public boolean a() {
        return y60.f7952a.g(this.f7339a);
    }

    public boolean b(String str, boolean z) {
        return d(str, z ? "1" : "0").equals("1");
    }

    public Set<String> c() {
        return this.f2797a.keySet();
    }

    public String d(String str, String str2) {
        return this.f2797a.containsKey(str) ? this.f2797a.get(str) : str2;
    }

    public boolean e(String str) {
        return this.f2797a.containsKey(str);
    }

    public void f(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f2797a.put(it.next(), "1");
        }
        i();
    }

    public final HashMap<String, String> g() {
        HashMap<String, String> map = new HashMap<>();
        for (String str : y60.f7952a.i(this.f7339a).split("\n")) {
            if (str.contains("=")) {
                String[] strArrSplit = str.split("=");
                if (strArrSplit.length > 1) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                } else {
                    map.put(strArrSplit[0], "");
                }
            }
        }
        return map;
    }

    public void h(String str) {
        this.f2797a.remove(str);
        i();
    }

    public final void i() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f2797a.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        y60.f7952a.l(this.f7339a, sb.toString());
    }

    public void j(String str, boolean z) {
        k(str, z ? "1" : "0");
    }

    public void k(String str, String str2) {
        if (str.isEmpty()) {
            return;
        }
        this.f2797a.put(str, str2);
        i();
    }
}
