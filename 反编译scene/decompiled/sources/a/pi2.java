package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pi2 extends g92 implements k82<Object, i62, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pi2 f7123a = new pi2();

    public pi2() {
        super(2);
    }

    @Override // a.k82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Object d(Object obj, i62 i62Var) {
        if (!(i62Var instanceof pg2)) {
            return obj;
        }
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? i62Var : Integer.valueOf(iIntValue + 1);
    }
}
