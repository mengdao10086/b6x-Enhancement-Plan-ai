package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ah1 extends g92 implements g82<Integer, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f5607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivitySwap.y f67a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah1(ActivitySwap.y yVar, View view) {
        super(1);
        this.f67a = yVar;
        this.f5607a = view;
    }

    public final void a(int i) {
        if (i > -1) {
            String str = this.f67a.f5539a[i];
            View view = this.f5607a;
            if (view == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView) view).setText(str);
        }
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Integer num) {
        a(num.intValue());
        return m42.f6769a;
    }
}
