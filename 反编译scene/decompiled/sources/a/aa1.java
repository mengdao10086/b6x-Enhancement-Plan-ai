package a;

import android.content.Intent;
import android.view.View;
import com.omarea.vtools.activities.ActivityPerfOptions;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aa1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba1 f5587a;

    public aa1(ba1 ba1Var) {
        this.f5587a = ba1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f5587a.f249a.getContext(), (Class<?>) ActivityPerfOptions.class);
        intent.putExtra("config", 2131820556);
        intent.putExtra("title", "CpuCtl");
        this.f5587a.f250a.startActivity(intent);
    }
}
