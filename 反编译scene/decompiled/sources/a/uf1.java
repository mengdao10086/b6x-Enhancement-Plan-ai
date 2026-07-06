package a;

import a.p80;
import android.os.Build;
import android.widget.TextView;
import com.omarea.vtools.activities.ActivityStartSplash;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityStartSplash$checkPermissionsADB$1$1", f = "ActivityStartSplash.kt", l = {}, m = "invokeSuspend")
public final class uf1 extends d72 implements k82<wd2, b62<? super Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityStartSplash.e f3173a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf1(ActivityStartSplash.e eVar, b62 b62Var) {
        super(2, b62Var);
        this.f3173a = eVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        uf1 uf1Var = new uf1(this.f3173a, b62Var);
        uf1Var.f7592a = (wd2) obj;
        return uf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super Object> b62Var) {
        return ((uf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        p80.b bVarB;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = (TextView) ActivityStartSplash.this._$_findCachedViewById(t61.start_state_text);
        f92.c(textView, "start_state_text");
        textView.setText(ActivityStartSplash.this.getString(u61.scene_working_mode));
        try {
            if (Build.VERSION.SDK_INT <= 30) {
                p80.a aVar = p80.f2403a;
                ActivityStartSplash activityStartSplash = ActivityStartSplash.this;
                String string = ActivityStartSplash.this.getString(u61.scene_adb_tip);
                f92.c(string, "getString(R.string.scene_adb_tip)");
                bVarB = p80.a.B(aVar, activityStartSplash, string, "adb shell sh " + ActivityStartSplash.this.f5482a, null, 8, null);
            } else {
                p80.a aVar2 = p80.f2403a;
                ActivityStartSplash activityStartSplash2 = ActivityStartSplash.this;
                String string2 = ActivityStartSplash.this.getString(u61.scene_adb_tip);
                f92.c(string2, "getString(R.string.scene_adb_tip)");
                bVarB = p80.a.B(aVar2, activityStartSplash2, string2, "adb shell sh " + ActivityStartSplash.this.f5485b, null, 8, null);
            }
            return bVarB;
        } catch (Exception unused) {
            return m42.f6769a;
        }
    }
}
