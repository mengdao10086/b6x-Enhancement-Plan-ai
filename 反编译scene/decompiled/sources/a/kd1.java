package a;

import android.content.Intent;
import android.view.View;
import android.widget.Switch;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityOtherSettings;
import com.omarea.vtools.services.KeepAliveService;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kd1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityOtherSettings f6596a;

    public kd1(ActivityOtherSettings activityOtherSettings) {
        this.f6596a = activityOtherSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Switch");
        }
        boolean zIsChecked = ((Switch) view).isChecked();
        Scene.f4798a.k(hz0.f1282a.D(), zIsChecked);
        if (zIsChecked) {
            this.f6596a.n();
        } else {
            this.f6596a.stopService(new Intent(this.f6596a.getApplicationContext(), (Class<?>) KeepAliveService.class));
        }
    }
}
