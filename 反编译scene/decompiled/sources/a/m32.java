package a;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m32 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n32 f6765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Activity f1886a;

    public m32(n32 n32Var, Activity activity) {
        this.f6765a = n32Var;
        this.f1886a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6765a.f6871a.e(this.f6765a.f6871a.c());
        this.f1886a.recreate();
    }
}
