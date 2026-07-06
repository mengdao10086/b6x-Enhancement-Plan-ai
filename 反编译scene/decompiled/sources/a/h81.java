package a;

import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityAppDetails;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h81 implements qj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppDetails.g f1137a;

    public h81(ActivityAppDetails.g gVar, View view) {
        this.f1137a = gVar;
        this.f6286a = view;
    }

    @Override // a.qj1
    public void a(int i, String str) {
        ActivityAppDetails.this.C().screenOrientation = i;
        View view = this.f6286a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        ((TextView) view).setText("" + str);
    }
}
