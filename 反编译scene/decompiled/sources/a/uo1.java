package a;

import android.content.Context;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityPerfOptions;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uo1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f7618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3201a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo1(TextView textView, dp1 dp1Var) {
        super(0);
        this.f3201a = textView;
        this.f7618a = dp1Var;
    }

    public final void a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        ActivityPerfOptions.a aVar = ActivityPerfOptions.f8803a;
        Context context = this.f3201a.getContext();
        f92.c(context, "context");
        Context context2 = this.f3201a.getContext();
        f92.c(context2, "context");
        m30 m30VarB = new rw0(context2).b();
        String str = this.f7618a.f591a;
        String string = this.f3201a.getContext().getString(u61.schedule_feature_fps);
        f92.c(string, "context.getString(R.string.schedule_feature_fps)");
        aVar.b(context, m30VarB, str, string);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        a();
        return m42.f6769a;
    }
}
