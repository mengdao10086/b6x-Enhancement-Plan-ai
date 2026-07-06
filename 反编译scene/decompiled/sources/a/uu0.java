package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.ModeSwitcher$execNext$1", f = "ModeSwitcher.kt", l = {318, 329}, m = "invokeSuspend")
public final class uu0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wu0 f3214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3215a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3216b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu0(wu0 wu0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3214a = wu0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        uu0 uu0Var = new uu0(this.f3214a, b62Var);
        uu0Var.f7632a = (wd2) obj;
        return uu0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((uu0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[Catch: Exception -> 0x0039, TRY_ENTER, TryCatch #0 {Exception -> 0x0039, blocks: (B:30:0x009e, B:32:0x00b5, B:18:0x0043, B:20:0x005e, B:23:0x006f, B:25:0x0086, B:27:0x008d, B:33:0x00be), top: B:39:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:30:0x009e, B:32:0x00b5, B:18:0x0043, B:20:0x005e, B:23:0x006f, B:25:0x0086, B:27:0x008d, B:33:0x00be), top: B:39:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:30:0x009e, B:32:0x00b5, B:18:0x0043, B:20:0x005e, B:23:0x006f, B:25:0x0086, B:27:0x008d, B:33:0x00be), top: B:39:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #0 {Exception -> 0x0039, blocks: (B:30:0x009e, B:32:0x00b5, B:18:0x0043, B:20:0x005e, B:23:0x006f, B:25:0x0086, B:27:0x008d, B:33:0x00be), top: B:39:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b5 -> B:16:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00be -> B:16:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x0039
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // a.s62
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.uu0.j(java.lang.Object):java.lang.Object");
    }
}
