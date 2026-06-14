package a;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6089a;

    public fb0(Context context) {
        this.f6089a = context;
    }

    public String a() {
        int iB = b();
        StringBuilder sb = new StringBuilder();
        sb.append("u");
        sb.append(iB);
        sb.append("_a");
        sb.append((Process.myUid() % 100000) - 10000);
        return sb.toString();
    }

    public int b() {
        try {
            return (int) ((UserManager) this.f6089a.getSystemService("user")).getSerialNumberForUser(Process.myUserHandle());
        } catch (Exception unused) {
            return 0;
        }
    }
}
