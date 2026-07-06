package a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class es1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6037a;

    public es1(zs1 zs1Var) {
        this.f6037a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = (TextView) this.f6037a.w1(t61.home_zramsize_text);
        f92.c(textView, "home_zramsize_text");
        textView.setText(this.f6037a.L(u61.please_wait));
        Context contextP = this.f6037a.p();
        f92.b(contextP);
        Toast.makeText(contextP, u61.home_shell_begin, 0).show();
        Scene.f4798a.a(new ds1(this, null));
    }
}
