package a;

import android.graphics.drawable.Drawable;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ze1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f8064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess.b f3838a;

    public ze1(ActivityProcess.b bVar, n92 n92Var) {
        this.f3838a = bVar;
        this.f8064a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        this.f3838a.f5469a.setImageDrawable((Drawable) this.f8064a.f6891a);
    }
}
