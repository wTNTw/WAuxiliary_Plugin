# 媒体方法

::: warning 警告
本文档适用于 WAuxiliary v1.2.6 版本
:::

## 发送媒体

```java
void sendMediaMsg(String talker, MediaMessage mediaMessage, String appId);
```

## 分享文件

```java
void shareFile(String talker, String title, String filePath, String appId);
```

## 分享小程序

```java
void shareMiniProgram(String talker, String title, String description, String userName, String path, byte[] thumbData, String appId);
```

## 分享音乐

```java
void shareMusic(String talker, String title, String description, String musicUrl, String musicDataUrl, byte[] thumbData, String appId);
```

## 分享音乐视频

```java
void shareMusicVideo(String talker, String title, String description, String musicUrl, String musicDataUrl, String singerName, String duration, String songLyric, byte[] thumbData, String appId);
```

## 分享文本

```java
void shareText(String talker, String text, String appId);
```

## 分享视频

```java
void shareVideo(String talker, String title, String description, String videoUrl, byte[] thumbData, String appId);
```

## 分享网页

```java
void shareWebpage(String talker, String title, String description, String webpageUrl, byte[] thumbData, String appId);
```
