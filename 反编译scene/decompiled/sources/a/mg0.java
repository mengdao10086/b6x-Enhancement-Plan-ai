package a;

import android.view.View;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mg0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeekBar f6806a;

    public mg0(SeekBar seekBar) {
        this.f6806a = seekBar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SeekBar seekBar = this.f6806a;
        f92.c(seekBar, "seekbar");
        if (seekBar.getProgress() > 0) {
            SeekBar seekBar2 = this.f6806a;
            f92.c(seekBar2, "seekbar");
            seekBar2.setProgress(seekBar2.getProgress() - 1);
        }
    }
}
