package a;

import android.content.Context;
import android.util.Log;
import com.omarea.model.ProcessInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nb2 f7315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f2757a;

    public rm0(Context context) {
        f92.d(context, "context");
        this.f2757a = new qm0();
        this.f7315a = new nb2(".*\\..*");
    }

    public final ArrayList<ProcessInfo> a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = new l30(pm0.f7130a).toString();
        f92.c(string, "json{\n                \"m…\n            }.toString()");
        List listD0 = ec2.d0(e50.f677a.i1("top", string, 1000L), new String[]{"\n"}, false, 0, 6, null);
        ArrayList<ProcessInfo> arrayList = new ArrayList<>();
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            ProcessInfo processInfoE = e((String) it.next());
            if (processInfoE != null) {
                arrayList.add(processInfoE);
            }
        }
        Log.e("@Scene", "耗时" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayList;
    }

    public final boolean b(ProcessInfo processInfo) {
        String str = processInfo.command;
        f92.c(str, "processInfo.command");
        if (!ec2.C(str, "app_process", false, 2, null)) {
            return false;
        }
        String str2 = processInfo.name;
        f92.c(str2, "processInfo.name");
        return this.f7315a.f(str2);
    }

    public final void c(int i) {
        e50.f677a.a0("kill -9 " + i, 3000L);
    }

    public final void d(ProcessInfo processInfo) {
        String strSubstring;
        f92.d(processInfo, "processInfo");
        if (!b(processInfo)) {
            c(processInfo.pid);
            return;
        }
        String str = processInfo.name;
        f92.c(str, "processInfo.name");
        if (ec2.C(str, ":", false, 2, null)) {
            String str2 = processInfo.name;
            f92.c(str2, "processInfo.name");
            String str3 = processInfo.name;
            f92.c(str3, "processInfo.name");
            int iN = ec2.N(str3, ":", 0, false, 6, null);
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(0, iN);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            strSubstring = processInfo.name;
        }
        e50 e50Var = e50.f677a;
        q92 q92Var = q92.f7191a;
        String str4 = String.format("killall -9 %s;am force-stop %s;am kill %s", Arrays.copyOf(new Object[]{strSubstring, strSubstring, strSubstring}, 3));
        f92.c(str4, "java.lang.String.format(format, *args)");
        e50Var.a0(str4, 3000L);
    }

    public final ProcessInfo e(String str) {
        List listD0 = ec2.d0(str, new String[]{"|"}, false, 0, 6, null);
        try {
            ProcessInfo processInfo = new ProcessInfo();
            processInfo.cpu = Float.parseFloat((String) listD0.get(0));
            processInfo.res = g((String) listD0.get(1));
            processInfo.shr = g((String) listD0.get(2));
            processInfo.swap = g((String) listD0.get(3));
            String str2 = (String) listD0.get(4);
            processInfo.name = str2;
            if (this.f2757a.contains(str2)) {
                return null;
            }
            processInfo.pid = Integer.parseInt((String) listD0.get(5));
            processInfo.user = (String) listD0.get(6);
            processInfo.state = (String) listD0.get(7);
            processInfo.command = (String) listD0.get(8);
            processInfo.cmdline = (String) listD0.get(9);
            return processInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void f(ProcessInfo processInfo) {
        f92.d(processInfo, "processInfo");
        String strSubstring = processInfo.name;
        f92.c(strSubstring, "name");
        if (ec2.C(strSubstring, ":", false, 2, null)) {
            strSubstring = strSubstring.substring(0, ec2.N(strSubstring, ":", 0, false, 6, null));
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        e50 e50Var = e50.f677a;
        q92 q92Var = q92.f7191a;
        String str = String.format("killall -9 %s;am force-stop %s;am kill %s", Arrays.copyOf(new Object[]{strSubstring, strSubstring, strSubstring}, 3));
        f92.c(str, "java.lang.String.format(format, *args)");
        e50Var.a0(str, 3000L);
        c(processInfo.pid);
    }

    public final long g(String str) {
        double d;
        double d2;
        double d3;
        if (str.length() == 0) {
            return 0L;
        }
        if (ec2.C(str, "K", false, 2, null)) {
            int iN = ec2.N(str, "K", 0, false, 6, null);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(0, iN);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            d3 = Double.parseDouble(strSubstring);
        } else {
            if (ec2.C(str, "M", false, 2, null)) {
                int iN2 = ec2.N(str, "M", 0, false, 6, null);
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring2 = str.substring(0, iN2);
                f92.c(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                d = Double.parseDouble(strSubstring2);
                d2 = 1024;
            } else {
                if (!ec2.C(str, "G", false, 2, null)) {
                    return Long.parseLong(str) / ((long) 1024);
                }
                int iN3 = ec2.N(str, "G", 0, false, 6, null);
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring3 = str.substring(0, iN3);
                f92.c(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                d = Double.parseDouble(strSubstring3);
                d2 = 1048576;
            }
            d3 = d * d2;
        }
        return (long) d3;
    }

    public final boolean h() {
        return true;
    }
}
