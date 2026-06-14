package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f6327a;

    public hn1(Activity activity) {
        f92.d(activity, "context");
        this.f6327a = activity;
    }

    public final void a() {
        View viewInflate = this.f6327a.getLayoutInflater().inflate(2131558520, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f6327a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.monitor_perf);
        compoundButton.setChecked(f92.a(ox1.f7064a.a(), Boolean.TRUE));
        compoundButton.setOnClickListener(new an1(compoundButton));
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.monitor_proc);
        compoundButton2.setChecked(u12.f3107a.b());
        compoundButton2.setOnClickListener(new bn1(compoundButton2));
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.monitor_threads);
        compoundButton3.setChecked(iz1.f6457a.b());
        compoundButton3.setOnClickListener(new cn1(compoundButton3));
        CompoundButton compoundButton4 = (CompoundButton) viewInflate.findViewById(t61.monitor_game);
        compoundButton4.setChecked(f92.a(az1.f5657a.a(), Boolean.TRUE));
        compoundButton4.setOnClickListener(new dn1(compoundButton4));
        CompoundButton compoundButton5 = (CompoundButton) viewInflate.findViewById(t61.monitor_watch);
        compoundButton5.setChecked(f92.a(py1.f7160a.a(), Boolean.TRUE));
        compoundButton5.setOnClickListener(new en1(compoundButton5));
        CompoundButton compoundButton6 = (CompoundButton) viewInflate.findViewById(t61.monitor_temperature);
        compoundButton6.setChecked(f92.a(d22.f5853a.a(), Boolean.TRUE));
        compoundButton6.setOnClickListener(new fn1(compoundButton6));
        viewInflate.findViewById(2131362069).setOnClickListener(new gn1(bVarT));
    }
}
