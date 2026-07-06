package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t3 extends nh {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u3 f2944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2945a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7459a = 0;

    public t3(u3 u3Var) {
        this.f2944a = u3Var;
    }

    @Override // a.mh
    public void a(View view) {
        int i = this.f7459a + 1;
        this.f7459a = i;
        if (i == this.f2944a.f3120a.size()) {
            mh mhVar = this.f2944a.f3117a;
            if (mhVar != null) {
                mhVar.a(null);
            }
            d();
        }
    }

    @Override // a.nh, a.mh
    public void c(View view) {
        if (this.f2945a) {
            return;
        }
        this.f2945a = true;
        mh mhVar = this.f2944a.f3117a;
        if (mhVar != null) {
            mhVar.c(null);
        }
    }

    public void d() {
        this.f7459a = 0;
        this.f2945a = false;
        this.f2944a.b();
    }
}
