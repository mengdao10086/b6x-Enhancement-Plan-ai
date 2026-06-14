package a;

import android.content.Context;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vo1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f7713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3295a;

    public vo1(View view, dp1 dp1Var, boolean z) {
        this.f3295a = view;
        this.f7713a = dp1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Context context = this.f3295a.getContext();
        f92.c(context, "context");
        String str = this.f7713a.c;
        String string = this.f3295a.getContext().getString(u61.schedule_limiter);
        f92.c(string, "context.getString(R.string.schedule_limiter)");
        aVar.a(context, 2131820554, str, string);
    }
}
