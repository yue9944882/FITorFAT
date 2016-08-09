package com.kimmin.ms.storage;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by kimmin on 7/19/16.
 */
public class StorageManager {

    private StorageManager(){
        try {
            this.account = CloudStorageAccount.parse(StorageConfig.storageConnectionString);
            this.client = this.account.createCloudBlobClient();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
    private static class Singleton {
        private static StorageManager instance = new StorageManager();
    }
    public static StorageManager getInstance(){
        return Singleton.instance;
    }

    private CloudStorageAccount account = null;
    private CloudBlobClient client = null;

    public void saveImageToCloud(InputStream stream, long length, String id){
        try {
            CloudBlobContainer container = client.getContainerReference("dish");
            container.createIfNotExists();
            CloudBlockBlob blob = container.getBlockBlobReference(id);
            blob.getProperties().setContentType("image/jpg");
            blob.upload(stream, length);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }



}
