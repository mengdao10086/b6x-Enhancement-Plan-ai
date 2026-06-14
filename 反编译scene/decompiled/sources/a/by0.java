package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class by0 {
    public long lastUpdate;
    public String id = "";
    public String propUrl = "";
    public String zipUrl = "";
    public String notesUrl = "";

    public final String getId() {
        return this.id;
    }

    public final long getLastUpdate() {
        return this.lastUpdate;
    }

    public final String getNotesUrl() {
        return this.notesUrl;
    }

    public final String getPropUrl() {
        return this.propUrl;
    }

    public final String getZipUrl() {
        return this.zipUrl;
    }

    public final void setId(String str) {
        f92.d(str, "<set-?>");
        this.id = str;
    }

    public final void setLastUpdate(long j) {
        this.lastUpdate = j;
    }

    public final void setNotesUrl(String str) {
        f92.d(str, "<set-?>");
        this.notesUrl = str;
    }

    public final void setPropUrl(String str) {
        f92.d(str, "<set-?>");
        this.propUrl = str;
    }

    public final void setZipUrl(String str) {
        f92.d(str, "<set-?>");
        this.zipUrl = str;
    }
}
