package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r8 extends nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s8 f2721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2722a = false;

    public r8(s8 s8Var, int i) {
        this.f2721a = s8Var;
        this.f7280a = i;
    }

    @Override // a.mh
    public void a(View view) {
        if (this.f2722a) {
            return;
        }
        this.f2721a.f2852a.setVisibility(this.f7280a);
    }

    @Override // a.nh, a.mh
    public void b(View view) {
        this.f2722a = true;
    }

    @Override // a.nh, a.mh
    public void c(View view) {
        this.f2721a.f2852a.setVisibility(0);
    }
}
