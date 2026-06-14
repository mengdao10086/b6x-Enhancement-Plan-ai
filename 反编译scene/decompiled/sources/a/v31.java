package a;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v31 implements TabLayout.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x31 f7655a;

    public v31(x31 x31Var) {
        this.f7655a = x31Var;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void a(TabLayout.g gVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void b(TabLayout.g gVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void c(TabLayout.g gVar) {
        d();
    }

    public final void d() {
        if (!this.f7655a.f3530a) {
            int tabCount = this.f7655a.f3528a.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TabLayout.g gVarU = this.f7655a.f3528a.u(i);
                if (gVarU != null) {
                    gVarU.l((View) this.f7655a.b.get(i));
                }
            }
            this.f7655a.f3530a = true;
        }
        this.f7655a.h();
    }
}
