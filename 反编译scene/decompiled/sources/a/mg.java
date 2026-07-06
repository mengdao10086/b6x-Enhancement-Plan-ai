package a;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6805a;
    public int b;

    public mg(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f6805a | this.b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.b = i;
        } else {
            this.f6805a = i;
        }
    }

    public void d(View view, int i) {
        if (i == 1) {
            this.b = 0;
        } else {
            this.f6805a = 0;
        }
    }
}
