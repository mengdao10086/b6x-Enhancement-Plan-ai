package a;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v91 implements Map.Entry<String, Long>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f7671a;

    public v91(List list) {
        this.f7671a = list;
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return (String) this.f7671a.get(0);
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long getValue() {
        return Long.valueOf(Long.parseLong((String) this.f7671a.get(1)));
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ Long setValue(Long l) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
