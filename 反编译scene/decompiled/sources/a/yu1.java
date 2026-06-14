package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityAutoClick;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f8012a;

    public yu1(kv1 kv1Var) {
        this.f8012a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f8012a.s1(new Intent(this.f8012a.p(), (Class<?>) ActivityAutoClick.class));
    }
}
