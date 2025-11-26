# 在 Cursor 中打开 GitHub 项目指南

## 项目信息
- **GitHub仓库**: `https://github.com/zzy68789/hm-springboot.git`
- **项目类型**: Spring Boot 3.3.2 (Maven项目)

---

## 方法一：使用 Cursor 界面克隆项目（推荐）

### 步骤 1: 打开 Cursor

1. **启动 Cursor 编辑器**
   - 打开 Cursor 应用程序

2. **打开命令面板**
   - 按 `Ctrl+Shift+P` (Windows/Linux) 或 `Cmd+Shift+P` (Mac)
   - 或者点击菜单 `View` → `Command Palette...`

### 步骤 2: 克隆 GitHub 仓库

1. **选择克隆命令**
   - 在命令面板中输入: `Git: Clone`
   - 选择 `Git: Clone` 命令

2. **输入仓库URL**
   - 输入GitHub仓库地址: `https://github.com/zzy68789/hm-springboot.git`
   - 或者输入: `zzy68789/hm-springboot`
   - 按 `Enter` 确认

3. **选择保存位置**
   - 选择本地文件夹来保存项目
   - 选择一个合适的目录（例如: `~/Projects` 或 `D:\Projects`）
   - 点击 `Select Repository Location`

4. **等待克隆完成**
   - Cursor会自动克隆项目
   - 底部状态栏会显示进度

5. **打开项目**
   - 克隆完成后，Cursor会提示是否打开项目
   - 点击 `Open` 打开项目
   - 或者点击 `Open in New Window` 在新窗口打开

---

## 方法二：使用欢迎页面

### 步骤 1: 使用欢迎界面

1. **打开 Cursor**
   - 如果是首次打开，会显示欢迎页面
   - 如果已打开，可以关闭所有窗口回到欢迎页面

2. **克隆仓库**
   - 在欢迎页面找到 `Clone Git Repository...`
   - 或者点击 `Start` → `Clone Git Repository...`

3. **输入仓库URL**
   - 输入: `https://github.com/zzy68789/hm-springboot.git`
   - 按 `Enter`

4. **选择保存位置并打开**
   - 选择保存目录
   - 克隆完成后自动打开

---

## 方法三：使用终端命令克隆（适合熟悉命令行的用户）

### 步骤 1: 打开终端

1. **在 Cursor 中打开终端**
   - 按 `` Ctrl+` `` (反引号键，通常在键盘左上角)
   - 或者菜单: `Terminal` → `New Terminal`
   - 或者 `View` → `Terminal`

### 步骤 2: 克隆项目

```bash
# 进入你想要保存项目的目录
cd ~/Projects  # 或你的项目目录

# 克隆仓库
git clone https://github.com/zzy68789/hm-springboot.git

# 进入项目目录
cd hm-springboot
```

### 步骤 3: 在 Cursor 中打开

1. **打开文件夹**
   - 按 `Ctrl+K Ctrl+O` (Windows/Linux) 或 `Cmd+K Cmd+O` (Mac)
   - 或者菜单: `File` → `Open Folder...`
   - 选择刚才克隆的 `hm-springboot` 文件夹
   - 点击 `Select Folder`

---

## 方法四：如果项目已经在本地

### 步骤 1: 打开现有项目

1. **打开文件夹**
   - 按 `Ctrl+K Ctrl+O` (Windows/Linux) 或 `Cmd+K Cmd+O` (Mac)
   - 或者菜单: `File` → `Open Folder...`
   - 选择项目根目录（包含 `pom.xml` 的文件夹）
   - 点击 `Select Folder`

2. **信任项目（首次打开）**
   - Cursor可能会询问是否信任项目
   - 点击 `Yes, I trust the authors` 或 `Trust Folder`

---

## 配置项目（克隆后）

### 步骤 1: 安装推荐扩展（可选）

Cursor可能会提示安装推荐扩展，对于Java/Spring Boot项目，建议安装：

- **Extension Pack for Java** (Microsoft)
- **Spring Boot Extension Pack** (VMware)
- **Maven for Java** (Microsoft)

### 步骤 2: 配置 Java 环境

1. **检查 Java 版本**
   - 打开终端: `` Ctrl+` ``
   - 运行: `java -version`
   - 确保是 Java 17 或更高版本

2. **配置 Java 路径（如果需要）**
   - 按 `Ctrl+Shift+P` 打开命令面板
   - 输入: `Java: Configure Java Runtime`
   - 选择正确的 JDK 路径

### 步骤 3: 等待 Maven 依赖下载

1. **自动检测**
   - Cursor会自动检测到 `pom.xml`
   - 右下角会显示 "Maven projects need to be imported"
   - 点击 "Import Maven Projects"

2. **手动导入（如果没有自动提示）**
   - 打开命令面板: `Ctrl+Shift+P`
   - 输入: `Java: Clean Java Language Server Workspace`
   - 或者右键点击 `pom.xml` → `Reimport Maven Projects`

3. **查看进度**
   - 底部状态栏会显示下载进度
   - 等待所有依赖下载完成（可能需要几分钟）

