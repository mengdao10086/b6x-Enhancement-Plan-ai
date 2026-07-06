package a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class on0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2270a;
    public final String b;

    public on0(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "storageKey");
        this.f7039a = context;
        this.b = str;
    }

    public final void d(SharedPreferences sharedPreferences) {
        String strF = f();
        this.f2270a = strF;
        if (strF != null) {
            if ((strF.length() > 0) && (!f92.a(this.f2270a, "error"))) {
                sharedPreferences.edit().putString(this.b, this.f2270a).apply();
            }
        }
    }

    public final String e() {
        if (this.f2270a == null) {
            SharedPreferences sharedPreferences = this.f7039a.getSharedPreferences("TripleCacheValues", 0);
            if (sharedPreferences.contains(this.b)) {
                this.f2270a = sharedPreferences.getString(this.b, "");
                f92.c(sharedPreferences, "storage");
                h(sharedPreferences);
            } else {
                f92.c(sharedPreferences, "storage");
                d(sharedPreferences);
            }
        }
        return this.f2270a;
    }

    public abstract String f();

    public final void g() {
        this.f2270a = null;
        this.f7039a.getSharedPreferences("TripleCacheValues", 0).edit().remove(this.b).apply();
        e();
    }

    public void h(SharedPreferences sharedPreferences) {
        f92.d(sharedPreferences, "storage");
        qc2.d(hf2.f6309a, qe2.b(), null, new nn0(this, sharedPreferences, null), 2, null);
    }

    public final int i() {
        String strE = e();
        if (strE == null || strE.length() == 0) {
            return 0;
        }
        return Integer.parseInt(strE);
    }

    public String toString() {
        String strE = e();
        return strE != null ? strE : "";
    }
}
