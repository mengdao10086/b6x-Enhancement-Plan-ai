package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wr0 f5925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f591a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public dp1(Activity activity) {
        f92.d(activity, "context");
        this.f590a = activity;
        this.f591a = "features/refresh_rate.conf";
        this.b = "features/bypass_power.conf";
        this.c = "features/limiter.conf";
        this.d = "features/fas.conf";
        this.e = "features/cpuset.conf";
        this.f5925a = new wr0();
    }

    public final String f() {
        String strH = Scene.f4798a.h(hz0.f1282a.x(), "");
        return strH != null ? strH : "normal";
    }

    public final Activity g() {
        return this.f590a;
    }

    public final void h() {
        View viewInflate = this.f590a.getLayoutInflater().inflate(2131558518, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f590a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        String strE = wu0.f3480a.e();
        boolean zK = new ez0().k();
        boolean zA = f92.a("SOURCE_SCENE_ONLINE", strE);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.bypass_enable);
        CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.refresh_rate_enable);
        viewInflate.findViewById(t61.custom_features_faq).setOnClickListener(new yo1(this));
        View viewFindViewById = viewInflate.findViewById(t61.bypass_power_supply);
        int i = 8;
        viewFindViewById.setVisibility(new hl0().g() ? 0 : 8);
        TextView textView = (TextView) viewFindViewById.findViewById(t61.bypass_text);
        String string = textView.getContext().getString(u61.schedule_feature_details);
        f92.c(string, "context.getString(R.stri…schedule_feature_details)");
        kk0.a(textView, string, new to1(textView, this, compoundButton));
        f92.c(compoundButton, "bypass");
        compoundButton.setChecked(new rx0(viewFindViewById.getContext(), this.b).b("enable", false));
        if (zK) {
            View viewFindViewById2 = viewInflate.findViewById(t61.refresh_rate);
            f92.c(viewFindViewById2, "view.findViewById<View>(R.id.refresh_rate)");
            viewFindViewById2.setVisibility(0);
            f92.c(compoundButton2, "refreshRate");
            compoundButton2.setChecked(new rx0(this.f590a, this.f591a).b("enable", false));
            TextView textView2 = (TextView) viewInflate.findViewById(t61.refresh_rate_text);
            String string2 = textView2.getContext().getString(u61.schedule_feature_details);
            f92.c(string2, "context.getString(R.stri…schedule_feature_details)");
            kk0.a(textView2, string2, new uo1(textView2, this));
        }
        viewInflate.findViewById(t61.cpus_control).setOnClickListener(new zo1(this));
        View viewFindViewById3 = viewInflate.findViewById(t61.cpus_limiter);
        if (zA && (!f92.a(f(), "ep"))) {
            if (!f92.a(new wu0().p() != null ? r5.f() : null, Boolean.FALSE)) {
                viewFindViewById3.setOnClickListener(new vo1(viewFindViewById3, this, zA));
                i = 0;
            }
        }
        viewFindViewById3.setVisibility(i);
        viewInflate.findViewById(t61.env).setOnClickListener(new ap1(this));
        if (this.f5925a.o()) {
            View viewFindViewById4 = viewInflate.findViewById(t61.fas);
            viewFindViewById4.setVisibility(0);
            viewFindViewById4.setOnClickListener(new wo1(viewFindViewById4, this));
        }
        viewInflate.findViewById(2131362070).setOnClickListener(new bp1(this, bVarT, zK, compoundButton2, compoundButton));
        viewInflate.findViewById(2131362069).setOnClickListener(new cp1(bVarT));
        bVarT.h(xo1.f7910a);
    }
}
