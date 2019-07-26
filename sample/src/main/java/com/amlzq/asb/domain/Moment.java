package com.amlzq.asb.domain;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 用户动态
 * MomentInfo
 */
public class Moment {

    public static final int IMAGE_0 = 0; // 无图片
    public static final int IMAGE_1 = 1; // 一张图
    public static final int IMAGE_2 = 2;
    public static final int IMAGE_3 = 3;
    public static final int IMAGE_4 = 4;
    public static final int IMAGE_5 = 5;
    public static final int IMAGE_6 = 6;
    public static final int IMAGE_7 = 7;
    public static final int IMAGE_8 = 8;
    public static final int IMAGE_9 = 9; // 九张图
    public static final int VIDEO = 10; // 视频

    // =============================================================================================
    // 包装方法
    // =============================================================================================

    /**
     * @return 用户昵称，界面显示
     */
    public String getUserNicknameWrapper() {
        if (TextUtils.isEmpty(userOpenId) && TextUtils.isEmpty(userNickname)) return "";
//        return TextUtils.isEmpty(nickName) ? String.format(ContextHolder.getString(R.string.empty_nickname_default), userOpenId) : userNickname;
        // 服务端已经处理未设置昵称的情况，所以直接取服务端数据
        return userNickname;
    }

    /**
     * @return 视频封面/缩略图
     */
    public String getVideoCover() {
        String url = "";
        try {
            url = getImages().get(1);
        } catch (Exception e) {
            // 系统后台发帖存在无缩略图问题
            e.printStackTrace();
        }
//        try {
//            JSONArray ja = new JSONArray(getPic());
//            url = ja.get(1).toString();
//            url = RemoteAPIs.BASE_URL + url;
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return url;
    }

    public String getVideoUrl() {
        String url = getImages().get(0);
//        try {
//            JSONArray ja = new JSONArray(getPic());
//            url = ja.get(0).toString();
//            url = RemoteAPIs.BASE_URL + url;
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return url;
    }

    /**
     * 服务端接口处理不一致
     *
     * @return 返回可用的用户头像地址
     */
    public String getUserAvatarWrapper() {
//        if (userAvatar.contains(MyConfig.PORTAL_PROTOCOL)) {
//            return userAvatar;
//        } else {
//            return RemoteAPIs.BASE_URL + userAvatar;
//        }
        return "";
    }

    /**
     * @return 已点赞
     */
    public boolean isLiked() {
        return liked == 1;
    }

    /**
     * @return 已救助
     */
    public boolean isRescued() {
        return getState() == 1;
    }

    /**
     * @return 是救助动态
     */
    public boolean isRescueMoment() {
        //"1救助帖子2广场帖子"
        return getType() == 1;
    }

    /**
     * @return 显示位置
     */
    public boolean isShowLocation() {
        //1是显示 地址，0是隐藏地址
        return getShowLocation() == 1;
    }

    // 基础属性
    @SerializedName(value = "post_id", alternate = {"c_id", "m_id"})
    private String id; // 惟一标识 (postId救助帖子或者广场帖子ID，cardId广场的帖子id，mapId救助帖子id)
    @SerializedName("content")
    private String content; // 字符内容
    @SerializedName("pic")
    private List<String> images; // 图片或视频内容
    @SerializedName("create_time")
    private String createTime; // 发帖时间
    @SerializedName("click_num")
    private int likeCount; // 点赞数
    @SerializedName("feedback_num")
    private int commentCount; // 评论数
    @SerializedName("share_num")
    private int shareCount; // 分享数
    @SerializedName("is_click")
    private int liked; // 已点赞
    private double longitude; // 经度
    private double latitude; // 纬度
    @SerializedName("lbs")
    private String location; // 地理位置/定位
    @SerializedName("is_lbs")
    private int showLocation; // 显示位置[0隐藏，1显示]
    @SerializedName("viewstatus")
    private int state; // 状态[1已查看，0未查看]
    @SerializedName("ntype")
    private int type; // 类型[1救助帖子，2广场帖子]
    @SerializedName("mtype")
    private int articleType; // 1点赞2评论3回复
    // 评论属性
//    @SerializedName("feedbackdata")
//    private List<Comment> comments = new ArrayList<Comment>(); // 前三条评论
    @SerializedName("reply_user")
    private String replyUser; // 被回复人
    // 发帖人属性
    @SerializedName("id")
    private String userId;
    private String userOpenId;
    @SerializedName("avatar")
    private String userAvatar;
    @SerializedName("nick_name")
    private String userNickname;

    // 本地属性
    private int itemType = IMAGE_0; // 类型
    private Float distance; // 存储帖子距离中心点的长度

    public Moment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(int showLocation) {
        this.showLocation = showLocation;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

}