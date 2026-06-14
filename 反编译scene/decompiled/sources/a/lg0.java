package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lg0 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ og0 f6704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1799a;

    public lg0(og0 og0Var, TextView textView) {
        this.f6704a = og0Var;
        this.f1799a = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView = this.f1799a;
        f92.c(textView, "textView");
        textView.setText(String.valueOf(i + this.f6704a.f2243a.getMin()));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
