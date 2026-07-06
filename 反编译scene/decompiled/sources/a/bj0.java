package a;

import android.annotation.SuppressLint;
import android.os.Build;
import com.omarea.Scene;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"NewApi"})
public class bj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5709a = "/odm/etc/orms/orms_core_config.xml";
    public static String b = "/data/system/orms";
    public static String c = b + "/orms_core_config.xml";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Charset f279a = StandardCharsets.UTF_8;

    public static boolean k() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (lowerCase.equals("realme") || lowerCase.equals("oppo") || lowerCase.equals("oneplus")) {
            return y60.f7952a.d(f5709a) || y60.f7952a.d(c);
        }
        return false;
    }

    public String a(boolean z) {
        String strD = z ? d(y60.f7952a.i(f5709a)) : f();
        n61 n61Var = new n61();
        Document documentA = n61Var.a(strD);
        NodeList elementsByTagName = documentA.getDocumentElement().getElementsByTagName("config");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Element element = (Element) elementsByTagName.item(i);
            NodeList elementsByTagName2 = element.getElementsByTagName("level");
            int length = elementsByTagName2.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                c((Element) elementsByTagName2.item(i2));
            }
            NodeList elementsByTagName3 = element.getElementsByTagName("mode");
            int length2 = elementsByTagName3.getLength();
            for (int i3 = 0; i3 < length2; i3++) {
                c((Element) elementsByTagName3.item(i3));
            }
        }
        String strD2 = c60.f5764a.d(Scene.f4796a, "orms_core_config.xml");
        if (!z) {
            strD2 = strD2 + ".cache.xml";
        }
        n61Var.b(documentA, strD2);
        String str = new String(c60.f5764a.g(new File(strD2)), bb2.f5692a);
        if (z) {
            c60.f5764a.i(new File(strD2), g(str).getBytes());
        } else {
            new File(strD2).delete();
        }
        return str;
    }

    public final String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public final void c(Element element) {
        Node nodeItem;
        String str;
        NamedNodeMap attributes = element.getAttributes();
        int length = element.getAttributes().getLength();
        for (int i = 0; i < length; i++) {
            nodeItem = attributes.item(i);
            switch (nodeItem.getNodeName()) {
                case "minCpuCore":
                case "maxCpuCore":
                case "minCpuFreq":
                case "maxCpuFreq":
                case "maxCpuFreqHigh":
                case "maxCpuCoreHigh":
                    str = "-1,-1,-1";
                    nodeItem.setNodeValue(str);
                    break;
                case "minGpuCore":
                case "maxGpuCore":
                case "minGpuFreq":
                case "maxGpuFreq":
                    str = "-1";
                    nodeItem.setNodeValue(str);
                    break;
                case "cpuBouncingEnable":
                    str = "0";
                    nodeItem.setNodeValue(str);
                    break;
            }
        }
    }

    public String d(String str) {
        return e(j().getBytes(), str);
    }

    public String e(byte[] bArr, String str) throws Exception {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(Base64.getMimeDecoder().decode(str));
            byte[] bArr2 = new byte[byteBufferWrap.get()];
            byteBufferWrap.get(bArr2);
            byte[] bArr3 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr3);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr, "AES"), new GCMParameterSpec(128, bArr2));
            byte[] bArrDoFinal = cipher.doFinal(bArr3);
            Arrays.fill(bArr2, (byte) 0);
            Arrays.fill(bArr3, (byte) 0);
            return new String(bArrDoFinal, this.f279a);
        } catch (Exception e) {
            throw new Exception("could not decrypt", e);
        }
    }

    public String f() {
        String str = f5709a;
        String str2 = c;
        if (y60.f7952a.d(str2)) {
            str = str2;
        } else if (!y60.f7952a.d(str)) {
            return "";
        }
        return d(y60.f7952a.i(str));
    }

    public String g(String str) {
        return h(j().getBytes(), str);
    }

    public String h(byte[] bArr, String str) throws Exception {
        try {
            byte[] bArr2 = new byte[12];
            new SecureRandom().nextBytes(bArr2);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, new SecretKeySpec(bArr, "AES"), new GCMParameterSpec(128, bArr2));
            byte[] bArrDoFinal = cipher.doFinal(str.getBytes(this.f279a));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(13 + bArrDoFinal.length);
            byteBufferAllocate.put((byte) 12);
            byteBufferAllocate.put(bArr2);
            byteBufferAllocate.put(bArrDoFinal);
            return Base64.getEncoder().encodeToString(byteBufferAllocate.array());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String i(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            return b(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String j() {
        return i("ORMS").substring(0, 16);
    }
}
