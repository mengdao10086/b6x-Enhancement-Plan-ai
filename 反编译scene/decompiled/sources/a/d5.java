package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class d5 implements mh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ e5 f491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f492a = false;

    public d5(e5 e5Var) {
        this.f491a = e5Var;
    }

    @Override // a.mh
    public void a(View view) {
        if (this.f492a) {
            return;
        }
        e5 e5Var = this.f491a;
        e5Var.f673a = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f5861a);
    }

    @Override // a.mh
    public void b(View view) {
        this.f492a = true;
    }

    @Override // a.mh
    public void c(View view) {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f492a = false;
    }

    public d5 d(lh lhVar, int i) {
        this.f491a.f673a = lhVar;
        this.f5861a = i;
        return this;
    }
}