### 步骤 4: 配置数据库（重要）

1. **打开配置文件**
   - 在文件资源管理器中找到: `src/main/resources/application.yml`
   - 双击打开

2. **修改数据库配置**
   - 修改为你的本地MySQL配置：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/你的数据库名?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: 你的数据库用户名
    password: 你的数据库密码
```

---

## 在 Cursor 中运行项目

### 方法一：使用终端运行（推荐）

1. **打开终端**
   - 按 `` Ctrl+` `` 打开终端

2. **运行项目**
   ```bash
   # 使用Maven运行
   ./mvnw spring-boot:run
   
   # 或者如果已安装Maven
   mvn spring-boot:run
   ```

3. **查看输出**
   - 终端会显示启动日志
   - 看到 `Started HelloApplication` 表示成功
   - 访问: `http://localhost:8080`

### 方法二：使用运行配置

1. **创建运行配置**
   - 打开 `.vscode/launch.json`（如果没有，创建它）
   - 添加以下配置：

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch HelloApplication",
            "request": "launch",
            "mainClass": "com.example.hello.HelloApplication",
            "projectName": "hello"
        }
    ]
}
```

2. **运行**
   - 按 `F5` 启动调试
   - 或者点击左侧调试图标 → 选择配置 → 点击运行按钮

### 方法三：直接运行主类

1. **打开主类文件**
   - 打开 `src/main/java/com/example/hello/HelloApplication.java`

2. **运行**
   - 点击 `main` 方法上方的 `Run | Debug` 按钮
   - 或者右键点击文件 → `Run Java`

---

## 常用快捷键

- **打开命令面板**: `Ctrl+Shift+P` (Windows/Linux) / `Cmd+Shift+P` (Mac)
- **打开终端**: `` Ctrl+` `` (反引号)
- **打开文件夹**: `Ctrl+K Ctrl+O`
- **搜索文件**: `Ctrl+P`
- **全局搜索**: `Ctrl+Shift+F`
- **运行/调试**: `F5`
- **停止运行**: `Ctrl+C` (在终端中)

---

## 常见问题解决

### 1. 克隆失败

**问题**: 无法克隆仓库

**解决方案**:
- 检查网络连接
- 确认仓库URL正确
- 如果使用SSH，确保已配置SSH密钥
- 尝试使用HTTPS方式: `https://github.com/zzy68789/hm-springboot.git`

### 2. Maven依赖下载失败

**问题**: 依赖下载很慢或失败

**解决方案**:
- 配置Maven镜像（阿里云）:
  - 创建或编辑 `~/.m2/settings.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings>
  <mirrors>
    <mirror>
      <id>aliyunmaven</id>
      <mirrorOf>*</mirrorOf>
      <name>阿里云公共仓库</name>
      <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
  </mirrors>
</settings>
```

### 3. Java扩展未安装

**问题**: 代码没有语法高亮或智能提示

**解决方案**:
- 打开扩展面板: `Ctrl+Shift+X`
- 搜索并安装 "Extension Pack for Java"
- 重启 Cursor

### 4. 找不到主类

**问题**: 无法运行主类

**解决方案**:
- 确保已安装 Java 扩展
- 等待 Maven 项目完全导入
- 检查 `pom.xml` 是否正确
- 重新加载窗口: `Ctrl+Shift+P` → `Developer: Reload Window`

### 5. 数据库连接失败

**问题**: 启动时报数据库错误

**解决方案**:
- 确保 MySQL 服务正在运行
- 检查 `application.yml` 中的数据库配置
- 确认数据库已创建
- 检查用户名和密码是否正确

---

## 验证项目是否成功打开

✅ **检查清单**:
- [ ] 项目文件夹已在 Cursor 中打开
- [ ] 文件资源管理器显示项目结构
- [ ] `pom.xml` 文件可见
- [ ] Java 扩展已安装
- [ ] Maven 依赖已下载（底部状态栏无错误）
- [ ] 代码有语法高亮
- [ ] 可以运行项目（终端或运行配置）

---

## 项目结构说明

在 Cursor 的文件资源管理器中，你应该看到：

```
hm-springboot/
├── .git/                    # Git配置（隐藏）
├── .gitignore              # Git忽略文件
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/hello/
│   │   │       ├── HelloApplication.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       └── ...
│   │   └── resources/
│   │       ├── application.yml
│   │       └── mapper/
│   └── test/
├── pom.xml                 # Maven配置文件
├── README.md
├── entrypoint.sh
└── mvnw                    # Maven Wrapper
```

---

## 快速开始命令总结

```bash
# 1. 克隆项目
git clone https://github.com/zzy68789/hm-springboot.git
cd hm-springboot

# 2. 在Cursor中打开
# 使用 Ctrl+K Ctrl+O 打开文件夹

# 3. 运行项目（在Cursor终端中）
./mvnw spring-boot:run
```

---

## 下一步

项目成功打开后，你可以：
1. 修改代码
2. 运行和调试应用
3. 使用 Git 进行版本控制
4. 安装更多有用的扩展

祝您使用愉快！如有问题，请参考上述常见问题解决方案。

