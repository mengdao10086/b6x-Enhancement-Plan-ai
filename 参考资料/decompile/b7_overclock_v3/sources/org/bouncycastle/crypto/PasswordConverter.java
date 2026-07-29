package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public enum PasswordConverter implements i {
    ASCII { // from class: org.bouncycastle.crypto.PasswordConverter.1
        @Override // org.bouncycastle.crypto.i
        public byte[] convert(char[] cArr) {
            return c0.b(cArr);
        }

        @Override // org.bouncycastle.crypto.i
        public String getType() {
            return "ASCII";
        }
    },
    UTF8 { // from class: org.bouncycastle.crypto.PasswordConverter.2
        @Override // org.bouncycastle.crypto.i
        public byte[] convert(char[] cArr) {
            return c0.c(cArr);
        }

        @Override // org.bouncycastle.crypto.i
        public String getType() {
            return "UTF8";
        }
    },
    PKCS12 { // from class: org.bouncycastle.crypto.PasswordConverter.3
        @Override // org.bouncycastle.crypto.i
        public byte[] convert(char[] cArr) {
            return c0.a(cArr);
        }

        @Override // org.bouncycastle.crypto.i
        public String getType() {
            return "PKCS12";
        }
    }
}
