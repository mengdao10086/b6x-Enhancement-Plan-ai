package a;

import android.widget.ListView;
import com.omarea.vtools.activities.ActivityAppContents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppContents$setList$1$2", f = "ActivityAppContents.kt", l = {}, m = "invokeSuspend")
public final class f81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppContents.g f860a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f81(ActivityAppContents.g gVar, b62 b62Var) {
        super(2, b62Var);
        this.f860a = gVar;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        f81 f81Var = new f81(this.f860a, b62Var);
        f81Var.f6083a = (wd2) obj;
        return f81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((f81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityAppContents.n(ActivityAppContents.this).c();
        ListView listView = (ListView) ActivityAppContents.this._$_findCachedViewById(t61.app_list);
        if (listView != null) {
            ActivityAppContents activityAppContents = ActivityAppContents.this;
            activityAppContents.v(activityAppContents.f5129b, listView);
        }
        return m42.f6769a;
    }
}
