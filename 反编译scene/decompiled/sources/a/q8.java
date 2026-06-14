package a;

import android.R;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s8 f7186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final w3 f2552a;

    public q8(s8 s8Var) {
        this.f7186a = s8Var;
        this.f2552a = new w3(this.f7186a.f2852a.getContext(), 0, R.id.home, 0, 0, this.f7186a.f2853a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s8 s8Var = this.f7186a;
        Window.Callback callback = s8Var.f2851a;
        if (callback == null || !s8Var.f2858b) {
            return;
        }
        callback.onMenuItemSelected(0, this.f2552a);
    }
}
