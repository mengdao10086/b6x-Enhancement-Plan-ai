package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jj0 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g82 f6516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1548a;

    public jj0(TextView textView, g82 g82Var) {
        this.f1548a = textView;
        this.f6516a = g82Var;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f1548a.setText((CharSequence) this.f6516a.f(Integer.valueOf(i)));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
