package a;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityProcess$onViewCreated$2$1", f = "ActivityProcess.kt", l = {87, 89}, m = "invokeSuspend")
public final class cf1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityProcess.c f392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f393a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f394b;
    public final /* synthetic */ int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Object f395c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf1(ActivityProcess.c cVar, int i, b62 b62Var) {
        super(2, b62Var);
        this.f392a = cVar;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        cf1 cf1Var = new cf1(this.f392a, this.c, b62Var);
        cf1Var.f5788a = (wd2) obj;
        return cf1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((cf1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [T, com.omarea.model.ProcessInfo] */
    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        n92 n92Var;
        n92 n92Var2;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f5788a;
            n92Var = new n92();
            ActivityProcess activityProcess = ActivityProcess.this;
            ListView listView = (ListView) activityProcess._$_findCachedViewById(t61.process_list);
            f92.c(listView, "process_list");
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterProcess");
            }
            ProcessInfo item = ((a21) adapter).getItem(this.c);
            this.f393a = wd2Var;
            this.f394b = n92Var;
            this.f395c = n92Var;
            this.b = 1;
            obj = activityProcess.n(item, this);
            if (obj == objC) {
                return objC;
            }
            n92Var2 = n92Var;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            n92Var = (n92) this.f395c;
            n92Var2 = (n92) this.f394b;
            wd2Var = (wd2) this.f393a;
            h42.b(obj);
        }
        n92Var.f6891a = (ProcessInfo) obj;
        fg2 fg2VarC = qe2.c();
        bf1 bf1Var = new bf1(this, n92Var2, null);
        this.f393a = wd2Var;
        this.f394b = n92Var2;
        this.b = 2;
        if (oc2.g(fg2VarC, bf1Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
