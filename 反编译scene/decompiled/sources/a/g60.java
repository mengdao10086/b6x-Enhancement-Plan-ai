package a;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g60<T extends Serializable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f977a;

    public g60(Context context) {
        f92.d(context, "context");
        this.f6175a = context;
        this.f977a = "objects/";
    }

    public boolean a(String str) {
        f92.d(str, "configFile");
        return new File(b(str)).exists();
    }

    public final String b(String str) {
        f92.d(str, "configFile");
        return c60.f5764a.d(this.f6175a, this.f977a + str);
    }

    public T c(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        FileInputStream fileInputStream;
        f92.d(str, "configFile");
        File file = new File(b(str));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        T t = (T) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        return t;
                    } catch (Exception unused2) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception unused5) {
                    objectInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream = null;
                }
            } catch (Exception unused6) {
                fileInputStream = null;
                objectInputStream = null;
            } catch (Throwable th4) {
                objectInputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #8 {Exception -> 0x0062, blocks: (B:32:0x005a, B:34:0x005f), top: B:48:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(T r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "configFile"
            a.f92.d(r5, r0)
            java.io.File r0 = new java.io.File
            java.lang.String r5 = r3.b(r5)
            r0.<init>(r5)
            java.io.File r5 = r0.getParentFile()
            boolean r1 = r5.exists()
            if (r1 != 0) goto L1b
            r5.mkdirs()
        L1b:
            r5 = 1
            if (r4 == 0) goto L63
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L37
            r0.writeObject(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L38
            r0.close()     // Catch: java.lang.Exception -> L32
            r2.close()     // Catch: java.lang.Exception -> L32
        L32:
            return r5
        L33:
            r4 = move-exception
            goto L57
        L35:
            r4 = move-exception
            goto L58
        L37:
            r0 = r1
        L38:
            r1 = r2
            goto L3e
        L3a:
            r4 = move-exception
            r2 = r1
            goto L58
        L3d:
            r0 = r1
        L3e:
            android.content.Context r4 = r3.f6175a     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = "存储配置失败！"
            r2 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r2)     // Catch: java.lang.Throwable -> L55
            r4.show()     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.lang.Exception -> L54
        L4f:
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.lang.Exception -> L54
        L54:
            return r2
        L55:
            r4 = move-exception
            r2 = r1
        L57:
            r1 = r0
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Exception -> L62
        L5d:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.lang.Exception -> L62
        L62:
            throw r4
        L63:
            boolean r4 = r0.exists()
            if (r4 == 0) goto L6c
            r0.delete()
        L6c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g60.d(java.io.Serializable, java.lang.String):boolean");
    }
}
