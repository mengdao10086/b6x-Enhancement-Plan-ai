package a;

import android.view.View;
import android.widget.Switch;
import com.omarea.vtools.activities.ActivityFileSelector;
import com.omarea.vtools.activities.ActivityOtherSettings;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jd1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Switch f6502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityOtherSettings f1528a;

    public jd1(Switch r1, ActivityOtherSettings activityOtherSettings) {
        this.f6502a = r1;
        this.f1528a = activityOtherSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.f6502a.isChecked()) {
            sk0.f7408a.a().m();
            throw null;
        }
        ActivityOtherSettings activityOtherSettings = this.f1528a;
        activityOtherSettings.startActivityForResult(ActivityFileSelector.a.b(ActivityFileSelector.f8644a, activityOtherSettings, "xml", null, 4, null), 9999);
        this.f6502a.setChecked(false);
    }
}
