# 联系方法

::: warning 警告
本文档适用于 WAuxiliary v1.2.6 版本
:::

## 取当前登录Wxid

```java
String getLoginWxid();
```

## 取当前登录微信号

```java
String getLoginAlias();
```

## 取上下文Wxid

```java
String getTargetTalker();
```

## 取好友列表

```java
List<FriendInfo> getFriendList();
```

## 取好友昵称

```java
String getFriendName(String friendWxid);

String getFriendName(String friendWxid, String roomId);
```

## 取头像链接

```java
void getAvatarUrl(String username);

void getAvatarUrl(String username, boolean isBigHeadImg);
```

## 取群聊列表

```java
List<GroupInfo> getGroupList();
```

## 取群成员列表

```java
List<String> getGroupMemberList(String groupWxid);
```

## 取群成员数量

```java
int getGroupMemberCount(String groupWxid);
```

## 添加群成员

```java
void addChatroomMember(String chatroomId, String addMember);

void addChatroomMember(String chatroomId, List<String> addMemberList);
```

## 邀请群成员

```java
void inviteChatroomMember(String chatroomId, String inviteMember);

void inviteChatroomMember(String chatroomId, List<String> inviteMemberList);
```

## 移除群成员

```java
void delChatroomMember(String chatroomId, String delMember);

void delChatroomMember(String chatroomId, List<String> delMemberList);
```

## 通过好友申请

```java
void verifyUser(String wxid, String ticket, int scene);

void verifyUser(String wxid, String ticket, int scene, int privacy);
```

## 修改好友标签

```java

void modifyContactLabelList(String username, String labelName);

void modifyContactLabelList(String username, List<String> labelNames);
```
