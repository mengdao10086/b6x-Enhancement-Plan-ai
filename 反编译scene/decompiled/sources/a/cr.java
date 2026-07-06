package a;

import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cr extends bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f439a = false;

    public cr(er erVar, ViewGroup viewGroup) {
        this.f5820a = viewGroup;
    }

    @Override // a.bs, a.zr
    public void a(as asVar) {
        ps.c(this.f5820a, false);
    }

    @Override // a.bs, a.zr
    public void b(as asVar) {
        ps.c(this.f5820a, true);
    }

    @Override // a.bs, a.zr
    public void d(as asVar) {
        ps.c(this.f5820a, false);
        this.f439a = true;
    }

    @Override // a.zr
    public void e(as asVar) {
        if (!this.f439a) {
            ps.c(this.f5820a, false);
        }
        asVar.P(this);
    }
}
