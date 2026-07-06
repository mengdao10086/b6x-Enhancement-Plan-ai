package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj1 f7604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f3184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f3185a;

    public uj1(Activity activity, Integer num, qj1 qj1Var) {
        f92.d(activity, "context");
        f92.d(qj1Var, "iResultCallback");
        this.f3184a = activity;
        this.f3185a = num;
        this.f7604a = qj1Var;
    }

    public final qj1 a() {
        return this.f7604a;
    }

    public final String b(Integer num) {
        return new rj1(this.f3184a).a(num);
    }

    public final void c() {
        View viewInflate = this.f3184a.getLayoutInflater().inflate(2131558539, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f3184a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        View viewFindViewById = viewInflate.findViewById(t61.orientation_default);
        CompoundButton compoundButton = (CompoundButton) viewFindViewById;
        compoundButton.setTag(-1);
        m42 m42Var = m42.f6769a;
        f92.c(viewFindViewById, "view.findViewById<Compou…ECIFIED\n                }");
        View viewFindViewById2 = viewInflate.findViewById(t61.orientation_sensor_force);
        CompoundButton compoundButton2 = (CompoundButton) viewFindViewById2;
        compoundButton2.setTag(10);
        m42 m42Var2 = m42.f6769a;
        f92.c(viewFindViewById2, "view.findViewById<Compou…_SENSOR\n                }");
        View viewFindViewById3 = viewInflate.findViewById(t61.orientation_sensor_auto);
        CompoundButton compoundButton3 = (CompoundButton) viewFindViewById3;
        compoundButton3.setTag(13);
        m42 m42Var3 = m42.f6769a;
        f92.c(viewFindViewById3, "view.findViewById<Compou…LL_USER\n                }");
        View viewFindViewById4 = viewInflate.findViewById(t61.orientation_landscape);
        CompoundButton compoundButton4 = (CompoundButton) viewFindViewById4;
        compoundButton4.setTag(6);
        m42 m42Var4 = m42.f6769a;
        f92.c(viewFindViewById4, "view.findViewById<Compou…NDSCAPE\n                }");
        View viewFindViewById5 = viewInflate.findViewById(t61.orientation_portrait);
        CompoundButton compoundButton5 = (CompoundButton) viewFindViewById5;
        compoundButton5.setTag(7);
        m42 m42Var5 = m42.f6769a;
        f92.c(viewFindViewById5, "view.findViewById<Compou…ORTRAIT\n                }");
        fj0 fj0Var = new fj0(compoundButton, compoundButton2, compoundButton3, compoundButton4, compoundButton5);
        Integer num = this.f3185a;
        if (num != null) {
            fj0Var.i(num);
        }
        viewInflate.findViewById(2131362069).setOnClickListener(new sj1(bVarT));
        viewInflate.findViewById(2131362070).setOnClickListener(new tj1(this, bVarT, fj0Var));
    }
}
