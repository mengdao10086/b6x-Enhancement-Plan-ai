package a;

import android.graphics.Color;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kl0 f696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f697a;

    public e51() {
        kl0 kl0Var = new kl0();
        this.f696a = kl0Var;
        this.f697a = kl0Var.f();
        this.f5968a = this.f696a.l(0);
    }

    public final ArrayList<Integer> a() {
        return (this.f5968a < 2700000 || this.f697a.size() != 2) ? this.f697a.size() > 3 ? y42.c(Integer.valueOf(Color.parseColor("#B177E3")), Integer.valueOf(Color.parseColor("#00d5d9")), Integer.valueOf(Color.parseColor("#00B9C2")), Integer.valueOf(Color.parseColor("#fc8a1b"))) : y42.c(Integer.valueOf(Color.parseColor("#B177E3")), Integer.valueOf(Color.parseColor("#00d5d9")), Integer.valueOf(Color.parseColor("#fc8a1b")), Integer.valueOf(Color.parseColor("#fc8a1b"))) : y42.c(Integer.valueOf(Color.parseColor("#00d5d9")), Integer.valueOf(Color.parseColor("#fc8a1b")), Integer.valueOf(Color.parseColor("#fc8a1b")), Integer.valueOf(Color.parseColor("#fc8a1b")));
    }
}
