package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yc extends ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nc f7967a;

    public yc(nc ncVar) {
        this.f7967a = ncVar;
    }

    @Override // a.ke
    public void a(int i) {
        nc ncVar = this.f7967a;
        if (ncVar != null) {
            ncVar.d(i);
        }
    }

    @Override // a.ke
    public void b(Typeface typeface) {
        nc ncVar = this.f7967a;
        if (ncVar != null) {
            ncVar.e(typeface);
        }
    }
}
