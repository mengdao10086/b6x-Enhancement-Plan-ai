package a;

import android.view.View;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ng0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeekBar f6912a;

    public ng0(SeekBar seekBar) {
        this.f6912a = seekBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SeekBar seekBar = this.f6912a;
        f92.c(seekBar, "seekbar");
        int progress = seekBar.getProgress();
        SeekBar seekBar2 = this.f6912a;
        f92.c(seekBar2, "seekbar");
        if (progress < seekBar2.getMax()) {
            SeekBar seekBar3 = this.f6912a;
            f92.c(seekBar3, "seekbar");
            seekBar3.setProgress(seekBar3.getProgress() + 1);
        }
    }
}
