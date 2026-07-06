package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kj0 {
    public final void a(SeekBar seekBar, TextView textView, g82<? super Integer, String> g82Var) {
        f92.d(seekBar, "seekBar");
        f92.d(textView, "textView");
        f92.d(g82Var, "fmt");
        seekBar.setOnSeekBarChangeListener(new jj0(textView, g82Var));
        textView.setText(g82Var.f(Integer.valueOf(seekBar.getProgress())));
    }
}
