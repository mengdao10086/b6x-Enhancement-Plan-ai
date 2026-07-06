package a;

import android.util.Log;
import com.omarea.krscript.model.NodeInfoBase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mf0 implements we0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ of0 f6802a;

    public mf0(of0 of0Var) {
        this.f6802a = of0Var;
    }

    @Override // a.we0
    public void a(ye0 ye0Var) {
        f92.d(ye0Var, "listItemView");
        String strA = ye0Var.a();
        try {
            NodeInfoBase nodeInfoBaseM = this.f6802a.m(strA, this.f6802a.f2240a);
            if (nodeInfoBaseM != null) {
                this.f6802a.p(nodeInfoBaseM, ye0Var);
                return;
            }
            Log.e("onItemClick", "找不到指定ID的项 index: " + strA);
        } catch (Exception unused) {
        }
    }
}
