package j3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.multidex.MultiDexExtractor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f36026a = ".classes";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f36027b = ".zip";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f36028c = androidx.multidex.b.f6397c + File.separator + "secondary-dexes";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f36029d = "multidex.version";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f36030e = "dex.number";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f36031f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f36032g = 1;

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    public static class RunnableC0406a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f36033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f36034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Set f36035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f36036d;

        public RunnableC0406a(String str, String str2, Set set, CountDownLatch countDownLatch) {
            this.f36033a = str;
            this.f36034b = str2;
            this.f36035c = set;
            this.f36036d = countDownLatch;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(5:21|3|(1:5)(1:6)|7|(4:10|(3:23|12|26)(1:25)|24|8))|19|15|16|17|(1:(0))) */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                java.lang.String r1 = r4.f36033a     // Catch: java.lang.Throwable -> L4c
                java.lang.String r2 = ".zip"
                boolean r1 = r1.endsWith(r2)     // Catch: java.lang.Throwable -> L4c
                if (r1 == 0) goto L26
                java.lang.String r1 = r4.f36033a     // Catch: java.lang.Throwable -> L4c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
                r2.<init>()     // Catch: java.lang.Throwable -> L4c
                java.lang.String r3 = r4.f36033a     // Catch: java.lang.Throwable -> L4c
                r2.append(r3)     // Catch: java.lang.Throwable -> L4c
                java.lang.String r3 = ".tmp"
                r2.append(r3)     // Catch: java.lang.Throwable -> L4c
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4c
                r3 = 0
                dalvik.system.DexFile r0 = dalvik.system.DexFile.loadDex(r1, r2, r3)     // Catch: java.lang.Throwable -> L4c
                goto L2e
            L26:
                dalvik.system.DexFile r1 = new dalvik.system.DexFile     // Catch: java.lang.Throwable -> L4c
                java.lang.String r2 = r4.f36033a     // Catch: java.lang.Throwable -> L4c
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L4c
                r0 = r1
            L2e:
                java.util.Enumeration r1 = r0.entries()     // Catch: java.lang.Throwable -> L4c
            L32:
                boolean r2 = r1.hasMoreElements()     // Catch: java.lang.Throwable -> L4c
                if (r2 == 0) goto L4e
                java.lang.Object r2 = r1.nextElement()     // Catch: java.lang.Throwable -> L4c
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L4c
                java.lang.String r3 = r4.f36034b     // Catch: java.lang.Throwable -> L4c
                boolean r3 = r2.startsWith(r3)     // Catch: java.lang.Throwable -> L4c
                if (r3 == 0) goto L32
                java.util.Set r3 = r4.f36035c     // Catch: java.lang.Throwable -> L4c
                r3.add(r2)     // Catch: java.lang.Throwable -> L4c
                goto L32
            L4c:
                if (r0 == 0) goto L51
            L4e:
                r0.close()     // Catch: java.lang.Throwable -> L51
            L51:
                java.util.concurrent.CountDownLatch r0 = r4.f36036d
                r0.countDown()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j3.a.RunnableC0406a.run():void");
        }
    }

    public static Set<String> a(Context context, String str) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        HashSet hashSet = new HashSet();
        List<String> listC = c(context);
        CountDownLatch countDownLatch = new CountDownLatch(listC.size());
        Iterator<String> it2 = listC.iterator();
        while (it2.hasNext()) {
            i3.b.a().execute(new RunnableC0406a(it2.next(), str, hashSet, countDownLatch));
        }
        countDownLatch.await();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Filter ");
        sb2.append(hashSet.size());
        sb2.append(" classes by packageName <");
        sb2.append(str);
        sb2.append(">");
        return hashSet;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static List<String> c(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        if (!d()) {
            int i10 = b(context).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, f36028c);
            for (int i11 = 2; i11 <= i10; i11++) {
                File file3 = new File(file2, str + i11 + ".zip");
                if (!file3.isFile()) {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
                arrayList.add(file3.getAbsolutePath());
            }
        }
        if (h3.a.g()) {
            arrayList.addAll(f(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d A[PHI: r1
  0x001d: PHI (r1v8 java.lang.String) = (r1v6 java.lang.String), (r1v6 java.lang.String), (r1v9 java.lang.String) binds: [B:13:0x004a, B:15:0x004e, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d() {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = e()     // Catch: java.lang.Throwable -> L51
            r3 = 1
            if (r2 == 0) goto L1f
            java.lang.String r1 = "'YunOS'"
            java.lang.String r2 = "ro.build.version.sdk"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L51
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L51
            r4 = 21
            if (r2 < r4) goto L52
        L1d:
            r0 = 1
            goto L52
        L1f:
            java.lang.String r1 = "'Android'"
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L52
            java.lang.String r4 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Throwable -> L51
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch: java.lang.Throwable -> L51
            boolean r4 = r2.matches()     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L52
            java.lang.String r4 = r2.group(r3)     // Catch: java.lang.Throwable -> L51
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L51
            r5 = 2
            java.lang.String r2 = r2.group(r5)     // Catch: java.lang.Throwable -> L51
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L51
            if (r4 > r5) goto L1d
            if (r4 != r5) goto L52
            if (r2 < r3) goto L52
            goto L1d
        L51:
        L52:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "VM with name "
            r2.append(r3)
            r2.append(r1)
            if (r0 == 0) goto L64
            java.lang.String r1 = " has multidex support"
            goto L66
        L64:
            java.lang.String r1 = " does not have multidex support"
        L66:
            r2.append(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.a.d():boolean");
    }

    public static boolean e() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if (property2 == null || !property2.toLowerCase().contains("lemur")) {
                if (property == null) {
                    return false;
                }
                if (property.trim().length() <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> f(ApplicationInfo applicationInfo) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            arrayList.addAll(Arrays.asList(strArr));
        } else {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(MultiDexExtractor.f6369i)) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                }
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("InstantRun support error, ");
                sb2.append(e10.getMessage());
            }
        }
        return arrayList;
    }
}
