package a;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.security.MessageDigest;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k60 {
    public final String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String b(Context context) {
        return context.getApplicationInfo().packageName;
    }

    public final String c(Context context, String str) {
        byte[] byteArray = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length && (byteArray = packageInfo.signatures[i].toByteArray()) == null; i++) {
            }
            return a(byteArray);
        } catch (Exception unused) {
            return "";
        }
    }

    public String d(Context context) {
        return c(context, b(context));
    }
}
