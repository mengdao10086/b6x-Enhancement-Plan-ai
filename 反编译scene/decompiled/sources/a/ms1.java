package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ms1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6839a;

    public ms1(zs1 zs1Var) {
        this.f6839a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6839a.s1(new Intent(this.f6839a.p(), (Class<?>) ActivitySwap.class));
    }
}
