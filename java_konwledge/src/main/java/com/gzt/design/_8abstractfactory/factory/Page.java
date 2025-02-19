package com.gzt.design._8abstractfactory.factory;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList content = new ArrayList();
    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void add(Item item) {
        content.add(item);
    }
    public abstract String makeHTML();
    public void output() {
        String filename = title + ".html";
        try {
            Writer writer = new PrintWriter(filename);
            writer.write(makeHTML());
            writer.close();
            System.out.println(filename + "编写完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
