package cc;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d {
    public static boolean a(e eVar) {
        return eVar.getCount() == 0 || eVar.getPosition() == eVar.getCount();
    }

    public static boolean b(e eVar) {
        return eVar.getCount() == 0 || eVar.getPosition() == -1;
    }

    public static boolean c(e eVar) {
        return eVar.getPosition() == 0 && eVar.getCount() != 0;
    }

    public static boolean d(e eVar) {
        int count = eVar.getCount();
        return eVar.getPosition() == count + (-1) && count != 0;
    }

    public static boolean e(e eVar) {
        return eVar.moveToPosition(0);
    }

    public static boolean f(e eVar) {
        return eVar.moveToPosition(eVar.getCount() - 1);
    }

    public static boolean g(e eVar) {
        return eVar.moveToPosition(eVar.getPosition() + 1);
    }

    public static boolean h(e eVar) {
        return eVar.moveToPosition(eVar.getPosition() - 1);
    }
}
