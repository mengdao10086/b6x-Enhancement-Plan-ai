package a;

import android.content.Context;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h02 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f6260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f1087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f1088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1089a;
    public final /* synthetic */ boolean b;

    public h02(l02 l02Var, Runnable runnable, boolean z, String str, Context context, n92 n92Var) {
        this.f6260a = l02Var;
        this.f1088a = runnable;
        this.b = z;
        this.f1089a = str;
        this.f1087a = context;
        this.f1086a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1088a.run();
        if (this.b && (!f92.a(this.f1089a, this.f1087a.getPackageName()))) {
            (f92.a((String) this.f1086a.f6891a, this.f6260a.f1710a) ? this.f6260a.f1708a.edit().remove(this.f6260a.m()) : this.f6260a.f1708a.edit().putString(this.f6260a.m(), (String) this.f1086a.f6891a)).apply();
        }
        Scene.f4798a.j(new g02(this), 300L);
    }
}
