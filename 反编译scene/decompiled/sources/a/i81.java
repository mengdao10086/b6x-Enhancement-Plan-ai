package a;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityAppDetails;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i81 implements vj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f6385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppDetails.o f1340a;

    public i81(ActivityAppDetails.o oVar, SharedPreferences sharedPreferences, View view) {
        this.f1340a = oVar;
        this.f6385a = sharedPreferences;
        this.f1339a = view;
    }

    @Override // a.vj1
    public void a(String str) {
        SharedPreferences.Editor editorEdit = this.f6385a.edit();
        (str == null || str.length() == 0 ? editorEdit.remove(ActivityAppDetails.this.y()) : editorEdit.putString(ActivityAppDetails.this.y(), str)).apply();
        View view = this.f1339a;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        ((TextView) view).setText(wu0.f3480a.k("" + str));
        ActivityAppDetails.this.f8518a = -1;
        ActivityAppDetails activityAppDetails = ActivityAppDetails.this;
        activityAppDetails.E(activityAppDetails.y(), "" + str);
    }
}
