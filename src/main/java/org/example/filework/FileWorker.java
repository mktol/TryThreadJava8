package org.example.filework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fagim on 05.10.16.
 */
public class FileWorker { //TODO make it Callable or Runnable

    //".*(@Autowired\\s+(public|private)\\s+(SomeClass)).*"    regexp for autowired
    //".*(@Autowired\s+(public|private)\s+(SomeClass)\s+(\w+)).*"
    private String regexp;
    public Optional<String> findCoincidence(String context, String regexp){
        Pattern p = Pattern.compile(".*(@Autowired\\s+(public|private)\\s+(SomeClass)).*");
        Matcher m = p.matcher(context);
        if(m.find()){
            return Optional.of(m.group());
        }
        return Optional.empty();
    }

    public Optional<String> getVarName(String context, String regexp){
//        Pattern p = Pattern.compile(".*(@Autowired\\s+(public|private)\\s+(SomeClass)).*");
        Pattern p = Pattern.compile(".*(@Autowired\\s+(public|private)\\s+(SomeClass)\\s+(\\w+)).*");
        Matcher m = p.matcher(context);
        if(m.find()){
            return Optional.of(m.group(4));
        }
        return Optional.empty();
    }

    public List<String> findMethods(String context){
        String varName = getVarName(context, "").orElse("Name");
        String regexp = ".*\\w+\\s*\\(.*"+varName+".*\\).*";
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(context);
        List<String> resultList = new ArrayList<>();
        while (m.find()){
            resultList.add(m.group());
        }
        return resultList;
    }


}
