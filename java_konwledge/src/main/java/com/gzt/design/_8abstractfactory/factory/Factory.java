package com.gzt.design._8abstractfactory.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("没有找到类：" + classname);
        } catch (InstantiationException e) {
            System.err.println("不能实例化");
        } catch (IllegalAccessException e) {
            System.err.println("非法访问");
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
