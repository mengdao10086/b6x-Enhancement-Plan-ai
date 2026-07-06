package a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ey1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ py1 f818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f819a;

    public ey1(py1 py1Var, Context context, n92 n92Var) {
        this.f818a = py1Var;
        this.f819a = context;
        this.f6054a = n92Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FrameLayout frameLayout = this.f818a.f2475a;
        if (frameLayout != null) {
            frameLayout.performHapticFeedback(1);
        }
        FrameLayout frameLayout2 = this.f818a.f2475a;
        if (frameLayout2 != null) {
            frameLayout2.setEnabled(false);
        }
        if (this.f818a.f2466a > 0) {
            this.f818a.E();
            Toast.makeText(this.f818a.f2473a, this.f819a.getString(u61.fps_record_stoped), 0).show();
            return;
        }
        double dP = fa0.f867a.p();
        if (dP >= 3.2d && dP < 10.0d) {
            qc2.d(xd2.a(qe2.b()), null, null, new dy1(this, view, null), 3, null);
            return;
        }
        Scene.c cVar = Scene.f4798a;
        String string = this.f819a.getString(u61.fps_voltage_error);
        f92.c(string, "context.getString(R.string.fps_voltage_error)");
        Scene.c.p(cVar, string, 0, 2, null);
    }
}
