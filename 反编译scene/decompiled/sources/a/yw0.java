package a;

import android.os.Build;
import com.omarea.Scene;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yw0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8015a;
    public final boolean b;

    public yw0(boolean z, int i) {
        this.b = z;
        this.f8015a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.StringBuilder] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        tw0 tw0VarB;
        StringBuilder sb;
        String string;
        List<String> listS = (this.b || (tw0VarB = tw0.f3070a.b()) == null) ? null : tw0VarB.s();
        if (listS == null) {
            listS = y42.e();
        }
        ArrayList arrayList = (ArrayList) pc2.b(null, new xw0(null), 1, null);
        boolean zB = Scene.f4798a.b(hz0.O, Build.VERSION.SDK_INT >= 28);
        ArrayList<String> arrayList2 = new ArrayList();
        for (String str : new fz0(Scene.f4798a.c()).c()) {
            if (!listS.contains(str) && !arrayList.contains(str)) {
                arrayList2.add(str);
            }
        }
        if (arrayList2.contains("com.android.vending")) {
            arrayList2.add("com.google.android.gsf");
            arrayList2.add("com.google.android.gsf.login");
            arrayList2.add("com.google.android.gms");
            arrayList2.add("com.google.android.play.games");
            arrayList2.add("com.google.android.syncadapters.contacts");
        }
        if (tw0.c.length() > 0) {
            pc2.b(null, new vw0(null), 1, null);
        }
        if (!arrayList2.isEmpty()) {
            String str2 = zB ? "suspend" : f92.a(e50.f677a.y0(), "adb") ? "disable-user" : "disable";
            n92 n92Var = new n92();
            n92Var.f6891a = new StringBuilder();
            for (String str3 : arrayList2) {
                StringBuilder sb2 = (StringBuilder) n92Var.f6891a;
                if (zB) {
                    sb = new StringBuilder();
                    sb.append("pm ");
                    sb.append(str2);
                    sb.append(' ');
                    sb.append(str3);
                    sb.append(" 2>/dev/null\n");
                    sb2.append(sb.toString());
                    sb2.append("am force-stop " + str3 + " 2>/dev/null\n");
                    string = "am kill current " + str3 + " 2>/dev/null\n";
                } else {
                    sb = new StringBuilder();
                    sb.append("pm ");
                    sb.append(str2);
                    sb.append(' ');
                    sb.append(str3);
                    sb.append(" 2>/dev/null\n");
                    string = sb.toString();
                }
                sb2.append(string);
            }
            l92 l92Var = new l92();
            int i = this.f8015a;
            if (i <= 0) {
                i = 1;
            }
            l92Var.f6687a = i;
            pc2.b(null, new ww0(n92Var, l92Var, null), 1, null);
        }
    }
}
