# allow-url 获取凭证框架

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
#### Step 3. 初始化Allow.create().io(IO); 建议在在自定义Application的oncreate()初始化;
    @Override
    public void onCreate() {
        super.onCreate();
        Allow.create().io(IO);
    }
#### Step 4. 具体使用例如加载图片
	Allow.load(AbsRuleHandler, ImageView, new OnAllowValueCallBack<ImageView, String>() {
	    @Override
	    public void success(ImageView target, String allowValue) {
		// 加载图片 ...
		Log.i("TAG", "url : " + allowValue);
	    }
	});

## 需要实现的接口与类

### IO
用于创建请求数据和磁盘缓存框架
##### INet<P>
	请求数据
##### IDisk
	磁盘缓存

### AbsRuleHandler
凭证的规则
