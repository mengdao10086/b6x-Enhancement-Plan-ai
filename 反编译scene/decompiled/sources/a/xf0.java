package a;

import android.graphics.Color;
import android.widget.Button;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xf0 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Button f7883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SeekBar f3578a;
    public final /* synthetic */ SeekBar b;
    public final /* synthetic */ SeekBar c;
    public final /* synthetic */ SeekBar d;

    public xf0(SeekBar seekBar, SeekBar seekBar2, SeekBar seekBar3, SeekBar seekBar4, Button button) {
        this.f3578a = seekBar;
        this.b = seekBar2;
        this.c = seekBar3;
        this.d = seekBar4;
        this.f7883a = button;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        f92.d(seekBar, "seekBar");
        SeekBar seekBar2 = this.f3578a;
        f92.c(seekBar2, "alphaBar");
        int progress = seekBar2.getProgress();
        SeekBar seekBar3 = this.b;
        f92.c(seekBar3, "redBar");
        int progress2 = seekBar3.getProgress();
        SeekBar seekBar4 = this.c;
        f92.c(seekBar4, "greenBar");
        int progress3 = seekBar4.getProgress();
        SeekBar seekBar5 = this.d;
        f92.c(seekBar5, "blueBar");
        this.f7883a.setBackgroundColor(Color.argb(progress, progress2, progress3, seekBar5.getProgress()));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        f92.d(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        f92.d(seekBar, "seekBar");
    }
}
