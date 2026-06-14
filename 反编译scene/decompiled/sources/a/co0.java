package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class co0 extends r50 {
    public final int c;
    public final int d;

    /* JADX WARN: Multi-variable type inference failed */
    public co0() {
        super(null, 1, 0 == true ? 1 : 0);
        this.c = 10000;
        this.d = 10000;
    }

    public final void A(String str, String str2) {
        f92.d(str, "cloudId");
        f92.d(str2, "remark");
        try {
            String str3 = no0.f6937a.a() + "/pvp/user-report-remark";
            String string = new l30(new bo0(str, str2)).toString();
            f92.c(string, "json {\n                \"…\n            }.toString()");
            s(str3, string);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final d42<String, String> B(String str) {
        f92.d(str, "json");
        if (!x()) {
            return null;
        }
        try {
            String str2 = no0.f6937a.a() + "/pvp/user-report-put";
            byte[] bytes = str.getBytes(bb2.f5692a);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            g30 g30Var = new g30(r50.r(this, str2, bytes, null, 4, null));
            if (!f92.a(g30Var.i("status"), "ok")) {
                return null;
            }
            String strI = g30Var.i("id");
            String strI2 = g30Var.i("url");
            f92.c(strI, "id");
            f92.c(strI2, "url");
            return new d42<>(strI, strI2);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override // a.r50
    public int h() {
        return this.c;
    }

    @Override // a.r50
    public int i() {
        return this.d;
    }

    public final boolean x() {
        try {
            return ec2.C(s(no0.f6937a.a() + "/pvp/user-report-allowed", "{}"), "true", false, 2, null);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public final String y(String str) {
        f92.d(str, "id");
        try {
            String str2 = no0.f6937a.a() + "/pvp/user-report-delete";
            String string = new l30(new zn0(str)).toString();
            f92.c(string, "json {\n                \"…\n            }.toString()");
            return s(str2, string);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public final String z(String str) {
        f92.d(str, "id");
        try {
            String str2 = no0.f6937a.a() + "/pvp/user-report-url";
            String string = new l30(new ao0(str)).toString();
            f92.c(string, "json {\n                \"…\n            }.toString()");
            return s(str2, string);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
