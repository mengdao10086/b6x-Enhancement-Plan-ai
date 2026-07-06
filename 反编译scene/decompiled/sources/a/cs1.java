package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cs1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f5825a;

    public cs1(zs1 zs1Var) {
        this.f5825a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView = (TextView) this.f5825a.w1(t61.home_raminfo_text);
        f92.c(textView, "home_raminfo_text");
        textView.setText(this.f5825a.J(u61.please_wait));
        Scene.f4798a.a(new zr1(this, null));
    }
}
