package a;

import android.view.View;
import android.widget.CompoundButton;
import com.omarea.model.SceneConfigInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fz0 f7645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l02 f3224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SceneConfigInfo f3226a;

    public uz1(l02 l02Var, SceneConfigInfo sceneConfigInfo, fz0 fz0Var, n92 n92Var) {
        this.f3224a = l02Var;
        this.f3226a = sceneConfigInfo;
        this.f7645a = fz0Var;
        this.f3225a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SceneConfigInfo sceneConfigInfo = this.f3226a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CompoundButton");
        }
        sceneConfigInfo.aloneLight = ((CompoundButton) view).isChecked();
        this.f7645a.g(this.f3226a);
        this.f3224a.q((String) this.f3225a.f6891a);
    }
}
