package a;

import android.os.Handler;
import com.omarea.krscript.model.NodeInfoBase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lf0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ of0 f6701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ye0 f1794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f1795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ NodeInfoBase f1796a;

    public lf0(of0 of0Var, Handler handler, ye0 ye0Var, NodeInfoBase nodeInfoBase) {
        this.f6701a = of0Var;
        this.f1795a = handler;
        this.f1794a = ye0Var;
        this.f1796a = nodeInfoBase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1795a.post(new kf0(this));
    }
}
