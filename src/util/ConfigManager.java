package util;

//这个类的作用是读properties属性文件
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取数据库属性文件，获取数据库连接信息
//如何让用户只能创建一个ConfigManager？ 单例模式
public class ConfigManager {
    private Properties properties = new Properties();
//    private static ConfigManager configManager;   //懒汉模式
    private static ConfigManager configManager = new ConfigManager();   //饿汉模式
    /*
     *  单例模式：
     * 1、将构造方法私有化 外部无法调用该构造方法
     * 2、自身要完成对象的实例化（自身调用一个构造方法）
     * 3、将实例化对象，写在共有的方法中，为保证在不创建实例的情况下调用该方法，要把该方法设为静态方法
     * 4、单例模式的方式：懒汉模式，饿汉模式
     */

    public ConfigManager(){
        String configFile = "database.properties";
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //对外共有方法（懒汉方式）-->这样能保证线程安全
    public static synchronized ConfigManager getInstance(){
        //保证ConfigManager对象有且仅有一个
        if(configManager == null){
            configManager = new ConfigManager();
        }
        return configManager;
    }

    //饿汉模式
/*    public static ConfigManager getInstance(){
        return configManager;
    }*/


    //根据属性文件中的键获得对应的值
    public String getString(String key){
        return properties.getProperty(key);
    }

}
