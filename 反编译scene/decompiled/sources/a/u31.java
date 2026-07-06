package a;

import com.omarea.ui.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final /* synthetic */ class u31 extends e92 implements g82<Integer, String> {
    public u31(SeekBar seekBar) {
        super(1, seekBar, SeekBar.class, "defaultFormatter", "defaultFormatter(I)Ljava/lang/String;", 0);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return k(num.intValue());
    }

    public final String k(int i) {
        return ((SeekBar) ((x82) this).f3548a).d(i);
    }
}
