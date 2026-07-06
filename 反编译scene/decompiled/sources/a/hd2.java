package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hd2 {
    public static final <T> Object a(Object obj, b62<? super T> b62Var) {
        if (obj instanceof gd2) {
            e42 e42Var = g42.f6169a;
            Throwable thJ = ((gd2) obj).f999a;
            if (be2.d() && (b62Var instanceof w62)) {
                thJ = ki2.j(thJ, (w62) b62Var);
            }
            obj = h42.a(thJ);
        } else {
            e42 e42Var2 = g42.f6169a;
        }
        g42.a(obj);
        return obj;
    }

    public static final <T> Object b(Object obj) {
        Throwable thB = g42.b(obj);
        return thB == null ? obj : new gd2(thB, false, 2, null);
    }

    public static final <T> Object c(Object obj, tc2<?> tc2Var) {
        Throwable thB = g42.b(obj);
        if (thB != null) {
            if (be2.d() && (tc2Var instanceof w62)) {
                thB = ki2.j(thB, (w62) tc2Var);
            }
            obj = new gd2(thB, false, 2, null);
        }
        return obj;
    }
}
