package bin.mt.signature;

import a9.a;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: loaded from: classes8.dex */
public class KillerApplication extends Application {
    public static final String URL = "https://github.com/L-JINBIN/ApkSignatureKillerEx";

    static {
        killPM(a.f308b, "MIIDfzCCAmegAwIBAgIEZiVLPzANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwI4NjERMA8GA1UE\nCBMIc2hhbmdoYWkxETAPBgNVBAcTCHNoYW5naGFpMQ8wDQYDVQQKEwZmZWl6aGkxDzANBgNVBAsT\nBmZlaXpoaTEYMBYGA1UEAxMPc2hhbmdoYWkgZmVpemhpMCAXDTE2MDMwMjAyMTQ1MVoYDzIwNjYw\nMjE4MDIxNDUxWjBvMQswCQYDVQQGEwI4NjERMA8GA1UECBMIc2hhbmdoYWkxETAPBgNVBAcTCHNo\nYW5naGFpMQ8wDQYDVQQKEwZmZWl6aGkxDzANBgNVBAsTBmZlaXpoaTEYMBYGA1UEAxMPc2hhbmdo\nYWkgZmVpemhpMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkvcAXs5iUgmAGywffXHu\nBn0MLCBGfRh/n3hLoyjIo4uiDQMS/QdHq8FIngIWSrZhWe1RK3kr/38xYXJxIo73gNKJLvM2d3KC\nugTGzeavFWOrV+I6o9cXXBZDnyre0QW2zWiBI8fP1+i/x3bZJNirC9ZjDnWQoPR3c4bnDToU0NNF\nKovhAvv6oBTMZFO2Bw/qL2BDvQijM47WbFxIcLTHtSPWffB+o6xh5ngnK6ewJYwYPq+wa42lCYdh\ntJpR/P0GubcUTrYMPIU5FvpxAdtYPVPmIczI/anJUdb8RPAiMBYjH5czNa5+qg8ZcuLZ6lqPqFJU\nn2rADZn7iO4BSsFsfQIDAQABoyEwHzAdBgNVHQ4EFgQUq9FRiSEYs6mpoY6W6mXNDDxLREswDQYJ\nKoZIhvcNAQELBQADggEBAHSxa3tLQK+jUnpEiiOWnSmkdoKtSaiLK2dMVHdsJVNmPuCzq1nUynoh\nCms+X2f/52TZ6GgHKmsTis7ABjXMadw+fgGW6ErIOWQN1UWJhR+OcMp5W8AM1yaYTW9dnvY4/mW/\nY+6J93QloACZWP2cLS8glQjUBn3JfZ5p8luyuqJe9nhTddiaFxoWMGlvRY9sI2pEX0mqmocM/Sg5\n3pn2KlVaUAgZoeMypQAbGULQXwr5g0HPfzbWixHgva9qW1CZAeS0gY0TKlDNv4i7rYGFIwWHy+8F\noEfZ+zve8wo3vIGgS3KMFk7CgdvmI+sTAX1kDPXenrT9S7bx5QZq+AXLhew=\n");
        killOpen(a.f308b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.reflect.Field findField(java.lang.Class<?> r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /*
            r0 = 1
            java.lang.reflect.Field r1 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L9
            r1.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L9
            return r1
        L9:
            r1 = move-exception
        La:
            java.lang.Class r3 = r3.getSuperclass()
            if (r3 == 0) goto L22
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L22
            java.lang.reflect.Field r2 = r3.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L20
            r2.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L20
            return r2
        L20:
            goto La
        L22:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bin.mt.signature.KillerApplication.findField(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    private static String getApkPath(String str) {
        String str2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            do {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        return null;
                    }
                    str2 = line.split("\\s+")[r1.length - 1];
                } finally {
                }
            } while (!isApkPath(str, str2));
            bufferedReader.close();
            return str2;
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    private static File getDataFile(String str) {
        String name = Environment.getExternalStorageDirectory().getName();
        if (name.matches("\\d+")) {
            File file = new File("/data/user/" + name + fh.a.f28350w + str);
            if (file.canWrite()) {
                return file;
            }
        }
        return new File("/data/data/" + str);
    }

    private static native void hookApkPath(String str, String str2);

    private static boolean isApkPath(String str, String str2) {
        if (str2.startsWith(fh.a.f28350w) && str2.endsWith(".apk")) {
            String[] strArrSplit = str2.substring(1).split(fh.a.f28350w, 6);
            int length = strArrSplit.length;
            if (length == 4 || length == 5) {
                if (strArrSplit[0].equals("data") && strArrSplit[1].equals(Constants.JumpUrlConstants.SRC_TYPE_APP) && strArrSplit[length - 1].equals("base.apk")) {
                    return strArrSplit[length - 2].startsWith(str);
                }
                if (strArrSplit[0].equals("mnt") && strArrSplit[1].equals("asec") && strArrSplit[length - 1].equals("pkg.apk")) {
                    return strArrSplit[length - 2].startsWith(str);
                }
            } else if (length == 3) {
                if (strArrSplit[0].equals("data") && strArrSplit[1].equals(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
                    return strArrSplit[2].startsWith(str);
                }
            } else if (length == 6 && strArrSplit[0].equals("mnt") && strArrSplit[1].equals("expand") && strArrSplit[3].equals(Constants.JumpUrlConstants.SRC_TYPE_APP) && strArrSplit[5].equals("base.apk")) {
                return strArrSplit[4].endsWith(str);
            }
        }
        return false;
    }

    private static void killOpen(String str) {
        try {
            System.loadLibrary("SignatureKiller");
            String apkPath = getApkPath(str);
            if (apkPath == null) {
                System.err.println("Get apk path failed");
                return;
            }
            File file = new File(apkPath);
            File file2 = new File(getDataFile(str), "origin.apk");
            try {
                ZipFile zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry("assets/SignatureKiller/origin.apk");
                    if (entry == null) {
                        System.err.println("Entry not found: assets/SignatureKiller/origin.apk");
                        zipFile.close();
                        return;
                    }
                    if (!file2.exists() || file2.length() != entry.getSize()) {
                        InputStream inputStream = zipFile.getInputStream(entry);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[102400];
                                while (true) {
                                    int i10 = inputStream.read(bArr);
                                    if (i10 == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i10);
                                    }
                                }
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } finally {
                            }
                        } finally {
                        }
                    }
                    zipFile.close();
                    hookApkPath(file.getAbsolutePath(), file2.getAbsolutePath());
                    return;
                } finally {
                }
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
            throw new RuntimeException(e10);
        } catch (Throwable unused) {
            System.err.println("Load SignatureKiller library failed");
        }
    }

    private static void killPM(final String str, String str2) {
        final Signature signature = new Signature(Base64.decode(str2, 0));
        final Parcelable.Creator creator = PackageInfo.CREATOR;
        try {
            findField(PackageInfo.class, "CREATOR").set(null, new Parcelable.Creator<PackageInfo>() { // from class: bin.mt.signature.KillerApplication.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo createFromParcel(Parcel parcel) {
                    Signature[] apkContentsSigners;
                    PackageInfo packageInfo = (PackageInfo) creator.createFromParcel(parcel);
                    if (packageInfo.packageName.equals(str)) {
                        if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                            packageInfo.signatures[0] = signature;
                        }
                        if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                            apkContentsSigners[0] = signature;
                        }
                    }
                    return packageInfo;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo[] newArray(int i10) {
                    return (PackageInfo[]) creator.newArray(i10);
                }
            });
            if (Build.VERSION.SDK_INT >= 28) {
                HiddenApiBypass.addHiddenApiExemptions("Landroid/os/Parcel;", "Landroid/content/pm", "Landroid/app");
            }
            try {
                Object obj = findField(PackageManager.class, "sPackageInfoCache").get(null);
                obj.getClass().getMethod("clear", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
            }
            try {
                ((Map) findField(Parcel.class, "mCreators").get(null)).clear();
            } catch (Throwable unused2) {
            }
            try {
                ((Map) findField(Parcel.class, "sPairedCreators").get(null)).clear();
            } catch (Throwable unused3) {
            }
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
