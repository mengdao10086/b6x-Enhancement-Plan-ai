package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ql0 {
    public static /* synthetic */ void b(ql0 ql0Var, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "com.android.vending";
        }
        ql0Var.a(str);
    }

    public final void a(String str) {
        f92.d(str, "app");
        String strG = "pm disable com.google.android.gsf 2> /dev/null\npm disable com.google.android.gsf.login 2> /dev/null\npm disable com.google.android.gms 2> /dev/null\npm disable " + str + " 2> /dev/null\npm disable com.google.android.play.games 2> /dev/null\npm disable com.google.android.syncadapters.contacts 2> /dev/null";
        if (f92.a(e50.f677a.y0(), "adb")) {
            strG = new nb2("disable").g(strG, "disable-user");
        }
        s60.f7366a.a(strG);
    }

    public final void c(String str) {
        f92.d(str, "app");
        s60.f7366a.a("pm enable com.google.android.gsf 2> /dev/null\npm enable com.google.android.gsf.login 2> /dev/null\npm enable com.google.android.gms 2> /dev/null\npm enable " + str + " 2> /dev/null\npm enable-user " + str + " 2> /dev/null\npm enable com.google.android.play.games 2> /dev/null\npm enable com.google.android.syncadapters.contacts 2> /dev/null");
    }
}
