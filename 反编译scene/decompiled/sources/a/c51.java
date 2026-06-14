package a;

import a.b51;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class c51 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b51.a f5762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ b51 f353a;

    public c51(b51.a aVar, b51 b51Var, View view) {
        this.f5762a = aVar;
        this.f353a = b51Var;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Object systemService = this.f353a.f233a.getSystemService("clipboard");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setText(this.f5762a.O().getText());
        Toast.makeText(this.f353a.f233a, this.f353a.f233a.getString(u61.apps_op_copied) + this.f5762a.O().getText(), 1).show();
        return true;
    }
}
