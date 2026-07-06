package a;

import android.widget.ListAdapter;
import com.omarea.common.ui.OverScrollListView;
import com.omarea.vtools.activities.ActivityAppRetrieve;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppRetrieve$loadData$1$2", f = "ActivityAppRetrieve.kt", l = {}, m = "invokeSuspend")
public final class o81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppRetrieve.a f2218a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o81(ActivityAppRetrieve.a aVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f2218a = aVar;
        this.f6995a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        o81 o81Var = new o81(this.f2218a, this.f6995a, b62Var);
        o81Var.f2217a = (wd2) obj;
        return o81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((o81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        ActivityAppRetrieve.m(ActivityAppRetrieve.this).c();
        if (((OverScrollListView) ActivityAppRetrieve.this._$_findCachedViewById(t61.hidden_app)) != null) {
            p01 p01Var = new p01(ActivityAppRetrieve.this.getContext(), (ArrayList) this.f6995a.f6891a, null, false, 12, null);
            OverScrollListView overScrollListView = (OverScrollListView) ActivityAppRetrieve.this._$_findCachedViewById(t61.hidden_app);
            f92.c(overScrollListView, "hidden_app");
            overScrollListView.setAdapter((ListAdapter) p01Var);
            ActivityAppRetrieve.this.f5151a = new WeakReference(p01Var);
            OverScrollListView overScrollListView2 = (OverScrollListView) ActivityAppRetrieve.this._$_findCachedViewById(t61.hidden_app);
            f92.c(overScrollListView2, "hidden_app");
            overScrollListView2.setOnItemClickListener(new n81(this));
        }
        return m42.f6769a;
    }
}
