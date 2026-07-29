package fi;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static int a(RecyclerView recyclerView) {
        return new ci.a(recyclerView).a();
    }

    public static int b(RecyclerView recyclerView) {
        return new ci.a(recyclerView).b();
    }

    public static int c(RecyclerView recyclerView) {
        return new ci.a(recyclerView).f();
    }

    public static int d(RecyclerView recyclerView) {
        return new ci.a(recyclerView).d();
    }

    @n0
    public static String e(@p0 Object obj) {
        return obj == null ? i0.f11859x : obj.getClass().getSimpleName();
    }

    @SuppressLint({"SwitchIntDef"})
    @n0
    public static String f(int i10) {
        return i10 != 1 ? i10 != 2 ? "IDLE" : "MULTI" : "SINGLE";
    }

    public static int g(RecyclerView recyclerView) {
        return new ci.a(recyclerView).c();
    }

    public static int h(RecyclerView recyclerView) {
        return new ci.a(recyclerView).e();
    }
}
