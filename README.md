# android-support-io

## 发布
* 最新版本

| groupId | artifactId | version |
| -------- | -------- | -------- |
| com.amlzq.android | io |  |

* 使用
```
dependencies{
    implementation 'com.amlzq.android:io:latest.integration'
}
```

## 工程结构
* ./io
> io library
```
package: com.amlzq.android.io
```
* ./sample
> sample application
```
package: com.amlzq.asb
appName: IO支持库
applicationId: com.amlzq.asb.io
```

## 功能
* [Parse XML data](https://developer.android.com/training/basics/network-ops/xml)

- [一个Android平台的高性能key-value组件，读写性能远超SharedPreferences](https://github.com/JeremyLiao/FastSharedPreferences)

- 数据持久化的5中方式
```
File
SharedPreferences
SQLite
ContentProvide
```

### 文件
File
SharedPreferences
- [目录问题](https://blog.csdn.net/chxc_yy/article/details/81536875)
```
<files-path name="name" path="path" /> 物理路径相当于Context.getFilesDir() + /path/
 
<cache-path name="name" path="path" /> 物理路径相当于Context.getCacheDir() + /path/
 
<external-path name="name" path="path" /> 物理路径相当于Environment.getExternalStorageDirectory() + /path/
 
<external-files-path name="name" path="path" /> 物理路径相当于Context.getExternalFilesDir(String) + /path/
 
<external-cache-path name="name" path="path" /> 物理路径相当于Context.getExternalCacheDir() + /path/
```

### 网络
- JSON
- XML

### SQLite ORM
- Native SQLite
- GreenDao实践
- Room实践

### JSON解析
- GSON
- FastJSON
- JackJSON

### 内存


### 三级缓存
- 内存，磁盘，远程
- []()

### 存储方式的使用场景
- [Pros and Cons of SQLite and Shared Preferences](https://stackoverflow.com/questions/6276358/pros-and-cons-of-sqlite-and-shared-preferences)

### DiskLruCache
- [Google DiskLruCache](https://android.googlesource.com/platform/libcore/+/android-4.1.1_r1/luni/src/main/java/libcore/io/DiskLruCache.java)
- [JakeWharton/DiskLruCache](https://github.com/JakeWharton/DiskLruCache)
