package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xh0 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f7891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f3591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3592a;
    public final /* synthetic */ g82 b;

    public xh0(TextView textView, g82 g82Var, rh0 rh0Var, g82 g82Var2) {
        this.f3592a = textView;
        this.f7891a = g82Var;
        this.f3591a = rh0Var;
        this.b = g82Var2;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView = this.f3592a;
        if (textView != null) {
            textView.setText((CharSequence) this.f7891a.f(Integer.valueOf(seekBar != null ? seekBar.getProgress() : 0)));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        rh0 rh0Var = this.f3591a;
        g82 g82Var = this.b;
        f92.b(seekBar);
        rh0Var.a(g82Var.f(Integer.valueOf(seekBar.getProgress())));
    }
}
