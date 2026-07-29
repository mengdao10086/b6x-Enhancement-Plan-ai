package io.objectbox.sync;

import io.objectbox.sync.SyncCredentials;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.annotation.Nullable;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
@c
public class a extends SyncCredentials {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SyncCredentials.CredentialsType f32954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f32955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f32956c;

    public a(SyncCredentials.CredentialsType credentialsType) {
        this.f32954a = credentialsType;
        this.f32955b = null;
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void f() {
        this.f32956c = true;
        byte[] bArr = this.f32955b;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        this.f32955b = null;
    }

    @Nullable
    public byte[] g() {
        if (this.f32956c) {
            throw new IllegalStateException("Credentials already have been cleared");
        }
        return this.f32955b;
    }

    public long h() {
        return this.f32954a.f32952id;
    }

    public a(SyncCredentials.CredentialsType credentialsType, byte[] bArr) {
        this(credentialsType);
        if (bArr != null && bArr.length != 0) {
            this.f32955b = bArr;
            return;
        }
        throw new IllegalArgumentException("Token must not be empty");
    }

    public a(SyncCredentials.CredentialsType credentialsType, String str) {
        this(credentialsType, e(str));
    }
}
