package a;

import android.view.View;
import android.widget.CompoundButton;
import com.omarea.model.SceneConfigInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fz0 f7838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l02 f3501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SceneConfigInfo f3502a;

    public wz1(l02 l02Var, SceneConfigInfo sceneConfigInfo, fz0 fz0Var) {
        this.f3501a = l02Var;
        this.f3502a = sceneConfigInfo;
        this.f7838a = fz0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        boolean zIsChecked = ((CompoundButton) view).isChecked();
        SceneConfigInfo sceneConfigInfo = this.f3502a;
        sceneConfigInfo.gpsOn = zIsChecked;
        this.f7838a.g(sceneConfigInfo);
        if (zIsChecked) {
            new tl0().c();
        } else {
            new tl0().a();
        }
        l02 l02Var = this.f3501a;
        l02Var.q(l02Var.m());
    }
}
