package a;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ll0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, String> f6719a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1825a;

    public ll0(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "storageKey");
        this.f1825a = str;
    }

    public final void a() {
        String strC = c();
        if (strC != null) {
            if ((strC.length() > 0) && (!f92.a(strC, "error"))) {
                f6719a.put(this.f1825a, strC);
            }
        }
    }

    public final String b() {
        if (!f6719a.containsKey(this.f1825a)) {
            a();
        }
        if (f6719a.containsKey(this.f1825a)) {
            return f6719a.get(this.f1825a);
        }
        return null;
    }

    public abstract String c();

    public final void d() {
        if (f6719a.containsKey(this.f1825a)) {
            f6719a.remove(this.f1825a);
        }
        b();
    }

    public String toString() {
        String strB = b();
        return strB != null ? strB : "";
    }
}
