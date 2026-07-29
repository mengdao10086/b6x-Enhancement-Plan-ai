package eg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends Dialog {
    public c(@n0 Context context) {
        super(context);
    }

    @p0
    public abstract View a();

    @n0
    public abstract List<String> b();

    @n0
    public abstract View c();

    public c(@n0 Context context, int i10) {
        super(context, i10);
    }

    public c(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
    }
}
