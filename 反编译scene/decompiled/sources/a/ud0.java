package a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.omarea.krscript.model.ClickableNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ud0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vd0 f7586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Intent f3170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ClickableNode f3171a;

    public ud0(vd0 vd0Var, Intent intent, ClickableNode clickableNode) {
        this.f7586a = vd0Var;
        this.f3170a = intent;
        this.f3171a = clickableNode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextP = this.f7586a.f7682a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        dd0 dd0Var = new dd0(contextP);
        Intent intent = this.f3170a;
        jc0 jc0Var = new jc0();
        Context contextP2 = this.f7586a.f7682a.p();
        f92.b(contextP2);
        f92.c(contextP2, "context!!");
        (!dd0Var.a(intent, jc0Var.c(contextP2, this.f3171a), this.f3171a) ? Toast.makeText(this.f7586a.f7682a.p(), ob0.kr_shortcut_create_fail, 0) : Toast.makeText(this.f7586a.f7682a.p(), this.f7586a.f7682a.J(ob0.kr_shortcut_create_success), 0)).show();
    }
}
