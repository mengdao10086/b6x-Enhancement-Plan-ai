package a;

import android.content.Context;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ od0 f6094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionParamInfo f883a;

    public fd0(od0 od0Var, ActionParamInfo actionParamInfo) {
        this.f6094a = od0Var;
        this.f883a = actionParamInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u90 u90VarB1 = fe0.B1(this.f6094a.f7008a);
        StringBuilder sb = new StringBuilder();
        Context contextP = this.f6094a.f7008a.p();
        f92.b(contextP);
        sb.append(contextP.getString(ob0.kr_param_load));
        String label = this.f883a.getLabel();
        sb.append(!(label == null || label.length() == 0) ? this.f883a.getLabel() : this.f883a.getName());
        u90VarB1.d(sb.toString());
    }
}
