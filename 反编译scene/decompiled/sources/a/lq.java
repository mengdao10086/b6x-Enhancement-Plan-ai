package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static mf<lq> f6731a = new nf(20);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.l.b f1845a;
    public RecyclerView.l.b b;

    public static void a() {
        while (f6731a.a() != null) {
        }
    }

    public static lq b() {
        lq lqVarA = f6731a.a();
        return lqVarA == null ? new lq() : lqVarA;
    }

    public static void c(lq lqVar) {
        lqVar.f1844a = 0;
        lqVar.f1845a = null;
        lqVar.b = null;
        f6731a.b(lqVar);
    }
}
