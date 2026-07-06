package a;

import a.p80;
import android.view.View;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hf1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f1163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1164a;

    public hf1(String str, n92 n92Var, ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f1164a = str;
        this.f6308a = n92Var;
        this.f1163a = activityProcess;
        this.f1162a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1162a.c();
        String str = this.f1164a + "/memory.swappiness";
        String strD = x60.f7856a.d(str);
        if (f92.a(strD, "0")) {
            x60.f7856a.j(str, "100");
        }
        p80.a aVar = p80.f2403a;
        ActivityProcess activityProcess = this.f1163a;
        qc2.d(xd2.a(qe2.b()), null, null, new gf1(this, strD, str, aVar.F(activityProcess, activityProcess.getString(u61.process_force_empty)), null), 3, null);
    }
}
