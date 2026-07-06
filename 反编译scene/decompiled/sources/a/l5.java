package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l5 extends u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f6674a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l5(n5 n5Var, Context context, i4 i4Var, View view, boolean z) {
        super(context, i4Var, view, z, t.actionOverflowMenuStyle);
        this.f6674a = n5Var;
        h(8388613);
        j(n5Var.f2011a);
    }

    @Override // a.u4
    public void e() {
        if (((x3) ((x3) this.f6674a)).f3515a != null) {
            ((x3) ((x3) this.f6674a)).f3515a.close();
        }
        this.f6674a.f2010a = null;
        super.e();
    }
}
