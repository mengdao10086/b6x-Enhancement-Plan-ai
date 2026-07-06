package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hn0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1195a = "/sys/kernel/thermal/ttj";
    public final String b = "/sys/class/thermal/thermal_message/dynamic_tj";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f1196a = {"/sys/kernel/thermal/ttj", "/sys/class/thermal/thermal_message/dynamic_tj"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f6326a = a42.a(new gn0(this));
    public final String c = "vtools.thermal.disguise";

    public final void b() {
        e50.f677a.c0(true);
    }

    public final boolean c() {
        return ((Boolean) this.f6326a.getValue()).booleanValue();
    }

    public final boolean d() {
        Integer numJ;
        Integer numJ2;
        d42<String, String> d42VarA = x60.f7856a.a(this.f1196a);
        if (d42VarA == null) {
            return f92.a(um0.f7612a.a(this.c), "1");
        }
        if (f92.a(d42VarA.c(), this.f1195a)) {
            String str = (String) i52.C(ec2.d0(bc2.t(d42VarA.d(), ",", "", false, 4, null), new String[]{" "}, false, 0, 6, null));
            int iIntValue = (str == null || (numJ2 = ac2.j(str)) == null) ? 0 : numJ2.intValue();
            return iIntValue > 95000 && iIntValue < 666666666;
        }
        if (f92.a(d42VarA.c(), this.b)) {
            return d42VarA.d().length() == 7;
        }
        String str2 = (String) i52.C(ec2.d0(bc2.t(x60.f7856a.d(this.f1195a), ",", "", false, 4, null), new String[]{" "}, false, 0, 6, null));
        return ((str2 == null || (numJ = ac2.j(str2)) == null) ? 0 : numJ.intValue()) > 95000;
    }

    public final void e() {
        e50.f677a.c0(false);
    }

    public final boolean f() {
        return c();
    }
}
