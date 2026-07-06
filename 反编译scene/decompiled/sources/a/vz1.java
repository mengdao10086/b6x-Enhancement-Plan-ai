package a;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.omarea.model.SceneConfigInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fz0 f7738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l02 f3315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SceneConfigInfo f3317a;

    public vz1(l02 l02Var, SceneConfigInfo sceneConfigInfo, Context context, fz0 fz0Var) {
        this.f3315a = l02Var;
        this.f3317a = sceneConfigInfo;
        this.f3316a = context;
        this.f7738a = fz0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        CompoundButton compoundButton = (CompoundButton) view;
        boolean zIsChecked = compoundButton.isChecked();
        if (zIsChecked && !new yk0().a(this.f3316a)) {
            new yk0().b(this.f3316a);
            Context context = this.f3316a;
            Toast.makeText(context, context.getString(u61.scene_need_notic_listing), 0).show();
            compoundButton.setChecked(false);
            return;
        }
        SceneConfigInfo sceneConfigInfo = this.f3317a;
        sceneConfigInfo.disNotice = zIsChecked;
        this.f7738a.g(sceneConfigInfo);
        l02 l02Var = this.f3315a;
        l02Var.q(l02Var.m());
    }
}
