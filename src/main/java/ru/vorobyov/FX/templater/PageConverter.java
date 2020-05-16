package ru.vorobyov.FX.templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageConverter {

    private Configuration cfg;
    Map<String, Object> map;
    Template template;

    public File getConvertedFile() {
        try {
            instantiateConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create data model
        createDataModel();

        Writer file = null;
        String path = "src\\main\\resources\\html\\tableDate.html";
        try {
            file = new FileWriter(new File(path));
            template.process(map, file);
            file.flush();
            file.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    private void createDataModel(){
        //String - name of var in ftl, object - object in java that we need to put on var in ftl
        map = new HashMap<>();
        List<Integer> tableHeads = new ArrayList<>();
        for(int i = 0; i < 31; i++) tableHeads.add(i, i+1);
        map.put("table_heads", tableHeads);
        // map.put( name of var, object in java);
    }

    private void instantiateConfiguration() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File("src\\main\\resources\\templates"));
        cfg.setDefaultEncoding("windows-1251");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        template = cfg.getTemplate("tableDate.ftl");
    }
}
