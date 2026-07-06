package a;

import android.content.Context;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wo1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f7809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3463a;

    public wo1(View view, dp1 dp1Var) {
        this.f3463a = view;
        this.f7809a = dp1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Context context = this.f3463a.getContext();
        f92.c(context, "context");
        Context context2 = this.f3463a.getContext();
        f92.c(context2, "context");
        m30 m30VarC = new kt0(context2).c();
        String str = this.f7809a.d;
        String string = this.f3463a.getContext().getString(u61.fas_adjust);
        f92.c(string, "context.getString(R.string.fas_adjust)");
        aVar.b(context, m30VarC, str, string);
    }
}
