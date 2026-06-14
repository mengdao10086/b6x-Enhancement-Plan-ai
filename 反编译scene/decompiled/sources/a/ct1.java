package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityAppXposedConfig;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ct1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ et1 f5827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f443a;

    public ct1(View view, et1 et1Var) {
        this.f443a = view;
        this.f5827a = et1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5827a.s1(new Intent(this.f443a.getContext(), (Class<?>) ActivityAppXposedConfig.class));
    }
}
