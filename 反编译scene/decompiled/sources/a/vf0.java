package a;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vf0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ag0 f7690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Button f3274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f3275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SeekBar f3276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3277a;
    public final /* synthetic */ SeekBar b;
    public final /* synthetic */ SeekBar c;
    public final /* synthetic */ SeekBar d;

    public vf0(ag0 ag0Var, SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, Button button, TextView textView, ImageView imageView, View view) {
        this.f7690a = ag0Var;
        this.f3276a = seekBar;
        this.b = seekBar2;
        this.c = seekBar3;
        this.d = seekBar4;
        this.f3274a = button;
        this.f3277a = textView;
        this.f3275a = imageView;
        this.f3273a = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SeekBar seekBar = this.f3276a;
        f92.c(seekBar, "alphaBar");
        int progress = seekBar.getProgress();
        SeekBar seekBar2 = this.b;
        f92.c(seekBar2, "redBar");
        int progress2 = seekBar2.getProgress();
        SeekBar seekBar3 = this.c;
        f92.c(seekBar3, "greenBar");
        int progress3 = seekBar3.getProgress();
        SeekBar seekBar4 = this.d;
        f92.c(seekBar4, "blueBar");
        int iArgb = Color.argb(progress, progress2, progress3, seekBar4.getProgress());
        this.f3274a.setBackgroundColor(iArgb);
        try {
            TextView textView = this.f3277a;
            ag0 ag0Var = this.f7690a;
            SeekBar seekBar5 = this.f3276a;
            f92.c(seekBar5, "alphaBar");
            int progress4 = seekBar5.getProgress();
            SeekBar seekBar6 = this.b;
            f92.c(seekBar6, "redBar");
            int progress5 = seekBar6.getProgress();
            SeekBar seekBar7 = this.c;
            f92.c(seekBar7, "greenBar");
            int progress6 = seekBar7.getProgress();
            SeekBar seekBar8 = this.d;
            f92.c(seekBar8, "blueBar");
            textView.setText(ag0Var.f(progress4, progress5, progress6, seekBar8.getProgress()));
            this.f3275a.setVisibility(8);
            this.f3273a.setBackground(new ColorDrawable(iArgb));
        } catch (Exception unused) {
        }
    }
}
