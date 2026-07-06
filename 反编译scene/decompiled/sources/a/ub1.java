package a;

import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ub1 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f7582a;

    public ub1(TextView textView) {
        this.f7582a = textView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        TextView textView = this.f7582a;
        f92.c(textView, "freeze_time_limit_text");
        textView.setText(String.valueOf(i));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar != null) {
            Scene.f4798a.g().edit().putInt(hz0.f1282a.N(), seekBar.getProgress()).apply();
        }
    }
}
