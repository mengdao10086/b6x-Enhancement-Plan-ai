package hh;

import com.upyun.library.exception.UpYunException;
import fh.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31295a = "HmacSHA1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31296b = "upyun-android-sdk 2.1.2";

    public static String a(String str, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f31295a);
        Mac mac = Mac.getInstance(f31295a);
        mac.init(secretKeySpec);
        return l(mac.doFinal(str2.getBytes()));
    }

    public static byte[] b(String str, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f31295a);
        Mac mac = Mac.getInstance(f31295a);
        mac.init(secretKeySpec);
        return mac.doFinal(str2.getBytes());
    }

    public static int c(File file, int i10) {
        return (int) Math.ceil(file.length() / ((double) i10));
    }

    public static String d(Map<String, Object> map) {
        return b.k(new JSONObject(map).toString());
    }

    public static String e(String str, String str2) {
        return h(str + "&" + str2);
    }

    public static String f(Map<String, Object> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer("");
        for (Object obj : array) {
            stringBuffer.append(obj);
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return i(stringBuffer.toString().getBytes());
    }

    public static String g(File file, int i10) {
        int i11;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[i10];
            while (true) {
                int i12 = fileInputStream.read(bArr);
                if (i12 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i12);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
            for (byte b10 : bArrDigest) {
                int i13 = b10 & 255;
                if (i13 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i13));
            }
            return sb2.toString();
        } catch (FileNotFoundException e10) {
            throw new RuntimeException("file not found", e10);
        } catch (IOException e11) {
            throw new RuntimeException("file get md5 failed", e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e12);
        }
    }

    public static String h(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
            for (byte b10 : bArrDigest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 is unsupported", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e11);
        }
    }

    public static String i(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
            for (byte b10 : bArrDigest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e10);
        }
    }

    public static String j(File file) {
        int i10;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[j.f28479a];
            while (true) {
                int i11 = fileInputStream.read(bArr);
                if (i11 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i11);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder(bArrDigest.length * 2);
            for (byte b10 : bArrDigest) {
                int i12 = b10 & 255;
                if (i12 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i12));
            }
            return sb2.toString();
        } catch (FileNotFoundException e10) {
            throw new RuntimeException("file not found", e10);
        } catch (IOException e11) {
            throw new RuntimeException("file get md5 failed", e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e12);
        }
    }

    public static String k(String str, String str2, String str3, String str4, String str5, String str6) throws UpYunException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("&");
        sb2.append(str3);
        sb2.append("&");
        sb2.append(str2);
        if (str6 != null && str6.length() > 0) {
            sb2.append("&");
            sb2.append(str6);
        }
        try {
            byte[] bArrB = b(str5, sb2.toString().trim());
            if (bArrB == null) {
                return null;
            }
            return "UPYUN " + str4 + ":" + b.i(bArrB).trim();
        } catch (Exception unused) {
            throw new UpYunException("calculate SHA1 wrong.");
        }
    }

    public static String l(byte[] bArr) {
        Formatter formatter = new Formatter();
        for (byte b10 : bArr) {
            formatter.format("%02x", Byte.valueOf(b10));
        }
        return formatter.toString();
    }
}
