package a;

import android.os.Handler;
import android.widget.LinearLayout;
import com.omarea.krscript.model.ActionNode;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class od0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f2229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ LinearLayout f2230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionNode f2231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f2232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f2234a;

    public od0(fe0 fe0Var, ArrayList arrayList, Handler handler, ActionNode actionNode, LinearLayout linearLayout, String str, Runnable runnable) {
        this.f7008a = fe0Var;
        this.f2234a = arrayList;
        this.f2229a = handler;
        this.f2231a = actionNode;
        this.f2230a = linearLayout;
        this.f2233a = str;
        this.f2232a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (ActionParamInfo actionParamInfo : this.f2234a) {
            this.f2229a.post(new fd0(this, actionParamInfo));
            if (actionParamInfo.getValueShell() != null) {
                fe0 fe0Var = this.f7008a;
                String valueShell = actionParamInfo.getValueShell();
                f92.b(valueShell);
                actionParamInfo.setValueFromShell(fe0Var.K1(valueShell, this.f2231a));
            }
            this.f2229a.post(new gd0(this, actionParamInfo));
            fe0 fe0Var2 = this.f7008a;
            f92.c(actionParamInfo, "actionParamInfo");
            actionParamInfo.setOptionsFromShell(fe0Var2.L1(actionParamInfo, this.f2231a));
        }
        this.f2229a.post(new hd0(this));
        this.f2229a.post(new nd0(this));
    }
}
