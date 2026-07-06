package a;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l30 extends g30 {
    public l30() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l30(g82<? super l30, m42> g82Var) {
        this();
        f92.d(g82Var, "init");
        g82Var.f(this);
    }

    public final <T> void D(String str, Iterable<? extends T> iterable) throws Exception {
        f92.d(str, "$this$to");
        f92.d(iterable, "values");
        d30 d30Var = new d30();
        for (T t : iterable) {
            if (t instanceof y32) {
                throw new Exception(d30Var + " 函数不能作为数据，请避免将 json{ ... } 写成 { ... }");
            }
            d30Var.k(t);
        }
        m42 m42Var = m42.f6769a;
        x(str, d30Var);
    }

    public final <T> void E(String str, T t) {
        f92.d(str, "$this$to");
        x(str, t);
    }

    public final <T> void F(String str, Map<String, ? extends T> map) throws Exception {
        f92.d(str, "$this$to");
        f92.d(map, "values");
        g30 g30Var = new g30();
        for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
            if (entry.getValue() instanceof y32) {
                throw new Exception(g30Var + " 函数不能作为数据，请避免将 json{ ... } 写成 { ... }");
            }
            g30Var.x(entry.getKey(), entry.getValue());
        }
        m42 m42Var = m42.f6769a;
        x(str, g30Var);
    }

    public final void G(String str, g82<? super l30, m42> g82Var) {
        f92.d(str, "$this$to");
        f92.d(g82Var, "params");
        l30 l30Var = new l30();
        g82Var.f(l30Var);
        x(str, l30Var);
    }

    public final <T> void H(String str, T[] tArr) throws Exception {
        f92.d(str, "$this$to");
        f92.d(tArr, "values");
        d30 d30Var = new d30();
        for (T t : tArr) {
            if (t instanceof y32) {
                throw new Exception(d30Var + " 函数不能作为数据，请避免将 json{ ... } 写成 { ... }");
            }
            d30Var.k(t);
        }
        m42 m42Var = m42.f6769a;
        x(str, d30Var);
    }

    public final void I(String str, g82<l30, m42>[] g82VarArr) {
        f92.d(str, "$this$to");
        f92.d(g82VarArr, "values");
        x(str, new m30((g82<? super l30, m42>[]) Arrays.copyOf(g82VarArr, g82VarArr.length)));
    }
}
