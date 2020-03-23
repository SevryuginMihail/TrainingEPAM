package Sevryugin.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
@Slf4j
public class MyClassLoader extends ClassLoader {
    private String classPath;
    public MyClassLoader(String path) {
        this.classPath = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(classPath+"\\"+name+".class");
        if(!f.isFile())
            throw new ClassNotFoundException("Нет такого класса : "+ name);
        InputStream ins = null;
        Class c = null;
        try{
            ins = new BufferedInputStream(new FileInputStream(f));
            byte []b = new byte[(int)f.length()];
            ins.read(b);
            c = defineClass(name,b,0,b.length);
        } catch (FileNotFoundException e) {
            log.error("MyClassLoader : "+e.getMessage());
        } catch (IOException e) {
            log.error("MyClassLoader : "+e.getMessage());
        }finally {
            try {
                ins.close();
            } catch (IOException e) {
                log.error("MyClassLoader : "+e.getMessage());
            }
        }
        return c;
    }
}
