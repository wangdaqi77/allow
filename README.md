# allow-url 从服务器获取可用的url的缓存框架

## DEMO
[以七牛云为例的demo](https://github.com/wangdaqi77/AllowUrlForQiNiu)

## 使用方式

### 依赖
#### Step 1. 在project的build的repositories{}中添加maven { url 'https://jitpack.io' }

allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
#### Step 2. 在module中添加compile 'com.github.wangdaqi77:allow-url:1.0.1'	
dependencies {
    ...
    compile 'com.github.wangdaqi77:allow-url:1.0.1'
}
#### Step 3. 初始化AllowUrl.create().io(IO); 建议在在自定义Application的oncreate()初始化;

#### Step 4. 具体使用例如加载图片
AllowUrl.load(AbsRuleHandler, ImageView, new OnAllowUrlSuccessListener<T>() {
    @Override
    public void success(ImageView target, String allowUrl) {
        // 加载图片 ...
        Log.i("TAG", "url : " + allowUrl);
    }
});

## 需要实现的接口与类

### IO
用于创建请求数据和磁盘缓存框架
##### IAllowUrNetFramework<P>
	请求数据
##### IAllowUrDiskFramework
	磁盘缓存

### AbsRuleHandler
凭证的规则
