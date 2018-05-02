package com.example.p7xxtm1_g.jdsimulate.utils;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by P7XXTM1-G on 2018/4/24.
 */

public class MApplication extends Application {
    File cacheFile= new File(Environment.getExternalStorageDirectory()+"/"+"imgages");
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                /*.memoryCacheExtraOptions(480, 800) // default = device screen dimensions 内存缓存文件的最大长宽
                .diskCacheExtraOptions(480, 800, null)  // 本地缓存的详细信息(缓存的最大长宽)，最好不要设置这个
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024)) //可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)  // 内存缓存的最大值
                .memoryCacheSizePercentage(13) // default
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
                .diskCacheFileCount(100)  // 可以缓存的文件数量
                .diskCache(new UnlimitedDiskCache(cacheFile))//自定义缓存目录
                // default为使用HASHCODE对UIL进行加密命名， 还可以用MD5(new Md5FileNameGenerator())加密
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .defaultDisplayImageOptions(ImageLoaderUtils_circle.getDisplayImageOption()) // default
                .writeDebugLogs() // 打印debug log*/
                .build();

        ImageLoader.getInstance().init(build);

    }
}
