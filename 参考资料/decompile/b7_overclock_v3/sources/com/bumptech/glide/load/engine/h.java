package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12378a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f12379b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f12380c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f12381d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f12382e = new e();

    public class a extends h {
        @Override // com.bumptech.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    public class b extends h {
        @Override // com.bumptech.glide.load.engine.h
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    public class c extends h {
        @Override // com.bumptech.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    public class d extends h {
        @Override // com.bumptech.glide.load.engine.h
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    public class e extends h {
        @Override // com.bumptech.glide.load.engine.h
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.h
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z10 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy);
}
