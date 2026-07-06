package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gs1 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6239a;

    public gs1(zs1 zs1Var) {
        this.f6239a = zs1Var;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        TextView textView = (TextView) this.f6239a.w1(t61.home_zramsize_text);
        f92.c(textView, "home_zramsize_text");
        textView.setText(this.f6239a.L(u61.please_wait));
        Scene.f4798a.a(new fs1(this, null));
        return true;
    }
}
