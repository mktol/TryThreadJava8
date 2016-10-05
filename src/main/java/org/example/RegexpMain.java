package org.example;

import org.example.filework.FileWorker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fagim on 05.10.16.
 */
public class RegexpMain {

    static String forTest = "package com.balance.checker.service;\n" +
            "\n" +
            "import com.balance.checker.entity.CurrentPerson;\n" +
            "import com.balance.checker.entity.Person;\n" +
            "import org.springframework.beans.factory.annotation.Autowired;\n" +
            "import org.springframework.security.core.userdetails.UserDetails;\n" +
            "import org.springframework.security.core.userdetails.UserDetailsService;\n" +
            "import org.springframework.security.core.userdetails.UsernameNotFoundException;\n" +
            "import org.springframework.stereotype.Service;\n" +
            "\n" +
            "/**\n" +
            " * Created by fagim on 29.04.16.\n" +
            " */\n" +
            "@Service\n" +
            "public class PersonDetailsServiceImpl implements UserDetailsService {\n" +
            "\n" +
            "    private final PersonService personService;\n" +
            "\t@Autowired\n" +
            "\tprivate SomeClass someClass;\n" +
            "    @Autowired\n" +
            "    public PersonDetailsServiceImpl(PersonService personService1) {\n" +
            "        this.personService = personService1;\n" +
            "\n" +
            "    }\n" +
            "    @Override\n" +
            "    public CurrentPerson loadUserByUsername(String email) throws UsernameNotFoundException {\n" +
            "        Person person = personService.getPersonByEmail( email)\n" +
            "                .orElseThrow(()-> new UsernameNotFoundException(String.format(\"User with email=%s was not found\", email)));\n" +
            "new Hopkins (someClass)\n" +
            "tryout(voka(someClass))\n" +
            "        return new CurrentPerson(person);\n" +
            "\n" +
            "    }\n" +
            "\tpublic Object lodA(someClass){\n" +
            "}\n" +
            "\t\tpublic Object lodA( non, MobiusSubject someClass){\n" +
            "}\n" +
            "\tpublic Object lodA( non,MobiusSubject someClass, asan){\n" +
            "}\n" +
            "\n" +
            "}";
    public static void main(String[] args) {
        String location = "/home/fagim/Git/CheckMoney";
        Path file = Paths.get(location);
        System.out.println(Files.isDirectory(file));

        FileWorker fileWorker = new FileWorker();
        System.out.println(fileWorker.getVarName(forTest, "").orElse("Nima"));

        List<String> list = fileWorker.findMethods(forTest);
        list.forEach(System.out::println);

//        Pattern p = Pattern.compile("(@Autowired)");
//        Pattern p = Pattern.compile(".*(@Autowired\\s+(public|private)\\s+(SomeClass)).*");
//        Matcher m = p.matcher(forTest);
//        if(m.find()){
//            System.out.println(m.group());
//        }
//        System.out.println(m.find());
    }
}
