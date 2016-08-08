package com.kimmin.ms.storage;

/**
 * Created by t-mijin on 8/8/2016.
 */
public class StorageConfig {

    public final static String AZURE_STORAGE_KEY = "c+eBgBD8z+7MjlTjTlKCj/JLn+plGrRvxfRmAteSNK2CpMIuxkEKHUOZpReTjpriIGKPrAFo4HwHDVQp6esaHA==";

    public final static String AZURE_STORAGE_NAME = "fitstorage";

    public final static String AZURE_STORAGE_ENDPOINT = "https://fitstorage.blob.core.chinaclouapi.cn";

    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;" +
                    "AccountName=" + AZURE_STORAGE_NAME + ";" +
                    "AccountKey=" + AZURE_STORAGE_KEY + ";" +
                    "BlobEndpoint=" + AZURE_STORAGE_ENDPOINT;



}

