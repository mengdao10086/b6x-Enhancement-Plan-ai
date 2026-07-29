package io.objectbox.tree;

import javax.annotation.Nullable;
import li.b;

/* JADX INFO: loaded from: classes5.dex */
@b
public class Branch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Tree f32960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32961b;

    public Branch(Tree tree, long j10) {
        this.f32960a = tree;
        this.f32961b = j10;
    }

    private native long nativeGetBranchId(long j10, long j11, String[] strArr);

    private native LeafNode nativeGetLeaf(long j10, long j11, String[] strArr);

    @Nullable
    public Branch a(String str) {
        d(str);
        return b(str.split(this.f32960a.z()));
    }

    @Nullable
    public Branch b(String[] strArr) {
        e(strArr);
        long jNativeGetBranchId = nativeGetBranchId(this.f32960a.m(), this.f32961b, strArr);
        if (jNativeGetBranchId == 0) {
            return null;
        }
        return new Branch(this.f32960a, jNativeGetBranchId);
    }

    @Nullable
    public Branch c(String str) {
        return b(new String[]{str});
    }

    public final void d(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("name/path must not be null or empty");
        }
    }

    public final void e(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("path must not be null or empty");
        }
    }

    public long f() {
        return this.f32961b;
    }

    public Tree g() {
        return this.f32960a;
    }

    @Nullable
    public wi.b h(String str) {
        d(str);
        return i(str.split(this.f32960a.z()));
    }

    @Nullable
    public wi.b i(String[] strArr) {
        e(strArr);
        LeafNode leafNodeNativeGetLeaf = nativeGetLeaf(this.f32960a.m(), this.f32961b, strArr);
        if (leafNodeNativeGetLeaf == null) {
            return null;
        }
        return new wi.b(leafNodeNativeGetLeaf);
    }

    @Nullable
    public wi.b j(String str) {
        d(str);
        return i(new String[]{str});
    }
}
