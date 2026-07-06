package a;

import android.content.Context;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ od0 f6195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionParamInfo f997a;

    public gd0(od0 od0Var, ActionParamInfo actionParamInfo) {
        this.f6195a = od0Var;
        this.f997a = actionParamInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarB1 = fe0.B1(this.f6195a.f7008a);
        StringBuilder sb = new StringBuilder();
        Context contextP = this.f6195a.f7008a.p();
        f92.b(contextP);
        sb.append(contextP.getString(ob0.kr_param_options_load));
        String label = this.f997a.getLabel();
        sb.append(!(label == null || label.length() == 0) ? this.f997a.getLabel() : this.f997a.getName());
        u90VarB1.d(sb.toString());
    }
}
