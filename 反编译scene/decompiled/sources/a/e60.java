package a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5970a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final e60 f698a = new e60();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f699a = "/data/adb/modules";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f700a = false;
    public static int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f701b = "/data/adb/modules";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f702b = false;
    public static final String c = "/data/adb/modules_update";
    public static final String d = "/dev/scene/modules_tmp";

    public static final boolean a() {
        return f700a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean m() {
        /*
            a.e60 r0 = a.e60.f698a
            boolean r0 = r0.n()
            if (r0 == 0) goto L73
            a.e60 r0 = a.e60.f698a
            java.lang.String r0 = r0.e()
            java.lang.String r1 = "magisk"
            boolean r0 = a.f92.a(r0, r1)
            java.lang.String r1 = "/scene_systemless/module.prop"
            r2 = 1
            if (r0 == 0) goto L37
            a.y60 r0 = a.y60.f7952a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = a.e60.c
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            boolean r0 = r0.d(r3)
            if (r0 == 0) goto L37
            java.lang.String r0 = a.e60.c
        L34:
            a.e60.f699a = r0
            return r2
        L37:
            a.y60 r0 = a.y60.f7952a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = a.e60.d
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            boolean r0 = r0.d(r1)
            if (r0 == 0) goto L53
            java.lang.String r0 = a.e60.d
            goto L34
        L53:
            a.y60 r0 = a.y60.f7952a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            a.e60 r3 = a.e60.f698a
            java.lang.String r3 = r3.g()
            r1.append(r3)
            java.lang.String r3 = "module.prop"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.d(r1)
            if (r0 == 0) goto L73
            return r2
        L73:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e60.m():boolean");
    }

    public final boolean b() {
        return (!n() || f700a || f702b) ? false : true;
    }

    public final void c(String str) {
        f92.d(str, "orginPath");
        if (y60.f7952a.g(str)) {
            y60.f7952a.l(h(str), "");
        }
    }

    public final String d() {
        return f700a ? "ksu" : f702b ? "ap" : "magisk";
    }

    public final String e() {
        return f700a ? "ksud" : f702b ? "apd" : "magisk";
    }

    public final String f() {
        if (!m()) {
            return "";
        }
        return y60.f7952a.i(g() + "post-fs-data.sh");
    }

    public final String g() {
        return f699a + "/scene_systemless/";
    }

    public final String h(String str) {
        f92.d(str, "systemPath");
        StringBuilder sb = new StringBuilder();
        String strG = g();
        int length = g().length() - 1;
        if (strG == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strG.substring(0, length);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        if (bc2.x(str, "/vendor", false, 2, null) || bc2.x(str, "/product", false, 2, null)) {
            str = "/system" + str;
        }
        sb.append(str);
        return sb.toString();
    }

    public final String i() {
        return g() + "system.prop";
    }

    public final boolean j() {
        return n() && !f702b;
    }

    public final boolean k(Context context) throws IOException {
        f92.d(context, "context");
        String strO = c60.f5764a.o(context, c60.f5764a.h(context, "ksu.zip"), "ksu.zip");
        if (strO == null || !l(strO)) {
            return false;
        }
        f699a = c;
        if (!f700a && !f702b) {
            return true;
        }
        String str = "/data/adb/" + d() + "/modules_update.img";
        if (!y60.f7952a.d(str)) {
            return true;
        }
        v("", "update");
        s60.f7366a.a("mkdir -p " + d + "\nmount -t ext4 --loop " + str + ' ' + d);
        f699a = d;
        return true;
    }

    public final boolean l(String str) {
        String str2;
        f92.d(str, "path");
        String strE = e();
        int iHashCode = strE.hashCode();
        if (iHashCode != -1081635250) {
            if (iHashCode != 96789) {
                if (iHashCode != 3301879 || !strE.equals("ksud")) {
                    return false;
                }
            } else if (!strE.equals("apd")) {
                return false;
            }
            str2 = "module install";
        } else {
            if (!strE.equals("magisk")) {
                return false;
            }
            str2 = "--install-module";
        }
        s60 s60Var = s60.f7366a;
        return !f92.a(s60Var.a(e() + ' ' + str2 + " '" + str + "' || echo error"), "error");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            r5 = this;
            int r0 = a.e60.f5970a
            r1 = 0
            r2 = 1
            r3 = -1
            if (r0 != r3) goto L5e
            java.lang.String r0 = a.a70.d()
            if (r0 != 0) goto Le
            goto L5c
        Le:
            int r3 = r0.hashCode()
            r4 = -2028305842(0xffffffff871a824e, float:-1.1623965E-34)
            if (r3 == r4) goto L3a
            r4 = 96789(0x17a15, float:1.3563E-40)
            if (r3 == r4) goto L2d
            r4 = 378773375(0x16939f7f, float:2.3849787E-25)
            if (r3 == r4) goto L22
            goto L5c
        L22:
            java.lang.String r3 = "KernelSU"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5c
            a.e60.f700a = r2
            goto L37
        L2d:
            java.lang.String r3 = "apd"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5c
            a.e60.f702b = r2
        L37:
            a.e60.f5970a = r2
            goto L5e
        L3a:
            java.lang.String r3 = "MAGISK"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5c
            a.s60 r0 = a.s60.f7366a
            java.lang.String r3 = "magisk -V"
            java.lang.String r0 = r0.c(r3)
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L5e
            int r0 = r0 / 1000
            a.e60.b = r0     // Catch: java.lang.Exception -> L5e
            r3 = 19
            if (r0 < r3) goto L58
            r0 = r2
            goto L59
        L58:
            r0 = r1
        L59:
            a.e60.f5970a = r0     // Catch: java.lang.Exception -> L5e
            goto L5e
        L5c:
            a.e60.f5970a = r1
        L5e:
            int r0 = a.e60.f5970a
            if (r0 != r2) goto L63
            r1 = r2
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e60.n():boolean");
    }

    public final String o(LinkedHashMap<String, String> linkedHashMap) {
        f92.d(linkedHashMap, "props");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("\n");
        }
        String string = sb.toString();
        f92.c(string, "stringBuilder.toString()");
        return string;
    }

    public final boolean p(String str, String str2) {
        f92.d(str, "orginPath");
        f92.d(str2, "newfile");
        if (!y60.f7952a.g(str2)) {
            return false;
        }
        String strH = h(str);
        String parent = new File(strH).getParent();
        s60.f7366a.a("mkdir -p \"" + parent + "\"\ncp \"" + str2 + "\" \"" + strH + "\"\nchmod 777 \"" + strH + '\"');
        return true;
    }

    public final void q(String str) {
        f92.d(str, "orginPath");
        y60.f7952a.b(h(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        if (r4 >= 140) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
    
        v("id=scene_systemless\nname=Scene的附加模块\nversion=v1.4.0\nversionCode=140\nauthor=嘟嘟ski\ndescription=Scene的辅助模块，使用Scene部分功能时可免于直接操作系统文件\nminMagisk=17000\n", "module.prop");
        r1 = a.c60.f5764a.a(r18, "addin/magisk_mount.sh");
        r3 = java.nio.charset.Charset.defaultCharset();
        a.f92.c(r3, "Charset.defaultCharset()");
        r4 = new java.lang.String(r1, r3);
        a.y60.f7952a.l(g() + "magisk_mount.sh", r4);
        r11 = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b4, code lost:
    
        if (a.ec2.C(r11, "magisk_mount.sh", false, 2, null) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bc, code lost:
    
        if (a.bc2.x(r11, "#!/system/bin/sh", false, 2, null) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00be, code lost:
    
        r1 = a.bc2.t(r11, "#!/system/bin/sh", "#!/system/bin/sh\nsh ${0%/*}/magisk_mount.sh\n", false, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d8, code lost:
    
        r1 = "sh ${0%/*}/magisk_mount.sh\n" + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e9, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ea, code lost:
    
        u(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(android.content.Context r18) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e60.r(android.content.Context):void");
    }

    public final boolean s(String str, String str2) {
        f92.d(str, "prop");
        String strI = y60.f7952a.i(i());
        int length = strI.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = f92.e(strI.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        Object[] array = new nb2("\n").h(strI.subSequence(i, length + 1).toString(), 0).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        ArrayList arrayList = new ArrayList();
        String str3 = str + '=';
        int length2 = strArr.length;
        int i2 = 0;
        boolean z3 = false;
        if (str2 != null) {
            while (i2 < length2) {
                String str4 = strArr[i2];
                if (bc2.x(str4, str3, false, 2, null)) {
                    arrayList.add(str3 + str2);
                    z3 = true;
                } else {
                    arrayList.add(str4);
                }
                i2++;
            }
            if (!z3) {
                arrayList.add(str + '=' + str2);
            }
        } else {
            while (i2 < length2) {
                String str5 = strArr[i2];
                if (bc2.x(str5, str3, false, 2, null)) {
                    arrayList.add(str + '=' + str2);
                    z3 = true;
                } else {
                    arrayList.add(str5);
                }
                i2++;
            }
            if (!z3) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        y60 y60Var = y60.f7952a;
        String strI2 = i();
        String string = sb.toString();
        f92.c(string, "stringBuilder.toString()");
        return y60Var.l(strI2, string);
    }

    public final boolean t(Context context, String str, String str2, String str3, String str4, String str5, int i) throws IOException {
        f92.d(context, "context");
        f92.d(str, "toPath");
        f92.d(str2, "newFile");
        f92.d(str3, "packageName");
        if (!n() || !y60.f7952a.g(str2)) {
            return false;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("id", str3);
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put("name", str4);
        if (str5 == null) {
            str5 = "";
        }
        linkedHashMap.put("version", str5);
        linkedHashMap.put("versionCode", "" + i);
        linkedHashMap.put("author", "嘟嘟ski(SCENE)");
        linkedHashMap.put("description", "用于将第三方应用转换成系统应用的模块，由Scene创建并添加");
        m42 m42Var = m42.f6769a;
        String strO = o(linkedHashMap);
        String str6 = f701b;
        y60.f7952a.b(f701b + '/' + str3);
        if (f700a) {
            if (!m()) {
                k(context);
            }
            if (f92.a(f699a, d)) {
                y60.f7952a.b(d + '/' + str3);
                str6 = d;
                y60.f7952a.l(f701b + '/' + str3 + "/module.prop", strO);
                y60.f7952a.l(f701b + '/' + str3 + "/update", "");
            }
        }
        y60.f7952a.l(str6 + '/' + str3 + "/module.prop", strO);
        StringBuilder sb = new StringBuilder();
        sb.append(str6);
        sb.append('/');
        sb.append(str3);
        if (bc2.x(str, "/vendor", false, 2, null) || bc2.x(str, "/product", false, 2, null)) {
            str = "/system" + str;
        }
        sb.append(str);
        String string = sb.toString();
        String parent = new File(string).getParent();
        s60.f7366a.a("mkdir -p '" + parent + "'\ncp -pdrf '" + str2 + "' '" + string + "'\nchmod -R 777 '" + string + '\'');
        y60 y60Var = y60.f7952a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append("/oat/arm/base.odex");
        y60Var.b(sb2.toString());
        y60 y60Var2 = y60.f7952a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string);
        sb3.append("/oat/arm64/base.odex");
        y60Var2.b(sb3.toString());
        y60.f7952a.b(string + "/oat/arm/base.art");
        y60.f7952a.b(string + "/oat/arm64/base.art");
        return true;
    }

    public final boolean u(String str) {
        y60 y60Var = y60.f7952a;
        String str2 = g() + "post-fs-data.sh";
        f92.b(str);
        return y60Var.l(str2, str);
    }

    public final void v(String str, String str2) {
        if (!bc2.x(str2, "/", false, 2, null)) {
            str2 = g() + str2;
        }
        y60.f7952a.l(str2, str);
    }
}
