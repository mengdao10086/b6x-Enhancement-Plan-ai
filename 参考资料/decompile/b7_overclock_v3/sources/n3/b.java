package n3;

import com.flydigi.base.common.n;
import java.io.DataOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a() {
        Process processExec;
        DataOutputStream dataOutputStream;
        n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive");
        DataOutputStream dataOutputStream2 = null;
        try {
            processExec = Runtime.getRuntime().exec("su");
            try {
                try {
                    dataOutputStream = new DataOutputStream(processExec.getOutputStream());
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
            processExec = null;
        } catch (Throwable th3) {
            th = th3;
            processExec = null;
        }
        try {
            dataOutputStream.writeBytes("cp /sdcard/Documents/flydigi/server/motionelf_server /data/local/tmp/motionelf_server\n");
            dataOutputStream.flush();
            n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive command_copy:cp /sdcard/Documents/flydigi/server/motionelf_server /data/local/tmp/motionelf_server\n");
            dataOutputStream.writeBytes("cd /data/local/tmp\n");
            dataOutputStream.flush();
            n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive command_cd:cd /data/local/tmp\n");
            dataOutputStream.writeBytes("chmod 777 motionelf_server\n");
            dataOutputStream.flush();
            n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive command_chmod:chmod 777 motionelf_server\n");
            dataOutputStream.writeBytes("./motionelf_server&\n");
            dataOutputStream.flush();
            n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive command_active:./motionelf_server&\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            n.a("flydigitestdata adbShellCopyPrivateDriverToLocalTmpAndActive finish");
            Thread.sleep(1000L);
            if (v5.c.g()) {
                n.a("flydigitestdata checkRootPermission 获取Root成功");
                try {
                    n.a("flydigitestdata checkRootPermission localDataOutputStream.close()");
                    dataOutputStream.close();
                    processExec.destroy();
                } catch (Exception unused) {
                    n.a("flydigitestdata checkRootPermission finally Exception");
                }
                return true;
            }
            if (processExec.waitFor() == 0) {
                n.a("flydigitestdata checkRootPermission 获取Root成功");
                try {
                    n.a("flydigitestdata checkRootPermission localDataOutputStream.close()");
                    dataOutputStream.close();
                    processExec.destroy();
                } catch (Exception unused2) {
                    n.a("flydigitestdata checkRootPermission finally Exception");
                }
                return true;
            }
            n.a("flydigitestdata checkRootPermission 获取Root失败");
            try {
                n.a("flydigitestdata checkRootPermission localDataOutputStream.close()");
                dataOutputStream.close();
                processExec.destroy();
            } catch (Exception unused3) {
                n.a("flydigitestdata checkRootPermission finally Exception");
            }
            return false;
        } catch (Exception e12) {
            e = e12;
            dataOutputStream2 = dataOutputStream;
            e.printStackTrace();
            n.a("flydigitestdata checkRootPermission 获取Root异常:" + e.getMessage());
            if (dataOutputStream2 != null) {
                try {
                    n.a("flydigitestdata checkRootPermission localDataOutputStream.close()");
                    dataOutputStream2.close();
                } catch (Exception unused4) {
                    n.a("flydigitestdata checkRootPermission finally Exception");
                    return false;
                }
            }
            processExec.destroy();
            return false;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream2 = dataOutputStream;
            if (dataOutputStream2 != null) {
                try {
                    n.a("flydigitestdata checkRootPermission localDataOutputStream.close()");
                    dataOutputStream2.close();
                } catch (Exception unused5) {
                    n.a("flydigitestdata checkRootPermission finally Exception");
                    throw th;
                }
            }
            processExec.destroy();
            throw th;
        }
    }
}
