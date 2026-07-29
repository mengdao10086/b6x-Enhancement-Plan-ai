package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import moe.shizuku.manager.adb.AdbKey;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KeyStore f22792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f22793b;

    public a(Context context) {
        try {
            this.f22793b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore keyStore = KeyStore.getInstance(AdbKey.f41450i);
            this.f22792a = keyStore;
            keyStore.load(null);
            if (this.f22792a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            c("");
            a(context);
            a();
        } catch (Exception e10) {
            SLog.d("KEYSTORE", "Exception", e10);
        }
    }

    private void a(Context context) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Build.VERSION.SDK_INT=");
        int i10 = Build.VERSION.SDK_INT;
        sb2.append(i10);
        SLog.d("KEYSTORE", sb2.toString());
        if (i10 >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", AdbKey.f41450i);
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", AdbKey.f41450i);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    private void c(String str) {
        this.f22793b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(String str) {
        this.f22793b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public String b(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance(AdbKey.f41452k);
            cipher.init(2, c(), new IvParameterSpec(b()));
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e10) {
            SLog.e("KEYSTORE", "Exception", e10);
            return "";
        }
    }

    private SecretKeySpec c() throws Exception {
        String string = this.f22793b.getString("PREF_KEY_AES", "");
        PrivateKey privateKey = (PrivateKey) this.f22792a.getKey("KEYSTORE_AES", null);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, privateKey);
        return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), AdbKey.f41452k);
    }

    private byte[] b() {
        return Base64.decode(this.f22793b.getString("PREF_KEY_IV", ""), 0);
    }

    public String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance(AdbKey.f41452k);
            cipher.init(1, c(), new IvParameterSpec(b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e10) {
            SLog.e("KEYSTORE", "Exception", e10);
            return "";
        }
    }

    private void a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        PublicKey publicKey = this.f22792a.getCertificate("KEYSTORE_AES").getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        d(Base64.encodeToString(cipher.doFinal(bArr), 0));
    }
}
