package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AnnotatedPrivateKey implements PrivateKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45251a = "label";
    private final Map<String, Object> annotations;
    private final PrivateKey key;

    public AnnotatedPrivateKey(PrivateKey privateKey, String str) {
        this.key = privateKey;
        this.annotations = Collections.singletonMap("label", str);
    }

    public AnnotatedPrivateKey(PrivateKey privateKey, Map<String, Object> map) {
        this.key = privateKey;
        this.annotations = map;
    }

    public AnnotatedPrivateKey a(String str, Object obj) {
        HashMap map = new HashMap(this.annotations);
        map.put(str, obj);
        return new AnnotatedPrivateKey(this.key, (Map<String, Object>) Collections.unmodifiableMap(map));
    }

    public Object b(String str) {
        return this.annotations.get(str);
    }

    public Map<String, Object> c() {
        return this.annotations;
    }

    public PrivateKey d() {
        return this.key;
    }

    public boolean equals(Object obj) {
        PrivateKey privateKey;
        if (obj instanceof AnnotatedPrivateKey) {
            privateKey = this.key;
            obj = ((AnnotatedPrivateKey) obj).key;
        } else {
            privateKey = this.key;
        }
        return privateKey.equals(obj);
    }

    public AnnotatedPrivateKey f(String str) {
        HashMap map = new HashMap(this.annotations);
        map.remove(str);
        return new AnnotatedPrivateKey(this.key, (Map<String, Object>) Collections.unmodifiableMap(map));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.key.getFormat();
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return (this.annotations.containsKey("label") ? this.annotations.get("label") : this.key).toString();
    }
}
