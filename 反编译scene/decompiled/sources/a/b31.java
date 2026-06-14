package a;

import android.view.View;
import com.omarea.ui.Games;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b31 implements yz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c31 f5670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ jp f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zz0 f209a;

    public b31(jp jpVar, c31 c31Var, zz0 zz0Var) {
        this.f208a = jpVar;
        this.f5670a = c31Var;
        this.f209a = zz0Var;
    }

    @Override // a.yz0
    public void a(View view, int i) {
        f92.d(view, "view");
        if (this.f208a.r()) {
            return;
        }
        Games.this.q(this.f209a.C(i));
    }
}
