package a;

import android.os.Handler;
import com.omarea.krscript.model.ActionParamInfo;
import com.omarea.krscript.model.PickerNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ce0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f5784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActionParamInfo f388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PickerNode f389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f390a;

    public ce0(fe0 fe0Var, PickerNode pickerNode, ActionParamInfo actionParamInfo, Handler handler, Runnable runnable) {
        this.f5784a = fe0Var;
        this.f389a = pickerNode;
        this.f388a = actionParamInfo;
        this.f387a = handler;
        this.f390a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f389a.getGetState() != null) {
            ActionParamInfo actionParamInfo = this.f388a;
            fe0 fe0Var = this.f5784a;
            String getState = this.f389a.getGetState();
            f92.b(getState);
            actionParamInfo.setValueFromShell(fe0Var.K1(getState, this.f389a));
        }
        ArrayList<n30> arrayListL1 = this.f5784a.L1(this.f388a, this.f389a);
        if (arrayListL1 != null) {
            he0.f6306a.d(this.f388a, arrayListL1);
        } else {
            arrayListL1 = null;
        }
        this.f387a.post(new be0(this, arrayListL1));
    }
}
