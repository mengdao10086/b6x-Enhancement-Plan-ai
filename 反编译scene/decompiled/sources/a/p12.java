package a;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p12 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u12 f7074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageButton f2353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f2354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2355a;
    public final /* synthetic */ ImageButton b;

    public p12(u12 u12Var, ListView listView, TextView textView, ImageButton imageButton, ImageButton imageButton2) {
        this.f7074a = u12Var;
        this.f2354a = listView;
        this.f2355a = textView;
        this.f2353a = imageButton;
        this.b = imageButton2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f2354a.getVisibility() == 0) {
            this.f2354a.setVisibility(8);
            this.f2355a.setVisibility(8);
            this.f2353a.setVisibility(8);
            this.b.setImageDrawable(yb.d(this.f7074a.f3113a, 2131230895));
            this.f7074a.s();
            return;
        }
        this.f2354a.setVisibility(0);
        this.f2355a.setVisibility(0);
        this.f2353a.setVisibility(0);
        this.b.setImageDrawable(yb.d(this.f7074a.f3113a, 2131230896));
        this.f7074a.r();
    }
}
