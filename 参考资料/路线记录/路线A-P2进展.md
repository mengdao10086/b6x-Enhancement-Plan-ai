# 路线 A — P2：CI 合并 + 文档 + 删除清单（进展）

> 在 `.claude/`，**未 git add**。禁止 git commit/push/add，全程遵守。
> 状态：**四个节点全部完成**（CI / 删除 / profile.conf / 三份 md）。

## 节点 1：`profile.conf` 三处值（完成）
- `LOG_FILE` `/cache/tempctrl.log` → `/data/data/com.example.waspwingtempctrl/files/tempctrl.log`（连带同行注释「空则…在 /cache/ 生成」改为「…应用私有目录生成」）
- `APP_LAUNCH_ENABLED` 1→0（注释补「默认，需在界面中开启」，去掉已删的 customize.sh 行为）
- `APP_WATCHDOG` 6→0
- 行尾仍为纯 LF（与 HEAD 字节核对一致）；改动 5 行
- 验证：`python 参数定义/check_params.py` → A/B/C 全 PASS，**EXIT=0**（改前后均 0）

## 节点 2：合并 CI（完成，语法层面）
`.github/workflows/build.yml`：`detect-changes`（保留 lsposed/magisk 两输出）+ **单一 `build` job**
（`if: lsposed=='true' || magisk=='true'`），19 步。要点：
- **`python3 参数定义/check_params.py`** 紧跟 checkout（checkout 后、Gradle 前），退出码 0/1/2 语义原样
- **R6**：`HASH=$(cd 'magisk模块(智能温控)' && find . -type f ! -name '*.md' -print0 | LC_ALL=C sort -z | xargs -0 -r sha256sum | sha256sum | cut -d' ' -f1)`；
  并在日志里打印参与哈希的**文件清单**（可审计覆盖面）。删除后实测覆盖 5 个文件：`tempctrl.c` / `build_tempctrl.sh` / `patch_tls.py` / `profile.conf` / `webroot/schema.js`
- 注入 `lsp模块(apk修复+温控接口)/app/src/main/assets/tempctrl-arm64`（= `Deployer.BIN_ASSET`）→ `gradlew assembleRelease`
- 新增「校验 APK 内含 C 二进制」步（拆 APK 断言 `assets/tempctrl-arm64` 存在；`cp` 失败不会让 Gradle 报错）
- 删除：`build-magisk` job 全部步骤、「打包 Magisk 模块框架」、「剥离前端资源注释与缩进」、「上传体积报告」、Magisk 产物上传
- 两处**有意偏离指令原文**：① 用 `python3`（本仓库既有约定，runner 上 `python` 不保证存在）；
  ② detect-changes 的 LSP 正则加入 `参数定义/`（否则只改定义、不重生成 params.json 时 CI 根本不跑校验步骤）

**本地验证（真跑过的部分）**：YAML 解析 OK / 12 个 `run` 块全部 `bash -n` 通过 / R6 哈希管道实测可复现且稳定 /
注入步骤在临时副本上干跑成功。**未真跑**：`assembleRelease`、NDK 编译、缓存命中、`unzip` 断言、CI 上的 Python 可用性。
自查中**修掉自己写的一个真 bug**：`cp lsp模块(apk修复+温控接口)/...` 未加引号 → bash 对 `(` 报语法错误；改为 `cp "…release/"*.apk`。

## 节点 3：删除（完成）
实际删除 10 个路径（计划 8 条，`META-INF/` 展开为 2 文件）——与计划逐条一致，**无多删**：
`magisk模块框架/{module.prop, customize.sh, uninstall.sh, service.sh}`、
`magisk模块框架/webroot/{app.js, style.css, index.html}`、
`magisk模块框架/META-INF/com/google/android/{update-binary, updater-script}`、
`magisk模块(智能温控)/strip_webroot.py`
- 保留：`magisk模块框架/profile.conf`、`magisk模块框架/webroot/schema.js`
- 用 `rm`（**未 `git rm`**），工作树为 ` D` 未暂存态
- 删除后 `git status --short`：仅预期的 10 个 ` D` + 预期 ` M`，无多余增删

## 节点 4：三份 md（完成）
- `README.md`：组件表 2 行 → 1 个 APK + 源码/定义两行；架构概览补落点一句话；功能段 WebUI → 原生界面、去掉「音量±选择」；项目结构树更新（去 module.prop/service.sh/customize.sh/webroot 多文件，加 `参数定义/`）
- `CLAUDE.md`：参数同步规则改为「`params.def.json` 唯一手写处 → gen_params → check_params」并列出派生副本；编译须知补单一构建链；版本号条目去掉 `module.prop`；关键文件索引补 `参数定义/*`
- `逻辑说明.md`：配置路径检测改私有目录 + 三处一致说明；`--config`/常见坑行改部署脚本；参数表 `LOG_FILE`、`APP_LAUNCH_ENABLED`、`APP_WATCHDOG` 行；日志系统默认路径；status 表加「原样未动」；`tempctrl_last_dev` 改宿主私有目录（各包各记）；**`## WebUI 配置界面（webroot）` 整节重写为 `## 原生配置界面（APK 内）`**（含参数落点表、曲线口径全文保留但重新锚定到原生实现、日志页、已知限制）；`## Magisk 模块框架` → `## 交付物与构建产物`；KernelSU noexec 行改部署流程
- 三份 md 自查：**无指向已删文件的失效引用**（残留的 `/cache/` 是 C 端真实兜底路径；一条 `已随路线 A 删除：…` 是显式历史注记）；markdown 内部链接 0 失效

## 未决（已写进最终报告）
版本号口径（APK 2.6 vs 已删的模块 v2.7）、只读侧陈旧引用（`tempctrl.c:5`、`diagnose_status.sh:21`、`ui/*.java` 的 `app.js:NNNN`、`参数定义/*` 引 app.js、
`webroot/schema.js` 的 `dataFile`/`configPath`/`subKeys`/自述）、CI 未真跑、`webroot/` 目录名已名不副实
