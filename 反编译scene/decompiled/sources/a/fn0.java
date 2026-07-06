package a;

import android.content.Context;
import com.omarea.model.ZramMMStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f6121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f927a;
    public final z32 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f928b;
    public final z32 c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f929c;
    public final z32 d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final String f930d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public fn0(Context context) {
        f92.d(context, "context");
        this.f926a = context;
        this.f927a = "/data/swapfile";
        this.f928b = "/sys/block/zram0/backing_dev";
        this.f929c = "/sys/block/zram0/hybridswap_loop_device";
        this.f930d = "/sys/block/zram0/smartswap_loop_device";
        this.e = "/sys/kernel/mm/memcompress/stat";
        this.f = "/sys/kernel/mm/memcompress/compressor";
        this.f6121a = a42.a(new bn0(this));
        this.b = a42.a(new zm0(this));
        this.c = a42.a(new an0(this));
        this.d = a42.a(new en0(this));
        this.g = "/proc/sys/vm/swappiness";
        this.h = "/sys/module/oplus_bsp_zram_opt/parameters";
        this.i = "/proc/oplus_mem/swappiness_para";
    }

    public final void A(int i) {
        StringBuilder sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("swapoff " + this.f927a + " >/dev/null 2>&1\n");
        sb2.append("rm -f " + this.f927a + " >/dev/null 2>&1\n");
        if (x60.f7856a.h()) {
            sb = new StringBuilder();
            sb.append("fallocate -l ");
            sb.append(i);
            sb.append("M ");
            sb.append(this.f927a);
            str = " || dd if=/dev/zero of=";
        } else {
            sb = new StringBuilder();
            str = "dd if=/dev/zero of=";
        }
        sb.append(str);
        sb.append(this.f927a);
        sb.append(" bs=1048576 count=");
        sb.append(i);
        sb.append('\n');
        sb2.append(sb.toString());
        s60 s60Var = s60.f7366a;
        String string = sb2.toString();
        f92.c(string, "sb.toString()");
        s60Var.a(string);
    }

    public final void B(int i, String str) {
        StringBuilder sb;
        f92.d(str, "algorithm");
        if (r() == i) {
            if ((!(str.length() > 0) || !(!f92.a(str, e()))) && s()) {
                return;
            }
        }
        x60.f7856a.j("/sys/block/zram0/max_comp_streams", "4");
        String strY = y();
        s60.f7366a.a("swapoff /dev/block/zram0");
        x60.f7856a.j("/sys/block/zram0/reset", "1");
        if (str.length() > 0) {
            x60.f7856a.j("/sys/block/zram0/comp_algorithm", str);
        }
        if ((strY.length() > 0) && (!f92.a(strY, "none")) && y60.f7952a.d(this.f928b)) {
            x60.f7856a.j(this.f928b, strY);
        }
        x60 x60Var = x60.f7856a;
        if (i > 2047) {
            sb = new StringBuilder();
            sb.append(i);
            sb.append('M');
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(((long) (i * 1024)) * 1024);
        }
        x60Var.j("/sys/block/zram0/disksize", sb.toString());
        s60 s60Var = s60.f7366a;
        String str2 = "mkswap /dev/block/zram0 >/dev/null 2>&1\nswapon -p 0 /dev/block/zram0 >/dev/null 2>&1\n";
        f92.c(str2, "StringBuilder()\n        …              .toString()");
        s60Var.a(str2);
    }

    public final void C(int i) {
        String strValueOf = String.valueOf(i);
        if (y60.f7952a.g(this.h)) {
            qc2.d(xd2.a(qe2.b()), null, null, new cn0(this, strValueOf, null), 3, null);
        }
        if (y60.f7952a.g(this.i)) {
            qc2.d(xd2.a(qe2.b()), null, null, new dn0(this, strValueOf, null), 3, null);
        }
        x60.f7856a.j(this.g, "100");
        x60.f7856a.j(this.g, strValueOf);
    }

    public final void D() {
        StringBuilder sb = new StringBuilder("sh " + m() + " disable_swap ");
        sb.append(ec2.C(l(), "loop", false, 2, null) ? "1" : "0");
        sb.append("\nrm -f " + this.f927a);
        s60 s60Var = s60.f7366a;
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        s60Var.a(string);
    }

    public final void E() {
        StringBuilder sb = new StringBuilder("sh " + m() + " disable_swap ");
        sb.append(ec2.C(l(), "loop", false, 2, null) ? "1" : "0");
        s60 s60Var = s60.f7366a;
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        s60Var.a(string);
    }

    public final String F(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("sh " + m() + " enable_swap ");
        sb.append(z ? "1" : "0");
        if (i > -2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(i);
            sb.append(sb2.toString());
        }
        b70 b70Var = new b70(this.f926a);
        s60 s60Var = s60.f7366a;
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        return j60.d(b70Var, s60Var.a(string), false, 2, null);
    }

    public final void G() {
        s60.f7366a.a("swapoff /dev/block/zram0\n");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.model.ZramMMStat H(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fn0.H(java.lang.String):com.omarea.model.ZramMMStat");
    }

    public final String d(int i) {
        if (g() == null) {
            return "Fail!";
        }
        return s60.f7366a.a(g() + ' ' + i);
    }

    public final String e() {
        Object obj;
        Iterator it = ec2.d0(x60.f7856a.d("/sys/block/zram0/comp_algorithm"), new String[]{" "}, false, 0, 6, null).iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            boolean z = false;
            if (bc2.x(str, "[", false, 2, null) && bc2.o(str, "]", false, 2, null)) {
                z = true;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        if (str2 == null) {
            return "";
        }
        String strT = bc2.t(bc2.t(str2, "[", "", false, 4, null), "]", "", false, 4, null);
        if (strT != null) {
            return ec2.r0(strT).toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final String[] f() {
        List listD0 = ec2.d0(x60.f7856a.d("/sys/block/zram0/comp_algorithm"), new String[]{" "}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(z42.m(listD0, 10));
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            arrayList.add(bc2.t(bc2.t((String) it.next(), "[", "", false, 4, null), "]", "", false, 4, null));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String g() {
        return (String) this.b.getValue();
    }

    public final String h() {
        return this.f;
    }

    public final String i() {
        return this.e;
    }

    public final boolean j() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final List<String> k() {
        String strT = bc2.t(bc2.t(x60.f7856a.d("/proc/swaps"), "\t\t", "\t", false, 4, null), "\t", " ", false, 4, null);
        while (ec2.C(strT, "  ", false, 2, null)) {
            strT = bc2.t(strT, "  ", " ", false, 4, null);
        }
        return i52.a0(ec2.d0(strT, new String[]{"\n"}, false, 0, 6, null));
    }

    public final String l() {
        if (!n()) {
            return "";
        }
        String strT = bc2.t(bc2.t(x60.f7856a.d("/proc/swaps"), "\t\t", "\t", false, 4, null), "\t", " ", false, 4, null);
        if (ec2.C(strT, "/swapfile", false, 2, null)) {
            return this.f927a;
        }
        String str = (String) i52.K(ec2.d0(um0.f7612a.a("vtools.swap.loop"), new String[]{"/"}, false, 0, 6, null));
        return (str != null && (f92.a(str, "error") ^ true) && ec2.C(strT, str, false, 2, null)) ? str : "";
    }

    public final String m() {
        return (String) this.f6121a.getValue();
    }

    public final boolean n() {
        return y60.f7952a.g(this.f927a);
    }

    public final int o() {
        if (!n()) {
            return 0;
        }
        long jF = 0;
        try {
            jF = y60.f7952a.f(this.f927a);
        } catch (Exception unused) {
        }
        long j = 1024;
        return (int) ((jF / j) / j);
    }

    public final int p() {
        String str = (String) i52.K(ec2.d0(um0.f7612a.a("vtools.swap.loop"), new String[]{"/"}, false, 0, 6, null));
        if (str != null && !ec2.C(str, "loop", false, 2, null)) {
            str = null;
        }
        for (String str2 : k()) {
            if (bc2.x(str2, "/swapfile ", false, 2, null) || bc2.x(str2, "/data/swapfile ", false, 2, null) || (str != null && ec2.C(str2, str, false, 2, null))) {
                List listA0 = i52.a0(ec2.d0(str2, new String[]{" "}, false, 0, 6, null));
                try {
                    return Integer.parseInt((String) listA0.get(3)) / 1024;
                } catch (Exception unused) {
                    return -1;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.model.ZramWriteBackStat q() {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fn0.q():com.omarea.model.ZramWriteBackStat");
    }

    public final int r() {
        try {
            long j = 1024;
            return (int) ((Long.parseLong(x60.f7856a.d("/sys/block/zram0/disksize")) / j) / j);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean s() {
        return ec2.C(x60.f7856a.d("/proc/swaps"), "/block/zram0", false, 2, null);
    }

    public final String[] t() {
        return (String[]) this.d.getValue();
    }

    public final Long u() {
        String memUsed;
        Long lValueOf = null;
        for (String str : t()) {
            ZramMMStat zramMMStatH = H(str);
            if (zramMMStatH != null && (memUsed = zramMMStatH.getMemUsed()) != null) {
                long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
                Long l = ac2.l(memUsed);
                lValueOf = Long.valueOf(jLongValue + ((l != null ? l.longValue() : 0L) / ((long) 1024)));
            }
        }
        return lValueOf;
    }

    public final Integer v() {
        for (String str : k()) {
            if (bc2.x(str, "/block/zram0 ", false, 2, null) || bc2.x(str, "/dev/block/zram0 ", false, 2, null)) {
                try {
                    return Integer.valueOf(Integer.parseInt((String) i52.a0(ec2.d0(str, new String[]{" "}, false, 0, 6, null)).get(4)));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public final boolean w() {
        if (y60.f7952a.g("/dev/block/zram0")) {
            return true;
        }
        x60.f7856a.d("/sys/class/zram-control/hot_add");
        return y60.f7952a.g("/dev/block/zram0");
    }

    public final int x() {
        for (String str : k()) {
            if (bc2.x(str, "/block/zram0 ", false, 2, null) || bc2.x(str, "/dev/block/zram0 ", false, 2, null)) {
                List listA0 = i52.a0(ec2.d0(str, new String[]{" "}, false, 0, 6, null));
                try {
                    return Integer.parseInt((String) listA0.get(3)) / 1024;
                } catch (Exception unused) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public final String y() {
        String strD;
        d42<String, String> d42VarA = x60.f7856a.a(new String[]{this.f928b, this.f929c, this.f930d});
        if (d42VarA == null || (strD = d42VarA.d()) == null) {
            strD = "";
        }
        return bc2.t(bc2.t(strD, "(", "", false, 4, null), ")", "", false, 4, null);
    }

    public final boolean z() {
        return x60.f7856a.a(new String[]{this.f928b, this.f929c, this.f930d}) != null;
    }
}
