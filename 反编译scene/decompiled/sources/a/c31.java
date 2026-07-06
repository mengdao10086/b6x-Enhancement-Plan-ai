package a;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.ui.Games;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.ui.Games$loadData$1$2", f = "Games.kt", l = {}, m = "invokeSuspend")
public final class c31 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Games.b f347a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ n92 f348b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c31(Games.b bVar, n92 n92Var, n92 n92Var2, b62 b62Var) {
        super(2, b62Var);
        this.f347a = bVar;
        this.f5756a = n92Var;
        this.f348b = n92Var2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        c31 c31Var = new c31(this.f347a, this.f5756a, this.f348b, b62Var);
        c31Var.f346a = (wd2) obj;
        return c31Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((c31) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (!Games.this.isAttachedToWindow()) {
            return m42.f6769a;
        }
        try {
            Context context = Games.this.getContext();
            f92.c(context, "context");
            Context applicationContext = context.getApplicationContext();
            f92.c(applicationContext, "context.applicationContext");
            zz0 zz0Var = new zz0(applicationContext, (ArrayList) this.f5756a.f6891a);
            e61 e61Var = new e61(zz0Var, Games.this.f4869a);
            np npVar = new np(e61Var);
            RecyclerView recyclerView = (RecyclerView) Games.this.a(t61.games);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
                recyclerView.setAdapter(zz0Var);
                npVar.l(recyclerView);
            }
            zz0Var.J(new a31(this, zz0Var));
            zz0Var.K(new b31(e61Var, this, zz0Var));
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
