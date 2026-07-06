package a;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class to1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f7519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3049a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public to1(TextView textView, dp1 dp1Var, CompoundButton compoundButton) {
        super(0);
        this.f3049a = textView;
        this.f7519a = dp1Var;
    }

    public final void a() {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Context context = this.f3049a.getContext();
        f92.c(context, "context");
        String str = this.f7519a.b;
        String string = this.f3049a.getContext().getString(u61.schedule_bypass_power);
        f92.c(string, "context.getString(R.string.schedule_bypass_power)");
        aVar.a(context, 2131820551, str, string);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
