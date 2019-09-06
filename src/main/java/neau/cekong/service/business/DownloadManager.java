package neau.cekong.service.business;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@PropertySource("classpath:application.properties")
public class DownloadManager {

    private File cachePathFile;

    private Map<String, FileDealingStat> dealFilesMap = new LinkedHashMap<String, FileDealingStat>() {
        /**
         * 控制map大小(插入时执行)
         * @param eldest 最早元素
         * @return 是否移除最早元素
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, FileDealingStat> eldest) {
            return size() > mapMaxSize;
        }
    };

    @Value("${download.mapMaxSize}")
    private int mapMaxSize;

    @Autowired
    public DownloadManager(@Value("${download.cachePath}") String path) throws IOException {

        String pathStr = null;

        if (path.startsWith("tomcat")) {
            pathStr = System.getProperty("catalina.home") + "/" + path.substring(7);
        } else if (path.startsWith("classpath")) {
            cachePathFile = new ClassPathResource(path.substring(10)).getFile();// 未测试
        } else {
            pathStr = path;
        }

        if (pathStr != null) {
            cachePathFile = new File(pathStr);
        }

    }

    public File getCachePathFlie() {
        return cachePathFile;
    }

    public void setCachePathFile(File cachePath) {
        this.cachePathFile = cachePath;
    }

    public String getCachePath() throws IOException {
        return cachePathFile.getCanonicalPath();
    }

    public Entry writeThread(String exPath, Consumer<FileDealingStat> writer) {

        // 创建文件路径描述
        File target = mkFileWithUsername(exPath);

        // 建立状态信息
        Entry fileDealingStatEntry = buildFileDealingStatEntry(target);

        // 存在则不执行生成线程
        if (fileDealingStatEntry.getExist()) {
            System.out.println();
        } else {
            // 启动线程执行
            new Thread(() -> writer.accept(fileDealingStatEntry.fileDealingStat)).start();
        }

        // 返回键
        return fileDealingStatEntry;
    }

    public FileDealingStat checkFileDealingStat(String uuid) {
        return dealFilesMap.get(uuid);
    }

    public FileDealingStat getFileDealingStat(String uuid) {
        return checkFileDealingStat(uuid);
    }

    public File mkFileWithUsername(String exPath){
        File target = null;
        try {
            target = new File(
                    cachePathFile.getAbsolutePath() + "/"
                            + Base64.getEncoder()// 包含Base64用户名的路径
                            .encodeToString(SecurityUtils.getSubject().getPrincipal().toString().getBytes("UTF-8")
                            ) + "/" + exPath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return target;
    }

    public void putFileDealingStat(String uuid, FileDealingStat fileDealingStat) {
        dealFilesMap.put(uuid, fileDealingStat);
    }

    public Entry getFileDealingStatEntry(String uuid) {
        FileDealingStat fileDealingStat = dealFilesMap.get(uuid);
        if (fileDealingStat == null) return null;
        File target = fileDealingStat.getFile();
        if (target.exists()) {
            fileDealingStat.finish();
            fileDealingStat.setNow(-1);// 标记已存在
            fileDealingStat.setNum(-1);
        }
        return new Entry(uuid, fileDealingStat, target.exists());
    }

    public Entry buildFileDealingStatEntry(File target) {
        String uuid = UUID.randomUUID().toString();
        FileDealingStat fileDealingStat = new FileDealingStat(target);
        putFileDealingStat(uuid, fileDealingStat);
        Entry fileDealingStatEntry = getFileDealingStatEntry(uuid);
        return fileDealingStatEntry;
    }

    public class Entry {
        String uuid;
        FileDealingStat fileDealingStat;
        Boolean exist;

        public Entry(String uuid, FileDealingStat fileDealingStat, Boolean exist) {
            this.uuid = uuid;
            this.fileDealingStat = fileDealingStat;
            this.exist = exist;
        }

        public Boolean getExist() {
            return exist;
        }

        public void setExist(Boolean exist) {
            this.exist = exist;
        }

        public Entry(String uuid, FileDealingStat fileDealingStat) {
            this.uuid = uuid;
            this.fileDealingStat = fileDealingStat;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public FileDealingStat getFileDealingStat() {
            return fileDealingStat;
        }

        public void setFileDealingStat(FileDealingStat fileDealingStat) {
            this.fileDealingStat = fileDealingStat;
        }
    }

}
