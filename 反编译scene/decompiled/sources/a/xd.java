package a;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ke f7877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3572a;

    public xd(ke keVar, Handler handler) {
        this.f7877a = keVar;
        this.f3572a = handler;
    }

    public final void a(int i) {
        this.f3572a.post(new wd(this, this.f7877a, i));
    }

    public void b(ge geVar) {
        if (geVar.a()) {
            c(geVar.f1000a);
        } else {
            a(geVar.f6198a);
        }
    }

    public final void c(Typeface typeface) {
        this.f3572a.post(new vd(this, this.f7877a, typeface));
    }
}
