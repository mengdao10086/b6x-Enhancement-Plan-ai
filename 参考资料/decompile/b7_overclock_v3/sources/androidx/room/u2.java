package androidx.room;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7520a = "room_master_table";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7521b = "room_master_table";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7522c = "id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7523d = "identity_hash";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7524e = "42";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7525f = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7526g = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";

    public static String a(String str) {
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
