package a;

import a.p80;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.omarea.model.AppInfo;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kf1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ProcessInfo f1626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess f1627a;

    public kf1(View view, ActivityProcess activityProcess, ProcessInfo processInfo, p80.b bVar) {
        this.f1625a = view;
        this.f1627a = activityProcess;
        this.f1626a = processInfo;
        this.f6600a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = this.f1626a.name;
        f92.c(str, "detail.name");
        String str2 = (String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null));
        Context context = this.f1625a.getContext();
        f92.c(context, "context");
        AppInfo appInfoD = new kh0(context, false).d(str2);
        if (appInfoD != null) {
            new iq1(this.f1627a, appInfoD, new jf1()).c0();
        } else {
            Toast.makeText(this.f1625a.getContext(), this.f1627a.getString(u61.process_app_not_found), 0).show();
        }
        this.f6600a.c();
    }
}
