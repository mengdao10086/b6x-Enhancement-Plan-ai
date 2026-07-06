package a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fh2 extends gh2 implements je2 {
    public volatile fh2 _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fh2 f6107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f900a;
    public final boolean b;

    public fh2(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ fh2(Handler handler, String str, int i, b92 b92Var) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public fh2(Handler handler, String str, boolean z) {
        super(null);
        this.f899a = handler;
        this.f900a = str;
        this.b = z;
        this._immediate = z ? this : null;
        fh2 fh2Var = this._immediate;
        if (fh2Var == null) {
            fh2Var = new fh2(this.f899a, this.f900a, true);
            this._immediate = fh2Var;
            m42 m42Var = m42.f6769a;
        }
        this.f6107a = fh2Var;
    }

    @Override // a.je2
    public re2 e(long j, Runnable runnable) {
        this.f899a.postDelayed(runnable, ga2.e(j, 4611686018427387903L));
        return new ch2(this, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof fh2) && ((fh2) obj).f899a == this.f899a;
    }

    @Override // a.je2
    public void g(long j, tc2<? super m42> tc2Var) {
        dh2 dh2Var = new dh2(this, tc2Var);
        this.f899a.postDelayed(dh2Var, ga2.e(j, 4611686018427387903L));
        tc2Var.w(new eh2(this, dh2Var));
    }

    public int hashCode() {
        return System.identityHashCode(this.f899a);
    }

    @Override // a.od2
    public void l(l62 l62Var, Runnable runnable) {
        this.f899a.post(runnable);
    }

    @Override // a.od2
    public boolean o(l62 l62Var) {
        return !this.b || (f92.a(Looper.myLooper(), this.f899a.getLooper()) ^ true);
    }

    @Override // a.od2
    public String toString() {
        String strT = t();
        if (strT != null) {
            return strT;
        }
        String string = this.f900a;
        if (string == null) {
            string = this.f899a.toString();
        }
        if (!this.b) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // a.fg2
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public fh2 p() {
        return this.f6107a;
    }
}
