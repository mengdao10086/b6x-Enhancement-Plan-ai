package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ca1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ da1 f5771a;

    public ca1(da1 da1Var) {
        this.f5771a = da1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f5771a.f523a.getContext(), (Class<?>) ActivityPerfOptions.class);
        intent.putExtra("config", 2131820555);
        intent.putExtra("title", "SchedTune");
        this.f5771a.f524a.startActivity(intent);
    }
}
