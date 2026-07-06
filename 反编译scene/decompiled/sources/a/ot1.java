package a;

import a.p80;
import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ot1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f2302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2303a;

    public ot1(View view, kv1 kv1Var, p80.b bVar) {
        this.f2303a = view;
        this.f7055a = kv1Var;
        this.f2302a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Scene.f4798a.a(new mt1(this, null));
        this.f7055a.L1(new nt1(this));
    }
}
