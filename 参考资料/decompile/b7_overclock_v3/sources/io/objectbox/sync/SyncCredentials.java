package io.objectbox.sync;

import li.b;

/* JADX INFO: loaded from: classes5.dex */
@b
public class SyncCredentials {

    public enum CredentialsType {
        NONE(1),
        SHARED_SECRET(2),
        GOOGLE(3);


        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final long f32952id;

        CredentialsType(long j10) {
            this.f32952id = j10;
        }
    }

    public static SyncCredentials a(String str) {
        return new a(CredentialsType.GOOGLE, str);
    }

    public static SyncCredentials b() {
        return new a(CredentialsType.NONE);
    }

    public static SyncCredentials c(String str) {
        return new a(CredentialsType.SHARED_SECRET, str);
    }

    public static SyncCredentials d(byte[] bArr) {
        return new a(CredentialsType.SHARED_SECRET, bArr);
    }
}
