package a;

import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextDirectionHeuristic f3270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f3271a;
    public int b;

    public ve(TextPaint textPaint) {
        this.f3271a = textPaint;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f7685a = 1;
            this.b = 1;
        } else {
            this.b = 0;
            this.f7685a = 0;
        }
        this.f3270a = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
    }

    public we a() {
        return new we(this.f3271a, this.f3270a, this.f7685a, this.b);
    }

    public ve b(int i) {
        this.f7685a = i;
        return this;
    }

    public ve c(int i) {
        this.b = i;
        return this;
    }

    public ve d(TextDirectionHeuristic textDirectionHeuristic) {
        this.f3270a = textDirectionHeuristic;
        return this;
    }
}
