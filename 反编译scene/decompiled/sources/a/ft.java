package a;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ft extends bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ it f6136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f943a;
    public final /* synthetic */ View b;

    public ft(it itVar, ViewGroup viewGroup, View view, View view2) {
        this.f6136a = itVar;
        this.f943a = viewGroup;
        this.f942a = view;
        this.b = view2;
    }

    @Override // a.bs, a.zr
    public void a(as asVar) {
        ps.a(this.f943a).c(this.f942a);
    }

    @Override // a.bs, a.zr
    public void b(as asVar) {
        if (this.f942a.getParent() == null) {
            ps.a(this.f943a).d(this.f942a);
        } else {
            this.f6136a.f();
        }
    }

    @Override // a.zr
    public void e(as asVar) {
        this.b.setTag(rr.save_overlay_view, null);
        ps.a(this.f943a).c(this.f942a);
        asVar.P(this);
    }
}
