package a;

import android.widget.Toast;
import com.omarea.vtools.activities.ActivityAddinOnline;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddinOnline.d f7572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3153a;

    public u71(ActivityAddinOnline.d dVar, String str) {
        this.f7572a = dVar;
        this.f3153a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f7572a.b, this.f3153a, 1).show();
    }
}
