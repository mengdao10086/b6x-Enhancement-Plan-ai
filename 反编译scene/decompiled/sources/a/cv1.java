package a;

import a.p80;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cv1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f5832a;

    public cv1(kv1 kv1Var) {
        this.f5832a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        bv1 bv1Var = new bv1(this);
        p80.a aVar = p80.f2403a;
        cl clVarJ = this.f5832a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        aVar.h(clVarJ, "一键策略", "Scene为当前设备提供了一些包含锁帧、后台清理，但不涉及性能和充电速度的调整项，是否采用？", new q80("采用", new zu1(this, bv1Var), false, 4, null), new q80("略过", new av1(bv1Var), false, 4, null));
    }
}
