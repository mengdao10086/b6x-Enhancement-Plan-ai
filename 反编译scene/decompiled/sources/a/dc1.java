package a;

import android.content.Context;
import android.os.Build;
import androidx.recyclerview.widget.GridLayoutManager;
import com.omarea.ui.BlurViewRecyclerView;
import com.omarea.vtools.activities.ActivityFreezeApps;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityFreezeApps$loadData$1$2", f = "ActivityFreezeApps.kt", l = {}, m = "invokeSuspend")
public final class dc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFreezeApps.s f548a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f549b;
    public final /* synthetic */ n92 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc1(ActivityFreezeApps.s sVar, n92 n92Var, n92 n92Var2, n92 n92Var3, b62 b62Var) {
        super(2, b62Var);
        this.f548a = sVar;
        this.f5883a = n92Var;
        this.f549b = n92Var2;
        this.c = n92Var3;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        dc1 dc1Var = new dc1(this.f548a, this.f5883a, this.f549b, this.c, b62Var);
        dc1Var.f547a = (wd2) obj;
        return dc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((dc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        try {
            Context applicationContext = ActivityFreezeApps.this.getApplicationContext();
            f92.c(applicationContext, "applicationContext");
            zz0 zz0Var = new zz0(applicationContext, (ArrayList) this.f5883a.f6891a);
            BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps);
            if (blurViewRecyclerView != null) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(blurViewRecyclerView.getContext(), 4);
                m42 m42Var = m42.f6769a;
                blurViewRecyclerView.setLayoutManager(gridLayoutManager);
                blurViewRecyclerView.setAdapter(zz0Var);
                e61 e61Var = new e61(zz0Var, ActivityFreezeApps.this.editingState);
                new np(e61Var).l((BlurViewRecyclerView) ActivityFreezeApps.this._$_findCachedViewById(t61.freeze_apps));
                zz0Var.J(new bc1(blurViewRecyclerView, this, zz0Var));
                zz0Var.K(new cc1(blurViewRecyclerView, e61Var, this, zz0Var));
            }
            ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
            if (Build.VERSION.SDK_INT >= 26 && ((ArrayList) this.f549b.f6891a).size() > 0) {
                ActivityFreezeApps activityFreezeApps = ActivityFreezeApps.this;
                String string = ((StringBuilder) this.c.f6891a).toString();
                f92.c(string, "lostedShortcutsName.toString()");
                activityFreezeApps.shortcutsLostDialog(string, (ArrayList) this.f549b.f6891a);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
