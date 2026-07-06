package a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f3464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RecyclerView.o f3465a;

    public wp(RecyclerView.o oVar) {
        this.f7810a = Integer.MIN_VALUE;
        this.f3464a = new Rect();
        this.f3465a = oVar;
    }

    public /* synthetic */ wp(RecyclerView.o oVar, up upVar) {
        this(oVar);
    }

    public static wp a(RecyclerView.o oVar) {
        return new up(oVar);
    }

    public static wp b(RecyclerView.o oVar, int i) {
        if (i == 0) {
            return a(oVar);
        }
        if (i == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static wp c(RecyclerView.o oVar) {
        return new vp(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f7810a) {
            return 0;
        }
        return n() - this.f7810a;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.f7810a = n();
    }
}
