# 路线 A — 线 A：C 端改造（进展）

> 本文件进 `.claude/`（根 .gitignore 已忽略），不进版本库。唯一可写文件：`magisk模块(智能温控)/tempctrl.c`。

## 逐处改动（均为最小改动，无 PID/KI 算法、无 clamp、无广播协议、无 status 路径改动）

1. **私有目录落点**：新增 `#define PRIVATE_DIR "/data/data/com.waspwingtempctrl/files"` + 新函数 `ensure_private_dir()`（mkdir 0771；**新建时 chown 为父目录属主=app uid** —— 否则 root 先建会让 app 自身写不进 `profile.conf`）。
2. **日志默认路径**：`set_default_log_path()` 默认 `/cache/<名>.log` → `PRIVATE_DIR/<名>.log`；私有目录不可用时兜底回原 `/cache/<名>.log` 并写 stderr（不静默）。取不到自身名时用 `tempctrl` 兜底。
3. **配置默认路径**：`detect_config_path()` 由「exe 同目录找 `profile.conf`」改为「`PRIVATE_DIR/profile.conf`」；`--config <绝对路径>` 分支未动，仍优先。
4. **曲线时序数据**：`WEBUI_DATA_PATH` → `PRIVATE_DIR "/tempctrl_webui.data"`（`write_webui_data()` 代码未改，只换宏）。
5. **未找到配置不再静默**：`main()` 的 else 分支加一行 `write_log("配置 未找到 … 使用代码默认值")`。
6. **单实例锁**：新增 `#define LOCK_FILE_PATH PRIVATE_DIR "/tempctrl.lock"`、`EXIT_ALREADY_RUNNING 2`、`static int lock_fd`、新函数 `acquire_single_instance_lock()`（`flock(LOCK_EX|LOCK_NB)`）；函数内先 `ensure_private_dir()`（唯一新增调用点，`main()` 顺序未动），私有目录或锁文件不可用 → stderr + 返回 1 不阻塞启动；`main()` 首步调用，未取到锁 → stderr + `return 2`（其余启动失败路径均返回 0，可区分）；取到后记一行 `单实例锁 已获取 <path>`。
   - 用户复核后裁定：锁文件从 `/data/local/tmp/` 迁回私有目录（本项为回炉改动，其余未动）。如实记录后果：app「清除数据」会连锁文件一起删，运行中的实例与新实例随即锁到不同 inode，**那一次锁失效**，兜底靠部署脚本的开机自检（已写进代码注释）。
   - `ensure_private_dir()` 只 mkdir 一层：父目录 `/data/data/<包名>` 不存在时 ENOENT 失败、绝不逐级创建（父目录须由系统 installd 建并打 SELinux 标签）；已核，全文件仅此一处 `mkdir`。
7. **删 `uninstall.sh` 自清理**：删函数 `record_log_path_for_uninstall()`、`parse_sysfs_cfg()` 中 `LOG_FILE` 分支的调用行、全局 `uninstall_script_path`（仅该处使用，成死变量）。**只删这一处**，未动其它清理/收尾逻辑。
8. **删 `tempctrl_last_dev` 死代码（用户裁定后回炉）**：`create_status_files()` 末尾「预创建 MAC 记录文件（0666）」整块删除（`fopen("a")`/`fclose`/`chmod(0666)`，已逐行确认该块只做这件事）。该文件迁至宿主 app 私有目录 `/data/data/<飞智包名>/files/`，读写双方只有 `MainHook`（由另一 agent 改），daemon 既不读也不该再造一个 `/data/local/tmp/` 残留物。顶部私有目录注释同步改为：`status 双文件仍留 /data/local/tmp/（原样不动）` + `tempctrl_last_dev 归宿主 app 私有目录，daemon 不参与`。status 双文件路径/字段/预创建/0666 **一字未动**。

## 涉及函数（供主窗口跑 `impact` 核对）
改行为：`set_default_log_path()`、`detect_config_path()`、`parse_sysfs_cfg()`（LOG_FILE 分支）、`create_status_files()`（删 last_dev 预创建块）、`main()`。
新增：`ensure_private_dir()`、`acquire_single_instance_lock()`。
删除：`record_log_path_for_uninstall()`。
未改：`write_webui_data()`、`write_log()`、status 双文件全套（路径/字段/预创建/0666/读取）、全部 PID/KI/限速/仲裁。

## 编译验证
**未编译验证** —— 本机无任何 C 工具链（无 NDK/无 clang/gcc/MSVC 可用前端），**CI 是唯一门禁**。仅做了括号/花括号配平与人工复核；CI 若报错按报错改。`flock` 已确认 bionic `sys/file.h` 无 `__INTRODUCED_IN` 门槛，android21-clang 可编译。

## 未决 / 残留风险
- **`tempctrl_last_dev` 已由用户裁定落定**：迁宿主 app 私有目录，`MainHook` 侧由另一 agent 改，daemon 的预创建块已删（见改动 8）。**残留后果**：daemon 不再为它兜权限，若 app 侧写入失败（文件不存在/权限不足），冷启动自动连接会失效 —— 该文件现完全由 app 自建自用，daemon 不参与、也不再有 `/data/local/tmp/` 的 0666 兜底。
- 锁文件已按用户裁定改回私有目录（见改动 6），**已知残留后果**：app「清除数据」连它一起删 → 那一次锁失效（此刻运行中的实例仍持旧 inode 上的锁），兜底靠部署脚本的开机自检；代码注释已如实记录，未美化。
- 私有目录若在运行中被清数据删除，`write_log`/`write_webui_data` 的 `fopen` 会失败且不重建（无 stderr）；按 `待办.md` 风险 2 由「部署脚本开机自检 + C 端回退默认值」负责，本线未加运行时重建。
- 私有目录内的日志/数据文件为 root 创建，权限随 umask（典型 0644）；app 以自身 uid 直读时若权限不足需 chmod（线 D 日志页/曲线页留意）。

## 给 P2 的提醒
- `profile.conf` 出厂值 `LOG_FILE=/cache/tempctrl.log` 及注释「默认在 /cache/ 生成」需改为私有目录（否则覆盖 C 端新默认值）；`service.sh` 的 `LOG_FILE=/cache/tempctrl.log` 与重定向、`uninstall.sh` 的 `rm -f /cache/tempctrl.log`、`webroot/app.js:1236` 的默认值、`逻辑说明.md` 138/530/531/627 行同步。
- `webroot/schema.js:23` 的 `dataFile` 需同步为私有目录（webroot 若按计划删除则忽略）。
- `customize.sh` 125–140 行的「从旧 uninstall.sh 迁移 rm 行」逻辑随 C 端自清理移除而失效，可一并删除。
- 清理清单：`tempctrl_last_dev` 已随 app 私有目录走（卸载/清除数据自然消失），**不需要**再在 `/data/local/tmp/` 清理它，daemon 侧也已不再产生该文件；`/data/local/tmp/tempctrl.lock` 这个名字在本次裁定后**从未使用**（锁在私有目录），部署脚本若见到它是上一版遗留物，可删。
- 新日志行 `单实例锁 已获取 …`，退出码 **2** 语义为「已有实例在运行」，部署脚本判活/幂等可直接用；注意 `pkill` 后需**等待旧进程真正退出**再启动，否则新实例会立刻以 2 退出（现有 `service.sh` 只 `sleep 1`，靠 5 分钟看门狗兜底）。

## 上下文用量
本轮线 A 单 agent 执行，未派 subagent；自查约 110k/1000k tokens。
